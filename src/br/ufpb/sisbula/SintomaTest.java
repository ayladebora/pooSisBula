package br.ufpb.sisbula;

import static org.junit.Assert.*;

import org.junit.Test;

public class SintomaTest {

	@Test
	public void testaCriacaoSintomaSemDescricao() {
		Sintoma sint = new Sintoma("febre");
		assertTrue(sint.getNome().equals("febre"));
		//assertTrue(sint.getDescricao().equals("febre"));
		assertEquals("febre", sint.getDescricao());
	}

	@Test
	public void testaCriacaoSintomaComDescricao() {
		Sintoma sint = new Sintoma("febre","temperatura corporal acima de 37 graus");
		assertTrue(sint.getNome().equals("febre"));
		assertEquals("temperatura corporal acima de 37 graus", sint.getDescricao());
	}

}
