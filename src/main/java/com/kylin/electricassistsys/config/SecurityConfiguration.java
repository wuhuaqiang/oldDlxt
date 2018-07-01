package com.kylin.electricassistsys.config;

import com.kylin.electricassistsys.handler.LoginFailureHandler;
import com.kylin.electricassistsys.handler.LoginSuccessHandler;
import com.kylin.electricassistsys.handler.LogoutLogHandler;
import com.kylin.electricassistsys.service.system.CustomSecurity.CaptchaAuthenticationFilter;
import com.kylin.electricassistsys.service.system.CustomSecurity.CustomFilterSecurityInterceptor;
import com.kylin.electricassistsys.service.system.CustomSecurity.CustomUserDetailsService;
import com.kylin.electricassistsys.utility.DESCryptography;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.session.ChangeSessionIdAuthenticationStrategy;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;


import javax.sql.DataSource;

/**
 * Created by Threecolors on 2017/12/3.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Bean
    UserDetailsService customUserDetailsService()
    {
        return new CustomUserDetailsService();
    }

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customUserDetailsService()).passwordEncoder(new PasswordEncoder()
        {

            @Override
            public String encode(CharSequence rawPassword)
            {
                return (String) rawPassword;
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword)
            {
                return encodedPassword.equals(DESCryptography.encode(rawPassword.toString()));
            }
        });
    }

    @Bean
    public SessionRegistry getSessionRegistry()
    {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    @Bean
    public ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }

    @Bean
    public AuthenticationFailureHandler loginFailureHandler()
    {
        LoginFailureHandler failureHandler = new LoginFailureHandler();
        failureHandler.setDefaultFailureUrl("/login");
        return failureHandler;
    }

    @Bean
    public SessionAuthenticationStrategy getSessionStrategy()
    {
        ConcurrentSessionControlAuthenticationStrategy sessionStrategy = new ConcurrentSessionControlAuthenticationStrategy(getSessionRegistry());
        sessionStrategy.setMaximumSessions(1);
        sessionStrategy.setExceptionIfMaximumExceeded(true);
        return  sessionStrategy;
    }

    @Bean
    public ConcurrentSessionFilter getConcurrentSessionFilter()
    {
        ConcurrentSessionFilter concurrentSessionFilter = new ConcurrentSessionFilter(getSessionRegistry());
        return  concurrentSessionFilter;
    }

    @Bean
    public LogoutLogHandler getLogoutLogHandler()
    {
        LogoutLogHandler logoutLogHandler = new LogoutLogHandler();
        return  logoutLogHandler;
    }



    @Bean
    public UsernamePasswordAuthenticationFilter getUsernamePasswordAuthenticationFilter() throws Exception
    {
        CaptchaAuthenticationFilter loginAuthenticationFilter = new CaptchaAuthenticationFilter();
        loginAuthenticationFilter.setPostOnly(true);
        loginAuthenticationFilter.setAuthenticationManager(this.authenticationManager());
//        loginAuthenticationFilter.setPasswordParameter("password");
//        loginAuthenticationFilter.setUsernameParameter("username");
        loginAuthenticationFilter.setAuthenticationFailureHandler(loginFailureHandler());
        loginAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
        loginAuthenticationFilter.setSessionAuthenticationStrategy(getSessionStrategy());
        return  loginAuthenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //iframe同源
        http.headers().frameOptions().sameOrigin();
        //自定义用户名密码验证码过滤器
        http.addFilterAt(getUsernamePasswordAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
        //session并发控制过滤器
        http.addFilterAt(getConcurrentSessionFilter(),ConcurrentSessionFilter.class);

        //自定义过滤器
        http.addFilterAt(customFilterSecurityInterceptor, FilterSecurityInterceptor.class);

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/captchImg").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true).sessionRegistry(getSessionRegistry()).expiredUrl("/expiredProcess")
                .and().and().formLogin().loginPage("/login").failureUrl("/login").permitAll()
                .successHandler(loginSuccessHandler)//.usernameParameter("account").passwordParameter("password")
                .and().headers().xssProtection().and()
//                .and().rememberMe().tokenValiditySeconds(1209600).rememberMeServices(rememberMeServices()).key("INTERNAL_SECRET_KEY")
                .and().logout().permitAll().invalidateHttpSession(true).clearAuthentication(true).and().httpBasic();

        // 关闭csrf
        http.csrf().disable();
    }

    @Bean
    public RememberMeServices rememberMeServices()
    {
        JdbcTokenRepositoryImpl rememberMeTokenRepository = new JdbcTokenRepositoryImpl();
        // 此处需要设置数据源，否则无法从数据库查询验证信息
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        rememberMeTokenRepository.setDataSource(dataSource);

        // 此处的 key 可以为任意非空值(null 或 "")，单必须和起前面
        // rememberMeServices(RememberMeServices rememberMeServices).key(key)的值相同
        PersistentTokenBasedRememberMeServices rememberMeServices = new PersistentTokenBasedRememberMeServices("INTERNAL_SECRET_KEY", customUserDetailsService(), rememberMeTokenRepository);

        // 该参数不是必须的，默认值为 "remember-me", 但如果设置必须和页面复选框的 name 一致
        rememberMeServices.setParameter("remember-me");
        return rememberMeServices;
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/css/**").antMatchers("/font/**").antMatchers("/images/**").antMatchers("/js/**").antMatchers("/lib/**").antMatchers("/skins/**").antMatchers("/favicon.ico");
    }
}
