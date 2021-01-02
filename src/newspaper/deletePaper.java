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
		deletePaperframe = new JFrame("ɾ��");
		deletePaperframe.setBounds(100, 100, 450, 300);
		deletePaperframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		deletePaperframe.setContentPane(contentPanel);
		
		JLabel label2=new JLabel("����Ҫɾ���ı�����");
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label2.setBounds(27,13,200,50);
		contentPanel.add(label2);
		
		//����Ҫɾ�������ı�����
		JTextField paperNo=new JTextField();
		paperNo.setColumns(20);
		paperNo.setBounds(14,77, 200, 50);
		contentPanel.add(paperNo);
		
		//ɾ��ִ�����ť
		JButton deleteButton=new JButton("ɾ��");
		
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String pno = paperNo.getText();
				if (pno.equals("")) {
					JOptionPane.showMessageDialog(null, "�����뱨���Ż򱨿��ŵ�һ����", "��ʾ", JOptionPane.WARNING_MESSAGE);
					return;
				}
				boolean f = DBUtils.deletePaper(pno);
				if (f) 
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�", "��ʾ",JOptionPane.PLAIN_MESSAGE);
			}
		});
		deleteButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		deleteButton.setBounds(250, 74, 100, 50);
		contentPanel.add(deleteButton);
		
		//���ذ�ť
		JButton returnButton =new JButton("����");
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				deletePaperframe.dispose();
				new paperDetail();
			}
		});
		returnButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		returnButton.setBounds(250, 161, 100, 50);
		contentPanel.add(returnButton);
		
		deletePaperframe.setVisible(true);
	}
	
}
