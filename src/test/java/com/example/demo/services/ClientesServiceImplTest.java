package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.IClienteService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ClientesServiceImplTest {
	@Autowired
	private IClienteService iClienteService;

	
	@Test
	void testBuscarCedula() {
		List<Cliente> listaCliente = this.iClienteService.buscarCedula("1727501510");
		for (Cliente c : listaCliente) {
			assertThat(c.getCedula()).isEqualTo("1727501510");
		}
	}
	@Test
	@Transactional
	@Rollback(false)
	void testCrearCliente() {
		Cliente cliente = new Cliente();
		cliente.setApellido("Noriega");
		this.iClienteService.crear(cliente);;
		//assertNotNull(this.iClienteService.buscarId(cliente.getId()));
	}
	//elimino
	@Test
	@Transactional
	@Rollback(true)
	void testEliminar() {
		this.iClienteService.borrar(2);
		//assertNull(this.iClienteService.buscarId(2));
	}


}
