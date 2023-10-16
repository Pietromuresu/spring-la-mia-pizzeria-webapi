package org.java.auth.config;

import org.java.auth.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http)
		throws Exception {
			 
			http.authorizeHttpRequests()
	        // ADMIN AUTHORIZATION
			// PIZZAS
			.requestMatchers("/create").hasAuthority("ADMIN")
	        .requestMatchers("/update/**").hasAuthority("ADMIN")
	        .requestMatchers("/delete/**").hasAuthority("ADMIN")
	        // OFFERS
	        .requestMatchers("/offers/create/**").hasAuthority("ADMIN")
	        .requestMatchers("/offers/update/**").hasAuthority("ADMIN")
	        .requestMatchers("/offers/delete/**").hasAuthority("ADMIN")
	        // INGREDIENTS
	        .requestMatchers("/ingredients").hasAuthority("ADMIN")
	        .requestMatchers("/ingredients/add").hasAuthority("ADMIN")
	        .requestMatchers("/ingredients/update/**").hasAuthority("ADMIN")
	        .requestMatchers("/ingredients/delete/**").hasAuthority("ADMIN")
	        .requestMatchers("/test/\\d").hasAnyAuthority("ADMIN")
	        // USER AUTHORIZATION
	        .requestMatchers("/**").hasAuthority("USER")
	        .and().formLogin().defaultSuccessUrl("/")
	        .and().logout();
			 
			return http.build();
	}
	
	@Bean
	UserService userDetailsService() {
		return new UserService();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
   
      authProvider.setUserDetailsService(userDetailsService());
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
    }
	
	
}
