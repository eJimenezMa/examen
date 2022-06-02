package org.indra.examen.models;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter @Setter
@Table(name="Empleados")
public class Empleado extends ObjetoDeNegocio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name")
	private String nombre;
	
	@Column(name="Surname")
	private String apellido;
	
	@Column(name="Telephone")
	private String telefono;
	
	@Column(name="Direction")
	private String direccion;
	
	
}
