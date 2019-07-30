package controle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import banco.Banco;
import banco.BancoAlunoGerenciar;
import banco.BancoDisciplinaGerenciar;
import banco.BancoEnderecoGerenciar;
import modelo.Aluno;
import modelo.Arquivo;
import modelo.Endereco;
import modelo.Lists;
import modelo.ModeloTabelaAluno;
import visao.VisaoFramePrincipal;
import visao.VisaoPainelConsultaAluno;
import visao.VisaoPainelEditaAluno;

public class ControlePainelConsultaAluno implements MouseListener {
	int volta;
	static VisaoPainelConsultaAluno telaConsAluno;
	static VisaoPainelEditaAluno editaAluno;
	static VisaoFramePrincipal frame;
	private String disciplina = "";
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String nome;
	private String matricula;
	private String dataNascimento;
	private String email;
	private String telefone;
	private String celular;
	private String cpf;
	private String rg;
	private String uf;
	private String dataExpedicao;
	private String orgaoExp;
	private String curso;
	private ArrayList<String> disciplinas = new ArrayList<String>();

	public ControlePainelConsultaAluno(VisaoPainelConsultaAluno telaConsAluno, int volta) {
		ControlePainelConsultaAluno.telaConsAluno = telaConsAluno;
		this.volta = volta;
		AddEventos();
	}

	public void AddEventos() {
		telaConsAluno.getButtonVoltar().addMouseListener(this);
		telaConsAluno.getJTableDados().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == telaConsAluno.getButtonVoltar()) {
			int saida = JOptionPane.showConfirmDialog(telaConsAluno, "Deseja realmente voltar?", "Confirmação de saída",
					JOptionPane.YES_NO_OPTION);
			if (saida == 0) {
				if (volta == 1)
					ControlePainelTelaInicial.troca();
				else if (volta == 2)
					ControlePainelCadastro.troca();
				else
					ControlePainelConsulta.troca();
			}
		}
		if (e.getSource() == telaConsAluno.getJTableDados()) {
			Object[] Vetor = { "Atualizar", "Excluir", "Cancelar" };

			int op = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opções:", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, Vetor, Vetor[0]);
			System.out.println(op);
			if (op == 0) {
				System.out.println("op = 0");
				editaAluno = new VisaoPainelEditaAluno();
				Aluno aluno = Main.aluno.get(telaConsAluno.getJTableDados().getSelectedRow());
				/*Endereco endereco = new BancoEnderecoGerenciar().consultar_endereco("rua",new Banco().consultar("Aluno","idAluno",
						String.valueOf(aluno.getId()), "Endereco_idEndereco"), "idEndereco");*/
				//System.out.println(endereco.getId());
				editaAluno.getFormattedTextFieldNomeAluno().setText(aluno.getNome());
				editaAluno.getFormattedTextFieldDataNascimento().setText(aluno.getDataNascimento());
				editaAluno.getFormattedTextFieldCpf().setText(aluno.getCpf());
				editaAluno.getFormattedTextFieldRg().setText(aluno.getRg());
				editaAluno.getFormattedTextFieldOrgaoExpeditor().setText(aluno.getOrgaoExp());
				editaAluno.getComboBoxEstadoRg().setSelectedItem(aluno.getUf());
				editaAluno.getFormattedTextFieldDataRg().setText(aluno.getDataExpedicao());
				editaAluno.getTextFieldEmail().setText(aluno.getEmail());
				editaAluno.getFormattedTextFieldTelefone().setText(aluno.getTelefone());
				editaAluno.getFormattedTextFieldCelular().setText(aluno.getCelular());
				editaAluno.getFormattedTextFieldMatriculaAluno().setText(aluno.getMatricula());
				editaAluno.getComboBoxCurso().setSelectedItem(aluno.getCurso());
//				editaAluno.getFormattedTextFieldRua().setText(endereco.getRua());
//				editaAluno.getFormattedTextFieldNumero().setText(endereco.getNumero());
//				editaAluno.getFormattedTextFieldComplemento().setText(endereco.getComplemento());
//				editaAluno.getFormattedTextFieldBairro().setText(endereco.getBairro());
//				editaAluno.getComboBoxEstadoEndereco().setSelectedItem(endereco.getEstado());
//				editaAluno.getComboBoxCidades().setSelectedItem(endereco.getCidade());
				frame = new VisaoFramePrincipal();
				frame.setBounds(10, 10, 860, 350);
				frame.setLocationRelativeTo(null);
				frame.setBackground(new Color(8, 42, 108));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setContentPane(editaAluno);
				frame.repaint();
				frame.validate();
				editaAluno.getButtonCancelar().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == editaAluno.getButtonCancelar()) {
							int saida = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a atualização do cadastro?",
									"Confirmação de saída", JOptionPane.YES_NO_OPTION);
							if (saida == 0) {
								frame.dispose();
							}
						}
					}
				});
				editaAluno.getButtonConfirmar().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int contador = 0;
								Arquivo arquivo = new Arquivo(0);
						if(e.getSource() == editaAluno.getButtonConfirmar()) {
							try {
								contador = 0;

								// tem essa quantidade de espaços por conta da máscara
								if (!editaAluno.getFormattedTextFieldNomeAluno().getText()
										.equals("                                                       ")) {
									nome = arquivo.TiraEspaços(
											editaAluno.getFormattedTextFieldNomeAluno().getText().toString().toUpperCase());
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Nome não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getFormattedTextFieldDataNascimento().getText().equals("  /  /    "))) {
									if (Lists.validaData(editaAluno.getFormattedTextFieldDataNascimento().getText().split("/"))) {
										dataNascimento = editaAluno.getFormattedTextFieldDataNascimento().getText();
										contador++;
									} else {
										JOptionPane.showMessageDialog(editaAluno, "Data de nascimento inválida!", "Aviso",
												JOptionPane.ERROR_MESSAGE);

									}
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Data de nascimento não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getFormattedTextFieldCpf().getText().equals("           "))) {
									if (!Lists.isCPF(editaAluno.getFormattedTextFieldCpf().getText())) {
										JOptionPane.showMessageDialog(editaAluno, "CPF inválido!", "Aviso",
												JOptionPane.ERROR_MESSAGE);

									}
									if (Validacoes(editaAluno.getFormattedTextFieldCpf().getText(), 2) > 0) { // mudar depois
										JOptionPane.showMessageDialog(editaAluno, "CPF já cadastrado!", "Aviso",
												JOptionPane.ERROR_MESSAGE);

									} else {
										cpf = editaAluno.getFormattedTextFieldCpf().getText().toString();
										contador++;
									}
								}
								// tem essa quantidade de espaços por conta da máscara
								if (!editaAluno.getFormattedTextFieldRg().getText().equals("")
										&& !(editaAluno.getComboBoxEstadoRg().getSelectedItem().equals("SELECIONE"))) {

									rg = editaAluno.getFormattedTextFieldRg().getText();
									uf = editaAluno.getComboBoxEstadoRg().getSelectedItem().toString();
									if (Validacoes(rg, 3) > 0) { // mudar depois
										JOptionPane.showMessageDialog(editaAluno, "RG e UF já cadastrados!", "Aviso",
												JOptionPane.ERROR_MESSAGE);

									} else {
										contador = contador + 2;
									}
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campos RG e UF não preenchidos!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}

								if (!(editaAluno.getFormattedTextFieldDataRg().getText().equals("  /  /    "))) {
									if (Lists.validaData(editaAluno.getFormattedTextFieldDataRg().getText().split("/"))) {
										dataExpedicao = editaAluno.getFormattedTextFieldDataRg().getText();
										contador++;
									} else {
										JOptionPane.showMessageDialog(editaAluno, "Data de expedição inválida!", "Aviso",
												JOptionPane.ERROR_MESSAGE);

									}
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Data de Expedição não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getFormattedTextFieldOrgaoExpeditor().getText()
										.equals("                                                       "))) {
									orgaoExp = arquivo
											.TiraEspaços(editaAluno.getFormattedTextFieldOrgaoExpeditor().getText().toUpperCase());
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Órgão Expeditor não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}

								if (!(editaAluno.getComboBoxCurso().getSelectedItem().equals("SELECIONE"))) {
									curso = editaAluno.getComboBoxCurso().getSelectedItem().toString();
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Curso não selecionado!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getFormattedTextFieldCep().getText().equals("  .   -   "))) {
									cep = editaAluno.getFormattedTextFieldCep().getText();
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo CEP não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getFormattedTextFieldRua().getText().equals("                              "))) {
									rua = arquivo.TiraEspaços(editaAluno.getFormattedTextFieldRua().getText().toUpperCase());
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Rua não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getFormattedTextFieldComplemento().getText()
										.equals("                              "))) {
									complemento = arquivo
											.TiraEspaços(editaAluno.getFormattedTextFieldComplemento().getText().toUpperCase());
								} else {
									complemento = null;
								}
								if (!(editaAluno.getFormattedTextFieldNumero().getText().equals("                              "))) {
									numero = arquivo.TiraEspaços(editaAluno.getFormattedTextFieldNumero().getText().toUpperCase());
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Número não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getFormattedTextFieldBairro().getText().equals("                              "))) {
									bairro = arquivo.TiraEspaços(editaAluno.getFormattedTextFieldBairro().getText().toUpperCase());
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Bairro não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getComboBoxCidades().getSelectedItem().equals("SELECIONE"))) {
									cidade = editaAluno.getComboBoxCidades().getSelectedItem().toString();
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Cidade não selecionado!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!editaAluno.getComboBoxEstadoEndereco().getSelectedItem().equals("SELECIONE")) {
									estado = editaAluno.getComboBoxEstadoEndereco().getSelectedItem().toString();
									contador++;
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo Estado não selecionado!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!editaAluno.getTextFieldEmail().getText().equals("")) {
									if (Lists.isEmail(editaAluno.getTextFieldEmail().getText())) {
										email = editaAluno.getTextFieldEmail().getText();
										contador++;
									} else {
										JOptionPane.showMessageDialog(editaAluno, "E-mail inválido!", "Aviso",
												JOptionPane.ERROR_MESSAGE);

									}
								} else {
									JOptionPane.showMessageDialog(editaAluno, "Campo E-mail não preenchido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}
								if (!(editaAluno.getFormattedTextFieldTelefone().getText().equals("(  )     -    "))) {
									telefone = editaAluno.getFormattedTextFieldTelefone().getText();
									contador++;
								} else {
									if (editaAluno.getFormattedTextFieldCelular().getText().equals("(  )      -    ")) {
										JOptionPane.showMessageDialog(editaAluno, "Campo telefone ou celular deve ser preenchido!",
												"Aviso", JOptionPane.ERROR_MESSAGE);

									} else {
										telefone = null;
									}

								}
								if (!(editaAluno.getFormattedTextFieldCelular().getText().equals("(  )      -    "))) {
									celular = editaAluno.getFormattedTextFieldCelular().getText();
									contador++;
								} else {
									if (editaAluno.getFormattedTextFieldTelefone().getText().equals("(  )     -    ")) {
										JOptionPane.showMessageDialog(editaAluno, "Campo telefone ou celular deve ser preenchido!",
												"Aviso", JOptionPane.ERROR_MESSAGE);

									} else {
										celular = null;
									}
								}
								System.out.println("contador = " + contador);
								if ((contador == 16 || contador == 17)) {
									Endereco endereco = new Endereco(cep, rua, numero, complemento, bairro, cidade, estado);
									aluno.setNome(nome);
									aluno.setCelular(celular);
									aluno.setCurso(curso);
									aluno.setDataExpedicao(dataExpedicao);
									aluno.setDataNascimento(dataNascimento);
									aluno.setEmail(email);
									aluno.setHistoricoDisciplinas(disciplinas);
									aluno.setMatricula(matricula);
									aluno.setOrgaoExp(orgaoExp);
									aluno.setRg(rg);
									aluno.setTelefone(telefone);
									aluno.setUf(uf);
									int count = 0;
									boolean retorno1 = new BancoEnderecoGerenciar().inserirEndereco(endereco);
									boolean retorno2 = new BancoAlunoGerenciar().alterar_aluno(aluno);
									boolean retorno3 = false;
									endereco.setId(Integer.parseInt(new Banco().primeiroEultimo("Endereco","idEndereco", 1)));
									if (disciplinas.size() > 0) {
										int idAluno = new BancoAlunoGerenciar().primeiroEultimo("idAluno", 1);
										for (int i = 0; i < disciplinas.size(); i++) {

											try {
												int idDisciplina = Integer.parseInt(new BancoDisciplinaGerenciar()
														.consultar("nomeDisciplina", disciplinas.get(i).toString(), "idDisciplina"));
												double media = Double.parseDouble(JOptionPane.showInputDialog(editaAluno,
														"Insira a média na disciplina " + disciplinas.get(i).toString(), "Solicitação",
														JOptionPane.OK_CANCEL_OPTION));

												retorno3 = new BancoAlunoGerenciar().inserirHistoricoDisciplinas(
														disciplinas.get(i).toString(), idAluno, idDisciplina, String.valueOf(media));
												if (retorno3)
													count++;

											} catch (Exception e1) {
												JOptionPane.showMessageDialog(editaAluno, "Valor inserido não aceito.", "Erro",
														JOptionPane.ERROR_MESSAGE);
												i--;
											}

										}

									}
									if ((retorno1 && retorno2) && count == disciplinas.size()) {
										JOptionPane.showMessageDialog(editaAluno, "Cadastro realizado com sucesso.");
										frame.dispose();
									} else {
										JOptionPane.showMessageDialog(editaAluno, "Cadastro realizado sem sucesso.");
									}

								} else {
									JOptionPane.showMessageDialog(editaAluno, "Todos os campos devem ser preenchidos.", "Aviso",
											JOptionPane.WARNING_MESSAGE);
								}

							} catch (Exception e1) {
								System.out.println(e1.getMessage());
								e1.printStackTrace();
							}




							}
					}
			});
		}
		if (op == 1) {
			String numMatricula = (String) telaConsAluno.getJTableDados()
					.getValueAt(telaConsAluno.getJTableDados().getSelectedRow(), 1);
			boolean retorno = new BancoAlunoGerenciar().BancoAlunoExcluir(numMatricula);
			Main.aluno.remove(telaConsAluno.getJTableDados().getSelectedRow());
			telaConsAluno.getTabela().fireTableRowsDeleted(telaConsAluno.getJTableDados().getSelectedRow(),
					telaConsAluno.getJTableDados().getSelectedRow());
			System.out.println(retorno);
		}

	}

}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public int Validacoes(String dado, int tipo) {
		int contador = 0;
		// 1 - busca disciplina no arrayList de disciplinas inseridas
		// 2 - busca CPF no array de Aluno
		// 3 - busca RG nno array de Aluno
		// 4 - busca se a disciplina está cadastrada no curso
		try {
			if (tipo == 1) {
				for (int i = 0; i < disciplinas.size(); i++) {
					// System.out.println(disciplinas.get(i).toString());
					if (disciplinas.get(i).toString().equals(dado)) {
						contador++;
						System.out.println(contador);
					}
				}
			} else if (tipo == 2) {
				for (int i = 0; i < Main.aluno.size(); i++) {
					if (Main.aluno.get(i).getCpf().equals(dado)) {
						contador++;
					}
				}
			} else if (tipo == 3) {
				for (int i = 0; i < Main.aluno.size(); i++) {
					if (Main.aluno.get(i).getRg().equals(dado)) {
						contador++;
					}
				}
			} else if (tipo == 4) {
				for (int i = 0; i < Main.disciplina.size(); i++) {
					if (Main.disciplina.get(i).getCurso()
							.equals(editaAluno.getComboBoxCurso().getSelectedItem().toString())) {
						if (Main.disciplina.get(i).getNome_Disciplina().equals(dado)) {
							return 0;
						} else {
							contador = 2;
						}
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return contador;
	}

}
