package banco;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Curso;

public class BancoCursoGerenciar {
//	Banco banco = new Banco();
	Connection conexao = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private Statement consulta;
	
	public boolean BancoCursoInserir(Curso curso) {
			//aqui é o comando em sql que é necessário para inserir no banco de dados
			String sqlCurso = "INSERT INTO Curso(nomeCurso, cargaHorariaTotal, tipoCurso, quantidadeSemestres) VALUES(?, ?, ?, ?)";
			
			conexao = BancoConexao.open();
			
			try {
				preparedStatement = conexao.prepareStatement(sqlCurso);
				preparedStatement.setString(1, curso.getNome());
				preparedStatement.setString(2, curso.getCargaHorariaTotal());
				preparedStatement.setString(3, curso.getTipoCurso());
				preparedStatement.setString(4, curso.getSemestres());
				int teste = preparedStatement.executeUpdate();

				if(teste > 0) {
//						System.out.println("Inserir1");
					preparedStatement.close();
					conexao.close();
					return true;
				}
				
				
			} catch (Exception e) {
				
				System.err.println("Erro inserir curso "+e);	
			}								
		
			return false;
	}
	public int contar(String campo, String query) {
		int qtd = 0;
		try {
			conexao = BancoConexao.open();
			consulta = conexao.createStatement();
			resultSet = consulta.executeQuery("SELECT COUNT(" + campo + ")FROM Curso WHERE " + query);
			resultSet.first();
			qtd = this.resultSet.getInt("COUNT(" + campo + ")");
		} catch (SQLException e) {
			System.out.println("Não foi possível realizar a contagem!\n" + e.getMessage());
		}
		return qtd;
	}
	
	public int contar() {
		int qtd = 0;
		try {
			conexao = BancoConexao.open();
			consulta = conexao.createStatement();
			resultSet = consulta.executeQuery("SELECT COUNT(*)FROM Curso");
			resultSet.first();
			qtd = this.resultSet.getInt("COUNT(*)");
		} catch (SQLException e) {
			System.out.println("Não foi possível realizar a contagem!\n" + e.getMessage());
		}
		return qtd;
	}
	public String consultar(String chave, String valorChave, String campo) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM Curso WHERE " + chave + " = " + valorChave;
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
}
	