package javasignment;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_2;
	private JTextField mail;
	private JTextField crse;
	private JTextField id;
	private JTable table_1;
	private JTable table2;
	private JTextField nam;
	private JTextField cse;
	private JTextField ml;
	private JTable table_2;
	private JTextField n;
	private JTextField i;
	private JTextField s;
	private JTextField g;

	
	
	/**
	 * Launch the application.
	 */// Assuming you have class fields for your UI components, e.g., JTextField id, mail, no, crse

	// Add a method to refresh data in your UI
	public void refreshData() {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
	        String selectSql = "SELECT * FROM student WHERE Username = ?";
	        PreparedStatement selectStmt = conn.prepareStatement(selectSql);

	        // Set parameter for the prepared statement
	        selectStmt.setString(1, id.getText());

	        // Execute the select query
	        ResultSet resultSet = selectStmt.executeQuery();

	        // Check if there is a result
	        if (resultSet.next()) {
	            // Update UI components with the refreshed data
	            mail.setText(resultSet.getString("Email"));
	          
	            crse.setText(resultSet.getString("Course"));
	        }

	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void close() {
	    WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	public Dashboard() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1054, 719);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setForeground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 1040, 682);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Course Management System");
		lblNewLabel_1.setFont(new Font("Century Schoolbook", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 92, 174, 15);
		panel.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(222, 92, 730, 531);
		panel.add(tabbedPane);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 14));
		btnNewButton.setBounds(39, 136, 96, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tutors");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 14));
		btnNewButton_1.setBounds(39, 210, 96, 38);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Course");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_2.setFont(new Font("Serif", Font.PLAIN, 14));
		btnNewButton_2.setBounds(39, 284, 96, 38);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_3.setFont(new Font("Serif", Font.PLAIN, 14));
		btnNewButton_3.setBounds(39, 362, 96, 38);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}

		private void open() {
			// TODO Auto-generated method stub
			dispose();
			Login nw = new Login();
			nw.setVisible(true);

			}
		});
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login signupPage = new Login();
		        signupPage.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Serif", Font.PLAIN, 14));
		btnNewButton_4.setBounds(39, 442, 96, 38);
		panel.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_12 = new JButton("Result");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Result nw = new Result();
				nw.setVisible(true);
			}
		});
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_12.setBounds(399, 240, 94, 36);
		panel_2.add(btnNewButton_12);
		
		JLabel lblNewLabel_13 = new JLabel("Click here to see your result!");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_13.setBounds(163, 252, 241, 13);
		panel_2.add(lblNewLabel_13);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(362, 5, 0, 0);
		panel_3.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 187, 705, 307);
		panel_3.add(scrollPane_1);
		
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Email", "Course"
			}
		));
		
		
		DefaultTableModel two =(DefaultTableModel) table2.getModel();
		
		JButton btnNewButton_6 = new JButton("ADD");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  // add button for teacher
				
				 String name = nam.getText();
		            String email = ml.getText();
		            
		            String course =  cse.getText();
		       

		            if (UserSession.isAdmin()) {
		        try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
		            String insertSql = "INSERT INTO teacher (Username, Email, Course) VALUES (?, ?, ?, ?)";
		            PreparedStatement updateStmt = conn.prepareStatement(insertSql);

		             
		        

		            // Set parameters for the prepared statement
		            updateStmt.setString(1, name);
		            updateStmt.setString(2, email);
		            
		            updateStmt.setString(4, course);
		         

		            // Execute the update query
		           updateStmt.executeUpdate();
		           
		           refreshData();

		           
		           

		           

		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		        
			 } else {
			        // Notify the user that only admin can perform this action
			        JOptionPane.showMessageDialog(null, "Only admin can delete students.", "Access Denied", JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6.setBounds(281, 15, 85, 41);
		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_8 = new JButton("DELETE");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   // delete for teacher
				
				  String name = nam.getText();
				  
				  
				  if (UserSession.isAdmin()) {
				    try {
				        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
				        String deleteSql = "DELETE FROM teacher WHERE Username = ?";
				        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);

				        // Set parameter for the prepared statement
				        deleteStmt.setString(1, name);

				        // Execute the delete query
				        deleteStmt.executeUpdate();
				        
				        refreshData();


				        conn.close();
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				  } else {
				        // Notify the user that only admin can perform this action
				        JOptionPane.showMessageDialog(null, "Only admin can delete students.", "Access Denied", JOptionPane.ERROR_MESSAGE);
				    }
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_8.setBounds(281, 126, 105, 41);
		panel_3.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("UPDATE");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String name = nam.getText();
		            String email = ml.getText();
		            
		            String course =  cse.getText();
		       

		            if (UserSession.isAdmin()) {
		        try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
		            String updateSql = "UPDATE teacher SET  Email=?, Course=? WHERE Username = ?";
		            PreparedStatement updateStmt = conn.prepareStatement(updateSql);

		             
		        

		            // Set parameters for the prepared statement
		            updateStmt.setString(1, email);
		        
		            updateStmt.setString(3, course);
		            updateStmt.setString(4, name);
		         

		            // Execute the update query
		           updateStmt.executeUpdate();
		           
		           refreshData();

		           
		           

		           

		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		            } else {
				        // Notify the user that only admin can perform this action
				        JOptionPane.showMessageDialog(null, "Only admin can delete students.", "Access Denied", JOptionPane.ERROR_MESSAGE);
				    }
			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_9.setBounds(281, 71, 105, 41);
		panel_3.add(btnNewButton_9);
		
		nam = new JTextField();
		nam.setBounds(35, 51, 177, 32);
		panel_3.add(nam);
		nam.setColumns(10);
		
		cse = new JTextField();
		cse.setBounds(51, 134, 148, 30);
		panel_3.add(cse);
		cse.setColumns(10);
		
		ml = new JTextField();
		ml.setBounds(452, 52, 223, 30);
		panel_3.add(ml);
		ml.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(542, 20, 45, 13);
		panel_3.add(lblNewLabel_6);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Name");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(99, 21, 45, 13);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Course");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(99, 104, 57, 13);
		panel_3.add(lblNewLabel_9);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnNewButton_10 = new JButton("ADD");
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // ADD FOR COURSE BUTTON 
				
				 String name = n.getText();
		            String id = i.getText();
		          
		       
		            if (UserSession.isAdmin()) {
		        try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
		            String insertSql = "INSERT INTO course (Name, Id) VALUES (?, ?)";
		            PreparedStatement updateStmt = conn.prepareStatement(insertSql);

		             
		        

		            // Set parameters for the prepared statement
		            updateStmt.setString(1, name);
		            updateStmt.setString(2, id);
		          
		         

		            // Execute the update query
		           updateStmt.executeUpdate();
		           
		           refreshData();

		           

		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		            } else {
				        // Notify the user that only admin can perform this action
				        JOptionPane.showMessageDialog(null, "Only admin can delete students.", "Access Denied", JOptionPane.ERROR_MESSAGE);
				    }
			}
		});
		btnNewButton_10.setBounds(39, 54, 92, 39);
		panel_4.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("DELETE");
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // delete for course
				 String id = i.getText();

				 if (UserSession.isAdmin()) {
				    try {
				        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
				        String deleteSql = "DELETE FROM course WHERE Id = ?";
				        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);

				        // Set parameter for the prepared statement
				        deleteStmt.setString(1, id);

				        // Execute the delete query
				        deleteStmt.executeUpdate();
				        
				        refreshData();


				        conn.close();
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
			 } else {
			        // Notify the user that only admin can perform this action
			        JOptionPane.showMessageDialog(null, "Only admin can delete students.", "Access Denied", JOptionPane.ERROR_MESSAGE);
			    }
				


			}
		});
		btnNewButton_11.setBounds(382, 56, 112, 39);
		panel_4.add(btnNewButton_11);
		
		JScrollPane tb3 = new JScrollPane();
		tb3.setBounds(10, 128, 705, 366);
		panel_4.add(tb3);
		
		table_2 = new JTable();
		tb3.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "ID"
			}
		));
		
		DefaultTableModel three =(DefaultTableModel) table_2.getModel();
		
		try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
            String sql = "SELECT * FROM course";
            java.sql.Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            three.setRowCount(0);//clearing existing rows from the table.

            while(result.next()) {
               
                String name = result.getString("Name");
                String id = result.getString("Id");
      

                three.addRow(new Object[] { name, id});
                
           
            }
            conn.close();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
		
		
		n = new JTextField();
		n.setBounds(160, 56, 194, 39);
		panel_4.add(n);
		n.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Name");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11.setBounds(160, 33, 45, 13);
		panel_4.add(lblNewLabel_11);
		
		i = new JTextField();
		i.setBounds(529, 56, 149, 39);
		panel_4.add(i);
		i.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("ID Module");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_12.setBounds(531, 34, 81, 13);
		panel_4.add(lblNewLabel_12);
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
            String sql = "SELECT * FROM teacher";
            java.sql.Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            two.setRowCount(0);//clearing existing rows from the table.

            while(result.next()) {
               
                String name = result.getString("Username");
                String email = result.getString("Email");
                
               String course = result.getString("Course");

                two.addRow(new Object[] { name, email, course});
                
           
            }
            conn.close();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
		
		
		JButton btnNewButton_5 = new JButton("ADD ");
		btnNewButton_5.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				
				                                      // add button for student
				 String name = id.getText();
		            String email = mail.getText();
		           
		            String course =  crse.getText();
		       

		            if (UserSession.isAdmin()) {
		        try {
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
		            String insertSql = "INSERT INTO student (Username, Email, Course) VALUES (?, ?, ?, ?)";
		            PreparedStatement updateStmt = conn.prepareStatement(insertSql);

		             
		        

		            // Set parameters for the prepared statement
		            updateStmt.setString(1, name);
		            updateStmt.setString(2, email);
		            
		            updateStmt.setString(4, course);
		         

		            // Execute the update query
		           updateStmt.executeUpdate();
		           
		           refreshData();

		           

		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		            } else {
				        // Notify the user that only admin can perform this action
				        JOptionPane.showMessageDialog(null, "Only admin can delete students.", "Access Denied", JOptionPane.ERROR_MESSAGE);
				    }
			}
		});
		btnNewButton_5.setBounds(637, 39, 78, 36);
		panel_1.add(btnNewButton_5);
		
		JButton update = new JButton("UPDATE");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		update.setFont(new Font("SansSerif", Font.BOLD, 16));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Assuming 'updateButton' is the name of your update button
				update.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) { // update button for student
				    	
				    	  String name = id.getText();
				            String email = mail.getText();
				            
				            String course =  crse.getText();
				            
				            
				       
				            if (UserSession.isAdmin()) {
				        try {
				            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
				            String updateSql = "UPDATE student SET  Email=?, Course=? WHERE Username = ?";
				            PreparedStatement updateStmt = conn.prepareStatement(updateSql);

				             
				        

				            // Set parameters for the prepared statement
				            updateStmt.setString(1, email);
				            
				            updateStmt.setString(3, course);
				            updateStmt.setString(4, name);
				         

				            // Execute the update query
				           updateStmt.executeUpdate();
				           
				           refreshData();

				           
				           

				           

				            conn.close();
				        } catch (SQLException ex) {
				            ex.printStackTrace();
				        }
				            } else {
						        // Notify the user that only admin can perform this action
						        JOptionPane.showMessageDialog(null, "Only admin can delete students.", "Access Denied", JOptionPane.ERROR_MESSAGE);
						    }
				    }
				});

				
				
			}
		});
		update.setBounds(608, 89, 107, 36);
		panel_1.add(update);
		
	
		
		JButton btnNewButton_7 = new JButton("DELETE");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //delete button for student
				
				
				    String name = id.getText();
				    
				
				    if (UserSession.isAdmin()) {
				    try {
				        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
				        String deleteSql = "DELETE FROM student WHERE Username = ?";
				        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);

				        // Set parameter for the prepared statement
				        deleteStmt.setString(1, name);

				        // Execute the delete query
				        deleteStmt.executeUpdate();
				        
				        refreshData();


				        conn.close();
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				    } else {
				        // Notify the user that only admin can perform this action
				        JOptionPane.showMessageDialog(null, "Only admin can delete students.", "Access Denied", JOptionPane.ERROR_MESSAGE);
				    }
			}
		
				

			
		});
		btnNewButton_7.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNewButton_7.setBounds(608, 139, 107, 36);
		panel_1.add(btnNewButton_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 177, 494, 317);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Email", "Course"
			}
		));
		
		DefaultTableModel one =(DefaultTableModel) table.getModel();
		
		textField_2 = new JTextField();
		textField_2.setBounds(535, 175, 96, 0);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(526, 308, 189, 36);
		panel_1.add(mail);
		mail.setColumns(10);
		
		crse = new JTextField();
		crse.setBounds(526, 446, 189, 36);
		panel_1.add(crse);
		crse.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(535, 212, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(535, 273, 45, 25);
		panel_1.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("course");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(535, 423, 66, 13);
		panel_1.add(lblNewLabel_5);
		
		id = new JTextField();
		id.setBounds(526, 235, 189, 36);
		panel_1.add(id);
		id.setColumns(10);
		
		s = new JTextField();
		s.setBounds(225, 42, 148, 36);
		panel_1.add(s);
		s.setColumns(10);
		
		JButton btnNewButton_14 = new JButton("ADD");
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   // add grades to result data set
				
				String name = s.getText();
	            String grade = g.getText();
	           
	            if (UserSession.isTeacher()) {

	        try {
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
	            String insertSql = "INSERT INTO result (Username, Grade) VALUES (?, ?)";
	            PreparedStatement updateStmt = conn.prepareStatement(insertSql);

	             
	        

	            // Set parameters for the prepared statement
	            updateStmt.setString(1, name);
	            updateStmt.setString(2, grade);
	        
	         

	            // Execute the update query
	           updateStmt.executeUpdate();
	           
	           refreshData();

	           

	            conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	            } else {
			        // Notify the user that only admin can perform this action
			        JOptionPane.showMessageDialog(null, "Only teacher can put students marks.", "Access Denied", JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		btnNewButton_14.setBounds(364, 113, 85, 36);
		panel_1.add(btnNewButton_14);
		
		g = new JTextField();
		g.setBounds(225, 114, 96, 35);
		panel_1.add(g);
		g.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("STUDENT");
		lblNewLabel_10.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblNewLabel_10.setBounds(40, 53, 123, 13);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_14 = new JLabel("Grade");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_14.setBounds(164, 123, 45, 13);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Name");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_15.setBounds(164, 53, 45, 13);
		panel_1.add(lblNewLabel_15);
		
		try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
            String sql = "SELECT * FROM student";
            java.sql.Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            one.setRowCount(0);//clearing existing rows from the table.

            while(result.next()) {
               
                String name = result.getString("Username");
                String email = result.getString("Email");
                
               String course = result.getString("Course");

                one.addRow(new Object[] { name, email, course});
                
                refreshData();

            }
            conn.close();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
		
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		textField.setBounds(194, 77, 514, 37);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}