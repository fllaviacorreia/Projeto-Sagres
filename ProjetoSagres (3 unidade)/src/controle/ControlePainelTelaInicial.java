package controle;

/**
 *  @author Flávia de Jesus Correia
 *   
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.VisaoFramePrincipal;
import visao.VisaoPainelCadastroAluno;
import visao.VisaoPainelCadastroClasse;
import visao.VisaoPainelCadastroCurso;
import visao.VisaoPainelCadastroDisciplina;
import visao.VisaoPainelCadastroProfessor;
import visao.VisaoPainelCadastro;
import visao.VisaoPainelConsulta;
import visao.VisaoPainelConsultaAluno;
import visao.VisaoPainelConsultaClasse;
import visao.VisaoPainelConsultaCurso;
import visao.VisaoPainelConsultaDisciplina;
import visao.VisaoPainelConsultaProfessor;
import visao.VisaoPainelTelaInicial;

public class ControlePainelTelaInicial implements ActionListener {
	static VisaoPainelTelaInicial 		 telaInicial;
	static VisaoPainelCadastro 			 telaCadastros;
	static VisaoFramePrincipal 			 framePrincipal;
	static VisaoPainelCadastroAluno		 telaCadAluno;
	static VisaoPainelCadastroDisciplina telaCadDisciplina;
	static VisaoPainelCadastroClasse 	 telaCadClasse;
	static VisaoPainelCadastroCurso		 telaCadCurso;
	static VisaoPainelCadastroProfessor	 telaCadProfessor;
	static VisaoPainelConsulta			 telaCadConsulta;
	static VisaoPainelConsultaAluno		 telaConsAluno;
	static VisaoPainelConsultaClasse	 telaConsClasse;
	static VisaoPainelConsultaCurso		 telaConsCurso;
	static VisaoPainelConsultaDisciplina telaConsDisciplina;
	static VisaoPainelConsultaProfessor	 telaConsProfessor;

	public ControlePainelTelaInicial(VisaoFramePrincipal framePrincipal, VisaoPainelTelaInicial telaInicial) {
		// inicializa();
		ControlePainelTelaInicial.framePrincipal = framePrincipal;
		ControlePainelTelaInicial.telaInicial = telaInicial;
		AdcEventos();
		System.out.println("Inicial");
//		verifica();
	}

	// public void inicializa() {
	// framePrincipal = new VisaoFramePrincipal();
	// telaInicial = new VisaoPainelTelaInicial();
	// troca();
	// }

	public void AdcEventos() {
		telaInicial.getButtonCadastros().addActionListener(this);
		telaInicial.getButtonSobre().addActionListener(this);
		telaInicial.getButtonConsultas().addActionListener(this);
		telaInicial.getButtonOpcoes().addActionListener(this);
		// telaInicial.getButtonCancelar().addActionListener(this);
		telaInicial.getButtonFechar().addActionListener(this);
		telaInicial.getButtonSair().addActionListener(this);
//		telaInicial.getMenuConsultas().addActionListener(this);
//		telaInicial.getMenuOpcoes().addActionListener(this);
//		telaInicial.getMenuSobre().addActionListener(this);
		telaInicial.getMenuItemCadastroAluno().addActionListener(this);
		telaInicial.getMenuItemCadastroClasse().addActionListener(this);
		telaInicial.getMenuItemCadastroCurso().addActionListener(this);
		telaInicial.getMenuItemCadastroDisciplina().addActionListener(this);
		telaInicial.getMenuItemCadastroProfessor().addActionListener(this);
		telaInicial.getMenuItemConsultaAluno().addActionListener(this);
		telaInicial.getMenuItemConsultaClasse().addActionListener(this);
		telaInicial.getMenuItemConsultaCurso().addActionListener(this);
		telaInicial.getMenuItemConsultaDisciplina().addActionListener(this);
		telaInicial.getMenuItemConsultaProfessor().addActionListener(this);

	}

	public static void troca() {
		framePrincipal.trocarPainel(telaInicial, "Página Inicial");
		telaCadAluno = null;
		telaCadDisciplina = null;
		telaCadClasse = null;
		telaCadCurso = null;
		telaCadProfessor = null;
		telaCadConsulta = null;
		telaConsAluno = null;
		telaConsClasse = null;
		telaConsCurso = null;
		telaConsDisciplina = null;
		telaConsProfessor = null;
//		verifica();
	}

//	public static void verifica() {
//		if(Main.disciplina.size() < 5 || Main.curso.size() < 1) {
//			telaInicial.getMenuItemAluno().setEnabled(false);	
//			telaInicial.getMenuItemClasse().setEnabled(false);	
//			telaInicial.getMenuItemProfessor().setEnabled(false);		
//		}else {
//			telaInicial.getMenuItemAluno().setEnabled(true);	
//			telaInicial.getMenuItemClasse().setEnabled(true);	
//			telaInicial.getMenuItemProfessor().setEnabled(true);		
//			
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaInicial.getButtonCadastros()) {
			try {
				if (telaCadastros == null) {
					telaCadastros = new VisaoPainelCadastro();
				}

				framePrincipal.trocarPainel(telaCadastros, "Página de Cadastros");
				new ControlePainelCadastro(framePrincipal, telaCadastros);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == telaInicial.getButtonSobre()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == telaInicial.getButtonConsultas()) {
			if (telaCadConsulta == null) {
				telaCadConsulta = new VisaoPainelConsulta();
			}
			framePrincipal.trocarPainel(telaCadConsulta, "Página de Consultas");
			new ControlePainelConsulta(framePrincipal, telaCadConsulta);

		}
		if (e.getSource() == telaInicial.getButtonOpcoes()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == telaInicial.getButtonSair()) {
			int saida;
			try {
				saida = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);

				if (saida == 0) {
					ControlePainelTelaLogin.troca();
					telaInicial.setVisible(false);
				}

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if (e.getSource() == telaInicial.getButtonFechar()) {
			int saida;
			try {
				saida = JOptionPane.showConfirmDialog(telaInicial, "Deseja realmente fechar o programa?",
						"Confirmação de saída", JOptionPane.YES_NO_OPTION);
				// System.out.println(saida);

				if (saida == 0)
					System.exit(0);

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
//		if(e.getSource() == telaInicial.getMenuConsultas()) {
//			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//		}
		if (e.getSource() == telaInicial.getMenuOpcoes()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == telaInicial.getMenuSobre()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == telaInicial.getMenuItemCadastroAluno()) {
			try {
				if (telaCadAluno == null) {
					telaCadAluno = new VisaoPainelCadastroAluno();
				}

				framePrincipal.trocarPainel(telaCadAluno, "Cadastro Aluno");
				new ControlePainelCadastroAluno(telaCadAluno, 1);
				// aluno.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == telaInicial.getMenuItemCadastroClasse()) {

			try {
				if (telaCadClasse == null) {
					telaCadClasse = new VisaoPainelCadastroClasse();
				}

				framePrincipal.trocarPainel(telaCadClasse, "Cadastro Classe");
				new ControlePainelCadastroClasse(telaCadClasse, 1);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == telaInicial.getMenuItemCadastroCurso()) {
			try {
				if (telaCadCurso == null) {
					telaCadCurso = new VisaoPainelCadastroCurso();
				}
				framePrincipal.trocarPainel(telaCadCurso, "Cadastro Curso");
				new ControlePainelCadastroCurso(framePrincipal, telaCadCurso, 1);

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == telaInicial.getMenuItemCadastroDisciplina()) {
			try {
				if (telaCadDisciplina == null) {
					telaCadDisciplina = new VisaoPainelCadastroDisciplina();
				}
				framePrincipal.trocarPainel(telaCadDisciplina, "Cadastro Disciplina");
				new ControlePainelCadastroDisciplina(telaCadDisciplina, 1);
				// disciplina.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

		if (e.getSource() == telaInicial.getMenuItemConsultaProfessor()) {
			try {
				if (telaCadProfessor == null) {
					telaCadProfessor = new VisaoPainelCadastroProfessor();
				}

				framePrincipal.trocarPainel(telaCadProfessor, "Cadastro Professor");
				new ControlePainelCadastroProfessor(telaCadProfessor, 1);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}

		if (e.getSource() == telaInicial.getMenuItemConsultaAluno()) {
			try {
				if (telaConsAluno == null) {
					telaConsAluno = new VisaoPainelConsultaAluno();
				}

				framePrincipal.trocarPainel(telaConsAluno, "Consulta Aluno");
				new ControlePainelConsultaAluno(telaConsAluno, 1);
				// aluno.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == telaInicial.getMenuItemConsultaClasse()) {
			try {
				if (telaCadClasse == null) {
					telaConsClasse = new VisaoPainelConsultaClasse();
				}

				framePrincipal.trocarPainel(telaConsClasse, "Consulta Classe");
				new ControlePainelConsultaClasse(telaConsClasse, 1);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == telaInicial.getMenuItemConsultaCurso()) {
			try {
				if (telaConsCurso == null) {
					telaConsCurso = new VisaoPainelConsultaCurso();
				}
				framePrincipal.trocarPainel(telaConsCurso, "Consulta Curso");
				new ControlePainelConsultaCurso(telaConsCurso, 1);

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == telaInicial.getMenuItemConsultaDisciplina()) {
			try {
				if (telaConsDisciplina == null) {
					telaConsDisciplina = new VisaoPainelConsultaDisciplina();
				}
				framePrincipal.trocarPainel(telaConsDisciplina, "Consulta Disciplina");
				new ControlePainelConsultaDisciplina(telaConsDisciplina, 1);
				// disciplina.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

		if (e.getSource() == telaInicial.getMenuItemConsultaProfessor()) {
			try {
				if (telaConsProfessor == null) {
					telaConsProfessor = new VisaoPainelConsultaProfessor();
				}

				framePrincipal.trocarPainel(telaConsProfessor, "Consulta Professor");
				new ControlePainelConsultaProfessor(telaConsProfessor, 1);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}

	}

}
