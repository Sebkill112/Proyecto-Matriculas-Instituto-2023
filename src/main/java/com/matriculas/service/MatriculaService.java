package com.matriculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matriculas.dao.DetalleMatriculaRepository;
import com.matriculas.dao.MatriculaRepository;
import com.matriculas.entity.DetalleMatricula;
import com.matriculas.entity.DetalleMatriculaPK;
import com.matriculas.entity.Matricula;


@Service
public class MatriculaService {

	
	@Autowired
	private MatriculaRepository repo;
	
	@Autowired
	private DetalleMatriculaRepository repoDetalle;
	
	public String GenerarCodigo() {
		return repo.generarNumeroMatricula();
	}
	
	public void GrabarMatricula(Matricula i) {
		repo.save(i);
	}
	
	public List<Matricula> listadoMatriculasUsu(String dni,String estado){
		return repo.listarMatriculasUsuario(dni, estado);
	}
	public Matricula buscarPorID(String cod) {
		return repo.findById(cod).orElse(null);
	}
	

	
	@Transactional
	public void registrarHorariosMatricula(Matricula bean) {
		try {
			
			//grabar MedicamentoHasBoleta "detalle"
			for(DetalleMatricula mhb:bean.getListaDetalleMatricula()) {
				//crear objeto de la clase MedicamentoHasBoletaPK
				DetalleMatriculaPK pk=new DetalleMatriculaPK();
				//setear
				pk.setCodigoMatricula(bean.getIdMatricula());
				pk.setCodigoHorario(mhb.getHorario().getCodigo());
				//enviar pk a mhb
				mhb.setPk(pk);
				repoDetalle.save(mhb);
			}
			String estado = "MATRICULADO";
			repo.actualizaEstado(estado, bean.getIdMatricula());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
