package banco;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import com.mysql.*;


public class BancoConexao {
	
	
	public static Connection open() {
		java.sql.Connection conexao = null;
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
	
	
}
