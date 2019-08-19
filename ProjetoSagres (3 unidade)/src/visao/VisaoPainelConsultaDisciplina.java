package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controle.Main;
import modelo.ModeloTabelaAluno;
import modelo.ModeloTabelaClasse;
import modelo.ModeloTabelaDisciplina;

public class VisaoPainelConsultaDisciplina extends JPanel{
	private JButton 			buttonVoltar 	 				= null;
	private JTable jtableDados;
	private JScrollPane dadosJScrollPane;
	private JComboBox<String> comboBoxTipoBusca;
	private JTextField textFieldBusca;
	private JButton btnBuscar;
	private ModeloTabelaDisciplina tabela;
	
	public VisaoPainelConsultaDisciplina() {
		this.setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getButtonVoltar());
		this.add(getDadosJScrollPane());
		this.add(getComboBoxTipoBusca());
		this.add(getTextFieldBusca());
		this.add(getButtonBuscar());
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
	
	public JTable getJTableDados() {
		if (jtableDados == null) {
			jtableDados = new JTable();
			jtableDados.setFont(new Font("Arial Narrow", Font.BOLD, 20));
			jtableDados.setModel(getTabela());
			//auto ajuste na altura da tabela
			//jtableDadosAluno.setFillsViewportHeight(true);
	        //selecionar somente uma linha
			//jtableDadosAluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jtableDados.setBounds(10, 89, 1200, 400);
			jtableDados.getColumnModel().getColumn(0).setPreferredWidth(40);
			jtableDados.getColumnModel().getColumn(1).setPreferredWidth(250);
			jtableDados.getColumnModel().getColumn(2).setPreferredWidth(40);
			jtableDados.getColumnModel().getColumn(3).setPreferredWidth(400);
			jtableDados.getColumnModel().getColumn(4).setPreferredWidth(250);
			jtableDados.setVisible(true);
		}
		return jtableDados;
	}
	
	public JScrollPane getDadosJScrollPane() {
		if(dadosJScrollPane == null) {
			dadosJScrollPane = new JScrollPane(getJTableDados());
			dadosJScrollPane.setBounds(48, 116, 1200, 400);
		}
		return dadosJScrollPane;
	}	
	public JComboBox<String> getComboBoxTipoBusca() {
		if (comboBoxTipoBusca == null) {
			comboBoxTipoBusca = new JComboBox<String>();
			comboBoxTipoBusca.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECIONE", "Nome", "CPF"}));
			comboBoxTipoBusca.setForeground(Color.BLACK);
			comboBoxTipoBusca.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxTipoBusca.setBackground(Color.WHITE);
			comboBoxTipoBusca.setBounds(49, 48, 140, 22);
		}
		return comboBoxTipoBusca;
	}
	public JTextField getTextFieldBusca() {
		if (textFieldBusca == null) {
			textFieldBusca = new JTextField();
			textFieldBusca.setForeground(Color.BLACK);
			textFieldBusca.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldBusca.setBackground(Color.WHITE);
			textFieldBusca.setBounds(216, 48, 591, 22);
			textFieldBusca.setColumns(10);
		}
		return textFieldBusca;
	}
	public JButton getButtonBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.setForeground(Color.BLACK);
			btnBuscar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnBuscar.setBackground(Color.WHITE);
			btnBuscar.setBounds(837, 47, 89, 23);
		}
		return btnBuscar;
	}

	public ModeloTabelaDisciplina getTabela() {
		if(tabela == null) {
			tabela = new ModeloTabelaDisciplina();
			for(int i = 0; i < Main.disciplina.size(); i++)
				tabela.setValueAt(Main.disciplina.get(i), i);
		}
		return tabela;
	}

	public void setTabela(ModeloTabelaDisciplina tabela) {
		this.tabela = tabela;
	}

}
