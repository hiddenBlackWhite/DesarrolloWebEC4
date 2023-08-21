package edu.pe.idat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.idat.model.Departamento;
import edu.pe.idat.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return departamentoService.obtenerTodosLosDepartamentos();
    }

    @GetMapping("/{id}")
    public Departamento verDepartamento(@PathVariable int id) {
        return departamentoService.obtenerDepartamentoPorId(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
    }

    @PostMapping
    public Departamento crearDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.guardarDepartamento(departamento);
    }

    @PutMapping("/{id}")
    public Departamento actualizarDepartamento(@PathVariable int id, @RequestBody Departamento departamento) {
        return departamentoService.actualizarDepartamento(id, departamento);
    }

    @DeleteMapping("/{id}")
    public void eliminarDepartamento(@PathVariable int id) {
        departamentoService.eliminarDepartamentoPorId(id);
    }
}
