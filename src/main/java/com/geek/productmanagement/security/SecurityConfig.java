package com.geek.productmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//ログイン・ログアウト方法・URLごとのアクセス制限を設定するクラス
@Configuration
public class SecurityConfig {
	
	// BCrypt方式でパスワードをハッシュ化・照合するオブジェクトをBean登録する
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
			throws Exception{
		
		//// /loginはログイン前でもアクセス可能、それ以外はログイン済みの利用者のみアクセス可能
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/login").permitAll()
				.anyRequest().authenticated()
		);
		
		//ログイン方法：
		http.formLogin(form -> form
				//ログイン画面（/login）を使用。
				.loginPage("/login")
				//ログインフォームの送信先。Spring Securityが処理する
				.loginProcessingUrl("/login")
				//ログインID:email
				.usernameParameter("email")
				//パスワード：password
				.passwordParameter("password")
				//ログイン成功後：TOP画面
				.defaultSuccessUrl("/top",true)
				//ログイン失敗時：（エラーパラメータをつけて）ログイン画面へ戻す
				.failureUrl("/login?error")
				//ログイン画面・ログイン処理・ログイン（失敗）画面は全員遷移できる
				.permitAll()
		);
		
		//ログアウト機能
		http.logout(logout -> logout
					//// POST /logoutをSpring Securityが処理する
					.logoutUrl("/logout")
					//ログアウト成功時：(logoutパラメータを付けて)ログイン画面へ
					.logoutSuccessUrl("/login?logout")
					//ログアウト関連のURLへのアクセスを許可する
					.permitAll()
		);
		
		return http.build();
		

	}
	
	@Bean
	//PasswordEncoder:パスワード変換ルールを定めたインターフェース
	public PasswordEncoder passwordEncoder() {
		
		//BCrypt方式でそのルールを実装したクラス
		return new BCryptPasswordEncoder();
	}
	

}
