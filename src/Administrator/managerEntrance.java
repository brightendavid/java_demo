package Administrator;//��һ����¼���棬��READER��ͬ,��ʱ�Ͷ��߽�����һ����
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
		numberLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		numberLabel.setBounds(91, 35, 95, 40);
		contentPane.add(numberLabel);

		numberTextField = new JTextField();
		numberTextField.setBounds(193, 35, 180, 40);
		contentPane.add(numberTextField);
		numberTextField.setColumns(10);

		passwordLabel = new JLabel("���룺");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		passwordLabel.setBounds(107, 104, 60, 40);
		contentPane.add(passwordLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(193, 107, 180, 40);
		contentPane.add(passwordTextField);

//������
		nameLabel = new JLabel("������");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		nameLabel.setBounds(91, 150, 60, 40);
		contentPane.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(193, 150, 180, 40);
		contentPane.add(nameTextField);
		
		
		registerButton = new JButton("ע��");
		registerButton.setBackground(Color.CYAN);
		registerButton.setEnabled(false);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderRegister();
			}
		});
		registerButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		registerButton.setBounds(14, 212, 120, 40);
		contentPane.add(registerButton);
//��¼���,��ɣ�������������Ч�ģ�������admin��¼����
		loginButton = new JButton("��¼");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberStr = numberTextField.getText().trim();
				String password = String.valueOf(passwordTextField.getPassword());
				
				String name=String.valueOf(nameTextField.getName());//���е�getName����
				
				if (password.equals("") || numberStr.equals("")||name.contentEquals("")) {
					JOptionPane.showMessageDialog(null, "������num�����������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("---empty number or password!---");
					return;
				}
				int number = 0;
				try {
					number = Integer.parseInt(numberStr);
					manageNumber = number;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "������Ϸ�ѧ��", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "ѧ�Ż����������������ȷ", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		loginButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		loginButton.setBounds(148, 212, 120, 40);
		contentPane.add(loginButton);
		frame.getRootPane().setDefaultButton(loginButton);
		
		JButton btnNewButton = new JButton("��Ծ��READER");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
