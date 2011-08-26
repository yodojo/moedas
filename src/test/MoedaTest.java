package test;

import static org.junit.Assert.*;
import lib.Moeda;

import org.junit.Before;
import org.junit.Test;

public class MoedaTest {
	
	private Moeda moeda;
	
	@Before
	public void setUp() {
		this.moeda = new Moeda();
	}

	@Test
	public void valorDeveSerMaiorOuIgualAUmEMenorOuIgualA_50000() {		
		moeda.setPreco(234);
		assertTrue(moeda.precoValido());
		
		moeda.setPreco(0);
		assertFalse(moeda.precoValido());	
	}
	
	@Test
	public void quantidadeDeMoedasDistintasDeveSerMaiorOuIgualA_1EMenorOuIgualA_100() {
		moeda.setQuatidadeMoedaDistinta(43);
		assertTrue(moeda.quatidadeMoedaDistintasValido());
		
		moeda.setQuatidadeMoedaDistinta(123);
		assertFalse(moeda.quatidadeMoedaDistintasValido());		
	}

	@Test
	public void quantidadeDeValoresDeMoedasDeveSerIgualAMoedasDistintas(){
		moeda.setQuatidadeMoedaDistinta(3);
		moeda.setMoedas(5,10,30);
		assertTrue(moeda.quatidadeMoedasValida());
	}
	
	@Test
	public void deveRetornarONumeroMinimoDeMoedasNecessarias(){
		moeda.setPreco(125);
		moeda.setMoedas(50, 25);
		moeda.setQuatidadeMoedaDistinta(2);
		assertEquals("3", moeda.quantidadeDeMoedaNecessarias());
	}

	@Test
	public void deveRetornarImpossivel(){
		moeda.setPreco(137);
		moeda.setMoedas(50, 25);
		moeda.setQuatidadeMoedaDistinta(2);
		assertEquals("Missão Impossível", moeda.quantidadeDeMoedaNecessarias());
	}
	
}
