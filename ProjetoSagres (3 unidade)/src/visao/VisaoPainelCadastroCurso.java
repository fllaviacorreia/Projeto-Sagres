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

@SuppressWarnings("serial")
public class VisaoPainelCadastroCurso extends JPanel{
	
	private JLabel 				labelNomeCurso 					= null;
	private JLabel 				labelCargaHorariaTotal 			= null;
	private JLabel 				labelSemestresTotais 			= null;
	private JLabel 				labelTipoDoCurso				= null;
	private JLabel 				labelTipoDaGraduacao			= null;
	private JLabel 				labelHorario					= null;
	private JFormattedTextField formattedTextFieldNomeCurso		= null;
	private JComboBox<String> 	comboBoxCargaHorariaTotal 		= null;
	private JComboBox<String> 	comboBoxHorario					= null;
	private JComboBox<String> 	comboBoxSemestresTotais			= null;
	private JComboBox<String> 	comboBoxTipoCurso				= null;
	private JComboBox<String> 	comboBoxTipoGraduacao			= null;
	private JButton 			buttonVoltar 					= null;
	private JButton 			buttonCancelar 	 				= null;
	private JButton 			buttonConfirmar   				= null;
	FormataMascaras formatacao = new FormataMascaras();
	
	public VisaoPainelCadastroCurso() {
		this.setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getLabelCargaHorariaTotal());
		this.add(getLabelNomeCurso());
		this.add(getLabelSemestresTotais());
		this.add(getLabelHorario());
		this.add(getLabelTipoDoCurso());
		this.add(getLabelTipoDaGraduacao());
		this.add(getFormattedTextFieldNomeCurso());
		this.add(getComboBoxCargaHorariaTotal());
		this.add(getComboBoxHorario());
		this.add(getComboBoxSemestresTotais());
		this.add(getComboBoxTipoCurso());
		this.add(getComboBoxTipoGraduacao());
		this.add(getButtonVoltar());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
	}

	public JLabel getLabelNomeCurso() {
		if(labelNomeCurso == null) {
			labelNomeCurso = new JLabel("Nome:");
			labelNomeCurso.setBounds(22, 33, 154, 25);
			labelNomeCurso.setForeground(Color.BLACK);
			labelNomeCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNomeCurso.setVisible(true);
		}
		return labelNomeCurso;
	}

	public JLabel getLabelCargaHorariaTotal() {
		if(labelCargaHorariaTotal == null) {
			labelCargaHorariaTotal = new JLabel("Carga Horaria Total:");
			labelCargaHorariaTotal.setBounds(22, 105, 154, 25);
			labelCargaHorariaTotal.setForeground(Color.BLACK);
			labelCargaHorariaTotal.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCargaHorariaTotal.setVisible(true);
		}
		return labelCargaHorariaTotal;
	}

	public JLabel getLabelSemestresTotais() {
		if(labelSemestresTotais == null) {
			labelSemestresTotais = new JLabel("Semestres Totais:");
			labelSemestresTotais.setBounds(22, 168, 154, 25);
			labelSemestresTotais.setForeground(Color.BLACK);
			labelSemestresTotais.setFont(new Font("Arial", Font.PLAIN, 14));
			labelSemestresTotais.setVisible(true);
		}
		return labelSemestresTotais;
	}
	public JLabel getLabelHorario() {
		if (labelHorario == null) {
			labelHorario = new JLabel("Hor\u00E1rio do Curso:");
			labelHorario.setFont(new Font("Arial", Font.PLAIN, 14));
			labelHorario.setBounds(22, 237, 130, 25);
		}
		return labelHorario;
	}
	public JLabel getLabelTipoDoCurso() {
		if (labelTipoDoCurso == null) {
			labelTipoDoCurso = new JLabel("Tipo do Curso:");
			labelTipoDoCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelTipoDoCurso.setBounds(22, 309, 119, 25);
		}
		return labelTipoDoCurso;
	}
	public JLabel getLabelTipoDaGraduacao() {
		if (labelTipoDaGraduacao == null) {
			labelTipoDaGraduacao = new JLabel("Tipo da gradua\u00E7\u00E3o");
			labelTipoDaGraduacao.setEnabled(false);
			labelTipoDaGraduacao.setFont(new Font("Arial", Font.PLAIN, 14));
			labelTipoDaGraduacao.setBounds(22, 374, 168, 25);
		}
		return labelTipoDaGraduacao;
	}
	public JFormattedTextField getFormattedTextFieldNomeCurso() {
		if (formattedTextFieldNomeCurso == null) {
			formattedTextFieldNomeCurso = new JFormattedTextField();
			formattedTextFieldNomeCurso.setForeground(Color.BLACK);
			formattedTextFieldNomeCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldNomeCurso.setBounds(23, 56, 425, 25);
		}
		return formattedTextFieldNomeCurso;
	}
	public JComboBox<String> getComboBoxCargaHorariaTotal() {
		if(comboBoxCargaHorariaTotal == null) {
			comboBoxCargaHorariaTotal = new JComboBox<String>();
			comboBoxCargaHorariaTotal.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE"}));
			comboBoxCargaHorariaTotal.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCargaHorariaTotal.setBackground(Color.WHITE);
			comboBoxCargaHorariaTotal.setBounds(22, 131, 202, 25);
			comboBoxCargaHorariaTotal.setVisible(true);
			int i = 1500;
			while(i <= 5000) {
				comboBoxCargaHorariaTotal.addItem(String.valueOf(i));
				i = i + 50;
			}
		}
		return comboBoxCargaHorariaTotal;
	}
	public JComboBox<String> getComboBoxHorario() {
		if (comboBoxHorario == null) {
			comboBoxHorario = new JComboBox<String>();
			comboBoxHorario.setBackground(Color.WHITE);
			comboBoxHorario.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxHorario.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE", "MATUTINO", "VESPERTINO", "NOTURNO", "INTEGRAL"}));
			comboBoxHorario.setBounds(23, 263, 201, 25);
		}
		return comboBoxHorario;
	}
	
	public JComboBox<String> getComboBoxSemestresTotais() {
		if (comboBoxSemestresTotais == null) {
			comboBoxSemestresTotais = new JComboBox<String>();
			comboBoxSemestresTotais.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxSemestresTotais.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE", 
					"4", "5","6","7", "8", "9", "10","11", "12"}));
			comboBoxSemestresTotais.setBounds(22, 195, 202, 25);
			comboBoxSemestresTotais.setBackground(Color.WHITE);
		}
		return comboBoxSemestresTotais;
	}
	
	public JComboBox<String> getComboBoxTipoCurso() {
		if (comboBoxTipoCurso == null) {
			comboBoxTipoCurso = new JComboBox<String>();
			comboBoxTipoCurso.setBackground(Color.WHITE);
			comboBoxTipoCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxTipoCurso.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE", "GRADUA\u00C7\u00C3O", "ESPECIALIZA\u00C7\u00C3O", "MESTRADO", "DOUTORADO"}));
			comboBoxTipoCurso.setBounds(23, 334, 201, 25);
		}
		return comboBoxTipoCurso;
	}
	public JComboBox<String> getComboBoxTipoGraduacao() {
		if (comboBoxTipoGraduacao == null) {
			comboBoxTipoGraduacao = new JComboBox<String>();
			comboBoxTipoGraduacao.setEnabled(false);
			comboBoxTipoGraduacao.setBackground(Color.WHITE);
			comboBoxTipoGraduacao.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxTipoGraduacao.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE", "LICENCIATURA", "BACHARELADO"}));
			comboBoxTipoGraduacao.setBounds(22, 399, 202, 25);
		}
		return comboBoxTipoGraduacao;
	}
	public JButton getButtonVoltar() {
		if(buttonVoltar == null) {
			buttonVoltar = new JButton("VOLTAR");
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonVoltar.setBounds(54, 631, 130, 35);
			buttonVoltar.setBackground(Color.WHITE);
			buttonVoltar.setVisible(true);
		}
		return buttonVoltar;
	}

	public JButton getButtonCancelar() {
		if(buttonCancelar == null) {
			buttonCancelar = new JButton("CANCELAR");
			buttonCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonCancelar.setBounds(211, 631, 130, 35);
			buttonCancelar.setBackground(Color.WHITE);
			buttonCancelar.setVisible(true);
		}
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		if(buttonConfirmar == null) {
			buttonConfirmar = new JButton("CONFIRMAR");
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonConfirmar.setBounds(370, 631, 130, 35);
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setVisible(true);
		}
		return buttonConfirmar;
	}
	
}
