package controle;

/**
 *  @author Flávia de Jesus Correia
 *  @author Ian Farias
 *  
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Curso;
import visao.VisaoFramePrincipal;
import visao.VisaoPainelCadastroCurso;
import visao.VisaoPainelFluxograma;

public class ControlePainelCadastroCurso implements ActionListener{
	static VisaoPainelCadastroCurso telaCadCurso;
	static VisaoPainelFluxograma telaFluxograma;
	static VisaoFramePrincipal framePrincipal;
	Curso dados;
	private int contador;
	private int saida;
	private int volta;
	private int cargaHoraria;
	private String disciplina = "";
	private ArrayList<String> disciplinas = new ArrayList<String>();

	
	public ControlePainelCadastroCurso(VisaoFramePrincipal framePrincipal, VisaoPainelCadastroCurso telaCadCurso, int volta) {
		this.framePrincipal = framePrincipal;
		this.telaCadCurso = telaCadCurso;
		this.volta = volta;
		telaCadCurso.setVisible(true);
		AddEventos();
		preecheComboBox();
	}
	
	public static void troca() {
		telaCadCurso.setVisible(true);
		framePrincipal.trocarPainel(telaCadCurso, "Cadastro Curso");
	}
	
	public void AddEventos(){
		telaCadCurso.getButtonAdicionarCargaHoraria().addActionListener(this);
		telaCadCurso.getButtonAdicionarDisciplina().addActionListener(this);
		telaCadCurso.getButtonCancelar().addActionListener(this);
		telaCadCurso.getButtonConfirmar().addActionListener(this);
		telaCadCurso.getButtonVoltar().addActionListener(this);
		telaCadCurso.getButtonGerarFluxograma().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaCadCurso.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadCurso, 
														"Deseja realmente voltar?",
														"Confirmação de saída", 
														JOptionPane.YES_NO_OPTION);
				if(saida == 0) {
					LimpaDados();
					if(volta == 1)
						ControlePainelTelaInicial.troca();
					else
						ControlePainelCadastros.troca();
				}	
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == telaCadCurso.getButtonCancelar()){
			try {
				saida = JOptionPane.showConfirmDialog(telaCadCurso, 
														"Deseja realmente cancelar o cadastro?",
														"Confirmação de saída", 
														JOptionPane.YES_NO_OPTION);
				if(saida == 0) {
					LimpaDados();
					ControlePainelCadastros.troca();
				}
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadCurso.getButtonAdicionarCargaHoraria()){
			try {
				cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog(telaCadCurso,  
																			"Insira a carga horária:", 
																			"Inserir", 
																			JOptionPane.OK_CANCEL_OPTION));
				
				if(!String.valueOf(cargaHoraria).isEmpty()) {
					telaCadCurso.getComboBoxCargaHorariaTotal().addItem(String.valueOf(cargaHoraria));
				}
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadCurso.getButtonAdicionarDisciplina()){
			if(!telaCadCurso.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
				try {
					disciplina = JOptionPane.showInputDialog(telaCadCurso,  "Insira o nome da disciplina:", 
							  								"Inserir", JOptionPane.OK_CANCEL_OPTION);
					
					if(!disciplina.equals("")) {
						disciplina = disciplina.toUpperCase();
						telaCadCurso.getComboBoxDisciplinas().addItem(disciplina);
					}
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(telaCadCurso,  "Insira o nome do curso.", 
						  "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		if(e.getSource() == telaCadCurso.getButtonConfirmar()){
			try {
				dados = new Curso();
				contador = 0;
				if(!telaCadCurso.getComboBoxCurso().getSelectedItem().equals("SELECIONE")) {
					dados.setNome(telaCadCurso.getComboBoxCurso().getSelectedItem().toString());
					contador++;
				}
				if(!telaCadCurso.getComboBoxSemestresTotais().getSelectedItem().equals("SELECIONE")) {
					dados.setSemestres(telaCadCurso.getComboBoxSemestresTotais().getSelectedItem().toString());
					contador++;
				}
				if(!telaCadCurso.getComboBoxCargaHorariaTotal().getSelectedItem().equals("SELECIONE")) {
					dados.setCargaHorariaTotal(telaCadCurso.getComboBoxCargaHorariaTotal().getSelectedItem().toString());
					contador++;
				}
				if(telaCadCurso.getComboBoxDisciplinas().getSelectedItem() != null) {
					dados.setDisciplinas(disciplinas);
					contador++;
				}
				if(!telaCadCurso.getComboBoxHorario().getSelectedItem().equals("SELECIONE")) {
					dados.setTipoCurso(telaCadCurso.getComboBoxHorario().getSelectedItem().toString());
					contador++;
				}
				if(contador == 5) {
					Main.curso.add(dados);
					new ControleArquivo(3);
					JOptionPane.showMessageDialog(telaCadCurso, "Cadastro realizado com sucesso.");
					LimpaDados();
				}else {
					JOptionPane.showMessageDialog(telaCadCurso, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", 
							"Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadCurso.getButtonGerarFluxograma()) {
//			if(contador != 5)
//				JOptionPane.showMessageDialog(telaCadCurso, "Necessário salvar os dados primeiro", 
//						"Aviso",JOptionPane.INFORMATION_MESSAGE);
//			
//			else {
//				
				if(telaFluxograma == null) {
					telaFluxograma = new VisaoPainelFluxograma(telaCadCurso.getComboBoxCurso().getSelectedItem().toString(), 
							telaCadCurso.getComboBoxHorario().getSelectedItem().toString(), 
							telaCadCurso.getComboBoxCargaHorariaTotal().getSelectedItem().toString());
				}
				framePrincipal.trocarPainel(telaFluxograma, "Fluxograma");
				new ControlePainelFluxograma(framePrincipal, telaFluxograma);
//			}
		}
	}
	
	// método que preenche o comboBox curso com os adicionados e cadastrados ta telaDisciplina
	
	public void preecheComboBox() {
		telaCadCurso.getComboBoxCurso().addItem("SELECIONE");
		ArrayList<String> disc = new ArrayList<String>();
		String dis;
		dis = Main.disciplina.get(0).getCurso();
		disc.add(dis);
		int cont;
		for(int i = 1; i < Main.disciplina.size(); i++) {
			cont = 0;
			dis = Main.disciplina.get(i).getCurso().toString();
			
			if(disc.get(i).equals(dis)) {
				cont ++;
			}
			if(cont == 0)
				disc.add(dis);
		}
		
		for(int i = 0; i<disc.size(); i++) {
			telaCadCurso.getComboBoxCurso().addItem(disc.get(i).toString());
		}
	}
	
	public void LimpaDados() {
		telaCadCurso.getComboBoxCargaHorariaTotal().setSelectedIndex(0);
		telaCadCurso.getComboBoxHorario().setSelectedIndex(0);
		telaCadCurso.getComboBoxDisciplinas().removeAllItems();
		telaCadCurso.getComboBoxCurso().removeAllItems();
		telaCadCurso.getComboBoxSemestresTotais().setSelectedIndex(0);
	}

}
