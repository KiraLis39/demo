package com.example.demo.secure;

//@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
//    @Autowired
//    private DataSource dataSource;

//    @Autowired
//    private SecurityProperties security;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.
//                authorizeRequests().antMatchers("/home","/","/css/**","/js/**","/api/**","/post/**").permitAll().anyRequest().
//                fullyAuthenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and().logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
//                .exceptionHandling().accessDeniedPage("/access?error").and().csrf().disable();
//    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(this.dataSource);
//    }
}
