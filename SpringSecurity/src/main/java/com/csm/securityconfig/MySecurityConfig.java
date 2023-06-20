package com.csm.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.csm.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity 
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter
{
	//Basic Authenctication
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
		/*1*/	// .csrf().disable()  //If you are non-browser client than you have to disbale csrf
//		OR
		/*2*/.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // with the help of csrfCookieToken.token genrate and add in cookies
		/*2*/	.and() 
			
		/*3*/.authorizeRequests()
			//  .antMatchers("/home","/login").permitAll()
			.antMatchers("/signin").permitAll()
			/* If You Dont Want TO Add AntMatchers Then You can add
			 * Annotation  @PreAuthorization*/
			
//			.antMatchers(HttpMethod.GET,"/public/**").hasAnyRole("NORMAL","ADMIN")
//			.antMatchers("/users/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
//			.httpBasic();
			.formLogin() //If you dont want to use default Login Page then you use another Login Page Than you have to add
			.loginPage("/signin")     //.loginPage("/signin"); 
			.loginProcessingUrl("/dologin")
			.defaultSuccessUrl("/users/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
//		auth.inMemoryAuthentication().withUser("normal").password(this.passEncode().encode("normal")).roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("admin").password(this.passEncode().encode("admin")).roles("ADMIN");
		
		auth.userDetailsService(customUserDetailService).passwordEncoder(passEncode());
		
	}
	
	@Bean
	public BCryptPasswordEncoder passEncode()
	{
		return new BCryptPasswordEncoder(10);
	}
}
