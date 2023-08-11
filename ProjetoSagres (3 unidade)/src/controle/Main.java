package controle;

import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import banco.BancoAlunoGerenciar;
import banco.BancoCursoGerenciar;
import banco.BancoDisciplinaGerenciar;
import banco.BancoEnderecoGerenciar;
import modelo.Aluno;
//import modelo.Arquivo;
import modelo.Classe;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Endereco;
import modelo.ModeloTabelaAluno;
import modelo.Professor;

public class Main {
	public static ArrayList<Aluno> aluno = new ArrayList<Aluno>();
	public static ArrayList<Classe> classe = new ArrayList<Classe>();
	public static ArrayList<Curso> curso = new ArrayList<Curso>();
	public static ArrayList<Disciplina> disciplina = new ArrayList<Disciplina>();
	public static ArrayList<Professor> professor = new ArrayList<Professor>();
	public static ArrayList<Endereco> endereco = new ArrayList<Endereco>();
	public static ArrayList<ModeloTabelaAluno> tabelas = new ArrayList<ModeloTabelaAluno>();

	public static void main(String[] args) {
				
		try {			
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		    UIManager.put ( "Button.arc", 999 );
		    UIManager.put ( "Component.arc", 999 );
		    UIManager.put ( "ProgressBar.arc", 999 );
		    UIManager.put ( "TextComponent.arc", 999 );
		    UIManager.put( "ScrollBar.trackArc", 999 );
		    UIManager.put( "ScrollBar.thumbArc", 999 );
		    UIManager.put( "ScrollBar.trackInsets", new Insets( 2, 4, 2, 4 ) );
		    UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
		    UIManager.put( "ScrollBar.track", new Color( 0xe0e0e0 ) );
		    UIManager.put ( "TabbedPane.showTabSeparators", true );
		    UIManager.put( "TabbedPane.selectedBackground", Color.white );
		    UIManager.put ( "Component.innerFocusWidth", 1 );
		    UIManager.put ( "Button.innerFocusWidth", 1 );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
//		 new ControleArquivo(6);
//		new BancoAlunoGerenciar().insereAlunosNoArray();
//		new BancoCursoGerenciar().insereCursosNoArray();
//		new BancoDisciplinaGerenciar().insereDisciplinasNoArray();
//		new BancoEnderecoGerenciar().insereEnderecoNoArray();
		new ControlePainelTelaLogin();
		System.out.println("Main");
	}

}
