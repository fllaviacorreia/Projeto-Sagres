package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					//System.out.println("Inserir1");
				return true;
			}
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
				System.out.println("Erro inserir1"+e);	
		}
		
		return false;		
	}

}
