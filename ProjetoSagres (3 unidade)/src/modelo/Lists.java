package modelo;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controle.Main;


public class Lists {
	private static Lists lista;
	static Calendar calendario = Calendar.getInstance();
	synchronized public static Lists getInstance() {
		if (lista == null) {
			lista = new Lists();
		}
		return lista;
	}

	public static boolean VerificaCPF(String cpf, String tipo) {
		boolean verificar = false;
		if(tipo.equals("aluno")) {
			for (Aluno inicio : Main.aluno) {
				if (inicio.getCpf().equals(cpf)) {
					verificar = true;
				}
			}
		}
		if(tipo.equals("professor")) {
			for (Professor inicio : Main.professor) {
				if (inicio.getCpf().equals(cpf)) {
					verificar = true;
				}
			}
		}
		return verificar;
	}

	public static boolean isCPF(String CPF) {
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			return false;
		}
		char dig10, dig11;
		int sm, r, num, peso;
		try {
			sm = 0;
			peso = 10;
			for (int i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) {
				dig10 = '0';
			} else {
				dig10 = (char) (r + 48);
			}
			sm = 0;
			peso = 11;
			for (int i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) {
				dig11 = '0';
			} else {
				dig11 = (char) (r + 48);
			}
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
				return true;
			} else {
				return false;
			}
		} catch (InputMismatchException erro) {
			return false;
		}
	}
	
	public static boolean validaData(String [] data) {
		int dia = Integer.parseInt(data[0]);
		int mes = Integer.parseInt(data[1]);
		int ano = Integer.parseInt(data[2]);
		
		int limiteAno = calendario.get(Calendar.YEAR) - 70;
		System.out.println("calendario.get(Calendar.YEAR) - 70 = " + (calendario.get(Calendar.YEAR) - 70));
		if(dia <= 31 && dia>0 && mes>0 && mes<13){
			
			if(dia>29 && mes == 2) //verifica se o dia é maior que 29 e o mês é fevereiro
				return false;
					
			else if (dia <= 29 && mes == 2 && (ano%4 == 0 && ano%100 != 0)) //verifica se o ano é bissexto e o mês fevereiro
				return true;
				
			else if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12 && dia<=31) //verifica os meses com 31 dias
				return true;
		
			else if(mes==4 || mes==6 ||  mes==9 || mes==11 && dia<=30) //verifica os meses com 30 dias
				return true;

			else if(ano < limiteAno) {
				return false;
			}
			else
				return false;
		}
		else	
			return false;
		
	}

	public static boolean isEmail(String email) {
		if ((email == null) || (email.trim().length() == 0))
			return false;

		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean isRg(String rg) {
		if ((rg == null) || (rg.trim().length() == 0 || rg.trim().length() > 13))
			return false;

		String rgPattern = "/^[0-9]{2,3}\\.?[0-9]{2,3}\\.?[0-9]{3}\\-?[A-Za-z0-9]{1}$/";
		Pattern pattern = Pattern.compile(rgPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(rg);
		return matcher.matches();
	}

}
