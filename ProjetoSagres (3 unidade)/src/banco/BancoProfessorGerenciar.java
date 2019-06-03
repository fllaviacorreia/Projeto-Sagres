package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import modelo.Professor;

public class BancoProfessorGerenciar {
	Banco banco = new Banco();
	Connection conexao = null;
	PreparedStatement preparetedStatement = null;
	ResultSet resultSet = null;
	
	public boolean BancoProfessorInserir(Professor professor) {
		int endereco;
		
	//aqui é o comando em sql que é necessário para inserir no banco de dados
		String sqlProfessor = "INSERT INTO Professor(nomeProfessor, dataNascimento, numMatricula, email, telefone, celular"
				+ "cpf, rg, ufRg, OrgaoExpeditorRg, dataExpedicaoRg, Endereco_idEndereco, Curso_idCurso) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
	//fazendo a conexão com o banco de dados	
		conexao = BancoConexao.open();
		try {
			endereco = Integer.parseInt(banco.primeiroEultimo("endereco", "id", 1));
		//aqui é lincando o comando com o banco	em aluno
			preparetedStatement = conexao.prepareStatement(sqlProfessor);
			
		//salvando na table os dados	
			preparetedStatement.setString(1, professor.getNome());
			preparetedStatement.setString(2, professor.getMatricula());
			preparetedStatement.setString(4, professor.getEmail());
			preparetedStatement.setString(5, professor.getCpf());
			preparetedStatement.setString(6, professor.getRg());
			preparetedStatement.setString(7, professor.getUf());
			preparetedStatement.setString(8, professor.getOrgaoExp());
			preparetedStatement.setString(9, professor.getDataExpedicao());
			
		//primeiro o endereço é salvo e depois o id gerado de endereço é jogado aqui
		// o mesmo acontece com curso, a diferença é que vai buscar o curso no banco
			preparetedStatement.setInt(9, endereco);
			
			System.out.println(preparetedStatement);
			int teste = preparetedStatement.executeUpdate();

			if(teste > 0) {
				preparetedStatement.close();
				conexao.close();
				return true;
			}
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
				System.out.println("Erro inserir1"+e);	
		}
		
		return false;		
	}
	
	public boolean BancoProfessorExcluir(String numMatricula) {//sugestão mudar para boolean
		try {
			conexao = BancoConexao.open();
			String sql = "DELETE FROM Professor  WHERE( numMatricula = '" + numMatricula + "')";
			preparetedStatement = conexao.prepareStatement(sql);
			int teste = preparetedStatement.executeUpdate(sql);
			if(teste > 0) {
				return true;
			}
			conexao.close();
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro: Não foi possível excluir!\n" + e.getMessage());
			return false;
		}
		return true;
	}
	
	public int primeiroEultimo(String tabela, String campo, int op) {
		int valor = 0;
		try {
			conexao = BancoConexao.open();
			if (op <= 0) {
				String sql = "SELECT MIN(" + campo + ") AS resultado FROM " + tabela;
				preparetedStatement = conexao.prepareStatement(sql);
				resultSet = preparetedStatement.executeQuery(sql);
			} else {
				String sql = "SELECT MAX(" + campo + ") AS resultado FROM " + tabela;
				preparetedStatement = conexao.prepareStatement(sql);
				resultSet = preparetedStatement.executeQuery(sql);
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
	
	public String consultar(String tabela, String chave, String valorChave, String campo) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM " + tabela + " WHERE " + chave + " LIKE '%" + valorChave + "%'";
		try {
			conexao = BancoConexao.open();
			preparetedStatement = conexao.prepareStatement(sql);
			resultSet = preparetedStatement.executeQuery(sql);
			if (resultSet.next()) {
				retorno = (String) resultSet.getString(campo);
			}
			preparetedStatement.close();
			resultSet.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro: Não foi possível consultar!\n" + e.getMessage());
		}
		return retorno;
	}
	
	public ArrayList<String> consultarUmaColuna(String tabela, String coluna) {
		ArrayList<String> lista = new ArrayList<String>();
		String sql = "SELECT * FROM " + tabela;
		
		try {
			conexao = BancoConexao.open();
			preparetedStatement = conexao.prepareStatement(sql);
			resultSet = preparetedStatement.executeQuery(sql);
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
