package com.nuey.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// jwt방식은 상태 stateless로 관리하기 때문에 csrf를 방어하지 않아도 되서 disabled
		http
				.csrf(auth -> auth.disable());

		// form 로그인 방식 disable
		http
				.formLogin(auth -> auth.disable());

		// http basic 인증 방식 disable
		http
				.httpBasic(auth -> auth.disable());

		// 경로별 인가 작업
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/signup").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().denyAll()
                        );

        http
                .formLogin(auth -> auth.loginPage("/login")                         // 로그인 경로설정 -> 로그인이 필요할 시 자동으로 로그인페이지로 리다이렉트해줌
                                    .loginProcessingUrl("/loginform")   // 로그인 처리 URL 설정 (null로 설정하면 기본 URL 사용)
                                    .permitAll()                                            // 로그인 페이지는 모든 사용자에게 허용
                );

        http
                .csrf(auth -> auth.disable()); // CSRF 보호 비활성화 (API 서버 등에서는 필요에 따라 활성화할 수 있음)
                

        return http.build();

    }

}
