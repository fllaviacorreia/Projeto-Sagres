package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.VisaoPainelConsultaClasse;

public class ControlePainelConsultaClasse implements ActionListener {
	int volta;
	static VisaoPainelConsultaClasse telaConsClasse;

	public ControlePainelConsultaClasse(VisaoPainelConsultaClasse telaConsClasse, int volta) {
		ControlePainelConsultaClasse.telaConsClasse = telaConsClasse;
		this.volta = volta;
		AddEventos();
	}

	public void AddEventos() {
		telaConsClasse.getButtonVoltar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaConsClasse.getButtonVoltar()) {
			int saida = JOptionPane.showConfirmDialog(telaConsClasse, "Deseja realmente voltar?",
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
