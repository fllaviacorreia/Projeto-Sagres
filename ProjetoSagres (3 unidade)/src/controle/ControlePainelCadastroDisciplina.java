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

import banco.Banco;
import banco.BancoCursoGerenciar;
import banco.BancoDisciplinaGerenciar;
import modelo.Arquivo;
import modelo.Disciplina;
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
//	private int semestreInserido;
	private int contador;
	private int saida;
	private int volta;
	private String  nome_Disciplina;
	private String  semestre;
	private String 	carga_Horaria;
	private boolean ePreRequisito;
	private boolean optativa;
	private boolean obrigatoria;
	private boolean teorica;
	private boolean pratica;
	private boolean estagio;
	
	public ControlePainelCadastroDisciplina(VisaoPainelCadastroDisciplina telaCadDisciplina, int volta) {
		this.telaCadDisciplina = telaCadDisciplina;
		this.telaCadDisciplina.setVisible(true);
		this.volta = volta;
		preenche();
		AddEventos();
	}

	public void AddEventos() {
		telaCadDisciplina.getComboBoxAreaDisciplina().setEnabled(false);
		telaCadDisciplina.getComboBoxCargaHoraria().setEnabled(false);
		telaCadDisciplina.getComboBoxSemestre().setEnabled(false);
		telaCadDisciplina.getRadioButtonEPreRequisito().setEnabled(false);
		telaCadDisciplina.getRadioButtonEstagio().setEnabled(false);
		telaCadDisciplina.getRadioButtonObrigatoria().setEnabled(false);
		telaCadDisciplina.getRadioButtonOptativa().setEnabled(false);
		telaCadDisciplina.getRadioButtonPratica().setEnabled(false);
		telaCadDisciplina.getRadioButtonPreRequisitos().setEnabled(false);
		telaCadDisciplina.getButtonAdicionarAreaDisciplina().setEnabled(false);
		telaCadDisciplina.getTextFieldNomeDisciplina().setEnabled(false);
		telaCadDisciplina.getRadioButtonPreRequisitos().addActionListener(this);
		telaCadDisciplina.getRadioButtonTeorica().addActionListener(this);
		telaCadDisciplina.getRadioButtonPratica().addActionListener(this);
		telaCadDisciplina.getRadioButtonEstagio().addActionListener(this);
		telaCadDisciplina.getButtonAdicionarAreaDisciplina().addActionListener(this);
//		telaCadDisciplina.getButtonAdicionarCurso().addActionListener(this);
		telaCadDisciplina.getButtonAdicionarPreRequisitos().addActionListener(this);
//		telaCadDisciplina.getButtonAdicionarSemestre().addActionListener(this);
		telaCadDisciplina.getButtonVoltar().addActionListener(this);
		telaCadDisciplina.getButtonCancelar().addActionListener(this);
		telaCadDisciplina.getButtonConfirmar().addActionListener(this);
		telaCadDisciplina.getRadioButtonEPreRequisito().addActionListener(this);
		telaCadDisciplina.getRadioButtonOptativa().addActionListener(this);
		telaCadDisciplina.getRadioButtonObrigatoria().addActionListener(this);
		telaCadDisciplina.getComboBoxCurso().addActionListener(this);
		telaCadDisciplina.getComboBoxSemestre().addActionListener(this);
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
					else if(volta == 2)
						ControlePainelCadastro.troca();
					else
						ControlePainelConsulta.troca();
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
					ControlePainelCadastro.troca();
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
						telaCadDisciplina.getComboBoxAreaDisciplina().addItem(areaDisciplina);
						telaCadDisciplina.getComboBoxAreaDisciplina().setSelectedItem(areaDisciplina);
					}else {
						JOptionPane.showMessageDialog(telaCadDisciplina, "Nome já incluso.", 
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == telaCadDisciplina.getComboBoxCurso()){
			try {
				if(!telaCadDisciplina.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
					int semestres = Integer.parseInt(new Banco().consultar("curso", "nomeCurso", 
							telaCadDisciplina.getComboBoxCurso().getSelectedItem().toString(), "quantidadeSemestres"));
					for(int i = 1; i <= semestres; i++) {
						telaCadDisciplina.getComboBoxSemestre().addItem(String.valueOf(i));
					}
					telaCadDisciplina.getComboBoxCurso().setEnabled(false);
					telaCadDisciplina.getComboBoxAreaDisciplina().setEnabled(true);
					telaCadDisciplina.getComboBoxCargaHoraria().setEnabled(true);
					telaCadDisciplina.getComboBoxSemestre().setEnabled(true);
					telaCadDisciplina.getRadioButtonEPreRequisito().setEnabled(true);
					telaCadDisciplina.getRadioButtonEstagio().setEnabled(true);
					telaCadDisciplina.getRadioButtonObrigatoria().setEnabled(true);
					telaCadDisciplina.getRadioButtonOptativa().setEnabled(true);
					telaCadDisciplina.getRadioButtonPratica().setEnabled(true);
					telaCadDisciplina.getRadioButtonPreRequisitos().setEnabled(true);
					telaCadDisciplina.getButtonAdicionarAreaDisciplina().setEnabled(true);
					telaCadDisciplina.getTextFieldNomeDisciplina().setEnabled(true);
				}
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadDisciplina.getComboBoxSemestre()){
			try {
				if(!(telaCadDisciplina.getComboBoxSemestre().getSelectedItem().equals("SELECIONE"))) {
					if(telaCadDisciplina.getComboBoxSemestre().getSelectedItem().equals("1")) {
						telaCadDisciplina.getRadioButtonPreRequisitos().setEnabled(false);
						telaCadDisciplina.getButtonAdicionarPreRequisitos().setEnabled(false);
						telaCadDisciplina.getComboBoxPreRequisitos().setEnabled(false);
						telaCadDisciplina.getComboBoxPreRequisitos().removeAllItems();
						preRequisitos.clear();
					}else {
						telaCadDisciplina.getRadioButtonPreRequisitos().setEnabled(true);
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
						System.out.println("pre requisito " + preRequisito);
						int consulta = Integer.parseInt(new BancoDisciplinaGerenciar().consultar("Disciplina", "nomeDisciplina", preRequisito, "Curso_idCurso"));
						System.out.println("int consulta "+ consulta);
						String consulta1 = new BancoCursoGerenciar().consultar("idCurso", String.valueOf(consulta), "nomeCurso");
						System.out.println("String consulta "+ consulta1);
						if(consulta1.equals(telaCadDisciplina.getComboBoxCurso().getSelectedItem())) {
							if(Validacoes(preRequisito, preRequisitos) == 0) {	
								preRequisitos.add(preRequisito);
								telaCadDisciplina.getComboBoxPreRequisitos().addItem(preRequisito);
							}else {
								JOptionPane.showMessageDialog(telaCadDisciplina, "Nome já incluso.", 
										"Erro", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(telaCadDisciplina, "Disciplina cadastrada em outro curso, não no curso escolhido. "
									+ "\nInsira somente disciplinas do curso escolhido.", 
									"Erro", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
		}
			
//		if(e.getSource() == telaCadDisciplina.getButtonAdicionarSemestre()){
//			try {
//				semestreInserido = Integer.parseInt(JOptionPane.showInputDialog(telaCadDisciplina, "Insira o semestre:", 
//																"Inserir", JOptionPane.OK_CANCEL_OPTION));
//				if(!String.valueOf(semestreInserido).isEmpty()) {
//					telaCadDisciplina.getComboBoxSemestre().addItem(String.valueOf(semestreInserido));
//				}
//			}catch (Exception e1) {
//				JOptionPane.showMessageDialog(telaCadDisciplina, "Valor inserido não aceito.", 
//						"Erro", JOptionPane.ERROR_MESSAGE);
//				System.out.println(e1.getMessage());
//				e1.printStackTrace();
//			}
//		}
		
		if(e.getSource() == telaCadDisciplina.getButtonConfirmar()) {
			
			try {
				int erros = 0;
				
				contador = 0;
				if(!telaCadDisciplina.getComboBoxAreaDisciplina().getSelectedItem().equals("SELECIONE")) {
					areaDisciplina = telaCadDisciplina.getComboBoxAreaDisciplina().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadDisciplina, "Campo Área não selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros ++;
				}	
				if(!telaCadDisciplina.getComboBoxCargaHoraria().getSelectedItem().equals("SELECIONE")) {
					carga_Horaria = telaCadDisciplina.getComboBoxCargaHoraria().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadDisciplina, "Campo Carga Horária não selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros ++;
				}	
				if(!telaCadDisciplina.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
					nomeCurso = telaCadDisciplina.getComboBoxCurso().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadDisciplina, "Campo Curso não selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros ++;
				}	
				if(!telaCadDisciplina.getComboBoxSemestre().getSelectedItem().equals("SELECIONE")) {
					semestre = telaCadDisciplina.getComboBoxSemestre().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadDisciplina,  "Campo Semestre não selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros ++;
				}	
				if(!telaCadDisciplina.getTextFieldNomeDisciplina().getText().equals("")) {
					Arquivo dado = new Arquivo(0); 
					if(!telaCadDisciplina.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
						nome_Disciplina = dado.TiraEspaços(telaCadDisciplina.getTextFieldNomeDisciplina().getText().toString());
						nome_Disciplina = nome_Disciplina.toUpperCase();
						if(ValidaNomeDisciplina(nome_Disciplina,  nomeCurso) == 0) {
							contador++;
						}else {
							JOptionPane.showMessageDialog(telaCadDisciplina, "Disciplina com mesmo nome e curso já cadastrados.", 
															"Aviso", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						
							JOptionPane.showMessageDialog(telaCadDisciplina, "Selecione o curso.", 
															"Aviso", JOptionPane.ERROR_MESSAGE);
							
					}
					
				}else {
					JOptionPane.showMessageDialog(telaCadDisciplina,  "Campo Nome não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros ++;
				}
				if(telaCadDisciplina.getRadioButtonOptativa().isSelected()) {
					contador++;
					optativa = true;
					obrigatoria = false;
				}
				else if(telaCadDisciplina.getRadioButtonObrigatoria().isSelected()) {
					optativa = false;
					obrigatoria = true;
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadDisciplina, "Indique se a disciplina é optativa ou obrigatória.", 
							"Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				
				if(telaCadDisciplina.getRadioButtonEPreRequisito().isSelected()) {
					ePreRequisito = true;
				}else {
					ePreRequisito = false;
				}
				teorica = true;
				if(telaCadDisciplina.getRadioButtonPratica().isSelected()) {
					pratica = true;
				}else {
					pratica = false;
				}
				if(telaCadDisciplina.getRadioButtonEstagio().isSelected()) {
					estagio = true;
				}else {
					estagio = false;
				}
				
				if(contador == 6) {
					dados = new Disciplina(nome_Disciplina, semestre, areaDisciplina, nomeCurso, preRequisitos, 
							carga_Horaria, ePreRequisito, optativa, obrigatoria, teorica, pratica, estagio);
					
					boolean retorno = new BancoDisciplinaGerenciar().BancoDisciplinaInserir(dados);
					boolean retorno1 = false;
					int count = 0;
					if(preRequisitos.size() > 0) {
						int idDisciplina = Integer.parseInt(new Banco().primeiroEultimo("Disciplina", "idDisciplina", 2));
						for(int i = 0; i < preRequisitos.size(); i++) {
							
							try {
								int idPreRequisito = Integer.parseInt(new BancoDisciplinaGerenciar().consultar("Disciplina", "nomeDisciplina", 
										preRequisitos.get(i).toString(), "idDisciplina"));
								retorno1 = new BancoDisciplinaGerenciar().inserirPreRequisitos(idDisciplina, idPreRequisito, preRequisitos.get(i));
								
								if(retorno1)
									count++;
								
							}catch(Exception e1) {
								e1.printStackTrace();
							}
							
						}
						
					
					}
					if(retorno && count == preRequisitos.size()) {
				//	new ControleArquivo(4);
						JOptionPane.showMessageDialog(telaCadDisciplina, "Cadastro realizado com sucesso.");
						LimpaDados();
					//	preenche();
					}
				}else {
					if(contador != 6)
						JOptionPane.showMessageDialog(telaCadDisciplina, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", 
														"Aviso", JOptionPane.WARNING_MESSAGE);
					else if(erros > 0)
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
		ArrayList<String> disciplinas = new BancoDisciplinaGerenciar().consultarUmaColuna("Disciplina", "nomeDisciplina");
		for(int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.get(i).equals(nome)){
			//selecionando o id do curso em que a disciplina está cadastrada	
				int idCursoDisciplina = Integer.parseInt(new Banco().consultar("Disciplina", "nomeDisciplina", nome, "Curso_idCurso"));
				int idCurso = Integer.parseInt(new BancoCursoGerenciar().consultar("nomeCurso", curso, "idCurso"));
				if(idCursoDisciplina == idCurso)
					contador++;
				
			}
		}
		return contador;
	}
	
	public int Validacoes(String nome, ArrayList<String> dados) {
		int contador = 0;
		for(int i = 0; i < dados.size(); i++) {
			if(dados.get(i).toString().equals(nome)) {
				contador += 1;
			}
		}
		return contador;
	}
	
	public void preenche() {
		int i;
		telaCadDisciplina.getComboBoxCurso().addItem("SELECIONE");
		telaCadDisciplina.getComboBoxAreaDisciplina().addItem("SELECIONE");
	//preenchendo o combobox com os nomes de cursos	e as areas
		try {
			ArrayList<String> cursosNome = new BancoCursoGerenciar().consultarUmaColuna("Curso", "nomeCurso");
			ArrayList<String> disciplinasArea = new BancoDisciplinaGerenciar().consultarUmaColuna("Disciplina", "areaDisciplina");
			for(i = 0; i<cursosNome.size(); i++) {
				telaCadDisciplina.getComboBoxCurso().addItem(cursosNome.get(i).toString());
				nomesCurso.add(cursosNome.get(i).toString());
			}
			for(i = 0; i < disciplinasArea.size(); i++) {
				if(Validacoes(disciplinasArea.get(i).toString(), areasDisciplina) == 0) {
					telaCadDisciplina.getComboBoxAreaDisciplina().addItem(disciplinasArea.get(i).toString());
					areasDisciplina.add(disciplinasArea.get(i).toString());
				}
					
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void LimpaDados() {
		telaCadDisciplina.getComboBoxAreaDisciplina().setSelectedIndex(0);
		telaCadDisciplina.getComboBoxCargaHoraria().setSelectedIndex(0);
		telaCadDisciplina.getComboBoxCurso().setSelectedIndex(0);
		telaCadDisciplina.getComboBoxPreRequisitos().removeAllItems();
		telaCadDisciplina.getComboBoxSemestre().removeAllItems();
		telaCadDisciplina.getComboBoxSemestre().addItem("SELECIONE");
		telaCadDisciplina.getComboBoxSemestre().setSelectedIndex(0);
		telaCadDisciplina.getTextFieldNomeDisciplina().setText(null);
		telaCadDisciplina.getRadioButtonPratica().setSelected(false);
		telaCadDisciplina.getRadioButtonEstagio().setSelected(false);
		telaCadDisciplina.getRadioButtonEPreRequisito().setSelected(false);
		telaCadDisciplina.getRadioButtonObrigatoria().setSelected(false);
		telaCadDisciplina.getRadioButtonOptativa().setSelected(false);
		preRequisitos.clear();
		telaCadDisciplina.getComboBoxAreaDisciplina().setEnabled(false);
		telaCadDisciplina.getComboBoxCargaHoraria().setEnabled(false);
		telaCadDisciplina.getComboBoxSemestre().setEnabled(false);
		telaCadDisciplina.getRadioButtonEPreRequisito().setEnabled(false);
		telaCadDisciplina.getRadioButtonEstagio().setEnabled(false);
		telaCadDisciplina.getRadioButtonObrigatoria().setEnabled(false);
		telaCadDisciplina.getRadioButtonOptativa().setEnabled(false);
		telaCadDisciplina.getRadioButtonPratica().setEnabled(false);
		telaCadDisciplina.getRadioButtonPreRequisitos().setEnabled(false);
		telaCadDisciplina.getButtonAdicionarAreaDisciplina().setEnabled(false);
		telaCadDisciplina.getTextFieldNomeDisciplina().setEnabled(false);
		telaCadDisciplina.getComboBoxCurso().setEnabled(true);
	}
}
