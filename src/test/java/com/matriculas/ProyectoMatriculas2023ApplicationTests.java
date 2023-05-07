package com.matriculas;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.matriculas.entity.Alumno;
import com.matriculas.entity.Distrito;
import com.matriculas.entity.Pais;
import com.matriculas.service.AlumnoService;

@SpringBootTest
class ProyectoMatriculas2023ApplicationTests {

	@Autowired
	private AlumnoService servicio;
	
	@Test
	void contextLoads() {
		
		Alumno a = new Alumno();
		
		a.setDni("80256932");
		a.setNombre("Luigui");
		a.setApellido("Ramirez");
		a.setCorreo("luigui@gmail.com");
		a.setFecNac(LocalDate.parse("2002-04-19"));
		a.setDireccion("Av Izaguirre 282");
		
		Distrito d = new Distrito();
		d.setCodigo(3);
		a.setDistrito(d);
		Pais p = new Pais();
		p.setCodigo(1);
		a.setPais(p);
		servicio.GrabarAlumno(a);
		
		
	}

}
