package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

import modelo.FormataMascaras;

@SuppressWarnings("serial")
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
	private JLabel 				labelEmail						= null;
	private JLabel 				labelCep						= null;
	private JLabel 				labelTelefone					= null;
	private JLabel 				labelCelular					= null;
	private JLabel 				labelTipoDoCurso				= null;
	private JTextField 			textFieldEmail					= null;
	private JFormattedTextField formattedTextFieldCep			= null;
	private JFormattedTextField formattedTextFieldTelefone		= null;
	private JFormattedTextField formattedTextFieldNomeAluno 	= null;
	private JFormattedTextField	formattedTextFieldMatriculaAluno= null;
	private JFormattedTextField formattedTextFieldCpf			= null;
	private JFormattedTextField formattedTextFieldRg			= null;
	private JFormattedTextField formattedTextFieldDataRg		= null;
	private JFormattedTextField formattedTextFieldDataNascimento= null;
	private JFormattedTextField formattedTextFieldOrgaoExpeditor= null;
	private JFormattedTextField formattedTextFieldRua			= null;
	private JFormattedTextField formattedTextFieldNumero		= null;
	private JFormattedTextField formattedTextFieldComplemento	= null;
	private JFormattedTextField formattedTextFieldBairro		= null;
	private JFormattedTextField formattedTextFieldCelular		= null;
	private JComboBox<String>   comboBoxCurso					= null;
	private JComboBox<String>   comboBoxHistoricoDisciplinas	= null;
	private JComboBox<String> 	comboBoxEstadoEndereco			= null;
	private JComboBox<String> 	comboBoxEstadoRg				= null;
	private JComboBox<String> 	comboBoxTipoCurso				= null;
	private JComboBox<String> 	comboBoxCidades					= null;
	private JButton 			buttonVoltar 	 				= null;
	private JButton 			buttonCancelar 	 				= null;
	private JButton 			buttonConfirmar   				= null;
	private JButton 			buttonAdicionarDisciplina  		= null;
	FormataMascaras formatacao = new FormataMascaras();
	public VisaoPainelCadastroAluno() {
		this.setLayout(null);
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
		this.add(getLabelEmail());
		this.add(getLabelCep());
		this.add(getLabelTelefone());
		this.add(getLabelCelular());
		this.add(getLabelTipoDoCurso());
		this.add(getTextFieldEmail());
		this.add(getFormattedTextFieldCep());
		this.add(getFormattedTextFieldTelefone());
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
		this.add(getFormattedTextFieldCelular());
		this.add(getComboBoxCurso());
		this.add(getComboBoxHistoricoDisciplinas());
		this.add(getComboBoxEstadoRg());
		this.add(getComboBoxEstadoEndereco());
		this.add(getComboBoxTipoCurso());
		this.add(getButtonVoltar());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonAdicionarDisciplina());
		add(getComboBoxCidades());
		
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
			labelMatriculaAluno.setBounds(779, 189, 144, 25);
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
			labelCurso.setEnabled(false);
			labelCurso.setBounds(198, 269, 70, 25);
			labelCurso.setForeground(Color.BLACK);
			labelCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCurso.setVisible(true);
		}
		return labelCurso;
	}

	public JLabel getLabelHistoricoDisciplinas() {
		if(labelHistoricoDisciplinas == null) {
			labelHistoricoDisciplinas = new JLabel("Disciplinas já cursadas:");
			labelHistoricoDisciplinas.setBounds(523, 269, 167, 25);
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

	public JLabel getLabelTipoDoCurso() {
		if (labelTipoDoCurso == null) {
			labelTipoDoCurso = new JLabel("Tipo do Curso:");
			labelTipoDoCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelTipoDoCurso.setBounds(22, 271, 119, 23);
		}
		return labelTipoDoCurso;
	}

	public JLabel getLabelDataDeExpedicao() {
		if (labelDataDeExpedicao == null) {
			labelDataDeExpedicao = new JLabel("Data de Expedi\u00E7\u00E3o: (DD/MM/AAAA)");
			labelDataDeExpedicao.setForeground(Color.BLACK);
			labelDataDeExpedicao.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDataDeExpedicao.setBounds(679, 112, 244, 25);
		}
		return labelDataDeExpedicao;
	}

	public JLabel getLabelDataDeNascimento() {
		if (labelDataDeNascimento == null) {
			labelDataDeNascimento = new JLabel("Data de Nascimento: \r\n(DD/MM/AAAA)");
			labelDataDeNascimento.setForeground(Color.BLACK);
			labelDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDataDeNascimento.setBounds(532, 38, 309, 25);
		}
		return labelDataDeNascimento;
	}
	
	public JLabel getLabelDadosPessoais() {
		if (labelDadosPessoais == null) {
			labelDadosPessoais = new JLabel("  Dados Pessoais");
			labelDadosPessoais.setBorder(new LineBorder(Color.BLACK, 2));
			labelDadosPessoais.setFont(new Font("Arial", Font.PLAIN, 19));
			labelDadosPessoais.setBounds(0, 0, 1009, 30);
		}
		return labelDadosPessoais;
	}
	
	public JLabel getLabelEndereco() {
		if (labelEndereco == null) {
			labelEndereco = new JLabel("  Endere\u00E7o");
			labelEndereco.setBorder(new LineBorder(Color.BLACK, 2));
			labelEndereco.setFont(new Font("Arial", Font.PLAIN, 19));
			labelEndereco.setBounds(0, 355, 1009, 30);
		}
		return labelEndereco;
	}
	
	public JLabel getLabelRua() {
		if (labelRua == null) {
			labelRua = new JLabel("Rua:");
			labelRua.setForeground(Color.BLACK);
			labelRua.setFont(new Font("Arial", Font.PLAIN, 14));
			labelRua.setBounds(22, 396, 46, 25);
		}
		return labelRua;
	}

	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00FAmero:");
			labelNumero.setForeground(Color.BLACK);
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNumero.setBounds(415, 396, 104, 25);
		}
		return labelNumero;
	}

	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 14));
			labelComplemento.setBounds(532, 396, 103, 25);
		}
		return labelComplemento;
	}

	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:");
			labelBairro.setForeground(Color.BLACK);
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 14));
			labelBairro.setBounds(22, 479, 46, 25);
		}
		return labelBairro;
	}

	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:");
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCidade.setBounds(421, 479, 130, 25);
		}
		return labelCidade;
	}

	public JLabel getLblEstado() {
		if (labelEstadoEndereco == null) {
			labelEstadoEndereco = new JLabel("Estado:");
			labelEstadoEndereco.setForeground(Color.BLACK);
			labelEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
			labelEstadoEndereco.setBounds(284, 481, 123, 25);
		}
		return labelEstadoEndereco;
	}

	public JLabel getLabelCep() {
		if (labelCep == null) {
			labelCep = new JLabel("CEP:");
			labelCep.setForeground(Color.BLACK);
			labelCep.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCep.setBounds(710, 479, 46, 25);
		}
		return labelCep;
	}

	public JLabel getLabelEmail() {
		if (labelEmail == null) {
			labelEmail = new JLabel("E-mail:");
			labelEmail.setForeground(Color.BLACK);
			labelEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			labelEmail.setBounds(22, 187, 46, 25);
		}
		return labelEmail;
	}

	public JLabel getLabelTelefone() {
		if (labelTelefone == null) {
			labelTelefone = new JLabel("Telefone:");
			labelTelefone.setForeground(Color.BLACK);
			labelTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
			labelTelefone.setBounds(346, 187, 128, 25);
		}
		return labelTelefone;
	}

	public JLabel getLabelCelular() {
		if (labelCelular == null) {
			labelCelular = new JLabel("Celular:");
			labelCelular.setForeground(Color.BLACK);
			labelCelular.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCelular.setBounds(573, 187, 128, 25);
		}
		return labelCelular;
	}

	public JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setForeground(Color.BLACK);
			textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldEmail.setBounds(22, 214, 309, 22);
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}
	
	public JFormattedTextField getFormattedTextFieldNomeAluno() {
		if(formattedTextFieldNomeAluno == null) {
			formattedTextFieldNomeAluno = new JFormattedTextField();
			formattedTextFieldNomeAluno.setForeground(Color.BLACK);
			formattedTextFieldNomeAluno.setBackground(Color.WHITE);
			formattedTextFieldNomeAluno.setFormatterFactory(formatacao.getNome());
			formattedTextFieldNomeAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldNomeAluno.setBounds(22, 62, 470, 22);
			formattedTextFieldNomeAluno.setVisible(true);
		}
		return formattedTextFieldNomeAluno;
	}
	
	public JFormattedTextField getFormattedTextFieldMatriculaAluno() {
		if(formattedTextFieldMatriculaAluno == null) {
			formattedTextFieldMatriculaAluno = new JFormattedTextField();
			formattedTextFieldMatriculaAluno.setForeground(Color.BLACK);
			formattedTextFieldMatriculaAluno.setBackground(Color.WHITE);
			formattedTextFieldMatriculaAluno.setFormatterFactory(formatacao.getMatricula());
			formattedTextFieldMatriculaAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldMatriculaAluno.setBounds(779, 214, 144, 22);
			formattedTextFieldMatriculaAluno.setVisible(true);
			formattedTextFieldMatriculaAluno.setEditable(false);
		}
		return formattedTextFieldMatriculaAluno;
	}

	public JFormattedTextField getFormattedTextFieldCpf() {
		if(formattedTextFieldCpf == null) {
			formattedTextFieldCpf = new JFormattedTextField();
			formattedTextFieldCpf.setForeground(Color.BLACK);
			formattedTextFieldCpf.setBackground(Color.WHITE);
			formattedTextFieldCpf.setFormatterFactory(formatacao.getCPF());
			formattedTextFieldCpf.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldCpf.setBounds(22, 136, 144, 22);
			formattedTextFieldCpf.setVisible(true);
		}
		return formattedTextFieldCpf;
	}

	public JFormattedTextField getFormattedTextFieldRg() {
		if(formattedTextFieldRg == null) {
			formattedTextFieldRg = new JFormattedTextField();
			formattedTextFieldRg.setForeground(Color.BLACK);
			formattedTextFieldRg.setBackground(Color.WHITE);
			formattedTextFieldRg.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldRg.setBounds(184, 136, 152, 22);
			formattedTextFieldRg.setVisible(true);
		}
		return formattedTextFieldRg;
	}

	public JFormattedTextField getFormattedTextFieldDataRg() {
		if (formattedTextFieldDataRg == null) {
			formattedTextFieldDataRg = new JFormattedTextField(formatacao.getData());
			formattedTextFieldDataRg.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldDataRg.setForeground(Color.BLACK);
			formattedTextFieldDataRg.setBounds(679, 136, 123, 22);
		}
		return formattedTextFieldDataRg;
	}

	public JFormattedTextField getFormattedTextFieldDataNascimento() {
		if (formattedTextFieldDataNascimento == null) {
			formattedTextFieldDataNascimento = new JFormattedTextField(formatacao.getData());
			formattedTextFieldDataNascimento.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldDataNascimento.setForeground(Color.BLACK);
			formattedTextFieldDataNascimento.setBounds(532, 63, 123, 22);
		}
		return formattedTextFieldDataNascimento;
	}	
	
	public JFormattedTextField getFormattedTextFieldOrgaoExpeditor() {
		if (formattedTextFieldOrgaoExpeditor == null) {
			formattedTextFieldOrgaoExpeditor = new JFormattedTextField();
			formattedTextFieldOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldOrgaoExpeditor.setForeground(Color.BLACK);
			formattedTextFieldOrgaoExpeditor.setFormatterFactory(formatacao.getNome());
			formattedTextFieldOrgaoExpeditor.setBounds(344, 136, 210, 22);
			formattedTextFieldOrgaoExpeditor.setColumns(10);
		}
		return formattedTextFieldOrgaoExpeditor;
	}

	public JFormattedTextField getFormattedTextFieldRua() {
		if (formattedTextFieldRua == null) {
			formattedTextFieldRua = new JFormattedTextField();
			formattedTextFieldRua.setForeground(Color.BLACK);
			formattedTextFieldRua.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldRua.setFormatterFactory(formatacao.getEndereco());
			formattedTextFieldRua.setBounds(22, 421, 360, 22);
		}
		return formattedTextFieldRua;
	}

	public JFormattedTextField getFormattedTextFieldNumero() {
		if (formattedTextFieldNumero == null) {
			formattedTextFieldNumero = new JFormattedTextField();
			formattedTextFieldNumero.setForeground(Color.BLACK);
			formattedTextFieldNumero.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldNumero.setFormatterFactory(formatacao.getEndereco());
			formattedTextFieldNumero.setBounds(415, 421, 86, 22);
		}
		return formattedTextFieldNumero;
	}

	public JFormattedTextField getFormattedTextFieldComplemento() {
		if (formattedTextFieldComplemento == null) {
			formattedTextFieldComplemento = new JFormattedTextField();
			formattedTextFieldComplemento.setForeground(Color.BLACK);
			formattedTextFieldComplemento.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldComplemento.setFormatterFactory(formatacao.getEndereco());
			formattedTextFieldComplemento.setBounds(532, 421, 309, 22);
		}
		return formattedTextFieldComplemento;
	}
	
	public JFormattedTextField getFormattedTextFieldBairro() {
		if (formattedTextFieldBairro == null) {
			formattedTextFieldBairro = new JFormattedTextField();
			formattedTextFieldBairro.setForeground(Color.BLACK);
			formattedTextFieldBairro.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldBairro.setFormatterFactory(formatacao.getEndereco());
			formattedTextFieldBairro.setBounds(22, 504, 237, 22);
		}
		return formattedTextFieldBairro;
	}

	public JFormattedTextField getFormattedTextFieldCep() {
		if (formattedTextFieldCep == null) {
			formattedTextFieldCep = new JFormattedTextField();
			formattedTextFieldCep.setForeground(Color.BLACK);
			formattedTextFieldCep.setFormatterFactory(formatacao.getCEP());
			formattedTextFieldCep.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldCep.setBounds(707, 506, 134, 22);
		}
		return formattedTextFieldCep;
	}
	
	public JFormattedTextField getFormattedTextFieldTelefone() {
		if (formattedTextFieldTelefone == null) {
			formattedTextFieldTelefone = new JFormattedTextField();
			formattedTextFieldTelefone.setForeground(Color.BLACK);
			formattedTextFieldTelefone.setFormatterFactory(formatacao.getTelefone());
			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldTelefone.setBounds(346, 214, 183, 22);
		}
		return formattedTextFieldTelefone;
	}
	
	public JFormattedTextField getFormattedTextFieldCelular() {
		if (formattedTextFieldCelular == null) {
			formattedTextFieldCelular = new JFormattedTextField();
			formattedTextFieldCelular.setForeground(Color.BLACK);
			formattedTextFieldCelular.setFormatterFactory(formatacao.getTelefoneCelular());
			formattedTextFieldCelular.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldCelular.setBounds(573, 214, 183, 22);
		}
		return formattedTextFieldCelular;
	}
	
	public JComboBox<String> getComboBoxCurso() {
		if(comboBoxCurso == null) {
			comboBoxCurso = new JComboBox<String>();
			comboBoxCurso.setEnabled(false);
			comboBoxCurso.setForeground(Color.BLACK);
			comboBoxCurso.setBackground(Color.WHITE);
			comboBoxCurso.setBounds(198, 294, 309, 22);
			comboBoxCurso.setFont(new Font("Arial", Font.PLAIN, 14));			
			
		}
		return comboBoxCurso;
	}

	public JComboBox<String> getComboBoxHistoricoDisciplinas() {
		if(comboBoxHistoricoDisciplinas == null) {
			comboBoxHistoricoDisciplinas = new JComboBox<String>();
			comboBoxHistoricoDisciplinas.setForeground(Color.BLACK);
			comboBoxHistoricoDisciplinas.setBackground(Color.WHITE);
			comboBoxHistoricoDisciplinas.setBounds(523, 293, 309, 22);
			comboBoxHistoricoDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));			
		}
		return comboBoxHistoricoDisciplinas;
	}
	
	public JComboBox<String> getComboBoxEstadoRg() {
		if(comboBoxEstadoRg == null) {
			comboBoxEstadoRg = new JComboBox<String>();
			comboBoxEstadoRg.setForeground(Color.BLACK);
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
	
	public JComboBox<String> getComboBoxEstadoEndereco() {
		if (comboBoxEstadoEndereco == null) {
			comboBoxEstadoEndereco = new JComboBox<String>();
			comboBoxEstadoEndereco.setForeground(Color.BLACK);
			comboBoxEstadoEndereco.setBackground(Color.WHITE);
			comboBoxEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxEstadoEndereco.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE", "AC", "AL", "AM", "AP", 
					"BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", 
					"RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoEndereco.setBounds(284, 506, 115, 22);
		}
		return comboBoxEstadoEndereco;
	}
	
	public JComboBox<String> getComboBoxTipoCurso() {
		if (comboBoxTipoCurso == null) {
			comboBoxTipoCurso = new JComboBox<String>();
			comboBoxTipoCurso.setBackground(Color.WHITE);
			comboBoxTipoCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxTipoCurso.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE", "GRADUA\u00C7\u00C3O", 
					"ESPECIALIZA\u00C7\u00C3O", "MESTRADO", "DOUTORADO"}));
			comboBoxTipoCurso.setBounds(23, 296, 168, 20);
		}
		return comboBoxTipoCurso;
	}
	
	public JComboBox<String> getComboBoxCidades() {
		if (comboBoxCidades == null) {
			comboBoxCidades = new JComboBox<String>();
			comboBoxCidades.setBackground(Color.WHITE);
			comboBoxCidades.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE"}));
			comboBoxCidades.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCidades.setBounds(421, 508, 269, 20);
		}
		return comboBoxCidades;
	}
	
	public JButton getButtonAdicionarDisciplina() {
		if(buttonAdicionarDisciplina == null) {
			buttonAdicionarDisciplina = new JButton("Adicionar disciplina");
			buttonAdicionarDisciplina.setForeground(Color.BLACK);
			buttonAdicionarDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarDisciplina.setFont(new Font("Arial", Font.PLAIN, 13));
			buttonAdicionarDisciplina.setBounds(842, 292, 152, 20);
			buttonAdicionarDisciplina.setBackground(Color.WHITE);
			buttonAdicionarDisciplina.setVisible(true);
		}
		return buttonAdicionarDisciplina;
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

	public JButton getButtonCancelar() {
		if(buttonCancelar == null) {
			buttonCancelar = new JButton("CANCELAR");
			buttonCancelar.setForeground(Color.BLACK);
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
			buttonConfirmar.setForeground(Color.BLACK);
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonConfirmar.setBounds(344, 640, 130, 33);
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setVisible(true);
		}
		return buttonConfirmar;
	}

	
}
