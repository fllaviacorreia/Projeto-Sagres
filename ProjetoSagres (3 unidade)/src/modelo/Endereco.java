package modelo;

import controle.Main;

public class Endereco {
	String cep;
	String rua;
	String numero;
	String complemento;
	String bairro;
	String cidade;
	String estado;
	String tipo;
	
	
	
	public Endereco(String cep, String rua, String numero, String complemento, String bairro, String cidade, String estado, String tipo) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.tipo = tipo;
		Main.endereco.add(this);
		System.out.println(cep +"  " + rua +"  " + numero +"  " + complemento +"  " + bairro +"  " + cidade +"  " + estado +"  " + tipo);
	
	}
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
