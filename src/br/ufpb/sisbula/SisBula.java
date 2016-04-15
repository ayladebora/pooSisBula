package br.ufpb.sisbula;

import java.util.List;

/**
 * Descreve as funcionalidades de um sistema de informações
 * sobre medicamentos
 * 
 * @author ayla
 *
 */
public interface SisBula {
	/**
	 * Cadastra um novo medicamento no sistema 
	 * @param m O novo medicamento a ser cadastrado.
	 * @throws MedicamentoJaExisteException Quando já existe
	 * um medicamento com o mesmo nome do medicamento a ser
	 * cadastrado.
	 */
	public void cadastraMedicamento(Medicamento m) throws MedicamentoJaExisteException;
	
	/**
	 * Retorna uma lista dos medicamentos indicados para certas
	 * doenças ou sintomas. 
	 * @param ind Um sintoma ou doença
	 * @return a lista dos medicamentos para o sintoma
	 * ou doença pesquisado
	 */
	public List<Medicamento> pesquisaMedicamentosPara(IndicacaoMedicamento ind);

	public Medicamento pesquisaMedicamento(String nome, Fabricante fabricante) throws MedicamentoInexistenteException;

	public void cadastraMedicamentoParaSintoma(String nomeMed, String nomeSintoma) throws MedicamentoInexistenteException;

	public void cadastraMedicamentoParaDoenca(String nomeMed, String nomeDoenca) throws MedicamentoInexistenteException;

	public boolean cadastraSintoma(String sintoma);

	public List<Medicamento> pesquisaMedicamentosDoFabricante(Fabricante fab);

	public Medicamento pesquisaMedicamento(String nome) throws MedicamentoInexistenteException;

	public void cadastraMedicamento(String nomeMedicamento) throws MedicamentoJaExisteException;

	public boolean cadastraDoenca(String nome);

	public List<Medicamento> pesquisaMedicamentosPara(String nomeDS);
}
