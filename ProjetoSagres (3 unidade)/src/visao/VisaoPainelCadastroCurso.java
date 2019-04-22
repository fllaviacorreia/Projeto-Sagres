package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import modelo.validacao.FormataMascaras;

public class VisaoPainelCadastroCurso extends JPanel{
	
	private JLabel 				labelNomeCurso 					= null;
	private JLabel 				labelCargaHorariaTotal 			= null;
	private JLabel 				labelDisciplinas 				= null;
	private JLabel 				labelSemestresTotais 			= null;
	private JComboBox<String> 	comboBoxCargaHorariaTotal 		= null;
	private JComboBox<String> 	comboBoxDisciplinas 			= null;
	private JButton 			buttonVoltar 					= null;
	private JButton 			buttonCancelar 	 				= null;
	private JButton 			buttonConfirmar   				= null;
	private JButton 			buttonAdicionarDisciplina  		= null;
	private JButton 			buttonAdicionarCargaHoraria  	= null;
	
	FormataMascaras formatacao = new FormataMascaras();
	private JButton buttonGerarFluxograma;
	private JComboBox<String> comboBoxHorario;
	private JLabel labelHorario;
	private JComboBox<String> comboBoxSemestresTotais;
	private JComboBox<String> comboBoxCurso;
	
	public VisaoPainelCadastroCurso() {
		this.setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getLabelCargaHorariaTotal());
		this.add(getLabelDisciplinas());
		this.add(getLabelNomeCurso());
		this.add(getLabelSemestresTotais());
		this.add(getComboBoxCargaHorariaTotal());
		this.add(getComboBoxDisciplinas());
		this.add(getButtonVoltar());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonAdicionarDisciplina());
		this.add(getButtonAdicionarCargaHoraria());
		add(getButtonGerarFluxograma());
		add(getComboBoxHorario());
		add(getLabelHorario());
		add(getComboBoxSemestresTotais());
		add(getComboBoxCurso());
	}
	
	

	public JLabel getLabelNomeCurso() {
		if(labelNomeCurso == null) {
			labelNomeCurso = new JLabel("Nome:");
			labelNomeCurso.setBounds(53, 7, 154, 15);
			labelNomeCurso.setForeground(Color.BLACK);
			labelNomeCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNomeCurso.setVisible(true);
		}
		return labelNomeCurso;
	}

	public JLabel getLabelCargaHorariaTotal() {
		if(labelCargaHorariaTotal == null) {
			labelCargaHorariaTotal = new JLabel("Carga Horaria Total:");
			labelCargaHorariaTotal.setBounds(54, 87, 154, 15);
			labelCargaHorariaTotal.setForeground(Color.BLACK);
			labelCargaHorariaTotal.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCargaHorariaTotal.setVisible(true);
		}
		return labelCargaHorariaTotal;
	}

	public JLabel getLabelDisciplinas() {
		if(labelDisciplinas == null) {
			labelDisciplinas = new JLabel("Disciplinas:");
			labelDisciplinas.setBounds(53, 164, 154, 15);
			labelDisciplinas.setForeground(Color.BLACK);
			labelDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDisciplinas.setVisible(true);
		}
		return labelDisciplinas;
	}

	public JLabel getLabelSemestresTotais() {
		if(labelSemestresTotais == null) {
			labelSemestresTotais = new JLabel("Semestres Totais:");
			labelSemestresTotais.setBounds(465, 7, 154, 15);
			labelSemestresTotais.setForeground(Color.BLACK);
			labelSemestresTotais.setFont(new Font("Arial", Font.PLAIN, 14));
			labelSemestresTotais.setVisible(true);
		}
		return labelSemestresTotais;
	}

	public JComboBox<String> getComboBoxCargaHorariaTotal() {
		if(comboBoxCargaHorariaTotal == null) {
			comboBoxCargaHorariaTotal = new JComboBox<String>();
			comboBoxCargaHorariaTotal.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE"}));
			comboBoxCargaHorariaTotal.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCargaHorariaTotal.setBackground(new Color(255, 255, 255));
			comboBoxCargaHorariaTotal.setBounds(54, 113, 130, 20);
			comboBoxCargaHorariaTotal.setVisible(true);
		}
		return comboBoxCargaHorariaTotal;
	}

	public JComboBox<String> getComboBoxDisciplinas() {
		if(comboBoxDisciplinas == null) {
			comboBoxDisciplinas = new JComboBox<String>();
			comboBoxDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxDisciplinas.setBackground(new Color(255, 255, 255));
			comboBoxDisciplinas.setBounds(53, 190, 337, 20);
			comboBoxDisciplinas.setVisible(true);
		}
		return comboBoxDisciplinas;
	}

	public JButton getButtonVoltar() {
		if(buttonVoltar == null) {
			buttonVoltar = new JButton("VOLTAR");
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonVoltar.setBounds(54, 631, 130, 33);
			buttonVoltar.setBackground(Color.WHITE);
			buttonVoltar.setVisible(true);
		}
		return buttonVoltar;
	}

	public JButton getButtonCancelar() {
		if(buttonCancelar == null) {
			buttonCancelar = new JButton("CANCELAR");
			buttonCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonCancelar.setBounds(211, 631, 130, 33);
			buttonCancelar.setBackground(Color.WHITE);
			buttonCancelar.setVisible(true);
		}
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		if(buttonConfirmar == null) {
			buttonConfirmar = new JButton("CONFIRMAR");
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonConfirmar.setBounds(370, 631, 130, 33);
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setVisible(true);
		}
		return buttonConfirmar;
	}

	public JButton getButtonAdicionarDisciplina() {
		if(buttonAdicionarDisciplina == null) {
			buttonAdicionarDisciplina = new JButton("Adicionar disciplina");
			buttonAdicionarDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonAdicionarDisciplina.setBounds(465, 190, 166, 20);
			buttonAdicionarDisciplina.setBackground(Color.WHITE);
			buttonAdicionarDisciplina.setVisible(true);
		}
		return buttonAdicionarDisciplina;
	}


	public JButton getButtonAdicionarCargaHoraria() {
		if(buttonAdicionarCargaHoraria == null) {
			buttonAdicionarCargaHoraria = new JButton("Adicionar carga hor\u00E1ria");
			buttonAdicionarCargaHoraria.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarCargaHoraria.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonAdicionarCargaHoraria.setBounds(204, 113, 186, 20);
			buttonAdicionarCargaHoraria.setBackground(Color.WHITE);
			buttonAdicionarCargaHoraria.setVisible(true);
		}
		return buttonAdicionarCargaHoraria;
	}
	public JButton getButtonGerarFluxograma() {
		if (buttonGerarFluxograma == null) {
			buttonGerarFluxograma = new JButton("Gerar Fluxograma");
			buttonGerarFluxograma.setBackground(Color.WHITE);
			buttonGerarFluxograma.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonGerarFluxograma.setForeground(Color.BLACK);
			buttonGerarFluxograma.setBounds(465, 256, 154, 23);
		}
		return buttonGerarFluxograma;
	}
	public JComboBox<String> getComboBoxHorario() {
		if (comboBoxHorario == null) {
			comboBoxHorario = new JComboBox();
			comboBoxHorario.setBackground(Color.WHITE);
			comboBoxHorario.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxHorario.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "MATUTINO", "VESPERTINO", "NOTURNO", "INTEGRAL"}));
			comboBoxHorario.setBounds(465, 113, 130, 20);
		}
		return comboBoxHorario;
	}
	public JLabel getLabelHorario() {
		if (labelHorario == null) {
			labelHorario = new JLabel("Hor\u00E1rio do Curso:");
			labelHorario.setFont(new Font("Arial", Font.PLAIN, 14));
			labelHorario.setBounds(465, 88, 130, 14);
		}
		return labelHorario;
	}
	public JComboBox<String> getComboBoxSemestresTotais() {
		if (comboBoxSemestresTotais == null) {
			comboBoxSemestresTotais = new JComboBox();
			comboBoxSemestresTotais.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxSemestresTotais.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "4", "6", "8", "10", "12"}));
			comboBoxSemestresTotais.setBounds(465, 34, 119, 20);
			comboBoxSemestresTotais.setBackground(Color.WHITE);
		}
		return comboBoxSemestresTotais;
	}
	public JComboBox<String> getComboBoxCurso() {
		if (comboBoxCurso == null) {
			comboBoxCurso = new JComboBox();
			comboBoxCurso.setForeground(Color.BLACK);
			comboBoxCurso.setBackground(Color.WHITE);
			comboBoxCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCurso.setBounds(54, 35, 336, 20);
		}
		return comboBoxCurso;
	}
}
