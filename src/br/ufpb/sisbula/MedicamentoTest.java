package br.ufpb.sisbula;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MedicamentoTest {

	Medicamento med;
	
	@Before
	public void setUp() throws Exception {
		med = new Medicamento("Tylenol");
		Sintoma dorCabeca = new Sintoma("Dor de Cabeça");
		Sintoma febre = new Sintoma("Febre");
		med.adicionaIndicacao(dorCabeca);
		med.adicionaIndicacao(febre);
	}

	@After
	public void tearDown() throws Exception {
		med = null;
	}

	@Test
	public void testCriacaoMedicamento() {
		assertTrue(med.getNome().equals("Tylenol"));
		assertTrue(med.getIndicacoes().size()==2);
		assertEquals(2, med.getIndicacoes().size());
		
		assertTrue(med.getIndicacoes().get(0).getNome().equals("Dor de Cabeça")
				|| med.getIndicacoes().get(0).getNome().equals("Febre"));
	
		assertTrue(med.getIndicacoes().get(1).getNome().equals("Dor de Cabeça")
				|| med.getIndicacoes().get(1).getNome().equals("Febre"));
		
		assertFalse(med.getIndicacoes().get(0).getNome().equals(med.getIndicacoes().get(1).getNome()));
	
	
	}

}
