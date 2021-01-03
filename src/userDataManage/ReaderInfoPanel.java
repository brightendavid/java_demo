package userDataManage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import reader.ReaderEntrance;
import utils.DBUtils;
import javax.swing.JTextField;

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

		JLabel titleLabel = new JLabel("\u7BA1\u7406\u5458\u7AEF\u53E3\u4FEE\u6539\u7528\u6237\u4FE1\u606F");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 25));
		titleLabel.setBounds(111, 23, 319, 40);
		add(titleLabel);

		JLabel nameLabel = new JLabel("–’√˚£∫");
		nameLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		nameLabel.setBounds(37, 76, 60, 40);
		add(nameLabel);

		/*JLabel nunberLabel = new JLabel("±‡∫≈£∫");
		nunberLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		nunberLabel.setBounds(50, 160, 60, 40);
		add(nunberLabel);*/

		JLabel sexLabel = new JLabel("–‘±£∫");
		sexLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		sexLabel.setBounds(172, 76, 60, 40);
		add(sexLabel);

		JLabel ageLabel = new JLabel("ƒÍ¡‰£∫");
		ageLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		ageLabel.setBounds(182, 129, 60, 40);
		add(ageLabel);

		JLabel telLabel = new JLabel("µÁª∞£∫");
		telLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		telLabel.setBounds(319, 76, 60, 40);
		add(telLabel);

		JLabel emailLabel = new JLabel("” œ‰£∫");
		emailLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		emailLabel.setBounds(319, 129, 60, 40);
		add(emailLabel);

		JLabel nameInfoLabel = new JLabel(String.valueOf(readerInfo.get("name")));
		nameInfoLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		nameInfoLabel.setBounds(111, 76, 77, 40);
		add(nameInfoLabel);

		JLabel sexInfoLabel = new JLabel(String.valueOf(readerInfo.get("sex")));
		sexInfoLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		sexInfoLabel.setBounds(245, 76, 60, 40);
		add(sexInfoLabel);

		telInfoLabel = new JLabel(String.valueOf(readerInfo.get("telephone")));
		telInfoLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		telInfoLabel.setBounds(387, 76, 129, 40);
		add(telInfoLabel);
		
		

		JLabel numberInfoLabel = new JLabel(String.valueOf(readerInfo.get("number")));
		numberInfoLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		numberInfoLabel.setBounds(86, 129, 75, 40);
		add(numberInfoLabel);

		ageInfoLabel = new JLabel(String.valueOf(readerInfo.get("age")));
		ageInfoLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		ageInfoLabel.setBounds(245, 129, 60, 40);
		add(ageInfoLabel);

		emailInfoLabel = new JLabel(String.valueOf(readerInfo.get("email")));
		emailInfoLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		emailInfoLabel.setBounds(387, 131, 129, 40);
		add(emailInfoLabel);

		JButton infoModifyButton = new JButton("–ﬁ∏ƒ∏ˆ»À–≈œ¢");
		infoModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderInfoModifier();
			}
		});
		infoModifyButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		infoModifyButton.setBounds(37, 241, 162, 50);
		add(infoModifyButton);

		JButton passwordModifyButton = new JButton("–ﬁ∏ƒ√‹¬Î");
		passwordModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderPasswordModifier();
				
			}
		});
		passwordModifyButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		passwordModifyButton.setBounds(224, 241, 168, 50);
		add(passwordModifyButton);
		
		
		
		
		//jLabel4.setText("∂‘≤ª∆£¨µ«¬º ß∞‹");
		
		
		JButton button = new JButton("\u67E5\u8BE2");//≤È—Ø
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
		
		JButton button_1 = new JButton("÷ÿ÷√√‹¬Î");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DBUtils.chongzhi_Password(number)){
					JOptionPane.showMessageDialog(null, "÷ÿ÷√√‹¬Î≥…π¶", "Ã· æ", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "÷ÿ÷√√‹¬Î ß∞‹£¨«Î÷ÿ ‘", "Ã· æ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		});
		button_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		button_1.setBounds(406, 241, 130, 50);
		add(button_1);
		
		
		
		


	}

	public static void updatePanel() {
		int number = ReaderEntrance.readerNumber;
		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);
		telInfoLabel.setText(String.valueOf(readerInfo.get("telephone")));
		ageInfoLabel.setText(String.valueOf(readerInfo.get("age")));
		emailInfoLabel.setText(String.valueOf(readerInfo.get("email")));
	}
}
