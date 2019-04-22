package modelo;

import java.util.ArrayList;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import javax.swing.JComboBox;

import controle.Main;

public class Aluno extends Endereco{

/*
 * Em aluno, na parte da visão falta pegar os nomes de cada disciplina e 
 * verificar se existem para haver a confirmação de cadastro de disciplina no sistema e 
 * jogar no histórico de disciplinas do aluno	
 * 
 */
	private String nome;
	private String matricula;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String uf;
	private String dataExpedicao;
	private String orgaoExp;
	private String curso;
	private ArrayList<String> historicoDisciplinas;
	
	public Aluno(String id, String rua, String numero, String complemento, String bairro, String cidade, String estado,
			String nome, String matricula, String cpf, String rg, String uf, String dataExpedicao, String orgaoExp,
			String curso, ArrayList<String> historicoDisciplinas) {
		super(id, rua, numero, complemento, bairro, cidade, estado);
		this.nome = nome;
		this.matricula = matricula;
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
}
