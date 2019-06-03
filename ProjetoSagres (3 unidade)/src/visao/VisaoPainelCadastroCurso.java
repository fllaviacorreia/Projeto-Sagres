package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import modelo.FormataMascaras;

public class VisaoPainelCadastroCurso extends JPanel{
	
	private JLabel 				labelNomeCurso 					= null;
	private JLabel 				labelCargaHorariaTotal 			= null;
	private JLabel 				labelSemestresTotais 			= null;
	private JComboBox<String> 	comboBoxCargaHorariaTotal 		= null;
	private JButton 			buttonVoltar 					= null;
	private JButton 			buttonCancelar 	 				= null;
	private JButton 			buttonConfirmar   				= null;
	private JButton 			buttonAdicionarCargaHoraria  	= null;
	
	FormataMascaras formatacao = new FormataMascaras();
//	private JButton buttonGerarFluxograma;
	private JComboBox<String> comboBoxHorario;
	private JLabel labelHorario;
	private JComboBox<String> comboBoxSemestresTotais;
	private JFormattedTextField formattedTextFieldNomeCurso;
	
	public VisaoPainelCadastroCurso() {
		this.setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getLabelCargaHorariaTotal());
		this.add(getLabelNomeCurso());
		this.add(getLabelSemestresTotais());
		this.add(getComboBoxCargaHorariaTotal());
		this.add(getButtonVoltar());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonAdicionarCargaHoraria());
//		add(getButtonGerarFluxograma());
		add(getComboBoxHorario());
		add(getLabelHorario());
		add(getComboBoxSemestresTotais());
		add(getFormattedTextFieldNomeCurso());
	}
	
	

	public JLabel getLabelNomeCurso() {
		if(labelNomeCurso == null) {
			labelNomeCurso = new JLabel("Nome:");
			labelNomeCurso.setBounds(22, 28, 154, 15);
			labelNomeCurso.setForeground(Color.BLACK);
			labelNomeCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNomeCurso.setVisible(true);
		}
		return labelNomeCurso;
	}

	public JLabel getLabelCargaHorariaTotal() {
		if(labelCargaHorariaTotal == null) {
			labelCargaHorariaTotal = new JLabel("Carga Horaria Total:");
			labelCargaHorariaTotal.setBounds(23, 108, 154, 15);
			labelCargaHorariaTotal.setForeground(Color.BLACK);
			labelCargaHorariaTotal.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCargaHorariaTotal.setVisible(true);
		}
		return labelCargaHorariaTotal;
	}

	public JLabel getLabelSemestresTotais() {
		if(labelSemestresTotais == null) {
			labelSemestresTotais = new JLabel("Semestres Totais:");
			labelSemestresTotais.setBounds(434, 28, 154, 15);
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
			comboBoxCargaHorariaTotal.setBounds(23, 134, 130, 20);
			comboBoxCargaHorariaTotal.setVisible(true);
		}
		return comboBoxCargaHorariaTotal;
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


	public JButton getButtonAdicionarCargaHoraria() {
		if(buttonAdicionarCargaHoraria == null) {
			buttonAdicionarCargaHoraria = new JButton("Adicionar carga hor\u00E1ria");
			buttonAdicionarCargaHoraria.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarCargaHoraria.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonAdicionarCargaHoraria.setBounds(173, 134, 186, 20);
			buttonAdicionarCargaHoraria.setBackground(Color.WHITE);
			buttonAdicionarCargaHoraria.setVisible(true);
		}
		return buttonAdicionarCargaHoraria;
	}
//	public JButton getButtonGerarFluxograma() {
//		if (buttonGerarFluxograma == null) {
//			buttonGerarFluxograma = new JButton("Gerar Fluxograma");
//			buttonGerarFluxograma.setBackground(Color.WHITE);
//			buttonGerarFluxograma.setFont(new Font("Arial", Font.PLAIN, 14));
//			buttonGerarFluxograma.setForeground(Color.BLACK);
//			buttonGerarFluxograma.setBounds(23, 251, 154, 23);
//		}
//		return buttonGerarFluxograma;
//	}
	public JComboBox<String> getComboBoxHorario() {
		if (comboBoxHorario == null) {
			comboBoxHorario = new JComboBox();
			comboBoxHorario.setBackground(Color.WHITE);
			comboBoxHorario.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxHorario.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "MATUTINO", "VESPERTINO", "NOTURNO", "INTEGRAL"}));
			comboBoxHorario.setBounds(434, 134, 130, 20);
		}
		return comboBoxHorario;
	}
	public JLabel getLabelHorario() {
		if (labelHorario == null) {
			labelHorario = new JLabel("Hor\u00E1rio do Curso:");
			labelHorario.setFont(new Font("Arial", Font.PLAIN, 14));
			labelHorario.setBounds(434, 109, 130, 14);
		}
		return labelHorario;
	}
	public JComboBox<String> getComboBoxSemestresTotais() {
		if (comboBoxSemestresTotais == null) {
			comboBoxSemestresTotais = new JComboBox();
			comboBoxSemestresTotais.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxSemestresTotais.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "4", "6", "8", "10", "12"}));
			comboBoxSemestresTotais.setBounds(434, 55, 119, 20);
			comboBoxSemestresTotais.setBackground(Color.WHITE);
		}
		return comboBoxSemestresTotais;
	}
	public JFormattedTextField getFormattedTextFieldNomeCurso() {
		if (formattedTextFieldNomeCurso == null) {
			formattedTextFieldNomeCurso = new JFormattedTextField();
			formattedTextFieldNomeCurso.setForeground(Color.BLACK);
			formattedTextFieldNomeCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldNomeCurso.setBounds(23, 56, 367, 22);
		}
		return formattedTextFieldNomeCurso;
	}
}
