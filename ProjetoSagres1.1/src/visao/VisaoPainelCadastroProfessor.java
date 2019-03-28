package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import controle.FormataMascaras;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VisaoPainelCadastroProfessor extends JPanel{

	private JLabel 				labelMatriculaProfessor 		= null;
	private JLabel 				labelAreaAtuacaoProfessor 		= null;
	private JLabel 				labelCargaHorariaProfessor  	= null;
	private JLabel 				labelNomeProfessor 				= null;
	private JComboBox<String> 	comboBoxCargaHorariaProfessor  	= null;
	private JFormattedTextField textFieldMatriculaProfessor 	= null;
	private JComboBox<String>   comboBoxAreaAtuacaoProfessor 	= null;
	private JFormattedTextField textFieldNomeProfessor 			= null;
	private JButton 			botaoVoltar 	 				= null;
	private JButton 			botaoCancelar 	 				= null;
	private JButton 			botaoConfirmar   				= null;
	private JButton 			buttonAdicionarAreaAtuacao 		= null;
	
	FormataMascaras formatacao = new FormataMascaras();
	
//construtor que inicia o painel e coloca todas as coisas nele	
	public VisaoPainelCadastroProfessor() {
		setLayout(null);
		this.setBackground(new Color(66, 179, 165));
		this.setVisible(true);
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.add(getLabelAreaAtuacaoProfessor());
		this.add(getLabelCargaHorariaProfessor());
		this.add(getLabelMatriculaProfessor());
		this.add(getLabelNomeProfessor());
		this.add(getComboBoxCargaHorariaProfessor());
		this.add(getComboBoxAreaAtuacaoProfessor());
		this.add(getTextFieldMatriculaProfessor());
		this.add(getTextFieldNomeProfessor());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonVoltar());
		this.add(getButtonAdicionarAreaAtuacao());
	}
	
	public JLabel getLabelMatriculaProfessor() {
		if(labelMatriculaProfessor == null) {
			labelMatriculaProfessor = new JLabel("Número de matrícula:");
			labelMatriculaProfessor.setBounds(53, 110, 150, 25);
			labelMatriculaProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelMatriculaProfessor.setForeground(Color.BLACK);
			labelMatriculaProfessor.setVisible(true);
		}
		return labelMatriculaProfessor;
	}
	
	public JLabel getLabelAreaAtuacaoProfessor() {
		if(labelAreaAtuacaoProfessor == null) {
			labelAreaAtuacaoProfessor = new JLabel("Área de atuação:");
			labelAreaAtuacaoProfessor.setBounds(53, 186, 130, 25);
			labelAreaAtuacaoProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelAreaAtuacaoProfessor.setForeground(Color.BLACK);
			labelAreaAtuacaoProfessor.setVisible(true);
		}
		return labelAreaAtuacaoProfessor;
	}
	
	public JLabel getLabelCargaHorariaProfessor() {
		if(labelCargaHorariaProfessor == null) {
			labelCargaHorariaProfessor = new JLabel("Carga Horária:");
			labelCargaHorariaProfessor.setBounds(220, 110, 130, 25);
			labelCargaHorariaProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCargaHorariaProfessor.setForeground(Color.BLACK);
			labelCargaHorariaProfessor.setVisible(true);
		}
		return labelCargaHorariaProfessor;
	}
	
	public JLabel getLabelNomeProfessor() {
		if(labelNomeProfessor == null) {
			labelNomeProfessor = new JLabel("Nome:");
			labelNomeProfessor.setBounds(53, 34, 52, 25);
			labelNomeProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			labelNomeProfessor.setForeground(Color.BLACK);
			labelNomeProfessor.setVisible(true);
		}
		return labelNomeProfessor;
	}
	
	public JComboBox<String> getComboBoxCargaHorariaProfessor() {
		if(comboBoxCargaHorariaProfessor == null) {
			comboBoxCargaHorariaProfessor = new JComboBox<String>();
			comboBoxCargaHorariaProfessor.addItem("SELECIONE");
			comboBoxCargaHorariaProfessor.addItem("[D.E.]/SEMANA");
			comboBoxCargaHorariaProfessor.addItem("[20]/SEMANA");
			comboBoxCargaHorariaProfessor.addItem("[40]/SEMANA");
			comboBoxCargaHorariaProfessor.setFont(new Font("Arial", Font.PLAIN, 13));
			comboBoxCargaHorariaProfessor.setBounds(220, 136, 161, 20);
			comboBoxCargaHorariaProfessor.setBackground(Color.WHITE);
			comboBoxCargaHorariaProfessor.setVisible(true);
		}
		return comboBoxCargaHorariaProfessor;
	}
	
	public JFormattedTextField getTextFieldMatriculaProfessor() {
		if(textFieldMatriculaProfessor == null) {
			textFieldMatriculaProfessor = new JFormattedTextField();
			textFieldMatriculaProfessor.setFormatterFactory(formatacao.getMatricula());
			textFieldMatriculaProfessor.setFont(new Font("Arial", Font.PLAIN, 13));
			textFieldMatriculaProfessor.setBounds(53, 136, 103, 20);
			textFieldMatriculaProfessor.setBackground(Color.WHITE);
			textFieldMatriculaProfessor.setVisible(true);
			textFieldMatriculaProfessor.setEditable(false);
		}

		return textFieldMatriculaProfessor;
	}
	
	public JComboBox<String> getComboBoxAreaAtuacaoProfessor() {
		if(comboBoxAreaAtuacaoProfessor == null) {
			comboBoxAreaAtuacaoProfessor = new JComboBox<String>();
			comboBoxAreaAtuacaoProfessor.addItem("SELECIONE");
			comboBoxAreaAtuacaoProfessor.setFont(new Font("Arial", Font.PLAIN, 13));
			comboBoxAreaAtuacaoProfessor.setBounds(53, 212, 252, 20);
			comboBoxAreaAtuacaoProfessor.setBackground(Color.WHITE);
			comboBoxAreaAtuacaoProfessor.setVisible(true);
		}
		return comboBoxAreaAtuacaoProfessor;
	}
	
	
	
	public JFormattedTextField getTextFieldNomeProfessor() {
		if(textFieldNomeProfessor == null) {
			textFieldNomeProfessor = new JFormattedTextField();
			textFieldNomeProfessor.setFormatterFactory(formatacao.getNome());
			textFieldNomeProfessor.setFont(new Font("Arial", Font.PLAIN, 13));
			textFieldNomeProfessor.setBounds(53, 60, 396, 20);
			textFieldNomeProfessor.setBackground(Color.WHITE);
			textFieldNomeProfessor.setVisible(true);
		}
		return textFieldNomeProfessor;
	}
	
	public JButton getButtonVoltar() {
		if(botaoVoltar == null) {
			botaoVoltar = new JButton("VOLTAR");
			botaoVoltar.setFont(new Font("Arial", Font.PLAIN, 13));
			botaoVoltar.setBounds(54, 631, 130, 33);
			botaoVoltar.setBackground(new Color(255, 255, 255));
			botaoVoltar.setVisible(true);
		}
		return botaoVoltar;
	}

	public JButton getButtonCancelar() {
		if(botaoCancelar == null) {
			botaoCancelar = new JButton("CANCELAR");
			botaoCancelar.setFont(new Font("Arial", Font.PLAIN, 13));
			botaoCancelar.setBounds(220, 631, 119, 33);
			botaoCancelar.setBackground(new Color(255, 255, 255));
			botaoCancelar.setVisible(true);
		}
		return botaoCancelar;
	}

	public JButton getButtonConfirmar() {
		if(botaoConfirmar == null) {
			botaoConfirmar = new JButton("CONFIRMAR");
			botaoConfirmar.setFont(new Font("Arial", Font.PLAIN, 13));
			botaoConfirmar.setBounds(372, 631, 119, 33);
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
			buttonAdicionarAreaAtuacao.setBounds(319, 212, 130, 20);
			buttonAdicionarAreaAtuacao.setBackground(Color.WHITE);
			buttonAdicionarAreaAtuacao.setVisible(true);
		}
		return buttonAdicionarAreaAtuacao;
	}
}
