package reader;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Administrator.managerEntrance;
import utils.DBUtils;

public class ReaderEntrance {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField numberTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	private JButton registerButton;
	private JButton loginButton;

	public static int readerNumber;

	/**
	 * Create the frame.
	 */
	public ReaderEntrance() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 319);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		JLabel numberLabel = new JLabel("电话：");
		numberLabel.setHorizontalAlignment(SwingConstants.LEFT);
		numberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		numberLabel.setBounds(91, 35, 60, 40);
		contentPane.add(numberLabel);

		numberTextField = new JTextField();
		numberTextField.setBounds(193, 35, 180, 40);
		contentPane.add(numberTextField);
		numberTextField.setColumns(10);

		passwordLabel = new JLabel("密码：");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		passwordLabel.setBounds(91, 110, 60, 40);
		contentPane.add(passwordLabel);
		
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(193, 110, 180, 40);
		contentPane.add(passwordTextField);
		

		
		registerButton = new JButton("注册");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderRegister();//register()类，注册界面
			}
		});
		registerButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		registerButton.setBounds(14, 185, 120, 40);
		contentPane.add(registerButton);

		
//登录，很奇怪是如何检验的，和数据库对准
		loginButton = new JButton("登录");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberStr = numberTextField.getText().trim();
				String password = String.valueOf(passwordTextField.getPassword());//传参
				if (password.equals("") || numberStr.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入学号和密码", "通知", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("---empty number or password!---");
					return;
				}
				int number = 0;
				try {//报错功能
					number = Integer.parseInt(numberStr);
					readerNumber = number;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "请输入合法学号", "通知", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("---invalid number!---");
					return;
				}

				boolean isValidReader = DBUtils.verifyReader(number, password);
				if (isValidReader) {
					frame.dispose();
					System.out.println("---login success!---");
					new ReaderDetail();
				} else {
					JOptionPane.showMessageDialog(null, "学号或者密码不正确", "通知", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		
		JButton btnNewButton = new JButton("跳跃到Maganager");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new managerEntrance();
			}
		});
		btnNewButton.setBounds(289, 185, 226, 40);
		contentPane.add(btnNewButton);
		
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		loginButton.setBounds(166, 185, 120, 40);
		contentPane.add(loginButton);
		frame.getRootPane().setDefaultButton(loginButton);
	}
}
