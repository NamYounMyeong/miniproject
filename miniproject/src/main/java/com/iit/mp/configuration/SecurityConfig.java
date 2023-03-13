/*package com.iit.mp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//다음 경로에 대한 요청은 인증 없이 접근을 허용하도록 설정
		http.authorizeRequests().antMatchers("/", "/member/join", "/login").permitAll();
		// 위의 경로 외에는 모두 인증을 하도록 설정
		http.authorizeRequests().anyRequest().authenticated();
		//사용자 정의 로그인 화면에서 CSRF 토큰을 전달하지 않는 설정
		http.csrf().disable();
		//로그인 화면 설정
		http.formLogin().loginPage("/login");
		//로그인 성공시 이동할 페이지 설정
		http.formLogin().defaultSuccessUrl("/");
		//로그아웃
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//js폴더, css폴더, img폴더도 예외처리
		web.ignoring().antMatchers("/static/js/**","/static/css/**","static/img/**");
		
	}
	
}
*/