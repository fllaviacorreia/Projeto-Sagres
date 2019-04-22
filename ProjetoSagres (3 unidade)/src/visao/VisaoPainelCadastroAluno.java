package visao;

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

import modelo.validacao.FormataMascaras;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

//import com.toedter.calendar.JDateChooser;

public class VisaoPainelCadastroAluno extends JPanel{

	private JLabel 				labelNomeAluno 	 				= null;
	private JLabel 				labelMatriculaAluno 			= null;
	private JLabel 				labelCurso 	 					= null;
	private JLabel 				labelHistoricoDisciplinas 	 	= null;
	private JLabel 				labelCpf 	 					= null;
	private JLabel 				labelRg 	 					= null;
	private JLabel 				labelOrgaoExpeditor				= null;
	private JLabel 				labelDataDeExpedicao			= null;
	private JLabel 				labelDataDeNascimento			= null;
	private JLabel   			labelEstadoRg  					= null;
	private JLabel   			labelDadosPessoais				= null;
	private JLabel    			labelEndereco					= null;
	private JLabel    			labelRua						= null;
	private JLabel    			labelNumero						= null;
	private JLabel    			labelComplemento				= null;
	private JLabel    			labelBairro						= null;
	private JLabel    			labelCidade						= null;
	private JLabel    			labelEstadoEndereco				= null;
	private JFormattedTextField textFieldNomeAluno 	 			= null;
	private JFormattedTextField	textFieldMatriculaAluno			= null;
	private JFormattedTextField textFieldCpf					= null;
	private JFormattedTextField textFieldRg						= null;
	private JFormattedTextField formattedTextFieldDataRg		= null;
	private JFormattedTextField formattedTextFieldDataNascimento= null;
	private JFormattedTextField textFieldOrgaoExpeditor			= null;
	private JFormattedTextField formattedTextFieldRua			= null;
	private JFormattedTextField formattedTextFieldNumero		= null;
	private JFormattedTextField formattedTextFieldComplemento	= null;
	private JFormattedTextField formattedTextFieldBairro		= null;
	private JFormattedTextField formattedTextFieldCidade		= null;
	private JComboBox<String>   comboBoxCurso					= null;
	private JComboBox<String>   comboBoxHistoricoDisciplinas	= null;
	private JComboBox<String> 	comboBoxEstadoEndereco			= null;
	private JComboBox<String> 	comboBoxEstadoRg				= null;
	private JButton 			buttonVoltar 	 				= null;
	private JButton 			buttonCancelar 	 				= null;
	private JButton 			buttonConfirmar   				= null;
	private JButton 			buttonAdicionarDisciplina  		= null;
	
	FormataMascaras formatacao = new FormataMascaras();
	
	
	public VisaoPainelCadastroAluno() {
		setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getLabelNomeAluno());
		this.add(getLabelMatriculaAluno());
		this.add(getLabelCurso());
		this.add(getLabelHistoricoDisciplinas());
		this.add(getLabelCpf());
		this.add(getLabelRg());
		this.add(getLabelOrgaoExpeditor());
		this.add(getLabelEstadoRg());
		this.add(getLabelDataDeExpedicao());
		this.add(getLabelDataDeNascimento());
		this.add(getLabelDadosPessoais());
		this.add(getLabelEndereco());
		this.add(getLabelRua());
		this.add(getLabelNumero());
		this.add(getLabelComplemento());
		this.add(getLabelBairro());
		this.add(getLabelCidade());
		this.add(getLblEstado());
		this.add(getFormattedTextFieldMatriculaAluno());
		this.add(getFormattedTextFieldNomeAluno());
		this.add(getFormattedTextFieldCpf());
		this.add(getFormattedTextFieldRg());
		this.add(getFormattedTextFieldDataRg());
		this.add(getFormattedTextFieldDataNascimento());
		this.add(getFormattedTextFieldOrgaoExpeditor());
		this.add(getFormattedTextFieldRua());
		this.add(getFormattedTextFieldNumero());
		this.add(getFormattedTextFieldComplemento());
		this.add(getFormattedTextFieldBairro());
		this.add(getFormattedTextFieldCidade());
		this.add(getComboBoxCurso());
		this.add(getComboBoxHistoricoDisciplinas());
		this.add(getComboBoxEstadoRg());
		this.add(getComboBoxEstadoEndereco());
		this.add(getButtonVoltar());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonAdicionarDisciplina());
		
	}
	
	public JLabel getLabelNomeAluno() {
		if(labelNomeAluno == null) {
			labelNomeAluno = new JLabel("Nome:");
			labelNomeAluno.setBounds(22, 38, 48, 25);
			labelNomeAluno.setForeground(Color.BLACK);
			labelNomeAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNomeAluno.setVisible(true);
		}
		return labelNomeAluno;
	}

	public JLabel getLabelMatriculaAluno() {
		if(labelMatriculaAluno == null) {
			labelMatriculaAluno = new JLabel("Número de matrícula:");
			labelMatriculaAluno.setBounds(364, 190, 144, 25);
			labelMatriculaAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			labelMatriculaAluno.setForeground(Color.BLACK);
			labelMatriculaAluno.setVisible(true);
		}
		return labelMatriculaAluno;
	}

	public JLabel getLabelCpf() {
		if(labelCpf == null) {
			labelCpf = new JLabel("CPF:");
			labelCpf.setBounds(22, 112, 38, 25);
			labelCpf.setForeground(Color.BLACK);
			labelCpf.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCpf.setVisible(true);
		}
		return labelCpf;
	}

	public JLabel getLabelRg() {
		if(labelRg == null) {
			labelRg = new JLabel("RG:");
			labelRg.setBounds(184, 112, 38, 25);
			labelRg.setForeground(Color.BLACK);
			labelRg.setFont(new Font("Arial", Font.PLAIN, 14));
			labelRg.setVisible(true);
		}
		return labelRg;
	}

	public JLabel getLabelCurso() {
		if(labelCurso == null) {
			labelCurso = new JLabel("Curso:");
			labelCurso.setBounds(22, 190, 70, 25);
			labelCurso.setForeground(Color.BLACK);
			labelCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCurso.setVisible(true);
		}
		return labelCurso;
	}

	public JLabel getLabelHistoricoDisciplinas() {
		if(labelHistoricoDisciplinas == null) {
			labelHistoricoDisciplinas = new JLabel("Disciplinas já cursadas:");
			labelHistoricoDisciplinas.setBounds(22, 270, 167, 25);
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
			labelOrgaoExpeditor.setBounds(346, 112, 115, 25);
			labelOrgaoExpeditor.setForeground(Color.BLACK);
			labelOrgaoExpeditor.setVisible(true);
		}
		return labelOrgaoExpeditor;
	}
	public JLabel getLabelEstadoRg() {
		if(labelEstadoRg == null) {
			labelEstadoRg = new JLabel("Estado:");
			labelEstadoRg.setFont(new Font("Arial", Font.PLAIN, 14));
			labelEstadoRg.setBounds(565, 112, 83, 25);
			labelEstadoRg.setForeground(Color.BLACK);
			labelEstadoRg.setVisible(true);
		}
		return labelEstadoRg;
	}
	public JFormattedTextField getFormattedTextFieldNomeAluno() {
		if(textFieldNomeAluno == null) {
			textFieldNomeAluno = new JFormattedTextField();
			textFieldNomeAluno.setBackground(Color.WHITE);
			textFieldNomeAluno.setFormatterFactory(formatacao.getNome());
			textFieldNomeAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldNomeAluno.setBounds(22, 62, 470, 22);
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
			textFieldMatriculaAluno.setBounds(364, 215, 144, 22);
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
			textFieldCpf.setBounds(22, 136, 144, 22);
			textFieldCpf.setVisible(true);
		}
		return textFieldCpf;
	}

	public JFormattedTextField getFormattedTextFieldRg() {
		if(textFieldRg == null) {
			textFieldRg = new JFormattedTextField();
			textFieldRg.setBackground(Color.WHITE);
			textFieldRg.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldRg.setBounds(184, 136, 152, 22);
			textFieldRg.setVisible(true);
		}
		return textFieldRg;
	}

	public JComboBox<String> getComboBoxCurso() {
		if(comboBoxCurso == null) {
			comboBoxCurso = new JComboBox<String>();
			comboBoxCurso.setBackground(Color.WHITE);
			comboBoxCurso.setBounds(22, 215, 309, 22);
			comboBoxCurso.setFont(new Font("Arial", Font.PLAIN, 14));			
			
		}
		return comboBoxCurso;
	}

	public JComboBox<String> getComboBoxHistoricoDisciplinas() {
		if(comboBoxHistoricoDisciplinas == null) {
			comboBoxHistoricoDisciplinas = new JComboBox<String>();
			comboBoxHistoricoDisciplinas.setBackground(Color.WHITE);
			comboBoxHistoricoDisciplinas.setBounds(22, 294, 309, 22);
			comboBoxHistoricoDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));			
		}
		return comboBoxHistoricoDisciplinas;
	}
	
	public JComboBox<String> getComboBoxEstadoRg() {
		if(comboBoxEstadoRg == null) {
			comboBoxEstadoRg = new JComboBox<String>();
			comboBoxEstadoRg.setBackground(Color.WHITE);
			comboBoxEstadoRg.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxEstadoRg.setModel(new DefaultComboBoxModel<String>(
									new String[] {"SELECIONE", "AC", "AL", "AM", "AP", "BA", "CE", 
											"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", 
											"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoRg.setBounds(564, 136, 104, 22);
		}
		return comboBoxEstadoRg;
	}

	public JButton getButtonVoltar() {
		if(buttonVoltar == null) {
			buttonVoltar = new JButton("VOLTAR");
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonVoltar.setBounds(22, 640, 130, 33);
			buttonVoltar.setBackground(Color.WHITE);
			buttonVoltar.setVisible(true);
		}
		return buttonVoltar;
	}

	public JButton getButtonCancelar() {
		if(buttonCancelar == null) {
			buttonCancelar = new JButton("CANCELAR");
			buttonCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonCancelar.setBounds(184, 640, 130, 33);
			buttonCancelar.setBackground(Color.WHITE);
			buttonCancelar.setVisible(true);
		}
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		if(buttonConfirmar == null) {
			buttonConfirmar = new JButton("CONFIRMAR");
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonConfirmar.setBounds(344, 640, 130, 33);
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setVisible(true);
		}
		return buttonConfirmar;
	}

	public JButton getButtonAdicionarDisciplina() {
		if(buttonAdicionarDisciplina == null) {
			buttonAdicionarDisciplina = new JButton("Adicionar disciplina");
			buttonAdicionarDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarDisciplina.setFont(new Font("Arial", Font.PLAIN, 13));
			buttonAdicionarDisciplina.setBounds(373, 294, 152, 20);
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
			labelDataDeExpedicao.setBounds(679, 112, 123, 25);
		}
		return labelDataDeExpedicao;
	}
	public JLabel getLabelDataDeNascimento() {
		if (labelDataDeNascimento == null) {
			labelDataDeNascimento = new JLabel("Data de Nascimento:");
			labelDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDataDeNascimento.setBounds(532, 38, 196, 25);
		}
		return labelDataDeNascimento;
	}
	public JFormattedTextField getFormattedTextFieldDataRg() {
		if (formattedTextFieldDataRg == null) {
			formattedTextFieldDataRg = new JFormattedTextField(formatacao.getData());
			formattedTextFieldDataRg.setBounds(679, 136, 123, 22);
		}
		return formattedTextFieldDataRg;
	}
	public JFormattedTextField getFormattedTextFieldDataNascimento() {
		if (formattedTextFieldDataNascimento == null) {
			formattedTextFieldDataNascimento = new JFormattedTextField(formatacao.getData());
			formattedTextFieldDataNascimento.setBounds(532, 63, 123, 22);
		}
		return formattedTextFieldDataNascimento;
	}
	public JLabel getLabelDadosPessoais() {
		if (labelDadosPessoais == null) {
			labelDadosPessoais = new JLabel("  Dados Pessoais");
			labelDadosPessoais.setBorder(new LineBorder(Color.BLACK, 2));
			labelDadosPessoais.setFont(new Font("Arial", Font.PLAIN, 19));
			labelDadosPessoais.setBounds(0, 0, 1026, 30);
		}
		return labelDadosPessoais;
	}
	public JLabel getLabelEndereco() {
		if (labelEndereco == null) {
			labelEndereco = new JLabel("  Endere\u00E7o");
			labelEndereco.setBorder(new LineBorder(Color.BLACK, 2));
			labelEndereco.setFont(new Font("Arial", Font.PLAIN, 19));
			labelEndereco.setBounds(0, 355, 1026, 30);
		}
		return labelEndereco;
	}
	public JFormattedTextField getFormattedTextFieldOrgaoExpeditor() {
		if (textFieldOrgaoExpeditor == null) {
			textFieldOrgaoExpeditor = new JFormattedTextField();
			textFieldOrgaoExpeditor.setFormatterFactory(formatacao.getNome());
			textFieldOrgaoExpeditor.setBounds(344, 136, 210, 22);
			textFieldOrgaoExpeditor.setColumns(10);
		}
		return textFieldOrgaoExpeditor;
	}
	public JLabel getLabelRua() {
		if (labelRua == null) {
			labelRua = new JLabel("Rua:");
			labelRua.setFont(new Font("Arial", Font.PLAIN, 14));
			labelRua.setBounds(22, 396, 46, 25);
		}
		return labelRua;
	}
	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00FAmero:");
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNumero.setBounds(415, 396, 104, 25);
		}
		return labelNumero;
	}
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 14));
			labelComplemento.setBounds(532, 396, 103, 25);
		}
		return labelComplemento;
	}
	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:");
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 14));
			labelBairro.setBounds(22, 479, 46, 25);
		}
		return labelBairro;
	}
	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:");
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCidade.setBounds(285, 479, 130, 25);
		}
		return labelCidade;
	}
	public JLabel getLblEstado() {
		if (labelEstadoEndereco == null) {
			labelEstadoEndereco = new JLabel("Estado:");
			labelEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
			labelEstadoEndereco.setBounds(571, 479, 123, 25);
		}
		return labelEstadoEndereco;
	}
	public JFormattedTextField getFormattedTextFieldRua() {
		if (formattedTextFieldRua == null) {
			formattedTextFieldRua = new JFormattedTextField();
			formattedTextFieldRua.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldRua.setFormatterFactory(formatacao.getEndereco());
			formattedTextFieldRua.setBounds(22, 421, 360, 22);
		}
		return formattedTextFieldRua;
	}
	public JFormattedTextField getFormattedTextFieldNumero() {
		if (formattedTextFieldNumero == null) {
			formattedTextFieldNumero = new JFormattedTextField();
			formattedTextFieldNumero.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldNumero.setFormatterFactory(formatacao.getEndereco());
			formattedTextFieldNumero.setBounds(415, 421, 86, 22);
		}
		return formattedTextFieldNumero;
	}
	public JFormattedTextField getFormattedTextFieldComplemento() {
		if (formattedTextFieldComplemento == null) {
			formattedTextFieldComplemento = new JFormattedTextField();
			formattedTextFieldComplemento.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldComplemento.setFormatterFactory(formatacao.getEndereco());
			formattedTextFieldComplemento.setBounds(532, 421, 309, 22);
		}
		return formattedTextFieldComplemento;
	}
	public JFormattedTextField getFormattedTextFieldBairro() {
		if (formattedTextFieldBairro == null) {
			formattedTextFieldBairro = new JFormattedTextField();
			formattedTextFieldBairro.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldBairro.setFormatterFactory(formatacao.getEndereco());
			formattedTextFieldBairro.setBounds(22, 504, 237, 22);
		}
		return formattedTextFieldBairro;
	}
	public JFormattedTextField getFormattedTextFieldCidade() {
		if (formattedTextFieldCidade == null) {
			formattedTextFieldCidade = new JFormattedTextField();
			formattedTextFieldCidade.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldCidade.setBounds(285, 504, 257, 22);
		}
		return formattedTextFieldCidade;
	}
	public JComboBox<String> getComboBoxEstadoEndereco() {
		if (comboBoxEstadoEndereco == null) {
			comboBoxEstadoEndereco = new JComboBox();
			comboBoxEstadoEndereco.setBackground(Color.WHITE);
			comboBoxEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxEstadoEndereco.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "AC", "AL", "AM", "AP", 
					"BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", 
					"RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoEndereco.setBounds(571, 504, 115, 22);
		}
		return comboBoxEstadoEndereco;
	}
}
