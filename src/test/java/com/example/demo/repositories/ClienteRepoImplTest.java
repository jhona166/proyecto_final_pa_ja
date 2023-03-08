package com.example.demo.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.IClienteRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;



@SpringBootTest
class ClienteRepoImplTest {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private IClienteRepo iClienteRepo;
	
	
	//1
	@Test
	@Transactional
	@Rollback(true)
	void testGuardarCliente() {

		Cliente cliente = new Cliente();
		cliente.setApellido("Ortiz");
		this.iClienteRepo.insertar(cliente);
		assertNotNull(this.iClienteRepo.buscarId(cliente.getId()));
		
		
	}
	//2
	@Test
	void testBuscarNombre() {
		List<Cliente> listaCliente = this.iClienteRepo.buscarCedula("1727501510");
		for (Cliente clie : listaCliente) {
			assertThat(clie.getCedula()).isEqualTo("1727501510");
		}
	}
	
	@Test
	void testBuscarApellido() {
		List<Cliente> listaCliente = this.iClienteRepo.buscarApellido("Altamirano");
		for (Cliente c : listaCliente) {
			assertThat(c.getApellido()).isEqualTo("Altamirano");
		}
	}
	
	@Test
	@Transactional
	@Rollback(true)
	void testBuscarPorNombreApellido() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Lenin");
		cliente.setApellido("Caroa");
		cliente.setCedula("1727501511");
		List<Cliente> clientes = new ArrayList();
		clientes.add(cliente);
		
		
		this.entityManager.persist(cliente);
		//this.entityManager.flush();
		
		//assertEquals(clientes,this.iClienteRepo.buscarApellido("Caroa"));
//		assertEquals(clientes,this.iClienteRepo.buscarCedula("1727501511"));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	void testActualizarPorNombre() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Camilo");
		this.iClienteRepo.actualizar(cliente);
		Cliente clie = this.iClienteRepo.buscarId(1);
		assertThat(clie.getNombre()).isEqualTo("Jhonatan");

	}
	
	
	
	
}
