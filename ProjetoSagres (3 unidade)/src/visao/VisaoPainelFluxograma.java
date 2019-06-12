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
	private JLabel labelDisciplinasLivres;
	private JLabel lblDisciplinasQueSo;
	private JLabel lblDisciplinasQueTm;
	private JLabel lblDisciplinasOptativas;
	private JLabel lblDisciplinasQueSo_1;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JButton buttonVoltar;
	private JButton disciplina;
	ArrayList<JButton> botoes;
	
	
	public VisaoPainelFluxograma(String nomeCurso, String tipoCurso, String cargaTotalCurso) {
		this.setBackground(SystemColor.controlHighlight);
		this.setLayout(null);
		this.add(getLabelNomeDoCurso(nomeCurso));
		this.add(getLabelCargaHorariaTotal(cargaTotalCurso));
		this.add(getLblTipoDeCurso(tipoCurso));
		this.add(getLabelFluxograma());
		this.add(getButtonVoltar());
		this.add(getLabelDisciplinasLivres());
		this.add(getLblDisciplinasQueSo());
		this.add(getLblDisciplinasQueTm());
		this.add(getLblDisciplinasOptativas());
		this.add(getLblDisciplinasQueSo_1());
		this.add(getSeparator());
		this.add(getSeparator_1());
		this.add(getSeparator_2());
		
	}

	public ArrayList<JButton> getBotoes(){
		if(botoes == null) {
			botoes = new ArrayList<JButton>();
		}
		return botoes;
		
		
	}

	public JButton BotoesFluxograma(String nome, int carga, boolean ePre, boolean temPre, int x, int y) {
		disciplina = new JButton("");
		if(carga>0) {
			disciplina.setText(nome+"            "+carga);
			if(ePre == false && temPre == false)
				disciplina.setBackground(new Color(51, 204, 0)); // verde, sem pré e n é pre-requisito
			else if(ePre == false && temPre == true)
				disciplina.setBackground(new Color(255, 255, 0)); //amarelo, tem pré e n é pré-requisito
			else if(ePre == true && temPre == false)
				disciplina.setBackground(new Color(255, 204, 0)); //laranja, sem pré e é pre-requisito
			else
				disciplina.setBackground(new Color(255, 0, 51)); //vermelho, tem pré e é pre-requisito
		}
		
		else {
			disciplina.setText(nome);
			disciplina.setBackground(Color.WHITE);
		}
		disciplina.setVerticalAlignment(SwingConstants.BOTTOM);
		disciplina.setHorizontalAlignment(SwingConstants.LEADING);
		disciplina.setForeground(Color.BLACK);
		disciplina.setFont(new Font("Arial", Font.BOLD, 14));
		disciplina.setBounds(x, y, 150, 40);
		
		return disciplina;
		
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
