package visao;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;

public class VisaoPainelConsultas extends JPanel {
	private JButton btnConsultarAlunos;
	private JButton btnConsultarProfessores;
	private JButton btnConsultarCursos;
	private JButton btnConsultarDisciplinas;
	private JButton btnConsultarClasses;
	private JButton btnVoltar;
	private JMenuBar  menuBarMenu        		= null;
	private JMenu     menuCadastros		 		= null;
	private JMenu     menuOpcoes		 		= null;
	private JMenu     menuConsultas		 		= null;
	private JMenu     menuSobre			 		= null;
	private JMenuItem menuItemCadastroAluno 	 = null;
	private JMenuItem menuItemCadastroClasse 	 = null;
	private JMenuItem menuItemCadastroCurso 	 = null;
	private JMenuItem menuItemCadastroDisciplina = null;
	private JMenuItem menuItemCadastroProfessor	 = null;
	private JMenuItem menuItemConsultaAluno 	 = null;
	private JMenuItem menuItemConsultaClasse 	 = null;
	private JMenuItem menuItemConsultaCurso 	 = null;
	private JMenuItem menuItemConsultaDisciplina = null;
	private JMenuItem menuItemConsultaProfessor	 = null;
	
	public VisaoPainelConsultas() {
		this.setBackground(new Color(66, 179, 165));
		this.setMinimumSize(new Dimension(1000, 730));
		this.setMaximumSize(new Dimension(1000, 730));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1)
					.addComponent(getMenuBarMenu(), GroupLayout.PREFERRED_SIZE, 1435, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(getBtnVoltar(), GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(getBtnConsultarProfessores(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(getBtnConsultarDisciplinas(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(getBtnConsultarCursos(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(getBtnConsultarClasses(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(getBtnConsultarAlunos(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
					.addGap(1098))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addComponent(getMenuBarMenu(), GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(getBtnConsultarAlunos(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getBtnConsultarClasses(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getBtnConsultarCursos(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getBtnConsultarDisciplinas(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getBtnConsultarProfessores(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
					.addComponent(getBtnVoltar(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		this.setVisible(true);
	}
	public JButton getBtnConsultarAlunos() {
		if (btnConsultarAlunos == null) {
			btnConsultarAlunos = new JButton("Consultar Alunos");
			btnConsultarAlunos.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnConsultarAlunos.setBackground(Color.WHITE);
			btnConsultarAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnConsultarAlunos;
	}
	public JButton getBtnConsultarProfessores() {
		if (btnConsultarProfessores == null) {
			btnConsultarProfessores = new JButton("Consultar Professores");
			btnConsultarProfessores.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnConsultarProfessores.setBackground(Color.WHITE);
			btnConsultarProfessores.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnConsultarProfessores;
	}
	public JButton getBtnConsultarCursos() {
		if (btnConsultarCursos == null) {
			btnConsultarCursos = new JButton("Consultar Cursos");
			btnConsultarCursos.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnConsultarCursos.setBackground(Color.WHITE);
			btnConsultarCursos.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnConsultarCursos;
	}
	public JButton getBtnConsultarDisciplinas() {
		if (btnConsultarDisciplinas == null) {
			btnConsultarDisciplinas = new JButton("Consultar Disciplinas");
			btnConsultarDisciplinas.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnConsultarDisciplinas.setBackground(Color.WHITE);
			btnConsultarDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnConsultarDisciplinas;
	}
	public JButton getBtnConsultarClasses() {
		if (btnConsultarClasses == null) {
			btnConsultarClasses = new JButton("Consultar Classes");
			btnConsultarClasses.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnConsultarClasses.setBackground(Color.WHITE);
			btnConsultarClasses.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnConsultarClasses;
	}
	public JButton getBtnVoltar() {
		if (btnVoltar == null) {
			btnVoltar = new JButton("VOLTAR");
			btnVoltar.setBackground(Color.WHITE);
			btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnVoltar;
	}
	
	public JMenuBar getMenuBarMenu() {
		if(menuBarMenu == null) {
			menuBarMenu = new JMenuBar();
			menuBarMenu.setLayout(null);
			menuBarMenu.setBounds(1, 1, 1400, 40);
			menuBarMenu.add(getMenuCadastros());
			menuBarMenu.add(getMenuConsultas());
			menuBarMenu.add(getMenuOpcoes());
			menuBarMenu.add(getMenuSobre());
		}
		return menuBarMenu;
	}

	public JMenu getMenuCadastros() {
		if(menuCadastros == null) {
			menuCadastros = new JMenu("CADASTROS");
			menuCadastros.setLayout(null);
			menuCadastros.setHorizontalAlignment(SwingConstants.CENTER);
			menuCadastros.setFont(new Font("Arial", Font.PLAIN, 12));
			menuCadastros.setBackground(Color.LIGHT_GRAY);
			menuCadastros.setForeground(Color.BLACK);
			menuCadastros.setBounds(1, 2, 90, 40);
			menuCadastros.add(getMenuItemCadastroAluno());
			menuCadastros.add(getMenuItemCadastroClasse());
			menuCadastros.add(getMenuItemCadastroCurso());
			menuCadastros.add(getMenuItemCadastroDisciplina());
			menuCadastros.add(getMenuItemCadastroProfessor());
		}
		return menuCadastros;
	}

	public JMenu getMenuOpcoes() {
		if(menuOpcoes == null) {
			menuOpcoes = new JMenu("OPÇÕES");
			menuOpcoes.setHorizontalAlignment(SwingConstants.CENTER);
			menuOpcoes.setFont(new Font("Arial", Font.PLAIN, 12));
			menuOpcoes.setBackground(Color.LIGHT_GRAY);
			menuOpcoes.setForeground(Color.BLACK);
			menuOpcoes.setBounds(242, 2, 90, 40);
		}
		return menuOpcoes;
	}

	public JMenu getMenuConsultas() {
		if(menuConsultas == null) {
			menuConsultas = new JMenu("CONSULTAS");
			menuConsultas.setHorizontalAlignment(SwingConstants.CENTER);
			menuConsultas.setFont(new Font("Arial", Font.PLAIN, 12));
			menuConsultas.setBackground(Color.LIGHT_GRAY);
			menuConsultas.setForeground(Color.BLACK);
			menuConsultas.setBounds(121, 1, 90, 40);
			menuConsultas.add(getMenuItemConsultaAluno());
			menuConsultas.add(getMenuItemConsultaClasse());
			menuConsultas.add(getMenuItemConsultaCurso());
			menuConsultas.add(getMenuItemConsultaDisciplina());
			menuConsultas.add(getMenuItemConsultaProfessor());
		}
		return menuConsultas;
	}

	public JMenu getMenuSobre() {
		if(menuSobre == null) {
			menuSobre = new JMenu("SOBRE");
			menuSobre.setHorizontalAlignment(SwingConstants.CENTER);
			menuSobre.setFont(new Font("Arial", Font.PLAIN, 12));
			menuSobre.setBackground(Color.LIGHT_GRAY);
			menuSobre.setForeground(Color.BLACK);
			menuSobre.setBounds(363, 1, 90, 40);
		}
		return menuSobre;
	}

	public JMenuItem getMenuItemCadastroAluno() {
		if(menuItemCadastroAluno == null) {
			menuItemCadastroAluno = new JMenuItem("Aluno");
		//	menuItemAluno.setBounds(1, 1, 40, 30);
		}
		return menuItemCadastroAluno;
	}

	public JMenuItem getMenuItemCadastroClasse() {
		if(menuItemCadastroClasse == null) {
			menuItemCadastroClasse = new JMenuItem("Classe");
		//	menuItemClasse.setBounds(1, 80, 40, 30);
		}
		return menuItemCadastroClasse;
	}

	public JMenuItem getMenuItemCadastroCurso() {
		if(menuItemCadastroCurso == null) {
			menuItemCadastroCurso = new JMenuItem("Curso");
		//	menuItemCurso.setBounds(1, 112, 40, 30);
		}
		return menuItemCadastroCurso;
	}

	public JMenuItem getMenuItemCadastroDisciplina() {
		if(menuItemCadastroDisciplina == null) {
			menuItemCadastroDisciplina = new JMenuItem("Disciplina");
		//	menuItemDisciplina.setBounds(1, 144, 40, 30);
		}
		return menuItemCadastroDisciplina;
	}

	public JMenuItem getMenuItemCadastroProfessor() {
		if(menuItemCadastroProfessor == null) {
			menuItemCadastroProfessor = new JMenuItem("Professor");
		//	menuItemProfessor.setBounds(1, 176, 40, 30);
		}
		return menuItemCadastroProfessor;
	}
	
	public JMenuItem getMenuItemConsultaAluno() {
		if(menuItemConsultaAluno == null) {
			menuItemConsultaAluno = new JMenuItem("Aluno");
		//	menuItemAluno.setBounds(1, 1, 40, 30);
		}
		return menuItemConsultaAluno;
	}

	public JMenuItem getMenuItemConsultaClasse() {
		if(menuItemConsultaClasse == null) {
			menuItemConsultaClasse = new JMenuItem("Classe");
		//	menuItemClasse.setBounds(1, 80, 40, 30);
		}
		return menuItemConsultaClasse;
	}

	public JMenuItem getMenuItemConsultaCurso() {
		if(menuItemConsultaCurso == null) {
			menuItemConsultaCurso = new JMenuItem("Curso");
		//	menuItemCurso.setBounds(1, 112, 40, 30);
		}
		return menuItemConsultaCurso;
	}

	public JMenuItem getMenuItemConsultaDisciplina() {
		if(menuItemConsultaDisciplina == null) {
			menuItemConsultaDisciplina = new JMenuItem("Disciplina");
		//	menuItemDisciplina.setBounds(1, 144, 40, 30);
		}
		return menuItemConsultaDisciplina;
	}

	public JMenuItem getMenuItemConsultaProfessor() {
		if(menuItemConsultaProfessor == null) {
			menuItemConsultaProfessor = new JMenuItem("Professor");
		//	menuItemProfessor.setBounds(1, 176, 40, 30);
		}
		return menuItemConsultaProfessor;
	}
}
