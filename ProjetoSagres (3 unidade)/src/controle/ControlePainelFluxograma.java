package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.VisaoFramePrincipal;
import visao.VisaoPainelFluxograma;

public class ControlePainelFluxograma implements ActionListener {

	static VisaoPainelFluxograma telaFluxograma;
	static VisaoFramePrincipal framePrincipal;

	public ControlePainelFluxograma(VisaoFramePrincipal framePrincipal, VisaoPainelFluxograma telaFluxograma) {
		ControlePainelFluxograma.framePrincipal = framePrincipal;
		ControlePainelFluxograma.telaFluxograma = telaFluxograma;
		telaFluxograma.setVisible(true);
		pegaBotoes();
		ControlePainelFluxograma.telaFluxograma.getButtonVoltar().addActionListener(this);
	}
	
	public void pegaBotoes() {
	
		for(int i = 0; i < 10; i++) {
			int x = i * 70;
			telaFluxograma.getBotoes().add(telaFluxograma.BotoesFluxograma("LP 1", 70, false, true, x, 10));
			telaFluxograma.add(telaFluxograma.getBotoes().get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaFluxograma.getButtonVoltar()) {
			try {
				
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

	}

}
