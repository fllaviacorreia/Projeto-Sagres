package controle;

/**
 *  @author Flávia de Jesus Correia
 *  @author Ian Farias
 *  
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Disciplina;
import visao.VisaoPainelCadastroAluno;
import visao.VisaoPainelCadastroClasse;
import visao.VisaoPainelCadastroCurso;
import visao.VisaoPainelCadastroDisciplina;

public class ControlePainelCadastroDisciplina implements ActionListener{
	Disciplina dados;
	VisaoPainelCadastroDisciplina telaCadDisciplina;
	
	private String areaDisciplina = "";
	private String nomeCurso = "";
	private String preRequisito = "";
	private ArrayList<String> areasDisciplina = new ArrayList<String>();
	private ArrayList<String>  nomesCurso = new ArrayList<String>();
	private ArrayList<String>  preRequisitos = new ArrayList<String>();
	private int semestre = 0;
	private int contador;
	private int saida;
	private int volta;
	
	public ControlePainelCadastroDisciplina(VisaoPainelCadastroDisciplina telaCadDisciplina, int volta) {
		this.telaCadDisciplina = telaCadDisciplina;
		telaCadDisciplina.setVisible(true);
		this.volta = volta;
		preenche();
		AddEventos();
	}
	
	public void AddEventos() {
		telaCadDisciplina.getRadioButtonPreRequisitos().addActionListener(this);
		telaCadDisciplina.getRadioButtonTeorica().addActionListener(this);
		telaCadDisciplina.getRadioButtonPratica().addActionListener(this);
		telaCadDisciplina.getRadioButtonEstagio().addActionListener(this);
		telaCadDisciplina.getButtonAdicionarAreaDisciplina().addActionListener(this);
		telaCadDisciplina.getButtonAdicionarCurso().addActionListener(this);
		telaCadDisciplina.getButtonAdicionarPreRequisitos().addActionListener(this);
		telaCadDisciplina.getButtonAdicionarSemestre().addActionListener(this);
		telaCadDisciplina.getButtonVoltar().addActionListener(this);
		telaCadDisciplina.getButtonCancelar().addActionListener(this);
		telaCadDisciplina.getButtonConfirmar().addActionListener(this);
		telaCadDisciplina.getRadioButtonEPreRequisito().addActionListener(this);
		telaCadDisciplina.getRadioButtonOptativa().addActionListener(this);
		telaCadDisciplina.getRadioButtonObrigatoria().addActionListener(this);
	}

	public void troca() {
		telaCadDisciplina.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaCadDisciplina.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadDisciplina, 
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
		
		if(e.getSource() == telaCadDisciplina.getButtonCancelar()){
			try {
				saida = JOptionPane.showConfirmDialog(telaCadDisciplina, 
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
		
		if(e.getSource() == telaCadDisciplina.getRadioButtonPreRequisitos()) {
			if(telaCadDisciplina.getRadioButtonPreRequisitos().isSelected()) {
				telaCadDisciplina.getButtonAdicionarPreRequisitos().setEnabled(true);
				telaCadDisciplina.getComboBoxPreRequisitos().setEnabled(true);
			}
			
			else{
				telaCadDisciplina.getButtonAdicionarPreRequisitos().setEnabled(false);
				telaCadDisciplina.getComboBoxPreRequisitos().setEnabled(false);
				telaCadDisciplina.getComboBoxPreRequisitos().removeAllItems();
				preRequisitos.clear();
			}
			
		}
		
		if(e.getSource() == telaCadDisciplina.getRadioButtonOptativa()) {
			if(telaCadDisciplina.getRadioButtonOptativa().isSelected()) {
				telaCadDisciplina.getRadioButtonObrigatoria().setSelected(false);
				telaCadDisciplina.getRadioButtonObrigatoria().setEnabled(false);
				telaCadDisciplina.getRadioButtonEPreRequisito().setSelected(false);
				telaCadDisciplina.getRadioButtonEPreRequisito().setEnabled(false);
			}
			else{
				telaCadDisciplina.getRadioButtonObrigatoria().setSelected(false);
				telaCadDisciplina.getRadioButtonObrigatoria().setEnabled(true);
				telaCadDisciplina.getRadioButtonEPreRequisito().setSelected(false);
				telaCadDisciplina.getRadioButtonEPreRequisito().setEnabled(true);
			}
		}
		
		if(e.getSource() == telaCadDisciplina.getRadioButtonObrigatoria()) {
			if(telaCadDisciplina.getRadioButtonObrigatoria().isSelected()) {
				telaCadDisciplina.getRadioButtonOptativa().setSelected(false);
				telaCadDisciplina.getRadioButtonOptativa().setEnabled(false);
			}else{
				telaCadDisciplina.getRadioButtonOptativa().setSelected(false);
				telaCadDisciplina.getRadioButtonOptativa().setEnabled(true);
			}
			
		}
		if(e.getSource() == telaCadDisciplina.getRadioButtonEPreRequisito()) {
			if(telaCadDisciplina.getRadioButtonEPreRequisito().isSelected()) {
				telaCadDisciplina.getRadioButtonObrigatoria().setSelected(true);
				telaCadDisciplina.getRadioButtonOptativa().setSelected(false);
				telaCadDisciplina.getRadioButtonOptativa().setEnabled(false);
			}else{
				telaCadDisciplina.getRadioButtonObrigatoria().setSelected(false);
				telaCadDisciplina.getRadioButtonOptativa().setSelected(false);
				telaCadDisciplina.getRadioButtonOptativa().setEnabled(true);
			}
			
		}
		if(e.getSource() == telaCadDisciplina.getButtonAdicionarAreaDisciplina()){
			try {
				areaDisciplina = JOptionPane.showInputDialog(telaCadDisciplina, "Insira o nome da área:", 
																"Inserir", JOptionPane.OK_CANCEL_OPTION);
				if(!areaDisciplina.equals("")) {
					areaDisciplina = areaDisciplina.toUpperCase();
					if(Validacoes(areaDisciplina, areasDisciplina) == 0) {	
						areasDisciplina.add(areaDisciplina);
						System.out.println(areasDisciplina);
						telaCadDisciplina.getComboBoxAreaDisciplina().addItem(areaDisciplina);
					}else {
						System.out.println("la3");
						JOptionPane.showMessageDialog(telaCadDisciplina, "Nome já incluso.", 
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == telaCadDisciplina.getButtonAdicionarCurso()){
			try {
				nomeCurso = JOptionPane.showInputDialog(telaCadDisciplina, "Insira o nome do curso:", 
																"Inserir", JOptionPane.OK_CANCEL_OPTION);
				if(!nomeCurso.equals("")) {
					nomeCurso = nomeCurso.toUpperCase();
					if(Validacoes(nomeCurso, nomesCurso) == 0) {	
						nomesCurso.add(nomeCurso);
						telaCadDisciplina.getComboBoxCurso().addItem(nomeCurso);
					}else{
						System.out.println("la3");
						JOptionPane.showMessageDialog(telaCadDisciplina, "Nome já incluso.", 
									"Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadDisciplina.getButtonAdicionarPreRequisitos()){
				try {
					preRequisito = JOptionPane.showInputDialog(telaCadDisciplina, "Insira o pré-requisito:", 
																	"Inserir", JOptionPane.OK_CANCEL_OPTION);
					if(!preRequisito.isEmpty()) {
						preRequisito = preRequisito.toUpperCase();
						if(Validacoes(preRequisito, preRequisitos) == 0) {	
							preRequisitos.add(preRequisito);
							telaCadDisciplina.getComboBoxPreRequisitos().addItem(preRequisito);
						}else {
							System.out.println("la3");
							JOptionPane.showMessageDialog(telaCadDisciplina, "Nome já incluso.", 
									"Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
		}
			
		if(e.getSource() == telaCadDisciplina.getButtonAdicionarSemestre()){
			try {
				semestre = Integer.parseInt(JOptionPane.showInputDialog(telaCadDisciplina, "Insira o semestre:", 
																"Inserir", JOptionPane.OK_CANCEL_OPTION));
				if(!String.valueOf(semestre).isEmpty()) {
					telaCadDisciplina.getComboBoxSemestre().addItem(String.valueOf(semestre));
				}
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == telaCadDisciplina.getButtonConfirmar()) {
			
			try {
				int erros = 0;
				dados = new Disciplina();
				contador = 0;
				if(!telaCadDisciplina.getComboBoxAreaDisciplina().getSelectedItem().equals("SELECIONE")) {
					dados.setArea_Disciplina(telaCadDisciplina.getComboBoxAreaDisciplina().getSelectedItem().toString());
					contador++;
				}
				if(!telaCadDisciplina.getComboBoxCargaHoraria().getSelectedItem().equals("SELECIONE")) {
					dados.setCarga_Horaria(telaCadDisciplina.getComboBoxCargaHoraria().getSelectedItem().toString());
					contador++;
				}
				if(!telaCadDisciplina.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
					dados.setCurso(telaCadDisciplina.getComboBoxCurso().getSelectedItem().toString());
					contador++;
				}
				if(!telaCadDisciplina.getComboBoxSemestre().getSelectedItem().equals("SELECIONE")) {
					dados.setSemestre(telaCadDisciplina.getComboBoxSemestre().getSelectedItem().toString());
					contador++;
				}
				if(!telaCadDisciplina.getTextFieldNomeDisciplina().getText().equals("")) {
					ControleArquivo dado = new ControleArquivo(0); 
					if(!telaCadDisciplina.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
						String disciplina = dado.TiraEspaços(telaCadDisciplina.getTextFieldNomeDisciplina().getText().toString());
						String curso = dado.TiraEspaços(telaCadDisciplina.getComboBoxCurso().getSelectedItem().toString());
						disciplina = disciplina.toUpperCase();
						curso = curso.toUpperCase();
						
						System.out.println(disciplina);
						System.out.println(curso);
						
						if(ValidaNomeDisciplina(disciplina, curso) == 0) {
							dados.setNome_Disciplina(telaCadDisciplina.getTextFieldNomeDisciplina().getText().toUpperCase());
							contador++;
						}
						else {
							JOptionPane.showMessageDialog(telaCadDisciplina, "Disciplina com mesmo nome e curso já cadastrado.", 
															"Aviso", JOptionPane.ERROR_MESSAGE);
							erros = 0;
						}
					}else {
						
							JOptionPane.showMessageDialog(telaCadDisciplina, "Selecione o curso.", 
															"Aviso", JOptionPane.ERROR_MESSAGE);
							
					}
					
				}
				if(telaCadDisciplina.getRadioButtonOptativa().isSelected()) {
					contador++;
					dados.setOptativa(telaCadDisciplina.getRadioButtonOptativa().isSelected());
				}
				else if(telaCadDisciplina.getRadioButtonObrigatoria().isSelected()) {
					contador++;
					dados.setObrigatoria(telaCadDisciplina.getRadioButtonObrigatoria().isSelected());
				}else {
					JOptionPane.showMessageDialog(telaCadDisciplina, "Indique se a disciplina é optativa ou obrigatória.", 
							"Aviso", JOptionPane.ERROR_MESSAGE);
				}
				
				dados.setPreRequisitos(preRequisitos);
				dados.setEPreRequisito(telaCadDisciplina.getRadioButtonEPreRequisito().isSelected());
				dados.setTeorica(telaCadDisciplina.getRadioButtonTeorica().isSelected());
				dados.setPratica(telaCadDisciplina.getRadioButtonPratica().isSelected());
				dados.setEstagio(telaCadDisciplina.getRadioButtonEstagio().isSelected());
				
				if(contador == 6) {
					Main.disciplina.add(dados);
					new ControleArquivo(4);
					JOptionPane.showMessageDialog(telaCadDisciplina, "Cadastro realizado com sucesso.");
					LimpaDados();
					preenche();
				}else {
					if(contador != 6)
						JOptionPane.showMessageDialog(telaCadDisciplina, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", 
														"Aviso", JOptionPane.WARNING_MESSAGE);
					else if(erros == 1)
						JOptionPane.showMessageDialog(telaCadDisciplina, "ERRO DURANTE O CADASTRO.", 
								"Aviso", JOptionPane.WARNING_MESSAGE);
										
				}
			
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
	}
	
	public int ValidaNomeDisciplina(String nome, String curso) {
		int contador = 0;
		for(int i = 0; i < Main.disciplina.size(); i++) {
			if(Main.disciplina.get(i).getNome_Disciplina().equals(nome) 
				&& Main.disciplina.get(i).getCurso().equals(curso)){
				contador += 1;
				System.out.println(contador);
			}
		}
		return contador;
	}
	
	public int Validacoes(String nome, ArrayList<String> dados) {
		int contador = 0;
		for(int i = 0; i < dados.size(); i++) {
			if(dados.get(i).toString().equals(nome)) {
				contador += 1;
				System.out.println(contador);
			}
		}
		return contador;
	}
	
	public void preenche() {
		telaCadDisciplina.getComboBoxCurso().addItem("SELECIONE");
		telaCadDisciplina.getComboBoxAreaDisciplina().addItem("SELECIONE");
		int i = 0;
		for(i = 0; i<Main.disciplina.size(); i++) {
			if(Validacoes(Main.disciplina.get(i).getArea_Disciplina().toString(), areasDisciplina) == 0) {
				areasDisciplina.add(Main.disciplina.get(i).getArea_Disciplina());
			}
				
			if(Validacoes(Main.disciplina.get(i).getCurso().toString(), nomesCurso) == 0) {
				nomesCurso.add(Main.disciplina.get(i).getCurso().toString());
			}	
		}
		i = 0;
		int j = 0;
		while((i < nomesCurso.size()) && (j < areasDisciplina.size())) {
			telaCadDisciplina.getComboBoxAreaDisciplina().addItem(areasDisciplina.get(j).toString());
			telaCadDisciplina.getComboBoxCurso().addItem(nomesCurso.get(i).toString());
			i++;
			j++;
		}
		
	}
	
	public void LimpaDados() {
		telaCadDisciplina.getComboBoxAreaDisciplina().removeAllItems();
		telaCadDisciplina.getComboBoxCargaHoraria().setSelectedIndex(0);
		telaCadDisciplina.getComboBoxCurso().removeAllItems();
		telaCadDisciplina.getComboBoxPreRequisitos().removeAllItems();
		telaCadDisciplina.getComboBoxSemestre().setSelectedIndex(0);
		telaCadDisciplina.getTextFieldNomeDisciplina().setText(null);
		telaCadDisciplina.getRadioButtonPratica().setSelected(false);
		telaCadDisciplina.getRadioButtonEstagio().setSelected(false);
		telaCadDisciplina.getRadioButtonEPreRequisito().setSelected(false);
		telaCadDisciplina.getRadioButtonObrigatoria().setSelected(false);
		telaCadDisciplina.getRadioButtonOptativa().setSelected(false);
		preRequisitos.clear();
	}
}
