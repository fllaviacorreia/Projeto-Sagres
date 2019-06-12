package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VisaoPainelTelaInicial extends JPanel {

	private JButton   buttonCadastros 	 = null;
	private JButton   buttonOpcoes 		 = null;
	private JButton   buttonSobre 		 = null;
	private JButton   buttonConsultas 	 = null;
	private JButton   buttonSair 		 = null;
//	private JButton   buttonCancelar 	 = null;
	private JButton   buttonFechar	 = null;
	private JMenuBar  menuBarMenu        = null;
	private JMenu     menuCadastros		 = null;
	private JMenu     menuOpcoes		 = null;
	private JMenu     menuConsultas		 = null;
	private JMenu     menuSobre			 = null;
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
	
	public VisaoPainelTelaInicial() {
		this.setBackground(new Color(66, 179, 165));
		this.setMinimumSize(new Dimension(1000, 730));
		this.setMaximumSize(new Dimension(1000, 730));
		this.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(getButtonSair(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(getButtonFechar(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(getMenuBarMenu(), GroupLayout.PREFERRED_SIZE, 1435, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getButtonCadastros(), GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(getButtonConsultas(), GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(getButtonOpcoes(), GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(getButtonSobre(), GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addComponent(getMenuBarMenu(), GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(getButtonCadastros(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(getButtonConsultas(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(getButtonOpcoes(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(getButtonSobre(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(170)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getButtonSair(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(getButtonFechar(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);
	}

	public JButton getButtonCadastros() {
		if(buttonCadastros == null) {
			buttonCadastros = new JButton("CADASTROS");
			buttonCadastros.setForeground(Color.BLACK);
			buttonCadastros.setBackground(Color.WHITE);
			buttonCadastros.setFont(new Font("Arial", Font.PLAIN, 14));;
		}
		return buttonCadastros;
	}
	public JButton getButtonOpcoes() {
		if (buttonOpcoes == null) {
			buttonOpcoes = new JButton("OP\u00C7\u00D5ES");
			buttonOpcoes.setForeground(Color.BLACK);
			buttonOpcoes.setBackground(Color.WHITE);
			buttonOpcoes.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonOpcoes;
	}
	public JButton getButtonSobre() {
		if (buttonSobre == null) {
			buttonSobre = new JButton("SOBRE");
			buttonSobre.setForeground(Color.BLACK);
			buttonSobre.setBackground(Color.WHITE);
			buttonSobre.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonSobre;
	}
	public JButton getButtonConsultas() {
		if (buttonConsultas == null) {
			buttonConsultas = new JButton("CONSULTAS");
			buttonConsultas.setForeground(Color.BLACK);
			buttonConsultas.setBackground(Color.WHITE);
			buttonConsultas.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return buttonConsultas;
	}
	
	public JButton getButtonSair() {
		if(buttonSair == null) {
			buttonSair = new JButton("SAIR");
			buttonSair.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonSair.setBackground(Color.WHITE);
			buttonSair.setVisible(true);
		}
		return buttonSair;
	}

//	public JButton getButtonCancelar() {
//		if(buttonCancelar == null) {
//			buttonCancelar = new JButton("CANCELAR");
//			buttonCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
//			buttonCancelar.setBounds(217, 416, 130, 33);
//			buttonCancelar.setBackground(Color.WHITE);
//			buttonCancelar.setVisible(false);
//		}
//		return buttonCancelar;
//	}

	public JButton getButtonFechar() {
		if(buttonFechar == null) {
			buttonFechar = new JButton("FECHAR");
			buttonFechar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonFechar.setBackground(Color.WHITE);
			buttonFechar.setVisible(true);
		}
		return buttonFechar;
	}
	
	public JMenuBar getMenuBarMenu() {
		if(menuBarMenu == null) {
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
		if(menuCadastros == null) {
			menuCadastros = new JMenu("CADASTROS");
			menuCadastros.setLayout(null);
			menuCadastros.setHorizontalAlignment(SwingConstants.CENTER);
			menuCadastros.setFont(new Font("Arial", Font.PLAIN, 12));
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
		if(menuOpcoes == null) {
			menuOpcoes = new JMenu("OPÇÕES");
			menuOpcoes.setHorizontalAlignment(SwingConstants.CENTER);
			menuOpcoes.setFont(new Font("Arial", Font.PLAIN, 12));
			menuOpcoes.setBackground(Color.LIGHT_GRAY);
			menuOpcoes.setForeground(Color.BLACK);
			menuOpcoes.setBounds(242, 1, 90, 40);
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
