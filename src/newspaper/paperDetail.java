package newspaper;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class paperDetail {
	
	private JFrame paperManagedetail;
	private JPanel contentPane;
	
	private JButton changePaperButton;
	private JButton searchPaperButton;
	private JButton deletePaperButton;	
	private JButton returnButton;
	private JButton reloginButton;
	
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

		//Èý¸ö°´Å¥
		changePaperButton = new JButton("±¨¿¯ÐÞ¸Ä");
		changePaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.repaint();

			}
		});
		changePaperButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		changePaperButton.setBounds(20, 331, 120, 50);
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
		deletePaperButton.setBounds(20, 331, 120, 50);
		contentPane.add(deletePaperButton);
	}
}