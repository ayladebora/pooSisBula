package br.ufpb.sisbula;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Medicamento implements Serializable {
	private String nome;
	private Fabricante fabricante;
	private List<Medicamento> interacoesMedicamentosas;
	private List<IndicacaoMedicamento> indicacoes;
	
	public Medicamento(String nome){
		this.nome = nome;
		this.fabricante =  Fabricante.FABRICANTE_DESCONHECIDO;
		this.indicacoes = new ArrayList<IndicacaoMedicamento>();
		this.interacoesMedicamentosas = new ArrayList<Medicamento>();
	}
	
	public Medicamento(String nome, Fabricante fabricante){
		this(nome);
		this.fabricante = fabricante;
	}
	public String getId(){
		return this.nome+this.fabricante.toString();
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	public List<Medicamento> getInteracoesMedicamentosas(){
		return this.interacoesMedicamentosas;
	}
	public List<IndicacaoMedicamento> getIndicacoes(){
		return this.indicacoes;
	}
	
	public void adicionaIndicacao(IndicacaoMedicamento ind){
		this.indicacoes.add(ind);
	}
	
	public void adicionaInteracaoMedicamentosa(Medicamento m){
		this.interacoesMedicamentosas.add(m);
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public String toString(){
		return this.nome+", Fabricante:"+fabricante.toString();
	}
	
	

}
