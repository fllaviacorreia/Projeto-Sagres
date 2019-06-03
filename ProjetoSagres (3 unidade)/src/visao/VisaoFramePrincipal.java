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
 //       this.setResizable(false);
        
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
		setContentPane(painel);
		setTitle(titulo);
//		setMinimumSize(new Dimension(display.width, display.height - 2));
//		setMaximumSize(new Dimension(display));
		setLocation(0,0);
		repaint();
		setSize( 1011, 730 );
		validate();
		setLocation((display.width - this.getSize().width)/2 , 0);
		

			
		repaint();
		validate();
	} 
}
