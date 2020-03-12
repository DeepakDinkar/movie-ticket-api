package com.bookMyMovie.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
@EnableWebSecurity
@Order(1)
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${security.keyHeaderName}")
	private String principalRequestHeader;

	@Value("${security.key}")
	private String principalRequestValue;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
		filter.setAuthenticationManager(new AuthenticationManager() {

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String principal = (String) authentication.getPrincipal();
				if (!principalRequestValue.equals(principal)) {
					throw new BadCredentialsException("API key not found");
				}
				authentication.setAuthenticated(true);
				return authentication;
			}
		});
		String[] matcher = { "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
				"/configuration/security", "/swagger-ui.html", "/webjars/**" };
		httpSecurity.authorizeRequests().antMatchers(matcher).permitAll();
		
		
		httpSecurity.antMatcher("/**").csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().addFilter(filter).authorizeRequests()
				.anyRequest().authenticated();

	}
}
