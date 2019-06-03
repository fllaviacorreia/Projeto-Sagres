package controle;

import java.util.ArrayList;


import modelo.Aluno;
import modelo.Arquivo;
import modelo.Classe;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Endereco;
import modelo.Professor;

public class Main {
	public static ArrayList<Aluno> 			aluno 			= new ArrayList<Aluno>();
	public static ArrayList<Classe> 		classe 			= new ArrayList<Classe>();
	public static ArrayList<Curso> 			curso 			= new ArrayList<Curso>();
	public static ArrayList<Disciplina> 	disciplina 		= new ArrayList<Disciplina>();
	public static ArrayList<Professor> 		professor 		= new ArrayList<Professor>();
	public static ArrayList<Endereco>		endereco		= new ArrayList<Endereco>();
	
	public static void main(String[] args) {			
	//	new ControleArquivo(6);
		new ControlePainelTelaLogin();
		System.out.println("Main");
	}

}
