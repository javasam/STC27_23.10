package com.example.rest_service;

import com.example.rest_service.security.MyAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@SpringBootApplication
public class RestServiceApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthProvider myAuthProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authenticationProvider(myAuthProvider)
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/byeuser.html")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/rest/auth/**")
                .authenticated();
    }

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
