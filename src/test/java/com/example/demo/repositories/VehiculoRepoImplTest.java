package com.example.demo.repositories;



import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repository.IVehiculoRepo;
import com.example.demo.service.IVehiculoService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class VehiculoRepoImplTest {
	@MockBean
	private IVehiculoRepo iVehiculoRepo;
	@Autowired
	private IVehiculoService iVehiculoService;
	@Test
	void testBuscarMarca() {
		List<Vehiculo> lista = this.iVehiculoRepo.buscarMarca("Aveo");
		for (Vehiculo v : lista) {
			assertThat(v.getMarca()).isEqualTo("Aveo");
		}
	}
	
	
	@Test
	void testBuscarString(){
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Toyota");
		vehiculo.setModelo("Hi-lux");
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(vehiculo);
		//hace que el test sea unitario
		when(this.iVehiculoRepo.buscarMarca("Toyota")).thenReturn(vehiculos);
		//assertEquals(vehiculos,this.iVehiculoService.buscarMarca("Toyota"));
	
	}
	@Test
	@Transactional
	@Rollback(true)
	void testUpdate() {
		Vehiculo vehi = new Vehiculo();
		vehi.setId(1);
		vehi.setMarca("Toyota");
		this.iVehiculoRepo.actualizar(vehi);
		assertThat(vehi.getMarca()).isEqualTo("Toyota");
	}
	
	//1
	@Test
	@Transactional
	@Rollback(true)
	void testGuardarVehiculo() {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setModelo("Aveo");
		this.iVehiculoRepo.insertar(vehiculo);
		assertNotNull(this.iVehiculoRepo.buscarId(vehiculo.getId()));
		
		
	}
}
