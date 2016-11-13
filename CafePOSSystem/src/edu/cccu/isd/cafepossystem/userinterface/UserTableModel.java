package edu.cccu.isd.cafepossystem.userinterface;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel{
	
    // build Jtable data model // 
	ArrayList<ArrayList> Table =  new ArrayList<ArrayList>();
	ArrayList<String> TableInfo = new ArrayList<String>();	
	
	ArrayList<String> columnSet =  new ArrayList<String>();
	ArrayList<List> userData = new ArrayList<List>();
	{
	columnSet.add("Item");
	columnSet.add("Price ");
	columnSet.add("Amount");
	}
	
	public void addRow(List rowData){
		userData.add(rowData);
		fireTableRowsInserted(userData.size() -1 , userData.size() -1);
	}
	public int getRowCount() {
		return userData.size();
	}

	public int getColumnCount() {
		return columnSet.size();
	}

	public Object getValueAt(int row, int col) {
		return userData.get(row).get(col);
	}
	
	public String getColumnName(int col){
		try{
			return columnSet.get(col);
		}catch(Exception e){
			return null;
		}
	}
	public void setValueAt(int col,List rowData){
		userData.set(col, rowData);
		fireTableCellUpdated(userData.size(),userData.size());
	}
	
}
