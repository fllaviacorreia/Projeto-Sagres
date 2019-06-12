package controle;

/**
 *  @author Flávia de Jesus Correia
 *  @author Ian
 *   
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.VisaoPainelCadastroAluno;
import visao.VisaoPainelCadastroClasse;
import visao.VisaoPainelCadastroCurso;
import visao.VisaoPainelCadastroDisciplina;
import visao.VisaoPainelCadastroProfessor;
import visao.VisaoPainelConsultaAluno;
import visao.VisaoPainelConsultaClasse;
import visao.VisaoPainelConsultaCurso;
import visao.VisaoPainelConsultaDisciplina;
import visao.VisaoPainelConsultaProfessor;
import visao.VisaoFramePrincipal;
import visao.VisaoPainelCadastro;

public class ControlePainelCadastro implements ActionListener {
	static VisaoFramePrincipal framePrincipal;
	static VisaoPainelCadastro painelCadastros;
	static VisaoPainelCadastroAluno telaCadAluno;
	static VisaoPainelCadastroDisciplina telaCadDisciplina;
	static VisaoPainelCadastroClasse telaCadClasse;
	static VisaoPainelCadastroCurso telaCadCurso;
	static VisaoPainelCadastroProfessor telaCadProfessor;
	static VisaoPainelConsultaAluno telaConsAluno;
	static VisaoPainelConsultaClasse telaConsClasse;
	static VisaoPainelConsultaCurso telaConsCurso;
	static VisaoPainelConsultaDisciplina telaConsDisciplina;
	static VisaoPainelConsultaProfessor telaConsProfessor;

	public ControlePainelCadastro(VisaoFramePrincipal framePrincipal, VisaoPainelCadastro painelCadastros) {
		ControlePainelCadastro.framePrincipal = framePrincipal;
		ControlePainelCadastro.painelCadastros = painelCadastros;
		System.out.println("Cadastros");
		AddEventos();
//		verifica();
	}

	// Voltar a exibir o Painel Principal Quando necessário
	public static void troca() {
		framePrincipal.trocarPainel(painelCadastros, "Página de Cadastros");
		telaCadAluno = null;
		telaCadDisciplina = null;
		telaCadClasse = null;
		telaCadCurso = null;
		telaCadProfessor = null;
		telaConsAluno = null;
		telaConsClasse = null;
		telaConsCurso = null;
		telaConsDisciplina = null;
		telaConsProfessor = null;
//		verifica();
	}
//	public static void verifica() {
//		if(Main.disciplina.size() < 5 || Main.curso.size() < 1) {
//			painelCadastros.getButtonCadastroAluno().setEnabled(false);	
//			painelCadastros.getButtonCadastroClasse().setEnabled(false);
//			painelCadastros.getButtonCadastroProfessor().setEnabled(false);
//			painelCadastros.getMenuItemAluno().setEnabled(false);
//			painelCadastros.getMenuItemClasse().setEnabled(false);
//			painelCadastros.getMenuItemProfessor().setEnabled(false);
//
//		}else {
//			painelCadastros.getButtonCadastroAluno().setEnabled(true);	
//			painelCadastros.getButtonCadastroClasse().setEnabled(true);
//			painelCadastros.getButtonCadastroProfessor().setEnabled(true);
//			painelCadastros.getMenuItemAluno().setEnabled(true);
//			painelCadastros.getMenuItemClasse().setEnabled(true);
//			painelCadastros.getMenuItemProfessor().setEnabled(true);
//		}
//	}

	public void AddEventos() {
		painelCadastros.getButtonCadastroAluno().addActionListener(this);
		painelCadastros.getButtonCadastroClasse().addActionListener(this);
		painelCadastros.getButtonCadastroCurso().addActionListener(this);
		painelCadastros.getButtonCadastroDisciplina().addActionListener(this);
		painelCadastros.getButtonCadastroProfessor().addActionListener(this);
		// painelCadastros.getButtonCancelar().addActionListener(this);
		// painelCadastros.getButtonFechar().addActionListener(this);
		painelCadastros.getButtonVoltar().addActionListener(this);
		painelCadastros.getMenuCadastros().addActionListener(this);
		painelCadastros.getMenuItemCadastroAluno().addActionListener(this);
		painelCadastros.getMenuItemCadastroClasse().addActionListener(this);
		painelCadastros.getMenuItemCadastroCurso().addActionListener(this);
		painelCadastros.getMenuItemCadastroDisciplina().addActionListener(this);
		painelCadastros.getMenuItemCadastroProfessor().addActionListener(this);
		painelCadastros.getMenuItemConsultaAluno().addActionListener(this);
		painelCadastros.getMenuItemConsultaClasse().addActionListener(this);
		painelCadastros.getMenuItemConsultaCurso().addActionListener(this);
		painelCadastros.getMenuItemConsultaDisciplina().addActionListener(this);
		painelCadastros.getMenuItemConsultaProfessor().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == painelCadastros.getButtonVoltar()) {
			ControlePainelTelaInicial.troca();
		}
		if ((e.getSource() == painelCadastros.getButtonCadastroAluno())
				|| (e.getSource() == painelCadastros.getMenuItemCadastroAluno())) {
			try {
				if (telaCadAluno == null) {
					telaCadAluno = new VisaoPainelCadastroAluno();
				}

				framePrincipal.trocarPainel(telaCadAluno, "Cadastro Aluno");
				new ControlePainelCadastroAluno(telaCadAluno, 2);

				// aluno.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if ((e.getSource() == painelCadastros.getButtonCadastroClasse())
				|| (e.getSource() == painelCadastros.getMenuItemCadastroClasse())) {
			try {
				if (telaCadClasse == null) {
					telaCadClasse = new VisaoPainelCadastroClasse();
				}

				framePrincipal.trocarPainel(telaCadClasse, "Cadastro Classe");
				new ControlePainelCadastroClasse(telaCadClasse, 2);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

		if ((e.getSource() == painelCadastros.getButtonCadastroDisciplina())
				|| (e.getSource() == painelCadastros.getMenuItemCadastroDisciplina())) {
			try {
				if (telaCadDisciplina == null) {
					telaCadDisciplina = new VisaoPainelCadastroDisciplina();
				}

				framePrincipal.trocarPainel(telaCadDisciplina, "Cadastro Disciplina");
				new ControlePainelCadastroDisciplina(telaCadDisciplina, 2);

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if ((e.getSource() == painelCadastros.getButtonCadastroProfessor())
				|| (e.getSource() == painelCadastros.getMenuItemCadastroProfessor())) {
			try {
				if (telaCadProfessor == null) {
					telaCadProfessor = new VisaoPainelCadastroProfessor();
				}

				framePrincipal.trocarPainel(telaCadProfessor, "Cadastro Professor");
				new ControlePainelCadastroProfessor(telaCadProfessor, 2);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if ((e.getSource() == painelCadastros.getButtonCadastroCurso())
				|| (e.getSource() == painelCadastros.getMenuItemCadastroCurso())) {
			try {
				if (telaCadCurso == null) {
					telaCadCurso = new VisaoPainelCadastroCurso();
				}
				framePrincipal.trocarPainel(telaCadCurso, "Cadastro Curso");
				new ControlePainelCadastroCurso(framePrincipal, telaCadCurso, 2);

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

		if (e.getSource() == painelCadastros.getMenuItemConsultaAluno()) {
			try {
				if (telaConsAluno == null) {
					telaConsAluno = new VisaoPainelConsultaAluno();
				}

				framePrincipal.trocarPainel(telaConsAluno, "Consulta Aluno");
				new ControlePainelConsultaAluno(telaConsAluno, 2);
				// aluno.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == painelCadastros.getMenuItemConsultaClasse()) {
			try {
				if (telaCadClasse == null) {
					telaConsClasse = new VisaoPainelConsultaClasse();
				}

				framePrincipal.trocarPainel(telaConsClasse, "Consulta Classe");
				new ControlePainelConsultaClasse(telaConsClasse, 2);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == painelCadastros.getMenuItemConsultaCurso()) {
			try {
				if (telaConsCurso == null) {
					telaConsCurso = new VisaoPainelConsultaCurso();
				}
				framePrincipal.trocarPainel(telaConsCurso, "Consulta Curso");
				new ControlePainelConsultaCurso(telaConsCurso, 2);

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == painelCadastros.getMenuItemConsultaDisciplina()) {
			try {
				if (telaConsDisciplina == null) {
					telaConsDisciplina = new VisaoPainelConsultaDisciplina();
				}
				framePrincipal.trocarPainel(telaConsDisciplina, "Consulta Disciplina");
				new ControlePainelConsultaDisciplina(telaConsDisciplina, 2);
				// disciplina.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

		if (e.getSource() == painelCadastros.getMenuItemConsultaProfessor()) {
			try {
				if (telaConsProfessor == null) {
					telaConsProfessor = new VisaoPainelConsultaProfessor();
				}

				framePrincipal.trocarPainel(telaConsProfessor, "Consulta Professor");
				new ControlePainelConsultaProfessor(telaConsProfessor, 2);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
//		if(e.getSource() == painelCadastros.getButtonCancelar()){
//			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//		}

//		if(e.getSource() == painelCadastros.getButtonFechar()){
//			try {
//				saida = JOptionPane.showConfirmDialog(painelCadastros, "Deseja realmente fechar o programa?", "Confirmação de saída", JOptionPane.YES_NO_OPTION);
//			//	System.out.println(saida);
//				
//				if(saida == 0)
//					System.exit(0);
//				
//			}catch(Exception e1) {
//				System.out.println(e1.getMessage());
//				e1.printStackTrace();
//			}
//		}

//		if(e.getSource() == painelCadastros.getMenuConsultas()) {
//			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//		}
//		if(e.getSource() == painelCadastros.getMenuOpcoes()) {
//			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//		}
//		if(e.getSource() == painelCadastros.getMenuSobre()) {
//			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//		}
//		if(e.getSource() == painelCadastros.getMenuItemAluno()) {
//			try {
//				if(telaCadAluno == null) {
//					telaCadAluno = new VisaoPainelCadastroAluno();
//				}	
//				
//				framePrincipal.trocarPainel(telaCadAluno, "Cadastro Aluno");
//				new ControlePainelAluno(telaCadAluno, 2);
//				//aluno.troca();
//			}catch(Exception e1) {
//				System.out.println(e1.getMessage());
//				e1.printStackTrace();
//			}
//		}
//		if(e.getSource() == painelCadastros.getMenuItemClasse()) {
//			try {
//				if(telaCadClasse == null) {
//					telaCadClasse = new VisaoPainelCadastroClasse();
//				}	
//				
//				framePrincipal.trocarPainel(telaCadClasse, "Cadastro Classe");
//				new ControlePainelClasse(telaCadClasse, 2);
//			}catch(Exception e1) {
//				System.out.println(e1.getMessage());
//				e1.printStackTrace();
//			}
//		}
//		if(e.getSource() == painelCadastros.getMenuItemCurso()) {
//			try {
//				if(telaCadCurso == null) {
//					telaCadCurso = new VisaoPainelCadastroCurso();
//				}
//				framePrincipal.trocarPainel(telaCadCurso, "Cadastro Curso");
//				new ControlePainelCurso(telaCadCurso, 2);
//				
//			}catch(Exception e1) {
//				System.out.println(e1.getMessage());
//				e1.printStackTrace();
//			}
//		}
//		if(e.getSource() == painelCadastros.getMenuItemDisciplina()) {
//			try {
//				if(telaCadDisciplina == null) {
//					telaCadDisciplina = new VisaoPainelCadastroDisciplina();
//				}	
//			
//				framePrincipal.trocarPainel(telaCadDisciplina, "Cadastro Disciplina");	
//				new ControlePainelDisciplina(telaCadDisciplina, 2);
//				//disciplina.troca();
//			}catch(Exception e1) {
//				System.out.println(e1.getMessage());
//				e1.printStackTrace();
//			}
//		}
//		if(e.getSource() == painelCadastros.getMenuItemProfessor()) {
//			try {
//				if(telaCadProfessor == null) {
//					telaCadProfessor = new VisaoPainelCadastroProfessor();
//				}	
//				
//				framePrincipal.trocarPainel(telaCadProfessor, "Cadastro Professor");
//				new ControlePainelProfessor(telaCadProfessor, 2);
//			}catch(Exception e1) {
//				System.out.println(e1.getMessage());
//				e1.printStackTrace();
//			}
//		}
	}

	public static VisaoFramePrincipal getFramePrincipal() {
		return framePrincipal;
	}

	public static void setFramePrincipal(VisaoFramePrincipal framePrincipal) {
		ControlePainelCadastro.framePrincipal = framePrincipal;
	}

}
