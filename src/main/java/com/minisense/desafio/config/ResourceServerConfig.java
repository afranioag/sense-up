package com.minisense.desafio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Autowired
	private Environment env;

	@Autowired
	private JwtTokenStore tokenStore;
	private static final String[] PUBLIC = { "/auth/token", "/h2-console/**" };
	private static final String[] LOGGED_GET = { "/api/v1/sensors/**", "/api/v1/measurements/**"};
	private static final String[] OPERATOR_OR_ADMIN = { "/api/v1/sensors/users/**", "/api/v1/measurements/**" };
	private static final String[] ADMIN = { "/admin/v1/users/**"};

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		// Liberando o H2
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}

		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, LOGGED_GET).permitAll()
		.antMatchers(OPERATOR_OR_ADMIN).hasAnyRole("ADMIN", "OPERATOR")
		.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
	}
}
