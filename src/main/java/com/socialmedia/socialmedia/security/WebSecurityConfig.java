package com.socialmedia.socialmedia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService appUserDetailService;

  @Autowired
  private DataSource dataSource;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(appUserDetailService)
        .passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .headers()
        .frameOptions().sameOrigin()
        .and()
        .authorizeRequests()
        .antMatchers("/resources/**", "/webjars/**", "/assets/**", "/css/**").permitAll()
        .antMatchers("/Posts/", "/User/Registration/").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/Login/")
        .defaultSuccessUrl("/Home/")
        .failureUrl("/Login/?error")
        .permitAll()
        .and()
//        .logout()
//        .logoutUrl("/Logout/")
//        .logoutRequestMatcher(new AntPathRequestMatcher("/Logout/"))

//        .logoutSuccessUrl("/Login/")
//        .deleteCookies("my-remember-me-cookie")
//        .permitAll()
//        .and()-
//        .rememberMe()
        //.key("my-secure-key")
//        .rememberMeCookieName("my-remember-me-cookie")
//        .tokenRepository(persistentTokenRepository())
//        .tokenValiditySeconds(24 * 60 * 60)
//        .and()
        .exceptionHandling();
  }

  PersistentTokenRepository persistentTokenRepository() {
    JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
    tokenRepositoryImpl.setDataSource(dataSource);
    return tokenRepositoryImpl;
  }
}
