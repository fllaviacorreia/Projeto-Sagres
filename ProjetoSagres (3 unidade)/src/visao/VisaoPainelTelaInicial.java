package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import assets.Fonts;
import assets.Strings;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VisaoPainelTelaInicial extends JPanel {
	private JButton   buttonCadastros 			= null;
	private JButton   buttonOpcoes 				= null;
	private JButton   buttonSobre 				= null;
	private JButton   buttonConsultas 			= null;
	private JButton   buttonSair 				= null;
	private JButton   buttonFechar 				= null;
	private JMenuBar  menuBarMenu				= null;
	private JMenu 	  menuCadastros 			= null;
	private JMenu 	  menuOpcoes 				= null;
	private JMenu 	  menuConsultas 			= null;
	private JMenu 	  menuSobre 				= null;
	private JMenuItem menuItemCadastroAluno 	= null;
	private JMenuItem menuItemCadastroClasse 	= null;
	private JMenuItem menuItemCadastroCurso 	= null;
	private JMenuItem menuItemCadastroDisciplina= null;
	private JMenuItem menuItemCadastroProfessor = null;
	private JMenuItem menuItemConsultaAluno 	= null;
	private JMenuItem menuItemConsultaClasse 	= null;
	private JMenuItem menuItemConsultaCurso 	= null;
	private JMenuItem menuItemConsultaDisciplina= null;
	private JMenuItem menuItemConsultaProfessor = null;

	Fonts fonts =  new Fonts();
	Strings strings = new Strings();
	
	public VisaoPainelTelaInicial() {
		this.setBackground(new Color(66, 179, 165));
		this.setMinimumSize(new Dimension(1000, 730));
		this.setMaximumSize(new Dimension(1000, 730));
		this.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(54)
										.addComponent(getButtonSair(), GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addGap(31).addComponent(getButtonFechar(), GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(getMenuBarMenu(),
										GroupLayout.PREFERRED_SIZE, 1435, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(41)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(getButtonCadastros(), GroupLayout.PREFERRED_SIZE, 219,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(getButtonConsultas(), GroupLayout.PREFERRED_SIZE, 219,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(getButtonOpcoes(), GroupLayout.PREFERRED_SIZE, 219,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(getButtonSobre(), GroupLayout.PREFERRED_SIZE, 219,
														GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(2)
				.addComponent(getMenuBarMenu(), GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE).addGap(55)
				.addComponent(getButtonCadastros(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addGap(54)
				.addComponent(getButtonConsultas(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addGap(63).addComponent(getButtonOpcoes(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addGap(46).addComponent(getButtonSobre(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addGap(170)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getButtonSair(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(getButtonFechar(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))));
		setLayout(groupLayout);
	}

	public JButton getButtonCadastros() {
		if (buttonCadastros == null) {
			buttonCadastros = new JButton("CADASTROS");
			buttonCadastros.setForeground(Color.BLACK);
			buttonCadastros.setBackground(Color.WHITE);
			buttonCadastros.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			;
		}
		return buttonCadastros;
	}

	public JButton getButtonOpcoes() {
		if (buttonOpcoes == null) {
			buttonOpcoes = new JButton("OP\u00C7\u00D5ES");
			buttonOpcoes.setForeground(Color.BLACK);
			buttonOpcoes.setBackground(Color.WHITE);
			buttonOpcoes.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
		}
		return buttonOpcoes;
	}

	public JButton getButtonSobre() {
		if (buttonSobre == null) {
			buttonSobre = new JButton("SOBRE");
			buttonSobre.setForeground(Color.BLACK);
			buttonSobre.setBackground(Color.WHITE);
			buttonSobre.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
		}
		return buttonSobre;
	}

	public JButton getButtonConsultas() {
		if (buttonConsultas == null) {
			buttonConsultas = new JButton("CONSULTAS");
			buttonConsultas.setForeground(Color.BLACK);
			buttonConsultas.setBackground(Color.WHITE);
			buttonConsultas.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
		}
		return buttonConsultas;
	}

	public JButton getButtonSair() {
		if (buttonSair == null) {
			buttonSair = new JButton("SAIR");
			buttonSair.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			buttonSair.setBackground(Color.WHITE);
			buttonSair.setVisible(true);
		}
		return buttonSair;
	}

	public JButton getButtonFechar() {
		if (buttonFechar == null) {
			buttonFechar = new JButton("FECHAR");
			buttonFechar.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			buttonFechar.setBackground(Color.WHITE);
			buttonFechar.setVisible(true);
		}
		return buttonFechar;
	}

	public JMenuBar getMenuBarMenu() {
		if (menuBarMenu == null) {
			menuBarMenu = new JMenuBar();
			menuBarMenu.setLayout(null);
			menuBarMenu.add(getMenuCadastros());
			menuBarMenu.add(getMenuConsultas());
			menuBarMenu.add(getMenuOpcoes());
			menuBarMenu.add(getMenuSobre());
		}
		return menuBarMenu;
	}

	public JMenu getMenuCadastros() {
		if (menuCadastros == null) {
			menuCadastros = new JMenu("CADASTROS");
			menuCadastros.setLayout(null);
			menuCadastros.setHorizontalAlignment(SwingConstants.CENTER);
			menuCadastros.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			menuCadastros.setBackground(Color.LIGHT_GRAY);
			menuCadastros.setForeground(Color.BLACK);
			menuCadastros.setBounds(1, 1, 90, 40);
			menuCadastros.add(getMenuItemCadastroAluno());
			menuCadastros.add(getMenuItemCadastroClasse());
			menuCadastros.add(getMenuItemCadastroCurso());
			menuCadastros.add(getMenuItemCadastroDisciplina());
			menuCadastros.add(getMenuItemCadastroProfessor());
		}
		return menuCadastros;
	}

	public JMenu getMenuOpcoes() {
		if (menuOpcoes == null) {
			menuOpcoes = new JMenu("OPÇÕES");
			menuOpcoes.setHorizontalAlignment(SwingConstants.CENTER);
			menuOpcoes.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			menuOpcoes.setBackground(Color.LIGHT_GRAY);
			menuOpcoes.setForeground(Color.BLACK);
			menuOpcoes.setBounds(242, 1, 90, 40);
		}
		return menuOpcoes;
	}

	public JMenu getMenuConsultas() {
		if (menuConsultas == null) {
			menuConsultas = new JMenu("CONSULTAS");
			menuConsultas.setHorizontalAlignment(SwingConstants.CENTER);
			menuConsultas.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
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
		if (menuSobre == null) {
			menuSobre = new JMenu("SOBRE");
			menuSobre.setHorizontalAlignment(SwingConstants.CENTER);
			menuSobre.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			menuSobre.setBackground(Color.LIGHT_GRAY);
			menuSobre.setForeground(Color.BLACK);
			menuSobre.setBounds(363, 1, 90, 40);
		}
		return menuSobre;
	}

	public JMenuItem getMenuItemCadastroAluno() {
		if (menuItemCadastroAluno == null) {
			menuItemCadastroAluno = new JMenuItem("Aluno");
			menuItemCadastroAluno.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			
		}
		return menuItemCadastroAluno;
	}

	public JMenuItem getMenuItemCadastroClasse() {
		if (menuItemCadastroClasse == null) {
			menuItemCadastroClasse = new JMenuItem("Classe");
			menuItemCadastroClasse.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			
		}
		return menuItemCadastroClasse;
	}

	public JMenuItem getMenuItemCadastroCurso() {
		if (menuItemCadastroCurso == null) {
			menuItemCadastroCurso = new JMenuItem("Curso");
			menuItemCadastroCurso.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			
		}
		return menuItemCadastroCurso;
	}

	public JMenuItem getMenuItemCadastroDisciplina() {
		if (menuItemCadastroDisciplina == null) {
			menuItemCadastroDisciplina = new JMenuItem("Disciplina");
			menuItemCadastroDisciplina.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			
		}
		return menuItemCadastroDisciplina;
	}

	public JMenuItem getMenuItemCadastroProfessor() {
		if (menuItemCadastroProfessor == null) {
			menuItemCadastroProfessor = new JMenuItem("Professor");
			menuItemCadastroProfessor.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
			
		}
		return menuItemCadastroProfessor;
	}

	public JMenuItem getMenuItemConsultaAluno() {
		if (menuItemConsultaAluno == null) {
			menuItemConsultaAluno = new JMenuItem("Aluno");
			menuItemConsultaAluno.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
		}
		return menuItemConsultaAluno;
	}

	public JMenuItem getMenuItemConsultaClasse() {
		if (menuItemConsultaClasse == null) {
			menuItemConsultaClasse = new JMenuItem("Classe");
			menuItemConsultaClasse.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
		}
		return menuItemConsultaClasse;
	}

	public JMenuItem getMenuItemConsultaCurso() {
		if (menuItemConsultaCurso == null) {
			menuItemConsultaCurso = new JMenuItem("Curso");
			menuItemConsultaCurso.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
		}
		return menuItemConsultaCurso;
	}

	public JMenuItem getMenuItemConsultaDisciplina() {
		if (menuItemConsultaDisciplina == null) {
			menuItemConsultaDisciplina = new JMenuItem("Disciplina");
			menuItemConsultaDisciplina.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
		}
		return menuItemConsultaDisciplina;
	}

	public JMenuItem getMenuItemConsultaProfessor() {
		if (menuItemConsultaProfessor == null) {
			menuItemConsultaProfessor = new JMenuItem("Professor");
			menuItemConsultaProfessor.setFont(fonts.setFont(strings.getSrcFontOpenSansRegular(), strings.getSizeMedium()));
		}
		return menuItemConsultaProfessor;
	}
}
