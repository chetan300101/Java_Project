package proj1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class HomePage {

	protected static Object btnNewButton_4;
	protected static Object btnNewButton_5;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marathe\\Downloads\\pediatric.jpeg"));
		lblNewLabel.setBounds(60, 424, 264, 238);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Marathe\\Downloads\\whitening.jpg"));
		lblNewLabel_1.setBounds(445, 424, 305, 238);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Marathe\\Downloads\\radiographic.jpeg"));
		lblNewLabel_2.setBounds(913, 424, 264, 238);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(247, 22, 908, 52);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Appointment");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new Appointment();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setBounds(54, 10, 140, 35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Contact us");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new Contact_us();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(SystemColor.info);
		btnNewButton_2.setBounds(726, 10, 140, 35);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new forgotpass();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(346, 10, 175, 35);
		panel.add(btnNewButton);
		
		JTextPane txtpnFinestDentalTreatment = new JTextPane();
		txtpnFinestDentalTreatment.setEditable(false);
		txtpnFinestDentalTreatment.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtpnFinestDentalTreatment.setText("Finest Dental Treatment At an unbelievably Low Cost. Let Us Design A Smile For You. The Best Doctor Gives The Least Medicines. Modern Dentistry in a Calm and Ralaxed Environment. ");
		txtpnFinestDentalTreatment.setBounds(661, 125, 622, 191);
		frame.getContentPane().add(txtpnFinestDentalTreatment);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Marathe\\Downloads\\smileimage.jpeg"));
		lblNewLabel_4.setBounds(27, 101, 601, 273);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("General Dentistry");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new Appointment();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(86, 697, 196, 30);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Whitening");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Appointment();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBounds(532, 697, 133, 30);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Radiography");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new Appointment();
			}
		});
		btnNewButton_6.setBounds(985, 697, 148, 30);
		frame.getContentPane().add(btnNewButton_6);
		
		frame.setBounds(100, 100, 1307, 786);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
