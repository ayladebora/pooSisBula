package br.ufpb.sisbula;

public class Sintoma extends IndicacaoMedicamento{
	private String descricao;
	public Sintoma(String nome){
		super(nome);
		this.descricao = nome;
	}
	public Sintoma(String nome, String descricao){
		super(nome);
		this.descricao = descricao;
	}
	public String getDescricao(){
		return this.descricao;
	}
	public void setDescricao(String desc){
		this.descricao = desc;
	}
}
