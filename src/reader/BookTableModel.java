package reader;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import utils.DBUtils;

public class BookTableModel extends AbstractTableModel {

	private static String[] columnName = { "报刊名", "报刊号", "作者", "出版社", "出版时间", "总量", "剩余量" };
	private static Vector<Vector<String>> data;

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}

	public BookTableModel(Vector<Vector<String>> data) {
		BookTableModel.data = data;
	}

	public BookTableModel() {
		data = DBUtils.getAllBookInfos();
	}
}
