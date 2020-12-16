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
	public class ReaderRegister {

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
		public ReaderRegister() {
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 418, 431);
			frame.setVisible(true);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);

			JLabel nameLabel = new JLabel("�������֣�");
			nameLabel.setBounds(82, 29, 54, 15);
			contentPane.add(nameLabel);

			nameTextField = new JTextField();
			nameTextField.setColumns(10);
			nameTextField.setBounds(190, 26, 155, 21);
			contentPane.add(nameTextField);

			JLabel pressLabel = new JLabel("���������磺");
			pressLabel.setBounds(82, 69, 54, 15);
			contentPane.add(pressLabel);

			pressTextField = new JTextField();
			pressTextField.setColumns(10);
			pressTextField.setBounds(190, 66, 155, 21);
			contentPane.add(pressTextField);

			JLabel PubTimeLabel = new JLabel("��������ʱ�䣺");
			PubTimeLabel.setBounds(82, 105, 54, 15);
			contentPane.add(PubTimeLabel);

			PubTimeTextField = new JTextField();
			PubTimeTextField.setColumns(10);
			PubTimeTextField.setBounds(190, 102, 155, 21);
			contentPane.add(PubTimeTextField);

			JLabel totalLabel = new JLabel("����������");
			totalLabel.setBounds(82, 145, 54, 15);
			contentPane.add(totalLabel);

			totalTextField = new JTextField();
			totalTextField.setColumns(10);
			totalTextField.setBounds(190, 142, 155, 21);
			contentPane.add(totalTextField);

			JLabel priceLabel = new JLabel("�����۸�");
			priceLabel.setBounds(82, 185, 54, 15);
			contentPane.add(priceLabel);

			priceTextField = new JTextField();
			priceTextField.setColumns(10);
			priceTextField.setBounds(190, 182, 155, 21);
			contentPane.add(priceTextField);

		

			JButton registerButton = new JButton("�������");
			registerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = nameTextField.getText();
					String press = pressTextField.getText();
					String PubTime = PubTimeTextField.getText();
					String total = totalTextField.getText();
					String price = priceTextField.getText();
					

					if (name.equals("") || total.equals("") || price.equals("")) {
						JOptionPane.showMessageDialog(null, "��������,��������,�����۸������������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if (total.length()<2 ) {
						JOptionPane.showMessageDialog(null, "��������Ϊ0������������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					String nameInt = null;
					try {
						nameInt = String.valueOf(name);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "�������ֲ����Ϲ�������������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					

					if (DBUtils.checkReaderNumber(nameInt)) {
						JOptionPane.showMessageDialog(null, "�ñ����Ѵ��ڣ�����������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						nameTextField.setText("");
						return;
					}
					if (DBUtils.registerReader( name, press, PubTime,  total, price)) {
						JOptionPane.showMessageDialog(null, "��ӳɹ���", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "���ʧ�ܣ�", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
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
		}
	}
}
