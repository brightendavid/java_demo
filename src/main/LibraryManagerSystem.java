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
		initialize();//调用界面设计
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {//将本项目的所有按钮变为圆按钮，并调整字体，润色            独立代码，可以消去
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e);
        }
		
		
		
//界面设计开始界面
		frame = new JFrame("浙江工商大学图书馆管理系统");//窗口
		frame.setAlwaysOnTop(true);
		frame.setBackground(new java.awt.Color(64, 64, 64));
		frame.setBounds(200, 200, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//图片
		ImageIcon image = new ImageIcon("E:\\OneDrive\\图片\\示例.jpg");
		JLabel Limage = new JLabel(image);
		Limage.setForeground(java.awt.Color.DARK_GRAY);
		Limage.setBackground(java.awt.Color.CYAN);
		frame.getContentPane().add(Limage,java.awt.BorderLayout.NORTH);//上部图片部分
		
		
		contentPanel = new JPanel();
		contentPanel.setBackground(java.awt.Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPanel.setLayout(null);
//		frame.setContentPane(contentPanel);

	//	JLabel titleLabel = new JLabel("浙江工商大学图书馆管理系统");
		 JLabel titleLabel = new JLabel("浙江工商大学图书馆管理系统");
	     Font font=new Font("Monospaced",Font.BOLD,32);//设置字体格式和大小
	     titleLabel.setFont(font);
		//"<font color='red' size='24'>浙江工商大学图书馆管理系统</font>"
		 /*JLabel label = new JLabel("文字");
	        Font font=new Font("Monospaced",Font.BOLD,32);//设置字体格式和大小
	        label.setForeground(Color.RED);//设置前景色*/
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		titleLabel.setBounds(53, 24, 329, 50);
		contentPanel.add(titleLabel);
//管理员
		JButton managerButton = new JButton("管理员入口");
		managerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//新建 管理员
				frame.dispose();
				new managerEntrance();//新建manager类
			}
		});
		managerButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		managerButton.setBounds(131, 87, 200, 50);
		contentPanel.add(managerButton);
		
		
//读者
		JButton readerButton = new JButton("读者入口");
		readerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ReaderEntrance();
			}
		});
		readerButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		readerButton.setBounds(131, 175, 200, 50);
		contentPanel.add(readerButton);
		
		
		
		frame.getContentPane().add(contentPanel,BorderLayout.CENTER);
	}

}
