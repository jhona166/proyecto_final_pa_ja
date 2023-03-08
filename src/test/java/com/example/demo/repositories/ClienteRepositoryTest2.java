package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.IClienteRepo;

import jakarta.transaction.Transactional;


@SpringBootTest
public class ClienteRepositoryTest2 {

	
	@Autowired
	private IClienteRepo clienteRepo;
	
	private static Cliente cliente1;
	private static Cliente cliente2;
	
	@BeforeAll
	public static void setup() {

		cliente1 = new Cliente("1223321", "Francisco", "Mancheno", LocalDateTime.now(), "Masculino", "Registrado", "VIP");
		cliente2 = new Cliente("838833", "Luis", "Chanataxi", LocalDateTime.now(), "Masculino", "Registrado", "VIP");

	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testInsertarCliente() {
		//Vehiculo vehiculo = new Vehiculo("uass-212", "Hilux", "TOYOTA") ;
		this.clienteRepo.insertar(cliente1);
		this.clienteRepo.insertar(cliente2);
		assertNotNull(this.clienteRepo.buscarId(cliente2.getId()));;
	}
	

	@Test
	@Transactional
    @Rollback(false)
	public void testBuscarId() {
		
		Cliente c = this.clienteRepo.buscarId(30);
		assertTrue(c!=null);
	}
	
	@Test
	@Transactional
    @Rollback(false)
	public void testBuscarApellido() {
		
		List<Cliente> c = this.clienteRepo.buscarApellido(cliente2.getApellido());
		assertTrue(c.size()>0);
	}
	
	@Test
	@Transactional
    @Rollback(false)
	public void testBuscarCedula() {
		
		List<Cliente> c = this.clienteRepo.buscarCedula(cliente2.getCedula());
		assertTrue(c.size()>0);
	}
	

}
