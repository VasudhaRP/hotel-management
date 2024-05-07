
package hotel.management.system;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateRoomStatus extends JFrame implements ActionListener{
    JLabel lblupdate,lblroomno,lblavailable,lblclean,lblid;
        JTextField tfroomno,tfavai,tfclean;
        JButton btncheck,btnupdate,back;
        Choice cid;

    public UpdateRoomStatus() {
        
        
        
        
                getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(250, 200, 1100, 600);
                
                lblupdate = new JLabel("Update Room Status");
		lblupdate.setBounds(470, 30, 300, 30);
                lblupdate.setFont(new Font("Serif",Font.BOLD,25));
		add(lblupdate);
                
                 lblid=new JLabel("Customer ID");
                 lblid.setBounds(25,80,110,30);
                 lblid.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblid);
                
                cid=new Choice();
        
        try{
            Conn conn=new Conn();
            
            String query="select * from customer ";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                cid.add(rs.getString("idno"));
            }
            
            while(rs.next()){
                cid.add(rs.getString("roomno"));
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        cid.setBounds(190, 85, 200, 40);
        add(cid);
        
         lblroomno=new JLabel("Room Number");
                 lblroomno.setBounds(25,130,110,30);
                 lblroomno.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblroomno);
                 
                  tfroomno=new JTextField();
                  tfroomno.setBounds(190,135,200,30);
                  add(tfroomno);
                 
                  lblavailable=new JLabel("Availability");
                 lblavailable.setBounds(25,180,110,30);
                 lblavailable.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblavailable);
                 
                  tfavai=new JTextField();
                  tfavai.setBounds(190,185,200,30);
                  add(tfavai);
                 
                  lblclean=new JLabel("Cleaning Status");
                 lblclean.setBounds(25,230,110,30);
                 lblclean.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblclean);
                 
                  tfclean=new JTextField();
                  tfclean.setBounds(190,235,200,30);
                  add(tfclean);
                 
                  
                  
                    btncheck=new JButton("Check");
                    btncheck.setBounds(25,300,100,30);
                    btncheck.setBackground(Color.BLACK);
                    btncheck.setForeground(Color.WHITE);
                    btncheck.addActionListener(this);
                    
                    
                  add(btncheck);
                    
                    btnupdate=new JButton("Update");
                    btnupdate.setBounds(150,300,100,30);
                    btnupdate.setBackground(Color.BLACK);
                    btnupdate.setForeground(Color.WHITE);
                    btnupdate.addActionListener(this);
                    add(btnupdate);
                    
                    back=new JButton("Back");
                    back.setBounds(260,300,100,30);
                    back.setBackground(Color.BLACK);
                    back.setForeground(Color.WHITE);
                    back.addActionListener(this);
                    add(back);
                    
                    ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/one.jpg"));
                Image i3 = i1.getImage().getScaledInstance(570, 450,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(450,80,550,450);
                add(l1);
                
                
                setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== btncheck){
        try{
            Conn conn=new Conn();
            String query="select * from customer where idno='"+cid.getSelectedItem()+"'";
             ResultSet rs=conn.s.executeQuery(query);
             while(rs.next()){
                 tfroomno.setText(rs.getString("roomno"));
             }
             ResultSet rs2=conn.s.executeQuery("select * from rooms where roomno='"+tfroomno.getText()+"'");
             while(rs2.next()){
              tfavai.setText(rs2.getString("available"));
              tfclean.setText(rs2.getString("clean"));
             
               }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()== btnupdate){
            String id=cid.getSelectedItem();
            String roomno=tfroomno.getText();
            String available=tfavai.getText();
            String clean=tfclean.getText();
           
            try{
            Conn conn=new Conn();
            String query="update rooms set available='"+available+"',clean='"+clean+"' where roomno='"+roomno+"'";
            conn.s.executeUpdate(query); 
            JOptionPane.showMessageDialog(null,"Data Updated successfully");
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()== back){
            setVisible(false);
            new Reception();
        }
        
    }
    public static void main(String[] args) {
        new UpdateRoomStatus();
        
    }
    
}

