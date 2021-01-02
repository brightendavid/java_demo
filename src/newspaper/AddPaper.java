package newspaper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AddPaper {

	private JFrame paperAdd;
	private JPanel contentPanel;
	//private JLabel 	;
	private JButton returnButton;
	
	public AddPaper() {
		paperAdd = new JFrame();
		paperAdd.setTitle("AddPaper");
		paperAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paperAdd.setVisible(true);
		paperAdd.setBounds(100, 100, 684, 574);

		contentPanel = new JPanel();
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
//		contentPane.add(managerInfoPanel);
		paperAdd.setContentPane(contentPanel);

		JLabel label1=new JLabel("报刊名：");
		label1.setBounds(82, 29, 54, 15);
		contentPanel.add(label1);
		
		JTextField textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(190, 26, 155, 21);
		contentPanel.add(textField1);
		
		JLabel label2=new JLabel("报刊作者:");
		label2.setBounds(82, 69, 54, 15);
		contentPanel.add(label2);
		
		JTextField textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(190, 66, 155, 21);
		contentPanel.add(textField2);
		
		JLabel label3=new JLabel("报刊出版社:");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label1.setBounds(82, 109, 54, 15);
		contentPanel.add(label3);
		
		JTextField textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(190, 106, 155, 21);
		contentPanel.add(textField3);
		
		JLabel label4=new JLabel("报刊出版时间:");
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label2.setBounds(82, 149, 54, 15);
		contentPanel.add(label4);
		
		JTextField textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(190, 146, 155, 21);
		contentPanel.add(textField4);
		
		JLabel label5=new JLabel("报刊总量:");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label1.setBounds(82, 189, 54, 15);
		contentPanel.add(label5);
		
		JTextField textField5 = new JTextField();
		textField5.setColumns(10);
		textField5.setBounds(190, 186, 155, 21);
		contentPanel.add(textField5);
		
		JLabel label6=new JLabel("报刊剩余量:");
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label2.setBounds(82, 229, 54, 15);
		contentPanel.add(label6);
		
		JTextField textField6 = new JTextField();
		textField6.setColumns(10);
		textField6.setBounds(190, 226, 155, 21);
		contentPanel.add(textField6);
		
		JLabel label7=new JLabel("报刊价格:");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label1.setBounds(82, 269, 54, 15);
		contentPanel.add(label7);
		
		JTextField textField7 = new JTextField();
		textField7.setColumns(10);
		textField7.setBounds(190, 266, 155, 21);
		contentPanel.add(textField7);
		
		JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
		});
	}
}
