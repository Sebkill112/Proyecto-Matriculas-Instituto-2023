package com.matriculas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.matriculas.security.security;

//archivo de configuracion
@Configuration
//habilitar segurdidad
@EnableWebSecurity

//habilitar metodo para validar clave
@EnableMethodSecurity
public class securityConfig {
	//autenticacion
		@Bean
		public UserDetailsService userDetailsService() {
		/*	UserDetails usuario1=User.withUsername("emanuel").password("{noop}123").roles("ADMIN").build();
			UserDetails usuario2=User.withUsername("alicia").password("{noop}456").roles("USER").build();
			

			return new InMemoryUserDetailsManager(usuario1,usuario2);*/
			
			return new security();
		}
		
		@Bean
		//interfaz AuthenticationProvider
		public AuthenticationProvider AuthenticationProvider() {
			DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
			dao.setUserDetailsService(userDetailsService());
			dao.setPasswordEncoder(password());
			return dao;
		}
		
		@Bean
		public BCryptPasswordEncoder password() {
			
			return new BCryptPasswordEncoder();
		}

	//autorizacion
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/validar/usuario")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();*/
		
		http.csrf().disable().authorizeHttpRequests().requestMatchers("/validar/**","/resources/js/**","/resources/css/**","resources/img/**",
				"/resources/datepicker/**","/resources/**alertifyjs/**","/home/**").permitAll().and().authorizeHttpRequests().
		requestMatchers("/horario/**").hasAuthority("Alumno").requestMatchers("/matricula/**","/alumno/buscar","/carrera/buscar").hasAuthority("Secretaria").
		and().authorizeHttpRequests().requestMatchers("/alumno/**","/carrera/**","docente/**").hasAnyAuthority("Administrador").
		and().formLogin().loginPage("/validar/usuario").defaultSuccessUrl("/validar/intranet");
		
		return http.build();
	}
	
	
	
	
	
}
