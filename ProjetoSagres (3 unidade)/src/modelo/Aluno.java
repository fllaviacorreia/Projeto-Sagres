package modelo;

import java.util.ArrayList;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import javax.swing.JComboBox;

import org.w3c.dom.views.AbstractView;

import controle.Main;

public class Aluno{

/*
 * Em aluno, na parte da visão falta pegar os nomes de cada disciplina e 
 * verificar se existem para haver a confirmação de cadastro de disciplina no sistema e 
 * jogar no histórico de disciplinas do aluno	
 * 
 */
	private int id;
	private String nome;
	private String matricula;
	private String dataNascimento;
	private String email;
	private String telefone;
	private String celular;
	private String cpf;
	private String rg;
	private String uf;
	private String dataExpedicao;
	private String orgaoExp;
	private String curso;
	private ArrayList<String> historicoDisciplinas;
	
	public Aluno(String nome, String matricula, String dataNascimento, String email, String telefone, String celular, 
			String cpf, String rg, String uf, String dataExpedicao, String orgaoExp, String curso, 
			ArrayList<String> historicoDisciplinas) {
		this.nome = nome;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.dataExpedicao = dataExpedicao;
		this.orgaoExp = orgaoExp;
		this.historicoDisciplinas = historicoDisciplinas;
		this.curso = curso;
		Main.aluno.add(this);
	}

	
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
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(String dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getOrgaoExp() {
		return orgaoExp;
	}

	public void setOrgaoExp(String orgaoExp) {
		this.orgaoExp = orgaoExp;
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}  
}
