package Administrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.DBUtils;
import java.awt.Color;
import java.awt.SystemColor;

public class Newspaperrukudata {


		private JFrame frame;
		private JPanel contentPane;
		private JTextField nameTextField;
		private JTextField pressTextField;
		private JTextField PubTimeTextField;
		private JTextField totalTextField;
		private JTextField priceTextField;
		private JTextField authortextField;
		

		/**
		 * Create the frame.
		 */
		public Newspaperrukudata() {
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 487, 451);
			frame.setVisible(true);
			//frame.setUndecorated(true);	//���ر�����  ����ֲ�������
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.activeCaption);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);

			JLabel nameLabel = new JLabel("�������֣�");
			nameLabel.setBounds(36, 29, 110, 18);
			contentPane.add(nameLabel);

			nameTextField = new JTextField();
			nameTextField.setColumns(10);
			nameTextField.setBounds(190, 26, 155, 21);
			contentPane.add(nameTextField);

			JLabel pressLabel = new JLabel("���������磺");
			pressLabel.setBounds(36, 69, 110, 21);
			contentPane.add(pressLabel);

			pressTextField = new JTextField();
			pressTextField.setColumns(10);
			pressTextField.setBounds(190, 66, 155, 21);
			contentPane.add(pressTextField);

			JLabel PubTimeLabel = new JLabel("��������ʱ�䣺");
			PubTimeLabel.setBounds(36, 97, 132, 27);
			contentPane.add(PubTimeLabel);
			
			JLabel label = new JLabel("���ߣ�");
			label.setBounds(50, 218, 72, 21);
			contentPane.add(label);
			
			authortextField = new JTextField();
			authortextField.setBounds(186, 216, 159, 24);
			contentPane.add(authortextField);
			authortextField.setColumns(10);
			
			PubTimeTextField = new JTextField();
			PubTimeTextField.setColumns(10);
			PubTimeTextField.setBounds(190, 102, 155, 21);
			contentPane.add(PubTimeTextField);

			JLabel totalLabel = new JLabel("����������");
			totalLabel.setBounds(36, 145, 86, 18);
			contentPane.add(totalLabel);

			totalTextField = new JTextField();
			totalTextField.setColumns(10);
			totalTextField.setBounds(190, 142, 155, 21);
			totalTextField.setOpaque(false);  
			contentPane.add(totalTextField);

			JLabel priceLabel = new JLabel("�����۸�");
			priceLabel.setBounds(36, 185, 100, 15);
			contentPane.add(priceLabel);

			priceTextField = new JTextField();
			priceTextField.setColumns(10);
			priceTextField.setBounds(190, 182, 155, 21);
			contentPane.add(priceTextField);

		

			JButton registerButton = new JButton("�������");
			//registerButton.setToolTipText("\u62A5\u520A\u5165\u5E93");
			//registerButton.setContentAreaFilled(false);/*�쳣*/   //�������������
			registerButton.setIcon(new ImageIcon("D:/���ݿ�/�γ����/3.png"));     //���ð�ťͼ��
			registerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = nameTextField.getText();
					String press = pressTextField.getText();
					String PubTime = PubTimeTextField.getText();
					String total = totalTextField.getText();
					String price = priceTextField.getText();
					String author =authortextField.getText();
					

					if (name.equals("") || total.equals("") || price.equals("")) {
						JOptionPane.showMessageDialog(null, "��������,��������,�����۸������������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					/*if (total.length()<2 ) {
						JOptionPane.showMessageDialog(null, "��������Ϊ0������������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						return;
					}*/
					int total2=0;
					try {
						total2=Integer.valueOf(total);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "��������������Ϲ�������������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					//String nameInt = null;
					int price2=0;
					try {
						price2=Integer.valueOf(price);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "����ļ۸񲻷��Ϲ�������������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					if (DBUtils.checkNews_Number(name)) {
						JOptionPane.showMessageDialog(null, "�ñ����Ѵ��ڣ�����������", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						nameTextField.setText("");
						return;
					}
					if (DBUtils.registerNEWS( name, press, PubTime,  total2, price2,author)) {//�ٴ��޸����
						JOptionPane.showMessageDialog(null, "��ӳɹ���", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "���ʧ�ܣ�", "֪ͨ", JOptionPane.INFORMATION_MESSAGE);
						return;
					}

				}
			});
			registerButton.setBounds(80, 339, 115, 40);
			contentPane.add(registerButton);

			JButton cancleButton = new JButton("ȡ��");
			cancleButton.setIcon(new ImageIcon("D:/���ݿ�/�γ����/2.png"));     //���ð�ťͼ��
			cancleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			cancleButton.setBounds(302, 339, 123, 40);
			contentPane.add(cancleButton);
			

		}
}
