package banco;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Aluno;

public class BancoAlunoGerenciar{
	Banco banco = new Banco();
	Connection conexao = null;
	PreparedStatement preparetedStatement = null;
	ResultSet resultSet = null;
	
	public boolean BancoAlunoInserir(Aluno aluno) {
		int endereco;
		int curso;
	//aqui é o comando em sql que é necessário para inserir no banco de dados
		String sqlAluno = "INSERT INTO Aluno(nomeAluno, numMatricula, dataNascimento, email, telefone, celular"
				+ "cpf, rg, ufRg, OrgaoExpeditorRg, dataExpedicaoRg, Endereco_idEndereco, Curso_idCurso) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
	//fazendo a conexão com o banco de dados	
		conexao = BancoConexao.open();
		try {
			endereco = Integer.parseInt(banco.primeiroEultimo("Endereco", "id", 1));
			curso = Integer.parseInt(banco.consultar("Curso", "nomeCurso", aluno.getCurso(), "id")); 
		//aqui é lincando o comando com o banco	em aluno
			preparetedStatement = conexao.prepareStatement(sqlAluno);
			
		//salvando na table os dados	
			preparetedStatement.setString(1, aluno.getNome());
			preparetedStatement.setString(2, aluno.getMatricula());
			preparetedStatement.setString(3, aluno.getDataNascimento());
			preparetedStatement.setString(4, aluno.getEmail());
			preparetedStatement.setString(5, aluno.getCpf());
			preparetedStatement.setString(6, aluno.getRg());
			preparetedStatement.setString(7, aluno.getUf());
			preparetedStatement.setString(8, aluno.getOrgaoExp());
			preparetedStatement.setString(9, aluno.getDataExpedicao());
			
		//primeiro o endereço é salvo e depois o id gerado de endereço é jogado aqui
		// o mesmo acontece com curso, a diferença é que vai buscar o curso no banco
			preparetedStatement.setInt(9, endereco);
			preparetedStatement.setInt(10, curso);
			
			System.out.println(preparetedStatement);
			int teste = preparetedStatement.executeUpdate();

			if(teste > 0) {
					//System.out.println("Inserir1");
				return true;
			}
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
				System.err.println("Erro inserir aluno "+e);	
		}
		
		return false;		
	}
	
	public boolean BancoAlunoExcluir(String numMatricula) {//sugestão mudar para boolean
		try {
			conexao = BancoConexao.open();
			String sql = "DELETE FROM Aluno  WHERE( numMatricula = " + numMatricula + "')";
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
				resultSet = preparetedStatement.executeQuery(sql);
			} else {
				String sql = "SELECT MAX(" + campo + ") AS resultado FROM " + tabela;
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
	
	public String consultar(String chave, String valorChave, String campo) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM Aluno WHERE " + chave + " LIKE '%" + valorChave + "%'";
		try {
			conexao = BancoConexao.open();
			resultSet = preparetedStatement.executeQuery(sql);
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
			
			String sql = "UPDATE Aluno SET " + query + " WHERE " + chave + " = '" + valor + "'";
			resultSet = preparetedStatement.executeQuery(sql);
			
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
