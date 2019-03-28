package modelo;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

public class Professor {
	/**
	 * em professor, falta fazer arquivo, fazer verificação da área de atuaçõ para 
	 * não colocr ítens repetidos no combo box
	 */
	private String matricula;
    private String area;
    private String carga_Horaria;
    private String nome_Professor;

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

    public String getNome() {
        return nome_Professor;
    }

    public void setNome(String nome) {
        this.nome_Professor = nome;
    }
}
