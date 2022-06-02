package org.indra.examen.services;

import java.util.*;

import org.indra.examen.models.Empleado;

public interface IEmpleadoService {
	public List<Empleado> getAll();
	public Empleado getById(int id) throws Exception;
	public Empleado add(Empleado empleado) throws Exception;
	public String deleteById(int id) throws Exception;
}
