package proj1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class Create_Account {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Account window = new Create_Account(); 
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
	public Create_Account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Create New Account");
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 821, 594);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(259, 36, 286, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(180, 160, 100, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(315, 160, 230, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(180, 195, 100, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(new Rectangle(0, 0, 200, 30));
		textField_1.setBounds(315, 195, 230, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
				System.out.println("database connected..");
				Statement st=con.createStatement(); 
				
				String str1 = textField.getText();
				String str2 = textField_1.getText();
				String str3 = textField_3.getText();
				String str4 = passwordField.getText();
				String str5 = textField_4.getText();
				String str6 = textField_5.getText();
				

				
				//textField_1.setText(numberToWord(str3));
				//pass.setText(str2);
				String query1="INSERT INTO `newaccount`" + " (`firstname`,`lastname`,`username`,`PASSWORD`,`mobileno`,`email`)" + "VALUES('" +str1+"','" +str2+"','" +str3+"','" +str4+"','" +str5+"','" +str6+"')";
				st.executeUpdate(query1); // record added. 
		         JOptionPane.showMessageDialog(null, "Account Created Successfully!");
		         frame.dispose();
		         new LoginPage();
			}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
		}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(199, 443, 112, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(180, 265, 100, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile No");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(180, 300, 100, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				String str5 = textField_4.getText();
				int length = str5.length();
				
				
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
				{
					if(length<10) 
					{
						textField_4.setEditable(true);
					}
					else
					{
						textField_4.setEditable(false);
					}
				}
				else
				{
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE)
					{
						textField_4.setEditable(true);
					}
					else
					{
						textField_4.setEditable(false);
					}
				}
			}
		});
		textField_4.setBounds(new Rectangle(0, 0, 200, 30));
		textField_4.setBounds(315, 300, 230, 30);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(180, 335, 80, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
	//	textField_5.addKeyListener(new KeyAdapter() {
	//		@Override
	//		public void keyPressed(KeyEvent e) 
	//		{
//				//String gmail="gmail";
//				String str3 = textField_5.getText();
//				int length = str3.length();
//				char c=e.getKeyChar();
//				
//				if(e.getKeyChar()>='a' && e.getKeyChar()<='z' || e.getKeyChar()>='0' || e.getKeyChar()<='9' || e.getKeyChar()=='@' || e.getKeyChar()=='.')
//				{
//					if(length<30) 
//					{
//						textField_5.setEditable(true);
//					}
//					else
//					{
//						JOptionPane.showMessageDialog(null, "Invalid gmail format...!");
//						textField_5.setEditable(false);
//					}
//				}
//				else
//				{
//					 
//					
//					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE)
//					{
//						
//						textField_5.setEditable(true);
//					}
//					else
//					{
//						textField_5.setEditable(false);
//					}      
//				
//			}
//			}
//		});
		textField_5.setBounds(315, 335, 230, 30);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(315, 265, 230, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(180, 230, 86, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(315, 230, 230, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Cancel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new LoginPage();
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBackground(SystemColor.info);
		btnNewButton_5.setForeground(new Color(255, 0, 0));
		btnNewButton_5.setBounds(466, 443, 112, 33);
		frame.getContentPane().add(btnNewButton_5);
	}
}
