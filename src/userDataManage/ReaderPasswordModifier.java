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
	private final JLabel oldPasswordLabel = new JLabel("原密码：");
	private final JPasswordField oldPasswordTextField = new JPasswordField();
	private final JLabel newPasswordLabel = new JLabel("新密码：");
	private final JPasswordField newPasswordTextField = new JPasswordField();
	private final JLabel verifyPasswordLabel = new JLabel("密码确认：");
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
			oldPasswordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			oldPasswordLabel.setBounds(36, 25, 105, 40);
			infoPanel.add(oldPasswordLabel);
		}
		{
			oldPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			oldPasswordTextField.setBounds(151, 25, 90, 40);
			infoPanel.add(oldPasswordTextField);
		}
		{
			newPasswordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			newPasswordLabel.setBounds(36, 90, 105, 40);
			infoPanel.add(newPasswordLabel);
		}
		{
			newPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			newPasswordTextField.setBounds(151, 90, 90, 40);
			infoPanel.add(newPasswordTextField);
		}
		{
			verifyPasswordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			verifyPasswordLabel.setBounds(36, 155, 105, 40);
			infoPanel.add(verifyPasswordLabel);
		}
		{
			verifyPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
							JOptionPane.showMessageDialog(null, "原密码、新密码、密码确认均不能为空，请继续输入", "通知",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}

						if (!newPassword.equals(verifyPassword)) {
							JOptionPane.showMessageDialog(null, "新密码、密码确认必须相同，请重新输入", "通知",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (newPassword.length() < 6) {
							JOptionPane.showMessageDialog(null, "新密码长度须不少于6位，请重新输入", "通知",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}

						int n = JOptionPane.showConfirmDialog(null, "确认修改吗?", "提示", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							int number = ReaderEntrance.readerNumber;
							String nowPassword = DBUtils.getNowPassword(number);
							if (!nowPassword.equals(oldPassword)) {
								JOptionPane.showMessageDialog(null, "密码校验失败，请重新输入", "提示",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							}

							if (DBUtils.updateReaderPassword(number, newPassword)) {
								JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
								dialog.dispose();
							} else {
								JOptionPane.showMessageDialog(null, "修改失败，请重试", "提示", JOptionPane.INFORMATION_MESSAGE);
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
