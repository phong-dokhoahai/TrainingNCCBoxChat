package com.example.demo.Controller.RestController;

import com.example.demo.Dto.EntityDto.LoginRequest;
import com.example.demo.Security.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    private JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        log.info("123");
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }
//    private UserDetailServiceImpl userDetailServiceIml ;
//    public void setUserDetailsService(UserDetailsService userDetailsService) {
//        log.info("userDetailsService");
//        this.userDetailsService = userDetailsService;
//    }
//    @PostConstruct
//    public void postConstruct(){
//        System.out.println(">> Đối tượng sau khi khởi tạo xong sẽ chạy hàm này");
//       setUserDetailsService(userDetailServiceIml);
//    }
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
        authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        final String accessToken = jwtUtils.generateTokenFromUsername(loginRequest.getUsername()).get("accessToken");
        final String refreshToken = jwtUtils.generateTokenFromUsername(loginRequest.getUsername()).get("refreshToken");

        return ResponseEntity.ok(accessToken);
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    @PostMapping("/refreshToken")
    public String createAccessTokenFromRefreshToken(@RequestBody String refreshToken){
        return jwtUtils.createAccessTokenFromRefreshToken(refreshToken);
    }
}
