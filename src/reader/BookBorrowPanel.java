package reader;

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

import utils.DBUtils;

public class BookBorrowPanel extends JPanel {
	private JTextField bookNameTextField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BookBorrowPanel() {
		setLayout(null);

		bookNameTextField = new JTextField();
		bookNameTextField.setBounds(98, 34, 99, 21);
		add(bookNameTextField);
		bookNameTextField.setColumns(10);

		JLabel bookNameLabel = new JLabel("请输入书名：");
		bookNameLabel.setBounds(10, 37, 78, 15);
		add(bookNameLabel);

		JButton queryButton = new JButton("查询");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName = bookNameTextField.getText();
				if (bookName.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入书名或书名一部分", "提示", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				Vector<Vector<String>> data = DBUtils.getBookInfo(bookName);
				table.setModel(new BookTableModel(data));
			}
		});
		queryButton.setBounds(218, 33, 93, 23);
		add(queryButton);

		JButton refreshButton = new JButton("刷新");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookNameTextField.setText("");

				Vector<Vector<String>> data = DBUtils.getAllBookInfos();
				table.setModel(new BookTableModel(data));
			}
		});
		refreshButton.setBounds(333, 33, 93, 23);
		add(refreshButton);

		JButton borrowButton = new JButton("借阅");
		borrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowNum = table.getSelectedRow();
				int readerNumber = ReaderEntrance.readerNumber;
				if (rowNum < 0 || rowNum > table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "未选中", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					int n = JOptionPane.showConfirmDialog(null, "确认借阅吗?", "提示", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						String isbn = (String) table.getValueAt(rowNum, 1);
						String remain = (String) table.getValueAt(rowNum, 6);
						if (remain.equals("0")) {
							JOptionPane.showMessageDialog(null, "当前书籍已全部借出", "提示", JOptionPane.PLAIN_MESSAGE);
						} else {
							if (DBUtils.verifyBorrow(readerNumber, isbn)) {
								JOptionPane.showMessageDialog(null, "借阅失败，已借阅该书", "提示", JOptionPane.PLAIN_MESSAGE);
								return;
							}

							if (!DBUtils.borrowOneBook(readerNumber, isbn)) {
								JOptionPane.showMessageDialog(null, "借阅失败", "提示", JOptionPane.PLAIN_MESSAGE);
								return;
							}
							JOptionPane.showMessageDialog(null, "借阅成功", "提示", JOptionPane.PLAIN_MESSAGE);

						}

					} else if (n == JOptionPane.NO_OPTION) {
						return;
					}
				}
				Vector<Vector<String>> data = DBUtils.getAllBookInfos();
				table.setModel(new BookTableModel(data));
			}
		});
		borrowButton.setBounds(438, 33, 93, 23);
		add(borrowButton);

		table = new JTable();
		table.setModel(new BookTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 79, 521, 211);
		add(scrollPane);

	}

	public void refresh() {
		table.setModel(new BookTableModel());
	}
}
