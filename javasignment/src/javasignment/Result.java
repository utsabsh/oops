package javasignment;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Result extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField search;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(199, 10, 0, 0);
		contentPane.add(table);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 378, 288);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Grades"
			}
		));
		
		DefaultTableModel three =(DefaultTableModel) table_1.getModel();
		
		try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
            String sql = "SELECT * FROM result";
            java.sql.Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            three.setRowCount(0);//clearing existing rows from the table.

            while(result.next()) {
               
                String name = result.getString("Username");
                String grade = result.getString("Grade");
                
               three.addRow(new Object[] { name, grade,});
                
               

            }
            conn.close();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
		
		JLabel lblNewLabel = new JLabel("Search your name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(123, 35, 161, 13);
		contentPane.add(lblNewLabel);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			    try {
			        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanage", "root", "");
			        String sql = "SELECT * FROM result where Username = ?";
			        PreparedStatement pst = conn.prepareStatement(sql); // Use PreparedStatement instead of Statement
			        pst.setString(1, search.getText()); // Assuming you have a JTextField for the search bar named 'yourSearchTextField'

			        ResultSet result = pst.executeQuery();

			        three.setRowCount(0); // Clearing existing rows from the table.

			        while (result.next()) {
			            String name = result.getString("Username");
			            String grade = result.getString("Grade");

			            three.addRow(new Object[]{name, grade});
			        }

			        conn.close();
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			}

			
		});
		search.setFont(new Font("Tahoma", Font.PLAIN, 13));
		search.setBounds(117, 58, 167, 36);
		contentPane.add(search);
		search.setColumns(10);
	}

}