package controle;

/**
 *  @author Flávia de Jesus Correia
 *  @author Ian Farias
 *  
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import modelo.Professor;
import visao.VisaoPainelCadastroProfessor;

public class ControlePainelCadastroProfessor implements ActionListener{
	
	VisaoPainelCadastroProfessor telaCadProfessor;
	Professor dados;
	private int contador;
	private int saida;
	private int volta;
	private String areaAtuacao;
	private ArrayList<String> areasAtuacao = new ArrayList<String>();
	private int numMatriculaProfessor;
	Calendar calendario = Calendar.getInstance();
	
	public ControlePainelCadastroProfessor(VisaoPainelCadastroProfessor telaCadProfessor, int volta) {
		this.telaCadProfessor = telaCadProfessor;
		telaCadProfessor.setVisible(true);
		this.volta = volta;
		AddEventos();
		preencheComboBox();
		numMatriculaProfessor = (calendario.get(Calendar.YEAR)*10000) + Main.aluno.size();
		telaCadProfessor.getTextFieldMatriculaProfessor().setText(String.valueOf(numMatriculaProfessor));
	}

	public void troca() {
		telaCadProfessor.setVisible(true);
	}
	
	public void AddEventos(){
		
		telaCadProfessor.getButtonCancelar().addActionListener(this);
		telaCadProfessor.getButtonConfirmar().addActionListener(this);
		telaCadProfessor.getButtonVoltar().addActionListener(this);
		telaCadProfessor.getTextFieldNomeProfessor().addActionListener(this);
		telaCadProfessor.getTextFieldMatriculaProfessor().addActionListener(this);
		telaCadProfessor.getComboBoxAreaAtuacaoProfessor().addActionListener(this);
		telaCadProfessor.getComboBoxCargaHorariaProfessor().addActionListener(this);
		telaCadProfessor.getButtonAdicionarAreaAtuacao().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaCadProfessor.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadProfessor, 
														"Deseja realmente voltar?",
														"Confirmação de saída", 
														JOptionPane.YES_NO_OPTION);
				if(saida == 0) {
					LimpaDados();
					if(volta == 1)
						ControlePainelTelaInicial.troca();
					else
						ControlePainelCadastros.troca();
				}
				
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == telaCadProfessor.getButtonCancelar()){
			try {
				saida = JOptionPane.showConfirmDialog(telaCadProfessor, 
														"Deseja realmente cancelar o cadastro?",
														"Confirmação de saída", 
														JOptionPane.YES_NO_OPTION);
				if(saida == 0) {
					LimpaDados();
					ControlePainelCadastros.troca();
				}
				
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadProfessor.getButtonAdicionarAreaAtuacao()) {
			try {
				areaAtuacao = JOptionPane.showInputDialog(telaCadProfessor,  "Insira o nome da área:", 
						 								  "Inserir", JOptionPane.OK_CANCEL_OPTION);
				if(!areaAtuacao.isEmpty()) {
					if(Validacoes(areaAtuacao, areasAtuacao) == 0) {
						areaAtuacao = areaAtuacao.toUpperCase();
						telaCadProfessor.getComboBoxAreaAtuacaoProfessor().addItem(areaAtuacao);
						areasAtuacao.add(areaAtuacao);
					}
				}	
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadProfessor.getButtonConfirmar()) {
			try {
				contador = 0;
				if(!telaCadProfessor.getTextFieldNomeProfessor().getText().isEmpty()) {
					dados.setNome(telaCadProfessor.getTextFieldNomeProfessor().getText().toUpperCase());
					contador++;
				}
				if(!telaCadProfessor.getTextFieldMatriculaProfessor().getText().isEmpty()) {
					dados.setMatricula(String.valueOf(numMatriculaProfessor));
					contador++;
				}
				if(!telaCadProfessor.getComboBoxAreaAtuacaoProfessor().getSelectedItem().equals("SELECIONE")) {
					dados.setArea(telaCadProfessor.getComboBoxAreaAtuacaoProfessor().getSelectedItem().toString().toUpperCase());
					contador++;
				}
				if(!telaCadProfessor.getComboBoxCargaHorariaProfessor().getSelectedItem().equals("SELECIONE")) {
					dados.setCarga_Horaria(telaCadProfessor.getComboBoxCargaHorariaProfessor().getSelectedItem().toString().toUpperCase());
					contador++;
				}
				if(contador == 4) {
					Main.professor.add(dados);
			//		new ControleArquivo(5);
					JOptionPane.showMessageDialog(telaCadProfessor, "Cadastro realizado com sucesso.");
					LimpaDados();
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", 
												"Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
	}
	
	public int Validacoes(String nome, ArrayList<String> dados) {
		int contador = 0;
		System.out.println("la4");
		for(int i = 0; i < dados.size(); i++) {
			System.out.println(dados.get(i).toString());
			if(dados.get(i).toString().equals(nome)) {
				contador += 1;
				System.out.println(contador);
			}
		}
		return contador;
	}
	
	public void preencheComboBox() {
		areasAtuacao.add("CIÊNCIAS EXATAS");
		areasAtuacao.add("CIÊNCIAS HUMANAS");
		areasAtuacao.add("CIÊNCIAS DA TERRA");
		areasAtuacao.add("CIÊNCIAS BIOLÓGICAS");
		areasAtuacao.add("CIÊNCIAS SOCIAIS");
		areasAtuacao.add("CIÊNCIAS NATURAIS");
		areasAtuacao.add("CIÊNCIAS POLÍTICAS");
		areasAtuacao.add("ADMINISTRAÇÃO");
		areasAtuacao.add("PSICOLOGIA");
		areasAtuacao.add("REDES DE COMPUTADORES");
		
		for(int i = 0; i<areasAtuacao.size(); i++) {
			telaCadProfessor.getComboBoxAreaAtuacaoProfessor().addItem(areasAtuacao.get(i).toString());
		}
	}
	
	public void LimpaDados() {
		telaCadProfessor.getTextFieldNomeProfessor().setText(null);
		telaCadProfessor.getTextFieldMatriculaProfessor().setText(null);
		telaCadProfessor.getComboBoxAreaAtuacaoProfessor().setSelectedIndex(0);
		telaCadProfessor.getComboBoxCargaHorariaProfessor().setSelectedIndex(0);
	}
}
