//package com.iit.mp.configuration;
//
//
//import java.util.Arrays;
//import java.util.HashMap;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
///*시큐리티 설정중 우선 제외*/
////import com.iit.mp.security.CustomAuthenticationFailureHandler;
////import com.iit.mp.security.CustomAuthenticationSuccessHandler;
//import com.iit.mp.security.CustomUserDetailsService;
///*시큐리티 설정중 우선 제외*/
////import com.iit.mp.util.UserConectHistorySearchService;
//
//
//@EnableWebSecurity //Spring Security Filter Chain이 자동 포함된다.
//public class WebSecurityConfig {
//
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
//	/*시큐리티 설정중 우선 제외*/
////	@Autowired
////	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//	/*시큐리티 설정중 우선 제외*/
////	@Autowired
////	private UserConectHistorySearchService userConectHistorySearchService;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Configuration
//	public class WebSecurityConfigBased  extends  WebSecurityConfigurerAdapter{
//	/*<authentication-manager>
//		<authentication-provider user-service-ref="customUserDetailsService">
//			<password-encoder ref="bcryptPasswordEncoder"/>
//		</authentication-provider>
//	</authentication-manager>*/
//	
//	/* 스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		/* AuthenticationProvider 구현체 */
//		auth
//			.userDetailsService(customUserDetailsService)
//			.passwordEncoder(passwordEncoder);
//	}
//	
//	/* 스프링 시큐리티 규칙 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		<http auto-config="true" use-expressions="true">
////	    	<csrf disabled="true"/>
////	    	/board 라는 경로를 가진 페이지들은 ROLE-USER라는 권한이 있어야 접근이 가능하다
////	        <intercept-url pattern="/board/**" access="isAuthenticated()"/>
////	        <http-basic/>  basic authentication 설정 (기본 인증)
////	        default-target-url = 로그인 성공 후 이동할 페이지 설정
////	        <form-login login-page="/login" login-processing-url="/login" default-target-url="/board/board" username-parameter="mbrId" password-parameter="mbrPw"/>
////	        <logout logout-url="/logout" logout-success-url="/" delete-cookies="JSESSIONID"/>
////	                자동 로그인 설정 (7일 = 604800초)
////			<remember-me data-source-ref="dataSource" remember-me-parameter="remember-me" token-validity-seconds="604800"/>
////		</http>
//		/* cors: Cross-Origin Resource Sharing ??? 접근 허용 */
//		http
//		.cors().configurationSource(corsConfigurationSource())
//		.and()
//		.csrf().disable()
//		.formLogin() //직접 만든 로그인폼 사용
//		.usernameParameter("mbrId")
//		.passwordParameter("mbrPw")
//		.loginPage("/login")
//		.failureUrl("/login")
//		.loginProcessingUrl("/login")
////		.successHandler(customAuthenticationSuccessHandler())
////		.failureHandler(customAuthenticationFailureHandler())/*시큐리티 설정중 우선 제외*/
//		.and()
//		.logout()
//		.logoutUrl("/logout")
////		.addLogoutHandler(new LogoutHandler() {
//			/*시큐리티 설정중 우선 제외*/
////			@Override
////			public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
////				//로그아웃 이력 저장
////				HashMap<String, Object> param = new HashMap<>();
////				param.put("jntIo", 'O');
////				param.put("jntIp", request.getRemoteAddr());
////				String status = userConectHistorySearchService.selectlastStatus();
////				if( String.valueOf(status).equals("I".toString()) ){
////					userConectHistorySearchService.saveLog(param);
////				}
////				
////			}
////		})
//		.logoutSuccessUrl("/") //로그아웃 성공시 메인 화면으로 이동
//		.and()
//		.exceptionHandling().accessDeniedPage("/accessDenied.htm");
//		http.headers().frameOptions().sameOrigin();
//		
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
//}
//	
//	public CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("*")); //모든 ip에 응답 허용
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")); //해당 메소드들의 요청 허용
//		
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		
//		return source;
//	}
//	/*시큐리티 설정중 우선 제외*/
////	public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
////		return customAuthenticationSuccessHandler;
////	}
////	
////	public AuthenticationFailureHandler customAuthenticationFailureHandler() {
////		CustomAuthenticationFailureHandler handler = new CustomAuthenticationFailureHandler();
////		handler.setLoginId("mbrId");
////		handler.setLoginPw("mbrPw");
////		handler.setLoginRedirectName("loginRedirect");
////		handler.setExceptionMsgName("securityexceptionmsg");
////		handler.setDefaultFailureUrl("/login");
////	    
////		return handler;
////	}
//	
//	
//}