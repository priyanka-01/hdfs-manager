package com.loginsecurity.security;

import com.loginsecurity.bean.Role;
import com.loginsecurity.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserPrincipalDetailsService userPrincipalDetailsService;
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

//    @Override
//    public void configure(WebSecurity webSecurity){
//        webSecurity.ignoring().antMatchers("/register");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry request =
                http.authorizeRequests();


//        request.antMatchers("/**.jsp").denyAll()
//                .antMatchers("/bootstrap/**", "/css/**", "/images/**", "/jquery/**", "/js/**", "/menu/**").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/index").permitAll();

        request.antMatchers("/home").permitAll();

        resourceRepository.findAll()
                .stream()
                .forEach(resource -> {
                    if (resource.getRoles().size() == 1) {
                        String name = resource.getRoles().iterator().next().getName();
                        if (name.equals("NONE")) {
                            request
                                    .antMatchers(resource.getPage())
                                    .denyAll();
                        } else if (name.equals("ALL")) {
                            request
                                    .antMatchers(resource.getPage())
                                    .permitAll();
                        } else {
                            request
                                    .antMatchers(resource.getPage())
                                    .hasRole(name);

                        }
                    }
                    else {
                        request
                                .antMatchers(resource.getPage())
                                .hasAnyRole(
                                        resource.getRoles()
                                                .parallelStream()
                                                .map(Role::getName)
                                                .toArray(String[]::new)
                                );
                    }
                });

//        resourceRepository.findAll()
//                .parallelStream()
//                .forEach(resource -> request
//                        .antMatchers(resource.getPage())
//                        .hasAnyRole(
//                                resource.getRoles()
//                                        .parallelStream()
//                                        .map(Role::getName)
//                                        .toArray(String[]::new)
//                        )
//                );

//        request.antMatchers("/admin").hasRole("ADMIN")

        request.antMatchers("/manageData").hasAnyRole("STUDENT", "ADMIN");
                request.anyRequest().authenticated()
                .and()
                //.httpBasic();
                .csrf().disable()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home")
                .usernameParameter("email")
                .passwordParameter("password")
                        .and()
                        // logout
                        .logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/");

    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                //URLs matching for access
                .antMatchers(	"/bootstrap/**",
                        "/css/**",
                        "/images/**",
                        "/jquery/**",
                        "/js/**",
                        "/register",
                        "/error").permitAll()
                .antMatchers("/home/**").hasAnyAuthority("ADMIN", "FACULTY", "STUDENT", "ROLE_STUDENT")
                .anyRequest().authenticated()
                .and()
                // Form login
                .csrf().disable()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                // logout
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                //Exception Handling
                .exceptionHandling()
                .accessDeniedPage("/error");
    } */