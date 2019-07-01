package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import controle.Main;
import modelo.ModeloTabelaAluno;
import modelo.ModeloTabelaCurso;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class VisaoPainelConsultaCurso extends JPanel{
	private JButton 			buttonVoltar 	 				= null;
	private JButton 			buttonGerarFluxograma			= null;
	private JComboBox comboBoxCursos;
	private ModeloTabelaCurso tabelaCurso;
	private JTable jtableDadosCurso;
	private JScrollPane dadosCursoJScrollPane;
	
	public VisaoPainelConsultaCurso() {
		this.setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getButtonVoltar());
		this.add(getButtonGerarFluxograma());
		this.add(getComboBoxCursos());
		this.add(getDadosAlunoJScrollPane());
	}
	
	public JButton getButtonVoltar() {
		if(buttonVoltar == null) {
			buttonVoltar = new JButton("VOLTAR");
			buttonVoltar.setForeground(Color.BLACK);
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonVoltar.setBounds(22, 640, 130, 33);
			buttonVoltar.setBackground(Color.WHITE);
			buttonVoltar.setVisible(true);
		}
		return buttonVoltar;
	}
	
	public JButton getButtonGerarFluxograma() {
		if (buttonGerarFluxograma == null) {
			buttonGerarFluxograma = new JButton("Gerar Fluxograma");
			buttonGerarFluxograma.setBackground(Color.WHITE);
			buttonGerarFluxograma.setFont(new Font("Arial", Font.PLAIN, 20));
			buttonGerarFluxograma.setForeground(Color.BLACK);
			buttonGerarFluxograma.setBounds(742, 52, 214, 25);
		}
		return buttonGerarFluxograma;
	}
	public JComboBox getComboBoxCursos() {
		if (comboBoxCursos == null) {
			comboBoxCursos = new JComboBox();
			comboBoxCursos.setFont(new Font("Arial", Font.PLAIN, 20));
			comboBoxCursos.setBackground(Color.WHITE);
			comboBoxCursos.setBounds(43, 52, 675, 25);
		}
		return comboBoxCursos;
	}
	
	public JTable getJTableDadosCurso() {
		if (jtableDadosCurso == null) {
			jtableDadosCurso = new JTable();
			jtableDadosCurso.setBorder(new LineBorder(new Color(0, 0, 0)));
			jtableDadosCurso.setFont(new Font("Arial Narrow", Font.BOLD, 20));
			jtableDadosCurso.setModel(getTabela());
			//auto ajuste na altura da tabela
			//jtableDadosCurso.setFillsViewportHeight(true);
	        //selecionar somente uma linha
			//jtableDadosCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jtableDadosCurso.getColumnModel().getColumn(0).setPreferredWidth(100);
			jtableDadosCurso.getColumnModel().getColumn(1).setPreferredWidth(400);
			jtableDadosCurso.getColumnModel().getColumn(2).setPreferredWidth(120);
			jtableDadosCurso.getColumnModel().getColumn(3).setPreferredWidth(200);
			jtableDadosCurso.getColumnModel().getColumn(4).setPreferredWidth(400);
			jtableDadosCurso.getColumnModel().getColumn(5).setPreferredWidth(150);
			jtableDadosCurso.setBounds(10, 89, 1200, 400);
			jtableDadosCurso.setVisible(true);
		}
		return jtableDadosCurso;
	}
	
	public JScrollPane getDadosAlunoJScrollPane() {
		if(dadosCursoJScrollPane == null) {
			dadosCursoJScrollPane = new JScrollPane(getJTableDadosCurso());
			dadosCursoJScrollPane.setBounds(48, 116, 1200, 400);
		}
		return dadosCursoJScrollPane;
	}
	
	public ModeloTabelaCurso getTabela() {
		if(tabelaCurso == null) {
			tabelaCurso = new ModeloTabelaCurso();
		}
		return tabelaCurso;
	}

	public void setTabela(ModeloTabelaCurso tabela) {
		this.tabelaCurso = tabela;
	}
}
