package banco;

import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Aluno;
import modelo.Curso;

public class BancoCursoGerenciar {
//	Banco banco = new Banco();
	Connection conexao = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private Statement consulta;
	
	public boolean BancoCursoInserir(Curso curso) {
			//aqui � o comando em sql que � necess�rio para inserir no banco de dados
			String sqlCurso = "INSERT INTO Curso(nomeCurso, cargaHorariaTotal, tipo, quantidadeSemestres, tipoCurso, tipoGraduacao) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			
			conexao = BancoConexao.open();
			
			try {
				preparedStatement = conexao.prepareStatement(sqlCurso);
				preparedStatement.setString(1, curso.getNome());
				preparedStatement.setString(2, curso.getCargaHorariaTotal());
				preparedStatement.setString(3, curso.getTipo());
				preparedStatement.setString(4, curso.getSemestres());
				preparedStatement.setString(5, curso.getTipoCurso());
				preparedStatement.setString(6, curso.getTipoGraduacao());
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
			System.out.println("N�o foi poss�vel realizar a contagem!\n" + e.getMessage());
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
			System.out.println("N�o foi poss�vel realizar a contagem!\n" + e.getMessage());
		}
		return qtd;
	}
	//vai consultar alguma coisa especifica 
	public String consultar(String chave, String valorChave, String campo) {
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
			System.out.println("Erro: N�o foi poss�vel consultar!\n" + e.getMessage());
		}
		return retorno;
	}
	//usa para verificar o ultimo id 
	public int primeiroEultimo(String campo, int op) {
		int valor = 0;
		try {
			conexao = BancoConexao.open();
			if (op <= 0) {
				String sql = "SELECT MIN(" + campo + ") AS resultado FROM Curso";
				preparedStatement = conexao.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery(sql);
			} else {
				String sql = "SELECT MAX(" + campo + ") AS resultado FROM Curso";
				preparedStatement = conexao.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery(sql);
			}
			if (resultSet.next()) {
				valor = this.resultSet.getInt(1);
			}
			conexao.close();
		} catch (SQLException e) {
			System.out.println("N�o foi possivel realizar a pesquisar Firts/Last!\n" + e.getMessage());
		}
		return valor;
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
	
	public void insereCursosNoArray() {
		String sql = "SELECT * FROM Curso";
		conexao = BancoConexao.open();
		try {
			preparedStatement = conexao.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				Curso curso = new Curso(resultSet.getString("cargaHorariaTotal"), resultSet.getString("nomeCurso"), 
						resultSet.getString("tipo"), resultSet.getString("quantidadeSemestres"), resultSet.getString("tipoCurso"), 
						resultSet.getString("tipoGraduacao"));
				curso.setId(resultSet.getInt("idCurso"));
			}
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ver se est� funcionando dps
	/*public void BancoCursoDeletar(String nome) {
		
		String sqlCurso = "DELETE From Curso WHERE idCurso = ?";
		
		conexao = BancoConexao.open();
		
		try {
			preparedStatement = conexao.prepareStatement(sqlCurso);
			sqlCurso.setString(1, );
			sqlCurso.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			sqlCurso.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  excluir " + e);

			e.printStackTrace();
		}
		
	}*/
	
	public boolean BancoCursoAlterar(Curso curso) {
		//aqui � o comando em sql que � necess�rio para inserir no banco de dados
		//chave prim�ria de curso? 
		String sqlCurso = "UPDATE Curso SET nomeCurso = ?, cargaHorariaTotal = ?, tipo = ?, quantidadeSemestres = ?, tipoCurso = ?, tipoGraduacao = ? WHERE nomeCurso = ?";
		
		conexao = BancoConexao.open();
		
		try {
			preparedStatement = conexao.prepareStatement(sqlCurso);
			preparedStatement.setString(1, curso.getNome());
			preparedStatement.setString(2, curso.getCargaHorariaTotal());
			preparedStatement.setString(3, curso.getTipo());
			preparedStatement.setString(4, curso.getSemestres());
			preparedStatement.setString(5, curso.getTipoCurso());
			preparedStatement.setString(6, curso.getTipoGraduacao());
			preparedStatement.setString(7, curso.getNome());
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
}
	