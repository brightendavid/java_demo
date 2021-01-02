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

import Administrator.managerDetail;


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

		JLabel label1 = new JLabel("ÇëÑ¡ÔñÒÔÏÂÁ½¸ö¹¦ÄÜ");
		label1.setBackground(Color.CYAN);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		label1.setBounds(159, 172, 290, 50);
		contentPane.add(label1);
		
		//Á½¸ö°´Å¥
		changePaperButton = new JButton("±¨¿¯ÐÞ¸Ä");
		changePaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new ChangePaper();
			}
		});
		changePaperButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		changePaperButton.setBounds(199, 375, 209, 50);
		contentPane.add(changePaperButton);
//
		deletePaperButton = new JButton("±¨¿¯É¾³ý");
		deletePaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new deletePaper();

			}
		});
		deletePaperButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		deletePaperButton.setBounds(199, 288, 209, 50);
		contentPane.add(deletePaperButton);
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paperManagedetail.dispose();
				new managerDetail();
			}
		});
		btnReturn.setBounds(467, 443, 138, 50);
		contentPane.add(btnReturn);
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