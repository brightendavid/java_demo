package newspaper;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class paperDetail {
	
	private JFrame paperManagedetail;
	private JPanel contentPane;
	
	private JButton changePaperButton;
	private JButton searchPaperButton;
	private JButton deletePaperButton;	
	
	public paperDetail() {
		paperManagedetail = new JFrame();
		paperManagedetail.setTitle("paperDetail");
		paperManagedetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paperManagedetail.setVisible(true);
		paperManagedetail.setBounds(100, 100, 684, 574);

		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	
//	contentPane.add(managerInfoPanel);
		paperManagedetail.setContentPane(contentPane);

		JLabel label1 = new JLabel("请选择以下两个功能");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label1.setBounds(20, 30, 20, 50);
		contentPane.add(label1);
		
		//两个按钮
		changePaperButton = new JButton("报刊修改");
		changePaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new ChangePaper();
			}
		});
		changePaperButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		changePaperButton.setBounds(20, 31, 120, 50);
		contentPane.add(changePaperButton);
//
		deletePaperButton = new JButton("报刊删除");
		deletePaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new deletePaper();

			}
		});
		deletePaperButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		deletePaperButton.setBounds(20, 331, 120, 50);
		contentPane.add(deletePaperButton);
	/*	
		addPaperButton = new JButton("报刊添加");
		addPaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new AddPaper();

			}
		});
		addPaperButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		addPaperButton.setBounds(20, 331, 120, 50);
		contentPane.add(addPaperButton);
	*/
		
	}
}