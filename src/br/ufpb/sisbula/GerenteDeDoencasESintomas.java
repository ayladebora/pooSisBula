package br.ufpb.sisbula;

import java.util.HashMap;
import java.util.Map;

/**
 * Gerencia operações referentes a doenças e sintomas.
 * @author ayla
 *
 */
public class GerenteDeDoencasESintomas {
	private Map<String, Sintoma> sintomas;
	private Map<String, Doenca> doencas;
	
	/**
	 * Construtor da classe
	 */
	public GerenteDeDoencasESintomas(){
		this.sintomas = new HashMap<String,Sintoma>();
		this.doencas = new HashMap<String, Doenca>();
	}
	
	/**
	 * Cadastra uma doença com este nome.
	 * @param nomeDoenca O nome da doença a ser cadastrada
	 * @return true se conseguiu cadastrar e false, caso
	 * já exista uma doença com o mesmo nome.
	 */
	public boolean cadastraDoenca(String nomeDoenca){
		if (this.doencas.containsKey(nomeDoenca)){
			return false;
		} else {
			Doenca d = new Doenca(nomeDoenca);
			this.doencas.put(nomeDoenca, d);
			return true;
		}
		
	}
	
	/**
	 * Cadastra um sintoma
	 * @param nomeSintoma O nome do sintoma
	 * @return true se o sintoma for cadastrado e false,
	 * se não for cadastrado por já existir
	 */
	public boolean cadastraSintoma(String nomeSintoma) {
		Sintoma s = this.sintomas.get(nomeSintoma);
		if (s==null){
			s = new Sintoma(nomeSintoma);
			this.sintomas.put(nomeSintoma, s);
			return true;
		} else {
			return false;
		}
			
		
	}

	/**
	 * Pesquisa se existe uma doença ou sintoma com este nome.
	 * @param nomeDS o nome da doença ou sintoma
	 * @return a doença ou sintoma cadastrada que tenha esse nome
	 * ou null caso não encontre nem doença nem sintoma com esse nome.
	 */
	public IndicacaoMedicamento pesquisaDoencaOuSintoma(String nomeDS) {
		IndicacaoMedicamento ind = this.doencas.get(nomeDS);
		if (ind == null){
			ind = this.sintomas.get(nomeDS);
			return ind;
		} else {
			return ind;
		}
	}
}
