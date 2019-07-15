package controle;

/**
 *  @author Fl�via de Jesus Correia
 *  @author Ian Farias
 *  
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import banco.BancoEnderecoGerenciar;
import banco.BancoProfessorGerenciar;
import modelo.Arquivo;
import modelo.Endereco;
import modelo.Lists;
import modelo.Professor;
import visao.VisaoPainelCadastroProfessor;

public class ControlePainelCadastroProfessor implements ActionListener{
	
	VisaoPainelCadastroProfessor telaCadProfessor;
	Professor dados;
	private int contador;
	private int saida;
	private int volta;
	private String areaAtuacao;
	private ArrayList<String> areasAtuacao = new ArrayList<String>();
	private int numMatriculaProfessor;
	Calendar calendario = Calendar.getInstance();
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String uf;
	private String dataExpedicao;
	private String orgaoExp;
	private String cep;
	private String rua;
	private String complemento;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String email;
	private String telefone;
	private VisaoPainelCadastroProfessor telaCadAluno;
	private String celular;
	private String matricula;
	private String area;
	private String carga_Horaria;
	private Arquivo arquivo = new Arquivo(0);
	
	public ControlePainelCadastroProfessor(VisaoPainelCadastroProfessor telaCadProfessor, int volta) {
		this.telaCadProfessor = telaCadProfessor;
		telaCadProfessor.setVisible(true);
		this.volta = volta;
		AddEventos();
		preencheComboBox();
		numMatriculaProfessor = (calendario.get(Calendar.YEAR)*10000) + Main.aluno.size();
		telaCadProfessor.getTextFieldMatriculaProfessor().setText(String.valueOf(numMatriculaProfessor));
	}

	public void AddEventos(){
		telaCadProfessor.getButtonCancelar().addActionListener(this);
		telaCadProfessor.getButtonConfirmar().addActionListener(this);
		telaCadProfessor.getButtonVoltar().addActionListener(this);
		telaCadProfessor.getTextFieldNomeProfessor().addActionListener(this);
		telaCadProfessor.getTextFieldMatriculaProfessor().addActionListener(this);
		telaCadProfessor.getComboBoxAreaAtuacaoProfessor().addActionListener(this);
		telaCadProfessor.getComboBoxCargaHorariaProfessor().addActionListener(this);
		telaCadProfessor.getButtonAdicionarAreaAtuacao().addActionListener(this);
		telaCadProfessor.getComboBoxEstadoEndereco().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaCadProfessor.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadProfessor, 
														"Deseja realmente voltar?",
														"Confirma��o de sa�da", 
														JOptionPane.YES_NO_OPTION);
				if(saida == 0) {
					LimpaDados();
					if(volta == 1)
						ControlePainelTelaInicial.troca();
					else if(volta == 2)
						ControlePainelCadastro.troca();
					else
						ControlePainelConsulta.troca();
				}
				
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadProfessor.getComboBoxEstadoEndereco()) {
			if(!telaCadProfessor.getComboBoxEstadoEndereco().getSelectedItem().equals("SELECIONE")) {
				ArrayList<String> cidade = null;
				try {
					cidade = arquivo.EscreveCidades(telaCadProfessor.getComboBoxEstadoEndereco().getSelectedItem().toString());
					telaCadProfessor.getComboBoxCidades().removeAllItems();
					telaCadProfessor.getComboBoxCidades().addItem("SELECIONE");
					for(int i = 0; i < cidade.size(); i++) {
						telaCadProfessor.getComboBoxCidades().addItem(cidade.get(i));
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource() == telaCadProfessor.getButtonCancelar()){
			try {
				saida = JOptionPane.showConfirmDialog(telaCadProfessor, 
														"Deseja realmente cancelar o cadastro?",
														"Confirma��o de sa�da", 
														JOptionPane.YES_NO_OPTION);
				if(saida == 0) {
					LimpaDados();
					ControlePainelCadastro.troca();
				}
				
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadProfessor.getButtonAdicionarAreaAtuacao()) {
			try {
				areaAtuacao = JOptionPane.showInputDialog(telaCadProfessor,  "Insira o nome da �rea:", 
						 								  "Inserir", JOptionPane.OK_CANCEL_OPTION);
				if(!areaAtuacao.isEmpty()) {
					if(Validacoes(areaAtuacao, areasAtuacao) == 0) {
						areaAtuacao = areaAtuacao.toUpperCase();
						telaCadProfessor.getComboBoxAreaAtuacaoProfessor().addItem(areaAtuacao);
						areasAtuacao.add(areaAtuacao);
					}
				}	
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadProfessor.getButtonConfirmar()) {
			try {
				contador = 0;
				Arquivo arquivo = new Arquivo(0);
				if(!telaCadProfessor.getTextFieldNomeProfessor().getText().equals("                                                       ")) { 
					nome = arquivo.TiraEspa�os(telaCadProfessor.getTextFieldNomeProfessor().getText().toString().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo Nome n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
	
				}if(!telaCadProfessor.getComboBoxAreaAtuacaoProfessor().getSelectedItem().equals("SELECIONE")) {
					area = telaCadProfessor.getComboBoxAreaAtuacaoProfessor().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo �rea de Atua��o n�o selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
		
				}if(!telaCadProfessor.getComboBoxCargaHorariaProfessor().getSelectedItem().equals("SELECIONE")) {
					carga_Horaria = telaCadProfessor.getComboBoxCargaHorariaProfessor().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo Carga Hor�ria n�o selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
			
				}
				if(!(telaCadProfessor.getFormattedTextFieldDataNascimento().getText().equals("  /  /    "))) {	
					if(Lists.validaData(telaCadProfessor.getFormattedTextFieldDataNascimento().getText().split("/"))) {
							dataNascimento = telaCadProfessor.getFormattedTextFieldDataNascimento().getText();
							contador++;
					}else {
						JOptionPane.showMessageDialog(telaCadProfessor, "Data de nascimento inv�lida!", "Aviso", JOptionPane.ERROR_MESSAGE);
			
					}		
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo Data de nascimento n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);

				}
				if(!(telaCadProfessor.getFormattedTextFieldCpf().getText().equals("           "))) {
					if(!Lists.isCPF(telaCadProfessor.getFormattedTextFieldCpf().getText())){
						JOptionPane.showMessageDialog(telaCadProfessor, "CPF inv�lido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					
					}
					if(Validacoes(telaCadProfessor.getFormattedTextFieldCpf().getText(), 2) > 0) { //mudar depois
						JOptionPane.showMessageDialog(telaCadProfessor, "CPF j� cadastrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
				
					}
					else{
						cpf = telaCadProfessor.getFormattedTextFieldCpf().getText().toString();
						contador++;
					}
				}
				// tem essa quantidade de espa�os por conta da m�scara
				if(!telaCadProfessor.getFormattedTextFieldRg().getText().equals("")
					&& !(telaCadProfessor.getComboBoxEstadoRg().getSelectedItem().equals("SELECIONE"))) {
					
					rg = telaCadProfessor.getFormattedTextFieldRg().getText();
					uf = telaCadProfessor.getComboBoxEstadoRg().getSelectedItem().toString();
					if(Validacoes(rg, 3) > 0) { // mudar depois
						JOptionPane.showMessageDialog(telaCadProfessor, "RG e UF j� cadastrados!", "Aviso", JOptionPane.ERROR_MESSAGE);

					}else {
						contador= contador+2;
					}
				}else {
						JOptionPane.showMessageDialog(telaCadProfessor, "Campos RG e UF n�o preenchidos!", "Aviso", JOptionPane.ERROR_MESSAGE);
			
					}
				
				if(!(telaCadProfessor.getFormattedTextFieldDataRg().getText().equals("  /  /    "))) {	
					if(Lists.validaData(telaCadProfessor.getFormattedTextFieldDataRg().getText().split("/"))) {
							dataExpedicao = telaCadProfessor.getFormattedTextFieldDataRg().getText();
							contador++;
					}else {
						JOptionPane.showMessageDialog(telaCadProfessor, "Data de expedi��o inv�lida!", "Aviso", JOptionPane.ERROR_MESSAGE);
	
					}		
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo Data de Expedi��o n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
				
				}
				if(!(telaCadProfessor.getFormattedTextFieldOrgaoExpeditor().getText().equals("                                                       "))) {
					orgaoExp = arquivo.TiraEspa�os(telaCadProfessor.getFormattedTextFieldOrgaoExpeditor().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo �rg�o Expeditor n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
			
				}
				
				if(!(telaCadProfessor.getFormattedTextFieldCep().getText().equals("  .   -   "))) {
					cep = telaCadProfessor.getFormattedTextFieldCep().getText();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo CEP n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
				
				}
				if(!(telaCadProfessor.getFormattedTextFieldRua().getText().equals("                              "))) {
					rua = arquivo.TiraEspa�os(telaCadProfessor.getFormattedTextFieldRua().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo Rua n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
				
				}
				if(!(telaCadProfessor.getFormattedTextFieldComplemento().getText().equals("                              "))) {
					complemento = arquivo.TiraEspa�os(telaCadProfessor.getFormattedTextFieldComplemento().getText().toUpperCase());
				}else {
					complemento = null;
				}
				if(!(telaCadProfessor.getFormattedTextFieldNumero().getText().equals("                              "))) {
					numero = arquivo.TiraEspa�os(telaCadProfessor.getFormattedTextFieldNumero().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo N�mero n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);

				}
				if(!(telaCadProfessor.getFormattedTextFieldBairro().getText().equals("                              "))) {
					bairro = arquivo.TiraEspa�os(telaCadProfessor.getFormattedTextFieldBairro().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo Bairro n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
			
				}
				if(!(telaCadProfessor.getComboBoxCidades().getSelectedItem().equals("SELECIONE"))) {
					cidade = telaCadProfessor.getComboBoxCidades().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo Cidade n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
		
				}
				if(!telaCadProfessor.getComboBoxEstadoEndereco().getSelectedItem().equals("SELECIONE")) {
					estado = telaCadProfessor.getComboBoxEstadoEndereco().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo Estado n�o selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
				
				}
				if(!telaCadProfessor.getTextFieldEmail().getText().equals("")) {
					if(Lists.isEmail(telaCadProfessor.getTextFieldEmail().getText())) {
						email = telaCadProfessor.getTextFieldEmail().getText();
						contador++;
					}else {
						JOptionPane.showMessageDialog(telaCadProfessor, "E-mail inv�lido!", "Aviso", JOptionPane.ERROR_MESSAGE);
		
					}
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "Campo E-mail n�o preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);

				}
				if(!(telaCadProfessor.getFormattedTextFieldTelefone().getText().equals("(  )     -    "))) {
					telefone = telaCadProfessor.getFormattedTextFieldTelefone().getText();
					contador++;
				}else {
					if(telaCadAluno.getFormattedTextFieldCelular().getText().equals("(  )      -    ")) {
						JOptionPane.showMessageDialog(telaCadAluno, "Campo telefone ou celular deve ser preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
				
					}else{
						telefone = null;
					}
					
				}
				if(!(telaCadAluno.getFormattedTextFieldCelular().getText().equals("(  )      -    "))) {
					celular = telaCadAluno.getFormattedTextFieldCelular().getText();
					contador++;
				}else {
					if(telaCadAluno.getFormattedTextFieldTelefone().getText().equals("(  )     -    ")) {
						JOptionPane.showMessageDialog(telaCadAluno, "Campo telefone ou celular deve ser preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
				
					}else {
						celular = null;
					}
				}
				System.out.println("contador = "+contador);
				if((contador == 17 || contador == 18)){
					matricula = String.valueOf(numMatriculaProfessor);
					Endereco endereco = new Endereco(cep, rua, numero, complemento, bairro, cidade, estado);
					Professor professor = new Professor(nome, dataNascimento, matricula, area, carga_Horaria, email, telefone, celular, cpf, rg, uf, dataExpedicao, orgaoExp);
					boolean retorno1 = new BancoEnderecoGerenciar().inserirEndereco(endereco);
					boolean retorno2 = new BancoProfessorGerenciar().BancoProfessorInserir(professor);
					endereco.setId(new BancoEnderecoGerenciar().primeiroEultimo("idEndereco", 1));
					professor.setId(new BancoProfessorGerenciar().primeiroEultimo("idProfessor", 1));
					if (retorno1 && retorno2) {
						JOptionPane.showMessageDialog(telaCadProfessor, "Cadastro realizado com sucesso.");
						LimpaDados();
					}else {
						JOptionPane.showMessageDialog(telaCadProfessor, "Cadastro realizado sem sucesso.");
					}
				//	new Arquivo(1);
				}else {
					JOptionPane.showMessageDialog(telaCadProfessor, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", 
												"Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		
	}
	public int Validacoes(String dado, int tipo) {
		int contador = 0;
		// 1 - busca disciplina
		// 2 - busca CPF
		// 3 - busca RG
		try {
//			if(tipo == 1) {
//				for(int i = 0; i < disciplinas.size(); i++) {
//					//	System.out.println(disciplinas.get(i).toString());
//					if(disciplinas.get(i).toString().equals(dado)) {
//						contador++;
//						System.out.println(contador);
//					}
//				}
//			}
			if(tipo == 2) {
				for(int i = 0; i < Main.professor.size(); i++) {
					if(Main.professor.get(i).getCpf().equals(dado)) {
						contador++;
					}
				}
			}else if(tipo == 3) {
				for(int i = 0; i < Main.professor.size(); i++) {
					if(Main.professor.get(i).getRg().equals(dado)) {
						contador++;
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}


		return contador;
	}


	public int Validacoes(String nome, ArrayList<String> dados) {
		int contador = 0;
		System.out.println("la4");
		for(int i = 0; i < dados.size(); i++) {
			System.out.println(dados.get(i).toString());
			if(dados.get(i).toString().equals(nome)) {
				contador += 1;
				System.out.println(contador);
			}
		}
		return contador;
	}
	
	public void preencheComboBox() {
		
		areasAtuacao.add("CI�NCIAS EXATAS");
		areasAtuacao.add("CI�NCIAS HUMANAS");
		areasAtuacao.add("CI�NCIAS DA TERRA");
		areasAtuacao.add("CI�NCIAS BIOL�GICAS");
		areasAtuacao.add("CI�NCIAS SOCIAIS");
		areasAtuacao.add("CI�NCIAS NATURAIS");
		areasAtuacao.add("CI�NCIAS POL�TICAS");
		areasAtuacao.add("ADMINISTRA��O");
		areasAtuacao.add("PSICOLOGIA");
		areasAtuacao.add("REDES DE COMPUTADORES");
		ArrayList<String> areas = new BancoProfessorGerenciar().consultarUmaColuna("Professor", "areaAtuacao");
		for(int i = 0; i<areas.size(); i++) {
			contador = 0;
			for(int j = 0; j<areasAtuacao.size(); j++) {
				if(areas.get(i).equals(areasAtuacao.get(j))) {
					contador++;
				}
				
			}
			if(contador == 0)
					areasAtuacao.add(areas.get(i));
		}
		
		for(int i = 0; i<areasAtuacao.size(); i++) {
			telaCadProfessor.getComboBoxAreaAtuacaoProfessor().addItem(areasAtuacao.get(i).toString());
			
			
		}
	}
	
	public void LimpaDados() {
		telaCadProfessor.getTextFieldNomeProfessor().setText(null);
		telaCadProfessor.getTextFieldMatriculaProfessor().setText(null);
		telaCadProfessor.getComboBoxAreaAtuacaoProfessor().setSelectedIndex(0);
		telaCadProfessor.getComboBoxCargaHorariaProfessor().setSelectedIndex(0);
	}
}
