package controle;

/**
 *  @author Flávia de Jesus Correia
 *  @author Ian Farias 
 *  
 * */
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import banco.BancoAlunoGerenciar;
import banco.BancoCursoGerenciar;
import banco.BancoDisciplinaGerenciar;
import banco.BancoEnderecoGerenciar;
import visao.VisaoPainelCadastroAluno;
import controle.ControlePainelCadastros;
import modelo.Aluno;
import modelo.Endereco;
import modelo.validacao.Lists;

public class ControlePainelCadastroAluno implements ActionListener{
	VisaoPainelCadastroAluno telaCadAluno;
	Aluno dados;
	ControleArquivo arquivo = new ControleArquivo(0);
	Calendar calendario = Calendar.getInstance();
	private int contador;
	private int saida;
	private int volta;
	private int erros;
	private String disciplina = "";
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String tipo;
	private String nome;
	private String matricula;
	private String dataNascimento;
	private String email;
	private String telefone;
	private String celular;
	private String cpf;
	private String rg;
	private String uf;
	private String dataExpedicao;
	private String orgaoExp;
	private String curso;
	private ArrayList<String> disciplinas = new ArrayList<String>();
	private int numMatriculaAluno;



	public ControlePainelCadastroAluno(VisaoPainelCadastroAluno telaCadAluno, int volta) {
		this.telaCadAluno = telaCadAluno;
		this.volta = volta;
		telaCadAluno.setVisible(true);
		System.out.println("Cad Aluno");
		AddEventos();
		preecheComboBox();
		numMatriculaAluno = (calendario.get(Calendar.YEAR)*10000) + Main.aluno.size();
		telaCadAluno.getFormattedTextFieldMatriculaAluno().setText(String.valueOf(numMatriculaAluno));

	}

	public void troca() {
		telaCadAluno.setVisible(true);
		//((FramePrincipal) FramePrincipal.getInstance()).trocarPainel(aluno, "MINI-MUNDO");
	}

	public void AddEventos(){
		System.out.println("evt Aluno");
		telaCadAluno.getButtonCancelar().addActionListener(this);
		telaCadAluno.getButtonConfirmar().addActionListener(this);
		telaCadAluno.getButtonVoltar().addActionListener(this);
		telaCadAluno.getFormattedTextFieldMatriculaAluno().addActionListener(this);
		telaCadAluno.getFormattedTextFieldCpf().addActionListener(this);
		telaCadAluno.getFormattedTextFieldRg().addActionListener(this);
		telaCadAluno.getFormattedTextFieldNomeAluno().addActionListener(this);
		telaCadAluno.getComboBoxCurso().addActionListener(this);
		telaCadAluno.getComboBoxHistoricoDisciplinas().addActionListener(this);
		telaCadAluno.getButtonAdicionarDisciplina().addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaCadAluno.getButtonVoltar()) {
			try {
				saida = JOptionPane.showConfirmDialog(telaCadAluno, 
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
		
		if(e.getSource() == telaCadAluno.getButtonCancelar()){
			try {
				saida = JOptionPane.showConfirmDialog(telaCadAluno, 
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
		if(e.getSource() == telaCadAluno.getButtonAdicionarDisciplina()) {
			if(disciplinas == null) {
				disciplinas = new ArrayList<String>();
			}
			try {
				System.out.println("button Add Disc");
				disciplina = JOptionPane.showInputDialog(telaCadAluno,  "Insira o nome da disciplina:", 
						"Inserir", JOptionPane.OK_CANCEL_OPTION);
				System.out.println("la0");

				if(!disciplina.equals("")){
					disciplina = disciplina.toUpperCase();
					System.out.println("size array disciplinas = "  + disciplinas.size());
					if(Validacoes(disciplina, 1) == 0) {
						telaCadAluno.getComboBoxHistoricoDisciplinas().addItem(disciplina);
						disciplinas.add(disciplina);
					}else {
						System.out.println("la3");
						JOptionPane.showMessageDialog(telaCadAluno, "Nome já incluso.", 
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource() == telaCadAluno.getButtonConfirmar()) {
			try {
				numMatriculaAluno = (calendario.get(Calendar.YEAR)*10000) + Main.aluno.size(); //mudar depois
				erros = 0;
				contador = 0;
				
				// tem essa quantidade de espaços por conta da máscara
				if(!telaCadAluno.getFormattedTextFieldNomeAluno().getText().equals("                                                       ")) { 
					nome = arquivo.TiraEspaços(telaCadAluno.getFormattedTextFieldNomeAluno().getText().toString().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Nome não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!(telaCadAluno.getFormattedTextFieldDataNascimento().getText().equals("  /  /    "))) {	
					if(Lists.validaData(telaCadAluno.getFormattedTextFieldDataNascimento().getText().split("/"))) {
							dataNascimento = telaCadAluno.getFormattedTextFieldDataNascimento().getText();
							contador++;
					}else {
						JOptionPane.showMessageDialog(telaCadAluno, "Data de nascimento inválida!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros ++;
					}		
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Data de nascimento não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!(telaCadAluno.getFormattedTextFieldCpf().getText().equals("           "))) {
					if(!Lists.isCPF(telaCadAluno.getFormattedTextFieldCpf().getText())){
						JOptionPane.showMessageDialog(telaCadAluno, "CPF inválido!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros ++;
					}
					if(Validacoes(telaCadAluno.getFormattedTextFieldCpf().getText(), 2) > 0) { //mudar depois
						JOptionPane.showMessageDialog(telaCadAluno, "CPF já cadastrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros ++;
					}
					else{
						cpf = telaCadAluno.getFormattedTextFieldCpf().getText().toString();
						contador++;
					}
				}
				// tem essa quantidade de espaços por conta da máscara
				if(!telaCadAluno.getFormattedTextFieldRg().getText().equals("")
					&& !(telaCadAluno.getComboBoxEstadoRg().getSelectedItem().equals("SELECIONE"))) {
					
					rg = telaCadAluno.getFormattedTextFieldRg().getText();
					uf = telaCadAluno.getComboBoxEstadoRg().getSelectedItem().toString();
					if(Validacoes(rg, 3) > 0) { // mudar depois
						JOptionPane.showMessageDialog(telaCadAluno, "RG e UF já cadastrados!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros ++;
					}else {
						contador= contador+2;
					}
				}else {
						JOptionPane.showMessageDialog(telaCadAluno, "Campos RG e UF não preenchidos!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros++;
					}
				
				if(!(telaCadAluno.getFormattedTextFieldDataRg().getText().equals("  /  /    "))) {	
					if(Lists.validaData(telaCadAluno.getFormattedTextFieldDataRg().getText().split("/"))) {
							dataExpedicao = telaCadAluno.getFormattedTextFieldDataRg().getText();
							contador++;
					}else {
						JOptionPane.showMessageDialog(telaCadAluno, "Data de expedição inválida!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros ++;
					}		
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Data de Expedição não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!(telaCadAluno.getFormattedTextFieldOrgaoExpeditor().getText().equals("                                                       "))) {
					orgaoExp = arquivo.TiraEspaços(telaCadAluno.getFormattedTextFieldOrgaoExpeditor().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Órgão Expeditor não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				
				if(!(telaCadAluno.getComboBoxCurso().getSelectedItem().equals("SELECIONE"))) {
					curso =telaCadAluno.getComboBoxCurso().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Curso não selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				
				
				if(!(telaCadAluno.getFormattedTextFieldCep().getText().equals("  .   -   "))) {
					cep = telaCadAluno.getFormattedTextFieldCep().getText();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo CEP não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!(telaCadAluno.getFormattedTextFieldRua().getText().equals("                              "))) {
					rua = arquivo.TiraEspaços(telaCadAluno.getFormattedTextFieldRua().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Rua não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!(telaCadAluno.getFormattedTextFieldComplemento().getText().equals("                              "))) {
					complemento = arquivo.TiraEspaços(telaCadAluno.getFormattedTextFieldComplemento().getText().toUpperCase());
				}else {
					complemento = null;
				}
				if(!(telaCadAluno.getFormattedTextFieldNumero().getText().equals("                              "))) {
					numero = arquivo.TiraEspaços(telaCadAluno.getFormattedTextFieldNumero().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Número não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!(telaCadAluno.getFormattedTextFieldBairro().getText().equals("                              "))) {
					bairro = arquivo.TiraEspaços(telaCadAluno.getFormattedTextFieldBairro().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Bairro não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!(telaCadAluno.getFormattedTextFieldCidade().getText().equals("                              "))) {
					cidade = arquivo.TiraEspaços(telaCadAluno.getFormattedTextFieldCidade().getText().toUpperCase());
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Cidade não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!telaCadAluno.getComboBoxEstadoEndereco().getSelectedItem().equals("SELECIONE")) {
					estado = telaCadAluno.getComboBoxEstadoEndereco().getSelectedItem().toString();
					contador++;
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo Estado não selecionado!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!telaCadAluno.getTextFieldEmail().getText().equals("")) {
					if(Lists.isEmail(telaCadAluno.getTextFieldEmail().getText())) {
						email = telaCadAluno.getTextFieldEmail().getText();
						contador++;
					}else {
						JOptionPane.showMessageDialog(telaCadAluno, "E-mail inválido!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros++;
					}
				}else {
					JOptionPane.showMessageDialog(telaCadAluno, "Campo E-mail não preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
					erros++;
				}
				if(!(telaCadAluno.getFormattedTextFieldTelefone().getText().equals("(  )     -    "))) {
					telefone = telaCadAluno.getFormattedTextFieldTelefone().getText();
					contador++;
				}else {
					if(telaCadAluno.getFormattedTextFieldCelular().getText().equals("(  )      -    ")) {
						JOptionPane.showMessageDialog(telaCadAluno, "Campo telefone ou celular deve ser preenchido!", "Aviso", JOptionPane.ERROR_MESSAGE);
						erros++;
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
						erros++;
					}else {
						celular = null;
					}
				}
				System.out.println("contador = "+contador);
				if((contador == 16 || contador == 17)){
					tipo = "ALUNO";
					matricula = String.valueOf(numMatriculaAluno);
					Endereco endereco = new Endereco(cep, rua, numero, complemento, bairro, cidade, estado, tipo);
					Aluno aluno = new Aluno( nome, matricula, dataNascimento, email, telefone, celular, cpf, rg, uf, 
							dataExpedicao, orgaoExp, curso, disciplinas);
					new ControleArquivo(1);
						
					
					int count = 0;
					boolean retorno1 = new BancoEnderecoGerenciar().inserirEndereco(endereco);
					boolean rotorno2 = new BancoAlunoGerenciar().BancoAlunoInserir(aluno);
					boolean retorno3 = false;
					if(disciplinas.size() > 0) {
						int idAluno = new BancoAlunoGerenciar().primeiroEultimo("Aluno", "idAluno", 1);
						for(int i = 0; i < disciplinas.size(); i++) {
							
							try {
								int idDisciplina = Integer.parseInt(new BancoDisciplinaGerenciar().consultar("Disciplina", "nomeDisciplina", 
										disciplinas.get(i).toString(), "idDisciplina"));
								double media = Double.parseDouble(JOptionPane.showInputDialog(telaCadAluno, 
										"Insira a média na disciplina " + disciplinas.get(i).toString(), 
										"Solicitação", JOptionPane.OK_CANCEL_OPTION));
								
								retorno3 = new BancoAlunoGerenciar().inserirHistoricoDisciplinas(disciplinas.get(i).toString(), 
										idAluno, idDisciplina, String.valueOf(media));
								if(retorno3)
									count++;
								
							}catch(Exception e1) {
								JOptionPane.showMessageDialog(telaCadAluno, "Valor inserido não aceito.", 
										"Erro", JOptionPane.ERROR_MESSAGE);
								i--;
							}
							
						}
						
					}
					if((retorno1 && rotorno2) && count == disciplinas.size()) {
						JOptionPane.showMessageDialog(telaCadAluno, "Cadastro realizado com sucesso.");
						LimpaDados();
					}
					else {
						JOptionPane.showMessageDialog(telaCadAluno, "Cadastro realizado sem sucesso.");
					}
					
					
				}else{
						JOptionPane.showMessageDialog(telaCadAluno, "Todos os campos devem ser preenchidos.", "Aviso",
								JOptionPane.WARNING_MESSAGE);
				}

			}catch(Exception e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}

	}

	public void preecheComboBox() {
		ArrayList<String> disc = new BancoCursoGerenciar().consultarUmaColuna("Curso", "nomeCurso");
		telaCadAluno.getComboBoxCurso().addItem("SELECIONE");
		try {
			for(int i = 0; i<disc.size(); i++) {
				telaCadAluno.getComboBoxCurso().addItem(disc.get(i).toString());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public int Validacoes(String dado, int tipo) {
		int contador = 0;
		// 1 - busca disciplina
		// 2 - busca CPF
		// 3 - busca RG
		try {
			if(tipo == 1) {
				for(int i = 0; i < disciplinas.size(); i++) {
					//	System.out.println(disciplinas.get(i).toString());
					if(disciplinas.get(i).toString().equals(dado)) {
						contador++;
						System.out.println(contador);
					}
				}
			}else if(tipo == 2) {
				for(int i = 0; i < Main.aluno.size(); i++) {
					if(Main.aluno.get(i).getCpf().equals(dado)) {
						contador++;
					}
				}
			}else if(tipo == 3) {
				for(int i = 0; i < Main.aluno.size(); i++) {
					if(Main.aluno.get(i).getRg().equals(dado)) {
						contador++;
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}


		return contador;
	}

	public void LimpaDados() {
		numMatriculaAluno = (calendario.get(Calendar.YEAR)*10000) + Main.aluno.size();
		telaCadAluno.getFormattedTextFieldMatriculaAluno().setText(String.valueOf(numMatriculaAluno));
		telaCadAluno.getFormattedTextFieldNomeAluno().setText(null);
		telaCadAluno.getFormattedTextFieldCpf().setText(null);
		telaCadAluno.getFormattedTextFieldMatriculaAluno().setText(null);
		telaCadAluno.getFormattedTextFieldRg().setText(null);
		telaCadAluno.getComboBoxCurso().setSelectedIndex(0);
		telaCadAluno.getComboBoxEstadoRg().setSelectedIndex(0);
		telaCadAluno.getFormattedTextFieldDataNascimento().setText(null);
		telaCadAluno.getFormattedTextFieldDataRg().setText(null);
		telaCadAluno.getTextFieldEmail().setText(null);
		telaCadAluno.getFormattedTextFieldTelefone().setText(null);
		telaCadAluno.getFormattedTextFieldCelular().setText(null);
		telaCadAluno.getFormattedTextFieldOrgaoExpeditor().setText(null);
		telaCadAluno.getComboBoxHistoricoDisciplinas().removeAllItems();
		telaCadAluno.getFormattedTextFieldRua().setText(null);
		telaCadAluno.getFormattedTextFieldNumero().setText(null);
		telaCadAluno.getFormattedTextFieldComplemento().setText(null);
		telaCadAluno.getFormattedTextFieldBairro().setText(null);
		telaCadAluno.getFormattedTextFieldCidade().setText(null);
		telaCadAluno.getFormattedTextFieldCep().setText(null);
		telaCadAluno.getComboBoxEstadoEndereco().setSelectedIndex(0);
		if(disciplinas.size() > 0)
			disciplinas.clear();
	}
}
