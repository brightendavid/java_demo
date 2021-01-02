package reader;//�޸Ķ�����Ϣ����

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.DBUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ReaderInfoModifier {

	private final JDialog dialog = new JDialog();
	private final JPanel contentPanel = new JPanel();
	private final JPanel infoPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReaderInfoModifier dialog = new ReaderInfoModifier();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReaderInfoModifier() {
		int number = ReaderEntrance.readerNumber;
		Map<String, Object> readerInfo = DBUtils.getStudentInfo(number);

		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		dialog.setBounds(100, 100, 516, 300);
		dialog.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.add(infoPanel, BorderLayout.CENTER);
		infoPanel.setLayout(null);

		JLabel nameLabel = new JLabel("������");
		nameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		nameLabel.setBounds(22, 27, 60, 40);
		infoPanel.add(nameLabel);

		JLabel nameInfoLabel = new JLabel(String.valueOf(readerInfo.get("name")));
		nameInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		nameInfoLabel.setBounds(76, 27, 60, 40);
		infoPanel.add(nameInfoLabel);

		JLabel nunberLabel = new JLabel("�˺ţ�");
		nunberLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		nunberLabel.setBounds(22, 94, 60, 40);
		infoPanel.add(nunberLabel);

		JLabel numberInfoLabel = new JLabel(String.valueOf(readerInfo.get("number")));
		numberInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		numberInfoLabel.setBounds(77, 94, 60, 40);
		infoPanel.add(numberInfoLabel);

		JLabel telLabel = new JLabel("�绰��");
		telLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		telLabel.setBounds(222, 94, 60, 40);
		infoPanel.add(telLabel);

		JTextField telInfoTextField = new JTextField(String.valueOf(readerInfo.get("telephone")));
		telInfoTextField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		telInfoTextField.setBounds(280, 94, 129, 40);
		infoPanel.add(telInfoTextField);

		JLabel sexLabel = new JLabel("�Ա�");
		sexLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		sexLabel.setBounds(22, 161, 60, 40);
		infoPanel.add(sexLabel);

		JLabel sexInfoLabel = new JLabel(String.valueOf(readerInfo.get("sex")));
		sexInfoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		sexInfoLabel.setBounds(76, 161, 60, 40);
		infoPanel.add(sexInfoLabel);

		JLabel ageLabel = new JLabel("���䣺");
		ageLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		ageLabel.setBounds(222, 27, 60, 40);
		infoPanel.add(ageLabel);

		JTextField ageInfoTextField = new JTextField(String.valueOf(readerInfo.get("age")));
		ageInfoTextField.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		ageInfoTextField.setBounds(277, 27, 60, 40);
		infoPanel.add(ageInfoTextField);

		JLabel emailLabel = new JLabel("���䣺");
		emailLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		emailLabel.setBounds(222, 161, 60, 40);
		infoPanel.add(emailLabel);

		JTextField emailInfoTextField = new JTextField(String.valueOf(readerInfo.get("email")));
		emailInfoTextField.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		emailInfoTextField.setBounds(280, 161, 129, 40);
		infoPanel.add(emailInfoTextField);
//����סַ
		/*JLabel addressLabel = new JLabel("סַ��");
		addressLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		addressLabel.setBounds(220, 200, 60, 40);
		infoPanel.add(addressLabel);*/

		JTextField addressInfoTextField = new JTextField(String.valueOf(readerInfo.get("email")));
		addressInfoTextField.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		addressInfoTextField.setBounds(280, 211, 220, 40);
		infoPanel.add(addressInfoTextField);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String telephone = telInfoTextField.getText();
						String email = emailInfoTextField.getText();
						String age = ageInfoTextField.getText();

						if (telephone.equals("") || email.equals("") || age.equals("")) {
							JOptionPane.showMessageDialog(null, "�绰�����䡢���������Ϊ�գ����������", "֪ͨ",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}

						String telRegexString = "^(13[0-9]|17[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
						String emailRegexString = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
						String ageRegexString = "^\\d{1,2}$";
						if (!(Pattern.matches(telRegexString, telephone) && Pattern.matches(emailRegexString, email)
								&& Pattern.matches(ageRegexString, age))) {
							JOptionPane.showMessageDialog(null, "�绰����������䲻���Ϲ�������������", "֪ͨ",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}

						int n = JOptionPane.showConfirmDialog(null, "ȷ���޸���?", "��ʾ", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							if (DBUtils.updateReaderInfo(number, telephone, age, email)) {
								JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								dialog.dispose();
								// TODO:
								ReaderInfoPanel.updatePanel();
							} else {
								JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
							}

						} else if (n == JOptionPane.NO_OPTION) {
							return;
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				dialog.getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
