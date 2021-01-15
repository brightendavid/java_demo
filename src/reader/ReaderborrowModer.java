package reader;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import utils.DBUtils;
public class ReaderborrowModer extends AbstractTableModel {
	
//这是另外一张表
	
	private static String[] columnName = { "编号", "报刊号", "借出时间", "应还时间"};
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

	public ReaderborrowModer(Vector<Vector<String>> data) {
		ReaderborrowModer.data = data;
	}

	public ReaderborrowModer() {
		data = DBUtils.getAllreaderInfos();
	}
}