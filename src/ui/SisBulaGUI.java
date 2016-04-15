package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.ufpb.sisbula.Fabricante;
import br.ufpb.sisbula.Medicamento;
import br.ufpb.sisbula.MedicamentoInexistenteException;
import br.ufpb.sisbula.MedicamentoJaExisteException;
import br.ufpb.sisbula.SisBula;
import br.ufpb.sisbula.SisBulaMemory;

/**
 * Classe representando uma interface gráfica com Menu para o sistema SisBula
 * Observação: Código baseado no Exemplo 8.2 do livro Java 7 Ensino Didático
 */

public class SisBulaGUI extends JFrame {
	
	private SisBula sisBula;
	private Container painelDeConteudo;
	private JMenuBar barraDeMenu;
	private JMenu medicamentoMenu, creditosMenu;
	private JMenuItem cadastraMed, pesquisaMed, creditos;
	
	
	public SisBulaGUI(SisBula sis){
		this.sisBula = sis;
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes(){
		setTitle("SisBula");
		setBounds(0,0,800,600);
		painelDeConteudo = getContentPane();
		barraDeMenu = new JMenuBar();
		medicamentoMenu = new JMenu("Medicamento");
		creditosMenu = new JMenu("Creditos");
		barraDeMenu.add(medicamentoMenu);
		barraDeMenu.add(creditosMenu);
		cadastraMed = new JMenuItem("Cadastrar medicamento");
		pesquisaMed = new JMenuItem("Pesquisar medicamento");
		medicamentoMenu.add(cadastraMed);
		medicamentoMenu.add(pesquisaMed);
		creditos = new JMenuItem("Créditos");
		creditosMenu.add(creditos);
		setJMenuBar(barraDeMenu);
	}
	
	
	
	private void definirEventos(){
		cadastraMed.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Medicamento m = leDadosMedicamento();
				try {
					sisBula.cadastraMedicamento(m);
					JOptionPane.showMessageDialog(painelDeConteudo, "Cadastro efetuado com sucesso");
				} catch (MedicamentoJaExisteException e1) {
					JOptionPane.showMessageDialog(painelDeConteudo, e1.getMessage());
				}
			}
		});
		pesquisaMed.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String nome = JOptionPane.showInputDialog("Qual o nome do medicamento a pesquisar?");
				Fabricante fab = leFabricante();
				try {
					Medicamento m  = sisBula.pesquisaMedicamento(nome, fab);
					JOptionPane.showMessageDialog(painelDeConteudo, "Medicamento encontrado:"+m.toString());
				} catch (MedicamentoInexistenteException e1) {
					JOptionPane.showMessageDialog(painelDeConteudo, e1.getMessage());
				}
			}
		});
		
		creditos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(painelDeConteudo, "Sistema feito para aula de POO de Ayla com base no exemplo 8.2 do livro Java 7 Ensino Didático");
			}
		});
		
		
	}

	
	private Medicamento leDadosMedicamento() {
		String nome = JOptionPane.showInputDialog("Qual o nome do medicamento?");
		Fabricante fabricante = leFabricante();
		return new Medicamento(nome,fabricante);
	}
	
	private Fabricante leFabricante(){
		String fabricante = JOptionPane.showInputDialog("Qual o fabricante?");
		if (fabricante.equalsIgnoreCase("MEDLEY")){
			return Fabricante.MEDLEY;
		} else if (fabricante.equalsIgnoreCase("EMS")){
			return Fabricante.EMS;
		} else if (fabricante.equalsIgnoreCase("EUROFARMA")){
			return Fabricante.EUROFARMA;
		} else {
			return Fabricante.FABRICANTE_DESCONHECIDO;
		}
	}
	
	public static void main(String [] args){
		SisBula sis = new SisBulaMemory();
		SisBulaGUI janelaPrincipal = new SisBulaGUI(sis);
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.setVisible(true);
	}
}
