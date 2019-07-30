package modelo;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.util.ArrayList;

public class Horario {
	private String curso;
	private String disciplina;
	private String professor;
	private String tipoAula;
	private ArrayList<Object> horario;
	
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

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getTipoAula() {
		return tipoAula;
	}

	public void setTipoAula(String tipoAula) {
		this.tipoAula = tipoAula;
	}

	public ArrayList<Object> getHorario() {
		return horario;
	}

	public void setHorario(ArrayList<Object> horario) {
		this.horario = horario;
	}

}
