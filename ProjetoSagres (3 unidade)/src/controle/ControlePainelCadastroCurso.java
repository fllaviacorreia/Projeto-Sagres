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

import banco.BancoCursoGerenciar;
import modelo.Curso;
import visao.VisaoFramePrincipal;
import visao.VisaoPainelCadastroCurso;
import visao.VisaoPainelFluxograma;

public class ControlePainelCadastroCurso implements ActionListener {
	static VisaoPainelCadastroCurso telaCadCurso;
	static VisaoPainelFluxograma telaFluxograma;
	static VisaoFramePrincipal framePrincipal;
	Curso dados;
	private int contador;
	private int saida;
	private int volta;
	private String cargaHorariaTotal;
	private String nome;
	private String tipoHorario;
	private String semestres;
	private String tipoCurso;
	private String tipoGraduacao = "";
	
	public ControlePainelCadastroCurso(VisaoFramePrincipal framePrincipal, VisaoPainelCadastroCurso telaCadCurso, int volta) {
		this.framePrincipal = framePrincipal;
		ControlePainelCadastroCurso.telaCadCurso = telaCadCurso;
		this.volta = volta;
		telaCadCurso.setVisible(true);
		AddEventos();
		// preecheComboBox();
	}

	public void AddEventos() {
//		telaCadCurso.getButtonAdicionarCargaHoraria().addActionListener(this);
		telaCadCurso.getButtonCancelar().addActionListener(this);
		telaCadCurso.getButtonConfirmar().addActionListener(this);
		telaCadCurso.getButtonVoltar().addActionListener(this);
		telaCadCurso.getComboBoxTipoCurso().addActionListener(this);
		telaCadCurso.getComboBoxTipoGraduacao().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaCadCurso.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadCurso, "Deseja realmente voltar?", "Confirmação de saída",
						JOptionPane.YES_NO_OPTION);
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

		if (e.getSource() == telaCadCurso.getButtonCancelar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadCurso, "Deseja realmente cancelar o cadastro?",
						"Confirmação de saída", JOptionPane.YES_NO_OPTION);
				if (saida == 0) {
					LimpaDados();
				//	ControlePainelCadastro.troca();
				}
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadCurso.getComboBoxTipoCurso()) {
			if(telaCadCurso.getComboBoxTipoCurso().getSelectedItem().equals("GRADUAÇÃO")) {
				telaCadCurso.getLabelTipoDaGraduacao().setEnabled(true);
				telaCadCurso.getComboBoxTipoGraduacao().setEnabled(true);
			}else {
				telaCadCurso.getLabelTipoDaGraduacao().setEnabled(false);
				telaCadCurso.getComboBoxTipoGraduacao().setEnabled(false);
				telaCadCurso.getComboBoxTipoGraduacao().setSelectedIndex(0);
			}
		}
		if (e.getSource() == telaCadCurso.getButtonConfirmar()) {
			try {
				contador = 0;
				if (!telaCadCurso.getFormattedTextFieldNomeCurso().getText()
						.equals("                                                       ")) {
					nome = telaCadCurso.getFormattedTextFieldNomeCurso().getText().toString().toUpperCase();
					if (verificaNomes(nome)) {
						JOptionPane.showMessageDialog(telaCadCurso, "Nome já cadastrado!", "Aviso",
								JOptionPane.WARNING_MESSAGE);
					} else {
						contador++;
					}

				}
				if (!telaCadCurso.getComboBoxSemestresTotais().getSelectedItem().equals("SELECIONE")) {
					semestres =telaCadCurso.getComboBoxSemestresTotais().getSelectedItem().toString();
					contador++;
				}
				if (!telaCadCurso.getComboBoxCargaHorariaTotal().getSelectedItem().equals("SELECIONE")) {
					cargaHorariaTotal = telaCadCurso.getComboBoxCargaHorariaTotal().getSelectedItem().toString();
					contador++;
				}
				if (!telaCadCurso.getComboBoxHorario().getSelectedItem().equals("SELECIONE")) {
					tipoHorario = telaCadCurso.getComboBoxHorario().getSelectedItem().toString();
					contador++;
				}
				if(!telaCadCurso.getComboBoxTipoCurso().getSelectedItem().equals("SELECIONE")) {
					tipoCurso = telaCadCurso.getComboBoxTipoCurso().getSelectedItem().toString();
					if(tipoCurso.equals("GRADUAÇÃO")) {
						if(!telaCadCurso.getComboBoxTipoGraduacao().getSelectedItem().equals("SELECIONE")) {
							tipoGraduacao = telaCadCurso.getComboBoxTipoGraduacao().getSelectedItem().toString();
							contador++;
						}else{
							JOptionPane.showMessageDialog(telaCadCurso, "Selecione o tipo da graduação.", "Aviso", JOptionPane.ERROR_MESSAGE);
						}
							
					}else {
						contador++;
					}
				}
				
				if (contador == 5) {
					dados = new Curso(cargaHorariaTotal, nome, tipoHorario, semestres, tipoCurso, tipoGraduacao);
					// new ControleArquivo(3);
					BancoCursoGerenciar bancoCurso = new BancoCursoGerenciar();
					boolean retorno1 = bancoCurso.BancoCursoInserir(dados);

					if (retorno1)
						JOptionPane.showMessageDialog(telaCadCurso, "Cadastro realizado com sucesso.");

					LimpaDados();
				} else {
					JOptionPane.showMessageDialog(telaCadCurso, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
	}

	// método que preenche o comboBox curso com os adicionados e cadastrados ta
	// telaDisciplina

//	public void preecheComboBox() {
//		telaCadCurso.getComboBoxCurso().addItem("SELECIONE");
//		ArrayList<String> disc = new ArrayList<String>();
//		String dis;
//		dis = Main.disciplina.get(0).getCurso();
//		disc.add(dis);
//		int cont;
//		for(int i = 1; i < Main.disciplina.size(); i++) {
//			cont = 0;
//			dis = Main.disciplina.get(i).getCurso().toString();
//			
//			if(disc.get(i).equals(dis)) {
//				cont ++;
//			}
//			if(cont == 0)
//				disc.add(dis);
//		}
//		
//		for(int i = 0; i<disc.size(); i++) {
//			telaCadCurso.getComboBoxCurso().addItem(disc.get(i).toString());
//		}
//	}

	public boolean verificaNomes(String nome) {
		ArrayList<String> cursoNomes = new BancoCursoGerenciar().consultarUmaColuna("Curso", "nomeCurso");
		for (int i = 0; i < cursoNomes.size(); i++) {
			if (cursoNomes.get(i).equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public void LimpaDados() {
		telaCadCurso.getLabelTipoDaGraduacao().setEnabled(false);
		telaCadCurso.getComboBoxTipoGraduacao().setEnabled(false);
		telaCadCurso.getComboBoxTipoGraduacao().setSelectedIndex(0);
		telaCadCurso.getComboBoxTipoCurso().setSelectedIndex(0);
		telaCadCurso.getFormattedTextFieldNomeCurso().setText(null);
		telaCadCurso.getComboBoxCargaHorariaTotal().setSelectedIndex(0);
		telaCadCurso.getComboBoxHorario().setSelectedIndex(0);
		telaCadCurso.getComboBoxSemestresTotais().setSelectedIndex(0);
		
	}

}
