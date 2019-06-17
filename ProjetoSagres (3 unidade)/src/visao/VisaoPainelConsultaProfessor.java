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
import javax.swing.border.LineBorder;

import controle.Main;
import modelo.ModeloTabelaAluno;
import modelo.ModeloTabelaProfessor;

public class VisaoPainelConsultaProfessor extends JPanel{
	private JButton 			buttonVoltar 	 				= null;
	private JTable jtableDadosProfessor;
	private JScrollPane jScrollPaneDadosProfessor;
	private JComboBox<String> comboBoxTipoBusca;
	private JTextField textFieldBusca;
	private JButton btnBuscar;
	private ModeloTabelaProfessor tabelaProfessor;
	public VisaoPainelConsultaProfessor() {
		this.setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getButtonVoltar());
		this.add(getJScrollPaneDadosProfessor());
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
	
	public JTable getJTableDadosProfessor() {
		if (jtableDadosProfessor == null) {
			jtableDadosProfessor = new JTable();
			jtableDadosProfessor.setBorder(new LineBorder(new Color(0, 0, 0)));
			jtableDadosProfessor.setFont(new Font("Arial", Font.BOLD, 18));
			jtableDadosProfessor.setModel(getTabelaProfessor());
			jtableDadosProfessor.getColumnModel().getColumn(0).setPreferredWidth(150);
			jtableDadosProfessor.getColumnModel().getColumn(1).setPreferredWidth(150);
			jtableDadosProfessor.getColumnModel().getColumn(2).setPreferredWidth(300);
			jtableDadosProfessor.getColumnModel().getColumn(3).setPreferredWidth(300);
			jtableDadosProfessor.getColumnModel().getColumn(4).setPreferredWidth(180);
			jtableDadosProfessor.setBounds(10, 89, 1200, 400);
		}
		return jtableDadosProfessor;
	}
	
	public JScrollPane getJScrollPaneDadosProfessor() {
		if(jScrollPaneDadosProfessor == null) {
			jScrollPaneDadosProfessor = new JScrollPane(getJTableDadosProfessor());
			jScrollPaneDadosProfessor.setBounds(48, 89, 1200, 400);
		}
		return jScrollPaneDadosProfessor;
	}
	
	public JComboBox<String> getComboBoxTipoBusca() {
		if (comboBoxTipoBusca == null) {
			comboBoxTipoBusca = new JComboBox<String>();
			comboBoxTipoBusca.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "Nome", "CPF"}));
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

	public ModeloTabelaProfessor getTabelaProfessor() {
		if(tabelaProfessor == null)
			tabelaProfessor = new ModeloTabelaProfessor();
		return tabelaProfessor;
	}

	public void setTabelaProfessor(ModeloTabelaProfessor tabelaProfessor) {
		this.tabelaProfessor = tabelaProfessor;
	}

}
