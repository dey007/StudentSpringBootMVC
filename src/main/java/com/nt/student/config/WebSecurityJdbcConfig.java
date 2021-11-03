
package com.nt.student.config;

import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity

@Configuration
public class WebSecurityJdbcConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	/*
	 * @Autowired private DataSource ds;
	 */
	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new
	 * BCryptPasswordEncoder())
	 * .usersByUsernameQuery("select uname, pwd, status from user where uname=?")
	 * .authoritiesByUsernameQuery("select role, uname from user_role where uname=?"
	 * ); }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/student/login", "/student/register").permitAll()
				.antMatchers("/report").authenticated().antMatchers("/add_student")
				.hasAnyAuthority("teacher", "admin").antMatchers("/edit_student**").hasAnyAuthority("admin","teacher")
				.antMatchers("/delete_student**").hasAuthority("admin").anyRequest().authenticated().and()
				.exceptionHandling().accessDeniedPage("/denied").and()
				.formLogin().defaultSuccessUrl("/report",true).loginPage("/student/login")
				.loginProcessingUrl("/login").failureUrl("/student/login?error")
				.and().logout().logoutSuccessUrl("/student/login?logout");
	}
}
