package visao;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import controle.Main;
import modelo.Curso;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class VisaoPainelFluxograma extends JPanel {
	
	private JLabel  labelNomeDoCurso;
	private JLabel  labelCargaHorariaTotal;
	private JLabel  labelTipoDeCurso;
	private JLabel  labelFluxograma;
	private JButton buttonVoltar;
	
//	private int x = 30;
//	private int y = 90;
//	private int valor;
//	private int i1;
//	private String [] disciplinas;
//	private int [] carga;
//	private boolean [] epre;
//	private boolean [] tempre;
	ArrayList<VisaoBotoesFluxograma> botoes = new ArrayList<VisaoBotoesFluxograma>();
	
	int dado;
	Curso dados;
	private JButton buttonPriSemetre;
	private JButton buttonSegSemetre;
	private JButton buttonTerSemetre;
	private JButton buttonQuaSemetre;
	private JButton buttonQuiSemetre;
	private JButton buttonSexSemetre;
	private JButton buttonSetSemetre;
	private JButton buttonOitSemetre;
	private JButton btnDisciplina;
	private JButton btnDisciplina_1;
	private JButton btnDisciplina_2;
	private JButton btnDisciplina_3;
	private JButton btnDisciplina_4;
	private JButton btnDisciplina_5;
	private JButton btnDisciplina_6;
	private JButton btnDisciplina_7;
	private JButton btnDisciplina_8;
	private JButton btnDisciplina_9;
	private JButton btnDisciplina_10;
	private JButton btnDisciplina_11;
	private JButton btnDisciplina_12;
	private JButton btnDisciplina_13;
	private JButton btnDisciplina_14;
	private JButton btnDisciplina_15;
	private JButton btnDisciplina_16;
	private JButton btnDisciplina_17;
	private JButton btnDisciplina_18;
	private JButton btnDisciplina_19;
	private JButton btnDisciplina_20;
	private JButton btnDisciplina_21;
	private JButton btnDisciplina_22;
	private JButton btnDisciplina_23;
	private JButton btnDisciplina_24;
	private JButton btnDisciplina_25;
	private JButton btnDisciplina_26;
	private JButton btnDisciplina_27;
	private JButton btnDisciplina_28;
	private JButton btnDisciplina_29;
	private JButton btnDisciplina_30;
	private JButton btnDisciplina_31;
	private JButton btnDisciplina_32;
	private JButton btnDisciplina_33;
	private JButton btnDisciplina_34;
	private JButton btnDisciplina_35;
	private JButton btnDisciplina_36;
	private JButton btnDisciplina_37;
	private JButton btnDisciplina_38;
	private JButton btnDisciplina_39;
	private JLabel labelDisciplinasLivres;
	private JLabel lblDisciplinasQueSo;
	private JLabel lblDisciplinasQueTm;
	private JLabel lblDisciplinasOptativas;
	private JLabel lblDisciplinasQueSo_1;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	
	public VisaoPainelFluxograma(String nomeCurso, String tipoCurso, String cargaTotalCurso) {
		this.setBackground(SystemColor.controlHighlight);
		this.setLayout(null);
		this.add(getLabelNomeDoCurso(nomeCurso));
		this.add(getLabelCargaHorariaTotal(cargaTotalCurso));
		this.add(getLblTipoDeCurso(tipoCurso));
		this.add(getLabelFluxograma());
		this.add(getButtonVoltar());
		add(getButtonPriSemetre());
		add(getButtonSegSemetre());
		add(getButtonTerSemetre());
		add(getButtonQuaSemetre());
		add(getButtonQuiSemetre());
		add(getButtonSexSemetre());
		add(getButtonSetSemetre());
		add(getButtonOitSemetre());
		add(getBtnDisciplina());
		add(getBtnDisciplina_1());
		add(getBtnDisciplina_2());
		add(getBtnDisciplina_3());
		add(getBtnDisciplina_4());
		add(getBtnDisciplina_5());
		add(getBtnDisciplina_6());
		add(getBtnDisciplina_7());
		add(getBtnDisciplina_8());
		add(getBtnDisciplina_9());
		add(getBtnDisciplina_10());
		add(getBtnDisciplina_11());
		add(getBtnDisciplina_12());
		add(getBtnDisciplina_13());
		add(getBtnDisciplina_14());
		add(getBtnDisciplina_15());
		add(getBtnDisciplina_16());
		add(getBtnDisciplina_17());
		add(getBtnDisciplina_18());
		add(getBtnDisciplina_19());
		add(getBtnDisciplina_20());
		add(getBtnDisciplina_21());
		add(getBtnDisciplina_22());
		add(getBtnDisciplina_23());
		add(getBtnDisciplina_24());
		add(getBtnDisciplina_25());
		add(getBtnDisciplina_26());
		add(getBtnDisciplina_27());
		add(getBtnDisciplina_28());
		add(getBtnDisciplina_29());
		add(getBtnDisciplina_30());
		add(getBtnDisciplina_31());
		add(getBtnDisciplina_32());
		add(getBtnDisciplina_33());
		add(getBtnDisciplina_34());
		add(getBtnDisciplina_35());
		add(getBtnDisciplina_36());
		add(getBtnDisciplina_37());
		add(getBtnDisciplina_38());
		add(getBtnDisciplina_39());
		add(getLabelDisciplinasLivres());
		add(getLblDisciplinasQueSo());
		add(getLblDisciplinasQueTm());
		add(getLblDisciplinasOptativas());
		add(getLblDisciplinasQueSo_1());
		add(getSeparator());
		add(getSeparator_1());
		add(getSeparator_2());
		
//		dado = dados.getSemestres();
//		for(int i = 0; i <= dado; i++) {
//			x = x * i;
//			y = 90;
//			
//			botoes.add(new VisaoBotoesFluxograma(i+"º semestre", 0, false, false, x, y));
//			valor = contaDisciplinasPorSemestre(nomeCurso, i);
//			
////			for(int j = 1; j< valor; j++) {
////				y = y + 30;
////				botoes.add(new VisaoBotoesFluxograma(disciplinas[j], carga[j], epre[j], tempre[j], x, y);
////			}
//			
//			i1 = i;
//		}
//		for(int i = 1; i < i1; i++)
//			this.add(botoes.get(i));
	}

	

	public JLabel getLabelNomeDoCurso(String nomeCurso) {
		if (labelNomeDoCurso == null) {
			labelNomeDoCurso = new JLabel("CURSO DE "+nomeCurso);
			labelNomeDoCurso.setForeground(Color.BLACK);
			labelNomeDoCurso.setFont(new Font("Arial", Font.BOLD, 14));
			labelNomeDoCurso.setBounds(27, 70, 178, 25);
			labelNomeDoCurso.setVisible(true);
		}
		return labelNomeDoCurso;
	}
	public JLabel getLabelCargaHorariaTotal(String cargaTotalCurso) {
		if (labelCargaHorariaTotal == null) {
			labelCargaHorariaTotal = new JLabel("CH TOTAL DE "+cargaTotalCurso);
			labelCargaHorariaTotal.setForeground(Color.BLACK);
			labelCargaHorariaTotal.setFont(new Font("Arial", Font.BOLD, 14));
			labelCargaHorariaTotal.setBounds(251, 70, 183, 24);
			labelCargaHorariaTotal.setVisible(true);
		}
		return labelCargaHorariaTotal;
	}
	public JLabel getLblTipoDeCurso(String tipoCurso) {
		if (labelTipoDeCurso == null) {
			labelTipoDeCurso = new JLabel("CURSO "+ tipoCurso);
			labelTipoDeCurso.setForeground(Color.BLACK);
			labelTipoDeCurso.setFont(new Font("Arial", Font.BOLD, 14));
			labelTipoDeCurso.setBounds(545, 70, 166, 24);
			labelTipoDeCurso.setVisible(true);
		}
		return labelTipoDeCurso;
	}
	public JLabel getLabelFluxograma() {
		if (labelFluxograma == null) {
			labelFluxograma = new JLabel("FLUXOGRAMA");
			labelFluxograma.setForeground(Color.BLACK);
			labelFluxograma.setBackground(new Color(0, 0, 128));
			labelFluxograma.setFont(new Font("Arial", Font.PLAIN, 24));
			labelFluxograma.setBounds(495, 28, 249, 32);
			labelFluxograma.setVisible(true);
		}
		return labelFluxograma;
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
	public JButton getButtonPriSemetre() {
		if (buttonPriSemetre == null) {
			buttonPriSemetre = new JButton("1\u00BA Semetre");
			buttonPriSemetre.setForeground(Color.BLACK);
			buttonPriSemetre.setBackground(new Color(255, 255, 255));
			buttonPriSemetre.setFont(new Font("Arial", Font.BOLD, 14));
			buttonPriSemetre.setBounds(70, 172, 118, 23);
		}
		return buttonPriSemetre;
	}
	public JButton getButtonSegSemetre() {
		if (buttonSegSemetre == null) {
			buttonSegSemetre = new JButton("2\u00BA Semetre");
			buttonSegSemetre.setForeground(Color.BLACK);
			buttonSegSemetre.setBackground(new Color(255, 255, 255));
			buttonSegSemetre.setFont(new Font("Arial", Font.BOLD, 14));
			buttonSegSemetre.setBounds(70, 224, 118, 23);
		}
		return buttonSegSemetre;
	}
	public JButton getButtonTerSemetre() {
		if (buttonTerSemetre == null) {
			buttonTerSemetre = new JButton("3\u00BA Semetre");
			buttonTerSemetre.setForeground(Color.BLACK);
			buttonTerSemetre.setBackground(new Color(255, 255, 255));
			buttonTerSemetre.setFont(new Font("Arial", Font.BOLD, 14));
			buttonTerSemetre.setBounds(70, 275, 118, 23);
		}
		return buttonTerSemetre;
	}
	public JButton getButtonQuaSemetre() {
		if (buttonQuaSemetre == null) {
			buttonQuaSemetre = new JButton("4\u00BA Semetre");
			buttonQuaSemetre.setForeground(Color.BLACK);
			buttonQuaSemetre.setBackground(new Color(255, 255, 255));
			buttonQuaSemetre.setFont(new Font("Arial", Font.BOLD, 14));
			buttonQuaSemetre.setBounds(70, 324, 118, 23);
		}
		return buttonQuaSemetre;
	}
	public JButton getButtonQuiSemetre() {
		if (buttonQuiSemetre == null) {
			buttonQuiSemetre = new JButton("5\u00BA Semetre");
			buttonQuiSemetre.setForeground(Color.BLACK);
			buttonQuiSemetre.setBackground(new Color(255, 255, 255));
			buttonQuiSemetre.setFont(new Font("Arial", Font.BOLD, 14));
			buttonQuiSemetre.setBounds(70, 372, 118, 23);
		}
		return buttonQuiSemetre;
	}
	public JButton getButtonSexSemetre() {
		if (buttonSexSemetre == null) {
			buttonSexSemetre = new JButton("6\u00BA Semetre");
			buttonSexSemetre.setForeground(Color.BLACK);
			buttonSexSemetre.setBackground(new Color(255, 255, 255));
			buttonSexSemetre.setFont(new Font("Arial", Font.BOLD, 14));
			buttonSexSemetre.setBounds(70, 423, 118, 23);
		}
		return buttonSexSemetre;
	}
	public JButton getButtonSetSemetre() {
		if (buttonSetSemetre == null) {
			buttonSetSemetre = new JButton("7\u00BA Semetre");
			buttonSetSemetre.setForeground(Color.BLACK);
			buttonSetSemetre.setBackground(new Color(255, 255, 255));
			buttonSetSemetre.setFont(new Font("Arial", Font.BOLD, 14));
			buttonSetSemetre.setBounds(70, 476, 118, 23);
		}
		return buttonSetSemetre;
	}
	public JButton getButtonOitSemetre() {
		if (buttonOitSemetre == null) {
			buttonOitSemetre = new JButton("8\u00BA Semetre");
			buttonOitSemetre.setForeground(Color.BLACK);
			buttonOitSemetre.setBackground(new Color(255, 255, 255));
			buttonOitSemetre.setFont(new Font("Arial", Font.BOLD, 14));
			buttonOitSemetre.setBounds(70, 527, 118, 23);
		}
		return buttonOitSemetre;
	}
	public JButton getBtnDisciplina() {
		if (btnDisciplina == null) {
			btnDisciplina = new JButton("Disciplina 1");
			btnDisciplina.setForeground(Color.BLACK);
			btnDisciplina.setBorderPainted(false);
			btnDisciplina.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina.setBackground(new Color(51, 204, 0));
			btnDisciplina.setBounds(263, 172, 118, 23);
		}
		return btnDisciplina;
	}
	public JButton getBtnDisciplina_1() {
		if (btnDisciplina_1 == null) {
			btnDisciplina_1 = new JButton("Disciplina 1");
			btnDisciplina_1.setForeground(Color.BLACK);
			btnDisciplina_1.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_1.setBackground(new Color(255, 255, 0));
			btnDisciplina_1.setBounds(263, 224, 118, 23);
		}
		return btnDisciplina_1;
	}
	public JButton getBtnDisciplina_2() {
		if (btnDisciplina_2 == null) {
			btnDisciplina_2 = new JButton("Disciplina 1");
			btnDisciplina_2.setForeground(Color.BLACK);
			btnDisciplina_2.setBorderPainted(false);
			btnDisciplina_2.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_2.setBackground(new Color(51, 204, 0));
			btnDisciplina_2.setBounds(263, 275, 118, 23);
		}
		return btnDisciplina_2;
	}
	public JButton getBtnDisciplina_3() {
		if (btnDisciplina_3 == null) {
			btnDisciplina_3 = new JButton("Disciplina 1");
			btnDisciplina_3.setForeground(Color.BLACK);
			btnDisciplina_3.setBorderPainted(false);
			btnDisciplina_3.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_3.setBackground(new Color(51, 204, 0));
			btnDisciplina_3.setBounds(263, 324, 118, 23);
		}
		return btnDisciplina_3;
	}
	public JButton getBtnDisciplina_4() {
		if (btnDisciplina_4 == null) {
			btnDisciplina_4 = new JButton("Disciplina 1");
			btnDisciplina_4.setForeground(Color.BLACK);
			btnDisciplina_4.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_4.setBackground(new Color(255, 255, 0));
			btnDisciplina_4.setBounds(263, 372, 118, 23);
		}
		return btnDisciplina_4;
	}
	public JButton getBtnDisciplina_5() {
		if (btnDisciplina_5 == null) {
			btnDisciplina_5 = new JButton("Disciplina 1");
			btnDisciplina_5.setForeground(Color.BLACK);
			btnDisciplina_5.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_5.setBackground(new Color(255, 255, 0));
			btnDisciplina_5.setBounds(263, 423, 118, 23);
		}
		return btnDisciplina_5;
	}
	public JButton getBtnDisciplina_6() {
		if (btnDisciplina_6 == null) {
			btnDisciplina_6 = new JButton("Disciplina 1");
			btnDisciplina_6.setForeground(Color.BLACK);
			btnDisciplina_6.setBorderPainted(false);
			btnDisciplina_6.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_6.setBackground(new Color(51, 204, 0));
			btnDisciplina_6.setBounds(263, 476, 118, 23);
		}
		return btnDisciplina_6;
	}
	public JButton getBtnDisciplina_7() {
		if (btnDisciplina_7 == null) {
			btnDisciplina_7 = new JButton("Disciplina 1");
			btnDisciplina_7.setForeground(Color.BLACK);
			btnDisciplina_7.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_7.setBackground(new Color(51, 204, 0));
			btnDisciplina_7.setBounds(263, 527, 118, 23);
		}
		return btnDisciplina_7;
	}
	public JButton getBtnDisciplina_8() {
		if (btnDisciplina_8 == null) {
			btnDisciplina_8 = new JButton("Disciplina 2");
			btnDisciplina_8.setForeground(Color.BLACK);
			btnDisciplina_8.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_8.setBackground(new Color(255, 204, 0));
			btnDisciplina_8.setBounds(438, 172, 118, 23);
		}
		return btnDisciplina_8;
	}
	public JButton getBtnDisciplina_9() {
		if (btnDisciplina_9 == null) {
			btnDisciplina_9 = new JButton("Disciplina 2");
			btnDisciplina_9.setForeground(Color.BLACK);
			btnDisciplina_9.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_9.setBackground(new Color(255, 0, 51));
			btnDisciplina_9.setBounds(438, 224, 118, 23);
		}
		return btnDisciplina_9;
	}
	public JButton getBtnDisciplina_10() {
		if (btnDisciplina_10 == null) {
			btnDisciplina_10 = new JButton("Disciplina 2");
			btnDisciplina_10.setForeground(Color.BLACK);
			btnDisciplina_10.setBorderPainted(false);
			btnDisciplina_10.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_10.setBackground(new Color(51, 204, 0));
			btnDisciplina_10.setBounds(438, 275, 118, 23);
		}
		return btnDisciplina_10;
	}
	public JButton getBtnDisciplina_11() {
		if (btnDisciplina_11 == null) {
			btnDisciplina_11 = new JButton("Disciplina 2");
			btnDisciplina_11.setForeground(Color.BLACK);
			btnDisciplina_11.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_11.setBackground(new Color(255, 255, 0));
			btnDisciplina_11.setBounds(438, 324, 118, 23);
		}
		return btnDisciplina_11;
	}
	public JButton getBtnDisciplina_12() {
		if (btnDisciplina_12 == null) {
			btnDisciplina_12 = new JButton("Disciplina 2");
			btnDisciplina_12.setForeground(Color.BLACK);
			btnDisciplina_12.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_12.setBackground(new Color(255, 0, 51));
			btnDisciplina_12.setBounds(438, 372, 118, 23);
		}
		return btnDisciplina_12;
	}
	public JButton getBtnDisciplina_13() {
		if (btnDisciplina_13 == null) {
			btnDisciplina_13 = new JButton("Disciplina 2");
			btnDisciplina_13.setForeground(Color.BLACK);
			btnDisciplina_13.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_13.setBackground(new Color(255, 0, 51));
			btnDisciplina_13.setBounds(438, 423, 118, 23);
		}
		return btnDisciplina_13;
	}
	public JButton getBtnDisciplina_14() {
		if (btnDisciplina_14 == null) {
			btnDisciplina_14 = new JButton("Disciplina 2");
			btnDisciplina_14.setForeground(Color.BLACK);
			btnDisciplina_14.setBorderPainted(false);
			btnDisciplina_14.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_14.setBackground(new Color(51, 204, 0));
			btnDisciplina_14.setBounds(438, 476, 118, 23);
		}
		return btnDisciplina_14;
	}
	public JButton getBtnDisciplina_15() {
		if (btnDisciplina_15 == null) {
			btnDisciplina_15 = new JButton("Disciplina 2");
			btnDisciplina_15.setForeground(Color.BLACK);
			btnDisciplina_15.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_15.setBackground(new Color(186, 85, 211));
			btnDisciplina_15.setBounds(438, 527, 118, 23);
		}
		return btnDisciplina_15;
	}
	public JButton getBtnDisciplina_16() {
		if (btnDisciplina_16 == null) {
			btnDisciplina_16 = new JButton("Disciplina 3");
			btnDisciplina_16.setForeground(Color.BLACK);
			btnDisciplina_16.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_16.setBackground(new Color(255, 204, 0));
			btnDisciplina_16.setBounds(614, 172, 118, 23);
		}
		return btnDisciplina_16;
	}
	public JButton getBtnDisciplina_17() {
		if (btnDisciplina_17 == null) {
			btnDisciplina_17 = new JButton("Disciplina 3");
			btnDisciplina_17.setForeground(Color.BLACK);
			btnDisciplina_17.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_17.setBackground(new Color(255, 0, 51));
			btnDisciplina_17.setBounds(614, 224, 118, 23);
		}
		return btnDisciplina_17;
	}
	public JButton getBtnDisciplina_18() {
		if (btnDisciplina_18 == null) {
			btnDisciplina_18 = new JButton("Disciplina 3");
			btnDisciplina_18.setForeground(Color.BLACK);
			btnDisciplina_18.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_18.setBackground(new Color(255, 204, 0));
			btnDisciplina_18.setBounds(614, 275, 118, 23);
		}
		return btnDisciplina_18;
	}
	public JButton getBtnDisciplina_19() {
		if (btnDisciplina_19 == null) {
			btnDisciplina_19 = new JButton("Disciplina 3");
			btnDisciplina_19.setForeground(Color.BLACK);
			btnDisciplina_19.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_19.setBackground(new Color(255, 255, 0));
			btnDisciplina_19.setBounds(614, 324, 118, 23);
		}
		return btnDisciplina_19;
	}
	public JButton getBtnDisciplina_20() {
		if (btnDisciplina_20 == null) {
			btnDisciplina_20 = new JButton("Disciplina 3");
			btnDisciplina_20.setForeground(Color.BLACK);
			btnDisciplina_20.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_20.setBackground(new Color(255, 0, 51));
			btnDisciplina_20.setBounds(614, 372, 118, 23);
		}
		return btnDisciplina_20;
	}
	public JButton getBtnDisciplina_21() {
		if (btnDisciplina_21 == null) {
			btnDisciplina_21 = new JButton("Disciplina 3");
			btnDisciplina_21.setForeground(Color.BLACK);
			btnDisciplina_21.setBorderPainted(false);
			btnDisciplina_21.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_21.setBackground(new Color(51, 204, 0));
			btnDisciplina_21.setBounds(614, 423, 118, 23);
		}
		return btnDisciplina_21;
	}
	public JButton getBtnDisciplina_22() {
		if (btnDisciplina_22 == null) {
			btnDisciplina_22 = new JButton("Disciplina 3");
			btnDisciplina_22.setForeground(Color.BLACK);
			btnDisciplina_22.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_22.setBackground(new Color(255, 0, 51));
			btnDisciplina_22.setBounds(614, 476, 118, 23);
		}
		return btnDisciplina_22;
	}
	public JButton getBtnDisciplina_23() {
		if (btnDisciplina_23 == null) {
			btnDisciplina_23 = new JButton("Disciplina 3");
			btnDisciplina_23.setForeground(Color.BLACK);
			btnDisciplina_23.setBorderPainted(false);
			btnDisciplina_23.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_23.setBackground(new Color(51, 204, 0));
			btnDisciplina_23.setBounds(614, 527, 118, 23);
		}
		return btnDisciplina_23;
	}
	public JButton getBtnDisciplina_24() {
		if (btnDisciplina_24 == null) {
			btnDisciplina_24 = new JButton("Disciplina 4");
			btnDisciplina_24.setForeground(Color.BLACK);
			btnDisciplina_24.setBorderPainted(false);
			btnDisciplina_24.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_24.setBackground(new Color(51, 204, 0));
			btnDisciplina_24.setBounds(789, 172, 118, 23);
		}
		return btnDisciplina_24;
	}
	public JButton getBtnDisciplina_25() {
		if (btnDisciplina_25 == null) {
			btnDisciplina_25 = new JButton("Disciplina 4");
			btnDisciplina_25.setForeground(Color.BLACK);
			btnDisciplina_25.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_25.setBackground(new Color(255, 0, 51));
			btnDisciplina_25.setBounds(789, 224, 118, 23);
		}
		return btnDisciplina_25;
	}
	public JButton getBtnDisciplina_26() {
		if (btnDisciplina_26 == null) {
			btnDisciplina_26 = new JButton("Disciplina 4");
			btnDisciplina_26.setForeground(Color.BLACK);
			btnDisciplina_26.setBorderPainted(false);
			btnDisciplina_26.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_26.setBackground(new Color(51, 204, 0));
			btnDisciplina_26.setBounds(789, 275, 118, 23);
		}
		return btnDisciplina_26;
	}
	public JButton getBtnDisciplina_27() {
		if (btnDisciplina_27 == null) {
			btnDisciplina_27 = new JButton("Disciplina 4");
			btnDisciplina_27.setForeground(Color.BLACK);
			btnDisciplina_27.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_27.setBackground(new Color(255, 204, 0));
			btnDisciplina_27.setBounds(789, 324, 118, 23);
		}
		return btnDisciplina_27;
	}
	public JButton getBtnDisciplina_28() {
		if (btnDisciplina_28 == null) {
			btnDisciplina_28 = new JButton("Disciplina 4");
			btnDisciplina_28.setForeground(Color.BLACK);
			btnDisciplina_28.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_28.setBackground(new Color(255, 0, 51));
			btnDisciplina_28.setBounds(789, 372, 118, 23);
		}
		return btnDisciplina_28;
	}
	public JButton getBtnDisciplina_29() {
		if (btnDisciplina_29 == null) {
			btnDisciplina_29 = new JButton("Disciplina 4");
			btnDisciplina_29.setForeground(Color.BLACK);
			btnDisciplina_29.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_29.setBackground(new Color(255, 0, 51));
			btnDisciplina_29.setBounds(789, 423, 118, 23);
		}
		return btnDisciplina_29;
	}
	public JButton getBtnDisciplina_30() {
		if (btnDisciplina_30 == null) {
			btnDisciplina_30 = new JButton("Disciplina 4");
			btnDisciplina_30.setForeground(Color.BLACK);
			btnDisciplina_30.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_30.setBackground(new Color(255, 215, 0));
			btnDisciplina_30.setBounds(789, 476, 118, 23);
		}
		return btnDisciplina_30;
	}
	public JButton getBtnDisciplina_31() {
		if (btnDisciplina_31 == null) {
			btnDisciplina_31 = new JButton("Disciplina 4");
			btnDisciplina_31.setForeground(Color.BLACK);
			btnDisciplina_31.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_31.setBackground(new Color(51, 204, 0));
			btnDisciplina_31.setBounds(789, 527, 118, 23);
		}
		return btnDisciplina_31;
	}
	public JButton getBtnDisciplina_32() {
		if (btnDisciplina_32 == null) {
			btnDisciplina_32 = new JButton("Disciplina 5");
			btnDisciplina_32.setForeground(Color.BLACK);
			btnDisciplina_32.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_32.setBackground(new Color(255, 204, 0));
			btnDisciplina_32.setBounds(951, 172, 118, 23);
		}
		return btnDisciplina_32;
	}
	public JButton getBtnDisciplina_33() {
		if (btnDisciplina_33 == null) {
			btnDisciplina_33 = new JButton("Disciplina 5");
			btnDisciplina_33.setForeground(Color.BLACK);
			btnDisciplina_33.setBorderPainted(false);
			btnDisciplina_33.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_33.setBackground(new Color(51, 204, 0));
			btnDisciplina_33.setBounds(951, 224, 118, 23);
		}
		return btnDisciplina_33;
	}
	public JButton getBtnDisciplina_34() {
		if (btnDisciplina_34 == null) {
			btnDisciplina_34 = new JButton("Disciplina 5");
			btnDisciplina_34.setForeground(Color.BLACK);
			btnDisciplina_34.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_34.setBackground(new Color(255, 204, 0));
			btnDisciplina_34.setBounds(951, 275, 118, 23);
		}
		return btnDisciplina_34;
	}
	public JButton getBtnDisciplina_35() {
		if (btnDisciplina_35 == null) {
			btnDisciplina_35 = new JButton("Disciplina 5");
			btnDisciplina_35.setForeground(Color.BLACK);
			btnDisciplina_35.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_35.setBackground(new Color(51, 204, 0));
			btnDisciplina_35.setBounds(951, 324, 118, 23);
		}
		return btnDisciplina_35;
	}
	public JButton getBtnDisciplina_36() {
		if (btnDisciplina_36 == null) {
			btnDisciplina_36 = new JButton("Disciplina 5");
			btnDisciplina_36.setForeground(Color.BLACK);
			btnDisciplina_36.setBorderPainted(false);
			btnDisciplina_36.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_36.setBackground(new Color(51, 204, 0));
			btnDisciplina_36.setBounds(951, 372, 118, 23);
		}
		return btnDisciplina_36;
	}
	public JButton getBtnDisciplina_37() {
		if (btnDisciplina_37 == null) {
			btnDisciplina_37 = new JButton("Disciplina 5");
			btnDisciplina_37.setForeground(Color.BLACK);
			btnDisciplina_37.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_37.setBackground(new Color(186, 85, 211));
			btnDisciplina_37.setBounds(951, 423, 118, 23);
		}
		return btnDisciplina_37;
	}
	public JButton getBtnDisciplina_38() {
		if (btnDisciplina_38 == null) {
			btnDisciplina_38 = new JButton("Disciplina 5");
			btnDisciplina_38.setForeground(Color.BLACK);
			btnDisciplina_38.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_38.setBackground(new Color(186, 85, 211));
			btnDisciplina_38.setBounds(951, 476, 118, 23);
		}
		return btnDisciplina_38;
	}
	public JButton getBtnDisciplina_39() {
		if (btnDisciplina_39 == null) {
			btnDisciplina_39 = new JButton("Disciplina 5");
			btnDisciplina_39.setForeground(Color.BLACK);
			btnDisciplina_39.setFont(new Font("Arial", Font.BOLD, 14));
			btnDisciplina_39.setBackground(new Color(255, 255, 0));
			btnDisciplina_39.setBounds(951, 527, 118, 23);
		}
		return btnDisciplina_39;
	}
	public JLabel getLabelDisciplinasLivres() {
		if (labelDisciplinasLivres == null) {
			labelDisciplinasLivres = new JLabel("Disciplinas livres");
			labelDisciplinasLivres.setForeground(new Color(51, 204, 0));
			labelDisciplinasLivres.setFont(new Font("Arial", Font.BOLD, 14));
			labelDisciplinasLivres.setBounds(196, 638, 249, 14);
		}
		return labelDisciplinasLivres;
	}
	public JLabel getLblDisciplinasQueSo() {
		if (lblDisciplinasQueSo == null) {
			lblDisciplinasQueSo = new JLabel("Disciplinas que s\u00E3o pr\u00E9-requisito");
			lblDisciplinasQueSo.setBackground(new Color(255, 204, 0));
			lblDisciplinasQueSo.setForeground(new Color(255, 215, 0));
			lblDisciplinasQueSo.setFont(new Font("Arial", Font.BOLD, 14));
			lblDisciplinasQueSo.setBounds(196, 663, 319, 14);
		}
		return lblDisciplinasQueSo;
	}
	public JLabel getLblDisciplinasQueTm() {
		if (lblDisciplinasQueTm == null) {
			lblDisciplinasQueTm = new JLabel("Disciplinas que t\u00EAm pr\u00E9-requisito(s)");
			lblDisciplinasQueTm.setBackground(new Color(255, 255, 0));
			lblDisciplinasQueTm.setForeground(new Color(255, 255, 102));
			lblDisciplinasQueTm.setFont(new Font("Arial", Font.BOLD, 14));
			lblDisciplinasQueTm.setBounds(456, 638, 288, 14);
		}
		return lblDisciplinasQueTm;
	}
	public JLabel getLblDisciplinasOptativas() {
		if (lblDisciplinasOptativas == null) {
			lblDisciplinasOptativas = new JLabel("Disciplinas optativas");
			lblDisciplinasOptativas.setForeground(new Color(186, 85, 211));
			lblDisciplinasOptativas.setFont(new Font("Arial", Font.BOLD, 14));
			lblDisciplinasOptativas.setBounds(456, 662, 288, 14);
		}
		return lblDisciplinasOptativas;
	}
	public JLabel getLblDisciplinasQueSo_1() {
		if (lblDisciplinasQueSo_1 == null) {
			lblDisciplinasQueSo_1 = new JLabel("Disciplinas que s\u00E3o e t\u00EAm pr\u00E9-requisito(s)");
			lblDisciplinasQueSo_1.setForeground(new Color(255, 0, 51));
			lblDisciplinasQueSo_1.setBackground(new Color(255, 0, 51));
			lblDisciplinasQueSo_1.setFont(new Font("Arial", Font.BOLD, 14));
			lblDisciplinasQueSo_1.setBounds(742, 638, 369, 14);
		}
		return lblDisciplinasQueSo_1;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.WHITE);
			separator.setBounds(182, 622, 1400, 76);
		}
		return separator;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBackground(Color.WHITE);
			separator_1.setBounds(182, 608, 1400, 76);
		}
		return separator_1;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBackground(Color.WHITE);
			separator_2.setOrientation(SwingConstants.VERTICAL);
			separator_2.setBounds(182, 608, 24, 159);
		}
		return separator_2;
	}
}
