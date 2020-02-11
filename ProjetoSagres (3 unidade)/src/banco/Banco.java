package banco;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * 
 * @author Ricardo Farias
 *
 */

public class Banco {

	private Connection conexao = null;
	private Statement consulta;
	public ResultSet resultado;
	public int result = 0;

	//Conex�es
	public Connection abrir(int op) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sge?useTimezone=true&serverTimezone=UTC";
			String user = "root";
			String password = "";
			conexao = DriverManager.getConnection(url, user, password);
			if (op == 1) {
				JOptionPane.showMessageDialog(null, "Conex�o realizada com sucesso!");
			}
		} catch (HeadlessException | ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: Conex�o n�o pode ser realizada!\n" + e.getMessage());
			e.printStackTrace();
		}
		return conexao;
	}

	public Connection fechar(int op) {
		try {
			conexao.close();
			if (op == 1) {
				JOptionPane.showMessageDialog(null, "Conex�o encerrada com sucesso!");
			}
		} catch (HeadlessException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: Conex�o n�o pode ser encerrada!\n" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public boolean testar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sysedu";
			conexao = DriverManager.getConnection(url, "root", "");
			conexao.close();
				JOptionPane.showMessageDialog(null, "Conex�o realizada com Sucesso!\n");
			return true;
		} catch (HeadlessException | ClassNotFoundException | SQLException e) {
	
				JOptionPane.showMessageDialog(null, "Erro: Conex�o n�o pode ser realizada!\n" + e.getMessage());
				e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet executar(String sql) {
		conexao = this.abrir(0);
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (!resultado.isBeforeFirst()) {
				// JOptionPane.showMessageDialog(null, "Não a registros com o parametro
				// informado!");

				return null;
			}
			// conexao = this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel executar a query SQL!\n" + e.getMessage());
		}
		return resultado;
	}

	public ResultSet executar(String sql, boolean showSqlCode) {
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		} /// exibe o codigo sql
		conexao = this.abrir(0);
		try {
			consulta = conexao.createStatement();

			resultado = consulta.executeQuery(sql);
			if (!resultado.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "N�o a registros com o parametro informado!");

				return null;

			}
			// conexao = this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel executar a query SQL!\n" + e.getMessage());
		}
		return resultado;
	}

	public void executarCustom(String sql) {
		conexao = this.abrir(0);
		try {
			consulta = conexao.createStatement();
			result = consulta.executeUpdate(sql);
			conexao = this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel executar a query SQL!\n" + e.getMessage());
		}
	}

	//Fun��es gerais
	public boolean inserir(String tabela, String campos, String valores) {//sugest�o mudar para booleans
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			String sql = "INSERT INTO " + tabela + "(" + campos + ") VALUES(" + valores + ");";
			consulta.execute(sql);
			//JOptionPane.showMessageDialog(null, "Inserido com sucesso!"); eu exibo as mensagens de confirma��o de inclus�o no controlador, se n�o se importa j� faz l�, a� n�o precisa tu alterar aqui...
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel inserir!\n" + e.getMessage());
			return false;
		}
		return true;
	}

	public void inserir(String tabela, String campos, String valores, boolean showSqlCode) {
		String sql = "INSERT INTO " + tabela + "(" + campos + ") VALUES(" + valores + ");";
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		}
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			consulta.execute(sql);
			JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel inserir!\n" + e.getMessage());
		}
	}

	public boolean excluir(String tabela, String chave, String valor) {//sugest�o mudar para boolean
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			String sql = "DELETE FROM " + tabela + " WHERE(" + chave + " = '" + valor + "');";
			consulta.execute(sql);
			//JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel excluir!\n" + e.getMessage());
			return false;
		}
		return true;
	}

	public void excluir(String tabela, String chave, String valor, boolean showSqlCode) {
		String sql = "DELETE FROM " + tabela + " WHERE(" + chave + " = '" + valor + "');";
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		} /// exibe o codigo sql
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			consulta.execute(sql);
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel excluir!\n" + e.getMessage());
		}
	}

	public boolean atualizar(String tabela, String chave, String valor, String query) {//sugest�o mudar para boolean
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			String sql = "UPDATE " + tabela + " SET " + query + " WHERE " + chave + " = '" + valor + "';";
			System.out.println(sql);
			consulta.execute(sql);

			//JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Atualiza��o",
	     	//			JOptionPane.INFORMATION_MESSAGE);
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro: Não foi possivel atualizar!\n" + e.getMessage(),
					"Atualização", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public void atualizar(String tabela, String chave, String valor, String query, boolean showSqlCode) {
		String sql = "UPDATE " + tabela + " SET " + query + " WHERE " + chave + " = '" + valor + "';";
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		} ///

		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			consulta.execute(sql);

			JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Atualiza��o",
					JOptionPane.INFORMATION_MESSAGE);
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel atualizar!\n" + e.getMessage(),
					"Atualização", JOptionPane.WARNING_MESSAGE);
		}
	}

	public String consultar(String tabela, String chave, String valorChave, String campo) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM " + tabela + " WHERE " + chave + " LIKE '%" + valorChave + "%'";
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (resultado.next()) {
				retorno = (String) resultado.getString(campo);
			}
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel consultar!\n" + e.getMessage());
		}
		return retorno;
	}

	public String consultar(String sql, String campo) {
		String retorno = "";

		// sql = "SELECT " + campo + " FROM " + tabela + " WHERE " + chave + " = '" +
		// valor + "'";
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (resultado.next()) {
				retorno = (String) resultado.getString(campo);
			}
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel consultar!\n" + e.getMessage());
		}
		return retorno;
	}

	public String consultar(String tabela, String chave, String valorChave, String campo, boolean showSqlCode) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM " + tabela + " WHERE " + chave + " = '" + valorChave + "'";
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		} /// exibe o codigo sql
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (resultado.next()) {
				retorno = (String) resultado.getString(campo);
			}
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel consultar!\n" + e.getMessage());
		}
		return retorno;
	}


	public ArrayList<String> consultarUmaColuna(String tabela, String coluna) {
		ArrayList<String> lista = new ArrayList<String>();
		String sql = "SELECT * FROM " + tabela;
		conexao = this.abrir(0);
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				lista.add(resultado.getString(coluna));
			}
			this.fechar(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public String consultarUmaColuna(String tabela, String campo, boolean showSqlCode) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM " + tabela + " WHERE 1";
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		} /// exibe o codigo sql
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (resultado.next()) {
				retorno = (String) resultado.getString(campo);
			}
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel consultar!\n" + e.getMessage());
		}
		return retorno;
	}

	
	public int contar(String tabela, String campo, String query) {
		int qtd = 0;
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT COUNT(" + campo + ")FROM " + tabela + " WHERE " + query);
			JOptionPane.showMessageDialog(null, "SELECT COUNT(" + campo + ")FROM " + tabela + " WHERE " + query);
			resultado.first();
			qtd = this.resultado.getInt("COUNT(" + campo + ")");
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel realizar a contagem!\n" + e.getMessage());
		}
		return qtd;
	}

	public int contar(String tabela) {
		int qtd = 0;
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT COUNT(*)FROM " + tabela);
			resultado.first();
			qtd = this.resultado.getInt("COUNT(*)");
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel realizar a contagem!\n" + e.getMessage());
		}
		return qtd;
	}

	public String primeiroEultimo(String tabela, String campo, int op) {
		String valor = "";
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			if (op <= 0) {
				resultado = consulta.executeQuery("SELECT MIN(" + campo + ") AS resultado FROM " + tabela);
			} else {
				resultado = consulta.executeQuery("SELECT MAX(" + campo + ") AS resultado FROM " + tabela);
			}
			if (resultado.next()) {
				valor = this.resultado.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("N�o foi possivel realizar a pesquisar Firts/Last!\n" + e.getMessage());
		}
		return valor;
	}

	
	//Fun��es Espec�ficas
	
//	public ArrayList<ModeloClientePessoaFisica> consultarClienteFisico() {
//		ArrayList<ModeloClientePessoaFisica> lista = new ArrayList<ModeloClientePessoaFisica>();
//		String sql = "SELECT * FROM cliente";
//		conexao = this.abrir(0);
//		try {
//			consulta = conexao.createStatement();
//			resultado = consulta.executeQuery(sql);
//			while (resultado.next()) {
//				ModeloClientePessoaFisica modeloClienteFisica = new ModeloClientePessoaFisica();
//				modeloClienteFisica.setCpf(resultado.getString("cpf"));
//				modeloClienteFisica.setNome(resultado.getString("nome"));
//				modeloClienteFisica.setSituacao(resultado.getString("situacao"));
//				modeloClienteFisica.setDataNascimento(resultado.getString("datanasc"));
//				modeloClienteFisica.setSexo(resultado.getString("sexo"));
//				modeloClienteFisica.setRg(resultado.getString("rg"));
//				modeloClienteFisica.setUfRg(resultado.getString("uf_rg"));
//				modeloClienteFisica.setOrgaoExpeditorRg(resultado.getString("orgaoexpedidor"));
//				modeloClienteFisica.setEmail(resultado.getString("email"));
//				modeloClienteFisica.setTelefone(resultado.getString("telefone"));
//				modeloClienteFisica.setLimiteCredito(resultado.getDouble("limitecredito"));
//				modeloClienteFisica.setId_endereco(resultado.getInt("ENDERECO_id"));
//				lista.add(modeloClienteFisica);
//			}
//			this.fechar(0);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//	}
//	
//	public ArrayList<ModeloClientePessoaJuridica> consultarClienteJuridico() {
//		ArrayList<ModeloClientePessoaJuridica> lista = new ArrayList<ModeloClientePessoaJuridica>();
//		String sql = "SELECT * FROM cliente";
//		conexao = this.abrir(0);
//		try {
//			consulta = conexao.createStatement();
//			resultado = consulta.executeQuery(sql);
//			while (resultado.next()) {
//				ModeloClientePessoaJuridica modeloClienteJuridica = new ModeloClientePessoaJuridica();
//				modeloClienteJuridica.setCnpj(resultado.getString("cnpj"));
//				modeloClienteJuridica.setRazaoSocial(resultado.getString("razaosocial"));
//				modeloClienteJuridica.setInscricaoEstadual(resultado.getString("inscricaoestadual"));
//				modeloClienteJuridica.setInscricaoEstadualUF(resultado.getString("uf_rg"));
//				modeloClienteJuridica.setRepresentante(resultado.getString("representante"));
//				modeloClienteJuridica.setSituacao(resultado.getString("situacao"));
//				modeloClienteJuridica.setEmail(resultado.getString("email"));
//				modeloClienteJuridica.setTelefone(resultado.getString("telefone"));
//				modeloClienteJuridica.setLimiteCredito(resultado.getDouble("limitecredito"));
//				modeloClienteJuridica.setId_endereco(resultado.getInt("ENDERECO_id"));
//				lista.add(modeloClienteJuridica);
//			}
//			this.fechar(0);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//	}
//	
//	public ArrayList<ModeloFornecedorFisica> consultarFornecedorFisico() {
//		ArrayList<ModeloFornecedorFisica> lista = new ArrayList<ModeloFornecedorFisica>();
//		String sql = "SELECT * FROM cliente";
//		conexao = this.abrir(0);
//		try {
//			consulta = conexao.createStatement();
//			resultado = consulta.executeQuery(sql);
//			while (resultado.next()) {
//				ModeloFornecedorFisica modeloFornecedorFisica = new ModeloFornecedorFisica();
//				modeloFornecedorFisica.setCpf(resultado.getString("cpf"));
//				modeloFornecedorFisica.setNome(resultado.getString("nome"));
//				modeloFornecedorFisica.setSituacao(resultado.getString("situacao"));
//				modeloFornecedorFisica.setDataNascimento(resultado.getString("datanasc"));
//				modeloFornecedorFisica.setSexo(resultado.getString("sexo"));
//				modeloFornecedorFisica.setRg(resultado.getString("rg"));
//				modeloFornecedorFisica.setUfRg(resultado.getString("uf_rg"));
//				modeloFornecedorFisica.setOrgaoExpeditorRg(resultado.getString("orgaoexpedidor"));
//				modeloFornecedorFisica.setEmail(resultado.getString("email"));
//				modeloFornecedorFisica.setTelefone(resultado.getString("telefone"));
//				modeloFornecedorFisica.setRamoAtividade(resultado.getString("ramoatividade"));
//				modeloFornecedorFisica.setFax(resultado.getString("fax"));
//				modeloFornecedorFisica.setId_endereco(resultado.getInt("ENDERECO_id"));
//				lista.add(modeloFornecedorFisica);
//			}
//			this.fechar(0);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//	}
//	
//	public ArrayList<EnderecoCadastro> consultarEndereco() {
//		ArrayList<EnderecoCadastro> lista = new ArrayList<EnderecoCadastro>();
//		String sql = "SELECT * FROM endereco";
//		conexao = this.abrir(0);
//		try {
//			consulta = conexao.createStatement();
//			resultado = consulta.executeQuery(sql);
//			while (resultado.next()) {
//				EnderecoCadastro modeloendereco = new EnderecoCadastro();
//				modeloendereco.setId_endereco(resultado.getInt("id"));
//				modeloendereco.setCep(resultado.getString("cep"));
//				modeloendereco.setNumeroEndereco(resultado.getString("numero"));
//				modeloendereco.setLogradouro(resultado.getString("logradouro"));
//				modeloendereco.setBairro(resultado.getString("bairro"));
//				modeloendereco.setComplemento(resultado.getString("complemento"));
//				modeloendereco.setCidade(resultado.getString("cidade"));
//				modeloendereco.setUf_estado(resultado.getString("uf"));
//				lista.add(modeloendereco);
//			}
//			this.fechar(0);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//	}
}