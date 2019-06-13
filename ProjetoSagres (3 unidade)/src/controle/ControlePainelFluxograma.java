package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.VisaoFramePrincipal;
import visao.VisaoPainelFluxograma;

public class ControlePainelFluxograma implements ActionListener {

	static VisaoPainelFluxograma telaFluxograma;
	static VisaoFramePrincipal framePrincipal;
	String nomeCurso;
	public ControlePainelFluxograma(VisaoFramePrincipal framePrincipal, VisaoPainelFluxograma telaFluxograma, String nomeCurso) {
		ControlePainelFluxograma.framePrincipal = framePrincipal;
		ControlePainelFluxograma.telaFluxograma = telaFluxograma;
		this.nomeCurso = nomeCurso;
		telaFluxograma.setVisible(true);
		pegaBotoes();
		ControlePainelFluxograma.telaFluxograma.getButtonVoltar().addActionListener(this);
	}
	
	public void pegaBotoes() {
		int i = 0;
		int x = 87, y = 186;
		int quantidadeSemestres;
		while(!Main.curso.get(i).getNome().equals(nomeCurso)) {
			i++;
		}
			
		quantidadeSemestres = Integer.parseInt(Main.curso.get(i).getSemestres());
		for(i = 1; i <= quantidadeSemestres; i++) {
			telaFluxograma.getBotoes().add(telaFluxograma.BotoesFluxograma(i + "º Semestre", 0, false, false, x, y));
			for(int j = 0; j < Main.disciplina.size(); j++) {
				if(Main.disciplina.get(j).getCurso().equals(nomeCurso)) {
					if(Main.disciplina.get(j).getSemestre().equals(String.valueOf(i))) {
						if(i == 1) { // para disciplinas de primeiro semestre
							telaFluxograma.getBotoes().add(telaFluxograma.BotoesFluxograma(
									Main.disciplina.get(j).getNome_Disciplina(),
									Integer.parseInt(Main.disciplina.get(j).getCarga_Horaria()), 
									Main.disciplina.get(j).getEPreRequisito(), 
									false, telaFluxograma.getBotoes().get(telaFluxograma.getBotoes().size() -1).getX() + 156, y));
						}else { //para disciplinas de outros semestres
								if(Main.disciplina.get(j).getPreRequisitos().size() > 0) {
									telaFluxograma.getBotoes().add(telaFluxograma.BotoesFluxograma(
											Main.disciplina.get(j).getNome_Disciplina(),
											Integer.parseInt(Main.disciplina.get(j).getCarga_Horaria()), 
											Main.disciplina.get(j).getEPreRequisito(), 
											true,  telaFluxograma.getBotoes().get(telaFluxograma.getBotoes().size() -1).getX() + 156, y));
								}else {
									telaFluxograma.getBotoes().add(telaFluxograma.BotoesFluxograma(
											Main.disciplina.get(j).getNome_Disciplina(),
											Integer.parseInt(Main.disciplina.get(j).getCarga_Horaria()), 
											Main.disciplina.get(j).getEPreRequisito(), 
											false,  telaFluxograma.getBotoes().get(telaFluxograma.getBotoes().size() -1).getX() + 156, y));
								}
							
						}
						
						
						
					}
				}
			}
			
			y = y + 70;
		}
		
		for(i = 0; i < telaFluxograma.getBotoes().size(); i++) {
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
