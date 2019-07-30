package modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.Main;

public class ModeloTabelaDisciplina extends AbstractTableModel {
	String[] columnName = {"ID", "CURSO", "C.H.", "NOME", "ÁREA" }; // nome das coluna
	ArrayList<Disciplina> arrayDisciplina;

	public ModeloTabelaDisciplina() {
		arrayDisciplina = Main.disciplina;//arrayClasse = Main.classe
	}

	public String[] getColumnName() {
		return columnName;
	}

	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}

	// --------------------------- INÍCIO DOS MÉTODOS OBRIGATÓRIOS DO ABSTRACT TABLE
	// MODEL ------------------------------------ \\
	@Override
	public int getColumnCount() {
		// retorna a quantidade de colunas na tabela
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		// retorna a quantidade de linhas da tabela
		return Main.disciplina.size();//main.classe.size()
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// retorna o valor em determinada célula, dado os argumentos de posição de linha
		// e coluna
		switch (coluna) {
		case 0:// coluna id
			return arrayDisciplina.get(linha).getId();
		case 1: //coluna curso
			return arrayDisciplina.get(linha).getCurso();
		case 2:// coluna carga horaria
			return arrayDisciplina.get(linha).getCarga_Horaria();
		case 3:// coluna nome da disciplina
			return arrayDisciplina.get(linha).getNome_Disciplina();
		case 4://coluna área da disciplina 
			return arrayDisciplina.get(linha).getArea_Disciplina();
		default:
			return arrayDisciplina.get(linha);
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		// retorna o nome da coluna em determinado índice
		return columnName[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// retorna a classe da coluna através do seu índice
		return String.class;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// irá configurar um valor em determinada célula.

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica os listeners que o valor de uma célula foi alterada.
	}

	/*
	 * FireTableDataChanged(): Notifica os listeners que todas as células foram
	 * alteradas. FireTableStructureChanged(): Notifica os listeners que a estrutura
	 * da tabela mudou, ou seja, o número de colunas, o tipos das colunas e o nome
	 * delas. FireTableRowsInserted(): Notifica os listeners que a quantidade de
	 * linhas aumentou, ou seja, dados foram adicionados. FireTableRowsUpdates():
	 * Notifica os listeners que as linhas foram atualizadas.
	 * FireTableRowsDeleted(): Notifica os listeners que as linhas foram deletadas.
	 * FireTableCellUpdated(): Notifica os listeners que o valor de uma célula foi
	 * alterada.
	 *
	 */

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// checa se a célula atual, dados os argumentos de posição de linha e coluna, é
		// editável
		return false;
	}

	// --------------------------- FIM DOS MÉTODOS OBRIGATÓRIOS DO ABSTRACT TABLE
	// MODEL ------------------------------------ \\

	public void AddDisiciplina(Disciplina disciplina) {//add classe
		arrayDisciplina.add(disciplina);
		fireTableDataChanged();
	}

	public void setValueAt(Disciplina aValue, int rowIndex) { // aValue é do tipo da Classe em que guarda o array seus dados
		Disciplina disciplina = arrayDisciplina.get(rowIndex);
		disciplina.setId(aValue.getId());
		disciplina.setCurso(aValue.getCurso());
		disciplina.setCarga_Horaria(aValue.getCarga_Horaria());
		disciplina.setNome_Disciplina(aValue.getNome_Disciplina());
		disciplina.setArea_Disciplina(aValue.getArea_Disciplina());
		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
		fireTableCellUpdated(rowIndex, 3);
		fireTableCellUpdated(rowIndex, 4);
		fireTableCellUpdated(rowIndex, 5);

	}

}
