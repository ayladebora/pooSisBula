package br.ufpb.sisbula;

import java.io.Serializable;

public abstract class IndicacaoMedicamento implements Serializable{
	private String nome;
	
	public IndicacaoMedicamento(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}

}
