package br.ufpb.sisbula;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SisBulaMemoryTest {

	SisBulaMemory sis;
	@Before
	public void setUp() throws Exception {
		sis = new SisBulaMemory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaCadastroDeMedicamentoOK() {
		Medicamento m = new Medicamento("Novalgina");
		try {
			sis.cadastraMedicamento(m);
		} catch (Exception e){
			fail("Lançou exceção sem necessidade");
		}	
	}

	
	@Test
	public void testaCadastroDeMedicamentoOK2() {
		try {
			sis.cadastraMedicamento("Novalgina");
			Medicamento m = sis.pesquisaMedicamento("Novalgina", Fabricante.FABRICANTE_DESCONHECIDO);
			assertEquals("Novalgina", m.getNome());
			assertEquals(Fabricante.FABRICANTE_DESCONHECIDO, m.getFabricante());
		} catch (Exception e){
			fail("Lançou exceção sem necessidade");
		}	
	}

	@Test
	public void testaPesquisaDeMedicamento(){
		try {
			sis.cadastraMedicamento("Novalgina");
			Medicamento m = sis.pesquisaMedicamento("Novalgina");
			assertEquals("Novalgina", m.getNome());
			assertEquals(Fabricante.FABRICANTE_DESCONHECIDO, m.getFabricante());
		} catch (Exception e){
			fail("Lançou exceção sem necessidade");
		}
	}
	
	@Test
	public void testaCadastroDeMedicamentoDuasVezes() {
		Medicamento m = new Medicamento("Novalgina");
		try {
			sis.cadastraMedicamento(m);
		} catch (Exception e){
			fail("Lançou exceção sem necessidade");
		}	
		
		try {
			sis.cadastraMedicamento(new Medicamento("Novalgina"));
			fail("Deveria ter lançado a exceção");
		} catch (MedicamentoJaExisteException e) {
			System.out.println("Muito bem, lançou a excecao direito");
		}
	}
	
	
	@Test
	public void testeDaProva(){
		SisBula sisBula = new SisBulaMemory();
		List<Medicamento> lista = sisBula.pesquisaMedicamentosDoFabricante(Fabricante.MEDLEY);
		assertEquals(0, lista.size());
		Medicamento dip = new Medicamento("Dipirona", Fabricante.MEDLEY);
		try {
			sisBula.cadastraMedicamento(dip);
		} catch (MedicamentoJaExisteException e){
			fail("Não deveria lançar exceção. Cadastro autorizado");
		}
		List<Medicamento> lista2 = sisBula.pesquisaMedicamentosDoFabricante(Fabricante.MEDLEY);
		assertEquals(1, lista2.size());
		assertTrue(lista2.get(0).getNome().equals("Dipirona"));
		Medicamento dip2 = new Medicamento("Dipirona",Fabricante.MEDLEY);
		try {
			sisBula.cadastraMedicamento(dip2);
			fail("Deveria ter lançado a exceção");
		} catch (MedicamentoJaExisteException e2){
			System.out.println("Exceção esperada");
		}
		
	}
	
	@Test
	public void testaCadastroIndicacoesMedicamento() throws Exception {
		sis.cadastraDoenca("Zika");
		sis.cadastraMedicamento("Dipirona");
		sis.cadastraSintoma("Febre");
		sis.cadastraMedicamentoParaDoenca("Dipirona","Zika");
		sis.cadastraMedicamentoParaSintoma("Dipirona","Febre");
		List<Medicamento> remediosPraZika = sis.pesquisaMedicamentosPara("Zika");
		List<Medicamento> remediosPraFebre = sis.pesquisaMedicamentosPara("Febre");
		assertEquals(1, remediosPraZika.size());
		assertEquals(1, remediosPraFebre.size());
		Medicamento m1 = remediosPraZika.get(0);
		Medicamento m2 = remediosPraFebre.get(0);
		assertEquals("Dipirona", m1.getNome());
		assertEquals("Dipirona", m2.getNome());
		
		
		
	}
	
	
	

}
