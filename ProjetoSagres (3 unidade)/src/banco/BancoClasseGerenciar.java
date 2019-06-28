package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoClasseGerenciar {
	Banco banco = new Banco();
	Connection conexao = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private Statement consulta;
	
	
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
