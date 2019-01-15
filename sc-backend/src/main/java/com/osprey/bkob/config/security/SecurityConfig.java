package com.osprey.bkob.config.security;

import com.osprey.bkob.config.token.JWTConfigurer;
import com.osprey.bkob.config.token.TokenProvider;
//import org.springframework.beans.factory.annotation.Autowired;
import com.osprey.bkob.config.token.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
//import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService detailsService;
    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;
    private final TokenProvider tokenProvider;

    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService detailsService,
                          PasswordEncoder passwordEncoder,
                          @Qualifier("dataSource") DataSource dataSource,
                          TokenProvider tokenProvider) {
        this.detailsService = detailsService;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
        this.tokenProvider = tokenProvider;
    }

    /**
     * Конфигурация безопасности для URL(Rest);
     */
    @Configuration
    public static class FormLoginConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/form/**").authorizeRequests().anyRequest().authenticated()
                    .and().formLogin().permitAll().loginPage("/public/login").loginProcessingUrl("/form/login")
                    .and().logout().logoutUrl("/form/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
        }
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

    @Configuration
    @Order(1)
    public class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .userDetailsService(detailsService)
                    .antMatcher("/api/**")
                    .csrf()
                    .disable()
                    .headers()
                    .frameOptions()
                    .disable()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/public/** /api/** /public/login/** /admin/user/delete/**" ).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .apply(this.securityConfigurerAdapter());

        }

        private JWTConfigurer securityConfigurerAdapter() {
            return new JWTConfigurer(SecurityConfig.this.tokenProvider);
        }

//        @Bean
//        public RequestContextListener requestContextListener() {
//            return new RequestContextListener();
//        }

        @Bean(name = "apiAuthManager")
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }


//    @Configuration
//    @EnableOAuth2Sso
//    public class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            // @formatter:off
//            http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**", "/error**").permitAll().anyRequest()
//                    .authenticated().
//                    and().
//                    exceptionHandling()
//                    .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")).and().logout()
//                    .logoutSuccessUrl("/").permitAll()
//                    .and().
//                    csrf()
//                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                    .and()
//                    .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
//            // @formatter:on
//        }
//
//
//        @Bean
//        public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
//            FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<OAuth2ClientContextFilter>();
//            registration.setFilter(filter);
//            registration.setOrder(-100);
//            return registration;
//        }
//
//        @Bean
//        @ConfigurationProperties("github")
//        public ClientResources github() {
//            return new ClientResources();
//        }
//
//        private Filter ssoFilter() {
//            CompositeFilter filter = new CompositeFilter();
//            List<Filter> filters = new ArrayList<>();
//            filters.add(ssoFilter(github(), "/login/github"));
//            filter.setFilters(filters);
//            return filter;
//        }
//
//        private Filter ssoFilter(ClientResources client, String path) {
//            OAuth2ClientAuthenticationProcessingFilter oAuth2ClientAuthenticationFilter = new OAuth2ClientAuthenticationProcessingFilter(path);
//            OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
//            oAuth2ClientAuthenticationFilter.setRestTemplate(oAuth2RestTemplate);
//            UserInfoTokenServices tokenServices = new UserInfoTokenServices(client.getResource().getUserInfoUri(),
//                    client.getClient().getClientId());
//            tokenServices.setRestTemplate(oAuth2RestTemplate);
//            oAuth2ClientAuthenticationFilter.setTokenServices(tokenServices);
//            return oAuth2ClientAuthenticationFilter;
//
//        }

//    }
}

