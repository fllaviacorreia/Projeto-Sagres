package modelo;

import java.util.ArrayList;

import controle.Main;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

public class Curso {
	private String cargaHorariaTotal;
	private String nome;
	private String tipoCurso;
	private String semestres;
	private boolean licenciatura;
	private boolean bacharelado;
	

	public Curso(String cargaHorariaTotal, String nome, String tipoCurso, String semestres, boolean licenciatura,
			boolean bacharelado) {
		super();
		this.cargaHorariaTotal = cargaHorariaTotal;
		this.nome = nome;
		this.tipoCurso = tipoCurso;
		this.semestres = semestres;
		this.licenciatura = licenciatura;
		this.bacharelado = bacharelado;
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
	public boolean isLicenciatura() {
		return licenciatura;
	}
	public void setLicenciatura(boolean licenciatura) {
		this.licenciatura = licenciatura;
	}
	public boolean isBacharelado() {
		return bacharelado;
	}
	public void setBacharelado(boolean bacharelado) {
		this.bacharelado = bacharelado;
	}
	
	
}
