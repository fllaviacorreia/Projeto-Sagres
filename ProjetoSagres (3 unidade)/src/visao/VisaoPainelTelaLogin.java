package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class VisaoPainelTelaLogin extends JPanel {
	private JLabel 			labelLogoSistema    = null;
	private JLabel 			labelLogin    		= null;
	private JLabel 			labelSenha   		= null;
	private ImageIcon 		imagemSistema    	= null;
	private JTextField 		textFieldLogin   	= null;
	private JPasswordField  passWordFieldfSenha = null;
	private JButton 		buttonEntrar   	 	= null;

	public VisaoPainelTelaLogin() {
		this.setBackground(new Color(17, 109, 112));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);

		labelLogin = new JLabel("Login: ");
		labelLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		labelLogin.setForeground(new Color(255, 255, 224));

		labelSenha = new JLabel("Senha: ");
		labelSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		labelSenha.setForeground(new Color(255, 255, 224));

		imagemSistema = new ImageIcon("imagens/logoTipoSoftware.png");
		imagemSistema.setImage(imagemSistema.getImage().getScaledInstance(300, 250, 200));
		labelLogoSistema = new JLabel(imagemSistema);
		labelLogoSistema.setFont(new Font("Arial", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(27)
						.addComponent(labelLogoSistema, GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE).addGap(67)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(labelSenha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(3))
								.addComponent(labelLogin, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup()
										.addGap(94)
										.addComponent(getButtonEntrar(), GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(getTextFieldLogin(), GroupLayout.PREFERRED_SIZE, 164,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
												.addComponent(getPassWordFieldSenha(), GroupLayout.PREFERRED_SIZE, 165,
														GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGap(173)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGap(399)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
										.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getTextFieldLogin(), GroupLayout.DEFAULT_SIZE, 24,
												Short.MAX_VALUE)
										.addGap(19).addComponent(getPassWordFieldSenha()))
										.addGroup(groupLayout.createSequentialGroup().addGap(2)
												.addComponent(labelLogin, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
												.addGap(18).addComponent(labelSenha)))
								.addGap(19)
								.addComponent(getButtonEntrar(), GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addGap(172))
						.addGroup(groupLayout.createSequentialGroup().addGap(158).addComponent(labelLogoSistema,
								GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)))
				.addContainerGap()));
		setLayout(groupLayout);

	}

	public JTextField getTextFieldLogin() {
		if (textFieldLogin == null) {
			textFieldLogin = new JTextField();
			textFieldLogin.setFont(new Font("Arial", Font.PLAIN, 15));
			textFieldLogin.setColumns(10);
			textFieldLogin.setForeground(Color.BLACK);
		}
		return textFieldLogin;
	}

	public JPasswordField getPassWordFieldSenha() {
		if (passWordFieldfSenha == null) {
			passWordFieldfSenha = new JPasswordField();
			passWordFieldfSenha.setFont(new Font("Arial", Font.PLAIN, 15));
			passWordFieldfSenha.setForeground(Color.BLACK);
		}
		return passWordFieldfSenha;
	}

	public JButton getButtonEntrar() {
		if (buttonEntrar == null) {
			buttonEntrar = new JButton("Entrar");
			buttonEntrar.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonEntrar.setBackground(Color.WHITE);
			buttonEntrar.setForeground(Color.BLACK);
		}
		return buttonEntrar;
	}
}
