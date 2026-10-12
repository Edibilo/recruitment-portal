package iki.mashad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SpringConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {

                    //application
                    request.requestMatchers("/api/v1/applications/**").hasAnyRole("APPLICANT","RECRUITER");

                    //roles
                    request.requestMatchers("/api/v1/roles/**").hasRole("ADMIN");

                    //jobs
                    request.requestMatchers(HttpMethod.GET,"/api/v1/jobs/**").hasAnyRole("APPLICANT","ADMIN","RECRUITER");
                    request.requestMatchers(HttpMethod.POST,"/api/v1/jobs/**").hasAnyRole("ADMIN","RECRUITER","APPLICANT");

                    //dashboards
                    request.requestMatchers("/api/v1/dashboards").hasAnyRole("ADMIN","RECRUITER","APPLICANT");

                    //register && login
                    request.requestMatchers("/api/v1/auth/**").permitAll();

                    //edit && delete Users
                    request.requestMatchers("/api/v1/users/profile").hasAnyRole("ADMIN", "RECRUITER", "APPLICANT");
                    request.requestMatchers("/api/v1/users/profile/edit").hasAnyRole("ADMIN", "RECRUITER", "APPLICANT");
                    request.requestMatchers("/api/v1/users/**").hasRole("ADMIN");

                }).formLogin(login -> {
                    login.loginPage("/api/v1/auth/login");
                    login.defaultSuccessUrl("/api/v1/dashboards");
                    login.permitAll();
                }).logout(logout -> {
                    logout.invalidateHttpSession(true);
                    logout.clearAuthentication(true);
                    logout.logoutUrl("/api/v1/auth/logout");
                    logout.logoutSuccessUrl("/api/v1/auth/login");
                    logout.deleteCookies("JSESSIONID");
                    logout.permitAll();
                });
        return httpSecurity.build();
    }
}
