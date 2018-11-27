package it.nextre.academy.restdemo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//non terrà traccia dello stato
                .authorizeRequests()
                .antMatchers("/res/**","/","/index","/home","/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("txtuser")
                    .passwordParameter("txtpwd")
                    //.successForwardUrl("/dashboard")
                    //.failureForwardUrl("/login?error=true&redirect=true")
                    .failureUrl("/login?error=true")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                .and()
                .sessionManagement()
                    .invalidSessionUrl("/login")
                    .maximumSessions(1)
                    .sessionRegistry(sessionRegistry())
                    .and()
                    .sessionFixation().none()
                ;
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }

    //definisco il metodo di crittografia della password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
        //usato per collegarsi a un provider che offre controllo col DB
        //auth.authenticationProvider(authProvider());

        //usato per test veloci
        auth
            .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
            .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN")

        ;

    }



    /*
    @Bean
    public DaoAuthenticationProvider authProvider() {
        final CustomAuthenticationProvider authProvider = new CustomAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }
    */

}//end class
