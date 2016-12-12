package ru.itis.inform.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.itis.inform.security.CORSFilter;
import ru.itis.inform.security.TokenAuthenticationEntryPoint;
import ru.itis.inform.security.TokenAuthenticationFilter;
import ru.itis.inform.security.user.UserDetailsServiceImpl;

import javax.servlet.Filter;

/**
 * 30.10.2016.
 *
 * @author Maxim Romanov
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**Disabling default security authentication,
    csrf support and default login form,
     allowing access to all requests without authorization
     (gonna check it in TokenAuthenticationFilter)*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .authorizeRequests().anyRequest().permitAll();
    }

    @Bean
    public TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint() {
        return new TokenAuthenticationEntryPoint();
    }

    @Bean
    public Filter tokenAuthenticationFilter(UserDetailsService userDetailsService) {
        return new TokenAuthenticationFilter(userDetailsService);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public Filter corsFilter() {
        return new CORSFilter();
    }
}
