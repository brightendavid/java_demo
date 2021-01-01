package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Administrator.managerEntrance;
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
		initialize();//���ý������
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {//������Ŀ�����а�ť��ΪԲ��ť�����������壬��ɫ            �������룬������ȥ
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e);
        }
		
		
		
//������ƿ�ʼ����
		frame = new JFrame("�㽭���̴�ѧͼ��ݹ���ϵͳ");//����
		frame.setAlwaysOnTop(true);
		frame.setBackground(new java.awt.Color(64, 64, 64));
		frame.setBounds(200, 200, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//ͼƬ
		ImageIcon image = new ImageIcon("E:\\OneDrive\\ͼƬ\\ʾ��.jpg");
		JLabel Limage = new JLabel(image);
		Limage.setForeground(java.awt.Color.DARK_GRAY);
		Limage.setBackground(java.awt.Color.CYAN);
		frame.getContentPane().add(Limage,java.awt.BorderLayout.NORTH);//�ϲ�ͼƬ����
		
		
		contentPanel = new JPanel();
		contentPanel.setBackground(java.awt.Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPanel.setLayout(null);
//		frame.setContentPane(contentPanel);

	//	JLabel titleLabel = new JLabel("�㽭���̴�ѧͼ��ݹ���ϵͳ");
		 JLabel titleLabel = new JLabel("�㽭���̴�ѧͼ��ݹ���ϵͳ");
	     Font font=new Font("Monospaced",Font.BOLD,32);//���������ʽ�ʹ�С
	     titleLabel.setFont(font);
		//"<font color='red' size='24'>�㽭���̴�ѧͼ��ݹ���ϵͳ</font>"
		 /*JLabel label = new JLabel("����");
	        Font font=new Font("Monospaced",Font.BOLD,32);//���������ʽ�ʹ�С
	        label.setForeground(Color.RED);//����ǰ��ɫ*/
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		titleLabel.setBounds(53, 24, 329, 50);
		contentPanel.add(titleLabel);
//����Ա
		JButton managerButton = new JButton("����Ա���");
		managerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//�½� ����Ա
				frame.dispose();
				new managerEntrance();//�½�manager��
			}
		});
		managerButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		managerButton.setBounds(131, 87, 200, 50);
		contentPanel.add(managerButton);
		
		
//����
		JButton readerButton = new JButton("�������");
		readerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ReaderEntrance();
			}
		});
		readerButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		readerButton.setBounds(131, 175, 200, 50);
		contentPanel.add(readerButton);
		
		
		
		frame.getContentPane().add(contentPanel,BorderLayout.CENTER);
	}

}
