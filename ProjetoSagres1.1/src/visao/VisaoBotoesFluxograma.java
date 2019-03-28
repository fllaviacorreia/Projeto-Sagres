package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import javax.swing.SwingConstants;

public class VisaoBotoesFluxograma extends JButton {
	private static final long serialVersionUID = 1L;

	public VisaoBotoesFluxograma(String nome, int carga, boolean ePre, boolean temPre, int x, int y) {
		if(carga>0) {
			this.setText(nome+"\n"+carga);
			if(ePre == false && temPre == false)
				this.setBackground(new Color(102, 205, 170)); // verde, sem pré e n é pre-requisito
			else if(ePre == false && temPre == true)
				this.setBackground(new Color(255, 255, 102)); //amarelo, tem pré e n é pré-requisito
			else if(ePre == true && temPre == false)
				this.setBackground(new Color(255, 204, 102)); //laranja, sem pré e é pre-requisito
			else
				this.setBackground(new Color(255, 102, 102)); //vermelho, tem pré e é pre-requisito
		}
		
		else {
			this.setText(nome);
			this.setBackground(Color.WHITE);
		}
		
		this.setVerticalAlignment(SwingConstants.BOTTOM);
		this.setHorizontalAlignment(SwingConstants.LEADING);
		this.setForeground(Color.BLACK);
		this.setFont(new Font("Arial", Font.PLAIN, 14));
		this.setBounds(x, y, 70, 50);
		
		
	}
	
}
