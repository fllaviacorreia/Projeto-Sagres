package modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.Main;

@SuppressWarnings("serial")
public class ModeloTabelaAluno extends AbstractTableModel{
	String [] columnName = {"N� MATRICULA","CPF","NOME","CONTATO","DATA NASCIMENTO"};		//nome das coluna 
	ArrayList<Aluno> arrayAluno = null;
	
	public ModeloTabelaAluno() {
		arrayAluno = Main.aluno;
	}

	public String[] getColumnName() {
		return columnName;
	}

	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}

// --------------------------- IN�CIO DOS M�TODOS OBRIGAT�RIOS DO ABSTRACT TABLE MODEL ------------------------------------ \\
	@Override
	public int getColumnCount() {
		//retorna a quantidade de colunas na tabela
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		//retorna a quantidade de linhas da tabela
		return Main.aluno.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// retorna o valor em determinada c�lula, dado os argumentos de posi��o de linha e coluna
		switch (coluna) {
		case 0://coluna matricula
			return arrayAluno.get(linha).getMatricula();
		case 1://coluna cpf
			return arrayAluno.get(linha).getCpf();		
		case 2://coluna nome
			return arrayAluno.get(linha).getNome();
		case 3://coluna telefone
			if(!( arrayAluno.get(linha).getTelefone().equals(null) ) && ( arrayAluno.get(linha).getCelular().equals(null) ) )
				return arrayAluno.get(linha).getTelefone();
			else if( (arrayAluno.get(linha).getTelefone().equals(null)) &&  ! (arrayAluno.get(linha).getCelular().equals(null)) )
				return arrayAluno.get(linha).getCelular();
			else
				return arrayAluno.get(linha).getTelefone() + "/" + arrayAluno.get(linha).getCelular();
		case 4: // coluna data de nascimento
			return arrayAluno.get(linha).getDataNascimento();
		default:
			return arrayAluno.get(linha);
		} 
	}
	@Override
    public String getColumnName(int columnIndex){
		// retorna o nome da coluna em determinado �ndice
      return columnName[columnIndex];
    }    
     
     @Override  
    public Class<?> getColumnClass(int columnIndex) {  
    	 //retorna a classe da coluna atrav�s do seu �ndice
        return String.class;  
    }
     
     @Override  
     public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
    	// ir� configurar um valor em determinada c�lula. 
    	
     	fireTableCellUpdated(rowIndex, columnIndex);   // Notifica os listeners que o valor de uma c�lula foi alterada.
      }   
     
    /*
     *  FireTableDataChanged(): Notifica os listeners que todas as c�lulas foram alteradas.
	 *	FireTableStructureChanged(): Notifica os listeners que a estrutura da tabela mudou, ou seja, o n�mero de colunas, o tipos das colunas e o nome delas.
	 *	FireTableRowsInserted(): Notifica os listeners que a quantidade de linhas aumentou, ou seja, dados foram adicionados.
	 *	FireTableRowsUpdates(): Notifica os listeners que as linhas foram atualizadas.
	 *	FireTableRowsDeleted(): Notifica os listeners que as linhas foram deletadas.
	 *	FireTableCellUpdated(): Notifica os listeners que o valor de uma c�lula foi alterada.
	 *
     */
      
     @Override  
     public boolean isCellEditable(int rowIndex, int columnIndex) {  
    	// checa se a c�lula atual, dados os argumentos de posi��o de linha e coluna, � edit�vel
         return false;  
     }
     

  // --------------------------- FIM DOS M�TODOS OBRIGAT�RIOS DO ABSTRACT TABLE MODEL ------------------------------------ \\
	
	public void AddAluno(Aluno aluno) {
		arrayAluno.add(aluno);
		fireTableDataChanged();
	}
	
	public void setValueAt(Aluno aValue, int rowIndex) {  //aValue � do tipo da Classe em que guarda o array seus dados
		Aluno aluno = arrayAluno.get(rowIndex);
		aluno.setMatricula(aValue.getMatricula());
		aluno.setCpf(aValue.getCpf());
		aluno.setNome(aValue.getNome());
		aluno.setTelefone(aValue.getTelefone());
		aluno.setCelular(aValue.getCelular());
		aluno.setDataNascimento(aValue.getDataNascimento());
		fireTableCellUpdated(rowIndex, 0);  
		fireTableCellUpdated(rowIndex, 1);  
		fireTableCellUpdated(rowIndex, 2);  
		fireTableCellUpdated(rowIndex, 3);  
		fireTableCellUpdated(rowIndex, 4);   
		fireTableCellUpdated(rowIndex, 5);  

	}
     
  


}
