package proj1;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

public class LoginPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 1151, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JLabel label1 = new JLabel("");
		label1.setBackground(SystemColor.info);
		label1.setIcon(new ImageIcon("C:\\Users\\Marathe\\Downloads\\newLogin.jpg"));
		label1.setBounds(10, 10, 482, 543);
		frame.getContentPane().add(label1);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(645, 34, 83, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(502, 109, 115, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(627, 110, 250, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(502, 192, 121, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) 
			{
				try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
				System.out.println("database connected..");
				Statement st=con.createStatement(); 
				String x = textField.getText();
				String y = pass.getText();
				 
				ResultSet rec = st.executeQuery("SELECT * FROM newaccount where username='"+x+"'and PASSWORD='"+y+"'");
				if(rec.next())
				{
					JOptionPane.showMessageDialog(null, "Login successfully!");
					frame.dispose();
					new HomePage();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username and Password. ");
				}
				}
					
				catch(Exception e1)
				{	
					e1.printStackTrace();
		        }	
			}
			
		});
		btnNewButton.setBounds(new Rectangle(0, 0, 100, 30));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setBounds(596, 446, 85, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(new Rectangle(0, 0, 100, 30));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setDefaultCapable(false);
		btnNewButton_1.setBounds(724, 446, 108, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		pass = new JPasswordField();
		pass.setBounds(627, 192, 250, 35);
		frame.getContentPane().add(pass);
		
		JButton btnNewButton_2 = new JButton("Create Account");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new Create_Account();
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBackground(SystemColor.info);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_2.setBounds(509, 304, 147, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Forgot Password");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new forgotpass();
			}
		});
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBounds(502, 366, 165, 30);
		frame.getContentPane().add(btnNewButton_3);
	}

	protected String numberToWord(int str2) {
		// TODO Auto-generated method stub
		return null;
	}

	protected String parseInt(String text) {
		// TODO Auto-generated method stub
		return null;
	}
}
