/*
 * package com.nt.student.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.core.session.SessionRegistry; import
 * org.springframework.security.core.session.SessionRegistryImpl;
 * 
 * @EnableWebSecurity
 * 
 * @Configuration public class WebSecurityInMemConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override public void configure(AuthenticationManagerBuilder auth) throws
 * Exception { //
 * auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles(
 * "ADMIN");
 * auth.inMemoryAuthentication().withUser("rahul").password("{noop}rahul123").
 * roles("CUSTOMER").and()
 * .withUser("admin").password("{noop}admin123").roles("ADMIN"); }
 * 
 * @Override public void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable().authorizeRequests().antMatchers("/",
 * "/report").authenticated()
 * .antMatchers("/add_student").hasAnyRole("CUSTOMER",
 * "ADMIN").antMatchers("/edit_student**")
 * .hasRole("CUSTOMER").antMatchers("/delete_student**").hasRole("ADMIN").
 * anyRequest().authenticated()
 * .and().formLogin().and().logout().and().rememberMe().and().exceptionHandling(
 * ) .accessDeniedPage("/denied").and().sessionManagement().maximumSessions(1).
 * maxSessionsPreventsLogin(true) .expiredUrl("/login"); } }
 */