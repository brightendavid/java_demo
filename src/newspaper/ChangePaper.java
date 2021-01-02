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
			changePaperframe = new JFrame("�����޸�");
			changePaperframe.setBounds(100, 100, 538, 401);
			changePaperframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���
			
			contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setLayout(null);
			changePaperframe.setContentPane(contentPanel);//���
			
			JLabel label1=new JLabel("����Ҫ�޸ĵı����ţ�");
			label1.setHorizontalAlignment(SwingConstants.LEFT);
			label1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			label1.setBounds(20, 20, 226, 50);
			contentPanel.add(label1);
			
			JLabel label2=new JLabel("\u8F93\u5165\u4FEE\u6539\u503C\uFF1A");
			label2.setHorizontalAlignment(SwingConstants.LEFT);
			label2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			label2.setBounds(20,79,147,50);
			contentPanel.add(label2);
			
			//�޸��ĸ����ԣ�name��writer��press��time
			
			//����Ҫ�޸ı����ı�����
			JTextField paperNo=new JTextField();
			paperNo.setColumns(20);
			paperNo.setBounds(206,26, 147, 44);
			contentPanel.add(paperNo);
			
			//�����޸ĵ�����ֵ
			JTextField paperChange=new JTextField();
			paperChange.setColumns(20);
			paperChange.setBounds(206,83, 147, 44);
			contentPanel.add(paperChange);
			
			//1.�޸�name
			JButton changeNameButton=new JButton("�������޸�");
			
			changeNameButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "�����뱨���Ż򱨿��ŵ�һ����", "��ʾ", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePaperName(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "�������޸ĳɹ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "�������޸�ʧ�ܣ�", "��ʾ",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changeNameButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			changeNameButton.setBounds(20, 163, 147, 50);
			contentPanel.add(changeNameButton);


			//�޸�writer
			JButton changeWriterButton=new JButton("���������޸�");
			
			changeWriterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "�����뱨���Ż򱨿��ŵ�һ����", "��ʾ", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePaperWriter(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "���������޸ĳɹ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "���������޸�ʧ�ܣ�", "��ʾ",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changeWriterButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			changeWriterButton.setBounds(20, 244, 150, 50);
			contentPanel.add(changeWriterButton);
			

			//�޸�press
			JButton changePressButton=new JButton("�����������޸�");
			
			changePressButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "�����뱨���Ż򱨿��ŵ�һ����", "��ʾ", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePaperPress(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "�����������޸ĳɹ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "�����������޸�ʧ�ܣ�", "��ʾ",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changePressButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			changePressButton.setBounds(181, 163, 161, 50);
			contentPanel.add(changePressButton);
			

			//�޸�time
			JButton changeTimeButton=new JButton("��������ʱ���޸�");
			
			changeTimeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "�����뱨���Ż򱨿��ŵ�һ����", "��ʾ", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePapertime(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "��������ʱ���޸ĳɹ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "��������ʱ���޸�ʧ�ܣ�", "��ʾ",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changeTimeButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			changeTimeButton.setBounds(184, 244, 169, 49);
			contentPanel.add(changeTimeButton);
		
			JButton changePriceButton=new JButton("�����۸��޸�");
			
			changePriceButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String pno = paperNo.getText();
					String pContent = paperChange.getText();
					if (pno.equals("")) {
						JOptionPane.showMessageDialog(null, "�����뱨���Ż򱨿��ŵ�һ����", "��ʾ", JOptionPane.WARNING_MESSAGE);
						return;
					}
					boolean f = DBUtils.changePaperprice(pno, pContent);
					if (f) 
						JOptionPane.showMessageDialog(null, "�����۸��޸ĳɹ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "�����۸��޸�ʧ�ܣ�", "��ʾ",JOptionPane.PLAIN_MESSAGE);
				}
			});
			changePriceButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			changePriceButton.setBounds(370, 163, 150, 50);
			contentPanel.add(changePriceButton);
			
			//���ذ�ť
			JButton returnButton =new JButton("����");
			returnButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					changePaperframe.dispose();
					new paperDetail();
				}
			});
			returnButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			returnButton.setBounds(399, 242, 107, 50);
			contentPanel.add(returnButton);
			
			changePaperframe.setVisible(true);
		}

}
