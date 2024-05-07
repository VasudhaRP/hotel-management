
package hotel.management.system;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;


public class Checkout extends JFrame implements ActionListener{
    JLabel lblupdate,lblid,lblroomno,lblcheckintime,lblcheckouttime,tfcheckout;
        JTextField tfroomno,tfcheckin;
        JButton btncheck,btnupdate,back;
        Choice cid;

    public Checkout() {
        
        
        
        
                getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(250, 200, 1100, 600);
                
                lblupdate = new JLabel("Checkout");
		lblupdate.setBounds(470, 30, 200, 30);
                lblupdate.setFont(new Font("Serif",Font.BOLD,25));
		add(lblupdate);
                
                 lblid=new JLabel("Customer ID");
                 lblid.setBounds(25,65,110,30);
                 lblid.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblid);
                
                cid=new Choice();
        
       
        cid.setBounds(190, 70, 200, 30);
        add(cid);
        
         lblroomno=new JLabel("Room Number");
                 lblroomno.setBounds(25,120,110,30);
                 lblroomno.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblroomno);
                 
                  tfroomno=new JTextField();
                  tfroomno.setBounds(190,125,200,25);
                  add(tfroomno);
                 
                  lblcheckintime=new JLabel("Checkin Time");
                 lblcheckintime.setBounds(25,165,110,30);
                 lblcheckintime.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblcheckintime);
                 
                  tfcheckin=new JTextField();
                  tfcheckin.setBounds(190,170,200,25);
                  add(tfcheckin);
                  
                  
                   try{
            Conn conn=new Conn();
            
            String query="select * from customer ";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                cid.add(rs.getString("idno"));
                 tfroomno.setText(rs.getString("roomno"));
                  tfcheckin.setText(rs.getString("checkintime"));
                
            }
            
          
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
                 
                  lblcheckouttime=new JLabel("Checkout Time");
                 lblcheckouttime.setBounds(25,210,110,30);
                 lblcheckouttime.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblcheckouttime);
                 
                 Date date=new Date();
                 
                  tfcheckout=new JLabel(""+date);
                  tfcheckout.setBounds(190,215,200,30);
                  add(tfcheckout);
                 
                
                  
                    btncheck=new JButton("Checkout");
                    btncheck.setBounds(40,280,150,30);
                    btncheck.setBackground(Color.BLACK);
                    btncheck.setForeground(Color.WHITE);
                    btncheck.addActionListener(this);
                    
                    
                  add(btncheck);
                    
                    
                    
                    back=new JButton("Back");
                    back.setBounds(250,280,150,30);
                    back.setBackground(Color.BLACK);
                    back.setForeground(Color.WHITE);
                    back.addActionListener(this);
                    add(back);
                    
//                    try{
//                        Conn conn=new Conn();
//                        String query="select * from customer where id='"+cid.getSelectedItem()+"'";
//                         ResultSet rs=conn.s.executeQuery(query);
//             while(rs.next()){
//                 tfroomno.setText(rs.getString("roomno"));
//                  tfcheckin.setText(rs.getString("checkintime"));
//                  
//             }
//                        
//                        
//                    }catch(Exception e){
//                        e.printStackTrace();
//                    }
//                    
                    ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/checkout1.jpeg"));
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
            String query1="delete from customer where idno='"+cid.getSelectedItem()+"'";
            String query2="update rooms set available='available' where roomno='"+tfroomno.getText()+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            
             JOptionPane.showMessageDialog(null,"Checkout done");
             setVisible(false);
             new Reception();
            
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }

        else if(ae.getSource()== back){
            setVisible(false);
            new Reception();
        }
        
    }
    public static void main(String[] args) {
        new Checkout();
        
    }
    
}

