package Administrator;

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
import reader.ReaderEntrance;
import reader.ReaderborrowModer;
import utils.DBUtils;

public class Newspaper_Fafang extends JPanel{
	
	private JTextField bookNameTextField;
	private JTable table;
	private JTextField numtextfield;

	/**
	 * Create the panel.
	 */
	public Newspaper_Fafang() {
		setLayout(null);

		bookNameTextField = new JTextField();
		bookNameTextField.setBounds(120, 34, 99, 21);
		add(bookNameTextField);
		bookNameTextField.setColumns(10);
		
		JButton button = new JButton("����˶���");
		button.setEnabled(false);
		
		JLabel bookNameLabel = new JLabel("������������");
		bookNameLabel.setBounds(10, 36, 106, 18);
		add(bookNameLabel);

		JButton queryButton = new JButton("��ѯ");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName = bookNameTextField.getText();
				if (bookName.equals("")) {
					JOptionPane.showMessageDialog(null, "����������������һ����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				Vector<Vector<String>> data = DBUtils.getBookInfo(bookName);
				table.setModel(new BookTableModel(data));    //��ӡ���
			}
		});
		queryButton.setBounds(252, 34, 119, 21);
		add(queryButton);

		JButton refreshButton = new JButton("ˢ��");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookNameTextField.setText("");
				button.setEnabled(false);

				Vector<Vector<String>> data = DBUtils.getAllBookInfos();
				table.setModel(new BookTableModel(data));
			}
		});
		refreshButton.setBounds(385, 34, 99, 21);
		add(refreshButton);
		
//����Ա�Ķ��Ĺ��ܲ���Ҫ
		/*JButton borrowButton = new JButton("����");
		borrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowNum = table.getSelectedRow();
				int readerNumber = ReaderEntrance.readerNumber;
				if (rowNum < 0 || rowNum > table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "δѡ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				} else {
					int n = JOptionPane.showConfirmDialog(null, "ȷ�Ͻ�����?", "��ʾ", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						String isbn = (String) table.getValueAt(rowNum, 1);
						String remain = (String) table.getValueAt(rowNum, 6);
						if (remain.equals("0")) {
							JOptionPane.showMessageDialog(null, "��ǰ�鼮��ȫ�����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
						} else {
							if (DBUtils.verifyBorrow(readerNumber, isbn)) {
								JOptionPane.showMessageDialog(null, "����ʧ�ܣ��ѽ��ĸ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
								return;
							}

							if (!DBUtils.borrowOneBook(readerNumber, isbn)) {
								JOptionPane.showMessageDialog(null, "����ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
								return;
							}
							JOptionPane.showMessageDialog(null, "���ĳɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);

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
		add(borrowButton);*/

		table = new JTable();
		table.setModel(new ReaderborrowModer());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 105, 505, 152);
		add(scrollPane);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��д��ɣ�������ݿ��ͬ�����ĺ�����
				int rowNum = table.getSelectedRow();
				//int readerNumber = ReaderEntrance.readerNumber;
				//int readerNumber=(int) table.getValueAt(rowNum, 1);
				if (rowNum < 0 || rowNum > table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "δѡ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					int n = JOptionPane.showConfirmDialog(null, "ȷ�Ͻ��������?", "��ʾ", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						String isbn = (String) table.getValueAt(rowNum, 1);//����Ǵ�0��ʼ������
						String readerNum=(String) table.getValueAt(rowNum, 0);
						int num=Integer.valueOf(readerNum);
							

							if (!DBUtils.jiechu_borrowOneBook(num, isbn)) {
								JOptionPane.showMessageDialog(null, "�������ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
								return;
							}
							else{
								JOptionPane.showMessageDialog(null, "������ĳɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
								return;
							}
						

						

					} 
					else if (n == JOptionPane.NO_OPTION) {
						return;
					}
				}
				Vector<Vector<String>> data = DBUtils.getAllreaderInfos();
				table.setModel(new ReaderborrowModer(data));
			}
		});
		button.setBounds(385, 270, 111, 27);
		add(button);
		
		JLabel label = new JLabel("����������ţ�");
		label.setBounds(10, 74, 106, 18);
		add(label);
		
		numtextfield = new JTextField();
		numtextfield.setBounds(120, 68, 86, 24);
		add(numtextfield);
		numtextfield.setColumns(10);
		
		JButton button_1 = new JButton("��ѯ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num= numtextfield.getText();
				if (num.equals("")) {
					JOptionPane.showMessageDialog(null, "������reader���˺�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				Vector<Vector<String>> data = DBUtils.getreadernumInfo(num);
				table.setModel(new ReaderborrowModer(data));    //��ӡ���
			}
		});
		button_1.setBounds(243, 70, 128, 22);
		add(button_1);
		
		JButton button_2 = new JButton("ˢ��");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setEnabled(true); 
				bookNameTextField.setText("");
				
				Vector<Vector<String>> data = DBUtils.getAllreaderInfos();
				table.setModel(new ReaderborrowModer(data));
				
			}
		});
		button_2.setBounds(385, 71, 99, 21);
		add(button_2);

	}

	public void refresh() {
		//table.setModel(new BookTableModel());
		table.setModel(new ReaderborrowModer());
	}
}