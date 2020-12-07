package reader;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import utils.DBUtils;

public class BookBorrowedTableModel extends AbstractTableModel {

	private static String[] columnName = { "书名", "书号", "作者", "出版社", "出版时间", "借阅时间" };
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

	public BookBorrowedTableModel(Vector<Vector<String>> data) {
		BookBorrowedTableModel.data = data;
	}

	public BookBorrowedTableModel(int number) {
		data = DBUtils.getAllBorrowedBookInfos(number);
	}
}
