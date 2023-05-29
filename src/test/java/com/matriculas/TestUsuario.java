package com.matriculas;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matriculas.entity.Alumno;
import com.matriculas.service.AlumnoService;



@SpringBootTest
class TestUsuario {

	// para incriptar un password de una inyeccion 
	@Autowired
	private AlumnoService ser1;
	
	public int indice(String dni) {
		List<Alumno> lista = ser1.ListarAlumnos();
		int resu = 0;
		String d = dni;
		for(int i=0;i<lista.size();i++) {		
			if(lista.get(i).getDni().equals(dni)) {
				resu = i;
			}
		}
		return resu;
	}
	
	
	@Test
	void contextLoads() {
		String dni= "72280526";
		System.out.println(indice(dni));
	}
	

}
