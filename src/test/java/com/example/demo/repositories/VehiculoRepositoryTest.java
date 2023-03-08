package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.dto.VehiculoDTO;
import com.example.demo.modelo.dto.VehiculoMyMDTO;
import com.example.demo.repository.IVehiculoRepo;

import jakarta.transaction.Transactional;


@SpringBootTest
public class VehiculoRepositoryTest {

	
	@Autowired
	private IVehiculoRepo iVehiculoRepo;
	
	private static Vehiculo vehiculo1;
	private static Vehiculo vehiculo2;
	
	@BeforeAll
	public static void setup() {
		 vehiculo1 = new Vehiculo( "uass-212", "Hilux", "TOYOTA",2019,"Ecuador","2500cc",new BigDecimal(50000),
				 new BigDecimal(250),"D" ) ;
		 vehiculo2 = new Vehiculo( "ESSA-44", "Hilux", "TOYOTA",2019,"Ecuador","2900cc",new BigDecimal(50000),
				 new BigDecimal(250),"D" ) ;
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testGuardarVehiculo() {
		//Vehiculo vehiculo = new Vehiculo("uass-212", "Hilux", "TOYOTA") ;
		this.iVehiculoRepo.insertar(vehiculo2);
		this.iVehiculoRepo.insertar(vehiculo1);
		assertNotNull(this.iVehiculoRepo.buscarId(vehiculo2.getId()));;
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testActualizar() {
		
		Vehiculo v = vehiculo1;
		v.setMarca("MAZDA");
		v.setPaisFabricion("China");
		this.iVehiculoRepo.actualizar(v);
		assertEquals(vehiculo1.getMarca(), "MAZDA");
	}
	
	@Test
	@Transactional
    @Rollback(false)
	public void testBuscarDisponibilidad() {
		
		Vehiculo v= this.iVehiculoRepo.buscarId(91);
		List<Vehiculo> dispo= this.iVehiculoRepo.buscarDispo("D");
		System.out.println(dispo);
		assertTrue(dispo.contains(v));
	}
	
	@Test
	@Transactional
    @Rollback(false)
	public void testBuscarId() {
		
		Vehiculo v= this.iVehiculoRepo.buscarId(91);
		assertTrue(v!=null);
	}
	
	
	@Test
	@Transactional
    @Rollback(false)
	public void testBuscarMarca() {
	
		Vehiculo v= this.iVehiculoRepo.buscarId(92);
		List<Vehiculo> listaToyota= this.iVehiculoRepo.buscarMarca("MAZDA");

		assertTrue(listaToyota.contains(v));
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testBuscarPlaca() {
		
		Vehiculo v1= new Vehiculo("aaa", "twingo","ff");
		this.iVehiculoRepo.insertar(v1);
		Vehiculo v= this.iVehiculoRepo.buscarPlaca("aaa");
		assertTrue(v!=null);
	}
	
	@Test
	@Transactional
    @Rollback(false)
	public void testBuscarTodos() {
	
		
		List<VehiculoMyMDTO> l = this.iVehiculoRepo.buscarTodos();

		assertTrue(l.size() >0);
	}
	
	@Test
	@Transactional
    @Rollback(false)
	public void testBuscarDisponibilidadDTO() {
		

		List<VehiculoDTO> dispo= this.iVehiculoRepo.buscarVehiculoDisponible( "TOYOTA","Hilux");
		System.out.println(dispo);
		assertTrue(dispo.size()>0);
	}
}
