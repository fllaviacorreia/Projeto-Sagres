package visao;

/**
 *  @author Flávia de Jesus Correia
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VisaoPainelCadastroClasse extends JPanel{
	private JLabel 			  labelDisciplina 			= null;
	private JLabel 			  labelProfessores 			= null;
	private JLabel 			  labelAlunos 				= null;
	private JLabel 			  labelAno 					= null;
	private JLabel 			  labelSemestre 			= null;
	private JLabel 			  labelCurso 				= null;
	private JLabel 			  labelDia1					= null;
	private JLabel 			  labelDia2					= null;
	private JLabel 			  labelDia3					= null;
	private JLabel 			  labelHora1				= null;
	private JLabel 			  labelHora2				= null;
	private JLabel 			  labelHora3				= null;
	private JTextField 		  textFieldAno				= null;
	private JTextField 		  textFieldDia1				= null;
	private JTextField 		  textFieldDia2				= null;
	private JTextField 		  textFieldDia3				= null;
	private JTextField 		  textFieldHora1			= null;
	private JTextField 		  textFieldHora2			= null;
	private JTextField 		  textFieldHora3			= null;
	private JComboBox<String> comboBoxDisciplina 		= null;
	private JComboBox<String> comboBoxProfessores 		= null;
	private JComboBox<String> comboBoxAlunos 		  	= null;
	private JComboBox<String> comboBoxSemestre 	 		= null;
	private JComboBox<String> comboBoxCurso 			= null;
	private JButton 		  buttonVoltar 	 			= null;
	private JButton 		  buttonCancelar 	 		= null;
	private JButton 		  buttonConfirmar   		= null;
	private JButton 		  buttonAdicionarProfessor  = null;
	private JButton 		  buttonAdicionarAluno  	= null;
//	private JButton 		  buttonGerarHorrio;
	private Calendar calendario = Calendar.getInstance();
	
	public VisaoPainelCadastroClasse() {
		this.setLayout(null);
		this.setBackground(new Color(120, 205, 194));
		this.setMinimumSize(new Dimension(1200, 720));
		this.setMaximumSize(new Dimension(1200, 720));
		this.setVisible(true);
		this.add(getLabelDisciplina());
		this.add(getLabelProfessores());
		this.add(getLabelAlunos());
		this.add(getLabelCurso());
		this.add(getLabelAno());
		this.add(getLabelDia1());
		this.add(getLabelDia2());
		this.add(getLabelDia3());
		this.add(getLabelHora1());
		this.add(getLabelHora2());
		this.add(getLabelHora3());
		this.add(getLabelSemestre());
		this.add(getTextFieldAno());
		this.add(getTextFieldDia1());
		this.add(getTextFieldDia2());
		this.add(getTextFieldDia3());
		this.add(getTextFieldHora1());
		this.add(getTextFieldHora2());
		this.add(getTextFieldHora3());
		this.add(getComboBoxDisciplina());
		this.add(getComboBoxProfessores());
		this.add(getComboBoxAlunos());
		this.add(getComboBoxSemestre());
		this.add(getComboBoxCurso());
		this.add(getButtonCancelar());
		this.add(getButtonConfirmar());
		this.add(getButtonVoltar());
		this.add(getButtonAdicionarAluno());
		this.add(getButtonAdicionarProfessor());
//		this.add(getButtonGerarHorario());
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
			labelAno.setBounds(53, 271, 47, 25);
			labelAno.setForeground(Color.BLACK);
			labelAno.setFont(new Font("Arial", Font.PLAIN, 14));
			labelAno.setVisible(true);
		}
		return labelAno;
	}

	public JLabel getLabelSemestre() {
		if(labelSemestre == null) {
			labelSemestre = new JLabel("Semestre:");
			labelSemestre.setBounds(158, 271, 83, 25);
			labelSemestre.setForeground(Color.BLACK);
			labelSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
			labelSemestre.setVisible(true);
		}
		return labelSemestre;
	}
	public JLabel getLabelCurso() {
		if (labelCurso == null) {
			labelCurso = new JLabel("Curso:");
			labelCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			labelCurso.setBounds(53, 32, 46, 25);
		}
		return labelCurso;
	}
	public JLabel getLabelDia1() {
		if (labelDia1 == null) {
			labelDia1 = new JLabel("Dia 1:");
			labelDia1.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDia1.setBounds(53, 350, 60, 25);
		}
		return labelDia1;
	}

	public JLabel getLabelDia2() {
		if (labelDia2 == null) {
			labelDia2 = new JLabel("Dia 2:");
			labelDia2.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDia2.setBounds(225, 350, 83, 25);
		}
		return labelDia2;
	}

	public JLabel getLabelDia3() {
		if (labelDia3 == null) {
			labelDia3 = new JLabel("Dia 3:");
			labelDia3.setFont(new Font("Arial", Font.PLAIN, 14));
			labelDia3.setBounds(397, 350, 60, 25);
		}
		return labelDia3;
	}

	public JLabel getLabelHora1() {
		if (labelHora1 == null) {
			labelHora1 = new JLabel("Hora 1:");
			labelHora1.setFont(new Font("Arial", Font.PLAIN, 14));
			labelHora1.setBounds(53, 410, 60, 25);
		}
		return labelHora1;
	}

	public JLabel getLabelHora2() {
		if (labelHora2 == null) {
			labelHora2 = new JLabel("Hora 2:");
			labelHora2.setFont(new Font("Arial", Font.PLAIN, 14));
			labelHora2.setBounds(226, 410, 60, 25);
		}
		return labelHora2;
	}

	public JLabel getLabelHora3() {
		if (labelHora3 == null) {
			labelHora3 = new JLabel("Hora 3:");
			labelHora3.setFont(new Font("Arial", Font.PLAIN, 14));
			labelHora3.setBounds(397, 410, 162, 25);
		}
		return labelHora3;
	}

	public JTextField getTextFieldAno() {
		if (textFieldAno == null) {
			textFieldAno = new JTextField();
			textFieldAno.setFont(new Font("Arial", Font.PLAIN, 14));
			textFieldAno.setText(String.valueOf(calendario.get(Calendar.YEAR)));
			textFieldAno.setForeground(Color.BLACK);
			textFieldAno.setBounds(53, 298, 69, 25);
			textFieldAno.setColumns(10);
			textFieldAno.setEditable(false);
		}
		return textFieldAno;
	}
	
	public JTextField getTextFieldDia1() {
		if (textFieldDia1 == null) {
			textFieldDia1 = new JTextField();
			textFieldDia1.setForeground(Color.BLACK);
			textFieldDia1.setBounds(53, 370, 162, 25);
			textFieldDia1.setColumns(10);
			textFieldDia1.setEditable(false);
		}
		return textFieldDia1;
	}

	public JTextField getTextFieldDia2() {
		if (textFieldDia2 == null) {
			textFieldDia2 = new JTextField();
			textFieldDia2.setForeground(Color.BLACK);
			textFieldDia2.setBounds(225, 370, 162, 25);
			textFieldDia2.setColumns(10);
			textFieldDia2.setEditable(false);
		}
		return textFieldDia2;
	}

	public JTextField getTextFieldDia3() {
		if (textFieldDia3 == null) {
			textFieldDia3 = new JTextField();
			textFieldDia3.setForeground(Color.BLACK);
			textFieldDia3.setBounds(397, 370, 162, 25);
			textFieldDia3.setColumns(10);
			textFieldDia3.setEditable(false);
		}
		return textFieldDia3;
	}

	public JTextField getTextFieldHora1() {
		if (textFieldHora1 == null) {
			textFieldHora1 = new JTextField();
			textFieldHora1.setForeground(Color.BLACK);
			textFieldHora1.setBounds(53, 430, 162, 25);
			textFieldHora1.setColumns(10);
			textFieldHora1.setEditable(false);
		}
		return textFieldHora1;
	}

	public JTextField getTextFieldHora2() {
		if (textFieldHora2 == null) {
			textFieldHora2 = new JTextField();
			textFieldHora2.setForeground(Color.BLACK);
			textFieldHora2.setBounds(225, 430, 162, 25);
			textFieldHora2.setColumns(10);
			textFieldHora2.setEditable(false);
		}
		return textFieldHora2;
	}

	public JTextField getTextFieldHora3() {
		if (textFieldHora3 == null) {
			textFieldHora3 = new JTextField();
			textFieldHora3.setForeground(Color.BLACK);
			textFieldHora3.setBounds(397, 430, 162, 25);
			textFieldHora3.setColumns(10);
			textFieldHora3.setEditable(false);
		}
		return textFieldHora3;
	}

	public JComboBox<String> getComboBoxCurso() {
		if (comboBoxCurso == null) {
			comboBoxCurso = new JComboBox<String>();
			comboBoxCurso.setBackground(Color.WHITE);
			comboBoxCurso.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxCurso.addItem("SELECIONE");
			comboBoxCurso.setEnabled(true);
			comboBoxCurso.setBounds(53, 58, 277, 25);
		}
		return comboBoxCurso;
	}
	public JComboBox<String> getComboBoxDisciplina() {
		if(comboBoxDisciplina == null) {
			comboBoxDisciplina = new JComboBox<String>();
			comboBoxDisciplina.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxDisciplina.setBackground(new Color(255, 255, 255));
			comboBoxDisciplina.setBounds(382, 58, 372, 25);
//			comboBoxDisciplina.addItem("SELECIONE");
			comboBoxDisciplina.setVisible(true);
		}
		return comboBoxDisciplina;
	}

	public JComboBox<String> getComboBoxProfessores() {
		if(comboBoxProfessores == null) {
			comboBoxProfessores = new JComboBox<String>();
			comboBoxProfessores.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxProfessores.setBackground(new Color(255, 255, 255));
			comboBoxProfessores.setBounds(53, 139, 372, 25);
			comboBoxProfessores.setVisible(true);
		}
		return comboBoxProfessores;
	}

	public JComboBox<String> getComboBoxAlunos() {
		if(comboBoxAlunos == null) {
			comboBoxAlunos = new JComboBox<String>();
			comboBoxAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxAlunos.setBackground(new Color(255, 255, 255));
			comboBoxAlunos.setBounds(53, 218, 372, 25);
			comboBoxAlunos.setVisible(true);
		}
		return comboBoxAlunos;
	}
	
	public JComboBox<String> getComboBoxSemestre() {
		if(comboBoxSemestre == null) {
			comboBoxSemestre = new JComboBox<String>();
			comboBoxSemestre.setFont(new Font("Arial", Font.PLAIN, 14));
			comboBoxSemestre.setBackground(new Color(255, 255, 255));
			comboBoxSemestre.setBounds(158, 297, 136, 25);
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
			buttonAdicionarProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonAdicionarProfessor.setBounds(435, 139, 167, 25);
			buttonAdicionarProfessor.setBackground(Color.WHITE);
			buttonAdicionarProfessor.setVisible(true);
		}
		return buttonAdicionarProfessor;
	}
	
	public JButton getButtonAdicionarAluno() {
		if(buttonAdicionarAluno == null) {
			buttonAdicionarAluno = new JButton("Adicionar aluno");
			buttonAdicionarAluno.setFont(new Font("Arial", Font.PLAIN, 14));
			buttonAdicionarAluno.setBounds(435, 218, 167, 25);
			buttonAdicionarAluno.setBackground(Color.WHITE);
			buttonAdicionarAluno.setVisible(true);
		}
		return buttonAdicionarAluno;
	}
	
//	public JButton getButtonGerarHorario() {
//		if (buttonGerarHorrio == null) {
//			buttonGerarHorrio = new JButton("Gerar hor\u00E1rio");
//			buttonGerarHorrio.setBackground(Color.WHITE);
//			buttonGerarHorrio.setFont(new Font("Arial", Font.PLAIN, 14));
//			buttonGerarHorrio.setBounds(388, 297, 161, 23);
//		}
//		return buttonGerarHorrio;
//	}
}
