package modelo;

import controle.Main;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

public class Curso {
	private String cargaHorariaTotal;
	private String nome;
	private String tipo;
	private String semestres;
	private String tipoCurso;
	private String tipoGraduacao;
	private int id;
	
	public Curso(String cargaHorariaTotal, String nome, String tipo, String semestres, String tipoCurso,
			String tipoGraduacao) {
		super();
		this.cargaHorariaTotal = cargaHorariaTotal;
		this.nome = nome;
		this.tipo = tipo;
		this.semestres = semestres;
		this.tipoCurso = tipoCurso;
		this.tipoGraduacao = tipoGraduacao;
		Main.curso.add(this);
	}
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String horario) {
		this.tipo = horario;
	}
	public String getSemestres() {
		return semestres;
	}
	public void setSemestres(String dados) {
		this.semestres = dados;
	}
	public String getTipoGraduacao() {
		return tipoGraduacao;
	}
	public void setTipoGraduacao(String tipoGraduacao) {
		this.tipoGraduacao = tipoGraduacao;
	}
	public String getTipoCurso() {
		return tipoCurso;
	}
	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}  
	
}
