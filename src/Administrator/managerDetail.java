package Administrator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import reader.NewspaperBorrowPanel;
import reader.ReaderEntrance;
import reader.ReaderInfoPanel;
import java.awt.Color;
import java.awt.SystemColor;

public class managerDetail {
	
	private JFrame frmManagerdetail;
	private JPanel contentPane;
	private ReaderInfoPanel managerInfoPanel;
	private NewspaperBorrowPanel bookBorrowPanel;
	//private BookReturnPanel bookReturnPanel;
	private JButton bookBorrowButton;
	private JButton returnButton;
	private JButton bookReturnButton;
	private JButton reloginButton;
	
	public managerDetail() {
	frmManagerdetail = new JFrame();
	frmManagerdetail.setTitle("managerDetail");
	frmManagerdetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmManagerdetail.setVisible(true);
	frmManagerdetail.setBounds(100, 100, 636, 566);

	managerInfoPanel = new ReaderInfoPanel();
	managerInfoPanel.setBackground(SystemColor.info);
	managerInfoPanel.setSize(540, 300);
	managerInfoPanel.setLocation(10, 10);

	bookBorrowPanel = new NewspaperBorrowPanel();
	bookBorrowPanel.setSize(540, 300);
	bookBorrowPanel.setLocation(10, 10);
	
	Newspaper_Ruku newspaperruku= new Newspaper_Ruku();
	newspaperruku.setSize(540, 300);
	newspaperruku.setLocation(10, 10);

/*	bookReturnPanel = new BookReturnPanel();
	bookReturnPanel.setSize(540, 300);
	bookReturnPanel.setLocation(10, 10);*/

	contentPane = new JPanel();
	contentPane.setBackground(Color.DARK_GRAY);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(null);

	contentPane.add(managerInfoPanel);
	frmManagerdetail.setContentPane(contentPane);

	bookBorrowButton = new JButton("报刊订阅");
	bookBorrowButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.remove(managerInfoPanel);
		//	contentPane.remove(bookReturnPanel);
			bookBorrowPanel.refresh();
			contentPane.add(bookBorrowPanel);
			contentPane.repaint();

		}
	});
	bookBorrowButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
	bookBorrowButton.setBounds(16, 320, 120, 50);
	contentPane.add(bookBorrowButton);

	returnButton = new JButton("返回个人信息");
	returnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.remove(bookBorrowPanel);
		//	contentPane.remove(bookReturnPanel);
			contentPane.add(managerInfoPanel);
			contentPane.repaint();
		}
	});
	returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
	returnButton.setBounds(298, 323, 141, 47);
	contentPane.add(returnButton);
//此处是邮局管理系统不需要使用的功能
	/*bookReturnButton = new JButton("图书归还");
	bookReturnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.remove(bookBorrowPanel);
			contentPane.remove(readerInfoPanel);
			bookReturnPanel.refresh();
			contentPane.add(bookReturnPanel);
			contentPane.repaint();
		}
	});
	bookReturnButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
	bookReturnButton.setBounds(152, 320, 120, 50);
	contentPane.add(bookReturnButton);*/

	reloginButton = new JButton("返回登录");
	reloginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frmManagerdetail.dispose();
			new managerEntrance();
		}
	});
	reloginButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
	reloginButton.setBounds(453, 320, 120, 50);
	contentPane.add(reloginButton);
	
	JButton button = new JButton("报刊入库管理");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.remove(managerInfoPanel);
			//	contentPane.remove(bookReturnPanel);
				bookBorrowPanel.refresh();
				contentPane.add(newspaperruku);
				contentPane.repaint();
		}
	});
	button.setBounds(150, 323, 134, 47);
	contentPane.add(button);
	
	JButton button_1 = new JButton("报刊数据管理");
	button_1.setBounds(37, 394, 224, 77);
	contentPane.add(button_1);
	
	JButton button_2 = new JButton("客户数据管理");
	button_2.setBounds(298, 394, 275, 27);
	contentPane.add(button_2);
	
	JButton button_3 = new JButton("报刊发放管理");
	button_3.setBounds(318, 434, 255, 37);
	contentPane.add(button_3);
	contentPane.repaint();
}
}
