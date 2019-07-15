package modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.Main;

@SuppressWarnings("serial")
public class ModeloTabelaCurso extends AbstractTableModel {
	String[] columnName = {"ID", "NOME", "CH TOTAL", "TIPO", "GRAU", "SEMESTRES" }; // nome das coluna
	ArrayList<Curso> arrayCurso;

	public ModeloTabelaCurso() {
		arrayCurso = Main.curso;
	}

	public String[] getColumnName() {
		return columnName;
	}

	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}

	// --------------------------- IN�CIO DOS M�TODOS OBRIGAT�RIOS DO ABSTRACT TABLE
	// MODEL ------------------------------------ \\
	@Override
	public int getColumnCount() {
		// retorna a quantidade de colunas na tabela
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		// retorna a quantidade de linhas da tabela
		return Main.curso.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// retorna o valor em determinada c�lula, dado os argumentos de posi��o de linha
		// e coluna
		switch (coluna) {
		case 0:// coluna id
			return arrayCurso.get(linha).getId();
		case 1: //coluna nome
			return arrayCurso.get(linha).getNome();
		case 2:// coluna carga horaria
			return arrayCurso.get(linha).getCargaHorariaTotal();
		case 3:// coluna tipo
			return arrayCurso.get(linha).getTipo();
		case 4: {// coluna grau
			String tipoCurso = arrayCurso.get(linha).getTipoCurso();
			if (tipoCurso.equals("GRADUA��O")) {
				String tipoGraduacao = arrayCurso.get(linha).getTipoGraduacao();
				return (tipoCurso + " (" + tipoGraduacao + ")");
			} else
				return tipoCurso;
		}
		case 5: // coluna semestres
			return arrayCurso.get(linha).getSemestres();
		default:
			return arrayCurso.get(linha);
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		// retorna o nome da coluna em determinado �ndice
		return columnName[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// retorna a classe da coluna atrav�s do seu �ndice
		return String.class;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// ir� configurar um valor em determinada c�lula.

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica os listeners que o valor de uma c�lula foi alterada.
	}

	/*
	 * FireTableDataChanged(): Notifica os listeners que todas as c�lulas foram
	 * alteradas. FireTableStructureChanged(): Notifica os listeners que a estrutura
	 * da tabela mudou, ou seja, o n�mero de colunas, o tipos das colunas e o nome
	 * delas. FireTableRowsInserted(): Notifica os listeners que a quantidade de
	 * linhas aumentou, ou seja, dados foram adicionados. FireTableRowsUpdates():
	 * Notifica os listeners que as linhas foram atualizadas.
	 * FireTableRowsDeleted(): Notifica os listeners que as linhas foram deletadas.
	 * FireTableCellUpdated(): Notifica os listeners que o valor de uma c�lula foi
	 * alterada.
	 *
	 */

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// checa se a c�lula atual, dados os argumentos de posi��o de linha e coluna, �
		// edit�vel
		return false;
	}

	// --------------------------- FIM DOS M�TODOS OBRIGAT�RIOS DO ABSTRACT TABLE
	// MODEL ------------------------------------ \\

	public void AddCurso(Curso curso) {
		arrayCurso.add(curso);
		fireTableDataChanged();
	}

	public void setValueAt(Curso aValue, int rowIndex) { // aValue � do tipo da Classe em que guarda o array seus dados
		Curso curso = arrayCurso.get(rowIndex);
		curso.setId(aValue.getId());
		curso.setNome(aValue.getNome());
		curso.setCargaHorariaTotal(aValue.getCargaHorariaTotal());
		curso.setTipo(aValue.getTipo());
		curso.setTipoCurso(aValue.getTipoCurso());
		curso.setSemestres(aValue.getSemestres());
		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
		fireTableCellUpdated(rowIndex, 3);
		fireTableCellUpdated(rowIndex, 4);
		fireTableCellUpdated(rowIndex, 5);

	}

}
