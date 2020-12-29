package Administrator;
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

import reader.ReaderPasswordModifier;
import utils.DBUtils;

public class managerInfoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public managerInfoPanel() {//´Ë´¦È«²¿ÊÇÍ¼ÐÎ»¯½çÃæµÄ´î½¨ºÍÏìÓ¦Æ÷
		setBorder(new LineBorder(new Color(0, 0, 0)));

		int number = managerEntrance.manageNumber;

		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);

		setLayout(null);

		JLabel titleLabel = new JLabel("\u90AE\u5C40\u62A5\u520A\u8BA2\u9605admin\u754C\u9762");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		titleLabel.setBounds(111, 23, 319, 40);
		add(titleLabel);

		JLabel nameLabel = new JLabel("ÐÕÃû£º");
		nameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameLabel.setBounds(103, 137, 60, 40);
		add(nameLabel);

		JLabel nunberLabel = new JLabel("Ñ§ºÅ£º");
		nunberLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nunberLabel.setBounds(341, 137, 60, 40);
		add(nunberLabel);

		JLabel nameInfoLabel = new JLabel("admin");
		nameInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameInfoLabel.setBounds(160, 137, 77, 40);
		add(nameInfoLabel);

		JLabel numberInfoLabel = new JLabel("999");
		numberInfoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		numberInfoLabel.setBounds(435, 137, 75, 40);
		add(numberInfoLabel);
//²»ÐèÒª
		/*JButton infoModifyButton = new JButton("ÐÞ¸Ä¸öÈËÐÅÏ¢");
		infoModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new managerInfoModifier();
			}
		});
		infoModifyButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		infoModifyButton.setBounds(50, 233, 162, 50);
		add(infoModifyButton);*/

		/*JButton passwordModifyButton = new JButton("ÐÞ¸ÄÃÜÂë");
		passwordModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderPasswordModifier();
			}
		});
		passwordModifyButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		passwordModifyButton.setBounds(308, 233, 114, 50);
		add(passwordModifyButton);*/

	}

	/*public static void updatePanel() {
		int number = managerEntrance.manageNumber;
		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);
		telInfoLabel.setText(String.valueOf(readerInfo.get("telephone")));
		ageInfoLabel.setText(String.valueOf(readerInfo.get("age")));
		emailInfoLabel.setText(String.valueOf(readerInfo.get("email")));
	}*/
}

