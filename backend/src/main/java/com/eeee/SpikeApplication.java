package com.eeee;

import com.eeee.services.AccountService;
import com.eeee.spike.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.management.MXBean;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@SpringBootApplication
public class SpikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpikeApplication.class, args);
    }

    // CORS
    @Bean
    FilterRegistrationBean corsFilter(
            @Value("${tagit.origin:http://localhost:8090}") String origin) {
        return new FilterRegistrationBean(new Filter() {
            public void doFilter(ServletRequest req, ServletResponse res,
                                 FilterChain chain) throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) req;
                HttpServletResponse response = (HttpServletResponse) res;
                String method = request.getMethod();
                // this origin value could just as easily have come from a database
                response.setHeader("Access-Control-Allow-Origin", origin);
                response.setHeader("Access-Control-Allow-Methods",
                        "POST,GET,OPTIONS,DELETE");
                response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader(
                        "Access-Control-Allow-Headers",
                        "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
                if ("OPTIONS".equals(method)) {
                    response.setStatus(HttpStatus.OK.value());
                } else {
                    chain.doFilter(req, res);
                }
            }

            public void init(FilterConfig filterConfig) {
            }

            public void destroy() {
            }
        });
    }

    @Bean
    CommandLineRunner init(final AccountService accountService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... arg0) throws Exception {
                accountService.add(new Account("Shi", "Charles", "charles.qld@gmail.com", "abcd1234"));
            }

        };
    }
}


@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    AccountService accountService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                return accountService.getByEmail(s).map(acct -> new User(acct.getEmail(), acct.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER")))
                        .orElseThrow(
                                () -> new UsernameNotFoundException("Could not find user '" + s + "'")
                        );
            }
        };
    }
}

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/register").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/**").hasRole("USER")
                .antMatchers("/**")
                .permitAll().and().httpBasic().and().csrf().disable();
                //.access("#oauth2.hasScope('read')");
    }
}