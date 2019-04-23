//package banco;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//import modelo.Aluno;
//
//public class BancoAlunoGerenciar{
//	
//	Connection conexao = null;
//	PreparedStatement preparetedStatement = null;
//	ResultSet resultSet = null;
//	
//	public boolean BancoAlunoInserir(Aluno aluno, int endereco, int curso) {
//		
//	//aqui � o comando em sqlque � necess�rio para inserir no banco de dados
//		String sql1 = "INSERT INTO Aluno(nomeAluno, numMatricula, cpf, rg, ufRg, OrgaoExpeditorRg, dataExpedicaoRg, "
//				+ "dataNascimento, Endereco_idEndereco, Curso_idCurso) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		
//	//fazendo a conex�o com o banco de dados	
//		conexao = BancoConexao.conector();
//
//		try {
//		//aqui � lincando o comanco com o banco	
//			preparetedStatement = conexao.prepareStatement(sql1);
//			
//		//salvando na table os dados	
//			preparetedStatement.setString(1, aluno.getNome());
//			preparetedStatement.setString(2, aluno.getMatricula());
//			preparetedStatement.setString(3, aluno.getCpf());
//			preparetedStatement.setString(4, aluno.getRg());
//			preparetedStatement.setString(5, aluno.getUf());
//			preparetedStatement.setString(6, aluno.getOrgaoExp());
//			preparetedStatement.setString(7, aluno.getDataExpedicao());
//			preparetedStatement.setString(8, aluno.getDataNascimento());
//			
//		//primeiro o endere�o � salvo e depois o id gerado de endere�o � jogado aqui
//		// o mesmo acontece com curso, a diferen�a � que vai buscar o curso no banco
//			preparetedStatement.setInt(9, endereco);
//			preparetedStatement.setInt(10, curso);
//			
//			System.out.println(preparetedStatement);
//			int teste = preparetedStatement.executeUpdate();
//
//			if(teste > 0) {
//					//System.out.println("Inserir1");
//				return true;
//			}
//			conexao.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//				System.out.println("Erro inserir1"+e);	
//		}
//		
//		return false;		
//	}
//
//}
