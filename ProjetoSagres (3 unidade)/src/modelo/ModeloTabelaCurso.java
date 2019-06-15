package modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controle.Main;

public class ModeloTabelaCurso extends AbstractTableModel{
	String [] columnName = {"ID","NOME","CH TOTAL","TIPO", "SEMESTRES"};		//nome das coluna 
	ArrayList<Curso> arrayAluno = null;
	
	
	public ModeloTabelaCurso() {
		arrayAluno = Main.curso;
	}
	
	public String[] getColumnName() {
		return columnName;
	}

	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
