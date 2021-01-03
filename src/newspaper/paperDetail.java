package newspaper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Administrator.managerDetail;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;


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
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
//	contentPane.add(managerInfoPanel);
		paperManagedetail.setContentPane(contentPane);
		
		//Á½¸ö°´Å¥
		changePaperButton = new JButton("±¨¿¯ÐÞ¸Ä");
		changePaperButton.setBounds(100, 334, 170, 74);
		changePaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new ChangePaper();
			}
		});
		
				JLabel label1 = new JLabel("ÇëÑ¡ÔñÒÔÏÂÁ½¸ö¹¦ÄÜ");
				label1.setBounds(198, 248, 254, 60);
				label1.setBackground(Color.CYAN);
				label1.setHorizontalAlignment(SwingConstants.CENTER);
				label1.setFont(new Font("Ó×Ô²", Font.PLAIN, 25));
		changePaperButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		//
				deletePaperButton = new JButton("±¨¿¯É¾³ý");
				deletePaperButton.setBounds(375, 335, 170, 73);
				deletePaperButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						paperManagedetail.dispose();
						new deletePaper();

					}
				});
				deletePaperButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.setBounds(539, 472, 113, 42);
		btnReturn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new managerDetail();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(label1);
		contentPane.add(changePaperButton);
		contentPane.add(deletePaperButton);
		contentPane.add(btnReturn);
		
		ImageIcon image = new ImageIcon("E:\\OneDrive\\Í¼Æ¬\\2.PNG");
		
		JLabel Limage = new JLabel(image);
		Limage.setBounds(-18, -28, 684, 230);
		contentPane.add(Limage);
		Limage.setHorizontalAlignment(SwingConstants.LEADING);
		Limage.setForeground(Color.WHITE);
		Limage.setBackground(java.awt.Color.CYAN);
		
		
		
	/*	
		addPaperButton = new JButton("±¨¿¯Ìí¼Ó");
		addPaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new AddPaper();

			}
		});
		addPaperButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		addPaperButton.setBounds(20, 331, 120, 50);
		contentPane.add(addPaperButton);
	*/
		
	}
}