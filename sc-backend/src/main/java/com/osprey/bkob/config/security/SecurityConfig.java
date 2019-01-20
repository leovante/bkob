package com.osprey.bkob.config.security;

import com.osprey.bkob.config.token.TokenJwtFilter;
import com.osprey.bkob.config.token.TokenProvider;

import org.springframework.beans.factory.annotation.Qualifier;

import com.osprey.bkob.config.token.UserDetailsServiceImpl;
import com.osprey.bkob.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
//import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.web.filter.CompositeFilter;


import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security configuration
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService detailsService;

    private TokenProvider tokenProvider;

    @Autowired
    public void setDetailsService(UserDetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @Autowired
    public void setTokenProvider(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }


//    @Order(67) // LOWEST
//    @Configuration
//    public static class NoAuthConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.antMatcher("/public/**").authorizeRequests().anyRequest().permitAll();
//        }
//    }
//
//    @Order(45) // LOW
//    @Configuration
//    public static class BasicAuthConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.antMatcher("/basic/**").authorizeRequests().anyRequest().authenticated()
//                    .and().httpBasic().and().apply(this.securityConfigurerAdapter());
//        }
//    }
   // ApiWebSecurityConfigurationAdapter

   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .userDetailsService(detailsService)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(new TokenJwtFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().antMatchers("/public/login", "/public/signup", "/public/activate/**").permitAll()
                .antMatchers("/public/**").authenticated()
                .anyRequest().authenticated();

    }

    @Bean(name = "apiAuthManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Primary
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }

}

