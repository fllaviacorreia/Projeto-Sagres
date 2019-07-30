package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.VisaoPainelConsultaDisciplina;

public class ControlePainelConsultaDisciplina implements ActionListener {
	int volta;
	static VisaoPainelConsultaDisciplina telaConsDisciplina;

	public ControlePainelConsultaDisciplina(VisaoPainelConsultaDisciplina telaConsDisciplina, int volta) {
		ControlePainelConsultaDisciplina.telaConsDisciplina = telaConsDisciplina;
		this.volta = volta;
		AddEventos();
	}

	public void AddEventos() {
		telaConsDisciplina.getButtonVoltar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaConsDisciplina.getButtonVoltar()) {
			int saida = JOptionPane.showConfirmDialog(telaConsDisciplina, "Deseja realmente voltar?",
					"Confirmação de saída", JOptionPane.YES_NO_OPTION);
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
