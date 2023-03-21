//package com.iit.mp.configuration;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.iit.mp.security.CustomUserDetailsService;
//
//@Configuration
//@EnableWebSecurity //Spring Security Filter Chain이 자동 포함된다.
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
//	
//	/* 스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		/* AuthenticationProvider 구현체 */
//		auth.userDetailsService(customUserDetailsService);
//	}
//	
//	/* 스프링 시큐리티 규칙 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//다음 경로에 대한 요청은 인증 없이 접근을 허용하도록 설정
//		http.authorizeRequests().antMatchers("/", "/member/join", "/login").permitAll();
//		// 위의 경로 외에는 모두 인증을 하도록 설정
//		http.authorizeRequests().anyRequest().authenticated().antMatchers("/board/**").access("mbrRgd('')");
//		//사용자 정의 로그인 화면에서 CSRF 토큰을 전달하지 않는 설정
//		http.csrf().disable();
//		//로그인 화면 설정
//		http.formLogin().loginPage("/login").usernameParameter("mbrId").passwordParameter("mbrPw");
//		//로그인 성공시 이동할 페이지 설정
//		http.formLogin().defaultSuccessUrl("/");
//		//로그아웃
//		http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
////		http.csrf().disable();
////		http.authorizeRequests() //보호된 리소스 URI에 접근할 수 있는 권한을 설정
////			.antMatchers("/login", "/logout", "/").permitAll() //해당 페이지들은 전체 접근 허용
////			//.antMatchers("/board/**").hasRole("USER") //게시판 관련 페이지는 USER라는 롤을 가진 사용자만 접근 허용
////			.antMatchers("/board/**").access("hasRole('ROLE_USER')") //게시판 관련 페이지는 USER라는 롤을 가진 사용자만 접근 허용
////			.anyRequest().authenticated()
////		.and()
////			.formLogin()
////			.loginPage("/login")
////			.usernameParameter("mbrId")
////			.passwordParameter("mbrPw")
////			.defaultSuccessUrl("/")
////			.permitAll()
////		.and()
////			.logout()
////			.logoutUrl("/logout")
////			.logoutSuccessUrl("/");
//	}
//	
//	@Bean
//	public PasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//
//	/* 스프링 시큐리티 룰을 무시하게 한느 url 규칙(여기에 등록하면 규칙을 적용하지 않는다.) */
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		//js폴더, css폴더, img폴더도 예외처리
//		web.ignoring().antMatchers("/js/**","/css/**","/img/**");
//		
//	}
//	
//}