package banco;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Curso;
import modelo.Professor;
import com.mysql.*;

public class BancoCursoGerenciar {
//	Banco banco = new Banco();
	Connection conexao = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
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
					return true;
				}
				conexao.close();
			} catch (Exception e) {
				
				System.err.println("Erro inserir curso "+e);	
			}								
		
			return false;
	}
}
	