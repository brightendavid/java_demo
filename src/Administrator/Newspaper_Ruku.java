package Administrator;

 //������������ӦmanagerDetail  �ı���������buttom  ����û��ʲô����
	

import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import reader.BookTableModel;
import reader.NewspaperBorrowedTableModel;
import reader.ReaderEntrance;
import utils.DBUtils;
public class Newspaper_Ruku extends JPanel {
	private JTextField bookNameTextField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Newspaper_Ruku() {
		setLayout(null);

		bookNameTextField = new JTextField();
		bookNameTextField.setBounds(98, 34, 99, 21);
		add(bookNameTextField);
		bookNameTextField.setColumns(10);

		JLabel bookNameLabel = new JLabel("�����뱨������");
		bookNameLabel.setBounds(10, 37, 78, 15);
		add(bookNameLabel);

		JButton queryButton = new JButton("��ѯ");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName = bookNameTextField.getText();
				if (bookName.equals("")) {
					JOptionPane.showMessageDialog(null, "����������������һ����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				Vector<Vector<String>> data = DBUtils.getBorrowedBookInfos(ReaderEntrance.readerNumber, bookName);
				table.setModel(new BookTableModel(data));
			}
		});
		queryButton.setBounds(218, 33, 93, 23);
		add(queryButton);

		JButton refreshButton = new JButton("ˢ��");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookNameTextField.setText("");

				Vector<Vector<String>> data = DBUtils.getAllBorrowedBookInfos(ReaderEntrance.readerNumber);
				table.setModel(new NewspaperBorrowedTableModel(data));
			}
		});
		refreshButton.setBounds(333, 33, 93, 23);
		add(refreshButton);

		JButton borrowButton = new JButton("�������");
		borrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowNum = table.getSelectedRow();
				int readerNumber = ReaderEntrance.readerNumber;
				if (rowNum < 0 || rowNum > table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "δѡ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				} else {
					int n = JOptionPane.showConfirmDialog(null, "ȷ�Ϲ黹��?", "��ʾ", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						String isbn = (String) table.getValueAt(rowNum, 1);

						if (!DBUtils.returnOneBook(readerNumber, isbn)) {
							JOptionPane.showMessageDialog(null, "�黹ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						JOptionPane.showMessageDialog(null, "�黹�ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);

					} else if (n == JOptionPane.NO_OPTION) {
						return;
					}
				}
				Vector<Vector<String>> data = DBUtils.getAllBorrowedBookInfos(ReaderEntrance.readerNumber);
				table.setModel(new NewspaperBorrowedTableModel(data));
			}
		});
		borrowButton.setBounds(438, 33, 93, 23);
		add(borrowButton);

		table = new JTable();
		table.setModel(new NewspaperBorrowedTableModel(ReaderEntrance.readerNumber));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 79, 521, 211);
		add(scrollPane);

	}

	public void refresh() {
		table.setModel(new NewspaperBorrowedTableModel(ReaderEntrance.readerNumber));
	}
}