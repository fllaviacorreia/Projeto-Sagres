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
	private JMenuItem menuItemAluno 	 = null;
	private JMenuItem menuItemClasse 	 = null;
	private JMenuItem menuItemCurso 	 = null;
	private JMenuItem menuItemDisciplina = null;
	private JMenuItem menuItemProfessor	 = null;
	
	public VisaoPainelTelaInicial() {
		this.setLayout(null);
		this.setBackground(new Color(66, 179, 165));
		this.setMinimumSize(new Dimension(1000, 730));
		this.setMaximumSize(new Dimension(1000, 730));
		this.setVisible(true);
		
		this.add(getButtonCadastros());
		this.add(getButtonOpcoes());
		this.add(getButtonSobre());
		this.add(getButtonConsultas());
		this.add(getButtonSair());
//		this.add(getButtonCancelar());
		this.add(getButtonFechar());
		this.add(getMenuBarMenu());
	}

	public JButton getButtonCadastros() {
		if(buttonCadastros == null) {
			buttonCadastros = new JButton("CADASTROS");
			buttonCadastros.setForeground(Color.BLACK);
			buttonCadastros.setBackground(Color.WHITE);
			buttonCadastros.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonCadastros.setBounds(42, 101, 219, 40);;
		}
		return buttonCadastros;
	}
	public JButton getButtonOpcoes() {
		if (buttonOpcoes == null) {
			buttonOpcoes = new JButton("OP\u00C7\u00D5ES");
			buttonOpcoes.setForeground(Color.BLACK);
			buttonOpcoes.setBackground(Color.WHITE);
			buttonOpcoes.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonOpcoes.setBounds(42, 298, 219, 40);
		}
		return buttonOpcoes;
	}
	public JButton getButtonSobre() {
		if (buttonSobre == null) {
			buttonSobre = new JButton("SOBRE");
			buttonSobre.setForeground(Color.BLACK);
			buttonSobre.setBackground(Color.WHITE);
			buttonSobre.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonSobre.setBounds(42, 384, 219, 40);
		}
		return buttonSobre;
	}
	public JButton getButtonConsultas() {
		if (buttonConsultas == null) {
			buttonConsultas = new JButton("CONSULTAS");
			buttonConsultas.setForeground(Color.BLACK);
			buttonConsultas.setBackground(Color.WHITE);
			buttonConsultas.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonConsultas.setBounds(42, 195, 219, 40);
		}
		return buttonConsultas;
	}
	
	public JButton getButtonSair() {
		if(buttonSair == null) {
			buttonSair = new JButton("SAIR");
			buttonSair.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonSair.setBounds(54, 631, 130, 33);
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
			buttonFechar.setBounds(215, 631, 130, 33);
			buttonFechar.setBackground(Color.WHITE);
			buttonFechar.setVisible(true);
		}
		return buttonFechar;
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
			menuCadastros.setBounds(1, 1, 90, 48);
			menuCadastros.add(getMenuItemAluno());
			menuCadastros.add(getMenuItemClasse());
			menuCadastros.add(getMenuItemCurso());
			menuCadastros.add(getMenuItemDisciplina());
			menuCadastros.add(getMenuItemProfessor());
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
			menuOpcoes.setBounds(121, 1, 90, 48);
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
			menuConsultas.setBounds(242, 1, 90, 48);
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
			menuSobre.setBounds(363, 1, 90, 48);
		}
		return menuSobre;
	}

	public JMenuItem getMenuItemAluno() {
		if(menuItemAluno == null) {
			menuItemAluno = new JMenuItem("Aluno");
		//	menuItemAluno.setBounds(1, 1, 40, 30);
		}
		return menuItemAluno;
	}

	public JMenuItem getMenuItemClasse() {
		if(menuItemClasse == null) {
			menuItemClasse = new JMenuItem("Classe");
		//	menuItemClasse.setBounds(1, 80, 40, 30);
		}
		return menuItemClasse;
	}

	public JMenuItem getMenuItemCurso() {
		if(menuItemCurso == null) {
			menuItemCurso = new JMenuItem("Curso");
		//	menuItemCurso.setBounds(1, 112, 40, 30);
		}
		return menuItemCurso;
	}

	public JMenuItem getMenuItemDisciplina() {
		if(menuItemDisciplina == null) {
			menuItemDisciplina = new JMenuItem("Disciplina");
		//	menuItemDisciplina.setBounds(1, 144, 40, 30);
		}
		return menuItemDisciplina;
	}

	public JMenuItem getMenuItemProfessor() {
		if(menuItemProfessor == null) {
			menuItemProfessor = new JMenuItem("Professor");
		//	menuItemProfessor.setBounds(1, 176, 40, 30);
		}
		return menuItemProfessor;
	}
}
