package com.matriculas;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.matriculas.entity.Alumno;
import com.matriculas.entity.Distrito;
import com.matriculas.entity.Pais;
import com.matriculas.service.AlumnoService;
import com.matriculas.service.InscripcionService;

@SpringBootTest
class ProyectoMatriculas2023ApplicationTests {

	@Autowired
	private InscripcionService servicio;
	
	@Test
	void contextLoads() {
		
		
		String data = servicio.GenerarCodigo();
		
		
		System.out.println(data);
		
	}

}
