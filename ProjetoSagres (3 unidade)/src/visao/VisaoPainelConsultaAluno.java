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

@SuppressWarnings("serial")
public class VisaoPainelConsultaAluno extends JPanel{
	private JButton 			buttonVoltar 	 				= null;
	private JTable jtableDados;
	private JScrollPane dadosAlunoJScrollPane;
	private JComboBox<String> comboBoxTipoBusca;
	private JTextField textFieldBusca;
	private JButton btnBuscar;
	private ModeloTabelaAluno tabela;
	public VisaoPainelConsultaAluno() {
		this.setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1400, 720));
		this.setMaximumSize(new Dimension(1400, 720));
		this.setVisible(true);
		this.add(getButtonVoltar());
		this.add(getDadosAlunoJScrollPane());
		this.add(getComboBoxTipoBusca());
		this.add(getTextFieldBusca());
		this.add(getBtnBuscar());
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
			jtableDados.getColumnModel().getColumn(1).setPreferredWidth(120);
			jtableDados.getColumnModel().getColumn(2).setPreferredWidth(120);
			jtableDados.getColumnModel().getColumn(3).setPreferredWidth(300);
			jtableDados.getColumnModel().getColumn(4).setPreferredWidth(200);
			jtableDados.getColumnModel().getColumn(5).setPreferredWidth(250);
			jtableDados.getColumnModel().getColumn(6).setPreferredWidth(250);
			
			jtableDados.setVisible(true);
		}
		return jtableDados;
	}
	
	public JScrollPane getDadosAlunoJScrollPane() {
		if(dadosAlunoJScrollPane == null) {
			dadosAlunoJScrollPane = new JScrollPane(getJTableDados());
			dadosAlunoJScrollPane.setBounds(48, 116, 1200, 400);
		}
		return dadosAlunoJScrollPane;
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
	public JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.setForeground(Color.BLACK);
			btnBuscar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnBuscar.setBackground(Color.WHITE);
			btnBuscar.setBounds(837, 47, 89, 23);
		}
		return btnBuscar;
	}

	public ModeloTabelaAluno getTabela() {
		if(tabela == null) {
			tabela = new ModeloTabelaAluno();
			for(int i = 0; i < Main.aluno.size(); i++)
				tabela.setValueAt(Main.aluno.get(i), i);
		}
		return tabela;
	}

	public void setTabela(ModeloTabelaAluno tabela) {
		this.tabela = tabela;
	}
}
