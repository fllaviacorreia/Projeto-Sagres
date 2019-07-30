package visao;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class VisaoPainelHorarios extends JPanel {
	
	private JTable tableHorario;
	private JButton buttonVoltar;
	private JLabel curso;
	
	public VisaoPainelHorarios(String nomeCurso, String tipoCurso) {
		this.setLayout(null);
		this.setBackground(new Color(66, 179, 165));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
	//	if(tipoCurso == "MATUTINO")
	//		this.add(getTableHorarioMatutino());
	//	if(tipoCurso == "VESPERTINO")
	//		this.add(getTableHorarioVespertino());
	//	if(tipoCurso == "NOTURNO")
	//		this.add(getTableHorarioNoturno());
	//	if(tipoCurso == "INTEGRAL")
			this.add(getTableHorarioIntegral());
		this.add(getButtonVoltar());
		this.add(getCurso(nomeCurso));
	}
	public JTable getTableHorarioMatutino() {
		if (tableHorario == null) {
			tableHorario = new JTable();
			tableHorario.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			tableHorario.setBackground(new Color(255, 255, 255));
			tableHorario.setCellSelectionEnabled(true);
			tableHorario.setColumnSelectionAllowed(true);
			tableHorario.setModel(new DefaultTableModel(
				new Object[][] {
					{"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"},
					{"7:30", null, null, null, null, null, null},
					{"8:20", null, null, null, null, null, null},
					{"9:10", null, null, null, null, null, null},
					{"10:00", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo"},
					{"10:10", null, null, null, null, null, null},
					{"11:00", null, null, null, null, null, null},
					{"11:50", null, null, null, null, null, null},
					{"12:40", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas"},
				},
				new String[] {
					"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"
				}
			));
			tableHorario.setFont(new Font("Arial", Font.PLAIN, 15));
			tableHorario.setBounds(60, 93, 734, 144);
			
		}
		return tableHorario;
	}
	
	public JTable getTableHorarioVespertino() {
		if (tableHorario == null) {
			tableHorario = new JTable();
			tableHorario.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			tableHorario.setBackground(new Color(255, 255, 255));
			tableHorario.setCellSelectionEnabled(true);
			tableHorario.setColumnSelectionAllowed(true);
			tableHorario.setModel(new DefaultTableModel(
				new Object[][] {
					{"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"},
					{"13:10", null, null, null, null, null, null},
					{"14:00", null, null, null, null, null, null},
					{"14:50", null, null, null, null, null, null},
					{"15:40", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo"},
					{"15:50", null, null, null, null, null, null},
					{"16:40", null, null, null, null, null, null},
					{"17:30", null, null, null, null, null, null},
					{"18:20", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas"},
				},
				new String[] {
					"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"
				}
			));
			tableHorario.setFont(new Font("Arial", Font.PLAIN, 15));
			tableHorario.setBounds(60, 93, 734, 144);
		}
		return tableHorario;
	}
	public JTable getTableHorarioNoturno() {
		if (tableHorario == null) {
			tableHorario = new JTable();
			tableHorario.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			tableHorario.setBackground(new Color(255, 255, 255));
			tableHorario.setCellSelectionEnabled(true);
			tableHorario.setColumnSelectionAllowed(true);
			tableHorario.setModel(new DefaultTableModel(
				new Object[][] {
					{"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"},
					{"18:20", null, null, null, null, null, null},
					{"19:10", null, null, null, null, null, null},
					{"20:00", null, null, null, null, null, null},
					{"20:50", null, null, null, null, null, null},
					{"21:40", null, null, null, null, null, null},
					{"22:30", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas"},
				},
				new String[] {
					"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"
				}
			));
			tableHorario.setFont(new Font("Arial", Font.PLAIN, 15));
			tableHorario.setBounds(60, 93, 734, 112);
		}
		return tableHorario;
	}
	public JTable getTableHorarioIntegral() {
		if (tableHorario == null) {
			tableHorario = new JTable();
			tableHorario.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			tableHorario.setBackground(new Color(255, 255, 255));
			tableHorario.setCellSelectionEnabled(true);
			tableHorario.setColumnSelectionAllowed(true);
			tableHorario.setModel(new DefaultTableModel(
				new Object[][] {
					{"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"},
					{"7:30", null, null, null, null, null, null},
					{"8:20", null, null, null, null, null, null},
					{"9:10", null, null, null, null, null, null},
					{"10:00", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo"},
					{"10:10", null, null, null, null, null, null},
					{"11:00", null, null, null, null, null, null},
					{"11:50", null, null, null, null, null, null},
					{"12:40", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas"},
					{"13:10", null, null, null, null, null, null},
					{"14:00", null, null, null, null, null, null},
					{"14:50", null, null, null, null, null, null},
					{"15:40", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo", "Intervalo"},
					{"15:50", null, null, null, null, null, null},
					{"16:40", null, null, null, null, null, null},
					{"17:30", null, null, null, null, null, null},
					{"18:20", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas", "Fim das aulas"},
				},
				new String[] {
					"Hora////Dia", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S\u00E1bado"
				}
			));
			tableHorario.setFont(new Font("Arial", Font.PLAIN, 15));
			tableHorario.setBounds(60, 93, 734, 272);
		}
		return tableHorario;
	}
	public JButton getButtonVoltar() {
		if(buttonVoltar == null) {
			buttonVoltar = new JButton("VOLTAR");
			buttonVoltar.setForeground(Color.BLACK);
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonVoltar.setBounds(20, 643, 130, 23);
			buttonVoltar.setBackground(Color.WHITE);
			buttonVoltar.setVisible(true);
		}
		return buttonVoltar;
	}
	public JLabel getCurso(String nomeCurso) {
		if(curso == null) {
			curso = new JLabel("HORÁRIO DO CURSO DE "+nomeCurso);
			curso.setFont(new Font("Arial", Font.PLAIN, 15));
			curso.setForeground(Color.BLACK);
			curso.setBounds(20, 30, 500, 30);
			curso.setBackground(Color.WHITE);
		}
		return curso;
	}
	public void setCurso(JLabel curso) {
		this.curso = curso;
	}
}
