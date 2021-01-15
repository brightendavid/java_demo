package reader;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import utils.DBUtils;
public class ReaderborrowModer extends AbstractTableModel {
	
//��������һ�ű�
	
	private static String[] columnName = { "���", "������", "���ʱ��", "Ӧ��ʱ��"};
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