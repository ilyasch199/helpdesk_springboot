package devoir.charqielquortobi.Security;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import devoir.charqielquortobi.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
	private UserPrincipalDetailService userPrincipalDetailService;
	
	public WebSecurityConfig(UserPrincipalDetailService userPrincipalDetailService) {
		this.userPrincipalDetailService = userPrincipalDetailService;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userPrincipalDetailService).passwordEncoder(passwordEncoder());
	}

 
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/","/login","/register","/signup").permitAll()
            .antMatchers("/new").hasAnyAuthority("client")
            .antMatchers("/edit/**").hasAnyAuthority("admin", "developpeur")
            .antMatchers("/delete/**").hasAuthority("admin")
            .antMatchers("/tickets").permitAll()
            .antMatchers("/process_register").permitAll() 
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/tickets")
			.usernameParameter("nom")
			.passwordParameter("password")
            .and()
            .logout()
            	.logoutUrl("/doLogout").permitAll();
            ;
    }

}
