package br.ufpb.sisbula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SisBulaMemory implements SisBula {

	private GerenteMedicamentos gerenteMed;
	private GerenteDeDoencasESintomas gerenteDS;
	
	public SisBulaMemory() {
		this.gerenteMed = new GerenteMedicamentos();
		this.gerenteDS = new GerenteDeDoencasESintomas();
	
	}
	
	@Override
	public boolean cadastraDoenca(String nome){
		return this.gerenteDS.cadastraDoenca(nome);
	}

	@Override
	public void cadastraMedicamento(String nomeMedicamento) throws MedicamentoJaExisteException{
		gerenteMed.cadastraMedicamento(nomeMedicamento);
	}
	
	@Override
	public void cadastraMedicamento(Medicamento m) throws MedicamentoJaExisteException {
		gerenteMed.cadastraMedicamento(m);
	}

	
	@Override
	public Medicamento pesquisaMedicamento(String nome) throws MedicamentoInexistenteException{
		return gerenteMed.pesquisaMedicamento(nome);
	}

	@Override
	public Medicamento pesquisaMedicamento(String nome, 
			Fabricante fabricante) throws MedicamentoInexistenteException {
		return gerenteMed.pesquisaMedicamento(nome, fabricante);
	}
	
	@Override
	public List<Medicamento> pesquisaMedicamentosDoFabricante(Fabricante fab){
		return gerenteMed.pesquisaMedicamentosDoFabricante(fab);
	}


	@Override
	public boolean cadastraSintoma(String sintoma) {
		return gerenteDS.cadastraSintoma(sintoma);
		
	}

	@Override
	public void cadastraMedicamentoParaDoenca(String nomeMed, String nomeDoenca) throws MedicamentoInexistenteException {
		IndicacaoMedicamento indicacao = this.gerenteDS.pesquisaDoencaOuSintoma(nomeDoenca);
		if (indicacao==null){
			this.gerenteDS.cadastraDoenca(nomeDoenca);
			indicacao = this.gerenteDS.pesquisaDoencaOuSintoma(nomeDoenca);
		}
		
		this.gerenteMed.cadastraMedicamentoPara(nomeMed, indicacao);
	}

	@Override
	public void cadastraMedicamentoParaSintoma(String nomeMed, String nomeSintoma) throws MedicamentoInexistenteException {
		IndicacaoMedicamento indicacao = this.gerenteDS.pesquisaDoencaOuSintoma(nomeSintoma);
		if (indicacao==null){
			this.gerenteDS.cadastraSintoma(nomeSintoma);
			indicacao = this.gerenteDS.pesquisaDoencaOuSintoma(nomeSintoma);
		}
		
		this.gerenteMed.cadastraMedicamentoPara(nomeMed, indicacao);
	}

	@Override
	public List<Medicamento> pesquisaMedicamentosPara(String nomeDS) {
		IndicacaoMedicamento ind = this.gerenteDS.pesquisaDoencaOuSintoma(nomeDS);
		if (ind !=null){
			return this.pesquisaMedicamentosPara(ind);
		} else {
			return new ArrayList<Medicamento>();
		}
	}
	
	@Override
	public List<Medicamento> pesquisaMedicamentosPara(IndicacaoMedicamento ind) {
		return gerenteMed.pesquisaMedicamentosPara(ind);
	}


	
}
