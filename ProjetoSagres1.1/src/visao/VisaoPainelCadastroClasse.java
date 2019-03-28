package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//import com.toedter.calendar.JCalendar;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class VisaoPainelCadastroClasse extends JPanel{

	private JLabel 				labelDisciplina 			= null;
	private JLabel 				labelProfessores 			= null;
	private JLabel 				labelAlunos 				= null;
	private JLabel 				labelAno 					= null;
	private JLabel 				labelSemestre 				= null;
	private JComboBox<String>   comboBoxDisciplina 			= null;
	private JComboBox<String>   comboBoxProfessores 		= null;
	private JComboBox<String>   comboBoxAlunos 		  		= null;
	private JComboBox<String>   comboBoxSemestre 	 		= null;
	private JButton 			buttonVoltar 	 			= null;
	private JButton 			buttonCancelar 	 			= null;
	private JButton 			buttonConfirmar   			= null;
	private JButton 			buttonAdicionarProfessor  	= null;
	private JButton 			buttonAdicionarAluno  		= null;
	private JTextField 			textFieldAno				= null;
	private Calendar 			calendario 					= Calendar.getInstance();
	private JLabel labelCurso;
	private JComboBox<String> comboBoxCurso;
	private JButton btnGerarHorrio;
	public VisaoPainelCadastroClasse() {
		this.setLayout(null);
		this.setBackground(new Color(66, 179, 165));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getLabelDisciplina());
		this.add(getLabelProfessores());
		this.add(getLabelAlunos());
		this.add(getLabelAno());
		this.add(getLabelSemestre());
		this.add(getComboBoxDisciplina());
		this.add(getComboBoxProfessores());
		this.add(getComboBoxAlunos());
		this.add(getComboBoxSemestre());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonVoltar());
		this.add(getButtonAdicionarAluno());
		this.add(getButtonAdicionarProfessor());
		this.add(getTextFieldAno());
		add(getLabelCurso());
		add(getComboBoxCurso());
		add(getButtonGerarHorario());
	}
	
	

	public JLabel getLabelDisciplina() {
		if(labelDisciplina == null) {
			labelDisciplina = new JLabel("Disciplina:");
			labelDisciplina.setBounds(382, 32, 102, 25);
			labelDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDisciplina.setForeground(Color.BLACK);
			labelDisciplina.setVisible(true);
		
		}
		return labelDisciplina;
	}
	
	public JLabel getLabelProfessores() {
		if(labelProfessores == null) {
			labelProfessores = new JLabel("Professor(es):");
			labelProfessores.setBounds(53, 113, 102, 25);
			labelProfessores.setFont(new Font("Arial", Font.PLAIN, 14));
			labelProfessores.setForeground(Color.BLACK);
			labelProfessores.setVisible(true);
		
		}
		return labelProfessores;
	}
	
	public JLabel getLabelAlunos() {
		if(labelAlunos == null) {
			labelAlunos = new JLabel("Aluno(s):");
			labelAlunos.setBounds(53, 192, 102, 25);
			labelAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
			labelAlunos.setForeground(Color.BLACK);
			labelAlunos.setVisible(true);
		
		}
		return labelAlunos;
	}
	
	public JLabel getLabelAno() {
		if(labelAno == null) {
			labelAno = new JLabel("Ano:");
			labelAno.setBounds(53, 271, 47, 20);
			labelAno.setForeground(Color.BLACK);
			labelAno.setFont(new Font("Arial", Font.PLAIN, 14));
			labelAno.setVisible(true);
		}
		return labelAno;
	}

	public JLabel getLabelSemestre() {
		if(labelSemestre == null) {
			labelSemestre = new JLabel("Semestre:");
			labelSemestre.setBounds(158, 271, 83, 20);
			labelSemestre.setForeground(Color.BLACK);
			labelSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
			labelSemestre.setVisible(true);
		}
		return labelSemestre;
	}

	public JComboBox<String> getComboBoxDisciplina() {
		if(comboBoxDisciplina == null) {
			comboBoxDisciplina = new JComboBox<String>();
			comboBoxDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxDisciplina.setBackground(new Color(255, 255, 255));
			comboBoxDisciplina.setBounds(382, 58, 372, 20);
			comboBoxDisciplina.addItem("SELECIONE");
			comboBoxDisciplina.setVisible(true);
		}
		return comboBoxDisciplina;
	}

	public JComboBox<String> getComboBoxProfessores() {
		if(comboBoxProfessores == null) {
			comboBoxProfessores = new JComboBox<String>();
			comboBoxProfessores.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxProfessores.setBackground(new Color(255, 255, 255));
			comboBoxProfessores.setBounds(53, 139, 372, 20);
			comboBoxProfessores.setVisible(true);
		}
		return comboBoxProfessores;
	}

	public JComboBox<String> getComboBoxAlunos() {
		if(comboBoxAlunos == null) {
			comboBoxAlunos = new JComboBox<String>();
			comboBoxAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxAlunos.setBackground(new Color(255, 255, 255));
			comboBoxAlunos.setBounds(53, 218, 372, 20);
			comboBoxAlunos.setVisible(true);
		}
		return comboBoxAlunos;
	}
	
	public JComboBox<String> getComboBoxSemestre() {
		if(comboBoxSemestre == null) {
			comboBoxSemestre = new JComboBox<String>();
			comboBoxSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxSemestre.setBackground(new Color(255, 255, 255));
			comboBoxSemestre.setBounds(158, 297, 136, 20);
			comboBoxSemestre.addItem("SELECIONE");
			comboBoxSemestre.addItem("1");
			comboBoxSemestre.addItem("2");
			comboBoxSemestre.setVisible(true);
		}
		return comboBoxSemestre;
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
			buttonCancelar.setBounds(211, 631, 119, 33);
			buttonCancelar.setBackground(Color.WHITE);
			buttonCancelar.setVisible(true);
		}
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		if(buttonConfirmar == null) {
			buttonConfirmar = new JButton("CONFIRMAR");
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonConfirmar.setBounds(358, 631, 119, 33);
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setVisible(true);
		}
		return buttonConfirmar;
	}
	
	public JButton getButtonAdicionarProfessor() {
		if(buttonAdicionarProfessor == null) {
			buttonAdicionarProfessor = new JButton("Adicionar professor");
			buttonAdicionarProfessor.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarProfessor.setFont(new Font("Arial", Font.PLAIN, 11));
			buttonAdicionarProfessor.setBounds(435, 139, 132, 20);
			buttonAdicionarProfessor.setBackground(Color.WHITE);
			buttonAdicionarProfessor.setVisible(true);
		}
		return buttonAdicionarProfessor;
	}
	
	public JButton getButtonAdicionarAluno() {
		if(buttonAdicionarAluno == null) {
			buttonAdicionarAluno = new JButton("Adicionar aluno");
			buttonAdicionarAluno.setHorizontalAlignment(SwingConstants.LEFT);
			buttonAdicionarAluno.setFont(new Font("Arial", Font.PLAIN, 11));
			buttonAdicionarAluno.setBounds(435, 218, 132, 20);
			buttonAdicionarAluno.setBackground(Color.WHITE);
			buttonAdicionarAluno.setVisible(true);
		}
		return buttonAdicionarAluno;
	}
	public JTextField getTextFieldAno() {
		if (textFieldAno == null) {
			textFieldAno = new JTextField();
			textFieldAno.setText(String.valueOf(calendario.get(Calendar.YEAR)));
			textFieldAno.setForeground(Color.BLACK);
			textFieldAno.setBounds(53, 298, 69, 20);
			textFieldAno.setColumns(10);
			textFieldAno.setEditable(false);
		}
		return textFieldAno;
	}
	public JLabel getLabelCurso() {
		if (labelCurso == null) {
			labelCurso = new JLabel("Curso:");
			labelCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCurso.setBounds(53, 37, 46, 14);
		}
		return labelCurso;
	}
	public JComboBox<String> getComboBoxCurso() {
		if (comboBoxCurso == null) {
			comboBoxCurso = new JComboBox();
			comboBoxCurso.setBackground(Color.WHITE);
			comboBoxCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCurso.setBounds(53, 58, 277, 20);
		}
		return comboBoxCurso;
	}
	public JButton getButtonGerarHorario() {
		if (btnGerarHorrio == null) {
			btnGerarHorrio = new JButton("Gerar hor\u00E1rio");
			btnGerarHorrio.setBackground(Color.WHITE);
			btnGerarHorrio.setFont(new Font("Arial", Font.PLAIN, 14));
			btnGerarHorrio.setBounds(388, 297, 161, 23);
		}
		return btnGerarHorrio;
	}
}
