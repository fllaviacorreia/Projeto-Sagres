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
	private JMenuItem menuItemAluno 	 		= null;
	private JMenuItem menuItemClasse 	 		= null;
	private JMenuItem menuItemCurso 	 		= null;
	private JMenuItem menuItemDisciplina 		= null;
	private JMenuItem menuItemProfessor	 		= null;
//	private JButton buttonCancelar 	 			= null;
//	private JButton buttonFechar   				= null;
//	VisaoPainelTelaInicial menu = new VisaoPainelTelaInicial();
    
    public VisaoPainelCadastros(){
    	setLayout(null);
    	this.setBackground(new Color(66, 179, 165));
    	this.setMinimumSize(new Dimension(1000, 730));
		this.setMaximumSize(new Dimension(1000, 730));
		this.setVisible(true);
        this.add(getButtonCadastroAluno());
        this.add(getButtonCadastroClasse());
        this.add(getButtonCadastroCurso());
        this.add(getButtonCadastroDisciplina());
        this.add(getButtonCadastroProfessor());
		this.add(getButtonVoltar());

		this.add(getMenuBarMenu());
		
	//	this.add(menu.getMenuBarMenu());
	//	this.add(getButtonCancelar());
	//	this.add(getButtonFechar()); 
    }
    

    public JButton getButtonCadastroProfessor() {
        if(buttonCadastroProfessor == null){
            buttonCadastroProfessor = new JButton("CADASTRAR PROFESSOR");
            buttonCadastroProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonCadastroProfessor.setBounds(41, 454, 219, 40);
            buttonCadastroProfessor.setBackground(new Color(255, 255, 255));
            buttonCadastroProfessor.setVisible(true);
     
        }
        return buttonCadastroProfessor;
    }
   
    public JButton getButtonCadastroAluno() {
        if(buttonCadastroAluno == null){
            buttonCadastroAluno = new JButton("CADASTRAR ALUNO");
            buttonCadastroAluno.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonCadastroAluno.setBounds(41, 82, 219, 40);
            buttonCadastroAluno.setBackground(new Color(255, 255, 255));
            buttonCadastroAluno.setVisible(true);
        }
        return buttonCadastroAluno;
    }

    public JButton getButtonCadastroClasse() {
        if(buttonCadastroClasse == null){
            buttonCadastroClasse = new JButton("CADASTRAR CLASSE");
            buttonCadastroClasse.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonCadastroClasse.setBounds(41, 170, 219, 40);
            buttonCadastroClasse.setBackground(new Color(255, 255, 255));
            buttonCadastroClasse.setVisible(true);
        }
        return buttonCadastroClasse;
    }

    public JButton getButtonCadastroCurso() {
    	if(buttonCadastroCurso == null){
    		buttonCadastroCurso = new JButton("CADASTRAR CURSO");
    		buttonCadastroCurso.setFont(new Font("Arial", Font.PLAIN, 14));
    		buttonCadastroCurso.setBounds(41, 263, 219, 40);
    		buttonCadastroCurso.setBackground(new Color(255, 255, 255));
    		buttonCadastroCurso.setVisible(true);
        }
		return buttonCadastroCurso;
	}

    public JButton getButtonCadastroDisciplina() {
        if(buttonCadastroDisciplina == null){
            buttonCadastroDisciplina = new JButton("CADASTRAR DISCIPLINA");
            buttonCadastroDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
            buttonCadastroDisciplina.setBounds(41, 363, 219, 40);
            buttonCadastroDisciplina.setBackground(new Color(255, 255, 255));
            buttonCadastroDisciplina.setVisible(true); 
        }
        return buttonCadastroDisciplina;
    }
    
    public JButton getButtonVoltar() {
		if(buttonVoltar == null) {
			buttonVoltar = new JButton("VOLTAR");
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonVoltar.setBounds(54, 631, 130, 33);
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
			menuCadastros.setBounds(1, 2, 90, 48);
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

	public JMenuItem getMenuItemAluno() {
		if(menuItemAluno == null) {
			menuItemAluno = new JMenuItem("Aluno");
			menuItemAluno.setBounds(1, 2, 40, 30);
		}
		return menuItemAluno;
	}

	public JMenuItem getMenuItemClasse() {
		if(menuItemClasse == null) {
			menuItemClasse = new JMenuItem("Classe");
			menuItemClasse.setBounds(1, 80, 40, 30);
		}
		return menuItemClasse;
	}

	public JMenuItem getMenuItemCurso() {
		if(menuItemCurso == null) {
			menuItemCurso = new JMenuItem("Curso");
			menuItemCurso.setBounds(1, 112, 40, 30);
		}
		return menuItemCurso;
	}

	public JMenuItem getMenuItemDisciplina() {
		if(menuItemDisciplina == null) {
			menuItemDisciplina = new JMenuItem("Disciplina");
			menuItemDisciplina.setBounds(1, 144, 40, 30);
		}
		return menuItemDisciplina;
	}

	public JMenuItem getMenuItemProfessor() {
		if(menuItemProfessor == null) {
			menuItemProfessor = new JMenuItem("Professor");
			menuItemProfessor.setBounds(1, 176, 40, 30);
		}
		return menuItemProfessor;
	}
}
