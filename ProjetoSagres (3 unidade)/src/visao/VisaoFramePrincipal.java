package visao;

import java.awt.Color;

/**
 *  @author Fl�via de Jesus Correia
 * 
 * */

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VisaoFramePrincipal extends JFrame {
	Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
	public VisaoFramePrincipal() {
		new JFrame();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(8, 42, 108));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

	}

	public void trocarPainel(JPanel painel, String titulo) {
		this.setContentPane(painel);
		this.setTitle(titulo);
		this.setContentPane(painel);
		this.setTitle(titulo);
		this.setSize(display.width, display.height - 40);
		this.setLocation(0, 0);
		this.repaint();
		this.validate();
	}
}
