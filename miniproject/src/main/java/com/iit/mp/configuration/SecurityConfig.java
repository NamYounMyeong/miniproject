package com.iit.mp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
		//로그아웃
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
	
}
