package Administrator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import reader.NewspaperBorrowPanel;
import userDataManage.ReaderInfoPanel;

import java.awt.Color;
import java.awt.SystemColor;

public class managerDetail {
	
	private JFrame frmManagerdetail;
	private JPanel contentPane;
	private managerInfoPanel managerInfoPanel;
	private NewspaperBorrowPanel bookBorrowPanel;
	private Newspaper_Fafang newspaperfafang;
	private ReaderInfoPanel readerPanel;
	//private BookReturnPanel bookReturnPanel;
	private JButton bookBorrowButton;
	private JButton returnButton;
	private JButton reloginButton;
	
	public managerDetail() {
	frmManagerdetail = new JFrame();
	frmManagerdetail.setTitle("managerDetail");
	frmManagerdetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmManagerdetail.setVisible(true);
	frmManagerdetail.setBounds(100, 100, 684, 574);

	managerInfoPanel = new managerInfoPanel();
	managerInfoPanel.setBackground(SystemColor.info);
	managerInfoPanel.setSize(587, 313);
	managerInfoPanel.setLocation(10, 10);

	bookBorrowPanel = new NewspaperBorrowPanel();
	bookBorrowPanel.setSize(540, 300);
	bookBorrowPanel.setLocation(10, 10);
	
	newspaperfafang = new Newspaper_Fafang();
	newspaperfafang.setSize(540, 300);
	newspaperfafang.setLocation(10, 10);
	
	readerPanel=new ReaderInfoPanel();
	readerPanel.setSize(540, 300);
	readerPanel.setLocation(10, 10);
	
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

	/*bookBorrowButton = new JButton("报刊订阅");
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
	bookBorrowButton.setBounds(20, 331, 120, 50);
	contentPane.add(bookBorrowButton);*/

	returnButton = new JButton("返回个人信息");
	returnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			//移除一些可能的模块
			contentPane.remove(bookBorrowPanel);
			contentPane.remove(newspaperruku);
			contentPane.remove(newspaperfafang);
			contentPane.remove(readerPanel);
			contentPane.add(managerInfoPanel);
			contentPane.repaint();
		}
	});
	returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
	returnButton.setBounds(298, 335, 141, 47);
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
	reloginButton.setBounds(463, 331, 120, 50);
	contentPane.add(reloginButton);
	
	JButton button = new JButton("报刊入库管理");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new Newspaperrukudata();//Ruku类，加入界面
				
		}
	});
	button.setBounds(150, 336, 134, 47);
	contentPane.add(button);
	
	JButton button_1 = new JButton("报刊数据管理");
	button_1.setBounds(37, 394, 224, 77);
	contentPane.add(button_1);
	
	JButton button_2 = new JButton("客户数据管理");
	button_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.remove(managerInfoPanel);
			bookBorrowPanel.refresh();
			contentPane.add(readerPanel);
			contentPane.repaint();
		}
	});
	button_2.setBounds(298, 394, 275, 27);
	contentPane.add(button_2);
	
	JButton button_3 = new JButton("报刊发放管理");//需要改为发放有关的字段
	button_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.remove(managerInfoPanel);
			bookBorrowPanel.refresh();
			contentPane.add(newspaperfafang);
			contentPane.repaint();
		}
	});
	button_3.setBounds(318, 434, 255, 37);
	contentPane.add(button_3);
	contentPane.repaint();
}
}
