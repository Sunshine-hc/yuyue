package com.newer.yuyue.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试授权控制器
 *
 *
 */
@RestController
public class MethodProtectedRestController {

  /**
   * This is an example of some different kinds of granular restriction for endpoints. You can use the built-in SPEL expressions
   * in @PreAuthorize such as 'hasRole()' to determine if a user has access. Remember that the hasRole expression assumes a
   * 'ROLE_' prefix on all role names. So 'ADMIN' here is actually stored as 'ROLE_ADMIN' in database!
   **/
  @RequestMapping(value = "/protectedadmin", method = RequestMethod.GET)
  @PreAuthorize("hasRole('ADMIN')")//该方法只允许有ADMIN角色的用户访问
  public ResponseEntity<?> getProtectedAdmin() {
    return ResponseEntity.ok("Greetings from admin protected method!");
  }

  @RequestMapping(value = "/protecteduser", method = RequestMethod.GET)
  @PreAuthorize("hasRole('USER')")//该方法只允许有USER角色的用户访问
  public ResponseEntity<?> getProtectedUser() {
    return ResponseEntity.ok("Greetings from user protected method!");
  }


}