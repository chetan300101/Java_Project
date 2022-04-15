package proj1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class Contact_us {

	private JFrame frmContactUs;
	private JTextField textField;
	private JTextField textField_1;
	JTextArea textArea ;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact_us window = new Contact_us();
					window.frmContactUs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Contact_us() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContactUs = new JFrame();
		frmContactUs.getContentPane().setBackground(SystemColor.info);
		frmContactUs.setTitle("Contact Us");
		frmContactUs.setBounds(100, 100, 872, 674);
		frmContactUs.setVisible(true);
		frmContactUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmContactUs.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTACT US");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(321, 21, 154, 25);
		frmContactUs.getContentPane().add(lblNewLabel);
		
		JTextPane txtpnEmailUsWith = new JTextPane();
		txtpnEmailUsWith.setEditable(false);
		txtpnEmailUsWith.setBackground(SystemColor.info);
		txtpnEmailUsWith.setFont(new Font("Calibri", Font.BOLD, 25));
		txtpnEmailUsWith.setText("Email us with any questions or inquiries. We would be happy to answer your questions and set up a meeting with you. ");
		txtpnEmailUsWith.setBounds(45, 147, 660, 62);
		frmContactUs.getContentPane().add(txtpnEmailUsWith);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(107, 248, 82, 30);
		frmContactUs.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(107, 296, 82, 30);
		frmContactUs.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(107, 345, 97, 30);
		frmContactUs.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Message");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(107, 423, 82, 30);
		frmContactUs.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {						
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
					Statement st=con.createStatement();  
					
					String str1 = textField.getText();
					String str2 = textField_1.getText();
					String str3 = textField_2.getText();
					String str4 = textArea.getText();
					
					
					ResultSet rec = st.executeQuery("SELECT * FROM newaccount where email='"+str2+"'");
					if(rec.next())
					{
						String query1="INSERT INTO `contact_us`" + " (`name`, `email`,`subject`,`message`)" + "VALUES('" +str1+"','"+str2+"','"+str3+"','"+str4+"')";
						st.executeUpdate(query1); // record added. 
				        JOptionPane.showMessageDialog(null, "Message Submitted successfully!");
				        frmContactUs.dispose();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Username. Try Again...!");
					}
					
			        }
					
					catch(Exception e1){
						e1.printStackTrace();
			        }							
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(321, 574, 85, 21);
		frmContactUs.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(233, 245, 280, 30);
		frmContactUs.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 295, 280, 30);
		frmContactUs.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 345, 280, 30);
		frmContactUs.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(25, 71, 823, 40);
		frmContactUs.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(313, 5, 1, 1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GREEN);
		panel.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Appointment");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(54, 10, 140, 35);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Contact us");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setBounds(726, 10, 140, 35);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Change Password");
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setBounds(346, 17, 175, 21);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("Appointment");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmContactUs.dispose();
				new Appointment();
			}
		});
		btnNewButton_1_1.setBounds(282, 5, 140, 30);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(SystemColor.info);
		
		JButton btnNewButton_4 = new JButton("Change Password");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmContactUs.dispose();
				new forgotpass();
			}
		});
		btnNewButton_4.setBounds(553, 5, 206, 30);
		panel.add(btnNewButton_4);
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBackground(SystemColor.info);
		
		JButton btnNewButton_2_1 = new JButton("Home");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmContactUs.dispose();
				new HomePage();
			}
		});
		btnNewButton_2_1.setBounds(10, 5, 140, 30);
		panel.add(btnNewButton_2_1);
		btnNewButton_2_1.setForeground(Color.BLUE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_2_1.setBorder(null);
		btnNewButton_2_1.setBackground(SystemColor.info);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setVisible(true);
		textArea.setBounds(231, 410, 316, 128);
		frmContactUs.getContentPane().add(textArea);
		
		JButton btnNewButton_5 = new JButton("Next");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmContactUs.dispose();
				new tpshow();
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_5.setBounds(538, 559, 97, 36);
		frmContactUs.getContentPane().add(btnNewButton_5);
	}
}
