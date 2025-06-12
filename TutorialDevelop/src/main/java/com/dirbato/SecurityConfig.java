package com.dirbato;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    /** 認証・認可設定 */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
            .loginProcessingUrl("/login") 
            .loginPage("/login") 
            // ユーザー名・パスワードの送信先
            // ログイン画面
            .defaultSuccessUrl("/user/list") // ログイン成功後のリダイレクト先
            .failureUrl("/login?error") 
            .permitAll() 
        ).logout(logout -> logout
            .logoutSuccessUrl("/login") 
        ).authorizeHttpRequests(auth -> auth
            // ログイン失敗時のリダイレクト先
            // ログイン画面は未ログインでアクセス可
            // ログアウト後のリダイレクト先
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
            .permitAll() 
            // css等は未ログインでアクセス可
            .anyRequest().authenticated() 
        );
        return http.build();
    }
    // その他はログイン必要
    /** ハッシュ化したパスワードの比較に使用する */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}