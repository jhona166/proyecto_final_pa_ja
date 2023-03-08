/*
package com.example.demo.controllers;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.ClienteController;
import com.example.demo.modelo.Cliente;
import com.example.demo.service.ClienteServiceImpl;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {
	@MockBean
	private ClienteServiceImpl clienteServiceImpl;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ClienteServiceImpl iclienServiceImpl;

	@Test
	void testString() {
		Cliente cliente = new Cliente();
		cliente.setApellido("Altamirano");
		when(this.iclienServiceImpl.buscarCedula("1727501510")).thenReturn(this.iclienServiceImpl.buscarCedula("1727501510"));

	}
}
*/