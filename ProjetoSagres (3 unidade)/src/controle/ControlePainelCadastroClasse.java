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
import java.util.Random;

import javax.swing.JOptionPane;

import banco.BancoClasseGerenciar;
import modelo.Classe;
import modelo.Curso;
import modelo.Disciplina;
import visao.VisaoPainelCadastroClasse;
import visao.VisaoPainelHorarios;

public class ControlePainelCadastroClasse implements ActionListener {
	static VisaoPainelCadastroClasse telaCadClasse;
	static VisaoPainelHorarios visaoHorarios;
	private String matricula;
	private int contador;
	private int saida;
	private int volta;
	private ArrayList<String> alunos = new ArrayList<String>();
	private ArrayList<String> professores = new ArrayList<String>();
	Calendar hoje = Calendar.getInstance();
	Classe dados;
	int dia1 = 0;
	int dia2 = 0;
	int dia3 = 0;
	int hora1 = 0;
	int hora2 = 0;
	int hora3 = 0;
	String secondDay;
	String firstDay;
	String thirdDay;
	String hourFirstDay;
	String hourSecondDay;
	String hourThirdDay;
	Curso curso;
	Disciplina disciplina;
	
	public ControlePainelCadastroClasse(VisaoPainelCadastroClasse telaCadClasse, int volta) {
		ControlePainelCadastroClasse.telaCadClasse = telaCadClasse;
		telaCadClasse.setVisible(true);
		this.volta = volta;
		preencheComboBox(1);
		AddEventos();
	}

	public void AddEventos() {
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
		// telaCadClasse.getButtonGerarHorario().addActionListener(this);

		telaCadClasse.getComboBoxAlunos().setEnabled(false);
		telaCadClasse.getComboBoxDisciplina().setEnabled(false);
		telaCadClasse.getComboBoxProfessores().setEnabled(false);
		telaCadClasse.getComboBoxSemestre().setEnabled(false);
		telaCadClasse.getButtonAdicionarAluno().setEnabled(false);
		telaCadClasse.getButtonAdicionarProfessor().setEnabled(false);
		// telaCadClasse.getButtonGerarHorario().setEnabled(false);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaCadClasse.getComboBoxCurso()) {
			if (!telaCadClasse.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
				telaCadClasse.getComboBoxAlunos().setEnabled(true);
				telaCadClasse.getComboBoxCurso().setEnabled(false);
				telaCadClasse.getComboBoxDisciplina().setEnabled(true);
				telaCadClasse.getComboBoxProfessores().setEnabled(true);
				telaCadClasse.getComboBoxSemestre().setEnabled(true);
				telaCadClasse.getButtonAdicionarAluno().setEnabled(true);
				telaCadClasse.getButtonAdicionarProfessor().setEnabled(true);
				// telaCadClasse.getButtonGerarHorario().setEnabled(true);
				preencheComboBox(2);
			}
		}

		if (e.getSource() == telaCadClasse.getComboBoxDisciplina()) {
			if (!telaCadClasse.getComboBoxDisciplina().getSelectedItem().equals("SELECIONE")) {
				telaCadClasse.getComboBoxDisciplina().setEnabled(false);
				for (int i = 0; i < Main.curso.size(); i++) {
					if (Main.curso.get(i).getNome()
							.equals(telaCadClasse.getComboBoxCurso().getSelectedItem().toString())) {
						curso = Main.curso.get(i);
						for (int j = 0; j < Main.disciplina.size(); j++) {
							if (Main.disciplina.get(j).getNome_Disciplina()
									.equals(telaCadClasse.getComboBoxDisciplina().getSelectedItem().toString())) {
								disciplina = Main.disciplina.get(j);
								geraHorario(Main.disciplina.get(j), Main.curso.get(i));
								if (Main.disciplina.get(j).getCarga_Horaria().equals("30")
										|| Main.disciplina.get(j).getCarga_Horaria().equals("45")) {
									telaCadClasse.getTextFieldDia1().setText(firstDay);
									telaCadClasse.getTextFieldHora1().setText(hourFirstDay);

								} else if (Main.disciplina.get(j).getCarga_Horaria().equals("60")
										|| Main.disciplina.get(j).getCarga_Horaria().equals("75")
										|| Main.disciplina.get(j).getCarga_Horaria().equals("90")
										|| Main.disciplina.get(j).getCarga_Horaria().equals("105")
										|| Main.disciplina.get(j).getCarga_Horaria().equals("120")) {

									telaCadClasse.getTextFieldDia1().setText(firstDay);
									telaCadClasse.getTextFieldHora1().setText(hourFirstDay);
									telaCadClasse.getTextFieldDia2().setText(secondDay);
									telaCadClasse.getTextFieldHora2().setText(hourSecondDay);

								} else {
									telaCadClasse.getTextFieldDia1().setText(firstDay);
									telaCadClasse.getTextFieldHora1().setText(hourFirstDay);
									telaCadClasse.getTextFieldDia2().setText(secondDay);
									telaCadClasse.getTextFieldHora2().setText(hourSecondDay);
									telaCadClasse.getTextFieldDia2().setText(thirdDay);
									telaCadClasse.getTextFieldHora2().setText(hourThirdDay);
								}
								break;
							}
						}
						break;
					}
				}

			}
		}
		if (e.getSource() == telaCadClasse.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadClasse, "Deseja realmente voltar?",
						"Confirmação de saída", JOptionPane.YES_NO_OPTION);
				if (saida == 0) {
					//LimpaDados();
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
				saida = JOptionPane.showConfirmDialog(telaCadClasse, "Deseja realmente cancelar o cadastro?",
						"Confirmação de saída", JOptionPane.YES_NO_OPTION);
				if (saida == 0) {
					LimpaDados();
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
						if (ValidaAluno(matricula, 1) == 0) { // número de matrícula encontrado ou não
							if (ValidaAluno(matricula, 4) == 0) { // aluno cadastrado em outro curso ou não
								if (ValidaAluno(matricula, 3) == 0) { // aluno cadastrado ou não em outra turma
									if (ValidaAluno(matricula, 2) == 0) { // aluno cumpriu ou não os pré requisitos
										alunos.add(String.valueOf(matricula));
										telaCadClasse.getComboBoxAlunos().addItem(String.valueOf(matricula));

									} else {
										JOptionPane.showMessageDialog(null,
												"Aluno não cumpriu o(s) pré-requisito(s) da disciplina.", "Aviso",
												JOptionPane.ERROR_MESSAGE);
									}

								} else {
									JOptionPane.showMessageDialog(null,
											"Aluno cadastrado em outra turma no mesmo horário.", "Aviso",
											JOptionPane.ERROR_MESSAGE);
								}

							} else {
								JOptionPane.showMessageDialog(null, "Aluno cadastrado em outro curso.", "Aviso",
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
							} else {
								JOptionPane.showMessageDialog(telaCadClasse,
										"Professor com carga horária indisponível.", "Erro", JOptionPane.ERROR_MESSAGE);
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
				
				if (!telaCadClasse.getComboBoxDisciplina().getSelectedItem().equals("SELECIONE")) {
					contador++;
				}
				if (!telaCadClasse.getComboBoxSemestre().getSelectedItem().equals("SELECIONE")) {
					contador++;
				}
				if (!telaCadClasse.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
					contador++;
				}
				if (professores.size() > 0) {
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadClasse, "Deve haver no mínimo 1 professor cadastrado na turma!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
				if (alunos.size()>=5) {
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadClasse, "Deve haver no mínimo 5 alunos cadastrados na turma!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
				if (contador == 5) {
					String diaClasse;
					String horaClasse;
					if(disciplina.getCarga_Horaria().equals("30") 
							|| disciplina.getCarga_Horaria().equals("45")) {
						diaClasse = firstDay;
						horaClasse = hourFirstDay;
					}else if(disciplina.getCarga_Horaria().equals("60")
							|| disciplina.getCarga_Horaria().equals("75")
							|| disciplina.getCarga_Horaria().equals("90")
							|| disciplina.getCarga_Horaria().equals("105")
							|| disciplina.getCarga_Horaria().equals("120")) {
						diaClasse = firstDay + "/"+secondDay;
						horaClasse = hourFirstDay + "/"+hourSecondDay;
					}else {
						diaClasse = firstDay + "/"+secondDay+"/"+thirdDay;
						horaClasse = hourFirstDay+ "/"+hourSecondDay+"/"+hourThirdDay;
					}
					dados = new Classe(curso.getNome(), disciplina.getNome_Disciplina(), professores, alunos, telaCadClasse.getTextFieldAno().getText().toString() + "."
							+ telaCadClasse.getComboBoxSemestre().getSelectedItem().toString(), diaClasse, horaClasse);
					boolean retorno = new BancoClasseGerenciar().BancoClasseInserir(dados);
					
					// new ControleArquivo(2);
					if(retorno) {
						JOptionPane.showMessageDialog(telaCadClasse, "Cadastro realizado com sucesso.");
						LimpaDados();
					}else {
						JOptionPane.showMessageDialog(telaCadClasse, "Cadastro realizado sem sucesso.");
					}
					
				} else {
					JOptionPane.showMessageDialog(telaCadClasse, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		// if (e.getSource() == telaCadClasse.getButtonGerarHorario()) {
		// tipoCurso = busca();
		// if (visaoHorarios == null) {
		// visaoHorarios = new
		// VisaoPainelHorarios(telaCadClasse.getComboBoxCurso().getSelectedItem().toString(),
		// tipoCurso);
		// }
		// new ControlePainelHorários(visaoHorarios, tipoCurso,
		// telaCadClasse.getComboBoxDisciplina().getSelectedItem().toString());
		// }

	}

	public void geraHorario(Disciplina disciplina, Curso curso) {
		// matutino
		// primeiro horário 7:30 - 8:20
		// segundo horario 8:20 - 9:10
		// terceiro horario 9:10 - 10:00
		// quarto horário 10:10 - 11:00
		// quinto horário 11:00 - 11:50
		// sexto horário 11:00 - 11:50
		// sétimo horário 11:50 - 12:40

		// vespertino
		// primeiro horário 13:10 - 14:00
		// segundo horario 14:00 - 14:50
		// terceiro horario 14:50 - 15:40
		// quarto horário 15:50 - 16:40
		// quinto horário 16:40 - 17:30
		// sexto horário 17:30 - 18:20

		// noturno
		// primeiro horário 18:20 - 19:10
		// segundo horario 19:10 - 20:00
		// terceiro horario 20:00 - 20:50
		// quarto horário 20:50 - 21:40
		// quinto horário 21:40 - 22:30

		if (disciplina.getCarga_Horaria().equals("30") || disciplina.getCarga_Horaria().equals("45")) {
			dia1 = new Random().nextInt(5) + 1;
			if (dia1 == 1) {
				firstDay = "Segunda-feira";
			} else if (dia1 == 2) {
				firstDay = "Terça-feira";
			} else if (dia1 == 3) {
				firstDay = "Quarta-feira";
			} else if (dia1 == 4) {
				firstDay = "Quinta-feira";
			} else if (dia1 == 5) {
				firstDay = "Sexta-feira";
			} else {
				firstDay = "Sábado";
			}
			if (curso.getTipo().equals("NOTURNO")) {
				hora1 = new Random().nextInt(6) + 13;
				if (hora1 == 13 || hora1 == 14) {
					hourFirstDay = "18:20 - 20:00";
				} else if (hora1 == 15) {
					hourFirstDay = "19:10 - 20:50";
				} else if (hora1 == 16) {
					hourFirstDay = "20:00 - 21:40";
				} else {
					hourFirstDay = "20:50 - 22:30";
				}
			} else if (curso.getTipo().equals("MATUTINO")) {
				hora1 = new Random().nextInt(6) + 1;
				if (hora1 == 1) {
					hourFirstDay = "07:30 - 09:10";
				} else if (hora1 == 2) {
					hourFirstDay = "08:20 - 10:00";
				} else if (hora1 == 3) {
					hourFirstDay = "09:10 - 11:00";
				} else if (hora1 == 4) {
					hourFirstDay = "10:10 - 11:50";
				} else {
					hourFirstDay = "11:00 - 12:40";
				}

			} else if (curso.getTipo().equals("VESPERTINO")) {
				hora1 = new Random().nextInt(7) + 7;
				if (hora1 == 7 || hora1 == 8) {
					hourFirstDay = "13:10 - 14:50";
				} else if (hora1 == 9) {
					hourFirstDay = "14:00 - 15:40";
				} else if (hora1 == 10) {
					hourFirstDay = "14:50 - 16:40";
				} else if (hora1 == 11) {
					hourFirstDay = "15:40 - 17:30";
				} else {
					hourFirstDay = "16:40 - 18:20";
				}
			} else {
				hora1 = new Random().nextInt(12) + 1;
				if (hora1 == 1) {
					hourFirstDay = "07:30 - 09:10";
				} else if (hora1 == 2) {
					hourFirstDay = "08:20 - 10:00";
				} else if (hora1 == 3) {
					hourFirstDay = "09:10 - 11:00";
				} else if (hora1 == 4) {
					hourFirstDay = "10:10 - 11:50";
				} else if (hora1 == 5 || hora1 == 6 || hora1 == 7) {
					hourFirstDay = "11:00 - 12:40";
				} else if (hora1 == 8) {
					hourFirstDay = "13:10 - 14:50";
				} else if (hora1 == 9) {
					hourFirstDay = "14:00 - 15:40";
				} else if (hora1 == 10) {
					hourFirstDay = "14:50 - 16:40";
				} else if (hora1 == 11) {
					hourFirstDay = "15:40 - 17:30";
				} else if (hora1 == 12 || hora1 == 13) {
					hourFirstDay = "16:40 - 18:20";
				}
			}
		} else if (disciplina.getCarga_Horaria().equals("60") || disciplina.getCarga_Horaria().equals("75")
				|| disciplina.getCarga_Horaria().equals("90")) {
			while (dia1 == dia2) {
				dia1 = new Random().nextInt(5) + 1;
				dia2 = new Random().nextInt(5) + 1;

				if (dia1 == 1) {
					firstDay = "Segunda-feira";
				} else if (dia1 == 2) {
					firstDay = "Terça-feira";
				} else if (dia1 == 3) {
					firstDay = "Quarta-feira";
				} else if (dia1 == 4) {
					firstDay = "Quinta-feira";
				} else if (dia1 == 5) {
					firstDay = "Sexta-feira";
				} else {
					firstDay = "Sábado";
				}

				if (dia2 == 1) {
					secondDay = "Segunda-feira";
				} else if (dia2 == 2) {
					secondDay = "Terça-feira";
				} else if (dia2 == 3) {
					secondDay = "Quarta-feira";
				} else if (dia2 == 4) {
					secondDay = "Quinta-feira";
				} else if (dia2 == 5) {
					secondDay = "Sexta-feira";
				} else if (dia2 == 6) {
					secondDay = "Sábado";
				}
			}

			if (disciplina.getCarga_Horaria().equals("60") || disciplina.getCarga_Horaria().equals("75")) {
				if (curso.getTipo().equals("NOTURNO")) {
					hora1 = new Random().nextInt(6) + 13;
					hora2 = new Random().nextInt(6) + 13;
					if (hora1 == 13 || hora1 == 14) {
						hourFirstDay = "18:20 - 20:00";
					} else if (hora1 == 15) {
						hourFirstDay = "19:10 - 20:50";
					} else if (hora1 == 16) {
						hourFirstDay = "20:00 - 21:40";
					} else {
						hourFirstDay = "20:50 - 22:30";
					}
					if (hora2 == 13 || hora2 == 14) {
						hourSecondDay = "18:20 - 20:00";
					} else if (hora2 == 15) {
						hourSecondDay = "19:10 - 20:50";
					} else if (hora2 == 16) {
						hourSecondDay = "20:00 - 21:40";
					} else {
						hourSecondDay = "20:50 - 22:30";
					}

				} else if (curso.getTipo().equals("MATUTINO")) {
					hora1 = new Random().nextInt(6) + 1;
					hora2 = new Random().nextInt(6) + 1;
					if (hora1 == 1) {
						hourFirstDay = "07:30 - 09:10";
					} else if (hora1 == 2) {
						hourFirstDay = "08:20 - 10:00";
					} else if (hora1 == 3) {
						hourFirstDay = "09:10 - 11:00";
					} else if (hora1 == 4) {
						hourFirstDay = "10:10 - 11:50";
					} else {
						hourFirstDay = "11:00 - 12:40";
					}
					if (hora2 == 1) {
						hourSecondDay = "07:30 - 09:10";
					} else if (hora2 == 2) {
						hourSecondDay = "08:20 - 10:00";
					} else if (hora2 == 3) {
						hourSecondDay = "09:10 - 11:00";
					} else if (hora2 == 4) {
						hourSecondDay = "10:10 - 11:50";
					} else {
						hourSecondDay = "11:00 - 12:40";
					}

				} else if (curso.getTipo().equals("VESPERTINO")) {
					hora1 = new Random().nextInt(7) + 7;
					hora2 = new Random().nextInt(7) + 7;
					if (hora1 == 7 || hora1 == 8) {
						hourFirstDay = "13:10 - 14:50";
					} else if (hora1 == 9) {
						hourFirstDay = "14:00 - 15:40";
					} else if (hora1 == 10) {
						hourFirstDay = "14:50 - 16:40";
					} else if (hora1 == 11) {
						hourFirstDay = "15:40 - 17:30";
					} else {
						hourFirstDay = "16:40 - 18:20";
					}
					if (hora2 == 7 || hora2 == 8) {
						hourSecondDay = "13:10 - 14:50";
					} else if (hora2 == 9) {
						hourSecondDay = "14:00 - 15:40";
					} else if (hora2 == 10) {
						hourSecondDay = "14:50 - 16:40";
					} else if (hora2 == 11) {
						hourSecondDay = "15:40 - 17:30";
					} else {
						hourSecondDay = "16:40 - 18:20";
					}
				} else {
					hora1 = new Random().nextInt(12) + 1;
					hora2 = new Random().nextInt(12) + 1;
					if (hora1 == 1) {
						hourFirstDay = "07:30 - 09:10";
					} else if (hora1 == 2) {
						hourFirstDay = "08:20 - 10:00";
					} else if (hora1 == 3) {
						hourFirstDay = "09:10 - 11:00";
					} else if (hora1 == 4) {
						hourFirstDay = "10:10 - 11:50";
					} else if (hora1 == 5 || hora1 == 6 || hora1 == 7) {
						hourFirstDay = "11:00 - 12:40";
					} else if (hora1 == 8) {
						hourFirstDay = "13:10 - 14:50";
					} else if (hora1 == 9) {
						hourFirstDay = "14:00 - 15:40";
					} else if (hora1 == 10) {
						hourFirstDay = "14:50 - 16:40";
					} else if (hora1 == 11) {
						hourFirstDay = "15:40 - 17:30";
					} else if (hora1 == 12 || hora1 == 13) {
						hourFirstDay = "16:40 - 18:20";
					}

					if (hora2 == 1) {
						hourSecondDay = "07:30 - 09:10";
					} else if (hora2 == 2) {
						hourSecondDay = "08:20 - 10:00";
					} else if (hora2 == 3) {
						hourSecondDay = "09:10 - 11:00";
					} else if (hora2 == 4) {
						hourSecondDay = "10:10 - 11:50";
					} else if (hora2 == 5 || hora2 == 6 || hora2 == 7) {
						hourSecondDay = "11:00 - 12:40";
					} else if (hora2 == 8) {
						hourSecondDay = "13:10 - 14:50";
					} else if (hora2 == 9) {
						hourSecondDay = "14:00 - 15:40";
					} else if (hora2 == 10) {
						hourSecondDay = "14:50 - 16:40";
					} else if (hora2 == 11) {
						hourSecondDay = "15:40 - 17:30";
					} else if (hora2 == 12 || hora2 == 13) {
						hourSecondDay = "16:40 - 18:20";
					}
				}
			} else {
				if (curso.getTipo().equals("NOTURNO")) {
					hora1 = new Random().nextInt(6) + 13;
					hora2 = new Random().nextInt(6) + 13;
					if (hora1 == 13 || hora1 == 14) {
						hourFirstDay = "18:20 - 20:50";
					} else if (hora1 == 15) {
						hourFirstDay = "19:10 - 20:50";
					} else if (hora1 == 16) {
						hourFirstDay = "20:00 - 21:40";
					} else {
						hourFirstDay = "20:50 - 22:30";
					}
					if (hora2 == 13 || hora2 == 14) {
						hourSecondDay = "18:20 - 20:50";
					} else if (hora2 == 15) {
						hourSecondDay = "19:10 - 21:40";
					} else {
						hourSecondDay = "20:00 - 22:30";
					}

				} else if (curso.getTipo().equals("MATUTINO")) {
					hora1 = new Random().nextInt(6) + 1;
					hora2 = new Random().nextInt(6) + 1;
					if (hora1 == 1) {
						hourFirstDay = "07:30 - 09:10";
					} else if (hora1 == 2) {
						hourFirstDay = "08:20 - 10:00";
					} else if (hora1 == 3) {
						hourFirstDay = "09:10 - 11:00";
					} else if (hora1 == 4) {
						hourFirstDay = "10:10 - 11:50";
					} else {
						hourFirstDay = "11:00 - 12:40";
					}
					if (hora2 == 1) {
						hourSecondDay = "07:30 - 10:00";
					} else if (hora2 == 2) {
						hourSecondDay = "08:20 - 11:00";
					} else if (hora2 == 3) {
						hourSecondDay = "09:10 - 11:50";
					} else {
						hourSecondDay = "10:10 - 12:40";
					}

				} else if (curso.getTipo().equals("VESPERTINO")) {
					hora1 = new Random().nextInt(7) + 7;
					hora2 = new Random().nextInt(7) + 7;
					if (hora1 == 7 || hora1 == 8) {
						hourFirstDay = "13:10 - 14:50";
					} else if (hora1 == 9) {
						hourFirstDay = "14:00 - 15:40";
					} else if (hora1 == 10) {
						hourFirstDay = "14:50 - 16:40";
					} else if (hora1 == 11) {
						hourFirstDay = "15:40 - 17:30";
					} else {
						hourFirstDay = "16:40 - 18:20";
					}
					if (hora2 == 7 || hora2 == 8) {
						hourSecondDay = "13:10 - 15:40";
					} else if (hora2 == 9) {
						hourSecondDay = "14:00 - 16:40";
					} else if (hora2 == 10) {
						hourSecondDay = "14:50 - 17:30";
					} else {
						hourSecondDay = "15:40 - 18:20";
					}

				} else {
					hora1 = new Random().nextInt(12) + 1;
					hora2 = new Random().nextInt(12) + 1;
					if (hora1 == 1) {
						hourFirstDay = "07:30 - 09:10";
					} else if (hora1 == 2) {
						hourFirstDay = "08:20 - 10:00";
					} else if (hora1 == 3) {
						hourFirstDay = "09:10 - 11:00";
					} else if (hora1 == 4) {
						hourFirstDay = "10:10 - 11:50";
					} else {
						hourFirstDay = "11:00 - 12:40";
					}
					if (hora2 == 1) {
						hourSecondDay = "07:30 - 10:00";
					} else if (hora2 == 2) {
						hourSecondDay = "08:20 - 11:00";
					} else if (hora2 == 3) {
						hourSecondDay = "09:10 - 11:50";
					} else {
						hourSecondDay = "10:10 - 12:40";
					}
					if (hora1 == 7 || hora1 == 8) {
						hourFirstDay = "13:10 - 14:50";
					} else if (hora1 == 9) {
						hourFirstDay = "14:00 - 15:40";
					} else if (hora1 == 10) {
						hourFirstDay = "14:50 - 16:40";
					} else if (hora1 == 11) {
						hourFirstDay = "15:40 - 17:30";
					} else {
						hourFirstDay = "16:40 - 18:20";
					}
					if (hora2 == 7 || hora2 == 8) {
						hourSecondDay = "13:10 - 15:40";
					} else if (hora2 == 9) {
						hourSecondDay = "14:00 - 16:40";
					} else if (hora2 == 10) {
						hourSecondDay = "14:50 - 17:30";
					} else {
						hourSecondDay = "15:40 - 18:20";
					}
				}
			}
		} else if (disciplina.getCarga_Horaria().equals("105") || disciplina.getCarga_Horaria().equals("120")) {
			while (dia1 == dia2) {
				dia1 = new Random().nextInt(5) + 1;
				dia2 = new Random().nextInt(5) + 1;

				if (dia1 == 1) {
					firstDay = "Segunda-feira";
				} else if (dia1 == 2) {
					firstDay = "Terça-feira";
				} else if (dia1 == 3) {
					firstDay = "Quarta-feira";
				} else if (dia1 == 4) {
					firstDay = "Quinta-feira";
				} else if (dia1 == 5) {
					firstDay = "Sexta-feira";
				} else {
					firstDay = "Sábado";
				}

				if (dia2 == 1) {
					secondDay = "Segunda-feira";
				} else if (dia2 == 2) {
					secondDay = "Terça-feira";
				} else if (dia2 == 3) {
					secondDay = "Quarta-feira";
				} else if (dia2 == 4) {
					secondDay = "Quinta-feira";
				} else if (dia2 == 5) {
					secondDay = "Sexta-feira";
				} else if (dia2 == 6) {
					secondDay = "Sábado";
				}
			}
			hora1 = new Random().nextInt(12) + 1;
			hora2 = new Random().nextInt(12) + 1;

			if (hora1 == 1) {
				hourFirstDay = "07:30 - 10:00";
			} else if (hora1 == 2) {
				hourFirstDay = "08:20 - 11:00";
			} else if (hora1 == 3) {
				hourFirstDay = "09:10 - 11:50";
			} else {
				hourFirstDay = "10:10 - 12:40";
			}
			if (hora2 == 1) {
				hourSecondDay = "07:30 - 10:00";
			} else if (hora2 == 2) {
				hourSecondDay = "08:20 - 11:00";
			} else if (hora2 == 3) {
				hourSecondDay = "09:10 - 11:50";
			} else {
				hourSecondDay = "10:10 - 12:40";
			}
			if (hora3 == 1) {
				hourSecondDay = "07:30 - 10:00";
			} else if (hora3 == 2) {
				hourSecondDay = "08:20 - 11:00";
			} else if (hora3 == 3) {
				hourSecondDay = "09:10 - 11:50";
			} else {
				hourSecondDay = "10:10 - 12:40";
			}

			if (hora1 == 7 || hora1 == 8) {
				hourFirstDay = "13:10 - 15:40";
			} else if (hora1 == 9) {
				hourFirstDay = "14:00 - 16:40";
			} else if (hora1 == 10) {
				hourFirstDay = "14:50 - 17:30";
			} else {
				hourFirstDay = "15:40 - 18:20";
			}
			if (hora2 == 7 || hora2 == 8) {
				hourSecondDay = "13:10 - 15:40";
			} else if (hora2 == 9) {
				hourSecondDay = "14:00 - 16:40";
			} else if (hora2 == 10) {
				hourSecondDay = "14:50 - 17:30";
			} else {
				hourSecondDay = "15:40 - 18:20";
			}
		}

		else {
			while (dia1 == dia2 && dia1 == dia3) {
				dia1 = new Random().nextInt(5) + 1;
				dia2 = new Random().nextInt(5) + 1;
				dia3 = new Random().nextInt(5) + 1;
				if (dia1 == 1) {
					firstDay = "Segunda-feira";
				} else if (dia1 == 2) {
					firstDay = "Terça-feira";
				} else if (dia1 == 3) {
					firstDay = "Quarta-feira";
				} else if (dia1 == 4) {
					firstDay = "Quinta-feira";
				} else if (dia1 == 5) {
					firstDay = "Sexta-feira";
				} else {
					firstDay = "Sábado";
				}

				if (dia2 == 1) {
					secondDay = "Segunda-feira";
				} else if (dia2 == 2) {
					secondDay = "Terça-feira";
				} else if (dia2 == 3) {
					secondDay = "Quarta-feira";
				} else if (dia2 == 4) {
					secondDay = "Quinta-feira";
				} else if (dia2 == 5) {
					secondDay = "Sexta-feira";
				} else if (dia2 == 6) {
					secondDay = "Sábado";
				}
				if (dia3 == 1) {
					thirdDay = "Segunda-feira";
				} else if (dia3 == 2) {
					thirdDay = "Terça-feira";
				} else if (dia3 == 3) {
					thirdDay = "Quarta-feira";
				} else if (dia3 == 4) {
					thirdDay = "Quinta-feira";
				} else if (dia3 == 5) {
					thirdDay = "Sexta-feira";
				} else if (dia3 == 6) {
					thirdDay = "Sábado";
				}
			}
			hora1 = new Random().nextInt(12) + 1;
			hora2 = new Random().nextInt(12) + 1;
			hora3 = new Random().nextInt(12) + 1;
			if (hora1 < 7) {
				if (hora1 == 1) {
					hourFirstDay = "07:30 - 10:00";
				} else if (hora1 == 2) {
					hourFirstDay = "08:20 - 11:00";
				} else if (hora1 == 3) {
					hourFirstDay = "09:10 - 11:50";
				} else {
					hourFirstDay = "10:10 - 12:40";
				}
			} else if (hora1 > 6) {
				if (hora1 == 7 || hora1 == 8) {
					hourFirstDay = "13:10 - 15:40";
				} else if (hora1 == 9) {
					hourFirstDay = "14:00 - 16:40";
				} else if (hora1 == 10) {
					hourFirstDay = "14:50 - 17:30";
				} else {
					hourFirstDay = "15:40 - 18:20";
				}
			}
			if (hora2 < 7) {
				if (hora2 == 1) {
					hourSecondDay = "07:30 - 10:00";
				} else if (hora2 == 2) {
					hourSecondDay = "08:20 - 11:00";
				} else if (hora2 == 3) {
					hourSecondDay = "09:10 - 11:50";
				} else {
					hourSecondDay = "10:10 - 12:40";
				}
			} else if (hora2 > 6) {
				if (hora2 == 7 || hora2 == 8) {
					hourSecondDay = "13:10 - 15:40";
				} else if (hora2 == 9) {
					hourSecondDay = "14:00 - 16:40";
				} else if (hora2 == 10) {
					hourSecondDay = "14:50 - 17:30";
				} else {
					hourSecondDay = "15:40 - 18:20";
				}
			}

			if (hora3 < 7) {
				if (hora3 == 1) {

					hourThirdDay = "07:30 - 10:00";
				} else if (hora3 == 2) {
					hourThirdDay = "08:20 - 11:00";
				} else if (hora3 == 3) {
					hourThirdDay = "09:10 - 11:50";
				} else {
					hourThirdDay = "10:10 - 12:40";
				}
			} else if (hora3 > 6) {
				if (hora3 == 7 || hora3 == 8) {
					hourSecondDay = "13:10 - 15:40";
				} else if (hora3 == 9) {
					hourSecondDay = "14:00 - 16:40";
				} else if (hora3 == 10) {
					hourSecondDay = "14:50 - 17:30";
				} else {
					hourSecondDay = "15:40 - 18:20";
				}
			}

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

	public int ValidaAluno( String numero, int tipo) {
		// 1 - verifica se o aluno está cadastrado
		// 2 - verifica se o aluno cumpriu os pré-requisitos
		// 3 - verifica se o aluno está cadastrado em outra disciplina no mesmo horário
		// e dia
		// 4 - verifica se o aluno é de curso diferente
		int contador = 0;
		if (tipo == 1) {
			for (int i = 0; i < Main.aluno.size(); i++) {
				if (Main.aluno.get(i).getMatricula().equals(numero)) {
					return 0;
				}else
					contador++;
			}
		} else if (tipo == 2) {
			for (int i = 0; i < Main.aluno.size(); i++) {
				if (Main.aluno.get(i).getMatricula().equals(numero)) { // buscando aluno
					if (disciplina.getPreRequisitos().size() > 0) { // vefifica se o array de pré requisito tem algum dado
						for (int l = 0; l < disciplina.getPreRequisitos().size(); l++) { // percorre o  array  de  pré requisitos
							for (int k = 0; k < Main.aluno.get(i).getHistoricoDisciplinas().size(); k++) { // percorre o array de disciplinas concluídas em aluno
								// verifica se a disciplina cursada pelo aluo é a mesma que é o p´re-requisito
								if (Main.aluno.get(i).getHistoricoDisciplinas().get(k).equals(disciplina.getPreRequisitos().get(l))) {
									contador++;
								}
							}
						}
					}
					// se o contador foi do mesmo valor que o tamanho do array de pré-requisitos da
					// disciplina, quer dizer q ele cumpriu todos os necessários
					if (contador == disciplina.getPreRequisitos().size())
						return 0;
					else
						return 1;
					
				}

			}
		} else if (tipo == 3) {
			for (int i = 0; i < Main.classe.size(); i++) {
				for (int j = 0; j < Main.classe.get(i).getAluno().size(); j++) {
					if (Main.classe.get(i).getAluno().get(j).equals(numero)) {

						String[] dias = Main.classe.get(i).getDia().split("/");

					}
				}
			}

		} else if (tipo == 4) {
			for (int i = 0; i < Main.aluno.size(); i++) { // busca aluno
				if (Main.aluno.get(i).getMatricula().equals(numero)) {
					// verifica se o aluno cadastrado pertence ao curso que se quer cadastrar classe
					if (Main.aluno.get(i).getCurso().equals(curso.getNome())) {
						return 0;
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
			if (!telaCadClasse.getComboBoxCurso().getSelectedItem().equals(null))
				telaCadClasse.getComboBoxCurso().removeAllItems();

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
			// if(!telaCadClasse.getComboBoxDisciplina().getSelectedItem().equals(null))
			// telaCadClasse.getComboBoxDisciplina().removeAllItems();
			//
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
		telaCadClasse.getComboBoxCurso().setSelectedIndex(0);
		telaCadClasse.getTextFieldDia1().setText(null);
		telaCadClasse.getTextFieldHora1().setText(null);
		telaCadClasse.getTextFieldDia2().setText(null);
		telaCadClasse.getTextFieldHora2().setText(null);
		telaCadClasse.getTextFieldDia2().setText(null);
		telaCadClasse.getTextFieldHora2().setText(null);
		professores.clear();
		alunos.clear();

	}
}
