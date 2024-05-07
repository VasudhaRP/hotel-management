
package hotel.management.system;



import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SearchRoom extends JFrame{
  


	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblAvailability;
        private JLabel lblserach;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRoomNumber;
	private JLabel lblId;
        private JLabel lblroomtype;
        JComboBox cbroom;
        JCheckBox cbavailable;
        

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRoom frame = new SearchRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

        
	public SearchRoom()  {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 200, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                lblserach = new JLabel("Search Room");
		lblserach.setBounds(470, 30, 200, 25);
                lblserach.setFont(new Font("Serif",Font.PLAIN,25));
		contentPane.add(lblserach);
                
                lblroomtype = new JLabel("Room Type");
		lblroomtype.setBounds(50, 70, 200, 25);
                lblroomtype.setFont(new Font("Serif",Font.PLAIN,15));
		contentPane.add(lblroomtype);
                
                cbroom=new JComboBox(new String[]{"Single Bed","Double Bed"});
                cbroom.setBounds(160, 70, 150, 25);
                cbroom.setFont(new Font("Serif",Font.PLAIN,15));
                cbroom.setBackground(Color.WHITE);
                cbroom.setForeground(Color.BLACK);
                contentPane.add(cbroom);
                
                 cbavailable=new JCheckBox("Display Only Available");
                cbavailable.setBounds(700, 70, 300, 25);
                cbavailable.setFont(new Font("Serif",Font.PLAIN,15));
                cbavailable.setBackground(Color.WHITE);
                cbavailable.setForeground(Color.BLACK);
                contentPane.add(cbavailable);
                
                
                
                
                
                
                
                
                
                
		
		table = new JTable();
		table.setBounds(0, 150, 1100, 300);
		contentPane.add(table);
		
		
			
				try{
                                    Conn c = new Conn();
					String displayCustomersql = "select * from rooms";
					//PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
                                
                                JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    Conn conn=new Conn();
                                    String query="Select * from rooms where bedtype='"+cbroom.getSelectedItem()+"'";
                                    String query1="select * from rooms where available='available' and bedtype='"+cbroom.getSelectedItem()+"' ";
                                    ResultSet rs;
                                    if(cbavailable.isSelected()){
                                      rs=  conn.s.executeQuery(query1);
                                    }else{
                                      rs=  conn.s.executeQuery(query);   
                                    }
                                    
                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                    
                                }catch(Exception ae){
                                    ae.printStackTrace();
                                }
			}
		});
		btnSubmit.setBounds(400, 510, 120, 30);
                btnSubmit.setBackground(Color.BLACK);
                btnSubmit.setForeground(Color.WHITE);
		contentPane.add(btnSubmit);
			
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnNewButton.setBounds(550, 510, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
                
                lblId = new JLabel("Room Number");
		lblId.setBounds(60, 120, 90, 14);
		contentPane.add(lblId);
		
		lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(270, 120, 90, 14);
		contentPane.add(lblAvailability);
		
		lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(490, 120, 90, 14);
		contentPane.add(lblCleanStatus);
		
		lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(710, 120, 90, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Bed Type");
		lblNewLabel_1.setBounds(930, 120, 90, 14);
		contentPane.add(lblNewLabel_1);

		
		
                
                getContentPane().setBackground(Color.WHITE);
                setVisible(true);
	}

}


