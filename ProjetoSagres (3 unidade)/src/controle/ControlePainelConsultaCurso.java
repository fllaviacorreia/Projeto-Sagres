package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.VisaoPainelConsultaCurso;

public class ControlePainelConsultaCurso implements ActionListener {
	int volta;
	static VisaoPainelConsultaCurso telaConsCurso;

	public ControlePainelConsultaCurso(VisaoPainelConsultaCurso telaConsCurso, int volta) {
		ControlePainelConsultaCurso.telaConsCurso = telaConsCurso;
		this.volta = volta;
		AddEventos();
	}

	public void AddEventos() {
		telaConsCurso.getButtonVoltar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaConsCurso.getButtonVoltar()) {
			int saida = JOptionPane.showConfirmDialog(telaConsCurso, "Deseja realmente voltar?", "Confirmação de saída",
					JOptionPane.YES_NO_OPTION);
			if (saida == 0) {
				if (volta == 1)
					ControlePainelTelaInicial.troca();
				else if (volta == 2)
					ControlePainelCadastro.troca();
				else
					ControlePainelConsulta.troca();
			}
		}

	}

}
