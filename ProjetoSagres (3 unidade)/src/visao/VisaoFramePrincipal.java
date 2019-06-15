package visao;

import java.awt.Color;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VisaoFramePrincipal extends JFrame {
	Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
	public VisaoFramePrincipal() {
		new JFrame();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(8, 42, 108));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this.setResizable(false);

	}

	/*
	 * synchronized public static JFrame getInstance() { JFrame frame = null;
	 * if(frame == null) { frame = new FramePrincipal(); } return frame; }
	 */

	public void trocarPainel(JPanel painel, String titulo) {
		this.setContentPane(painel);
		this.setTitle(titulo);
		setContentPane(painel);
		setTitle(titulo);
//		setMinimumSize(new Dimension(display.width, display.height - 2));
//		setMaximumSize(new Dimension(display));
		setLocation(0, 0);
		repaint();
		setSize(1300, 730);
		validate();
		setLocation((display.width - this.getSize().width) / 2, 0);

		repaint();
		validate();
	}
}
