package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Curso;
import modelo.Disciplina;

public class BancoDisciplinaGerenciar {
	private Connection conexao;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private int curso;

	public boolean BancoDisciplinaInserir(Disciplina disciplina) {
		//aqui é o comando em sql que é necessário para inserir no banco de dados
		String sqlDisciplina = "INSERT INTO Disciplina(nomeDisciplina, areaDisciplina, semestre, cargaHoraria," + 
				"tipoDisciplina, optativaObrigatoria, teorica, estagio, pratica, preRequisito, Curso_idCurso ) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		/*
		 * String nome_Disciplina, String semestre, String area_Disciplina, String curso,
		 *	String tipoDisciplina, ArrayList<String> preRequisitos, String carga_Horaria, boolean ePreRequisito,
		 *	boolean optativa, boolean obrigatoria, boolean teorica, boolean pratica, boolean estagio
		 */
		curso = Integer.parseInt(new Banco().consultar("Curso", "nomeCurso", disciplina.getCurso(), "idCurso"));
		conexao = BancoConexao.open();
		
		try {
			preparedStatement = conexao.prepareStatement(sqlDisciplina);
			preparedStatement.setString(1, disciplina.getNome_Disciplina());
			preparedStatement.setString(2, disciplina.getArea_Disciplina());
			preparedStatement.setString(3, disciplina.getSemestre());
			preparedStatement.setString(4, disciplina.getCarga_Horaria());
			preparedStatement.setString(5, disciplina.getTipoDisciplina());
			if(disciplina.getOptativa() == true)
				preparedStatement.setString(6, "OPTATIVA");
			else if(disciplina.getObrigatoria() == true)
				preparedStatement.setString(6, "OBRIGATORIA");

			preparedStatement.setBoolean(7, disciplina.getTeorica());
			preparedStatement.setBoolean(8, disciplina.getEstagio());
			preparedStatement.setBoolean(9, disciplina.getPratica());
			preparedStatement.setBoolean(10, disciplina.getEPreRequisito());
			preparedStatement.setInt(11, curso);
			
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
	public String consultar(String tabela, String chave, String valorChave, String campo) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM " + tabela + " WHERE " + chave + " = " + valorChave;
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
	
	public boolean inserirPreRequisitos(int idDisciplina, int idPreRequisito){
		
		String sqlDisciplina = "INSERT INTO disciplina_tem_prerequisito(idDisciplina, idPreRequisito) VALUES(?, ?)";
		conexao = BancoConexao.open();
		
		try {
			preparedStatement = conexao.prepareStatement(sqlDisciplina);
			preparedStatement.setInt(1, idDisciplina);
			preparedStatement.setInt(2, idPreRequisito);
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
