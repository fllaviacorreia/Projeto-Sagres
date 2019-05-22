package controle;

import java.io.BufferedReader;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import modelo.Aluno;
import modelo.Classe;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Professor;

public class ControleArquivo{
	
	/***
	 * 
	 * @param value
	 * 
	 * 1 - aluno 
	 * 2 - classe
	 * 3 - curso
	 * 4 - disciplina
	 * 5 - professor
	 * 6 - realiza a verificação de todos os arquivos e preenche os arraylist's
	 * 
	 */

	String entrada;
	String [] pedacos;
	String junta;
	String dado;
	
	public ControleArquivo(int value) {

//		if(value == 1) {
//			ControleArquivoEscreveAluno();
//
//		}if(value == 2) {
//			ControleArquivoEscreveClasse();
//
//		}if(value == 3) {
//			ControleArquivoEscreveCurso();
//
//		}if(value == 4) {
//			ControleArquivoEscreveDisciplina();
//
//		}if(value == 5) {
//			ControleArquivoEscreveProfessor();
//		}
//		if(value == 6) {
//			ControleArquivoLeAluno();
//			ControleArquivoLeClasse();
//			ControleArquivoLeCurso();
//			ControleArquivoLeDisciplina();
//			ControleArquivoLeProfessor();
//		}

	}
//	
//	public void ControleArquivoEscreveAluno() {
//		try{
//			File arquivoAluno = new File("relatorios\\listaAlunos.txt");
//			BufferedWriter escreveArquivoAluno = new BufferedWriter(new FileWriter(arquivoAluno));
//			for(int i=0; i< Main.aluno.size(); i++)
//			{
//				//CEP;RUA;NUMERO;COMPLEMENTO;BAIRRO;CIDADE;ESTADO;TIPO;
//				//NOME;MATRICULA;DATA_NASCIMENTO;EMAIL;TELEFONE;CELULAR;CPF;RG;UF;DATA_EXP;ORGO_EXP;CURSO;DISCIPLINAS_CURSADAS;
//
//				
//				escreveArquivoAluno.write(Main.aluno.get(i).getCep());
//				escreveArquivoAluno.write(Main.aluno.get(i).getRua());
//				escreveArquivoAluno.write(Main.aluno.get(i).getNumero());
//				escreveArquivoAluno.write(Main.aluno.get(i).getComplemento());
//				escreveArquivoAluno.write(Main.aluno.get(i).getBairro());
//				escreveArquivoAluno.write(Main.aluno.get(i).getCidade());
//				escreveArquivoAluno.write(Main.aluno.get(i).getEstado());
//				escreveArquivoAluno.write(Main.aluno.get(i).getTipo());
//				escreveArquivoAluno.write(TiraEspaços(Main.aluno.get(i).getNome())+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getMatricula()+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getDataNascimento()+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getEmail()+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getTelefone()+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getCelular()+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getCpf()+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getRg()+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getUf()+";");
//				escreveArquivoAluno.write(Main.aluno.get(i).getDataExpedicao()+";");
//				escreveArquivoAluno.write(TiraEspaços(Main.aluno.get(i).getOrgaoExp()+";"));
//				escreveArquivoAluno.write(Main.aluno.get(i).getCurso()+";");
//				
//				if(Main.aluno.get(i).getHistoricoDisciplinas().equals(null)) {
//					escreveArquivoAluno.write(null+";");
//					
//				}else {
//					for(int j = 0; j < Main.aluno.get(i).getHistoricoDisciplinas().size(); j++)
//						escreveArquivoAluno.write(Main.aluno.get(i).getHistoricoDisciplinas().get(j).toString()+",");
//				}
//				
//				escreveArquivoAluno.newLine();
//			}
//			escreveArquivoAluno.close();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public void ControleArquivoEscreveClasse() {
//		try{
//			File arquivoClasse = new File("relatorios\\listaClasses.txt");
//			BufferedWriter escreveArquivoClasse = new BufferedWriter(new FileWriter(arquivoClasse));
//			for(int i=0; i< Main.classe.size(); i++)
//			{
//				//NOME_DISCIPLINA;PROFESSOR;ALUNO;ANO_SEMESTRE;DIA_HORA
//				dado = TiraEspaços(Main.classe.get(i).getDisciplina());
//				escreveArquivoClasse.write(dado+";");
//				for(int j = 0; j < Main.classe.get(i).getProfessor().size(); j++) {
//					escreveArquivoClasse.write(Main.classe.get(i).getProfessor().get(j).toString()+",");
//				}
//				escreveArquivoClasse.write(";");
//				for(int j = 0; j < Main.classe.get(i).getAluno().size(); j++) {
//					escreveArquivoClasse.write(Main.classe.get(i).getAluno().get(j).toString()+",");
//				}
//				escreveArquivoClasse.write(";");
//				escreveArquivoClasse.write(Main.classe.get(i).getAnoSemestre()+";");
//				escreveArquivoClasse.write(Main.classe.get(i).getDiaHora());
//				escreveArquivoClasse.newLine();
//			}
//			escreveArquivoClasse.close();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public void ControleArquivoEscreveCurso() {
//		try{
//			//NOME;CARGA_TOTAL;QTDD_SEMESTRES;DISCIPLINAS;TIPO_CURSO
//			File arquivoCurso = new File("relatorios\\listaCursos.txt");
//			BufferedWriter escreveArquivoCurso = new BufferedWriter(new FileWriter(arquivoCurso));
//			for(int i=0; i< Main.curso.size(); i++)
//			{
//				escreveArquivoCurso.write(dado+";");
//				escreveArquivoCurso.write(Main.curso.get(i).getCargaHorariaTotal()+";");
//				escreveArquivoCurso.write(Main.curso.get(i).getSemestres()+";");
//				for(int j = 0; j < Main.curso.get(i).getDisciplinas().size(); j++) {
//					escreveArquivoCurso.write(Main.curso.get(i).getDisciplinas().get(j).toString()+",");
//				}
//				escreveArquivoCurso.write(";");
//				escreveArquivoCurso.write(Main.curso.get(i).getTipoCurso());
//				escreveArquivoCurso.newLine();
//			}
//			escreveArquivoCurso.close();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public void ControleArquivoEscreveDisciplina() {
//		try{
//			File arquivoDisciplina = new File("relatorios\\listaDisciplinas.txt");
//			BufferedWriter escreveArquivoDisciplina = new BufferedWriter(new FileWriter(arquivoDisciplina));
//			for(int i=0; i< Main.disciplina.size(); i++)
//			{
//	//CURSO;NOME;CARGA;AREA;PRE-REQUISITOS;SEMESTRE;É_PRÉ-REQUISITO;É_OPTATIVA;TIPO_DISCIPLINA;TEORICA;PRATICA;ESTAGIO
//
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getCurso()+";");
//				dado = TiraEspaços(Main.disciplina.get(i).getNome_Disciplina());
//				escreveArquivoDisciplina.write(dado+";");
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getCarga_Horaria()+";");
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getArea_Disciplina()+";");
//				if(Main.disciplina.get(i).getPreRequisitos().equals(null)) {
//					escreveArquivoDisciplina.write(null+";");
//				}else {
//					for(int j =0; j < Main.disciplina.get(i).getPreRequisitos().size(); j++) {
//						escreveArquivoDisciplina.write(Main.disciplina.get(i).getPreRequisitos().get(j).toString()+",");
//					}
//					escreveArquivoDisciplina.write(";");
//				}
//				
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getSemestre()+";");
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getEPreRequisito()+";");
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getOptativa()+";");
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getTipoDisciplina()+";");
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getTeorica()+";");
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getPratica()+";");
//				escreveArquivoDisciplina.write(Main.disciplina.get(i).getEstagio()+"");
//				escreveArquivoDisciplina.newLine();
//			}
//			escreveArquivoDisciplina.close();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public void ControleArquivoEscreveProfessor() {
//		try{
//			File arquivoProfessor = new File("relatorios\\listaProfessores.txt");
//			BufferedWriter escreveArquivoProfessor = new BufferedWriter(new FileWriter(arquivoProfessor));
//			for(int i=0; i< Main.professor.size(); i++)
//			{
//				//CEP;RUA;NUMERO;COMPLEMENTO;BAIRRO;CIDADE;ESTADO;TIPO;
//				//NOME;MATRICULA;AREA;CARGA;CPF;RG;UF;DATA_EXP;ORGO_EXP
//				escreveArquivoProfessor.write(Main.professor.get(i).getCep());
//				escreveArquivoProfessor.write(Main.professor.get(i).getRua());
//				escreveArquivoProfessor.write(Main.professor.get(i).getNumero());
//				escreveArquivoProfessor.write(Main.professor.get(i).getComplemento());
//				escreveArquivoProfessor.write(Main.professor.get(i).getBairro());
//				escreveArquivoProfessor.write(Main.professor.get(i).getCidade());
//				escreveArquivoProfessor.write(Main.professor.get(i).getEstado());
//				escreveArquivoProfessor.write(Main.professor.get(i).getTipo());
//				escreveArquivoProfessor.write(TiraEspaços(Main.professor.get(i).getNome())+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getDataNascimento()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getMatricula()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getArea()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getCarga_Horaria()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getEmail()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getTelefone()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getCelular()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getCpf()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getRg()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getUf()+";");
//				escreveArquivoProfessor.write(Main.professor.get(i).getDataExpedicao()+";");
//				escreveArquivoProfessor.write(TiraEspaços(Main.professor.get(i).getOrgaoExp()));
//				escreveArquivoProfessor.newLine();
//			}
//			escreveArquivoProfessor.close();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public void ControleArquivoLeAluno() {
//		try {
//			File arquivo = new File("relatorios\\listaAlunos.txt"); 
//			if(arquivo.exists()) {
//				FileReader arquivoAluno = new FileReader("relatorios\\listaAlunos.txt");
//				BufferedReader lerArquivoAluno = new BufferedReader(arquivoAluno);
//				
//				//CEP;RUA;NUMERO;COMPLEMENTO;BAIRRO;CIDADE;ESTADO;TIPO;
//				//NOME;MATRICULA;DATA_NASCIMENTO;EMAIL;TELEFONE;CELULAR;CPF;RG;UF;DATA_EXP;ORGO_EXP;CURSO;DISCIPLINAS_CURSADAS;
//				String linha = lerArquivoAluno.readLine();
//				while (linha != null) {
//					String [] dados = linha.split(";");
//					new Aluno(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7],dados[8],
//							dados[9], dados[10], dados[11], dados[12], dados[13], dados[14],  dados[15], dados[16], 
//							dados[17], dados[18], dados[19],Dados(dados[20]));
//					
//					linha = lerArquivoAluno.readLine(); // lê da segunda até a última linha
//				}
//				arquivoAluno.close();
//			}else {
//				System.out.println("Arquivo aluno inexistente");
//			}
//		} catch (Exception e) {
//			System.err.printf("Erro na abertura do arquivo aluno: %s.\n",
//					e.getMessage());
//		}
//	}
//
//	public void ControleArquivoLeClasse() {
//		try {
//			File arquivo = new File("relatorios\\listaClasses.txt"); 
//			if(arquivo.exists()) {
//				FileReader arquivoClasse = new FileReader("relatorios\\listaClasses.txt");
//				BufferedReader lerArquivoClasse = new BufferedReader(arquivoClasse);
//
//				//NOME_DISCIPLINA;PROFESSOR;ALUNO;ANO_SEMESTRE;DIA_HORA;
//				String linha = lerArquivoClasse.readLine();
//				while (linha != null) {
//					String [] dados = linha.split(";");
//					Classe dado = new Classe();
//					dado.setDisciplina(dados[0]);
//					dado.setProfessor(Dados(dados[1]));
//					dado.setAluno(Dados(dados[2]));
//					dado.setAnoSemestre(dados[3]);
//					dado.setDiaHora(dados[4]);
//					Main.classe.add(dado);
//					linha = lerArquivoClasse.readLine(); // lê da segunda até a última linha
//				}
//				arquivoClasse.close();
//			}else {
//				System.out.println("Arquivo classe inexistente");
//			}
//		} catch (Exception e) {
//			System.err.printf("Erro na abertura do arquivo classe: %s.\n",
//					e.getMessage());
//		}
//	}
//
//	public void ControleArquivoLeCurso(){
//		try {
//			File arquivo = new File("relatorios\\listaCursos.txt"); 
//			if(arquivo.exists()) {
//				FileReader arquivoCurso = new FileReader("relatorios\\listaCursos.txt");
//				BufferedReader lerArquivoCurso = new BufferedReader(arquivoCurso);
//
//				//NOME;CARGA_TOTAL;QTDD_SEMESTRES;DISCIPLINAS;TIPO_CURSO
//				String linha = lerArquivoCurso.readLine();
//
//				while (linha != null) {
//					String [] dados = linha.split(";");
//					Curso dado = new Curso();
//					dado.setNome(dados[0]);
//					dado.setCargaHorariaTotal(dados[1]);
//					dado.setSemestres(dados[2]);
//					dado.setDisciplinas(Dados(dados[3]));
//					dado.setTipoCurso(dados[4]);
//					Main.curso.add(dado);
//					linha = lerArquivoCurso.readLine(); // lê da segunda até a última linha
//				}
//				arquivoCurso.close();
//			}else {
//				System.out.println("Arquivo curso inexistente");
//			}
//		} catch (Exception e) {
//			System.err.printf("Erro na abertura do arquivo curso: %s.\n",
//					e.getMessage());
//		}
//	}
//
//	public void ControleArquivoLeDisciplina() {
//
//		try {
//			File arquivo = new File("relatorios\\listaDisciplinas.txt"); 
//			if(arquivo.exists()) {
//				FileReader arquivoDisciplina = new FileReader("relatorios\\listaDisciplinas.txt");
//				BufferedReader lerArquivoDisciplina = new BufferedReader(arquivoDisciplina);
//
////CURSO;NOME;CARGA;AREA;PRE-REQUISITOS;SEMESTRE;É_PRÉ-REQUISITO;É_OPTATIVA;TIPO_DISCIPLINA;TEORICA;PRATICA;ESTAGIO;
//
//				String linha = lerArquivoDisciplina.readLine();
//				while (linha != null) {
//					String [] dados = linha.split(";");
//					Disciplina dado = new Disciplina();
//					dado.setCurso(dados[0]);
//					dado.setNome_Disciplina(dados[1]);
//					dado.setCarga_Horaria(dados[2]);
//					dado.setArea_Disciplina(dados[3]);
//					dado.setPreRequisitos(Dados(dados[4]));
//					dado.setSemestre(dados[5]);
//					dado.setEPreRequisito(Boolean.parseBoolean((String.valueOf(dados[6]))));
//					dado.setOptativa(Boolean.parseBoolean((String.valueOf(dados[7]))));
//					dado.setTipoDisciplina(dados[8]);
//					dado.setTeorica(true);
//					dado.setPratica(Boolean.parseBoolean((String.valueOf(dados[10]))));
//					dado.setEstagio(Boolean.parseBoolean((String.valueOf(dados[11]))));
//					Main.disciplina.add(dado);
//					linha = lerArquivoDisciplina.readLine(); // lê da segunda até a última linha
//				}
//				arquivoDisciplina.close();
//			}else {
//				System.out.println("Arquivo disciplina inexistente");
//			}
//		} catch (Exception e) {
//			System.err.printf("Erro na abertura do arquivo disciplina: %s.\n",
//					e.getMessage());
//		}
//	}
//
//	public void ControleArquivoLeProfessor() {
//		try {
//			File arquivo = new File("relatorios\\listaProfessores.txt"); 
//			if(arquivo.exists()) {
//				FileReader arquivoProfessor = new FileReader("relatorios\\listaProfessores.txt");
//				BufferedReader lerArquivoProfessor = new BufferedReader(arquivoProfessor);
//
//				//CEP;RUA;NUMERO;COMPLEMENTO;BAIRRO;CIDADE;ESTADO;TIPO;
//				//NOME;MATRICULA;AREA;CARGA;CPF;RG;UF;DATA_EXP;ORGO_EXP
//				String linha = lerArquivoProfessor.readLine();
//
//				while (linha != null) {
//					String [] dados = linha.split(";");
//					new Professor(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], 
//							dados[7],dados[8], dados[9], dados[10], dados[11], dados[12], dados[13], 
//							dados[14], dados[15], dados[16], dados[17],dados[18],dados[19],dados[20]);
//					
//					linha = lerArquivoProfessor.readLine(); // lê da segunda até a última linha
//				}
//				arquivoProfessor.close();
//			}else {
//				System.out.println("Arquivo professor inexistente");
//			}
//		} catch (Exception e) {
//			System.err.printf("Erro na abertura do arquivo professor: %s.\n",
//					e.getMessage());
//		}
//	}

//	public ArrayList<String> Dados(String dados){
//		String [] valores = dados.split(",");
//		ArrayList<String> dadosArray = new ArrayList<String>();
//
//		if(!dados.equals(null)) {
//			for(int i = 0; i < valores.length; i++) {
//				dadosArray.add(valores[i]);
//			}
//		}
//		return dadosArray;
//	}

	public String TiraEspaços(String dado) {
		entrada = dado;
		pedacos = entrada.split(" ");
		junta 	= "";

		for(int i=0; i<pedacos.length; i++){
			if(i == pedacos.length - 1) {
				junta = junta + pedacos[i];
			}
			else if(pedacos[i].equals(pedacos[i])) {
				junta = junta + pedacos[i] +" ";
			}
		} 
		return junta;
	}
}
