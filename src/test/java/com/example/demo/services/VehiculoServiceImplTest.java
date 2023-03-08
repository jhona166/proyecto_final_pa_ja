package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;

@SpringBootTest
public class VehiculoServiceImplTest {
	@Autowired
	private IVehiculoService iVehiculoService;
	@Test
	void testBuscarMarca() {
		List<Vehiculo> vehiculos = this.iVehiculoService.buscarMarca("Centra");
		for (Vehiculo vehi : vehiculos) {
			assertThat(vehi.getMarca()).isEqualTo("Centra");
		}
	}
	@Test
	void testBuscarId() {
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca("PCO-123");
			assertThat(vehiculo.getPlaca()).isEqualTo("PCO-123");
	}
	
	
}
