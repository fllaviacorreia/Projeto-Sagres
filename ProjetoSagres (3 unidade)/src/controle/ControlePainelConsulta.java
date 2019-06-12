package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.VisaoFramePrincipal;
import visao.VisaoPainelCadastroAluno;
import visao.VisaoPainelCadastroClasse;
import visao.VisaoPainelCadastroCurso;
import visao.VisaoPainelCadastroDisciplina;
import visao.VisaoPainelCadastroProfessor;
import visao.VisaoPainelConsulta;
import visao.VisaoPainelConsultaAluno;
import visao.VisaoPainelConsultaClasse;
import visao.VisaoPainelConsultaCurso;
import visao.VisaoPainelConsultaDisciplina;
import visao.VisaoPainelConsultaProfessor;

public class ControlePainelConsulta implements ActionListener {
	static VisaoFramePrincipal framePrincipal;
	static VisaoPainelConsulta painelConsultas;
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

	public ControlePainelConsulta(VisaoFramePrincipal framePrincipal, VisaoPainelConsulta painelConsultas) {
		ControlePainelConsulta.framePrincipal = framePrincipal;
		ControlePainelConsulta.painelConsultas = painelConsultas;
		AddEvento();
	}

	public static void troca() {
		framePrincipal.trocarPainel(painelConsultas, "Página de Consultas");
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
		// verifica();
	}

	public void AddEvento() {
		painelConsultas.getBtnConsultarAlunos().addActionListener(this);
		painelConsultas.getBtnConsultarClasses().addActionListener(this);
		painelConsultas.getBtnConsultarCursos().addActionListener(this);
		painelConsultas.getBtnConsultarDisciplinas().addActionListener(this);
		painelConsultas.getBtnConsultarProfessores().addActionListener(this);
		painelConsultas.getBtnVoltar().addActionListener(this);
		painelConsultas.getMenuItemCadastroAluno().addActionListener(this);
		painelConsultas.getMenuItemCadastroClasse().addActionListener(this);
		painelConsultas.getMenuItemCadastroCurso().addActionListener(this);
		painelConsultas.getMenuItemCadastroDisciplina().addActionListener(this);
		painelConsultas.getMenuItemCadastroProfessor().addActionListener(this);
		painelConsultas.getMenuItemConsultaAluno().addActionListener(this);
		painelConsultas.getMenuItemConsultaClasse().addActionListener(this);
		painelConsultas.getMenuItemConsultaCurso().addActionListener(this);
		painelConsultas.getMenuItemConsultaDisciplina().addActionListener(this);
		painelConsultas.getMenuItemConsultaProfessor().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(painelConsultas.getBtnVoltar())) {
			ControlePainelTelaInicial.troca();
		}

		if (e.getSource() == painelConsultas.getMenuItemCadastroAluno()) {
			try {
				if (telaCadAluno == null) {
					telaCadAluno = new VisaoPainelCadastroAluno();
				}

				framePrincipal.trocarPainel(telaCadAluno, "Cadastro Aluno");
				new ControlePainelCadastroAluno(telaCadAluno, 3);
				// aluno.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}

		if (e.getSource() == painelConsultas.getMenuItemCadastroClasse()) {
			try {
				if (telaCadClasse == null) {
					telaCadClasse = new VisaoPainelCadastroClasse();
				}

				framePrincipal.trocarPainel(telaCadClasse, "Cadastro Classe");
				new ControlePainelCadastroClasse(telaCadClasse, 3);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == painelConsultas.getMenuItemCadastroCurso()) {
			try {
				if (telaCadCurso == null) {
					telaCadCurso = new VisaoPainelCadastroCurso();
				}
				framePrincipal.trocarPainel(telaCadCurso, "Cadastro Curso");
				new ControlePainelCadastroCurso(framePrincipal,telaCadCurso, 3);

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == painelConsultas.getMenuItemCadastroDisciplina()) {
			try {
				if (telaCadDisciplina == null) {
					telaCadDisciplina = new VisaoPainelCadastroDisciplina();
				}
				framePrincipal.trocarPainel(telaCadDisciplina, "Cadastro Disciplina");
				new ControlePainelCadastroDisciplina(telaCadDisciplina, 3);
				// disciplina.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

		if (e.getSource() == painelConsultas.getMenuItemCadastroProfessor()) {
			try {
				if (telaCadProfessor == null) {
					telaCadProfessor = new VisaoPainelCadastroProfessor();
				}

				framePrincipal.trocarPainel(telaCadProfessor, "Cadastro Professor");
				new ControlePainelCadastroProfessor(telaCadProfessor, 3);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == painelConsultas.getMenuItemConsultaAluno()
				|| e.getSource() == painelConsultas.getBtnConsultarAlunos()) {
			try {
				if (telaConsAluno == null) {
					telaConsAluno = new VisaoPainelConsultaAluno();
				}

				framePrincipal.trocarPainel(telaConsAluno, "Consulta Aluno");
				new ControlePainelConsultaAluno(telaConsAluno, 3);
				// aluno.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}

		if (e.getSource() == painelConsultas.getMenuItemConsultaClasse()
				|| e.getSource() == painelConsultas.getBtnConsultarClasses()) {
			try {
				if (telaConsClasse == null) {
					telaConsClasse = new VisaoPainelConsultaClasse();
				}

				framePrincipal.trocarPainel(telaConsClasse, "Consulta Classe");
				new ControlePainelConsultaClasse(telaConsClasse, 3);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == painelConsultas.getMenuItemConsultaCurso()
				|| e.getSource() == painelConsultas.getBtnConsultarCursos()) {
			try {
				if (telaCadCurso == null) {
					telaConsCurso = new VisaoPainelConsultaCurso();
				}
				framePrincipal.trocarPainel(telaConsCurso, "Consulta Curso");
				new ControlePainelConsultaCurso(telaConsCurso, 3);

			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if (e.getSource() == painelConsultas.getMenuItemConsultaDisciplina()
				|| e.getSource() == painelConsultas.getBtnConsultarDisciplinas()) {
			try {
				if (telaConsDisciplina == null) {
					telaConsDisciplina = new VisaoPainelConsultaDisciplina();
				}
				framePrincipal.trocarPainel(telaConsDisciplina, "Consulta Disciplina");
				new ControlePainelConsultaDisciplina(telaConsDisciplina, 3);
				// disciplina.troca();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

		if (e.getSource() == painelConsultas.getMenuItemConsultaProfessor()
				|| e.getSource() == painelConsultas.getBtnConsultarProfessores()) {
			try {
				if (telaConsProfessor == null) {
					telaConsProfessor = new VisaoPainelConsultaProfessor();
				}

				framePrincipal.trocarPainel(telaConsProfessor, "Consulta Professor");
				new ControlePainelConsultaProfessor(telaConsProfessor, 3);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}

	}

}
