package visao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controle.ControlePainelTelaInicial;
import controle.ControlePainelTelaLogin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VisaoPainelTelaLogin extends JPanel {
	private JLabel labelLogoSistema;
	private Icon imagemSistema;
	private JTextField textFieldLogin;
	private JLabel labelLogin;
	private JLabel labelSenha;
	private JLabel labelEsqueceuSuaSenha;
	private JButton buttonEntrar;
	private JPasswordField passWordFieldfSenha;
	static VisaoFramePrincipal frame;
	static VisaoPainelTelaInicial telaInicial;
	Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
	public VisaoPainelTelaLogin() {
		this.setLayout(null);
		this.setBackground(new Color(17, 109, 112));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setLocation((display.width - this.getSize().width)/2 , 
				(display.height - this.getSize().height)/2);
		this.setVisible(true);

		add(getTextFieldLogin());
		add(getPassWordFieldSenha());
		add(getButtonEntrar());
		
		labelLogin = new JLabel("Login: ");
		labelLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		labelLogin.setBounds(573, 449, 60, 28);
		labelLogin.setForeground(new Color(255, 255, 224));
		add(labelLogin);
		
		labelSenha = new JLabel("Senha: ");
		labelSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		labelSenha.setBounds(565, 484, 68, 28);
		labelSenha.setForeground(new Color(255, 255, 224));
		add(labelSenha);
		
		imagemSistema = new ImageIcon("logoTipoSoftware1.png");
		labelLogoSistema = new JLabel( imagemSistema);
	//	labelLogoSistema.setText("EducaSoft");
		labelLogoSistema.setFont(new Font("Arial", Font.PLAIN, 13));
		labelLogoSistema.setBounds(428, 48, 520, 520);
		add(labelLogoSistema);
		
	}

	
	public JTextField getTextFieldLogin() {
		if(textFieldLogin == null) {
			textFieldLogin = new JTextField();
			textFieldLogin.setFont(new Font("Arial", Font.PLAIN, 15));
			textFieldLogin.setBounds(631, 453, 176, 20);
			textFieldLogin.setColumns(10);
			textFieldLogin.setForeground(Color.BLACK);
		}
		return textFieldLogin;
	}

	public JPasswordField getPassWordFieldSenha() {
		if(passWordFieldfSenha == null) {
			passWordFieldfSenha = new JPasswordField();
			passWordFieldfSenha.setFont(new Font("Arial", Font.PLAIN, 15));
			passWordFieldfSenha.setBounds(631, 488, 176, 20);
			passWordFieldfSenha.setForeground(Color.BLACK);
			System.out.println("getPassWord");
			

		}
//		passWordFieldfSenha.addKeyListener(new java.awt.event.KeyListener() {
//            public void keyPressed(java.awt.event.KeyEvent evt) {
//            	System.out.println("KeyListenergetPassWord");
//               if (evt.getKeyCode() == KeyEvent.VK_ENTER){
//            	   System.out.println("KeyEvtgetPassWord");
//            	   if(textFieldLogin.equals("admin") && 
//            			   (String.valueOf(getPassWordFieldSenha()).equals("admin"))) {
//            		   System.out.println("If Validacao Login e PassWord");
//            		   	getTextFieldLogin().setText("");
//       					getPassWordFieldSenha().setText("");
//       					System.out.println("SetPassWord");
//       					if(telaInicial == null)
//       						telaInicial = new VisaoPainelTelaInicial();
//       					frame.trocarPainel(telaInicial, "PáginaInicial");
//       					new ControlePainelTelaInicial(frame, telaInicial);
//               }else if(getTextFieldLogin().getText().equals("") || (String.valueOf(getPassWordFieldSenha()).equals(""))){
//   				JOptionPane.showMessageDialog(null, "Campos de login e senha devem ser preenchidos.", "Aviso", JOptionPane.ERROR_MESSAGE);
//   			}else {
//   				JOptionPane.showMessageDialog(null, "Login e/ou senha não coincidem com o banco de dados.", "Aviso", JOptionPane.ERROR_MESSAGE);
//   			}
//            }
//            }
//
//			
//
//			@Override
//			public void keyReleased(KeyEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//        });
		return passWordFieldfSenha;
	}

	public JButton getButtonEntrar() {
		if(buttonEntrar == null) {
			buttonEntrar = new JButton("Entrar");
			buttonEntrar.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonEntrar.setBounds(643, 533, 86, 23);
			buttonEntrar.setBackground(Color.WHITE);
			buttonEntrar.setForeground(Color.BLACK);
		}
		return buttonEntrar;
	}
}
