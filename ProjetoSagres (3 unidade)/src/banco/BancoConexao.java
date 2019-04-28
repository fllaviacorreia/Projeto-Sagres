package banco;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import com.mysql.*;


public class BancoConexao {
	static java.sql.Connection conexao = null;
	
	public static Connection open() {
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sagres?useTimezone=true&serverTimezone=UTC";
		conexao = DriverManager.getConnection(url, "root", "");
		
		} catch (HeadlessException  e) {
			JOptionPane.showMessageDialog(null, "Erro: Conexão não pode ser realizada!\n" + e.getMessage());
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro: Conexão não pode ser realizada!\n" + e.getMessage());
			e.printStackTrace();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: Conexão não pode ser realizada!\n" + e.getMessage());
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	public static Connection close(int op) {
		try {
			conexao.close();
			if (op == 1) {
				JOptionPane.showMessageDialog(null, "Conexão encerrada com sucesso!");
			}
		} catch (HeadlessException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: Conexão não pode ser encerrada!\n" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
