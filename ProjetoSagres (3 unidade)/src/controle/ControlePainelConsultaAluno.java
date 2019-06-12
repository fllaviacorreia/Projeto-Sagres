package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.ModeloTabela;
import visao.VisaoPainelConsultaAluno;

public class ControlePainelConsultaAluno implements ActionListener {
	int volta;
	static VisaoPainelConsultaAluno telaConsAluno;

	public ControlePainelConsultaAluno(VisaoPainelConsultaAluno telaConsAluno, int volta) {
		ControlePainelConsultaAluno.telaConsAluno = telaConsAluno;
		this.volta = volta;
		AddEventos();
	}

	public void AddEventos() {
		telaConsAluno.getButtonVoltar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaConsAluno.getButtonVoltar()) {
			int saida = JOptionPane.showConfirmDialog(telaConsAluno, "Deseja realmente voltar?", "Confirmação de saída",
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
