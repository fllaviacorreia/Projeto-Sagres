package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class VisaoFramePrincipal extends JFrame{

	Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
//	private static JFrame frame;
	
	public VisaoFramePrincipal(){
		new JFrame();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

	/*synchronized public static JFrame getInstance() {
		JFrame frame = null;
		if(frame == null) {
			frame = new FramePrincipal();
		}
		return frame;
	}*/
	
	public void trocarPainel(JPanel painel, String titulo) {
		this.setContentPane(painel);
		this.setTitle(titulo);
		
//		if(titulo == "Login") {
//			this.setSize(500, 500);
//			this.setResizable(false);
//			this.setLocation((display.width - this.getSize().width)/2 , 
//					(display.height - this.getSize().height)/2);
//		}
//		else {
			this.setMinimumSize(display);
			this.setMaximumSize(display);
			this.setLocation(0,0);
//		}
			
		repaint();
		validate();
	} 
}
