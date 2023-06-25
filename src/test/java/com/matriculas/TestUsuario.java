package com.matriculas;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matriculas.entity.Alumno;
import com.matriculas.service.AlumnoService;
import com.matriculas.service.MatriculaService;



@SpringBootTest
class TestUsuario {

	// para incriptar un password de una inyeccion 
	@Autowired
	private MatriculaService ser1;
	
	
	
	@Test
	void contextLoads() {
		
	}
	

}
