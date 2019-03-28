package modelo;

import java.util.ArrayList;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import javax.swing.JComboBox;

public class Aluno {
	
/*
 * Em aluno, na parte da visão falta pegar os nomes de cada disciplina e 
 * verificar se existem para haver a confirmação de cadastro de disciplina no sistema e 
 * jogar no histórico de disciplinas do aluno	
 * 
 */
	private String nome;
	private String matricula;
	private String cpf;
	private String rgUf;
	private String dataExpedicaoOrgaoExp;
	private ArrayList<String> historicoDisciplinas;
	private String curso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRgUf() {
		return rgUf;
	}

	public void setRgUf(String rg) {
		this.rgUf = rg;
	}

	public String getDataExpedicaoOrgaoExp() {
		return dataExpedicaoOrgaoExp;
	}

	public void setDataExpedicaoOrgaoExp(String dataExpedicaoOrgaoExp) {
		this.dataExpedicaoOrgaoExp = dataExpedicaoOrgaoExp;
	}

	public ArrayList<String> getHistoricoDisciplinas() {
		return historicoDisciplinas;
	}

	public void setHistoricoDisciplinas(ArrayList<String> disciplinas) {
		this.historicoDisciplinas = disciplinas;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}  
}
