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

import visao.VisaoPainelCadastroAluno;
import controle.ControlePainelCadastros;
import modelo.Aluno;

public class ControlePainelCadastroAluno implements ActionListener{
	VisaoPainelCadastroAluno telaCadAluno;
	Aluno dados;
	private int contador;
	private int saida;
	private int volta;
	private String disciplina = "";
	private ArrayList<String> disciplinas  = new ArrayList<String>();
	private int numMatriculaAluno;
	Calendar calendario = Calendar.getInstance();
	
	public ControlePainelCadastroAluno(VisaoPainelCadastroAluno telaCadAluno, int volta) {
		this.telaCadAluno = telaCadAluno;
		this.volta = volta;
		telaCadAluno.setVisible(true);
		System.out.println("Cad Aluno");
		AddEventos();
		preecheComboBox();
		numMatriculaAluno = (calendario.get(Calendar.YEAR)*10000) + Main.aluno.size();
		telaCadAluno.getFormattedTextFieldMatriculaAluno().setText(String.valueOf(numMatriculaAluno));
		
	}

	public void troca() {
		telaCadAluno.setVisible(true);
		//((FramePrincipal) FramePrincipal.getInstance()).trocarPainel(aluno, "MINI-MUNDO");
	}

	public void AddEventos(){
		System.out.println("evt Aluno");
		telaCadAluno.getButtonCancelar().addActionListener(this);
		telaCadAluno.getButtonConfirmar().addActionListener(this);
		telaCadAluno.getButtonVoltar().addActionListener(this);
		telaCadAluno.getFormattedTextFieldMatriculaAluno().addActionListener(this);
		telaCadAluno.getFormattedTextFieldCpf().addActionListener(this);
		telaCadAluno.getFormattedTextFieldRg().addActionListener(this);
		telaCadAluno.getFormattedTextFieldNomeAluno().addActionListener(this);
		telaCadAluno.getComboBoxCurso().addActionListener(this);
		telaCadAluno.getComboBoxHistoricoDisciplinas().addActionListener(this);
		telaCadAluno.getComboBoxEstado().addActionListener(this);
		telaCadAluno.getComboBoxOrgaoExpeditor().addActionListener(this);
		telaCadAluno.getButtonAdicionarDisciplina().addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaCadAluno.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadAluno, 
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
		
		
		if(e.getSource() == telaCadAluno.getButtonCancelar()){
			try {
				saida = JOptionPane.showConfirmDialog(telaCadAluno, 
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
		if(e.getSource() == telaCadAluno.getButtonAdicionarDisciplina()) {
			try {
				System.out.println("button Add Disc");
				disciplina = JOptionPane.showInputDialog(telaCadAluno,  "Insira o nome da disciplina:", 
														 "Inserir", JOptionPane.OK_CANCEL_OPTION);
				System.out.println("la0");
			
				if(!disciplina.equals("")){
					disciplina = disciplina.toUpperCase();
					System.out.println("la1");
					System.out.println(disciplinas.size());
					if(Validacoes(disciplina, 1) == 0) {
						telaCadAluno.getComboBoxHistoricoDisciplinas().addItem(disciplina);
						disciplinas.add(disciplina);
					}else {
						System.out.println("la3");
						JOptionPane.showMessageDialog(telaCadAluno, "Nome já incluso.", 
													  "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadAluno.getButtonConfirmar()) {
			try {
				int erros = 0;
				contador = 0;
				dados = new Aluno();
				System.out.println(numMatriculaAluno);
//				System.out.println(calendario.getInstance());
//				System.out.println(calendario.get(Calendar.YEAR));
//				System.out.println(Calendar.YEAR);
//				System.out.println(Calendar.MONTH);
//				System.out.println(calendario.get(Calendar.MONTH));
				
				
				if(!telaCadAluno.getFormattedTextFieldNomeAluno().getText().equals("")) {
					dados.setNome(telaCadAluno.getFormattedTextFieldNomeAluno().getText().toUpperCase());
					contador++;
				}
				if(!telaCadAluno.getFormattedTextFieldMatriculaAluno().getText().equals("")) {
					dados.setMatricula(String.valueOf(numMatriculaAluno));
					contador++;
				}
				if(!telaCadAluno.getFormattedTextFieldCpf().getText().equals("")) {
					if(Validacoes(telaCadAluno.getFormattedTextFieldCpf().getText(), 2) > 0) {
						JOptionPane.showMessageDialog(telaCadAluno, "CPF já cadastrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros ++;
					}else {
						dados.setCpf(telaCadAluno.getFormattedTextFieldCpf().getText());
						contador++;
					}
				}
				if(!(telaCadAluno.getFormattedTextFieldRg().getText().isEmpty())
					& !(telaCadAluno.getComboBoxOrgaoExpeditor().getSelectedItem().equals("SELECIONE"))
					& !(telaCadAluno.getComboBoxEstado().getSelectedItem().equals("SELECIONE"))
				//	& !(telaCadAluno.getDateChooserData().getMinSelectableDate().toString().equals(""))) {
					) {
					String RG = telaCadAluno.getFormattedTextFieldRg().getText()+"/"
								+telaCadAluno.getComboBoxEstado().getSelectedItem().toString();
							
							
				//	String dataOrgao =telaCadAluno.getDateChooserData().getMinSelectableDate().toString()+"/"
				//					+ telaCadAluno.getComboBoxOrgaoExpeditor().getSelectedItem().toString();
					if(Validacoes(RG, 3) > 0) {
						JOptionPane.showMessageDialog(telaCadAluno, "RG e UF já cadastrados!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros ++;
					}else {
						dados.setRgUf(RG);
	//					dados.setDataExpedicaoOrgaoExp(dataOrgao);
						contador++; //entrada do orgao expeditor e do estado ao RG são considerados, ao todo, como um
					}
	//				System.out.println(telaCadAluno.getDateChooserData().getMinSelectableDate().toString());
	//				System.out.println(telaCadAluno.getDateChooserData().getMinSelectableDate());
					
				}
				if(!(telaCadAluno.getComboBoxCurso().getSelectedItem().equals("SELECIONE"))) {
					dados.setCurso(telaCadAluno.getComboBoxCurso().getSelectedItem().toString().toUpperCase());
					contador++;
				}
				if(disciplinas != null) {
					dados.setHistoricoDisciplinas(disciplinas);
					contador++;
				}
				if(contador == 6){
					Main.aluno.add(dados);
					new ControleArquivo(1);
					JOptionPane.showMessageDialog(telaCadAluno, "Cadastro realizado com sucesso.");
					LimpaDados();
				}else{
					if(erros == 0)
						JOptionPane.showMessageDialog(telaCadAluno, "Todos os campos devem ser preenchidos.", "Aviso",
								JOptionPane.WARNING_MESSAGE);
					else
						JOptionPane.showMessageDialog(telaCadAluno, "ERRO DURANTE O ARMAZENAME.", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}

			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

	}
	
	public void preecheComboBox() {
		telaCadAluno.getComboBoxCurso().addItem("SELECIONE");
		ArrayList<String> disc = new ArrayList<String>();
		String dis = null;
		
		dis = Main.disciplina.get(0).getCurso().toString();
		disc.add(dis);
		int cont;
		for(int i = 1; i < Main.disciplina.size(); i++) {
			cont = 0;
			dis = Main.disciplina.get(i).getCurso().toString();
			if(disc.get(i-1).equals(dis)) {
				cont ++;
			}
			if(cont == 0)
				disc.add(dis);
		}
		for(int i = 0; i<disc.size(); i++) {
			telaCadAluno.getComboBoxCurso().addItem(disc.get(i).toString());
		}
	}
	
	public int Validacoes(String dado, int tipo) {
		int contador = 0;
		System.out.println("la4");
		// 1 - busca disciplina
		// 2 - busca CPF
		// 3 - busca RG
		
		if(tipo == 1) {
			for(int i = 0; i < disciplinas.size(); i++) {
			//	System.out.println(disciplinas.get(i).toString());
				if(disciplinas.get(i).toString().equals(dado)) {
					contador++;
					System.out.println(contador);
				}
			}
		}else if(tipo == 2) {
			for(int i = 0; i < Main.aluno.size(); i++) {
				if(Main.aluno.get(i).getCpf().equals(dado)) {
					contador++;
				}
			}
		}else if(tipo == 3) {
			for(int i = 0; i < Main.aluno.size(); i++) {
				if(Main.aluno.get(i).getRgUf().equals(dado)) {
					contador++;
				}
			}
		}
		
		return contador;
	}
	
	public void LimpaDados() {
		numMatriculaAluno = (calendario.get(Calendar.YEAR)*10000) + Main.aluno.size();
		telaCadAluno.getFormattedTextFieldMatriculaAluno().setText(String.valueOf(numMatriculaAluno));
		telaCadAluno.getFormattedTextFieldNomeAluno().setText(null);
		telaCadAluno.getFormattedTextFieldCpf().setText(null);
		telaCadAluno.getFormattedTextFieldMatriculaAluno().setText(null);
		telaCadAluno.getFormattedTextFieldRg().setText(null);
		telaCadAluno.getComboBoxCurso().removeAllItems();
		telaCadAluno.getComboBoxEstado().setSelectedIndex(0);
		telaCadAluno.getComboBoxOrgaoExpeditor().setSelectedIndex(0);
		telaCadAluno.getComboBoxHistoricoDisciplinas().removeAllItems();
//		telaCadAluno.getDateChooserData().setDate(null);
		disciplinas.clear();
	}
}
