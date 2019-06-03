package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VisaoPainelCadastros extends JPanel {

	private JButton   buttonCadastroProfessor  	= null;
    private JButton   buttonCadastroAluno 		= null;
    private JButton   buttonCadastroClasse 		= null;
    private JButton   buttonCadastroCurso 		= null;
    private JButton   buttonCadastroDisciplina 	= null;
    private JButton   buttonVoltar 	 			= null;
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
//	private JButton buttonCancelar 	 			= null;
//	private JButton buttonFechar   				= null;
//	VisaoPainelTelaInicial menu = new VisaoPainelTelaInicial();
    
    public VisaoPainelCadastros(){
    	this.setBackground(new Color(66, 179, 165));
    	this.setMinimumSize(new Dimension(1000, 730));
		this.setMaximumSize(new Dimension(1000, 730));
		this.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1)
					.addComponent(getMenuBarMenu(), GroupLayout.PREFERRED_SIZE, 1435, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getButtonVoltar(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getButtonCadastroAluno(), GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(getButtonCadastroClasse(), GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(getButtonCadastroCurso(), GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(getButtonCadastroDisciplina(), GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(getButtonCadastroProfessor(), GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
							.addGap(1191))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addComponent(getMenuBarMenu(), GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(getButtonCadastroAluno(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(getButtonCadastroClasse(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(getButtonCadastroCurso(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(getButtonCadastroDisciplina(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(getButtonCadastroProfessor(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(113)
					.addComponent(getButtonVoltar(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		setLayout(groupLayout);
		
	//	this.add(menu.getMenuBarMenu());
	//	this.add(getButtonCancelar());
	//	this.add(getButtonFechar()); 
    }
    

    public JButton getButtonCadastroProfessor() {
        if(buttonCadastroProfessor == null){
            buttonCadastroProfessor = new JButton("CADASTRAR PROFESSOR");
            buttonCadastroProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonCadastroProfessor.setBackground(new Color(255, 255, 255));
            buttonCadastroProfessor.setVisible(true);
     
        }
        return buttonCadastroProfessor;
    }
   
    public JButton getButtonCadastroAluno() {
        if(buttonCadastroAluno == null){
            buttonCadastroAluno = new JButton("CADASTRAR ALUNO");
            buttonCadastroAluno.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonCadastroAluno.setBackground(new Color(255, 255, 255));
            buttonCadastroAluno.setVisible(true);
        }
        return buttonCadastroAluno;
    }

    public JButton getButtonCadastroClasse() {
        if(buttonCadastroClasse == null){
            buttonCadastroClasse = new JButton("CADASTRAR CLASSE");
            buttonCadastroClasse.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonCadastroClasse.setBackground(new Color(255, 255, 255));
            buttonCadastroClasse.setVisible(true);
        }
        return buttonCadastroClasse;
    }

    public JButton getButtonCadastroCurso() {
    	if(buttonCadastroCurso == null){
    		buttonCadastroCurso = new JButton("CADASTRAR CURSO");
    		buttonCadastroCurso.setFont(new Font("Arial", Font.PLAIN, 14));
    		buttonCadastroCurso.setBackground(new Color(255, 255, 255));
    		buttonCadastroCurso.setVisible(true);
        }
		return buttonCadastroCurso;
	}

    public JButton getButtonCadastroDisciplina() {
        if(buttonCadastroDisciplina == null){
            buttonCadastroDisciplina = new JButton("CADASTRAR DISCIPLINA");
            buttonCadastroDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonCadastroDisciplina.setBackground(new Color(255, 255, 255));
            buttonCadastroDisciplina.setVisible(true); 
        }
        return buttonCadastroDisciplina;
    }
    
    public JButton getButtonVoltar() {
		if(buttonVoltar == null) {
			buttonVoltar = new JButton("VOLTAR");
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonVoltar.setBackground(new Color(255, 255, 255));
			buttonVoltar.setVisible(true);
		}
		return buttonVoltar;
	}

//	public JButton getButtonCancelar() {
//		if(buttonCancelar == null) {
//			buttonCancelar = new JButton("CANCELAR");
//			buttonCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
//			buttonCancelar.setBounds(224, 397, 118, 33);
//			buttonCancelar.setBackground(new Color(255, 255, 255));
//			buttonCancelar.setVisible(false);
//		}
//		return buttonCancelar;
//	}
//
//	public JButton getButtonFechar() {
//		if(buttonFechar == null) {
//			buttonFechar = new JButton("FECHAR");
//			buttonFechar.setFont(new Font("Arial", Font.PLAIN, 14));
//			buttonFechar.setBounds(211, 464, 109, 33);
//			buttonFechar.setBackground(new Color(255, 255, 255));
//			buttonFechar.setVisible(false);
//		}
//		return buttonFechar;
//	}
    
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
			menuCadastros.setBounds(1, 2, 90, 48);
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
			menuOpcoes.setBounds(242, 2, 90, 48);
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
			menuConsultas.setBounds(121, 1, 90, 48);
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
}
