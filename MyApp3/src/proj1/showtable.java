package proj1;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showtable {

	private JFrame frame;
	private JTable table1;
	DefaultTableModel model;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showtable window = new showtable();
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
	public showtable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Appointments List");
		frame.setBounds(100, 100, 880, 660);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 761, 555);
		frame.getContentPane().add(scrollPane); 
		
		table1 = new JTable();
		table1.setBackground(SystemColor.info);
		scrollPane.setViewportView(table1);
		table1.setFillsViewportHeight(true);
		table1.setColumnSelectionAllowed(true);
		table1.setCellSelectionEnabled(true);
		
		model= new DefaultTableModel();
		Object[] column= {"Name","Gender","Age","Address","City","Appointment Date","Mobile No"};
		model.setColumnIdentifiers(column);
		table1.setModel(model);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setBounds(420, 581, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Appointment();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(SystemColor.info);
		frame.getContentPane().add(btnNewButton);
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/javaproject","root","");  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from appointments");  
			while(rs.next())  
			{
				String s = rs.getString("name");
				String s1 = rs.getString("gender");
				String s2 = rs.getString("age");
				String s3 = rs.getString("address");
				String s4 = rs.getString("city");
				String s5 = rs.getString("adate");
				String s6 = rs.getString("mobile_no");
				
				Object[] row = {s,s1,s2,s3,s4,s5,s6};
				model.addRow(row);
			}
			con.close();  
			}
		catch(Exception e)
		{
				System.out.println(e);
		} 
	
	}
}
