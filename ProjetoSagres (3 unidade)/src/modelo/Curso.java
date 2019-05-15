package modelo;

import java.util.ArrayList;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

public class Curso {
//	private ArrayList<String> disciplinas;
	private String cargaHorariaTotal;
	private String nome;
	private String tipoCurso;
	private String semestres;
	
//	public ArrayList<String> getDisciplinas() {
//		return disciplinas;
//	}
//	public void setDisciplinas(ArrayList<String> disciplinas2) {
//		this.disciplinas = disciplinas2;
//	}
	public String getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}
	public void setCargaHorariaTotal(String cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoCurso() {
		return tipoCurso;
	}
	public void setTipoCurso(String horario) {
		this.tipoCurso = horario;
	}
	public String getSemestres() {
		return semestres;
	}
	public void setSemestres(String dados) {
		this.semestres = dados;
	}
	
	
}
