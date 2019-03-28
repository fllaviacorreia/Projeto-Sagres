package modelo;

import java.util.ArrayList;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

public class Classe {
	private String curso;
	private String disciplina;
	private ArrayList<String> professores;
	private ArrayList<String> alunos;
	private String anoSemestre;
	private String diaHora;
	
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

	public String getDiaHora() {
		return diaHora;
	}

	public void setDiaHora(String diaHora) {
		this.diaHora = diaHora;
	}

	   
}
