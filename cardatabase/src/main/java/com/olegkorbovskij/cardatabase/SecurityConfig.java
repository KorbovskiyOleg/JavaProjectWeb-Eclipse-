package com.olegkorbovskij.cardatabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
	
   protected void configure(HttpSecurity http) throws  Exception {
	   
   }
   
   @Bean
   public UserDetailsService userDetailsService(PasswordEncoder encoder) {
       UserDetails user = User.builder()
           .username("user")
           .password(encoder.encode("password")) // Шифрование пароля
           .roles("USER")
           .build();
       return new InMemoryUserDetailsManager(user);
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder(); // BCrypt-шифрование
   }
}
