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
import visao.VisaoPainelCadastros;
import visao.VisaoPainelConsultas;
import visao.VisaoPainelTelaInicial;

public class ControlePainelTelaInicial implements ActionListener{
	static VisaoPainelTelaInicial telaInicial;
	static VisaoPainelCadastros telaCadastros;
	static VisaoFramePrincipal framePrincipal;
	static VisaoPainelCadastroAluno telaCadAluno;
	static VisaoPainelCadastroDisciplina telaCadDisciplina;
	static VisaoPainelCadastroClasse telaCadClasse;
	static VisaoPainelCadastroCurso telaCadCurso;
	static VisaoPainelCadastroProfessor telaCadProfessor;
	static VisaoPainelConsultas telaCadConsulta;
	public ControlePainelTelaInicial(VisaoFramePrincipal framePrincipal, VisaoPainelTelaInicial telaInicial) {
		//	inicializa();
		this.framePrincipal  = framePrincipal;
		this.telaInicial = telaInicial;
		AdcEventos();
		System.out.println("Inicial");
//		verifica();
	}

	//	public void inicializa() {
	//		framePrincipal = new VisaoFramePrincipal();
	//		telaInicial = new VisaoPainelTelaInicial();
	//		troca();
	//	}

	public void AdcEventos() {
		telaInicial.getButtonCadastros().addActionListener(this);
		telaInicial.getButtonSobre().addActionListener(this);
		telaInicial.getButtonConsultas().addActionListener(this);
		telaInicial.getButtonOpcoes().addActionListener(this);
	//	telaInicial.getButtonCancelar().addActionListener(this);
		telaInicial.getButtonFechar().addActionListener(this);
		telaInicial.getButtonSair().addActionListener(this);
		telaInicial.getMenuConsultas().addActionListener(this);
		telaInicial.getMenuOpcoes().addActionListener(this);	
		telaInicial.getMenuSobre().addActionListener(this);
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
		if(e.getSource() == telaInicial.getButtonCadastros()) {
			try {
				if(telaCadastros == null) {
					telaCadastros = new VisaoPainelCadastros();
				}
				
				framePrincipal.trocarPainel(telaCadastros, "Página de Cadastros");
				new ControlePainelCadastros(framePrincipal, telaCadastros);
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if(e.getSource() == telaInicial.getButtonSobre()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == telaInicial.getButtonConsultas()) {
			if(telaCadConsulta == null) {
				telaCadConsulta = new VisaoPainelConsultas();
			}
			new ControlePainelConsultas(framePrincipal, telaCadConsulta);
			framePrincipal.trocarPainel(telaCadConsulta, "Página de Consultas");
		}
		if(e.getSource() == telaInicial.getButtonOpcoes()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == telaInicial.getButtonSair()) {
			int saida;
			try {
				saida = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Aviso", JOptionPane.INFORMATION_MESSAGE);

				if(saida == 0) {
					ControlePainelTelaLogin.troca();
					telaInicial.setVisible(false);
				}


			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaInicial.getButtonFechar()){
			int saida;
			try {
				saida = JOptionPane.showConfirmDialog(telaInicial, "Deseja realmente fechar o programa?", "Confirmação de saída", JOptionPane.YES_NO_OPTION);
				//	System.out.println(saida);

				if(saida == 0)
					System.exit(0);

			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaInicial.getMenuConsultas()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == telaInicial.getMenuOpcoes()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == telaInicial.getMenuSobre()) {
			JOptionPane.showMessageDialog(null, "EM CONSTRUÇÃO", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == telaInicial.getMenuItemCadastroAluno()) {
				try {
					if(telaCadAluno == null) {
						telaCadAluno = new VisaoPainelCadastroAluno();
					}	

					framePrincipal.trocarPainel(telaCadAluno, "Cadastro Aluno");
					new ControlePainelCadastroAluno(telaCadAluno, 1);
					//aluno.troca();
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			
		}
		if(e.getSource() == telaInicial.getMenuItemCadastroClasse()) {
			
				telaInicial.getMenuItemCadastroClasse().setEnabled(true);	
				try {
					if(telaCadClasse == null) {
						telaCadClasse = new VisaoPainelCadastroClasse();
					}	

					framePrincipal.trocarPainel(telaCadClasse, "Cadastro Classe");
					new ControlePainelCadastroClasse(framePrincipal, telaCadClasse, 1);
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			
		}
		if(e.getSource() == telaInicial.getMenuItemCadastroCurso()) {
			try {
				if(telaCadCurso == null) {
					telaCadCurso = new VisaoPainelCadastroCurso();
				}
				framePrincipal.trocarPainel(telaCadCurso, "Cadastro Curso");
				new ControlePainelCadastroCurso(framePrincipal, telaCadCurso, 1);

			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}

		}
		if(e.getSource() == telaInicial.getMenuItemCadastroDisciplina()) {
			try {
				if(telaCadDisciplina == null) {
					telaCadDisciplina = new VisaoPainelCadastroDisciplina();
				}	
				framePrincipal.trocarPainel(telaCadDisciplina, "Cadastro Disciplina");	
				new ControlePainelCadastroDisciplina(telaCadDisciplina, 1);
				//disciplina.troca();
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaInicial.getMenuItemConsultaProfessor()) {
				try {
					if(telaCadProfessor == null) {
						telaCadProfessor = new VisaoPainelCadastroProfessor();
					}	

					framePrincipal.trocarPainel(telaCadProfessor, "Cadastro Professor");
					new ControlePainelCadastroProfessor(telaCadProfessor, 1);
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			
		}

	}

}
