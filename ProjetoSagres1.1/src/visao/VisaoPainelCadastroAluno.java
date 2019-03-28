package visao;

import controle.FormataMascaras;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

//import com.toedter.calendar.JDateChooser;

public class VisaoPainelCadastroAluno extends JPanel{

	private JLabel 				labelNomeAluno 	 				= null;
	private JLabel 				labelMatriculaAluno 			= null;
	private JLabel 				labelCpf 	 					= null;
	private JLabel 				labelRg 	 					= null;
	private JLabel 				labelCurso 	 					= null;
	private JLabel 				labelHistoricoDisciplinas 	 	= null;
	private JLabel 				labelOrgaoExpeditor				= null;
	private JLabel   			labelUf  						= null;
	private JFormattedTextField textFieldNomeAluno 	 			= null;
	private JFormattedTextField	textFieldMatriculaAluno			= null;
	private JFormattedTextField textFieldCpf					= null;
	private JFormattedTextField textFieldRg						= null;
	private JComboBox<String>   comboBoxCurso					= null;
	private JComboBox<String>   comboBoxHistoricoDisciplinas	= null;
	private JComboBox<String>	comboBoxOrgaoExpeditor			= null;
	private JComboBox<String> 	comboBoxEstado					= null;
	private JButton 			buttonVoltar 	 				= null;
	private JButton 			buttonCancelar 	 				= null;
	private JButton 			buttonConfirmar   				= null;
	private JButton 			buttonAdicionarDisciplina  		= null;
	private DateFormat data;
//	private JDateChooser  		dateChooserData				 	= null;
	FormataMascaras formatacao = new FormataMascaras();
	private JLabel labelDataDeExpedicao;
	
	public VisaoPainelCadastroAluno() {
		setLayout(null);
		this.setBackground(new Color(66, 179, 165));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getLabelMatriculaAluno());
		this.add(getLabelNomeAluno());
		this.add(getLabelCpf());
		this.add(getLabelCurso());
		this.add(getLabelHistoricoDisciplinas());
		this.add(getLabelRg());
		this.add(getLabelOrgaoExpeditor());
		this.add(getLabelUf());
		this.add(getFormattedTextFieldMatriculaAluno());
		this.add(getFormattedTextFieldNomeAluno());
		this.add(getFormattedTextFieldCpf());
		this.add(getFormattedTextFieldRg());
		this.add(getComboBoxCurso());
		this.add(getComboBoxHistoricoDisciplinas());
		this.add(getComboBoxOrgaoExpeditor());
		this.add(getComboBoxEstado());
		this.add(getButtonVoltar());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonAdicionarDisciplina());
//		this.add(getDateChooserData());
		add(getLabelDataDeExpedicao());
		
	}
	
	public JLabel getLabelNomeAluno() {
		if(labelNomeAluno == null) {
			labelNomeAluno = new JLabel("Nome:");
			labelNomeAluno.setBounds(53, 34, 48, 15);
			labelNomeAluno.setForeground(Color.BLACK);
			labelNomeAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNomeAluno.setVisible(true);
		}
		return labelNomeAluno;
	}

	public JLabel getLabelMatriculaAluno() {
		if(labelMatriculaAluno == null) {
			labelMatriculaAluno = new JLabel("Número de matrícula:");
			labelMatriculaAluno.setBounds(395, 110, 144, 15);
			labelMatriculaAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			labelMatriculaAluno.setForeground(Color.BLACK);
			labelMatriculaAluno.setVisible(true);
		}
		return labelMatriculaAluno;
	}

	public JLabel getLabelCpf() {
		if(labelCpf == null) {
			labelCpf = new JLabel("CPF:");
			labelCpf.setBounds(53, 262, 38, 14);
			labelCpf.setForeground(Color.BLACK);
			labelCpf.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCpf.setVisible(true);
		}
		return labelCpf;
	}

	public JLabel getLabelRg() {
		if(labelRg == null) {
			labelRg = new JLabel("RG:");
			labelRg.setBounds(188, 262, 38, 14);
			labelRg.setForeground(Color.BLACK);
			labelRg.setFont(new Font("Arial", Font.PLAIN, 14));
			labelRg.setVisible(true);
		}
		return labelRg;
	}

	public JLabel getLabelCurso() {
		if(labelCurso == null) {
			labelCurso = new JLabel("Curso:");
			labelCurso.setBounds(53, 110, 70, 14);
			labelCurso.setForeground(Color.BLACK);
			labelCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCurso.setVisible(true);
		}
		return labelCurso;
	}

	public JLabel getLabelHistoricoDisciplinas() {
		if(labelHistoricoDisciplinas == null) {
			labelHistoricoDisciplinas = new JLabel("Disciplinas já cursadas:");
			labelHistoricoDisciplinas.setBounds(53, 186, 167, 14);
			labelHistoricoDisciplinas.setForeground(Color.BLACK);
			labelHistoricoDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));
			labelHistoricoDisciplinas.setVisible(true);
		}
		return labelHistoricoDisciplinas;
	}
	public JLabel getLabelOrgaoExpeditor() {
		if(labelOrgaoExpeditor == null) {
			labelOrgaoExpeditor = new JLabel("\u00D3rg\u00E3o Expeditor:");
			labelOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelOrgaoExpeditor.setBounds(310, 259, 115, 20);
			labelOrgaoExpeditor.setForeground(Color.BLACK);
			labelOrgaoExpeditor.setVisible(true);
		}
		return labelOrgaoExpeditor;
	}
	public JLabel getLabelUf() {
		if(labelUf == null) {
			labelUf = new JLabel("UF:");
			labelUf.setFont(new Font("Arial", Font.PLAIN, 14));
			labelUf.setBounds(440, 262, 46, 14);
			labelUf.setForeground(Color.BLACK);
			labelUf.setVisible(true);
		}
		return labelUf;
	}
	public JFormattedTextField getFormattedTextFieldNomeAluno() {
		if(textFieldNomeAluno == null) {
			textFieldNomeAluno = new JFormattedTextField();
			textFieldNomeAluno.setBackground(Color.WHITE);
			textFieldNomeAluno.setFormatterFactory(formatacao.getNome());
			textFieldNomeAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldNomeAluno.setBounds(53, 51, 470, 20);
			textFieldNomeAluno.setVisible(true);
		}
		return textFieldNomeAluno;
	}
	
	public JFormattedTextField getFormattedTextFieldMatriculaAluno() {
		if(textFieldMatriculaAluno == null) {
			textFieldMatriculaAluno = new JFormattedTextField();
			textFieldMatriculaAluno.setBackground(Color.WHITE);
			textFieldMatriculaAluno.setFormatterFactory(formatacao.getMatricula());
			textFieldMatriculaAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldMatriculaAluno.setBounds(395, 127, 144, 20);
			textFieldMatriculaAluno.setVisible(true);
			textFieldMatriculaAluno.setEditable(false);
		}
		return textFieldMatriculaAluno;
	}


	public JFormattedTextField getFormattedTextFieldCpf() {
		if(textFieldCpf == null) {
			textFieldCpf = new JFormattedTextField();
			textFieldCpf.setBackground(Color.WHITE);
			textFieldCpf.setFormatterFactory(formatacao.getCPF());
			textFieldCpf.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldCpf.setBounds(53, 278, 112, 20);
			textFieldCpf.setVisible(true);
		}
		return textFieldCpf;
	}

	public JFormattedTextField getFormattedTextFieldRg() {
		if(textFieldRg == null) {
			textFieldRg = new JFormattedTextField();
			textFieldRg.setBackground(Color.WHITE);
			textFieldRg.setFormatterFactory(formatacao.getRG());
			textFieldRg.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldRg.setBounds(188, 278, 112, 20);
			textFieldRg.setVisible(true);
		}
		return textFieldRg;
	}

	public JComboBox<String> getComboBoxCurso() {
		if(comboBoxCurso == null) {
			comboBoxCurso = new JComboBox<String>();
			comboBoxCurso.setBackground(Color.WHITE);
			comboBoxCurso.setBounds(53, 127, 309, 20);
			comboBoxCurso.setFont(new Font("Arial", Font.PLAIN, 14));			
			
		}
		return comboBoxCurso;
	}

	public JComboBox<String> getComboBoxHistoricoDisciplinas() {
		if(comboBoxHistoricoDisciplinas == null) {
			comboBoxHistoricoDisciplinas = new JComboBox<String>();
			comboBoxHistoricoDisciplinas.setBackground(Color.WHITE);
			comboBoxHistoricoDisciplinas.setBounds(53, 203, 309, 20);
			comboBoxHistoricoDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));			
		}
		return comboBoxHistoricoDisciplinas;
	}
	
	public JComboBox<String> getComboBoxOrgaoExpeditor() {
		if(comboBoxOrgaoExpeditor == null) {
			comboBoxOrgaoExpeditor = new JComboBox<String>();
			comboBoxOrgaoExpeditor.setBackground(Color.WHITE);
			comboBoxOrgaoExpeditor.setFont( new Font("Arial", Font.PLAIN, 14));
			comboBoxOrgaoExpeditor.setModel(new DefaultComboBoxModel<String>(
											new String[] {"SELECIONE", "SSP", "Policia Civil"}));
			comboBoxOrgaoExpeditor.setBounds(310, 278, 110, 20);	
		}
		return comboBoxOrgaoExpeditor;
	}
	
	public JComboBox<String> getComboBoxEstado() {
		if(comboBoxEstado == null) {
			comboBoxEstado = new JComboBox<String>();
			comboBoxEstado.setBackground(Color.WHITE);
			comboBoxEstado.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxEstado.setModel(new DefaultComboBoxModel<String>(
									new String[] {"SELECIONE", "AC", "AL", "AM", "AP", "BA", "CE", 
											"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", 
											"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstado.setBounds(435, 278, 88, 20);
		}
		return comboBoxEstado;
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
			buttonCancelar.setBounds(216, 631, 130, 33);
			buttonCancelar.setBackground(Color.WHITE);
			buttonCancelar.setVisible(true);
		}
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		if(buttonConfirmar == null) {
			buttonConfirmar = new JButton("CONFIRMAR");
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonConfirmar.setBounds(376, 631, 130, 33);
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setVisible(true);
		}
		return buttonConfirmar;
	}

	public JButton getButtonAdicionarDisciplina() {
		if(buttonAdicionarDisciplina == null) {
			buttonAdicionarDisciplina = new JButton("Adicionar disciplina");
			buttonAdicionarDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarDisciplina.setFont(new Font("Arial", Font.PLAIN, 11));
			buttonAdicionarDisciplina.setBounds(404, 203, 135, 20);
			buttonAdicionarDisciplina.setBackground(Color.WHITE);
			buttonAdicionarDisciplina.setVisible(true);
		}
		return buttonAdicionarDisciplina;
	}
	
//	public JDateChooser getDateChooserData() {
//		if(dateChooserData == null){
//			dateChooserData = new JDateChooser();
//			dateChooserData.setOpaque(false);
//			dateChooserData.getCalendarButton().setForeground(Color.BLACK);
//			dateChooserData.getCalendarButton().setFont(new Font("Arial", Font.PLAIN, 13));
//			dateChooserData.setBounds(545, 278, 123, 20);
//			dateChooserData.setFont(new Font("Arial", Font.PLAIN, 13));
//			dateChooserData.setForeground(Color.BLACK);
//			dateChooserData.setBackground(new Color(255, 255, 255));
//		}
//		return dateChooserData;
//	}
	public JLabel getLabelDataDeExpedicao() {
		if (labelDataDeExpedicao == null) {
			labelDataDeExpedicao = new JLabel("Data de Expedi\u00E7\u00E3o:");
			labelDataDeExpedicao.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDataDeExpedicao.setBounds(545, 263, 123, 14);
		}
		return labelDataDeExpedicao;
	}
}
