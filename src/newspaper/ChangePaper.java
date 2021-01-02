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

	public class ChangePaper {

		private JFrame changePaperframe;
		private JPanel contentPanel;
		
		public ChangePaper() {
			changePaperframe = new JFrame("修改");
			changePaperframe.setBounds(100, 100, 450, 300);
			changePaperframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//框架
			
			contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setLayout(null);
			changePaperframe.setContentPane(contentPanel);//面板
			
			JLabel label1=new JLabel("报刊修改");
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
			label1.setBounds(53, 20, 329, 50);
			contentPanel.add(label1);
			
			JLabel label2=new JLabel("输入要修改的报刊号");
			label2.setHorizontalAlignment(SwingConstants.LEFT);
			label2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			label2.setBounds(20,50,200,50);
			contentPanel.add(label2);
			
			//修改四个属性，name、writer、press、time
			
			//输入要修改报刊的报刊号
			JTextField paperNo=new JTextField();
			paperNo.setColumns(20);
			paperNo.setBounds(20,100, 200, 50);
			contentPanel.add(paperNo);
			
			//输入修改得属性值
			JTextField paperChange=new JTextField();
			paperChange.setColumns(20);
			paperChange.setBounds(20,100, 200, 50);
			contentPanel.add(paperChange);
			
			//1.修改name
			JButton changeNameButton=new JButton("报刊名修改");
			
			changeNameButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入报刊号或报刊号的一部分", "提示", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePaperName(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "报刊名修改成功！", "提示",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "报刊名修改失败！", "提示",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changeNameButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			changeNameButton.setBounds(250, 100, 100, 50);
			contentPanel.add(changeNameButton);


			//修改writer
			JButton changeWriterButton=new JButton("报刊作者修改");
			
			changeWriterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入报刊号或报刊号的一部分", "提示", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePaperWriter(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "报刊作者修改成功！", "提示",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "报刊作者修改失败！", "提示",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changeWriterButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			changeWriterButton.setBounds(250, 100, 100, 50);
			contentPanel.add(changeWriterButton);
			

			//修改press
			JButton changePressButton=new JButton("报刊出版社修改");
			
			changePressButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入报刊号或报刊号的一部分", "提示", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePaperPress(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "报刊出版社修改成功！", "提示",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "报刊出版社修改失败！", "提示",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changePressButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			changePressButton.setBounds(250, 100, 100, 50);
			contentPanel.add(changePressButton);
			

			//修改time
			JButton changeTimeButton=new JButton("报刊出版时间修改");
			
			changeTimeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入报刊号或报刊号的一部分", "提示", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePapertime(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "报刊出版时间修改成功！", "提示",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "报刊出版时间修改失败！", "提示",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changeTimeButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			changeTimeButton.setBounds(250, 100, 100, 50);
			contentPanel.add(changeTimeButton);
			
			
			//返回按钮
			JButton returnButton =new JButton("返回");
			returnButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					changePaperframe.dispose();
					new paperDetail();
				}
			});
			returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			returnButton.setBounds(250, 200, 100, 50);
			contentPanel.add(returnButton);
			
			changePaperframe.setVisible(true);
		}

}
