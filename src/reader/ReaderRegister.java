package reader;//ע��reader

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.DBUtils;

public class ReaderRegister {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField numberTextField;
	private JTextField sexTextField;
	private JTextField ageTextField;
	private JTextField telTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JPasswordField verifyPasswordField;

	/**
	 * Create the frame.
	 */
	public ReaderRegister() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 585, 429);
		frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		JLabel nameLabel = new JLabel("������");
		nameLabel.setBounds(82, 29, 54, 15);
		contentPane.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(190, 26, 155, 21);
		contentPane.add(nameTextField);

		JLabel numberLabel = new JLabel("�˺ţ�");
		numberLabel.setBounds(82, 69, 54, 15);
		contentPane.add(numberLabel);

		numberTextField = new JTextField();
		numberTextField.setColumns(10);
		numberTextField.setBounds(190, 66, 155, 21);
		contentPane.add(numberTextField);

		JLabel sexLabel = new JLabel("�Ա�");
		sexLabel.setBounds(82, 105, 54, 15);
		contentPane.add(sexLabel);

		sexTextField = new JTextField();
		sexTextField.setColumns(10);
		sexTextField.setBounds(190, 102, 155, 21);
		contentPane.add(sexTextField);

		JLabel ageLabel = new JLabel("���䣺");
		ageLabel.setBounds(82, 145, 54, 15);
		contentPane.add(ageLabel);

		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		ageTextField.setBounds(190, 142, 155, 21);
		contentPane.add(ageTextField);

		JLabel telephoneLabel = new JLabel("�绰��");
		telephoneLabel.setBounds(82, 185, 54, 15);
		contentPane.add(telephoneLabel);

		telTextField = new JTextField();
		telTextField.setColumns(10);
		telTextField.setBounds(190, 182, 155, 21);
		contentPane.add(telTextField);

		JLabel emailLabel = new JLabel("���䣺");
		emailLabel.setBounds(82, 225, 54, 15);
		contentPane.add(emailLabel);//��JLable  emailLable  �������

		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(190, 222, 155, 21);
		contentPane.add(emailTextField);

		JLabel passwordLabel = new JLabel("���룺");
		passwordLabel.setBounds(82, 263, 54, 15);
		contentPane.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(190, 260, 155, 21);
		contentPane.add(passwordField);

		JLabel verifyPasswordLabel = new JLabel("����ȷ�ϣ�");
		verifyPasswordLabel.setBounds(82, 303, 80, 15);
		contentPane.add(verifyPasswordLabel);

		verifyPasswordField = new JPasswordField();
		verifyPasswordField.setColumns(10);
		verifyPasswordField.setBounds(190, 300, 155, 21);
		contentPane.add(verifyPasswordField);

		JButton registerButton = new JButton("ע��");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String number = numberTextField.getText();
				String sex = sexTextField.getText();
				String age = ageTextField.getText();
				String telephone = telTextField.getText();
				String email = emailTextField.getText();
				String password = passwordField.getText();
				String verifyPassword = verifyPasswordField.getText();
//����Ϲ��Լ���
				if (name.equals("") || number.equals("")) {
					JOptionPane.showMessageDialog(null, "�������˺ű�����������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (password.equals("") || verifyPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "���롢����ȷ�Ͼ�����Ϊ�գ����������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (name.length() > 4 || number.length() != 6) {
					JOptionPane.showMessageDialog(null, "�������˺Ų����Ϲ�������������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int numberInt = 0;
				try {
					numberInt = Integer.valueOf(number);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "�������˺Ų����Ϲ�������������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String sexRegexString = "^��|Ů$";
				String telRegexString = "^(13[0-9]|17[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
				String emailRegexString = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
				String ageRegexString = "^\\d{1,2}$";
				if (!((telephone.equals("") || Pattern.matches(telRegexString, telephone))
						&& (email.equals("") || Pattern.matches(emailRegexString, email))
						&& (age.equals("") || Pattern.matches(ageRegexString, age))
						&& (sex.equals("") || Pattern.matches(sexRegexString, sex)))) {
					JOptionPane.showMessageDialog(null, "�绰�����䡢�Ա�����䲻���Ϲ�������������", "֪ͨ",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if (!password.equals(verifyPassword)) {
					JOptionPane.showMessageDialog(null, "�����������벻һ�£�����������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if (DBUtils.checkReaderNumber(numberInt)) {
					JOptionPane.showMessageDialog(null, "�˺���ע�ᣬ����������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					numberTextField.setText("");
					return;
				}
				if (DBUtils.registerReader(numberInt, name, sex, email, telephone, age, password, verifyPassword)) {
					JOptionPane.showMessageDialog(null, "ע��ɹ���", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

			}
		});
		registerButton.setBounds(68, 340, 100, 30);
		contentPane.add(registerButton);

		JButton cancleButton = new JButton("ȡ��");
		cancleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancleButton.setBounds(236, 340, 100, 30);
		contentPane.add(cancleButton);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\u957F\u5EA6\u4E0D\u5927\u4E8E4\uFF01\uFF01\uFF01");
		lblNewLabel.setBounds(364, 8, 173, 57);
		contentPane.add(lblNewLabel);
	}
}
