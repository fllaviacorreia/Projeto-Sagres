package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.Endereco;

public class BancoEnderecoGerenciar {
	Connection conexao = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public boolean inserirEndereco(Endereco endereco) {
		String sqlEndereco = "INSERT INTO Endereco(cep, rua, numero, complemento, bairro, cidade, uf, tipo) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		conexao = BancoConexao.open();
		try {
			preparedStatement = conexao.prepareStatement(sqlEndereco);
			preparedStatement.setString(1, endereco.getCep());
			preparedStatement.setString(2, endereco.getRua());
			preparedStatement.setString(3, endereco.getNumero());
			preparedStatement.setString(4, endereco.getComplemento());
			preparedStatement.setString(5, endereco.getBairro());
			preparedStatement.setString(6, endereco.getCidade());
			preparedStatement.setString(7, endereco.getEstado());
			preparedStatement.setString(8, endereco.getTipo());
				
			//	System.out.println(preparetedStatement);
				int teste = preparedStatement.executeUpdate();

				if(teste > 0) {
					conexao.close();
					return true;
				}
				
			
		}catch (Exception e) {
			System.err.println("Erro inserir endereço "+e);	
		}
		return false;
		
	}
	
	public int primeiroEultimo(String tabela, String campo, int op) {
		int valor = 0;
		try {
			conexao = BancoConexao.open();
			if (op <= 0) {
				String sql = "SELECT MIN(" + campo + ") AS resultado FROM Endereco";
				resultSet = preparedStatement.executeQuery(sql);
			} else {
				String sql = "SELECT MAX(" + campo + ") AS resultado FROM Endereco";
				resultSet = preparedStatement.executeQuery(sql);
			}
			if (resultSet.next()) {
				valor = this.resultSet.getInt(1);
			}
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Não foi possivel realizar a pesquisar Firts/Last!\n" + e.getMessage());
		}
		return valor;
	}
	
	public String consultar(String chave, String valorChave, String campo) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM Endereco WHERE " + chave + " LIKE '%" + valorChave + "%'";
		try {
			conexao = BancoConexao.open();
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

	public boolean atualizar(String tabela, String chave, String valor, String query) {//sugestão mudar para boolean
		try {
			conexao = BancoConexao.open();
			
			String sql = "UPDATE Endereco SET " + query + " WHERE " + chave + " = '" + valor + "'";
			resultSet = preparedStatement.executeQuery(sql);
			
//			System.out.println(sql);
//			JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Atualização",
//	     				JOptionPane.INFORMATION_MESSAGE);
			
			resultSet.close();
			conexao.close();
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro: NÃ£o foi possivel atualizar!\n" + e.getMessage(),
					"AtualizaÃ§Ã£o", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}
