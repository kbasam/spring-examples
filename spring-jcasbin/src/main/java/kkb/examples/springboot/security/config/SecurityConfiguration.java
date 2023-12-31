package kkb.examples.springboot.security.config;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import kkb.examples.springboot.security.services.UserAccessService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final Enforcer enforcer;
    private final UserAccessService userAccessService;

    @Autowired
    public SecurityConfiguration(Enforcer enforcer, UserAccessService userAccessService) {
        this.enforcer = enforcer;
        this.userAccessService = userAccessService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .addFilterBefore(new JCasBinFilter(enforcer, userAccessService), BasicAuthenticationFilter.class)
                .antMatcher("/services/data/**")
                .csrf()
                .disable();
    }

}
