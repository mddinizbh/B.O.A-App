package com.example.binaryOptionAnalytcs.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.binaryOptionAnalytcs.security.JWTAuthenticatorFilter;
import com.example.binaryOptionAnalytcs.security.JWTAuthorizationFilter;
import com.example.binaryOptionAnalytcs.security.JWTUtil;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private Environment env;
	
	@Autowired
	private JWTUtil jwtutil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	private static final String [] PUBLIC_MATCHERS = {
			
			"/h2-console/**",
			"/clientes/**",
			"/bancas/**",
			"/catalogacoes/**",
			"/daytrades/**",
			"/trades/**",
			"/aportes/**",
			"/pares/**",
			"/estrategiascatalog/**",
			"/retiradas/**",
		
	};	
//			private static final String [] PUBLIC_MATCHERS_GET = {
//			
//					
//	};
		private static final String [] PUBLIC_MATCHERS_POST = {
			
			"/clientes/**",
			"/auth/forgotPassword/**",
			
	};
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
//		.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
		.antMatchers(HttpMethod.POST,PUBLIC_MATCHERS_POST).permitAll()
		.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticatorFilter(authenticationManager(), jwtutil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtutil, userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	CorsConfigurationSource configurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		
		return source;
		
	}
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
}
