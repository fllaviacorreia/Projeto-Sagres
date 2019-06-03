package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.*;
import javax.swing.*;

import modelo.FormataMascaras;


public class VisaoPainelCadastroDisciplina extends JPanel{

	private JLabel 			 	labelAreaDisciplina 		  	= null;
	private JLabel 			 	labelNomeDisciplina 		  	= null;
	private JLabel 		 		labelSemestre 					= null;
	private JLabel 		 		labelCurso 						= null;
	private JLabel 		 		labelPreRequisitos 				= null;
	private JLabel 		 		labelCargaHorariaDisciplina 	= null;
	private JComboBox<String> 	comboBoxCargaHorariaDisciplina 	= null;
	private JComboBox<String>   comboBoxAreaDisciplina 		  	= null;
	private JComboBox<String>   comboBoxPreRequisitos 		  	= null;
	private JComboBox<String>   comboBoxSemestre 		  		= null;
	private JComboBox<String>   comboBoxCurso 		  			= null;
	private JFormattedTextField textFieldNomeDisciplina 	    = null;
	private JRadioButton 		radioButtonPreRequisitos 		= null;
	private JRadioButton 		radioButtonTeorica 				= null;
	private JRadioButton 		radioButtonPratica 				= null;
	private JRadioButton 		radioButtonEstagio 				= null;
	private JRadioButton 		radioButtonOptativa 			= null;
	private JRadioButton 		radioButtonEPreRequisito		= null;
//	private ButtonGroup  		radioButtonTipoDisciplina 		= null;
	private JButton 	 		buttonVoltar 	 		  		= null;
	private JButton 	 		buttonCancelar 	 		  		= null;
	private JButton 			buttonConfirmar   		  		= null;
//	private JButton 			buttonAdicionarSemestre		  	= null;
	private JButton 			buttonAdicionarAreaDisciplina	= null;
//	private JButton 			buttonAdicionarCurso		  	= null;
	private JButton 			buttonAdicionarPreRequisitos	= null;
	
	VisaoFramePrincipal frame;
	FormataMascaras fm = new FormataMascaras();
	private JRadioButton radioButtonObrigatoria;
	
	
	public VisaoPainelCadastroDisciplina() {
		setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1000, 730));
		this.setMaximumSize(new Dimension(1000, 730));
		this.setVisible(true);
		
		this.add(getLabelAreaDisciplina());
		this.add(getLabelNomeDisciplina());
		this.add(getLabelCargaHorariaDisciplina());
		this.add(getLabelCurso());
		this.add(getLabelPreRequisitos());
		this.add(getLabelSemestre());
		this.add(getComboBoxAreaDisciplina());
		this.add(getComboBoxCargaHoraria());
		this.add(getComboBoxSemestre());
		this.add(getComboBoxCurso());
		this.add(getComboBoxPreRequisitos());
		this.add(getTextFieldNomeDisciplina());
		this.add(getRadioButtonTeorica());
		this.add(getRadioButtonPratica());
		this.add(getRadioButtonEstagio());
		this.add(getRadioButtonPreRequisitos());
		this.add(getButtonVoltar());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
//		this.add(getButtonAdicionarSemestre());
		this.add(getButtonAdicionarAreaDisciplina());
//		this.add(getButtonAdicionarCurso());
		this.add(getButtonAdicionarPreRequisitos());
		this.add(getRadioButtonEPreRequisito());
		this.add(getRadioButtonOptativa());
		add(getRadioButtonObrigatoria());
	}
	
	public JLabel getLabelAreaDisciplina() {
		if(labelAreaDisciplina == null) {
			labelAreaDisciplina = new JLabel("\u00C1rea da disciplina:");
			labelAreaDisciplina.setBounds(430, 116, 130, 20);
			labelAreaDisciplina.setForeground(Color.BLACK);
			labelAreaDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			labelAreaDisciplina.setVisible(true);
		}
		return labelAreaDisciplina;
	}
	public JLabel getLabelNomeDisciplina() {
		if(labelNomeDisciplina == null) {
			labelNomeDisciplina = new JLabel("Nome da disciplina:");
			labelNomeDisciplina.setBounds(47, 116, 190, 20);
			labelNomeDisciplina.setForeground(Color.BLACK);
			labelNomeDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNomeDisciplina.setVisible(true);
		}
		return labelNomeDisciplina;
	}
	public JLabel getLabelCargaHorariaDisciplina() {
		if(labelCargaHorariaDisciplina == null) {
			labelCargaHorariaDisciplina = new JLabel("Carga hor\u00E1ria:");
			labelCargaHorariaDisciplina.setBounds(506, 200, 190, 20);
			labelCargaHorariaDisciplina.setForeground(Color.BLACK);
			labelCargaHorariaDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCargaHorariaDisciplina.setVisible(true);
		}
		return labelCargaHorariaDisciplina;
	}

	public JLabel getLabelSemestre() {
		if(labelSemestre == null) {
			labelSemestre = new JLabel("Semestre:");
			labelSemestre.setBounds(430, 32, 105, 20);
			labelSemestre.setForeground(Color.BLACK);
			labelSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
			labelSemestre.setVisible(true);
		}
		return labelSemestre;
	}

	public JLabel getLabelCurso() {
		if(labelCurso == null) {
			labelCurso = new JLabel("Curso:");
			labelCurso.setBounds(47, 32, 190, 20);
			labelCurso.setForeground(Color.BLACK);
			labelCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCurso.setVisible(true);
		}
		return labelCurso;
	}

	public JLabel getLabelPreRequisitos() {
		if(labelPreRequisitos == null) {
			labelPreRequisitos = new JLabel("Pr\u00E9-Requisito(s):");
			labelPreRequisitos.setBounds(47, 200, 130, 20);
			labelPreRequisitos.setForeground(Color.BLACK);
			labelPreRequisitos.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return labelPreRequisitos;
	}

	public JComboBox<String> getComboBoxAreaDisciplina() {
		if(comboBoxAreaDisciplina == null) {
			comboBoxAreaDisciplina = new JComboBox<String>();
			comboBoxAreaDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxAreaDisciplina.setBackground(new Color(255, 255, 255));
			comboBoxAreaDisciplina.setBounds(430, 147, 310, 25);
			comboBoxAreaDisciplina.setVisible(true);
			comboBoxAreaDisciplina.setVisible(true);
		}
		return comboBoxAreaDisciplina;
	}
	
	public JComboBox<String> getComboBoxCargaHoraria() {
		if(comboBoxCargaHorariaDisciplina == null) {
			comboBoxCargaHorariaDisciplina = new JComboBox<String>();
			comboBoxCargaHorariaDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCargaHorariaDisciplina.setBackground(new Color(255, 255, 255));
			comboBoxCargaHorariaDisciplina.setBounds(506, 231, 170, 25);
			comboBoxCargaHorariaDisciplina.addItem("SELECIONE");
			comboBoxCargaHorariaDisciplina.addItem("30");
			comboBoxCargaHorariaDisciplina.addItem("45");
			comboBoxCargaHorariaDisciplina.addItem("60");
			comboBoxCargaHorariaDisciplina.addItem("75");
			comboBoxCargaHorariaDisciplina.addItem("90");
			comboBoxCargaHorariaDisciplina.addItem("105");
			comboBoxCargaHorariaDisciplina.addItem("120");
			comboBoxCargaHorariaDisciplina.addItem("135");
			comboBoxCargaHorariaDisciplina.addItem("150");
			comboBoxCargaHorariaDisciplina.setVisible(true);
		}
		
		return comboBoxCargaHorariaDisciplina;
	}

	public JComboBox<String> getComboBoxPreRequisitos() {
		if(comboBoxPreRequisitos == null) {
			comboBoxPreRequisitos = new JComboBox<String>();
			comboBoxPreRequisitos.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxPreRequisitos.setBackground(new Color(255, 255, 255));
			comboBoxPreRequisitos.setBounds(47, 231, 170, 25);
			comboBoxPreRequisitos.setEnabled(false);
			comboBoxPreRequisitos.addItem("SELECIONE");
		}
		
		return comboBoxPreRequisitos;
	}
	
	public JComboBox<String> getComboBoxSemestre() {
		if(comboBoxSemestre == null) {
			comboBoxSemestre = new JComboBox<String>();
			comboBoxSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxSemestre.setBackground(new Color(255, 255, 255));
			comboBoxSemestre.setBounds(430, 63, 130, 25);
			comboBoxSemestre.addItem("SELECIONE");
			comboBoxSemestre.setVisible(true);
		}
		return comboBoxSemestre;
	}
	
	public JComboBox<String> getComboBoxCurso() {
		if(comboBoxCurso == null) {
			comboBoxCurso = new JComboBox<String>();
			comboBoxCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCurso.setBackground(new Color(255, 255, 255));
			comboBoxCurso.setBounds(47, 63, 289, 25);
			comboBoxCurso.setVisible(true);
		}
		return comboBoxCurso;
	}
	
	public JFormattedTextField getTextFieldNomeDisciplina() {
		if(textFieldNomeDisciplina == null) {
			textFieldNomeDisciplina = new JFormattedTextField();
			textFieldNomeDisciplina.setFormatterFactory(fm.getNome());
			textFieldNomeDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldNomeDisciplina.setBounds(47, 147, 310, 25);
			textFieldNomeDisciplina.setVisible(true);
			textFieldNomeDisciplina.setVisible(true);
		}
		
		return textFieldNomeDisciplina;
	}
	
	public JRadioButton getRadioButtonPreRequisitos() {
		if(radioButtonPreRequisitos == null) {
			radioButtonPreRequisitos = new JRadioButton("Possui pr\u00E9-requisito(s)");
			radioButtonPreRequisitos.setFont(new Font("Arial", Font.PLAIN, 14));
			radioButtonPreRequisitos.setBackground(new Color(66, 179, 165));
			radioButtonPreRequisitos.setVisible(true);
			radioButtonPreRequisitos.setBounds(194, 200, 190, 20);
		}
		return radioButtonPreRequisitos;
	}

	public JRadioButton getRadioButtonTeorica() {
		if(radioButtonTeorica == null) {
			radioButtonTeorica = new JRadioButton("Teórica");
			radioButtonTeorica.setForeground(Color.BLACK);
			radioButtonTeorica.setFont(new Font("Arial", Font.PLAIN, 14));
			radioButtonTeorica.setBackground(new Color(120, 205, 194));
			radioButtonTeorica.setSelected(true);
			radioButtonTeorica.setEnabled(false);
			radioButtonTeorica.setVisible(true);
			radioButtonTeorica.setBounds(249, 301, 87, 20);
		}
		return radioButtonTeorica;
	}
	
	public JRadioButton getRadioButtonPratica() {
		if(radioButtonPratica == null) {
			radioButtonPratica = new JRadioButton("Prática");
			radioButtonPratica.setForeground(Color.BLACK);
			radioButtonPratica.setFont(new Font("Arial", Font.PLAIN, 14));
			radioButtonPratica.setBackground(new Color(120, 205, 194));
			radioButtonPratica.setVisible(true);
			radioButtonPratica.setBounds(249, 324, 87, 20);
		}
		return radioButtonPratica;
	}
	public JRadioButton getRadioButtonEstagio() {
		if(radioButtonEstagio == null) {
			radioButtonEstagio = new JRadioButton("Estágio");
			radioButtonEstagio.setForeground(Color.BLACK);
			radioButtonEstagio.setFont(new Font("Arial", Font.PLAIN, 14));
			radioButtonEstagio.setBackground(new Color(120, 205, 194));
			radioButtonEstagio.setVisible(true);
			radioButtonEstagio.setBounds(249, 347, 87, 20);
		}
		return radioButtonEstagio;
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
			buttonCancelar.setBounds(227, 631, 117, 33);
			buttonCancelar.setBackground(Color.WHITE);
			buttonCancelar.setVisible(true);
		}
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		if(buttonConfirmar == null) {
			buttonConfirmar = new JButton("CONFIRMAR");
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonConfirmar.setBounds(387, 631, 117, 33);
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setVisible(true);
		}
		return buttonConfirmar;
	}
//	public JButton getButtonAdicionarSemestre() {
//		if(buttonAdicionarSemestre == null) {
//			buttonAdicionarSemestre = new JButton("Adicionar semestre");
//			buttonAdicionarSemestre.setHorizontalAlignment(SwingConstants.LEFT);
//			buttonAdicionarSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
//			buttonAdicionarSemestre.setBounds(703, 63, 162, 20);
//			buttonAdicionarSemestre.setBackground(Color.WHITE);
//			buttonAdicionarSemestre.setVisible(true);
//		}
//		return buttonAdicionarSemestre;
//	}
	
	public JButton getButtonAdicionarAreaDisciplina() {
		if(buttonAdicionarAreaDisciplina == null) {
			buttonAdicionarAreaDisciplina = new JButton("Adicionar área");
			buttonAdicionarAreaDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarAreaDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonAdicionarAreaDisciplina.setBounds(775, 147, 141, 20);
			buttonAdicionarAreaDisciplina.setBackground(Color.WHITE);
			buttonAdicionarAreaDisciplina.setVisible(true);
		}
		return buttonAdicionarAreaDisciplina;
	}
//	public JButton getButtonAdicionarCurso() {
//		if(buttonAdicionarCurso == null) {
//			buttonAdicionarCurso = new JButton("Adicionar curso");
//			buttonAdicionarCurso.setHorizontalAlignment(SwingConstants.LEFT);
//			buttonAdicionarCurso.setFont(new Font("Arial", Font.PLAIN, 14));
//			buttonAdicionarCurso.setBounds(363, 63, 141, 20);
//			buttonAdicionarCurso.setBackground(Color.WHITE);
//			buttonAdicionarCurso.setVisible(true);
//		}
//		return buttonAdicionarCurso;
//	}
	public JButton getButtonAdicionarPreRequisitos() {
		if(buttonAdicionarPreRequisitos == null) {
			buttonAdicionarPreRequisitos = new JButton("Adicionar pré-requisito");
			buttonAdicionarPreRequisitos.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarPreRequisitos.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonAdicionarPreRequisitos.setBounds(267, 231, 183, 20);
			buttonAdicionarPreRequisitos.setBackground(Color.WHITE);
			buttonAdicionarPreRequisitos.setEnabled(false);
			buttonAdicionarPreRequisitos.setVisible(true);
		}
		return buttonAdicionarPreRequisitos;
	}
	public JRadioButton getRadioButtonEPreRequisito() {
		if (radioButtonEPreRequisito == null) {
			radioButtonEPreRequisito = new JRadioButton("\u00C9 pr\u00E9-requisito");
			radioButtonEPreRequisito.setForeground(Color.BLACK);
			radioButtonEPreRequisito.setFont(new Font("Arial", Font.PLAIN, 14));
			radioButtonEPreRequisito.setBounds(47, 298, 141, 23);
			radioButtonEPreRequisito.setBackground(new Color(120, 205, 194));
		}
		return radioButtonEPreRequisito;
	}

//	public ButtonGroup getButtonGroupTipoDisciplina() {
//		if(radioButtonTipoDisciplina  == null) {
//			radioButtonTipoDisciplina = new ButtonGroup();
//			radioButtonTipoDisciplina.add(getRadioButtonObrigatoria());
//			radioButtonTipoDisciplina.add(getRadioButtonOptativa());
//		}
//		return radioButtonTipoDisciplina;
//	}

	
	public JRadioButton getRadioButtonOptativa() {
		if(radioButtonOptativa  == null) {
			radioButtonOptativa = new JRadioButton("Optativa");
			radioButtonOptativa.setForeground(Color.BLACK);
			radioButtonOptativa.setSize(94, 20);
			radioButtonOptativa.setLocation(47, 347);
			radioButtonOptativa.setFont(new Font("Arial", Font.PLAIN, 14));
			radioButtonOptativa.setBackground(new Color(120, 205, 194));
			radioButtonOptativa.setVisible(true);
		}
		return radioButtonOptativa;
	}
	public JRadioButton getRadioButtonObrigatoria() {
		if (radioButtonObrigatoria == null) {
			radioButtonObrigatoria = new JRadioButton("Obrigat\u00F3ria");
			radioButtonObrigatoria.setForeground(Color.BLACK);
			radioButtonObrigatoria.setSize(109, 20);
			radioButtonObrigatoria.setLocation(47, 324);
			radioButtonObrigatoria.setFont(new Font("Arial", Font.PLAIN, 14));
			radioButtonObrigatoria.setBackground(new Color(120, 205, 194));
			radioButtonObrigatoria.setVisible(true);
		}
		return radioButtonObrigatoria;
	}
}
