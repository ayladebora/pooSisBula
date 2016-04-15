package br.ufpb.sisbula;

public class MedicamentoInexistenteException extends Exception {
	public MedicamentoInexistenteException(String msg){
		super(msg);
	}

}
