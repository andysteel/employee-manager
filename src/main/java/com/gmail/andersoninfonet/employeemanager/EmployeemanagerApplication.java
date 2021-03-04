package com.gmail.andersoninfonet.employeemanager;

import java.util.Arrays;

import com.gmail.andersoninfonet.employeemanager.models.Employee;
import com.gmail.andersoninfonet.employeemanager.repositories.EmployeeRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200",  "http://localhost:4500")); //Collections.singletonList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	public ApplicationRunner initializer(EmployeeRepository repository) {
		return args -> repository.saveAll(Arrays.asList(
        	new Employee(1L, "Eduardo", "eduardo@eduardo.com", "Engenheiro", "2145687457", "https://bootdey.com/img/Content/avatar/avatar7.png",
			"sfhgfkhadgfkjhagdfkhjsgdfjhagdsfkjajjj"),
			new Employee(2L, "Nubia", "nubianeri@nubia.com", "Designer", "2145687457", "https://bootdey.com/img/Content/avatar/avatar4.png",
			"sfhgfkhadgfkjhagdfkhjsgdfjhagdsfkjahhh"),
			new Employee(3L, "Luciana", "luciana@luciana.com", "Confeiteira", "2145687457", "https://bootdey.com/img/Content/avatar/avatar2.png",
			"sfhgfkhadgfkjhagdfkhjsgdfjhagdsfkjayyy"),
			new Employee(4L, "Anderson", "anderson@anderson.com", "Engenheiro", "2145687457", "https://bootdey.com/img/Content/avatar/avatar1.png",
			"sfhgfkhadgfkjhagdfkhjsgdfjhagdsfkjaxxx")
		));
	}

	@Bean
	public HttpTraceRepository htttpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}
}


