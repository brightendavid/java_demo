package reader;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import utils.DBUtils;

public class BookTableModel extends AbstractTableModel {

	private static String[] columnName = { "������", "������", "����", "������", "����ʱ��", "����", "ʣ����" };
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
