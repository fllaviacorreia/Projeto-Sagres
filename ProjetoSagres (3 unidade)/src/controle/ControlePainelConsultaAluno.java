package controle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import banco.Banco;
import banco.BancoAlunoGerenciar;
import banco.BancoEnderecoGerenciar;
import modelo.Aluno;
import modelo.Arquivo;
import modelo.Endereco;
import modelo.Lists;
import visao.VisaoFramePrincipal;
import visao.VisaoPainelConsultaAluno;
import visao.VisaoPainelEditaAluno;

public class ControlePainelConsultaAluno implements ActionListener {
	int volta;
	static VisaoPainelConsultaAluno telaConsAluno;
	static VisaoPainelEditaAluno editaAluno;
	static VisaoFramePrincipal frame;
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
	private boolean mudou = false;
	private ArrayList<String> disciplinas = new ArrayList<String>();
	Aluno aluno;
	Endereco endereco;
	Arquivo arquivo = new Arquivo(0);
	public ControlePainelConsultaAluno(VisaoPainelConsultaAluno telaConsAluno, int volta) {
		ControlePainelConsultaAluno.telaConsAluno = telaConsAluno;
		this.volta = volta;
		AddEventos();
	}

	public void AddEventos() {
		telaConsAluno.getButtonVoltar().addActionListener(this);
		telaConsAluno.getJTableDados().addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getSource() == telaConsAluno.getJTableDados()) {
					Object[] Vetor = { "Atualizar", "Excluir", "Cancelar" };

					int op = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Op��es:", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, Vetor, Vetor[0]);
					System.out.println(op);
					if (op == 0) {
						System.out.println("op = 0");
						eventoAtualizar();
					}
					if (op == 1) {
						String numMatricula = (String) telaConsAluno.getJTableDados()
								.getValueAt(telaConsAluno.getJTableDados().getSelectedRow(), 1);
						boolean retorno = new BancoAlunoGerenciar().BancoAlunoExcluir(numMatricula);
						if(retorno) {
							Main.aluno.remove(telaConsAluno.getJTableDados().getSelectedRow());
							telaConsAluno.getTabela().fireTableRowsDeleted(telaConsAluno.getJTableDados().getSelectedRow(),
								telaConsAluno.getJTableDados().getSelectedRow());
							JOptionPane.showMessageDialog(null, "Aluno exclu�do com sucesso.");
						}else {
							JOptionPane.showMessageDialog(null, "Erro ao excluir aluno.");
						}
						
						System.out.println(retorno);
					}

				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public int Validacoes(String dado, int tipo) {
		int contador = 0;
		// 1 - busca disciplina no arrayList de disciplinas inseridas
		// 2 - busca CPF no array de Aluno
		// 3 - busca RG nno array de Aluno
		// 4 - busca se a disciplina est� cadastrada no curso
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

	public void eventoAtualizar(){
		editaAluno = new VisaoPainelEditaAluno();
		aluno = Main.aluno.get(telaConsAluno.getJTableDados().getSelectedRow());
		int idEndereco = Integer.parseInt(new BancoAlunoGerenciar().consultar("idAluno", String.valueOf(aluno.getId()), "Endereco_idEndereco"));
		int i = -1;
		do {
			i++;
		}while(!(Main.endereco.get(i).getId() == idEndereco));
		
		endereco = Main.endereco.get(i);
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
		editaAluno.getFormattedTextFieldRua().setText(endereco.getRua());
		editaAluno.getFormattedTextFieldNumero().setText(endereco.getNumero());
		editaAluno.getFormattedTextFieldComplemento().setText(endereco.getComplemento());
		editaAluno.getFormattedTextFieldBairro().setText(endereco.getBairro());
		editaAluno.getComboBoxEstadoEndereco().setSelectedItem(endereco.getEstado());
		EventoEstado();
		editaAluno.getComboBoxCidades().setSelectedItem(endereco.getCidade());
		frame = new VisaoFramePrincipal();
		frame.setBounds(10, 10, 860, 550);
		frame.setLocationRelativeTo(null);
		frame.setBackground(new Color(8, 42, 108));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setContentPane(editaAluno);
		frame.repaint();
		frame.validate();
		
		editaAluno.getButtonCancelar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == editaAluno.getButtonCancelar()) {
					int saida = JOptionPane.showConfirmDialog(null,
							"Deseja realmente cancelar a atualiza��o dos dados?", "Confirma��o de sa�da",
							JOptionPane.YES_NO_OPTION);
					if (saida == 0) {
						frame.dispose();
					}
				}
			}
		});
		
		editaAluno.getFormattedTextFieldCep().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == editaAluno.getFormattedTextFieldCep()) {
					for(int i = 0; i < Main.endereco.size(); i++) {
						
						if(editaAluno.getFormattedTextFieldCep().getText().equals(Main.endereco.get(i).getCep())) {
							editaAluno.getFormattedTextFieldRua().setText(Main.endereco.get(i).getRua());
							editaAluno.getFormattedTextFieldComplemento().setText(Main.endereco.get(i).getComplemento());
							editaAluno.getFormattedTextFieldBairro().setText(Main.endereco.get(i).getBairro());
							editaAluno.getComboBoxEstadoEndereco().setSelectedItem(Main.endereco.get(i).getEstado());
							editaAluno.getComboBoxCidades().setSelectedItem(Main.endereco.get(i).getCidade());
							mudou = true;
						}else {
							mudou = false;
						}
					}
				}
				
			}
		});
		editaAluno.getComboBoxEstadoEndereco().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == editaAluno.getComboBoxEstadoEndereco()) {
					EventoEstado();
				}
				
			}
		});
		editaAluno.getButtonConfirmar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int contador = 0;
				if (e.getSource() == editaAluno.getButtonConfirmar()) {
					try {
						contador = 0;

						// tem essa quantidade de espa�os por conta da m�scara
						if (!editaAluno.getFormattedTextFieldNomeAluno().getText()
								.equals("                                                       ")) {
							nome = arquivo.TiraEspacos(editaAluno.getFormattedTextFieldNomeAluno().getText()
									.toString().toUpperCase());
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo Nome n�o preenchido!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getFormattedTextFieldDataNascimento().getText()
								.equals("  /  /    "))) {
							if (Lists.validaData(
									editaAluno.getFormattedTextFieldDataNascimento().getText().split("/"))) {
								dataNascimento = editaAluno.getFormattedTextFieldDataNascimento().getText();
								contador++;
							} else {
								JOptionPane.showMessageDialog(editaAluno, "Data de nascimento inv�lida!",
										"Aviso", JOptionPane.ERROR_MESSAGE);

							}
						} else {
							JOptionPane.showMessageDialog(editaAluno,
									"Campo Data de nascimento n�o preenchido!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getFormattedTextFieldCpf().getText().equals("           "))) {
							cpf = editaAluno.getFormattedTextFieldCpf().getText();
							if (!cpf.equals(aluno.getCpf())){
								if (!Lists.isCPF(editaAluno.getFormattedTextFieldCpf().getText())) {
									JOptionPane.showMessageDialog(editaAluno, "CPF inv�lido!", "Aviso",
											JOptionPane.ERROR_MESSAGE);
								}if (Validacoes(editaAluno.getFormattedTextFieldCpf().getText(), 2) > 0) { // mudar
									// depois
									JOptionPane.showMessageDialog(editaAluno, "CPF j� cadastrado!", "Aviso",
											JOptionPane.ERROR_MESSAGE);

								}else {
									cpf = editaAluno.getFormattedTextFieldCpf().getText().toString();
									contador++;
								}
							}else {
								contador++;
							}
						}
						// tem essa quantidade de espa�os por conta da m�scara
						if (!editaAluno.getFormattedTextFieldRg().getText().equals("")
								&& !(editaAluno.getComboBoxEstadoRg().getSelectedItem().equals("SELECIONE"))) {

							rg = editaAluno.getFormattedTextFieldRg().getText();
							uf = editaAluno.getComboBoxEstadoRg().getSelectedItem().toString();
							if (!(rg.equals(aluno.getRg()) && uf.equals(aluno.getUf()))) {
								if (Validacoes(rg, 3) > 0) { // mudar depois
									JOptionPane.showMessageDialog(editaAluno, "RG e UF j� cadastrados!",
											"Aviso", JOptionPane.ERROR_MESSAGE);

								} else {
									contador = contador + 2;
								}
							}else {
								contador = contador + 2;
							}

						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campos RG e UF n�o preenchidos!",
									"Aviso", JOptionPane.ERROR_MESSAGE);

						}

						if (!(editaAluno.getFormattedTextFieldDataRg().getText().equals("  /  /    "))) {
							if (Lists.validaData(
									editaAluno.getFormattedTextFieldDataRg().getText().split("/"))) {
								dataExpedicao = editaAluno.getFormattedTextFieldDataRg().getText();
								contador++;
							} else {
								JOptionPane.showMessageDialog(editaAluno, "Data de expedi��o inv�lida!",
										"Aviso", JOptionPane.ERROR_MESSAGE);

							}
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo Data de Expedi��o n�o preenchido!",
									"Aviso", JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getFormattedTextFieldOrgaoExpeditor().getText()
								.equals("                                                       "))) {
							orgaoExp = arquivo.TiraEspacos(
									editaAluno.getFormattedTextFieldOrgaoExpeditor().getText().toUpperCase());
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo �rg�o Expeditor n�o preenchido!",
									"Aviso", JOptionPane.ERROR_MESSAGE);

						}

						if (!(editaAluno.getComboBoxCurso().getSelectedItem().equals("SELECIONE"))) {
							curso = editaAluno.getComboBoxCurso().getSelectedItem().toString();
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo Curso n�o selecionado!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getFormattedTextFieldCep().getText().equals("  .   -   "))) {
							cep = editaAluno.getFormattedTextFieldCep().getText();
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo CEP n�o preenchido!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getFormattedTextFieldRua().getText()
								.equals("                              "))) {
							rua = arquivo
									.TiraEspacos(editaAluno.getFormattedTextFieldRua().getText().toUpperCase());
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo Rua n�o preenchido!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getFormattedTextFieldComplemento().getText()
								.equals("                              "))) {
							complemento = arquivo.TiraEspacos(
									editaAluno.getFormattedTextFieldComplemento().getText().toUpperCase());
						} else {
							complemento = null;
						}
						if (!(editaAluno.getFormattedTextFieldNumero().getText()
								.equals("                              "))) {
							numero = arquivo.TiraEspacos(
									editaAluno.getFormattedTextFieldNumero().getText().toUpperCase());
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo N�mero n�o preenchido!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getFormattedTextFieldBairro().getText()
								.equals("                              "))) {
							bairro = arquivo.TiraEspacos(
									editaAluno.getFormattedTextFieldBairro().getText().toUpperCase());
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo Bairro n�o preenchido!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getComboBoxCidades().getSelectedItem().equals("SELECIONE"))) {
							cidade = editaAluno.getComboBoxCidades().getSelectedItem().toString();
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo Cidade n�o selecionado!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!editaAluno.getComboBoxEstadoEndereco().getSelectedItem().equals("SELECIONE")) {
							estado = editaAluno.getComboBoxEstadoEndereco().getSelectedItem().toString();
							contador++;
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo Estado n�o selecionado!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!editaAluno.getTextFieldEmail().getText().equals("")) {
							if (Lists.isEmail(editaAluno.getTextFieldEmail().getText())) {
								email = editaAluno.getTextFieldEmail().getText();
								contador++;
							} else {
								JOptionPane.showMessageDialog(editaAluno, "E-mail inv�lido!", "Aviso",
										JOptionPane.ERROR_MESSAGE);

							}
						} else {
							JOptionPane.showMessageDialog(editaAluno, "Campo E-mail n�o preenchido!", "Aviso",
									JOptionPane.ERROR_MESSAGE);

						}
						if (!(editaAluno.getFormattedTextFieldTelefone().getText().equals("(  )     -    "))) {
							telefone = editaAluno.getFormattedTextFieldTelefone().getText();
							contador++;
						} else {
							if (editaAluno.getFormattedTextFieldCelular().getText().equals("(  )      -    ")) {
								JOptionPane.showMessageDialog(editaAluno,
										"Campo telefone ou celular deve ser preenchido!", "Aviso",
										JOptionPane.ERROR_MESSAGE);

							} else {
								telefone = null;
							}

						}
						if (!(editaAluno.getFormattedTextFieldCelular().getText().equals("(  )      -    "))) {
							celular = editaAluno.getFormattedTextFieldCelular().getText();
							contador++;
						} else {
							if (editaAluno.getFormattedTextFieldTelefone().getText().equals("(  )     -    ")) {
								JOptionPane.showMessageDialog(editaAluno,
										"Campo telefone ou celular deve ser preenchido!", "Aviso",
										JOptionPane.ERROR_MESSAGE);

							} else {
								celular = null;
							}
						}
						System.out.println("contador = " + contador);
						if ((contador == 16 || contador == 17)) {
							boolean retorno1;
							if(mudou) {
								endereco = new Endereco(cep, rua, numero, complemento, bairro, cidade, estado);
								retorno1 = new BancoEnderecoGerenciar().inserirEndereco(endereco);
								endereco.setId(Integer.parseInt(new Banco().primeiroEultimo("Endereco", "idEndereco", 1)));
							}
								
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
							boolean retorno2 = new BancoAlunoGerenciar().alterar_aluno(aluno);
							
//							boolean retorno3 = false;
//							if (disciplinas.size() > 0) {
//								int idAluno = new BancoAlunoGerenciar().primeiroEultimo("idAluno", 1);
//								for (int i = 0; i < disciplinas.size(); i++) {
//
//									try {
//										int idDisciplina = Integer.parseInt(
//												new BancoDisciplinaGerenciar().consultar("nomeDisciplina",
//														disciplinas.get(i).toString(), "idDisciplina"));
//										double media = Double
//												.parseDouble(JOptionPane.showInputDialog(editaAluno,
//														"Insira a m�dia na disciplina "
//																+ disciplinas.get(i).toString(),
//																"Solicita��o", JOptionPane.OK_CANCEL_OPTION));
//
//										retorno3 = new BancoAlunoGerenciar().inserirHistoricoDisciplinas(
//												disciplinas.get(i).toString(), idAluno, idDisciplina,
//												String.valueOf(media));
//										if (retorno3)
//											count++;
//
//									} catch (Exception e1) {
//										JOptionPane.showMessageDialog(editaAluno, "Valor inserido n�o aceito.",
//												"Erro", JOptionPane.ERROR_MESSAGE);
//										i--;
//									}
//
//								}
//
//							}
							if ((retorno2) && count == disciplinas.size()) {
								JOptionPane.showMessageDialog(editaAluno, "Atualiza��o de cadastro realizado com sucesso.");
								frame.dispose();
							} else {
								JOptionPane.showMessageDialog(editaAluno, "Ocorreu algum erro ao tentar atualizar o cadastro.");
							}

						} else {
							JOptionPane.showMessageDialog(editaAluno, "Todos os campos devem ser preenchidos.",
									"Aviso", JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						e1.printStackTrace();
					}

				}
			}
		});
	}
	public void EventoEstado() {
		if (!editaAluno.getComboBoxEstadoEndereco().getSelectedItem().equals("SELECIONE")) {
			ArrayList<String> cidade = null;
			try {
				cidade = arquivo.EscreveCidades(editaAluno.getComboBoxEstadoEndereco().getSelectedItem().toString());
				editaAluno.getComboBoxCidades().removeAllItems();
				editaAluno.getComboBoxCidades().addItem("SELECIONE");
				for (int i = 0; i < cidade.size(); i++) {
					editaAluno.getComboBoxCidades().addItem(cidade.get(i));
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaConsAluno.getButtonVoltar()) {
			int saida = JOptionPane.showConfirmDialog(telaConsAluno, "Deseja realmente voltar?", "Confirma��o de sa�da",
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
		
	}
}
