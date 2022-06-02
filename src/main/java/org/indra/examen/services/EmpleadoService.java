package org.indra.examen.services;

import java.util.List;

import org.indra.examen.models.Empleado;
import org.indra.examen.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleadoService{
	
	@Autowired
	private EmpleadoRepository repository;
	
	@Override
	public List<Empleado> getAll() {
		return this.repository.findAll();
	}
	@Override
	public Empleado getById(int id) throws Exception {
		return this.repository.findById(id).get();
	}
	
	@Override
	public Empleado add(Empleado empleado) throws Exception {
		if(empleado.getNombre() == null || empleado.getNombre().length() == 0) {
			throw new Exception("Falta el nombre del empleado");
		}
		
		if(empleado.getApellido() == null || empleado.getApellido().length() == 0) {
			throw new Exception("Falta el apellido del empleado");
		}
		
		if(empleado.getTelefono() == null) {
			throw new Exception("Falta el telefono del empleado");
		}
		
		if(empleado.getTelefono().length() < 6 || empleado.getTelefono().length() > 9) {
			throw new Exception("El telefono tiene que tener entre 6 y 9 numeros");
		}
		
		if(empleado.getDireccion() == null || empleado.getDireccion().length() == 0) {
			throw new Exception("Falta la direccion del empleado");
		}
		
		this.repository.save(empleado);
		
		return empleado;
	}
	
	@Override
	public String deleteById(int id) throws Exception {
		if(this.repository.findById(id) == null) {
			throw new Exception("No se encuentra el empleado.");
		}
		
		this.repository.deleteById(id);
		
		return "Empleado borrado satisfactoriamente.";
	}
}
