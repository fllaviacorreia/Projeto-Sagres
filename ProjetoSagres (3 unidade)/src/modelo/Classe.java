package modelo;

import java.util.ArrayList;

import controle.Main;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

public class Classe {
	private int id;
	private String curso;
	private String disciplina;
	private ArrayList<String> professores;
	private ArrayList<String> alunos;
	private String anoSemestre;
	private String dia;
	private String hora;
	
	
	
	public Classe(String curso, String disciplina, ArrayList<String> professores, ArrayList<String> alunos,
			String anoSemestre, String dia, String hora) {
		super();
		this.curso = curso;
		this.disciplina = disciplina;
		this.professores = professores;
		this.alunos = alunos;
		this.anoSemestre = anoSemestre;
		this.dia = dia;
		this.hora = hora;
		Main.classe.add(this);
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public ArrayList<String> getProfessor() {
		return professores;
	}

	public void setProfessor(ArrayList<String> professores2) {
		this.professores = professores2;
	}

	public ArrayList<String> getAluno() {
		return alunos;
	}

	public void setAluno(ArrayList<String> alunos2) {
		this.alunos = alunos2;
	}

	public String getAnoSemestre() {
		return anoSemestre;
	}

	public void setAnoSemestre(String semestre) {
		this.anoSemestre = semestre;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String diaHora) {
		this.dia = diaHora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}     
}
