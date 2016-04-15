package br.ufpb.sisbula;

public class MedicamentoJaExisteException extends Exception {


	private static final long serialVersionUID = 1L;

	public MedicamentoJaExisteException(String msg){
		super(msg);
	}
}
