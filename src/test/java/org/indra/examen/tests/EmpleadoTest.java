package org.indra.examen.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.indra.examen.models.Empleado;
import org.indra.examen.services.EmpleadoService;
import org.indra.examen.services.IEmpleadoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
class EmpleadoTest {
	
	@Autowired
	private IEmpleadoService service = new EmpleadoService();

	@Test
	public void testGetById() throws Exception {
		Empleado e = this.service.getById(1);
		assertEquals("Ernesto", e.getNombre());
		assertEquals("Jimenez", e.getApellido());
	}

}
