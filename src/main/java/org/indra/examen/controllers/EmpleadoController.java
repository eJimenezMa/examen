package org.indra.examen.controllers;

import org.indra.examen.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.indra.examen.models.*;

@RestController
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService service;
	
	@GetMapping("/empleado")
	public ResponseEntity<List<Empleado>> getAll(){
		return new ResponseEntity<List<Empleado>>(this.service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/empleado/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name="id") int id) {
		try {
			return new ResponseEntity<Object>(this.service.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/empleado")
	public ResponseEntity<Object> add(@RequestBody() Empleado empleado){
		try {
			return new ResponseEntity<Object>(this.service.add(empleado), HttpStatus.OK);
		} catch(Exception exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/empleado/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name="id") int id){
		try {
			return new ResponseEntity<Object>(this.service.deleteById(id), HttpStatus.OK);
		} catch(Exception exception) {
			return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
