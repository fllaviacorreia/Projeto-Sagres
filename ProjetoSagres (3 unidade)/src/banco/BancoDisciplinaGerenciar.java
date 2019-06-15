package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Curso;
import modelo.Disciplina;

public class BancoDisciplinaGerenciar {
	private Connection conexao;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private ResultSet resultSet1;
	private Statement consulta;

	public boolean BancoDisciplinaInserir(Disciplina disciplina) {
		//aqui é o comando em sql que é necessário para inserir no banco de dados
		String sqlDisciplina = "INSERT INTO Disciplina(nomeDisciplina, areaDisciplina, semestre, cargaHoraria," + 
				" optativaObrigatoria, teorica, estagio, pratica, preRequisito, Curso_idCurso ) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		/*
		 * String nome_Disciplina, String semestre, String area_Disciplina, String curso,
		 *	String tipoDisciplina, ArrayList<String> preRequisitos, String carga_Horaria, boolean ePreRequisito,
		 *	boolean optativa, boolean obrigatoria, boolean teorica, boolean pratica, boolean estagio
		 */
		int curso = Integer.parseInt(new Banco().consultar("Curso", "nomeCurso", disciplina.getCurso(), "idCurso"));
	//	System.out.println("id curso selecionado = " + curso);
		conexao = BancoConexao.open();
		
		try {
			preparedStatement = conexao.prepareStatement(sqlDisciplina);
			preparedStatement.setString(1, disciplina.getNome_Disciplina());
			preparedStatement.setString(2, disciplina.getArea_Disciplina());
			preparedStatement.setString(3, disciplina.getSemestre());
			preparedStatement.setString(4, disciplina.getCarga_Horaria());
			if(disciplina.getOptativa())
				preparedStatement.setString(5, "OPTATIVA");
			else
				preparedStatement.setString(5, "OBRIGATORIA");

			preparedStatement.setBoolean(6, disciplina.getTeorica());
			preparedStatement.setBoolean(7, disciplina.getEstagio());
			preparedStatement.setBoolean(8, disciplina.getPratica());
			preparedStatement.setBoolean(9, disciplina.getEPreRequisito());
			preparedStatement.setInt(10, curso);
			
			int teste = preparedStatement.executeUpdate();

			if(teste > 0) {
				preparedStatement.close();
				conexao.close();
				return true;
			}
			
			
		} catch (Exception e) {
			
			System.err.println("Erro inserir disciplina "+e);	
		}								
	
		return false;
}
	
	public int contar( String campo, String query) {
		int qtd = 0;
		try {
			conexao = BancoConexao.open();
			consulta = conexao.createStatement();
			resultSet = consulta.executeQuery("SELECT COUNT(" + campo + ")FROM Disciplina WHERE " + query);
			resultSet.first();
			qtd = this.resultSet.getInt("COUNT(" + campo + ")");
		} catch (SQLException e) {
			System.out.println("Não foi possível realizar a contagem!\n" + e.getMessage());
		}
		return qtd;
	}
	
	public int contar(String tabela) {
		int qtd = 0;
		try {
			conexao = BancoConexao.open();
			consulta = conexao.createStatement();
			resultSet = consulta.executeQuery("SELECT COUNT(*)FROM " + tabela);
			resultSet.first();
			qtd = this.resultSet.getInt("COUNT(*)");
		} catch (SQLException e) {
			System.out.println("Não foi possível realizar a contagem!\n" + e.getMessage());
		}
		return qtd;
	}
	public String consultar(String tabela, String chave, String valorChave, String campo) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM Curso WHERE " + chave + " = '" + valorChave + "'";
		try {
			conexao = BancoConexao.open();
			preparedStatement = conexao.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			if (resultSet.next()) {
				retorno = (String) resultSet.getString(campo);
			}
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro: Não foi possível consultar!\n" + e.getMessage());
		}
		return retorno;
	}
	
	public ArrayList<String> consultarUmaColuna(String tabela, String coluna) {
		ArrayList<String> lista = new ArrayList<String>();
		String sql = "SELECT * FROM " + tabela;
		conexao = BancoConexao.open();
		try {
			preparedStatement = conexao.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				lista.add(resultSet.getString(coluna));
			}
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<String> consultarUmaColuna(String tabela, String coluna, String campo, String valorCampo) {
		ArrayList<String> lista = new ArrayList<String>();
		String sql = "SELECT * FROM " + tabela + " WHERE " + campo + " = '" + valorCampo +"'";
		conexao = BancoConexao.open();
		try {
			preparedStatement = conexao.prepareStatement(sql);
			resultSet1 = preparedStatement.executeQuery(sql);
			while (resultSet1.next()) {
				lista.add(resultSet1.getString(coluna));
			}
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public boolean inserirPreRequisitos(int idDisciplina, int idPreRequisito, String nomePreRequisito){
		
		String sqlDisciplina = "INSERT INTO disciplina_tem_prerequisito(idDisciplina, idPreRequisito, nomePreRequisito) VALUES(?, ?, ?)";
		conexao = BancoConexao.open();
		
		try {
			preparedStatement = conexao.prepareStatement(sqlDisciplina);
			preparedStatement.setInt(1, idDisciplina);
			preparedStatement.setInt(2, idPreRequisito);
			preparedStatement.setString(3, nomePreRequisito);
			int teste = preparedStatement.executeUpdate();
			if(teste > 0) {
//					System.out.println("Inserir1");
				preparedStatement.close();
				conexao.close();
				return true;
			}
			
			
		} catch (Exception e) {
			
			System.err.println("Erro inserir curso "+e);	
		}								
		return false;
	}
	
	public void insereDisciplinasNoArray() {
		String sql = "SELECT * FROM Disciplina";
		conexao = BancoConexao.open();
		try {
			preparedStatement = conexao.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				String curso = new BancoCursoGerenciar().consultar("idCurso", 
						String.valueOf(resultSet.getInt("Curso_idCurso")), "nomeCurso");
				boolean optativa, obrigatoria;
				if(resultSet.getString("optativaObrigatoria").equals("OPTATIVA")) {
					optativa = true;
					obrigatoria = false;
				}else {
					optativa = false;
					obrigatoria = true;
				}
				ArrayList<String> preRequisitos = consultarUmaColuna("disciplina_tem_prerequisito", "nomePreRequisito", "idDisciplina", String.valueOf(resultSet.getInt("idDisciplina")));
				Disciplina disciplina = new Disciplina(resultSet.getString("nomeDisciplina"), resultSet.getString("SEMESTRE"), 
						resultSet.getString("areaDisciplina"), curso, preRequisitos, resultSet.getString("cargaHoraria"), 
						resultSet.getBoolean("preRequisito"), optativa, obrigatoria, 
						resultSet.getBoolean("teorica"), resultSet.getBoolean("pratica"), resultSet.getBoolean("estagio"));
				
			}
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
