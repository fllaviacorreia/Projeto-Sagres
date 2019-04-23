package modelo.validacao;
/**
 * 
 * @author Murilo Silva Santana
 * 
 * @edited Fl·via de Jesus Correia
 * */
import java.text.ParseException;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class FormataMascaras {
	public MaskFormatter mascara = null;
	public String string;
	// construtor padr„o
	void Formata(String formato, int opcao) {
		if(opcao == 1) {
			try{
				mascara =  new MaskFormatter(formato);
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
		}else if(opcao == 2){
			try{
				mascara = new MaskFormatter("*******************************************************");
				mascara.setValidCharacters(" ‡·‚„ÈÍÌÛÙ˙abcÁdefghijklmnopqrstuvwxyz¿¡¬√… Õ”‘⁄ABC«DEFGHIJKLMNOPQRSTUVWXYZ");
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
			
		}else if(opcao == 3){
			try{
				mascara = new MaskFormatter("******************************");
				mascara.setValidCharacters(" 0123456789‡·‚„ÈÍÌÛÙ˙abcÁdefghijklmnopqrstuvwxyz¿¡¬√… Õ”‘⁄ABC«DEFGHIJKLMNOPQRSTUVWXYZ");
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
		}
		
		
		
	}
	
	// construtor que recebe uma String para o formato da m·scara
	// retorna a m·scara com o formato inserido pelo usu·rio
	
	
	// retorna m·scara CPF
	public DefaultFormatterFactory getCPF() {
		Formata("###########", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
//	// retorna m·scara RG
//	public DefaultFormatterFactory getRG() {
//		Formata("##.###.###-##", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
//	public DefaultFormatterFactory getNumero() {
//		Formata("", 3);
//		return new DefaultFormatterFactory(mascara);
//	}
	
	//retorna mascara para matricula
	public DefaultFormatterFactory getMatricula() {
		Formata("#########", 1);
		return new DefaultFormatterFactory(mascara);
	}
	// retorna m·scara telefone
	public DefaultFormatterFactory getTelefone() {
		Formata("(##) #####-####", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
//	// retorna m·scara CEP
//	public DefaultFormatterFactory getCEP() {
//		Formata("##.###-###", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
	// retorna m·scara Data
	public DefaultFormatterFactory getData() {
		Formata("##/##/####", 1);
		return new DefaultFormatterFactory(mascara);
	}
//	
//	//retorna m·scara AgÍncia Banc·ria
//	public DefaultFormatterFactory getAgencia() {
//		Formata("####", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
//	//retorna m·scara N˙mero da Conta Corrente/PoupanÁa
//	public DefaultFormatterFactory getNumeroConta() {
//		Formata("#########", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
//	public DefaultFormatterFactory getQuantia() {
//		Formata("########", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
	//retorna m·scara para nome 
	public DefaultFormatterFactory getNome() {
		Formata("", 2);
		return new DefaultFormatterFactory(mascara);
	}
	
	//retorna m·scara para qualquer campo de endereÁo
	public DefaultFormatterFactory getEndereco() {
		Formata("", 3);
		return new DefaultFormatterFactory(mascara);
	}
		
	
}
