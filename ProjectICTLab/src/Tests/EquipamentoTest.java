package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Equipamento;

public class EquipamentoTest {

	@Test
	public void testNome() {
		Equipamento equipamento = new Equipamento();
		
		equipamento.setNome("Microcontrolador");
		
		assertEquals("Microcontrolador",equipamento.getNome());
	}
	
	@Test
	public void testDescricao() {
		Equipamento equipamento = new Equipamento();
		
		equipamento.setDescricao("Controla as coisas");
		
		assertEquals("Controla as coisas",equipamento.getDescricao());
	}
	
	@Test
	public void testTombo() {
		Equipamento equipamento = new Equipamento();
		
		equipamento.setTombo("1234");
		
		assertEquals("1234",equipamento.getTombo());
	}
	
	
}
