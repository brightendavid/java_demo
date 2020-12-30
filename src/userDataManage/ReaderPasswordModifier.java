package userDataManage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import reader.ReaderEntrance;
import utils.DBUtils;

public class ReaderPasswordModifier {

	private final JDialog dialog = new JDialog();
	private final JPanel contentPanel = new JPanel();
	private final JPanel infoPanel = new JPanel();
	private final JLabel oldPasswordLabel = new JLabel("ԭ���룺");
	private final JPasswordField oldPasswordTextField = new JPasswordField();
	private final JLabel newPasswordLabel = new JLabel("�����룺");
	private final JPasswordField newPasswordTextField = new JPasswordField();
	private final JLabel verifyPasswordLabel = new JLabel("����ȷ�ϣ�");
	private final JPasswordField verifyPasswordTextField = new JPasswordField();

	/**
	 * Create the dialog.
	 */
	public ReaderPasswordModifier() {
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		dialog.setBounds(100, 100, 300, 300);
		dialog.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.add(infoPanel, BorderLayout.CENTER);
		infoPanel.setLayout(null);
		{
			oldPasswordLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			oldPasswordLabel.setBounds(36, 25, 105, 40);
			infoPanel.add(oldPasswordLabel);
		}
		{
			oldPasswordTextField.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			oldPasswordTextField.setBounds(151, 25, 90, 40);
			infoPanel.add(oldPasswordTextField);
		}
		{
			newPasswordLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			newPasswordLabel.setBounds(36, 90, 105, 40);
			infoPanel.add(newPasswordLabel);
		}
		{
			newPasswordTextField.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			newPasswordTextField.setBounds(151, 90, 90, 40);
			infoPanel.add(newPasswordTextField);
		}
		{
			verifyPasswordLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			verifyPasswordLabel.setBounds(36, 155, 105, 40);
			infoPanel.add(verifyPasswordLabel);
		}
		{
			verifyPasswordTextField.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			verifyPasswordTextField.setBounds(151, 155, 90, 40);
			infoPanel.add(verifyPasswordTextField);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String oldPassword = oldPasswordTextField.getText();
						String newPassword = newPasswordTextField.getText();
						String verifyPassword = verifyPasswordTextField.getText();

						if (oldPassword.equals("") || newPassword.equals("") || verifyPassword.equals("")) {
							JOptionPane.showMessageDialog(null, "ԭ���롢�����롢����ȷ�Ͼ�����Ϊ�գ����������", "֪ͨ",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}

						if (!newPassword.equals(verifyPassword)) {
							JOptionPane.showMessageDialog(null, "�����롢����ȷ�ϱ�����ͬ������������", "֪ͨ",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (newPassword.length() < 6) {
							JOptionPane.showMessageDialog(null, "�����볤���벻����6λ������������", "֪ͨ",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}

						int n = JOptionPane.showConfirmDialog(null, "ȷ���޸���?", "��ʾ", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							int number = ReaderEntrance.readerNumber;
							String nowPassword = DBUtils.getNowPassword(number);
							if (!nowPassword.equals(oldPassword)) {
								JOptionPane.showMessageDialog(null, "����У��ʧ�ܣ�����������", "��ʾ",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							}

							if (DBUtils.updateReaderPassword(number, newPassword)) {
								JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								dialog.dispose();
							} else {
								JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								return;
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
