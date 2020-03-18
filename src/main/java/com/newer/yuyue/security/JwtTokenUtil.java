package com.newer.yuyue.security;

import com.newer.yuyue.security.domain.JwtUser;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 *JWT工具类
 */
@Component
public class JwtTokenUtil implements Serializable {

  private static final long serialVersionUID = -3301605591108950415L;

  static final String CLAIM_KEY_USERNAME = "sub";
  static final String CLAIM_KEY_AUDIENCE = "aud";
  static final String CLAIM_KEY_CREATED = "iat";

  static final String AUDIENCE_UNKNOWN = "unknown";
  static final String AUDIENCE_WEB = "web";
  static final String AUDIENCE_MOBILE = "mobile";
  static final String AUDIENCE_TABLET = "tablet";

  @SuppressFBWarnings(value = "SE_BAD_FIELD", justification = "It's okay here")
  private Clock clock = DefaultClock.INSTANCE;

  //将配置文件属性jwt.secret的值注入到当前类的属性
  @Value("${jwt.secret}")
  private String secret;
  //失效时间
  @Value("${jwt.expiration}")
  private Long expiration;

  /**
   * 从token中获取用户名
   * @param token
   * @return
   */
  public String getUsernameFromToken(String token) {

    return getClaimFromToken(token, Claims::getSubject);
  }

  /**
   * 从token中获取token创建时间
   * @param token
   * @return
   */
  public Date getIssuedAtDateFromToken(String token) {

    return getClaimFromToken(token, Claims::getIssuedAt);
  }

  /**
   * 获取token的失效时间
   * @param token
   * @return
   */
  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  /**
   *
   * @param token
   * @return
   */
  public String getAudienceFromToken(String token) {
    return getClaimFromToken(token, Claims::getAudience);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  /**
   * 按密钥解析token，获得各
   * @param token
   * @return
   */
  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody();
  }

  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(clock.now());
  }

  /**
   * 判断token是否是密码修改前签发的
   * @param created
   * @param lastPasswordReset
   * @return
   */
  private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
    return (lastPasswordReset != null && created.before(lastPasswordReset));
  }

  private String generateAudience(Device device) {
    String audience = AUDIENCE_UNKNOWN;
    if (device.isNormal()) {
      audience = AUDIENCE_WEB;
    } else if (device.isTablet()) {
      audience = AUDIENCE_TABLET;
    } else if (device.isMobile()) {
      audience = AUDIENCE_MOBILE;
    }
    return audience;
  }

  private Boolean ignoreTokenExpiration(String token) {
    String audience = getAudienceFromToken(token);
    return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
  }

  /**
   * 获取token的方法
   * @param userDetails
   * @return
   */
  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    return doGenerateToken(claims, userDetails.getUsername());
  }

  private String doGenerateToken(Map<String, Object> claims, String subject) {
    final Date createdDate = clock.now();
    final Date expirationDate = calculateExpirationDate(createdDate);

    System.out.println("doGenerateToken " + createdDate);

    return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(createdDate)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
  }

  public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
    final Date created = getIssuedAtDateFromToken(token);
    return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
            && (!isTokenExpired(token) || ignoreTokenExpiration(token));
  }

  public String refreshToken(String token) {
    final Date createdDate = clock.now();
    final Date expirationDate = calculateExpirationDate(createdDate);

    final Claims claims = getAllClaimsFromToken(token);
    claims.setIssuedAt(createdDate);
    claims.setExpiration(expirationDate);

    return Jwts.builder()
            .setClaims(claims)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
  }

  /**
   * 校验用户的token
   * @param token
   * @param userDetails
   * @return
   */
  public Boolean validateToken(String token, UserDetails userDetails) {
    JwtUser user = (JwtUser) userDetails;
    final String username = getUsernameFromToken(token);
    final Date created = getIssuedAtDateFromToken(token);
    final Date expiration = getExpirationDateFromToken(token);
    return (
            username.equals(user.getUsername())
                    && !isTokenExpired(token)
                    && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate())
    );
  }

  private Date calculateExpirationDate(Date createdDate) {
    return new Date(createdDate.getTime() + expiration * 1000);
  }
}
