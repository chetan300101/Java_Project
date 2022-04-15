package proj1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class forgotpass {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_2_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotpass window = new forgotpass();
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
	public forgotpass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Reset Password Here Using Username");
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setForeground(Color.RED);
		frame.setBounds(100, 100, 842, 635);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reset Password");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(292, 23, 189, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(125, 168, 203, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter New Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(125, 222, 219, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Re-Enter New Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(125, 283, 235, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(370, 168, 272, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(370, 223, 272, 30);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(370, 278, 272, 30);
		frame.getContentPane().add(passwordField_1);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
					System.out.println("database connected..");
					Statement st=con.createStatement(); 
					String x = textField.getText();
					
					
					ResultSet rec = st.executeQuery("SELECT * FROM newaccount where username='"+x+"'");
					if(rec.next())
					{
						String z = passwordField.getText();
						String y = passwordField_1.getText();
						if(z.equalsIgnoreCase(y))
						{
							String query1="UPDATE `newaccount` SET `PASSWORD`= '"+y+"' where username='"+x+"'";
							st.executeUpdate(query1); // record added. 
						
							JOptionPane.showMessageDialog(null, "Updated successfully!");
						
							frame.dispose();
							new LoginPage();
						
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Password Mismatch...!");
						}
						
					}
					else
					{
							JOptionPane.showMessageDialog(null, "Invalid Username. Try Again...!");
					}
			}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(256, 422, 88, 35);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(454, 422, 85, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.info);
		panel.setBounds(37, 75, 738, 40);
		frame.getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(313, 5, 1, 1);
		panel.add(panel_1);
		
		btnNewButton_2 = new JButton("Appointment");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setBounds(54, 10, 140, 35);
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Contact us");
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setBounds(726, 10, 140, 35);
		panel_1.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Change Password");
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBackground(Color.GREEN);
		btnNewButton_4.setBounds(346, 17, 175, 21);
		panel_1.add(btnNewButton_4);
		
		btnNewButton_1_1 = new JButton("Appointment");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new Appointment();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(SystemColor.info);
		btnNewButton_1_1.setBounds(501, 5, 140, 30);
		panel.add(btnNewButton_1_1);
		
		btnNewButton_2_1 = new JButton("Home");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new HomePage();
			}
		});
		btnNewButton_2_1.setForeground(Color.BLUE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_1.setBorder(null);
		btnNewButton_2_1.setBackground(SystemColor.info);
		btnNewButton_2_1.setBounds(66, 5, 140, 30);
		panel.add(btnNewButton_2_1);
	}

}
