package it.nextre.academy.restdemo.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    //utile per bypassare la security sulle risorse statiche
    /*
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/res/**", "/static/**", "/contents/css/**", "/contents/js/**", "/contents/img/**");
    }
    */



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//non terrà traccia dello stato
                .authorizeRequests()
                .antMatchers("/res/**","/","/index","/home","/login","/registration")
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

    /*
    //FUNZIONA v1
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
    */


    /*Versione v2 per usare gli utenti in memoria*/
    /*
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        //Evitabile se ho definito il bean del password encoder
        //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(passwordEncoder()::encode);
        UserDetails user = userBuilder.username("user").password("user").roles("USER").build();
        UserDetails admin = userBuilder.username("admin").password("admin").roles("USER","ADMIN").build();
        return new InMemoryUserDetailsManager(admin,user);
    }
    */




    //Verisone v3 utenti sul db
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
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
