package modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.Main;

@SuppressWarnings("serial")
public class ModeloTabelaProfessor  extends AbstractTableModel{
	String [] columnName = {"ID","Nº MATRICULA","CPF","NOME","CONTATO","DATA NASCIMENTO", }; //nome das coluna 
	ArrayList<Professor> arrayProfessor = null;
	public ModeloTabelaProfessor() {
		arrayProfessor = Main.professor;
	}
	public int getColumnCount() {
		//retorna a quantidade de colunas na tabela
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		//retorna a quantidade de linhas da tabela
		return Main.professor.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// retorna o valor em determinada célula, dado os argumentos de posição de linha e coluna
		switch (coluna) {
		case 0://coluna id
			return arrayProfessor.get(linha).getId();
		case 1: //coluna matricula
			return arrayProfessor.get(linha).getMatricula();
		case 2://coluna cpf
			return arrayProfessor.get(linha).getCpf();		
		case 3://coluna nome
			return arrayProfessor.get(linha).getNome();
		case 4:{//coluna contato
			String telefone = arrayProfessor.get(linha).getTelefone();
			String celular = arrayProfessor.get(linha).getCelular();
			if(telefone != null &&  celular != null)
				return telefone + "/" + celular;
			if(telefone != null && celular == null)
				return telefone;
			if(telefone == null && celular != null)
				return celular;
			
			return telefone + "/" + celular;
		}
			
			
		case 5: // coluna data de nascimento
			return arrayProfessor.get(linha).getDataNascimento();
		
		default:
			return arrayProfessor.get(linha);
		} 
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
	
	public void AddProfessor(Professor professor) {
		arrayProfessor.add(professor);
		fireTableDataChanged();
	}
	
	public void setValueAt(Professor aValue, int rowIndex) {  //aValue é do tipo da Classe em que guarda o array seus dados
		Professor professor = arrayProfessor.get(rowIndex);
		professor.setId(aValue.getId());
		professor.setMatricula(aValue.getMatricula());
		professor.setCpf(aValue.getCpf());
		professor.setNome(aValue.getNome());
		professor.setTelefone(aValue.getTelefone());
		professor.setCelular(aValue.getCelular());
		professor.setDataNascimento(aValue.getDataNascimento());
		fireTableCellUpdated(rowIndex, 0);  
		fireTableCellUpdated(rowIndex, 1);  
		fireTableCellUpdated(rowIndex, 2);  
		fireTableCellUpdated(rowIndex, 3);  
		fireTableCellUpdated(rowIndex, 4);   
		fireTableCellUpdated(rowIndex, 5);    
		fireTableCellUpdated(rowIndex, 6);   

	}


}
