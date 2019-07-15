package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Classe;

public class BancoClasseGerenciar {
	Banco banco = new Banco();
	Connection conexao = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private Statement consulta;

	public boolean BancoClasseInserir(Classe classe) {
		String sqlClase = "INSERT INTO Classe(periodoLetivo, dia, hora) VALUES(?, ?, ?)";	
		conexao = BancoConexao.open();

		try {

			//lincando o comando com o banco em aluno
			preparedStatement = conexao.prepareStatement(sqlClase);

			//salvando na table os dados	
			preparedStatement.setString(1, classe.getAnoSemestre());
			preparedStatement.setString(2, classe.getDia());
			preparedStatement.setString(3, classe.getHora());

			int teste = preparedStatement.executeUpdate();

			if(teste > 0) {
				preparedStatement.close();
				conexao.close();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erro inserir classe "+e);	
		}

		return false;		
	}

	public boolean BancoClasseInserirAluno(Classe classe) {


		return true;
	}
	public boolean BancoClasseInserirProfessor(Classe classe) {


		return true;
	}
	public boolean BancoClasseInserirDisciplina(Classe classe) {


		return true;
	}
	public int contar(String campo, String query) {
		int qtd = 0;
		try {
			conexao = BancoConexao.open();
			consulta = conexao.createStatement();
			resultSet = consulta.executeQuery("SELECT COUNT(" + campo + ")FROM Classe WHERE " + query);
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
			resultSet = consulta.executeQuery("SELECT COUNT(*)FROM Classe");
			resultSet.first();
			qtd = this.resultSet.getInt("COUNT(*)");
		} catch (SQLException e) {
			System.out.println("Não foi possível realizar a contagem!\n" + e.getMessage());
		}
		return qtd;
	}
}
