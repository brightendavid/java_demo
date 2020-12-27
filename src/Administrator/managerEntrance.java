package Administrator;//第一步登录界面，和READER相同,此时和读者界面是一样的
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

import reader.ReaderEntrance;
import reader.ReaderRegister;
import utils.DBUtils;
import java.awt.Color;


public class managerEntrance {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField numberTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	
	private JLabel nameLabel;
	private JTextField nameTextField;
	
	private JButton registerButton;
	private JButton loginButton;

	public static int manageNumber;

	/**
	 * Create the frame.
	 */
	public managerEntrance() {
		frame = new JFrame();
		frame.setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		frame.setBounds(100, 100, 528, 348);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		JLabel numberLabel = new JLabel("number:");
		numberLabel.setHorizontalAlignment(SwingConstants.LEFT);
		numberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		numberLabel.setBounds(91, 35, 95, 40);
		contentPane.add(numberLabel);

		numberTextField = new JTextField();
		numberTextField.setBounds(193, 35, 180, 40);
		contentPane.add(numberTextField);
		numberTextField.setColumns(10);

		passwordLabel = new JLabel("密码：");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		passwordLabel.setBounds(107, 104, 60, 40);
		contentPane.add(passwordLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(193, 107, 180, 40);
		contentPane.add(passwordTextField);

//姓名栏
		nameLabel = new JLabel("姓名：");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		nameLabel.setBounds(91, 150, 60, 40);
		contentPane.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(193, 150, 180, 40);
		contentPane.add(nameTextField);
		
		
		registerButton = new JButton("注册");
		registerButton.setBackground(Color.CYAN);
		registerButton.setEnabled(false);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderRegister();
			}
		});
		registerButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		registerButton.setBounds(14, 212, 120, 40);
		contentPane.add(registerButton);
//登录检查,完成，姓名输入是无效的，独立的admin登录界面
		loginButton = new JButton("登录");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberStr = numberTextField.getText().trim();
				String password = String.valueOf(passwordTextField.getPassword());
				
				String name=String.valueOf(nameTextField.getName());//固有的getName属性
				
				if (password.equals("") || numberStr.equals("")||name.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "请输入num或密码或姓名", "通知", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("---empty number or password!---");
					return;
				}
				int number = 0;
				try {
					number = Integer.parseInt(numberStr);
					manageNumber = number;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "请输入合法学号", "通知", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("---invalid number!---");
					return;
				}

				//boolean isValidReader = DBUtils.verifyReader(number, password);
				boolean isValidAdimin = DBUtils.verifyAdmin(number, password,name);
				if (isValidAdimin) {
					frame.dispose();
					System.out.println("---login success!---");
					new managerDetail();
				} else {
					JOptionPane.showMessageDialog(null, "学号或者密码或姓名不正确", "通知", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		loginButton.setBounds(148, 212, 120, 40);
		contentPane.add(loginButton);
		frame.getRootPane().setDefaultButton(loginButton);
		
		JButton btnNewButton = new JButton("跳跃到READER");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ReaderEntrance();
			}
		});
		btnNewButton.setBounds(282, 212, 226, 40);
		contentPane.add(btnNewButton);
	}
}
