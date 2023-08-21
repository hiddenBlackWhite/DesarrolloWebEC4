package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pe.idat.model.Departamento;
import edu.pe.idat.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	 private final DepartamentoRepository departamentoRepository;

	    public DepartamentoService(DepartamentoRepository departamentoRepository) {
	        this.departamentoRepository = departamentoRepository;
	    }

	    public List<Departamento> obtenerTodosLosDepartamentos() {
	        return departamentoRepository.findAll();
	    }

	    public Optional<Departamento> obtenerDepartamentoPorId(int id) {
	        return departamentoRepository.findById(id);
	    }

	    public Departamento guardarDepartamento(Departamento departamento) {
	        return departamentoRepository.save(departamento);
	    }

	    public void eliminarDepartamentoPorId(int id) {
	        departamentoRepository.deleteById(id);
	    }

	    public Departamento actualizarDepartamento(int id, Departamento departamentoActualizado) {
	        Optional<Departamento> departamentoExistente = departamentoRepository.findById(id);

	        if (departamentoExistente.isPresent()) {
	            Departamento departamento = departamentoExistente.get();
	            departamento.setTitulo(departamentoActualizado.getTitulo());
	            departamento.setDistrito(departamentoActualizado.getDistrito());
	            departamento.setDireccion(departamentoActualizado.getDireccion());
	            departamento.setPrecio(departamentoActualizado.getPrecio());
	            departamento.setDisponible(departamentoActualizado.isDisponible());
	            departamento.setUsuario(departamentoActualizado.getUsuario());
	            departamento.setImagen1(departamentoActualizado.getImagen1());

	            return departamentoRepository.save(departamento);
	        } else {
	            // Manejar la situación si no se encuentra el departamento
	            throw new RuntimeException("No se encontró el departamento con el ID proporcionado");
	        }
	    }
	    
	    
	    public Departamento actualizarDisponibilidadDepartamento(int departamentoId, boolean disponible) {
	        Optional<Departamento> departamentoExistente = departamentoRepository.findById(departamentoId);

	        if (departamentoExistente.isPresent()) {
	            Departamento departamento = departamentoExistente.get();
	            departamento.setDisponible(disponible);
	            return departamentoRepository.save(departamento);
	        } else {
	            throw new RuntimeException("No se encontró el departamento con el ID proporcionado");
	        }
	    }
}
