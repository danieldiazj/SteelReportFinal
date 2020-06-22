package pe.edu.upc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.auth.handler.LoginSuccessHandler;
import pe.edu.upc.serviceimpl.JpaUserDetailsService;;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private LoginSuccessHandler successHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		try {
			http.authorizeRequests()
			
			.antMatchers("/tipocliente/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_CONSTRUCTOR')")
			.antMatchers("/cliente/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_CONSTRUCTOR')")
			.antMatchers("/obra/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_CONSTRUCTOR')")
			.antMatchers("/solicitudcompra/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_CLIENTE')  or hasRole('ROLE_INDUSTRIAL')  or hasRole('ROLE_CONSTRUCTOR')")
			.antMatchers("/detallesolicitud/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_CLIENTE')  or hasRole('ROLE_INDUSTRIAL')  or hasRole('ROLE_CONSTRUCTOR')")
			.antMatchers("/tipojefeventas/**").access("hasRole('ROLE_COMERCIAL')")
			.antMatchers("/jefeventas/**").access("hasRole('ROLE_COMERCIAL')")
			.antMatchers("/producto/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_INDUSTRIAL')")
			.antMatchers("/ordencompra/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_INDUSTRIAL')")
			.antMatchers("/hojaruta/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_INDUSTRIAL')")
			.antMatchers("/ordendespacho/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_INDUSTRIAL')")
			.antMatchers("/detallecompra/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_INDUSTRIAL')")
			.antMatchers("/detalledespacho/**").access("hasRole('ROLE_COMERCIAL') or hasRole('ROLE_INDUSTRIAL')").and()
			.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/solicitudcompra/bienvenido")
			.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

	}
}
