package reader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReaderDetail {

	private JFrame frame;
	private JPanel contentPane;
	private ReaderInfoPanel readerInfoPanel;
	private BookBorrowPanel bookBorrowPanel;
	private BookReturnPanel bookReturnPanel;
	private JButton bookBorrowButton;
	private JButton returnButton;
	private JButton bookReturnButton;
	private JButton reloginButton;

	/**
	 * Create the frame.
	 */
	public ReaderDetail() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(100, 100, 574, 416);

		readerInfoPanel = new ReaderInfoPanel();
		readerInfoPanel.setSize(540, 300);
		readerInfoPanel.setLocation(10, 10);

		bookBorrowPanel = new BookBorrowPanel();
		bookBorrowPanel.setSize(540, 300);
		bookBorrowPanel.setLocation(10, 10);

		bookReturnPanel = new BookReturnPanel();
		bookReturnPanel.setSize(540, 300);
		bookReturnPanel.setLocation(10, 10);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		contentPane.add(readerInfoPanel);
		frame.setContentPane(contentPane);

		bookBorrowButton = new JButton("Õº ÈΩË‘ƒ");
		bookBorrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(readerInfoPanel);
				contentPane.remove(bookReturnPanel);
				bookBorrowPanel.refresh();
				contentPane.add(bookBorrowPanel);
				contentPane.repaint();

			}
		});
		bookBorrowButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		bookBorrowButton.setBounds(16, 320, 120, 50);
		contentPane.add(bookBorrowButton);

		returnButton = new JButton("∑µªÿ∏ˆ»À–≈œ¢");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bookBorrowPanel);
				contentPane.remove(bookReturnPanel);
				contentPane.add(readerInfoPanel);
				contentPane.repaint();
			}
		});
		returnButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		returnButton.setBounds(288, 320, 120, 50);
		contentPane.add(returnButton);

		bookReturnButton = new JButton("Õº ÈπÈªπ");
		bookReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(bookBorrowPanel);
				contentPane.remove(readerInfoPanel);
				bookReturnPanel.refresh();
				contentPane.add(bookReturnPanel);
				contentPane.repaint();
			}
		});
		bookReturnButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		bookReturnButton.setBounds(152, 320, 120, 50);
		contentPane.add(bookReturnButton);

		reloginButton = new JButton("∑µªÿµ«¬º");
		reloginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ReaderEntrance();
			}
		});
		reloginButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		reloginButton.setBounds(424, 320, 120, 50);
		contentPane.add(reloginButton);
	}
}
