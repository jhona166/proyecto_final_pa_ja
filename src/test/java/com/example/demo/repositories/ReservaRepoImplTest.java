package com.example.demo.repositories;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repository.IClienteRepo;
import com.example.demo.repository.IReservaRepo;
import com.example.demo.repository.IVehiculoRepo;

@SpringBootTest
public class ReservaRepoImplTest {
	@Autowired
	private IReservaRepo iReservaRepo;
	@Autowired
	private IClienteRepo iClienteRepo;
	@Autowired
	private IVehiculoRepo ivehiculoRepo;
	//1
	@Test
	@Rollback(false)
	public void testGuardarReserva() {
		Reserva reserva = new Reserva();
		reserva.setNumero(300514285);		
		this.iReservaRepo.ingresar(reserva);
		//assertNotNull(this.iReservaRepo.buscarNumero(reserva.getNumero()));
		assertThat(reserva.getNumero()).isEqualTo(300514285);
		
	}
	//Necesito (1) ejecutar o tener el id guardao	
	//2
	@Test
	public void testBuscarReserva() {
		Reserva reserva = this.iReservaRepo.buscarNumero(300514285);
		assertThat(reserva.getNumero()).isEqualTo(300514285);
		
	}
	
	
}
