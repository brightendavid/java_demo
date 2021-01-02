package userDataManage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import reader.ReaderEntrance;
import utils.DBUtils;
import javax.swing.JTextField;
import javax.swing.JTable;

public class ReaderInfoPanel extends JPanel {

	private static JLabel ageInfoLabel;
	private static JLabel emailInfoLabel;
	private static JLabel telInfoLabel;
	private JTextField textField;
	static int number =100001;

	/**
	 * Create the panel.
	 */
	public ReaderInfoPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		textField = new JTextField();
		textField.setText("100001");
		textField.setBounds(102, 191, 86, 24);
		add(textField);
		textField.setColumns(10);
		
		number =100001;
		String num = textField.getText();
		number =Integer.valueOf(num);
		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);

		setLayout(null);

		JLabel titleLabel = new JLabel("»¶Ó­½øÈë±¨¿¯¶©ÔÄ¹ÜÀíÏµÍ³");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		titleLabel.setBounds(111, 23, 319, 40);
		add(titleLabel);

		JLabel nameLabel = new JLabel("ÐÕÃû£º");
		nameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameLabel.setBounds(37, 76, 60, 40);
		add(nameLabel);

		/*JLabel nunberLabel = new JLabel("±àºÅ£º");
		nunberLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nunberLabel.setBounds(50, 160, 60, 40);
		add(nunberLabel);*/

		JLabel sexLabel = new JLabel("ÐÔ±ð£º");
		sexLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		sexLabel.setBounds(172, 76, 60, 40);
		add(sexLabel);

		JLabel ageLabel = new JLabel("ÄêÁä£º");
		ageLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		ageLabel.setBounds(182, 129, 60, 40);
		add(ageLabel);

		JLabel telLabel = new JLabel("µç»°£º");
		telLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		telLabel.setBounds(319, 76, 60, 40);
		add(telLabel);

		JLabel emailLabel = new JLabel("ÓÊÏä£º");
		emailLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		emailLabel.setBounds(319, 129, 60, 40);
		add(emailLabel);

		JLabel nameInfoLabel = new JLabel(String.valueOf(readerInfo.get("name")));
		nameInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameInfoLabel.setBounds(111, 76, 77, 40);
		add(nameInfoLabel);

		JLabel sexInfoLabel = new JLabel(String.valueOf(readerInfo.get("sex")));
		sexInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		sexInfoLabel.setBounds(245, 76, 60, 40);
		add(sexInfoLabel);

		telInfoLabel = new JLabel(String.valueOf(readerInfo.get("telephone")));
		telInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		telInfoLabel.setBounds(387, 76, 129, 40);
		add(telInfoLabel);
		
		

		JLabel numberInfoLabel = new JLabel(String.valueOf(readerInfo.get("number")));
		numberInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		numberInfoLabel.setBounds(86, 129, 75, 40);
		add(numberInfoLabel);

		ageInfoLabel = new JLabel(String.valueOf(readerInfo.get("age")));
		ageInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		ageInfoLabel.setBounds(245, 129, 60, 40);
		add(ageInfoLabel);

		emailInfoLabel = new JLabel(String.valueOf(readerInfo.get("email")));
		emailInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		emailInfoLabel.setBounds(387, 131, 129, 40);
		add(emailInfoLabel);

		JButton infoModifyButton = new JButton("ÐÞ¸Ä¸öÈËÐÅÏ¢");
		infoModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderInfoModifier();
			}
		});
		infoModifyButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		infoModifyButton.setBounds(52, 241, 162, 50);
		add(infoModifyButton);

		JButton passwordModifyButton = new JButton("ÐÞ¸ÄÃÜÂë");
		passwordModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderPasswordModifier();
			}
		});
		passwordModifyButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		passwordModifyButton.setBounds(327, 241, 168, 50);
		add(passwordModifyButton);
		
		
		
		
		//jLabel4.setText("¶Ô²»Æð£¬µÇÂ¼Ê§°Ü");
		
		
		JButton button = new JButton("\u67E5\u8BE2");//²éÑ¯
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText();
				number =Integer.valueOf(num);
				Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);
				nameInfoLabel.setText(String.valueOf(readerInfo.get("name")));
				sexInfoLabel.setText(String.valueOf(readerInfo.get("sex")));
				telInfoLabel.setText(String.valueOf(readerInfo.get("telephone")));
				ageInfoLabel.setText(String.valueOf(readerInfo.get("age")));
				emailInfoLabel.setText(String.valueOf(readerInfo.get("email")));
				numberInfoLabel.setText(String.valueOf(readerInfo.get("number")));
			}
		});
		button.setBounds(317, 190, 113, 27);
		add(button);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setBounds(38, 140, 72, 18);
		add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		label_1.setBounds(38, 194, 72, 18);
		add(label_1);
		
		
		
		


	}

	public static void updatePanel() {
		int number = ReaderEntrance.readerNumber;
		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);
		telInfoLabel.setText(String.valueOf(readerInfo.get("telephone")));
		ageInfoLabel.setText(String.valueOf(readerInfo.get("age")));
		emailInfoLabel.setText(String.valueOf(readerInfo.get("email")));
	}
}
