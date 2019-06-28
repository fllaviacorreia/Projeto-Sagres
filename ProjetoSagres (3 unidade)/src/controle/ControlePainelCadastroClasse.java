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

import modelo.Classe;
import visao.VisaoPainelCadastroClasse;
import visao.VisaoPainelHorarios;

public class ControlePainelCadastroClasse implements ActionListener {
	// CadastroClasse classe = new CadastroClasse();
	static VisaoPainelCadastroClasse telaCadClasse;
	static VisaoPainelHorarios visaoHorarios;
	private String matricula;
	private int contador;
	private int saida;
	private int volta;
	private ArrayList<String> alunos = new ArrayList<String>();
	private ArrayList<String> professores = new ArrayList<String>();
	private String tipoCurso;
	Calendar hoje = Calendar.getInstance();
	Classe dados;

	public ControlePainelCadastroClasse(VisaoPainelCadastroClasse telaCadClasse, int volta) {
		ControlePainelCadastroClasse.telaCadClasse = telaCadClasse;
		telaCadClasse.setVisible(true);
		this.volta = volta;
		AddEventos();
		preencheComboBox(1);
	}

	public void AddEventos() {
		telaCadClasse.getComboBoxAlunos().setEnabled(false);
		telaCadClasse.getComboBoxDisciplina().setEnabled(false);
		telaCadClasse.getComboBoxProfessores().setEnabled(false);
		telaCadClasse.getComboBoxSemestre().setEnabled(false);
		telaCadClasse.getButtonAdicionarAluno().setEnabled(false);
		telaCadClasse.getButtonAdicionarProfessor().setEnabled(false);
		telaCadClasse.getButtonGerarHorario().setEnabled(false);

		telaCadClasse.getButtonCancelar().addActionListener(this);
		telaCadClasse.getButtonConfirmar().addActionListener(this);
		telaCadClasse.getButtonVoltar().addActionListener(this);
		telaCadClasse.getButtonAdicionarAluno().addActionListener(this);
		telaCadClasse.getButtonAdicionarProfessor().addActionListener(this);
		telaCadClasse.getComboBoxCurso().addActionListener(this);
		telaCadClasse.getComboBoxAlunos().addActionListener(this);
		telaCadClasse.getComboBoxDisciplina().addActionListener(this);
		telaCadClasse.getComboBoxProfessores().addActionListener(this);
		telaCadClasse.getComboBoxSemestre().addActionListener(this);
		telaCadClasse.getButtonGerarHorario().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaCadClasse.getComboBoxCurso()) {
			if (!telaCadClasse.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
				telaCadClasse.getComboBoxAlunos().setEnabled(true);
				telaCadClasse.getComboBoxDisciplina().setEnabled(true);
				telaCadClasse.getComboBoxProfessores().setEnabled(true);
				telaCadClasse.getComboBoxSemestre().setEnabled(true);
				telaCadClasse.getButtonAdicionarAluno().setEnabled(true);
				telaCadClasse.getButtonAdicionarProfessor().setEnabled(true);
				telaCadClasse.getButtonGerarHorario().setEnabled(true);
				preencheComboBox(2);
			}
			if (telaCadClasse.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
				telaCadClasse.getComboBoxAlunos().setEnabled(false);
				telaCadClasse.getComboBoxDisciplina().setEnabled(false);
				telaCadClasse.getComboBoxProfessores().setEnabled(false);
				telaCadClasse.getComboBoxSemestre().setEnabled(false);
				telaCadClasse.getButtonAdicionarAluno().setEnabled(false);
				telaCadClasse.getButtonAdicionarProfessor().setEnabled(false);
				telaCadClasse.getButtonGerarHorario().setEnabled(false);
				LimpaDados();
			}
		}

		if (e.getSource() == telaCadClasse.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadClasse, "Deseja realmente voltar o programa?",
						"Confirmação de saída", JOptionPane.YES_NO_OPTION);
				if (saida == 0) {
					LimpaDados();
					if (volta == 1)
						ControlePainelTelaInicial.troca();
					else if (volta == 2)
						ControlePainelCadastro.troca();
					else
						ControlePainelConsulta.troca();
				}

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

		if (e.getSource() == telaCadClasse.getButtonCancelar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadClasse, "Deseja realmente cancelar o programa?",
						"Confirmação de saída", JOptionPane.YES_NO_OPTION);
				if (saida == 0) {
					LimpaDados();
					ControlePainelCadastro.troca();
				}

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if (e.getSource() == telaCadClasse.getButtonAdicionarAluno()) {
			if (!telaCadClasse.getComboBoxDisciplina().getSelectedItem().equals("SELECIONE")) {
				try {
					matricula = JOptionPane.showInputDialog(telaCadClasse, "Insira o número de matrícula do aluno:",
							"Inserir", JOptionPane.OK_CANCEL_OPTION);

					if (!String.valueOf(matricula).equals("")) {
						if (ValidaAluno(matricula, 1) == 1) {
							if (ValidaAluno(matricula, 2) == 0) {
								if(ValidaAluno(matricula, 3) == 0) {
									alunos.add(String.valueOf(matricula));
									telaCadClasse.getComboBoxAlunos().addItem(String.valueOf(matricula));
								}else {
									JOptionPane.showMessageDialog(null,
											"Aluno cadastrado em outra disciplina no mesmo horário.", "Aviso",
											JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Aluno não cumpriu o(s) pré-requisito(s) da disciplina.", "Aviso",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Número de matrícula não encontrado no banco de dados.",
									"Erro", JOptionPane.ERROR_MESSAGE);
						}

					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Digite apenas valores Numéricos");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(telaCadClasse, "Insira o nome da disciplina", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
		if (e.getSource() == telaCadClasse.getButtonAdicionarProfessor()) {
			try {
				if (!telaCadClasse.getComboBoxDisciplina().getSelectedItem().equals("SELECIONE")) {

					matricula = JOptionPane.showInputDialog(telaCadClasse, "Insira o número de matrícula do professor:",
							"Inserir", JOptionPane.OK_CANCEL_OPTION);
					if (!String.valueOf(matricula).equals("")) {
						if (ValidaProfessor(matricula, 1) == 1) {
							if (ValidaProfessor(matricula, 2) == 0) {
								professores.add(String.valueOf(matricula));
								telaCadClasse.getComboBoxProfessores().addItem(String.valueOf(matricula));
							}else {
								JOptionPane.showMessageDialog(telaCadClasse, "Professor com carga horária indisponível.", "Erro",
										JOptionPane.ERROR_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(telaCadClasse, "Número de matrícula não encontrado.", "Erro",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				} else {
					JOptionPane.showMessageDialog(telaCadClasse, "Insira o nome da disciplina", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Digite apenas valores numéricos");
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				JOptionPane.showMessageDialog(telaCadClasse, "Erro durante a busca.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}

		if (e.getSource() == telaCadClasse.getButtonConfirmar()) {
			try {
				contador = 0;
				dados = new Classe();
				if (!telaCadClasse.getComboBoxDisciplina().getSelectedItem().equals("SELECIONE")) {
					dados.setDisciplina(telaCadClasse.getComboBoxDisciplina().getSelectedItem().toString());
					contador++;
				}
				if (!telaCadClasse.getComboBoxSemestre().getSelectedItem().equals("SELECIONE")) {
					dados.setAnoSemestre(telaCadClasse.getTextFieldAno().getText().toString() + "."
							+ telaCadClasse.getComboBoxSemestre().getSelectedItem().toString());
					contador++;
				}
				if (!telaCadClasse.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
					dados.setCurso(telaCadClasse.getComboBoxCurso().getSelectedItem().toString());
					contador++;
				}
				if (telaCadClasse.getComboBoxProfessores() != null) {
					dados.setProfessor(professores);
					contador++;
				}
				if (telaCadClasse.getComboBoxAlunos() != null) {
					dados.setAluno(alunos);
					contador++;
				}
				if (contador == 5) {
					Main.classe.add(dados);
					// new ControleArquivo(2);
					JOptionPane.showMessageDialog(telaCadClasse, "Cadastro realizado com sucesso.");
					LimpaDados();
				} else {
					JOptionPane.showMessageDialog(telaCadClasse, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if (e.getSource() == telaCadClasse.getButtonGerarHorario()) {
			tipoCurso = busca();
			if (visaoHorarios == null) {
				visaoHorarios = new VisaoPainelHorarios(telaCadClasse.getComboBoxCurso().getSelectedItem().toString(),
						tipoCurso);
			}
			new ControlePainelHorários(visaoHorarios, tipoCurso,
					telaCadClasse.getComboBoxDisciplina().getSelectedItem().toString());
		}

	}

	public int ValidaProfessor(String numero, int tipo) {
		// 1 - verifica se tem o professor cadastrado
		// 2 - verifica a disponibilidade do professor
		// 3 - verifica se o professor já está cadastrado em outra turma no mesmo
		// horário e dia

		int contador = 0;
		if (tipo == 1) {
			for (int i = 0; i < Main.professor.size(); i++) {
				if (Main.professor.get(i).getMatricula() == numero) {
					contador += 1;
					System.out.println(contador);
				}
			}
		} else if (tipo == 2) {
			for (int i = 0; i < Main.professor.size(); i++) {
				if (Main.professor.get(i).getMatricula().equals(numero)) {
					if (!telaCadClasse.getComboBoxDisciplina().getSelectedItem().equals("SELECIONE")) {
						int j = 0;
						while (!telaCadClasse.getComboBoxDisciplina().getSelectedItem()
								.equals(Main.disciplina.get(j).getNome_Disciplina())) {
							j++;
						}
						String cargaHoraria = Main.disciplina.get(j).getCarga_Horaria().toString();
						if (cargaHoraria.equals("90")) {

						}
						if (cargaHoraria.equals("75")) {

						}
						if (cargaHoraria.equals("60")) {

						}
						if (cargaHoraria.equals("45")) {

						}
						if (cargaHoraria.equals("30")) {

						}
					}
				}
			}
		} else if (tipo == 3) {

		}

		return contador;
	}

	public int ValidaAluno(String numero, int tipo) {
		// 1 - verifica se o aluno está cadastrado
		// 2 - verifica se o aluno cumpriu os pré-requisitos
		// 3 - verifica se o aluno está cadastrado em outra disciplina no mesmo horário e dia
		// 4 - verifica se o aluno é de curso diferente
		int contador = 0;
		if (tipo == 1) {
			for (int i = 0; i < Main.aluno.size(); i++) {
				if (Main.aluno.get(i).getMatricula() == numero) {
					contador += 1;
				}
			}
		} else if (tipo == 2) {
			for (int i = 0; i < Main.aluno.size(); i++) {
				if (Main.aluno.get(i).getMatricula().equals(numero)) {
					String disciplina = telaCadClasse.getComboBoxDisciplina().getSelectedItem().toString();
					int index = 0;
					int tamanho = 0;
					for (int j = 0; j < Main.disciplina.size(); j++) {
						if (Main.disciplina.get(j).getNome_Disciplina().equals(disciplina)) {
							index = j;
							tamanho = Main.disciplina.get(j).getPreRequisitos().size();
							break;
						}
					}
					for (int j = 0; j < tamanho; j++) {
						for (int k = 0; k < Main.aluno.get(i).getHistoricoDisciplinas().size(); k++) {
							if (Main.aluno.get(i).getHistoricoDisciplinas().get(k)
									.equals(Main.disciplina.get(index).getPreRequisitos().get(j))) {
								contador++;
							}
						}
					}

					if (contador == tamanho)
						return 0;
					else
						return 1;
				}
			}
		}else if(tipo == 3) {
			
		}else if(tipo == 4) {
			for (int i = 0; i < Main.aluno.size(); i++) {
				if (Main.aluno.get(i).getMatricula().equals(numero)) {
					if(Main.aluno.get(i).getCurso().equals(telaCadClasse.getComboBoxCurso())) {
						return 0;
					}else {
						return 1;
					}
				}
			}
		}

		return contador;
	}

	public void preencheComboBox(int tipo) {
		// 1 - preenche curso --- valida e insere no combobox cursos sem repetição
		// 2 - preenche disciplina --- insere no combobox disciplinas cadastradas em
		// cursos

		if (tipo == 1) {
			telaCadClasse.getComboBoxCurso().addItem("SELECIONE");
			if (Main.curso.size() > 0) {
				try {
					for (int i = 0; i < Main.curso.size(); i++) {
						telaCadClasse.getComboBoxCurso().addItem(Main.curso.get(i).getNome().toString());
					}
				} catch (Exception e) {
					e.getMessage();
					e.printStackTrace();
				}

			}

		} else if (tipo == 2) {
			telaCadClasse.getComboBoxDisciplina().addItem("SELECIONE");
			try {
				for (int i = 0; i < Main.disciplina.size(); i++) {
					if (telaCadClasse.getComboBoxCurso().getSelectedItem()
							.equals(Main.disciplina.get(i).getCurso().toString())) {
						telaCadClasse.getComboBoxDisciplina()
								.addItem(Main.disciplina.get(i).getNome_Disciplina().toString());
					}
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}

	}

	public String busca() {
		// retorna uma string que indica qual o tipo do curso (matutino, vespertino,
		// noturno ou integral)

		String tipoCurso = "";
		for (int i = 0; i < Main.curso.size(); i++) {
			if (telaCadClasse.getComboBoxCurso().getSelectedItem().equals(Main.curso.get(i).getNome())) {
				tipoCurso = Main.curso.get(i).getTipo();
			}
		}
		return tipoCurso;
	}

	public void LimpaDados() {
		telaCadClasse.getComboBoxDisciplina().removeAllItems();
		telaCadClasse.getComboBoxSemestre().setSelectedIndex(0);
		telaCadClasse.getComboBoxProfessores().removeAllItems();
		telaCadClasse.getComboBoxAlunos().removeAllItems();
		telaCadClasse.getComboBoxCurso().removeAllItems();
		professores.clear();
		alunos.clear();

	}
}
