package edu.pe.idat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.pe.idat.dto.RegisterRequest;
import static edu.pe.idat.model.Role.*;
import edu.pe.idat.service.AuthenticationService;

@SpringBootApplication
public class LabLeccion08Application {

	public static void main(String[] args) {
		SpringApplication.run(LabLeccion08Application.class, args);
	}
	
	
}
