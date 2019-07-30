package modelo;

import controle.Main;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

public class Professor{
	

	/**
	 * em professor, falta fazer arquivo, fazer verificação da área de atuação para 
	 * não colocar ítens repetidos no combobox
	 */
	private String nome;
	private String dataNascimento;
	private String matricula;
    private String area;
    private String carga_Horaria;
    private String email;
	private String telefone;
	private String celular;
    private String cpf;
	private String rg;
	private String uf;
	private String dataExpedicao;
	private String orgaoExp;
	private int id;
	
	public Professor(String nome, String dataNascimento, String matricula, String area, String carga_Horaria, String email, 
			String telefone, String celular,String cpf, String rg, String uf, String dataExpedicao, String orgaoExp) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.matricula = matricula;
		this.area = area;
		this.carga_Horaria = carga_Horaria;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.dataExpedicao = dataExpedicao;
		this.orgaoExp = orgaoExp;
		Main.professor.add(this);
	}
	
	 public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCarga_Horaria() {
        return carga_Horaria;
    }

    public void setCarga_Horaria(String dados) {
        this.carga_Horaria = dados;
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
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}  
}
