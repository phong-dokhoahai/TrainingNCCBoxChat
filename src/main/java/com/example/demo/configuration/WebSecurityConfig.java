package com.example.demo.configuration;

import com.example.demo.Security.AuthTokenFilter;
import com.example.demo.Security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@ConfigurationProperties() //: prefix"",value"", ignoreInvalidFields=false,ignoreKnownFields=true
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
   // @Qualifier("NoOpPasswordEncoder")
    PasswordEncoder passwordEncoder;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder( passwordEncoder);
    }
    //    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return new AuthenticationManager() {
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                return null;
//            }
//        };
//    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/login/**").permitAll()
                .requestMatchers("/register","/account/register").permitAll()
                .requestMatchers("/forgot-password").permitAll()
                .requestMatchers("/auth/login").permitAll()

                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/chatbox/**").permitAll()
                .requestMatchers("/chatbox*").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new AuthTokenFilter(jwtUtils, userDetailsService), UsernamePasswordAuthenticationFilter.class);

//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/home");
              //  .successHandler(new CustomAuthenticationSuccessHandler());// demo @Qualifier
        return http.build();
    }
}