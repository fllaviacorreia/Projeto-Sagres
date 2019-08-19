package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import banco.BancoCursoGerenciar;
import visao.VisaoFramePrincipal;
import visao.VisaoPainelConsultaCurso;
import visao.VisaoPainelFluxograma;

public class ControlePainelConsultaCurso implements ActionListener {
	int volta;
	private static VisaoPainelFluxograma telaFluxograma;
	private static VisaoPainelConsultaCurso telaConsCurso;
	private static VisaoFramePrincipal framePrincipal;
	
	public ControlePainelConsultaCurso(VisaoFramePrincipal framePrincipal, VisaoPainelConsultaCurso telaConsCurso, int volta) {
		ControlePainelConsultaCurso.telaConsCurso = telaConsCurso;
		ControlePainelConsultaCurso.framePrincipal = framePrincipal;
		this.volta = volta;
		AddEventos();
		preenche();
	}

	public void AddEventos() {
		telaConsCurso.getButtonVoltar().addActionListener(this);
		telaConsCurso.getButtonGerarFluxograma().addActionListener(this);
	}
	public static void troca() {
		framePrincipal.trocarPainel(telaConsCurso, "Página de Consultas de Cursos");
		telaFluxograma = null;
	}

	public void preenche() {
		telaConsCurso.getComboBoxCursos().addItem("SELECIONE");
		try {	
			ArrayList<String> disc = new BancoCursoGerenciar().consultarUmaColuna("Curso", "nomeCurso");
			for (int i = 0; i < disc.size(); i++) {
				telaConsCurso.getComboBoxCursos().addItem(disc.get(i).toString());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
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
		
		if(e.getSource() == telaConsCurso.getButtonGerarFluxograma()) {
			if(telaConsCurso.getComboBoxCursos().getSelectedItem().equals("SELECIONE"))
				JOptionPane.showMessageDialog(telaConsCurso, "Necessário selecionar um curso", 
						"Aviso",JOptionPane.INFORMATION_MESSAGE);
			
			else {
				String nome = telaConsCurso.getComboBoxCursos().getSelectedItem().toString();
				System.out.println("nome " + nome);
				String tipoCurso = new BancoCursoGerenciar().consultar("nomeCurso", nome, "tipoCurso");
	
				String cargaHorariaTotal = new BancoCursoGerenciar().consultar("nomeCurso", nome, "cargaHorariaTotal");
				if(telaFluxograma == null) {
					telaFluxograma = new VisaoPainelFluxograma(nome, tipoCurso, cargaHorariaTotal);
				}
				framePrincipal.trocarPainel(telaFluxograma, "Fluxograma");
				new ControlePainelFluxograma(framePrincipal, telaFluxograma, nome);
			}
		}

	}
	
	

}
