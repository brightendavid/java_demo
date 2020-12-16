package reader;//reader½çÃæ

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

import utils.DBUtils;

public class ReaderInfoPanel extends JPanel {

	private static JLabel ageInfoLabel;
	private static JLabel emailInfoLabel;
	private static JLabel telInfoLabel;

	/**
	 * Create the panel.
	 */
	public ReaderInfoPanel() {//´Ë´¦È«²¿ÊÇÍ¼ÐÎ»¯½çÃæµÄ´î½¨ºÍÏìÓ¦Æ÷
		setBorder(new LineBorder(new Color(0, 0, 0)));

		int number = ReaderEntrance.readerNumber;

		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);

		setLayout(null);

		JLabel titleLabel = new JLabel("ÓÊ¾Ö±¨¿¯¶©ÔÄ");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		titleLabel.setBounds(111, 23, 319, 40);
		add(titleLabel);

		JLabel nameLabel = new JLabel("ÐÕÃû£º");
		nameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameLabel.setBounds(50, 85, 60, 40);
		add(nameLabel);

		JLabel nunberLabel = new JLabel("Ñ§ºÅ£º");
		nunberLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nunberLabel.setBounds(50, 160, 60, 40);
		add(nunberLabel);

		JLabel sexLabel = new JLabel("ÐÔ±ð£º");
		sexLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		sexLabel.setBounds(191, 85, 60, 40);
		add(sexLabel);

		JLabel ageLabel = new JLabel("ÄêÁä£º");
		ageLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		ageLabel.setBounds(190, 160, 60, 40);
		add(ageLabel);

		JLabel telLabel = new JLabel("µç»°£º");
		telLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		telLabel.setBounds(319, 85, 60, 40);
		add(telLabel);

		JLabel emailLabel = new JLabel("ÓÊÏä£º");
		emailLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		emailLabel.setBounds(319, 160, 60, 40);
		add(emailLabel);

		JLabel nameInfoLabel = new JLabel(String.valueOf(readerInfo.get("name")));
		nameInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameInfoLabel.setBounds(104, 85, 77, 40);
		add(nameInfoLabel);

		JLabel sexInfoLabel = new JLabel(String.valueOf(readerInfo.get("sex")));
		sexInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		sexInfoLabel.setBounds(245, 85, 60, 40);
		add(sexInfoLabel);

		telInfoLabel = new JLabel(String.valueOf(readerInfo.get("telephone")));
		telInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		telInfoLabel.setBounds(377, 85, 129, 40);
		add(telInfoLabel);

		JLabel numberInfoLabel = new JLabel(String.valueOf(readerInfo.get("number")));
		numberInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		numberInfoLabel.setBounds(105, 160, 75, 40);
		add(numberInfoLabel);

		ageInfoLabel = new JLabel(String.valueOf(readerInfo.get("age")));
		ageInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		ageInfoLabel.setBounds(245, 160, 60, 40);
		add(ageInfoLabel);

		emailInfoLabel = new JLabel(String.valueOf(readerInfo.get("email")));
		emailInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		emailInfoLabel.setBounds(377, 160, 129, 40);
		add(emailInfoLabel);

		JButton infoModifyButton = new JButton("ÐÞ¸Ä¸öÈËÐÅÏ¢");
		infoModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderInfoModifier();
			}
		});
		infoModifyButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		infoModifyButton.setBounds(50, 233, 162, 50);
		add(infoModifyButton);

		JButton passwordModifyButton = new JButton("ÐÞ¸ÄÃÜÂë");
		passwordModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderPasswordModifier();
			}
		});
		passwordModifyButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		passwordModifyButton.setBounds(308, 233, 114, 50);
		add(passwordModifyButton);

	}

	public static void updatePanel() {
		int number = ReaderEntrance.readerNumber;
		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);
		telInfoLabel.setText(String.valueOf(readerInfo.get("telephone")));
		ageInfoLabel.setText(String.valueOf(readerInfo.get("age")));
		emailInfoLabel.setText(String.valueOf(readerInfo.get("email")));
	}
}
