package proj1;

 import java.awt.EventQueue;
import java.text.DateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

public class Appointment {

	protected static final String UPDATE = null;
	protected static final java.util.Date date = null;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1; 
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JRadioButton rdbtnNewRadioButton_5;

	//protected boolean selectionFound;
	JDateChooser date1 ;
	//SimpleDateFormat date2;
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Appointment window = new Appointment();
					window.frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public Appointment() 
	{
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBackground(SystemColor.info);
		frame.setForeground(Color.GREEN);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(1081,777);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointment");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(479, 21, 187, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(266, 166, 110, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setBounds(266, 212, 110, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_3.setBounds(266, 303, 110, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_4.setBounds(266, 260, 110, 35);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile No");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_5.setBounds(266, 447, 110, 35);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_6.setBounds(266, 348, 110, 35);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Date");
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_8.setBounds(266, 393, 110, 35);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(399, 161, 321, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				String str3 = textField_6.getText();
			int length = str3.length();
			char c=e.getKeyChar();
			
			if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
			{
				if(length<10) 
				{
					textField_1.setEditable(true);
				}
				else
				{
					textField_1.setEditable(false);
				}
			}
			else
			{
				if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE)
				{
					textField_1.setEditable(true);
				}
				else
				{
					textField_1.setEditable(false);
				}      
			
		}
				
				
			}
		});
		textField_1.setBounds(399, 258, 321, 35);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(SystemColor.info);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(399, 210, 80, 30);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		 final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		 rdbtnNewRadioButton_1.setBackground(SystemColor.info);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(495, 210, 80, 30);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		final ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(399, 303, 321, 35);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(399, 348, 321, 35);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				String str8 = textField_6.getText();
				int length = str8.length();
				char c=e.getKeyChar();
				
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
				{
					if(length<10) 
					{
						textField_6.setEditable(true);
					}
					else
					{
						textField_6.setEditable(false);
					}
				}
				else
				{
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE)
					{
						textField_6.setEditable(true);
					}
					else
					{
						textField_6.setEditable(false);
					}      
				
			}
			}
		});
		textField_6.setBounds(399, 447, 321, 35);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		final JButton btnNewButton = new JButton("Submit");
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			private AbstractButton rdbtnNewRadioButton_2;
			private JTextComponent dateChooser;
			private DateFormat sdf;

			  public void actionPerformed(ActionEvent e)
			{
				
					try {						
						
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
						Statement st=con.createStatement();  
						
						String str1 = textField.getText();
						String str2 = "";
						if(rdbtnNewRadioButton.isSelected())
						{
							str2="male";
						}
						else
						{
							str2="female";
						}
				
						 System.out.println(bg.getSelection().getActionCommand());
						
						int str3= Integer.parseInt(textField_1.getText());
			            textField_1.setText(numberToWord(str3));
						
			            String str4 = textField_2.getText();
			            
						String str5 = textField_3.getText();
						
						String str8 = textField_6.getText();
					 

						
						
						
						String query1="INSERT INTO `appointments`" + " (`name`, `gender`,`age`,`address`,`city`,`adate`,`mobile_no`)" + "VALUES('" +str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+date1.getDate()+"','"+str8+"')";
						st.executeUpdate(query1); // record added. 
				         JOptionPane.showMessageDialog(null, "Inserted successfully!");
				        }
					
						catch(Exception e1){
							e1.printStackTrace();
				        }	
				 
				  
					Date dateFromDateChooser = (Date) date1.getDate();
					String dateString = String.format("%1$td-%1$tm-%1$tY", dateFromDateChooser);
					
				  
				 JOptionPane.showMessageDialog(null, "Inserted successfully!"+dateString);
				  
				  
			}

				
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(399, 606, 100, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Show");
		btnNewButton_3.setDefaultCapable(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new showtable();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(635, 606, 100, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.info);
		panel.setBounds(207, 70, 738, 40);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(313, 5, 1, 1);
		panel.add(panel_1);
		
		JButton btnNewButton_1_1 = new JButton("Appointment");
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(Color.GREEN);
		btnNewButton_1_1.setBounds(54, 10, 140, 35);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Contact us");
		btnNewButton_2_1.setForeground(Color.BLUE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_1.setBorder(null);
		btnNewButton_2_1.setBackground(Color.GREEN);
		btnNewButton_2_1.setBounds(726, 10, 140, 35);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Change Password");
		btnNewButton_3_1.setForeground(Color.BLUE);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3_1.setBorder(null);
		btnNewButton_3_1.setBackground(Color.GREEN);
		btnNewButton_3_1.setBounds(346, 17, 175, 21);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Contact_Us");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new Contact_us();
			}
		});
		btnNewButton_1_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.setBackground(SystemColor.info);
		btnNewButton_1_1_1.setBounds(282, 5, 140, 30);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_4 = new JButton("Change Password");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new forgotpass();
			}
		});
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBackground(SystemColor.info);
		btnNewButton_4.setBounds(553, 5, 175, 30);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_2_1_1 = new JButton("Home");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new HomePage();
			}
		});
		btnNewButton_2_1_1.setForeground(Color.BLUE);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_1_1.setBorder(null);
		btnNewButton_2_1_1.setBackground(SystemColor.info);
		btnNewButton_2_1_1.setBounds(10, 5, 140, 30);
		panel.add(btnNewButton_2_1_1);

		
		
		
		date1 = new JDateChooser();
		date1.setDateFormatString("yyyy-MM-dd");
		date1.setBounds(399, 393, 241, 35);
		frame.getContentPane().add(date1);
		
		
		
	
		 
		
		
	}

	protected String numberToWord(int str3) {
		// TODO Auto-generated method stub
		return null;
	}
}
