package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.VisaoFramePrincipal;
import visao.VisaoPainelTelaInicial;
import visao.VisaoPainelTelaLogin;

public class ControlePainelTelaLogin implements ActionListener{
	static VisaoPainelTelaLogin telaLogin;
	static VisaoFramePrincipal framePrincipal;
	static VisaoPainelTelaInicial telaInicial;
	
	public ControlePainelTelaLogin(){
		inicializa();
		AdcEventos();
		System.out.println("Login");
	}
	
	public void inicializa() {
		framePrincipal = new VisaoFramePrincipal();
		telaLogin = new VisaoPainelTelaLogin();
		troca();
	}
	public static void troca() {
		telaLogin.setVisible(true);
		framePrincipal.trocarPainel(telaLogin, "Login");
		
	}
	
	public void AdcEventos() {
		telaLogin.getButtonEntrar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaLogin.getButtonEntrar()) {
			if (telaLogin.getTextFieldLogin().getText().equals("admin") && (String.valueOf(telaLogin.getPassWordFieldSenha().getPassword()).equals("admin"))) {
				if(telaInicial == null) {
					telaInicial = new VisaoPainelTelaInicial();
				}
				telaLogin.getTextFieldLogin().setText("");
				telaLogin.getPassWordFieldSenha().setText("");
				framePrincipal.trocarPainel(telaInicial, "Página Inicial");
				new ControlePainelTelaInicial(framePrincipal, telaInicial);

			}
			else if(telaLogin.getTextFieldLogin().getText().equals("") || (String.valueOf(telaLogin.getPassWordFieldSenha().getPassword()).equals(""))){
				JOptionPane.showMessageDialog(telaLogin, "Campos de login e senha devem ser preenchidos.", "Aviso", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(telaLogin, "Login e/ou senha não coincidem com o banco de dados.", "Aviso", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
