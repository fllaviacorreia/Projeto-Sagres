package modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.Main;

@SuppressWarnings("serial")
public class ModeloTabela extends AbstractTableModel{
	int columnCount = 0;		//quantidade de colunas 
	int rowCount = 0;			//quantidade de linhas 
	String [] columnName;		//nome das coluna 
	String tipoTabela;
	ArrayList<Aluno> arrayAluno = null;
	ArrayList<Professor> array2 = null;
	public ModeloTabela(int columnCount, int rowCount, String tipoTabela, String[] columnName) {
		System.out.println(columnCount);
		System.out.println(rowCount);
		System.out.println(tipoTabela);
		System.out.println(columnName[2]);
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		this.tipoTabela = tipoTabela;
		this.columnName = columnName;
	//	if(tipoTabela.equals("ALUNO"))
			arrayAluno = Main.aluno;
	//	else if(tipoTabela.equals("PROFESSOR"))
	//		array2 = new ArrayList<Professor>();
		
	//	Main.tabelas.add(this);
	}

	public String[] getColumnName() {
		return columnName;
	}

	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public String getTipoTabela() {
		return tipoTabela;
	}

	public void setTipoTabela(String tipoTabela) {
		this.tipoTabela = tipoTabela;
	}
// --------------------------- INÍCIO DOS MÉTODOS OBRIGATÓRIOS DO ABSTRACT TABLE MODEL ------------------------------------ \\
	@Override
	public int getColumnCount() {
		//retorna a quantidade de colunas na tabela
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		//retorna a quantidade de linhas da tabela
		return rowCount;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// retorna o valor em determinada célula, dado os argumentos de posição de linha e coluna
		
		return null;
	}
	@Override
    public String getColumnName(int columnIndex){
		// retorna o nome da coluna em determinado índice
      return columnName[columnIndex];
    }    
     
     @Override  
    public Class<?> getColumnClass(int columnIndex) {  
    	 //retorna a classe da coluna através do seu índice
        return String.class;  
    }
     
     @Override  
     public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
    	// irá configurar um valor em determinada célula. 
    	 /** EXEMPLO
    	  * Usuario usuario = usuarios.get(rowIndex);
         
        	usuario.setLogin(aValue.getLogin());
        	usuario.setNome(aValue.getNome());
        	usuario.setSenha(aValue.getSenha());        
   
        	fireTableCellUpdated(rowIndex, 0);  
        	fireTableCellUpdated(rowIndex, 1);  
        	fireTableCellUpdated(rowIndex, 2);  */
    	 
     	fireTableCellUpdated(rowIndex, columnIndex);   // Notifica os listeners que o valor de uma célula foi alterada.
      }   
     
    /*
     *  FireTableDataChanged(): Notifica os listeners que todas as células foram alteradas.
	 *	FireTableStructureChanged(): Notifica os listeners que a estrutura da tabela mudou, ou seja, o número de colunas, o tipos das colunas e o nome delas.
	 *	FireTableRowsInserted(): Notifica os listeners que a quantidade de linhas aumentou, ou seja, dados foram adicionados.
	 *	FireTableRowsUpdates(): Notifica os listeners que as linhas foram atualizadas.
	 *	FireTableRowsDeleted(): Notifica os listeners que as linhas foram deletadas.
	 *	FireTableCellUpdated(): Notifica os listeners que o valor de uma célula foi alterada.
	 *
     */
      
     @Override  
     public boolean isCellEditable(int rowIndex, int columnIndex) {  
    	// checa se a célula atual, dados os argumentos de posição de linha e coluna, é editável
         return false;  
     }
     

  // --------------------------- FIM DOS MÉTODOS OBRIGATÓRIOS DO ABSTRACT TABLE MODEL ------------------------------------ \\
     
	public Object getValueAt(int linha, int coluna, String tipo) {
		// retorna o valor em determinada célula, dado os argumentos de posição de linha, coluna e tipo (professor, aluno, classe, disciplina, curso)
	//	if(tipo.equals("ALUNO")) {
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
	//	}

//		if(tipo.equals("PROFESSOR")) {
//			switch (coluna) {
//			case 0://coluna matricula
//				return Main.professor.get(linha).getMatricula();
//			case 1://coluna cpf
//				return Main.professor.get(linha).getCpf();		
//			case 2://coluna nome
//				return Main.professor.get(linha).getNome();
//			case 3://coluna telefone
//				if(!( Main.professor.get(linha).getTelefone().equals(null) ) && ( Main.professor.get(linha).getCelular().equals(null) ) )
//					return Main.professor.get(linha).getTelefone();
//				else if( (Main.professor.get(linha).getTelefone().equals(null)) &&  ! (Main.professor.get(linha).getCelular().equals(null)) )
//					return Main.professor.get(linha).getCelular();
//				else
//					return Main.professor.get(linha).getTelefone() + "/" + Main.professor.get(linha).getCelular();
//			case 4: // coluna data de nascimento
//				return Main.professor.get(linha).getDataNascimento();
//			default:
//				return Main.professor.get(linha);
//			}
//
//		}
//		
		
	//	return null;

	}
	
	public void AddAluno(Aluno aluno) {
		arrayAluno.add(aluno);
		fireTableDataChanged();
	}
	
    public void setValueAt(String aValue, int rowIndex) {  //aValue é do tipo da Classe em que guarda o array seus dados
//        Usuario usuario = usuarios.get(rowIndex);
//         
//        usuario.setLogin(aValue.getLogin());
//        usuario.setNome(aValue.getNome());
//        usuario.setSenha(aValue.getSenha());        
//   
//        fireTableCellUpdated(rowIndex, 0);  
//        fireTableCellUpdated(rowIndex, 1);  
//        fireTableCellUpdated(rowIndex, 2);  
   
    }
     
  


}
