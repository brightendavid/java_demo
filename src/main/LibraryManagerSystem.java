package main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reader.ReaderEntrance;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryManagerSystem {

	private JFrame frame;

	private JPanel contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryManagerSystem window = new LibraryManagerSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryManagerSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		frame.setContentPane(contentPanel);

		JLabel titleLabel = new JLabel("浙江工商大学图书馆管理系统");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		titleLabel.setBounds(53, 24, 329, 50);
		contentPanel.add(titleLabel);

		JButton managerButton = new JButton("管理员入口");
		managerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		managerButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		managerButton.setBounds(118, 101, 200, 50);
		contentPanel.add(managerButton);

		JButton readerButton = new JButton("读者入口");
		readerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ReaderEntrance();
			}
		});
		readerButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		readerButton.setBounds(118, 178, 200, 50);
		contentPanel.add(readerButton);
	}

}
