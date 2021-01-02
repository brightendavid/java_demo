package newspaper;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import utils.DBUtils;

public class deletePaper{

	private JFrame deletePaperframe;
	private JPanel contentPanel;
	
	public deletePaper() {
		deletePaperframe = new JFrame("删除");
		deletePaperframe.setBounds(100, 100, 450, 300);
		deletePaperframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//框架
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		deletePaperframe.setContentPane(contentPanel);
		
		JLabel label2=new JLabel("输入要删除的报刊号");
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label2.setBounds(27,13,200,50);
		contentPanel.add(label2);
		
		//输入要删除报刊的报刊号
		JTextField paperNo=new JTextField();
		paperNo.setColumns(20);
		paperNo.setBounds(14,77, 200, 50);
		contentPanel.add(paperNo);
		
		//删除执行命令按钮
		JButton deleteButton=new JButton("删除");
		
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String pno = paperNo.getText();
				if (pno.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入报刊号或报刊号的一部分", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				boolean f = DBUtils.deletePaper(pno);
				if (f) 
					JOptionPane.showMessageDialog(null, "删除成功！", "提示",JOptionPane.PLAIN_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "删除失败！", "提示",JOptionPane.PLAIN_MESSAGE);
			}
		});
		deleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		deleteButton.setBounds(250, 74, 100, 50);
		contentPanel.add(deleteButton);
		
		//返回按钮
		JButton returnButton =new JButton("返回");
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				deletePaperframe.dispose();
				new paperDetail();
			}
		});
		returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		returnButton.setBounds(250, 161, 100, 50);
		contentPanel.add(returnButton);
		
		deletePaperframe.setVisible(true);
	}
	
}
