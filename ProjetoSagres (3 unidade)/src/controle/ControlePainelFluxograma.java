package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.VisaoFramePrincipal;
import visao.VisaoPainelFluxograma;

public class ControlePainelFluxograma implements ActionListener{

	static VisaoPainelFluxograma telaFluxograma;
	static VisaoFramePrincipal framePrincipal;
	
	public ControlePainelFluxograma(VisaoFramePrincipal framePrincipal, VisaoPainelFluxograma telaFluxograma) {
		this.framePrincipal = framePrincipal;
		this.telaFluxograma = telaFluxograma;
		telaFluxograma.setVisible(true);
		this.telaFluxograma.getButtonVoltar().addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaFluxograma.getButtonVoltar()) {
			try {
				ControlePainelCadastroCurso.troca();
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
	}

}
