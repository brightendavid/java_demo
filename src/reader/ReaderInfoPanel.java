package reader;

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
	public ReaderInfoPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));

		int number = ReaderEntrance.readerNumber;

		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);

		setLayout(null);

		JLabel titleLabel = new JLabel("��ӭ������߽��Ĺ���ϵͳ");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		titleLabel.setBounds(111, 23, 319, 40);
		add(titleLabel);

		JLabel nameLabel = new JLabel("������");
		nameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		nameLabel.setBounds(50, 85, 60, 40);
		add(nameLabel);

		JLabel nunberLabel = new JLabel("ѧ�ţ�");
		nunberLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		nunberLabel.setBounds(50, 160, 60, 40);
		add(nunberLabel);

		JLabel sexLabel = new JLabel("�Ա�");
		sexLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		sexLabel.setBounds(191, 85, 60, 40);
		add(sexLabel);

		JLabel ageLabel = new JLabel("���䣺");
		ageLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		ageLabel.setBounds(190, 160, 60, 40);
		add(ageLabel);

		JLabel telLabel = new JLabel("�绰��");
		telLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		telLabel.setBounds(319, 85, 60, 40);
		add(telLabel);

		JLabel emailLabel = new JLabel("���䣺");
		emailLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		emailLabel.setBounds(319, 160, 60, 40);
		add(emailLabel);

		JLabel nameInfoLabel = new JLabel(String.valueOf(readerInfo.get("name")));
		nameInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		nameInfoLabel.setBounds(104, 85, 77, 40);
		add(nameInfoLabel);

		JLabel sexInfoLabel = new JLabel(String.valueOf(readerInfo.get("sex")));
		sexInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		sexInfoLabel.setBounds(245, 85, 60, 40);
		add(sexInfoLabel);

		telInfoLabel = new JLabel(String.valueOf(readerInfo.get("telephone")));
		telInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		telInfoLabel.setBounds(377, 85, 129, 40);
		add(telInfoLabel);

		JLabel numberInfoLabel = new JLabel(String.valueOf(readerInfo.get("number")));
		numberInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		numberInfoLabel.setBounds(105, 160, 75, 40);
		add(numberInfoLabel);

		ageInfoLabel = new JLabel(String.valueOf(readerInfo.get("age")));
		ageInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		ageInfoLabel.setBounds(245, 160, 60, 40);
		add(ageInfoLabel);

		emailInfoLabel = new JLabel(String.valueOf(readerInfo.get("email")));
		emailInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		emailInfoLabel.setBounds(377, 160, 129, 40);
		add(emailInfoLabel);

		JButton infoModifyButton = new JButton("�޸ĸ�����Ϣ");
		infoModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderInfoModifier();
			}
		});
		infoModifyButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		infoModifyButton.setBounds(88, 233, 162, 50);
		add(infoModifyButton);

		JButton passwordModifyButton = new JButton("�޸�����");
		passwordModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderPasswordModifier();
			}
		});
		passwordModifyButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		passwordModifyButton.setBounds(338, 233, 114, 50);
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
