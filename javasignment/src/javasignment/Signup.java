package javasignment;

import java.awt.EventQueue;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textEmail;
	private JLabel lblNewLabel_2;
	private JTextField textPhone;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox txtCourse;
	private JComboBox txtMode;
	private JButton create;
	private JLabel lblNewLabel_6;
	private JTextField textPassword;
	private JLabel lblNewLabel_12;
	

	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	public class Txt extends JFrame {

	    public boolean isValidInput(String username, String email, String password, String mode, String course) {
	        if (username.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Username is missing");
	            return false;
	        }

	        if (email.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "You need to put your mail");
	            return false;
	        }

	        if (password.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Put your password");
	            return false;
	        }

	        if (!Pattern.matches("^[A-Z][a-zA-Z]*\\s[a-zA-Z]*$", username) ||
	            !Pattern.matches("^[a-z_0-9]+@[a-z0-9.-]+\\.[A-Z|a-z]{2,}$", email) ||
	            !Pattern.matches("[A-Z][a-zA-Z0-9@#$]+", password)) {
	            JOptionPane.showMessageDialog(this, "Regex error");
	            return false;
	        }

	        if (mode.isEmpty() || course.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Every field is mandatory");
	            return false;
	        }

	        return true;
	    }



	    // Other methods and components...
	}

		
	

	
	public void close() {
	    WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	


	/**
	 * Create the frame.
	 */
	public Signup() {
		setBackground(new Color(169, 169, 169));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 679, 676);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(166, 102, 150, 34);
		contentPane.add(lblNewLabel);
		
		textUsername = new JTextField();
		textUsername.setBounds(306, 102, 229, 40);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PhoneNo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(166, 263, 133, 19);
		contentPane.add(lblNewLabel_1);
		
		textEmail = new JTextField();
		textEmail.setBounds(256, 178, 279, 40);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(166, 181, 111, 28);
		contentPane.add(lblNewLabel_2);
		
		textPhone = new JTextField();
		textPhone.setBounds(256, 255, 279, 40);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Mode:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(221, 414, 85, 40);
		contentPane.add(lblNewLabel_3);
		
		JComboBox txtMode = new JComboBox();
		txtMode.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		txtMode.setModel(new DefaultComboBoxModel(new String[] {"Teacher ", "Student ", "Admin"}));
		txtMode.setBounds(316, 418, 122, 34);
		contentPane.add(txtMode);
		
		lblNewLabel_4 = new JLabel("Course:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(221, 474, 77, 28);
		contentPane.add(lblNewLabel_4);
		
		txtCourse = new JComboBox();
		txtCourse.setModel(new DefaultComboBoxModel(new String[] {"BSC,(BIT)", "BSC,(BIBM)"}));
		txtCourse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtCourse.setBounds(315, 471, 123, 34);
		contentPane.add(txtCourse);
		
		create = new JButton("Create");
		create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    String username = textUsername.getText().trim();
			    String email = textEmail.getText().trim();
			   
			    String password = textPassword.getText().trim();
			    String mode = txtMode.getSelectedItem().toString().trim();
			    String course = txtCourse.getSelectedItem().toString().trim();

			    if (!username.equals("") && !email.equals("") && !password.equals("") && !mode.equals("") && !course.equals("")) {
			        if (Pattern.matches("^[A-Z][a-zA-Z]+\\s[a-zA-Z]+$", username) &&
			                Pattern.matches("^[a-z_0-9]+@[a-z0-9.-]+\\.[A-Z|a-z]{2,}$", email) &&
			                Pattern.matches("[A-Z][a-zA-Z0-9@#$]+", password)) 
			        {

			            JOptionPane.showMessageDialog(null, "Successfully created the account!!!");

			            String url = "jdbc:mysql://localhost:3306/coursemanage";
			            String username1 = "root";
			            String password1 = "";
			            Connection con;

			            try {
			                con = DriverManager.getConnection(url, username1, password1);
			            
			                Statement st = con.createStatement();
			                String insertQuery;
			                
			                if ("Student".equals(mode)) {
			                    insertQuery = "INSERT INTO student (`Username`, `Email`, `Password`, `Mode`, `Course`) VALUES ('" + username + "', '" + email + "','" + password  + "', '" + mode + "','" + course + "')";
			                } else if ("Admin".equals(mode)) {
			                    insertQuery = "INSERT INTO admin (`Username`, `Email`,`Password`, `Mode`) VALUES ('" + username + "', '" + email + "','" + password + "', '" + mode + "')";
			                } else if ("Teacher".equals(mode)) {
			                    insertQuery = "INSERT INTO teacher (`Username`, `Email`, `Password`, `Mode`, `Course`) VALUES ('" + username + "', '" + email + "','" + password + "', '" + mode + "','" + course + "')";
			                } else {
			                    JOptionPane.showMessageDialog(null, "Invalid user type");
			                    return; // You may want to handle this case differently
			                }

			                st.execute(insertQuery);
			                con.close();
			            } catch (Exception ee) {
			                System.out.println(ee);
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Regex error");
			        }
			    } else {
			        JOptionPane.showMessageDialog(null, "Every field is mandatory");
			    }
			}
			});
	

		create.setBackground(new Color(255, 0, 0));
		create.setFont(new Font("Tahoma", Font.BOLD, 17));
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		create.setBounds(339, 530, 103, 34);
		contentPane.add(create);
		
		JButton btnNewButton_1 = new JButton("LogIn");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				close();
				Login nw = new Login();
				nw.setVisible(true);
				
			
			}
		});
		btnNewButton_1.setBounds(339, 588, 103, 34);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_6 = new JLabel("Password:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(161, 342, 85, 19);
		contentPane.add(lblNewLabel_6);
		
		textPassword = new JTextField();
		textPassword.setBounds(256, 334, 279, 40);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Already have an account?");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(118, 594, 209, 25);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("TO SIGNUP PAGE:)");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_13.setBounds(290, 32, 221, 34);
		contentPane.add(lblNewLabel_13);
	}
}