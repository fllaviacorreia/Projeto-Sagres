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

@SuppressWarnings("serial")
public class VisaoPainelConsulta extends JPanel {
	private JButton   buttonConsultarAlunos 	 = null;
	private JButton   buttonConsultarProfessores = null;
	private JButton   buttonConsultarCursos 	 = null;
	private JButton   buttonConsultarDisciplinas = null;
	private JButton   buttonConsultarClasses 	 = null;
	private JButton   buttonVoltar 				 = null;
	private JMenuBar  menuBarMenu 				 = null;
	private JMenu 	  menuCadastros 			 = null;
	private JMenu 	  menuOpcoes 				 = null;
	private JMenu 	  menuConsultas 			 = null;
	private JMenu 	  menuSobre 				 = null;
	private JMenuItem menuItemCadastroAluno 	 = null;
	private JMenuItem menuItemCadastroClasse 	 = null;
	private JMenuItem menuItemCadastroCurso 	 = null;
	private JMenuItem menuItemCadastroDisciplina = null;
	private JMenuItem menuItemCadastroProfessor  = null;
	private JMenuItem menuItemConsultaAluno 	 = null;
	private JMenuItem menuItemConsultaClasse 	 = null;
	private JMenuItem menuItemConsultaCurso 	 = null;
	private JMenuItem menuItemConsultaDisciplina = null;
	private JMenuItem menuItemConsultaProfessor  = null;
	
	public VisaoPainelConsulta() {
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
					.addComponent(getButtonVoltar(), GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(getButtonConsultarProfessores(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(getButtonConsultarDisciplinas(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(getButtonConsultarCursos(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(getButtonConsultarClasses(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(getButtonConsultarAlunos(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
					.addGap(1098))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addComponent(getMenuBarMenu(), GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(getButtonConsultarAlunos(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getButtonConsultarClasses(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getButtonConsultarCursos(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getButtonConsultarDisciplinas(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getButtonConsultarProfessores(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
					.addComponent(getButtonVoltar(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		this.setVisible(true);
	}
	public JButton getButtonConsultarAlunos() {
		if (buttonConsultarAlunos == null) {
			buttonConsultarAlunos = new JButton("Consultar Alunos");
			buttonConsultarAlunos.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonConsultarAlunos.setBackground(Color.WHITE);
			buttonConsultarAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonConsultarAlunos;
	}
	public JButton getButtonConsultarProfessores() {
		if (buttonConsultarProfessores == null) {
			buttonConsultarProfessores = new JButton("Consultar Professores");
			buttonConsultarProfessores.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonConsultarProfessores.setBackground(Color.WHITE);
			buttonConsultarProfessores.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonConsultarProfessores;
	}
	public JButton getButtonConsultarCursos() {
		if (buttonConsultarCursos == null) {
			buttonConsultarCursos = new JButton("Consultar Cursos");
			buttonConsultarCursos.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonConsultarCursos.setBackground(Color.WHITE);
			buttonConsultarCursos.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonConsultarCursos;
	}
	public JButton getButtonConsultarDisciplinas() {
		if (buttonConsultarDisciplinas == null) {
			buttonConsultarDisciplinas = new JButton("Consultar Disciplinas");
			buttonConsultarDisciplinas.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonConsultarDisciplinas.setBackground(Color.WHITE);
			buttonConsultarDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonConsultarDisciplinas;
	}
	public JButton getButtonConsultarClasses() {
		if (buttonConsultarClasses == null) {
			buttonConsultarClasses = new JButton("Consultar Classes");
			buttonConsultarClasses.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonConsultarClasses.setBackground(Color.WHITE);
			buttonConsultarClasses.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonConsultarClasses;
	}
	public JButton getButtonVoltar() {
		if (buttonVoltar == null) {
			buttonVoltar = new JButton("VOLTAR");
			buttonVoltar.setBackground(Color.WHITE);
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonVoltar;
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
		if (menuItemCadastroAluno == null) {
			menuItemCadastroAluno = new JMenuItem("Aluno");
			
		}
		return menuItemCadastroAluno;
	}

	public JMenuItem getMenuItemCadastroClasse() {
		if (menuItemCadastroClasse == null) {
			menuItemCadastroClasse = new JMenuItem("Classe");
			
		}
		return menuItemCadastroClasse;
	}

	public JMenuItem getMenuItemCadastroCurso() {
		if (menuItemCadastroCurso == null) {
			menuItemCadastroCurso = new JMenuItem("Curso");
			
		}
		return menuItemCadastroCurso;
	}

	public JMenuItem getMenuItemCadastroDisciplina() {
		if (menuItemCadastroDisciplina == null) {
			menuItemCadastroDisciplina = new JMenuItem("Disciplina");
			
		}
		return menuItemCadastroDisciplina;
	}

	public JMenuItem getMenuItemCadastroProfessor() {
		if (menuItemCadastroProfessor == null) {
			menuItemCadastroProfessor = new JMenuItem("Professor");
			
		}
		return menuItemCadastroProfessor;
	}

	public JMenuItem getMenuItemConsultaAluno() {
		if (menuItemConsultaAluno == null) {
			menuItemConsultaAluno = new JMenuItem("Aluno");
		}
		return menuItemConsultaAluno;
	}

	public JMenuItem getMenuItemConsultaClasse() {
		if (menuItemConsultaClasse == null) {
			menuItemConsultaClasse = new JMenuItem("Classe");
		}
		return menuItemConsultaClasse;
	}

	public JMenuItem getMenuItemConsultaCurso() {
		if (menuItemConsultaCurso == null) {
			menuItemConsultaCurso = new JMenuItem("Curso");
		}
		return menuItemConsultaCurso;
	}

	public JMenuItem getMenuItemConsultaDisciplina() {
		if (menuItemConsultaDisciplina == null) {
			menuItemConsultaDisciplina = new JMenuItem("Disciplina");
		}
		return menuItemConsultaDisciplina;
	}

	public JMenuItem getMenuItemConsultaProfessor() {
		if (menuItemConsultaProfessor == null) {
			menuItemConsultaProfessor = new JMenuItem("Professor");
		}
		return menuItemConsultaProfessor;
	}

}
