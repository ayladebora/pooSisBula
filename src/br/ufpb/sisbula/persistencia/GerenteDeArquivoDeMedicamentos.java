package br.ufpb.sisbula.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import br.ufpb.sisbula.Medicamento;

public class GerenteDeArquivoDeMedicamentos {
	
	public static final String ARQUIVO_DEFAULT="medicamentos.txt";
	
	private String nomeArquivo;
	public GerenteDeArquivoDeMedicamentos(String nomeArquivo){
		this.nomeArquivo = nomeArquivo;
	}
	
	public GerenteDeArquivoDeMedicamentos(){
		this.nomeArquivo  = ARQUIVO_DEFAULT;
	}
		
	public void gravaMedicamentos(Collection <Medicamento> medicamentos) throws IOException{
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
			out.writeObject(medicamentos);
		} finally {
			if (out != null){
				out.close();
			}
		}
	}
	
	public Collection <Medicamento> leMedicamentos() throws  IOException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(nomeArquivo));
			return (Collection<Medicamento>)in.readObject();
		} catch (ClassNotFoundException e) {
			throw new IOException(e);
		} finally {
			if (in!=null){
				in.close();
			}
		}
	}

}
