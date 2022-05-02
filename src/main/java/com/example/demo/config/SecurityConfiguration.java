package com.example.demo.config;

import com.example.demo.security.impl.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);

    private final UsersServiceImpl usersService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Authentication provider");

        http.authorizeRequests().antMatchers("/auth_page/**").authenticated().antMatchers("/user_info").authenticated().antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERADMIN") // ROLE_ADMIN, ROLE_SUPERADMIN
                .anyRequest().permitAll().and().formLogin().and().logout().invalidateHttpSession(true).deleteCookies("JSESSIONID");
//                .and()
//                .sessionManagement()
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(true);

//        http.
//                authorizeRequests().antMatchers("/home","/","/css/**","/js/**","/api/**","/post/**").permitAll().anyRequest().
//                fullyAuthenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and().logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
//                .exceptionHandling().accessDeniedPage("/access?error").and().csrf().disable();

//        if(!securityEnabled!!) {
//            http.httpBasic()
//                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/**").permitAll()
//                    .and()
//                    .csrf().disable()
//                    .formLogin().disable()
//        } else {
//            http
//                    .authorizeRequests()
//                    .antMatchers("/api/companies/**").permitAll()
//                    .antMatchers(Router.API_PATH + "/**").authenticated()
//                    .and()
//                    .httpBasic()
//                    .and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    .and()
//                    .anonymous()
//                    .and()
//                    .securityContext()
//                    .and()
//                    .headers().disable()
//                    .rememberMe().disable()
//                    .requestCache().disable()
//                    .csrf().disable()
//                    .x509().disable()
//                    .httpBasic().disable()
//                    .formLogin().disable()
//                    .logout().disable()
//                    .oauth2ResourceServer(oauth2 -> oauth2
//                            .jwt(jwt -> jwt.decoder(jwtDecoder()))
//                    )
//        }
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(usersService);
        return authenticationProvider;
    }
}
