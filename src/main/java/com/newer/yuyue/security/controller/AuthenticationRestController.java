package com.newer.yuyue.security.controller;

import com.newer.yuyue.security.AuthenticationException;
import com.newer.yuyue.security.JwtAuthenticationRequest;
import com.newer.yuyue.security.JwtAuthenticationResponse;
import com.newer.yuyue.security.JwtTokenUtil;
import com.newer.yuyue.security.domain.JwtUser;
import com.newer.yuyue.server.UserInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 授权控制器：处理登录和获取token
 *
 *
 */
@RestController
public class AuthenticationRestController {

  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  @Qualifier("jwtUserService")
  private UserDetailsService userDetailsService;

  @Autowired
  private UserInfoServer userInfoServer;

  /**
   * 创建授权令牌 (登录)
   *
   * @param authenticationRequest
   * @return
   * @throws AuthenticationException
   */
  @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
    //处理登录的请求
    //校验用户名和密码

    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

    // Reload password post-security so we can generate the token
    //按用户名查询安全框架管理的用户对象
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    //为该用户对象生产token
    final String token = jwtTokenUtil.generateToken(userDetails);
    //修改登录时间
//    adminsService.updateLoginTime(((JwtUser)userDetails).getId());

    // 响应给token客户端
    return ResponseEntity.ok(new JwtAuthenticationResponse(token));
  }

  /**
   * 刷新
   *
   * @param request
   * @return
   */
  @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
  public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
    String authToken = request.getHeader(tokenHeader);
    final String token = authToken.substring(7);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

    if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
      String refreshedToken = jwtTokenUtil.refreshToken(token);
      return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
    } else {
      return ResponseEntity.badRequest().body(null);
    }
  }

  @ExceptionHandler({AuthenticationException.class})
  public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
  }

  /**
   * Authenticates the user. If something is wrong, an {@link AuthenticationException} will be thrown
   */
  private void authenticate(String username, String password) {
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);

    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new AuthenticationException("User is disabled!", e);
    } catch (BadCredentialsException e) {
      throw new AuthenticationException("Bad credentials!", e);
    }
  }

}
