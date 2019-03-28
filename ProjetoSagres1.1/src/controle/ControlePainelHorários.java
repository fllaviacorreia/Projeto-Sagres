package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.VisaoFramePrincipal;
import visao.VisaoPainelHorarios;

public class ControlePainelHorários implements ActionListener{

	static VisaoPainelHorarios visaoHorarios;
	static VisaoFramePrincipal framePrincipal;
	private String tipoCurso;
	private String nomeDisciplina;
	private Object [][] dados;
	public ControlePainelHorários(VisaoFramePrincipal framePrincipal, VisaoPainelHorarios visaoHorarios,
									String tipoCurso, String nomeDisciplina) {
		
		ControlePainelHorários.framePrincipal = framePrincipal;
		ControlePainelHorários.visaoHorarios = visaoHorarios;
		this.tipoCurso = tipoCurso;
		this.nomeDisciplina = nomeDisciplina;
		visaoHorarios.setVisible(true);
		visaoHorarios.getButtonVoltar().addActionListener(this);
		
	}
	
	public void adicionaHorarios() {
		if(tipoCurso == "MATUTINO") {
			dados = new Object[][] {
				{"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"},
				{"7:30", null, null, null, null, null, null},
				{"8:20", null, null, null, null, null, null},
				{"9:10", null, null, null, null, null, null},
				{"10:00", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo"},
				{"10:10", null, null, null, null, null, null},
				{"11:00", null, null, null, null, null, null},
				{"11:50", null, null, null, null, null, null},
				{"12:40", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas"},
			};
			
			for(int j = 1; j < 6; j++) {
				for(int i = 1; i < 8; i++) {
					if(dados[i][j] == null) {
						
					}
					
				}
			}
		}
		if(tipoCurso == "VESPERTINO") {
			
		}
		if(tipoCurso == "NOTURNO") {
			
		}
		if(tipoCurso == "INTEGRAL") {
			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == visaoHorarios.getButtonVoltar()) {
			ControlePainelCadastroClasse.troca();
		}
		
	}

}
