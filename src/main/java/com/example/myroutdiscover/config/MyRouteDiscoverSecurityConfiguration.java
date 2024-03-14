//package com.example.myroutdiscover.config;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@Configuration
//public class MyRouteDiscoverSecurityConfiguration {
//@Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.authorizeHttpRequests(
////                authorizeRequests -> authorizeRequests.
////                requestMatchers(PathRequest.toStaticResources().atCommonLocations())
////                .permitAll()
////                        .requestMatchers("/","/users/login","/users/register").permitAll()
////                        .anyRequest().authenticated()
////
////                ).formLogin(
////                        formLogin -> {
////                            formLogin.loginPage("/users/login")
////                                    .usernameParameter("username")
////                                    .passwordParameter("password")
////                                    .defaultSuccessUrl("/")
////                                    .failureForwardUrl("/users/login-error");
////                        }
////        ).logout(
////                logout -> {
////                    logout.logoutUrl("/users/logout")
////                            .logoutSuccessUrl("/")
////                            .invalidateHttpSession(true);
////                }
////
////        );
////        return http.build();
////    }


//}
