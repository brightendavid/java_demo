package Administrator;

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

public class Newspaperrukudata {


		private JFrame frame;
		private JPanel contentPane;
		private JTextField nameTextField;
		private JTextField pressTextField;
		private JTextField PubTimeTextField;
		private JTextField totalTextField;
		private JTextField priceTextField;
		

		/**
		 * Create the frame.
		 */
		public Newspaperrukudata() {
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 487, 451);
			frame.setVisible(true);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);

			JLabel nameLabel = new JLabel("报刊名字：");
			nameLabel.setBounds(36, 29, 100, 15);
			contentPane.add(nameLabel);

			nameTextField = new JTextField();
			nameTextField.setColumns(10);
			nameTextField.setBounds(190, 26, 155, 21);
			contentPane.add(nameTextField);

			JLabel pressLabel = new JLabel("报刊出版社：");
			pressLabel.setBounds(36, 69, 110, 15);
			contentPane.add(pressLabel);

			pressTextField = new JTextField();
			pressTextField.setColumns(10);
			pressTextField.setBounds(190, 66, 155, 21);
			contentPane.add(pressTextField);

			JLabel PubTimeLabel = new JLabel("报刊出版时间：");
			PubTimeLabel.setBounds(36, 105, 140, 18);
			contentPane.add(PubTimeLabel);

			PubTimeTextField = new JTextField();
			PubTimeTextField.setColumns(10);
			PubTimeTextField.setBounds(190, 102, 155, 21);
			contentPane.add(PubTimeTextField);

			JLabel totalLabel = new JLabel("报刊数量：");
			totalLabel.setBounds(36, 145, 100, 15);
			contentPane.add(totalLabel);

			totalTextField = new JTextField();
			totalTextField.setColumns(10);
			totalTextField.setBounds(190, 142, 155, 21);
			contentPane.add(totalTextField);

			JLabel priceLabel = new JLabel("报刊价格：");
			priceLabel.setBounds(36, 185, 100, 15);
			contentPane.add(priceLabel);

			priceTextField = new JTextField();
			priceTextField.setColumns(10);
			priceTextField.setBounds(190, 182, 155, 21);
			contentPane.add(priceTextField);

		

			JButton registerButton = new JButton("报刊入库");
			registerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = nameTextField.getText();
					String press = pressTextField.getText();
					String PubTime = PubTimeTextField.getText();
					String total = totalTextField.getText();
					String price = priceTextField.getText();
					

					if (name.equals("") || total.equals("") || price.equals("")) {
						JOptionPane.showMessageDialog(null, "报刊名字,报刊数量,报刊价格必填，请继续输入", "提示", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if (total.length()<2 ) {
						JOptionPane.showMessageDialog(null, "数量不能为0，请重新输入", "通知", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					String nameInt = null;
					try {
						nameInt = String.valueOf(name);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "报刊名字不符合规则，请重新输入", "通知", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					

					if (DBUtils.checkNews_Number(nameInt)) {
						JOptionPane.showMessageDialog(null, "该报刊已存在，请重新输入", "通知", JOptionPane.INFORMATION_MESSAGE);
						nameTextField.setText("");
						return;
					}
					if (DBUtils.registerNEWS( name, press, PubTime,  total, price)) {
						JOptionPane.showMessageDialog(null, "添加成功！", "通知", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "添加失败！", "通知", JOptionPane.INFORMATION_MESSAGE);
						return;
					}

				}
			});
			registerButton.setBounds(68, 340, 100, 30);
			contentPane.add(registerButton);

			JButton cancleButton = new JButton("取消");
			cancleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			cancleButton.setBounds(236, 340, 100, 30);
			contentPane.add(cancleButton);
		}
	
}
