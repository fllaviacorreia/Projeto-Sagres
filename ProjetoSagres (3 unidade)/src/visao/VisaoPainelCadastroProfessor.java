package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.FormataMascaras;

public class VisaoPainelCadastroProfessor extends JPanel{

	private JLabel 				labelMatriculaProfessor 		= null;
	private JLabel 				labelAreaAtuacaoProfessor 		= null;
	private JLabel 				labelCargaHorariaProfessor  	= null;
	private JLabel 				labelNomeProfessor 				= null;
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
	private JComboBox<String> 	comboBoxCargaHorariaProfessor  	= null;
	private JComboBox<String>   comboBoxAreaAtuacaoProfessor 	= null;
	private JComboBox<String> 	comboBoxEstadoEndereco			= null;
	private JComboBox<String> 	comboBoxEstadoRg				= null;
	private JFormattedTextField textFieldMatriculaProfessor 	= null;
	private JFormattedTextField textFieldNomeProfessor 			= null;
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
	private JButton 			botaoVoltar 	 				= null;
	private JButton 			botaoCancelar 	 				= null;
	private JButton 			botaoConfirmar   				= null;
	private JButton 			buttonAdicionarAreaAtuacao 		= null;
	private JLabel lblEmail;
	private JTextField textFieldEmail;
	private JLabel lblCep;
	private JFormattedTextField formattedTextFieldCep;
	private JLabel lblTelefone;
	private JFormattedTextField formattedTextFieldTelefone;
	private JLabel labelCelular;
	private JFormattedTextField formattedTextFieldCelular;
	FormataMascaras formatacao = new FormataMascaras();
	
//construtor que inicia o painel e coloca todas as coisas nele	
	public VisaoPainelCadastroProfessor() {
		setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setVisible(true);
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.add(getLabelAreaAtuacaoProfessor());
		this.add(getLabelCargaHorariaProfessor());
		this.add(getLabelMatriculaProfessor());
		this.add(getLabelNomeProfessor());
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
		this.add(getComboBoxCargaHorariaProfessor());
		this.add(getComboBoxAreaAtuacaoProfessor());
		this.add(getComboBoxEstadoRg());
		this.add(getComboBoxEstadoEndereco());
		this.add(getTextFieldMatriculaProfessor());
		this.add(getTextFieldNomeProfessor());
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
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonVoltar());
		this.add(getButtonAdicionarAreaAtuacao());
		add(getLblEmail());
		add(getTextFieldEmail());
		add(getLblCep());
		add(getFormattedTextFieldCep());
		add(getLblTelefone());
		add(getFormattedTextFieldTelefone());
		add(getLabelCelular());
		add(getFormattedTextFieldCelular());
	}
	
	public JLabel getLabelMatriculaProfessor() {
		if(labelMatriculaProfessor == null) {
			labelMatriculaProfessor = new JLabel("Número de matrícula:");
			labelMatriculaProfessor.setBounds(22, 117, 150, 25);
			labelMatriculaProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelMatriculaProfessor.setForeground(Color.BLACK);
			labelMatriculaProfessor.setVisible(true);
		}
		return labelMatriculaProfessor;
	}
	
	public JLabel getLabelAreaAtuacaoProfessor() {
		if(labelAreaAtuacaoProfessor == null) {
			labelAreaAtuacaoProfessor = new JLabel("Área de atuação:");
			labelAreaAtuacaoProfessor.setBounds(22, 193, 130, 25);
			labelAreaAtuacaoProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelAreaAtuacaoProfessor.setForeground(Color.BLACK);
			labelAreaAtuacaoProfessor.setVisible(true);
		}
		return labelAreaAtuacaoProfessor;
	}
	
	public JLabel getLabelCargaHorariaProfessor() {
		if(labelCargaHorariaProfessor == null) {
			labelCargaHorariaProfessor = new JLabel("Carga Horária:");
			labelCargaHorariaProfessor.setBounds(233, 117, 130, 25);
			labelCargaHorariaProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCargaHorariaProfessor.setForeground(Color.BLACK);
			labelCargaHorariaProfessor.setVisible(true);
		}
		return labelCargaHorariaProfessor;
	}
	public JLabel getLabelCpf() {
		if(labelCpf == null) {
			labelCpf = new JLabel("CPF:");
			labelCpf.setBounds(480, 41, 38, 25);
			labelCpf.setForeground(Color.BLACK);
			labelCpf.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCpf.setVisible(true);
		}
		return labelCpf;
	}

	public JLabel getLabelRg() {
		if(labelRg == null) {
			labelRg = new JLabel("RG:");
			labelRg.setBounds(22, 265, 38, 25);
			labelRg.setForeground(Color.BLACK);
			labelRg.setFont(new Font("Arial", Font.PLAIN, 14));
			labelRg.setVisible(true);
		}
		return labelRg;
	}
	public JLabel getLabelOrgaoExpeditor() {
		if(labelOrgaoExpeditor == null) {
			labelOrgaoExpeditor = new JLabel("\u00D3rg\u00E3o Expeditor:");
			labelOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelOrgaoExpeditor.setBounds(184, 265, 115, 25);
			labelOrgaoExpeditor.setForeground(Color.BLACK);
			labelOrgaoExpeditor.setVisible(true);
		}
		return labelOrgaoExpeditor;
	}
	public JLabel getLabelEstadoRg() {
		if(labelEstadoRg == null) {
			labelEstadoRg = new JLabel("Estado:");
			labelEstadoRg.setFont(new Font("Arial", Font.PLAIN, 14));
			labelEstadoRg.setBounds(409, 265, 81, 25);
			labelEstadoRg.setForeground(Color.BLACK);
			labelEstadoRg.setVisible(true);
		}
		return labelEstadoRg;
	}
	public JLabel getLabelNomeProfessor() {
		if(labelNomeProfessor == null) {
			labelNomeProfessor = new JLabel("Nome:");
			labelNomeProfessor.setBounds(22, 41, 52, 25);
			labelNomeProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNomeProfessor.setForeground(Color.BLACK);
			labelNomeProfessor.setVisible(true);
		}
		return labelNomeProfessor;
	}
	public JLabel getLabelDataDeExpedicao() {
		if (labelDataDeExpedicao == null) {
			labelDataDeExpedicao = new JLabel("Data de Expedi\u00E7\u00E3o:");
			labelDataDeExpedicao.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDataDeExpedicao.setBounds(523, 265, 123, 25);
		}
		return labelDataDeExpedicao;
	}
	public JLabel getLabelDataDeNascimento() {
		if (labelDataDeNascimento == null) {
			labelDataDeNascimento = new JLabel("Data de Nascimento:");
			labelDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDataDeNascimento.setBounds(666, 41, 219, 25);
		}
		return labelDataDeNascimento;
	}
	
	public JLabel getLabelDadosPessoais() {
		if (labelDadosPessoais == null) {
			labelDadosPessoais = new JLabel("  Dados Pessoais");
			labelDadosPessoais.setBorder(new LineBorder(Color.BLACK, 2));
			labelDadosPessoais.setFont(new Font("Arial", Font.PLAIN, 19));
			labelDadosPessoais.setBounds(0, 0, 1028, 30);
		}
		return labelDadosPessoais;
	}
	public JLabel getLabelEndereco() {
		if (labelEndereco == null) {
			labelEndereco = new JLabel("  Endere\u00E7o");
			labelEndereco.setBorder(new LineBorder(Color.BLACK, 2));
			labelEndereco.setFont(new Font("Arial", Font.PLAIN, 19));
			labelEndereco.setBounds(0, 355, 1028, 30);
		}
		return labelEndereco;
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
	public JComboBox<String> getComboBoxCargaHorariaProfessor() {
		if(comboBoxCargaHorariaProfessor == null) {
			comboBoxCargaHorariaProfessor = new JComboBox<String>();
			comboBoxCargaHorariaProfessor.addItem("SELECIONE");
			comboBoxCargaHorariaProfessor.addItem("[D.E.]/SEMANA");
			comboBoxCargaHorariaProfessor.addItem("[20]/SEMANA");
			comboBoxCargaHorariaProfessor.addItem("[40]/SEMANA");
			comboBoxCargaHorariaProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCargaHorariaProfessor.setBounds(233, 143, 161, 22);
			comboBoxCargaHorariaProfessor.setBackground(Color.WHITE);
			comboBoxCargaHorariaProfessor.setVisible(true);
		}
		return comboBoxCargaHorariaProfessor;
	}
	
	public JComboBox<String> getComboBoxAreaAtuacaoProfessor() {
		if(comboBoxAreaAtuacaoProfessor == null) {
			comboBoxAreaAtuacaoProfessor = new JComboBox<String>();
			comboBoxAreaAtuacaoProfessor.addItem("SELECIONE");
			comboBoxAreaAtuacaoProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxAreaAtuacaoProfessor.setBounds(22, 219, 252, 22);
			comboBoxAreaAtuacaoProfessor.setBackground(Color.WHITE);
			comboBoxAreaAtuacaoProfessor.setVisible(true);
		}
		return comboBoxAreaAtuacaoProfessor;
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
	public JComboBox<String> getComboBoxEstadoRg() {
		if(comboBoxEstadoRg == null) {
			comboBoxEstadoRg = new JComboBox<String>();
			comboBoxEstadoRg.setBackground(Color.WHITE);
			comboBoxEstadoRg.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxEstadoRg.setModel(new DefaultComboBoxModel<String>(
									new String[] {"SELECIONE", "AC", "AL", "AM", "AP", "BA", "CE", 
											"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", 
											"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoRg.setBounds(404, 288, 104, 22);
		}
		return comboBoxEstadoRg;
	}
	public JFormattedTextField getFormattedTextFieldCpf() {
		if(textFieldCpf == null) {
			textFieldCpf = new JFormattedTextField();
			textFieldCpf.setBackground(Color.WHITE);
			textFieldCpf.setFormatterFactory(formatacao.getCPF());
			textFieldCpf.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldCpf.setBounds(480, 66, 144, 22);
			textFieldCpf.setVisible(true);
		}
		return textFieldCpf;
	}
	public JFormattedTextField getTextFieldMatriculaProfessor() {
		if(textFieldMatriculaProfessor == null) {
			textFieldMatriculaProfessor = new JFormattedTextField();
			textFieldMatriculaProfessor.setFormatterFactory(formatacao.getMatricula());
			textFieldMatriculaProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldMatriculaProfessor.setBounds(22, 143, 150, 22);
			textFieldMatriculaProfessor.setBackground(Color.WHITE);
			textFieldMatriculaProfessor.setVisible(true);
			textFieldMatriculaProfessor.setEditable(false);
		}

		return textFieldMatriculaProfessor;
	}
	public JFormattedTextField getFormattedTextFieldDataRg() {
		if (formattedTextFieldDataRg == null) {
			formattedTextFieldDataRg = new JFormattedTextField(formatacao.getData());
			formattedTextFieldDataRg.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldDataRg.setBounds(519, 289, 147, 22);
		}
		return formattedTextFieldDataRg;
	}
	public JFormattedTextField getFormattedTextFieldDataNascimento() {
		if (formattedTextFieldDataNascimento == null) {
			formattedTextFieldDataNascimento = new JFormattedTextField(formatacao.getData());
			formattedTextFieldDataNascimento.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldDataNascimento.setBounds(666, 67, 147, 22);
		}
		return formattedTextFieldDataNascimento;
	}
	public JFormattedTextField getFormattedTextFieldRg() {
		if(textFieldRg == null) {
			textFieldRg = new JFormattedTextField();
			textFieldRg.setBackground(Color.WHITE);
			textFieldRg.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldRg.setBounds(22, 289, 152, 22);
			textFieldRg.setVisible(true);
		}
		return textFieldRg;
	}

	
	public JFormattedTextField getTextFieldNomeProfessor() {
		if(textFieldNomeProfessor == null) {
			textFieldNomeProfessor = new JFormattedTextField();
			textFieldNomeProfessor.setFormatterFactory(formatacao.getNome());
			textFieldNomeProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldNomeProfessor.setBounds(22, 67, 396, 22);
			textFieldNomeProfessor.setBackground(Color.WHITE);
			textFieldNomeProfessor.setVisible(true);
		}
		return textFieldNomeProfessor;
	}
	
	public JFormattedTextField getFormattedTextFieldOrgaoExpeditor() {
		if (textFieldOrgaoExpeditor == null) {
			textFieldOrgaoExpeditor = new JFormattedTextField();
			textFieldOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldOrgaoExpeditor.setFormatterFactory(formatacao.getNome());
			textFieldOrgaoExpeditor.setBounds(184, 289, 210, 22);
			textFieldOrgaoExpeditor.setColumns(10);
		}
		return textFieldOrgaoExpeditor;
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
	public JButton getButtonVoltar() {
		if(botaoVoltar == null) {
			botaoVoltar = new JButton("VOLTAR");
			botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 13));
			botaoVoltar.setBounds(22, 639, 130, 33);
			botaoVoltar.setBackground(new Color(255, 255, 255));
			botaoVoltar.setVisible(true);
		}
		return botaoVoltar;
	}

	public JButton getButtonCancelar() {
		if(botaoCancelar == null) {
			botaoCancelar = new JButton("CANCELAR");
			botaoCancelar.setFont(new Font("Arial", Font.PLAIN, 13));
			botaoCancelar.setBounds(188, 639, 119, 33);
			botaoCancelar.setBackground(new Color(255, 255, 255));
			botaoCancelar.setVisible(true);
		}
		return botaoCancelar;
	}

	public JButton getButtonConfirmar() {
		if(botaoConfirmar == null) {
			botaoConfirmar = new JButton("CONFIRMAR");
			botaoConfirmar.setFont(new Font("Arial", Font.PLAIN, 13));
			botaoConfirmar.setBounds(340, 639, 119, 33);
			botaoConfirmar.setBackground(new Color(255, 255, 255));
			botaoConfirmar.setVisible(true);
		}
		return botaoConfirmar;
	}
	public JButton getButtonAdicionarAreaAtuacao() {
		if(buttonAdicionarAreaAtuacao == null) {
			buttonAdicionarAreaAtuacao = new JButton("Adicionar área");
			buttonAdicionarAreaAtuacao.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarAreaAtuacao.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonAdicionarAreaAtuacao.setBounds(288, 219, 130, 20);
			buttonAdicionarAreaAtuacao.setBackground(Color.WHITE);
			buttonAdicionarAreaAtuacao.setVisible(true);
		}
		return buttonAdicionarAreaAtuacao;
	}
	public JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail:");
			lblEmail.setForeground(Color.BLACK);
			lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			lblEmail.setBounds(480, 116, 46, 25);
		}
		return lblEmail;
	}
	public JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setForeground(Color.BLACK);
			textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldEmail.setBounds(480, 143, 309, 22);
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}
	public JLabel getLblCep() {
		if (lblCep == null) {
			lblCep = new JLabel("CEP:");
			lblCep.setForeground(Color.BLACK);
			lblCep.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCep.setBounds(710, 479, 46, 25);
		}
		return lblCep;
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
	public JLabel getLblTelefone() {
		if (lblTelefone == null) {
			lblTelefone = new JLabel("Telefone:");
			lblTelefone.setForeground(Color.BLACK);
			lblTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
			lblTelefone.setBounds(483, 193, 128, 25);
		}
		return lblTelefone;
	}
	public JFormattedTextField getFormattedTextFieldTelefone() {
		if (formattedTextFieldTelefone == null) {
			formattedTextFieldTelefone = new JFormattedTextField();
			formattedTextFieldTelefone.setForeground(Color.BLACK);
			formattedTextFieldTelefone.setFormatterFactory(formatacao.getTelefone());
			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldTelefone.setBounds(483, 216, 183, 22);
		}
		return formattedTextFieldTelefone;
	}
	public JLabel getLabelCelular() {
		if (labelCelular == null) {
			labelCelular = new JLabel("Celular:");
			labelCelular.setForeground(Color.BLACK);
			labelCelular.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCelular.setBounds(702, 190, 128, 25);
		}
		return labelCelular;
	}
	public JFormattedTextField getFormattedTextFieldCelular() {
		if (formattedTextFieldCelular == null) {
			formattedTextFieldCelular = new JFormattedTextField();
			formattedTextFieldCelular.setForeground(Color.BLACK);
			formattedTextFieldCelular.setFormatterFactory(formatacao.getTelefoneCelular());
			formattedTextFieldCelular.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldCelular.setBounds(702, 217, 183, 22);
		}
		return formattedTextFieldCelular;
	}
}
