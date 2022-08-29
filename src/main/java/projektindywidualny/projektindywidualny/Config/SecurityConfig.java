package projektindywidualny.projektindywidualny.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import projektindywidualny.projektindywidualny.RESTAuthentification.JsonObjectAuthenticationFilter;
import projektindywidualny.projektindywidualny.RESTAuthentification.RestAuthenticationFailureHandler;
import projektindywidualny.projektindywidualny.RESTAuthentification.RestAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private RestAuthenticationSuccessHandler authenticationSuccessHandler;
    private RestAuthenticationFailureHandler authenticationFailureHandler;

    public SecurityConfig(RestAuthenticationSuccessHandler authenticationSuccessHandler,
                          RestAuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }



    @Bean
    public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
        JsonObjectAuthenticationFilter filter = new JsonObjectAuthenticationFilter();
        AuthenticationSuccessHandler authenticationSuccessHandler;
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        AuthenticationFailureHandler authenticationFailureHandler;
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {

        builder.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password") //noop brak kodowania wybrać jedno z ({bcrypt}, {pbkdf2}, {scrypt}, {sha256})
                .roles("USER");


}
