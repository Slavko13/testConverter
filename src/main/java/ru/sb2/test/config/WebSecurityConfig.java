package ru.sb2.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.sb2.test.security.AuthProviderImpl;


@Configuration
@EnableWebSecurity
@ComponentScan("ru.sb2.test.security")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthProviderImpl authProvider;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/registration").anonymous()
                .antMatchers("/valute", "/js/**").authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/valute")
                .failureUrl("/login?error=true")
                .loginProcessingUrl("/login/process")
                .usernameParameter("login")
                .and()
                .rememberMe()
                .and()
                .exceptionHandling().accessDeniedPage("/")
                .and().logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
