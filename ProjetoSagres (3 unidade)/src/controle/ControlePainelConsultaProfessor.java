package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.VisaoPainelConsultaProfessor;

public class ControlePainelConsultaProfessor implements ActionListener {
	int volta;
	static VisaoPainelConsultaProfessor telaConsProfessor;

	public ControlePainelConsultaProfessor(VisaoPainelConsultaProfessor telaConsProfessor, int volta) {
		ControlePainelConsultaProfessor.telaConsProfessor = telaConsProfessor;
		this.volta = volta;
		AddEventos();
	}

	public void AddEventos() {
		telaConsProfessor.getButtonVoltar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaConsProfessor.getButtonVoltar()) {
			int saida = JOptionPane.showConfirmDialog(telaConsProfessor, "Deseja realmente voltar?",
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
