
package hotel.management.system;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateStatus extends JFrame implements ActionListener{
    JLabel lblupdate,lblid,lblroomno,lblname,lblcheckintime,lblamtpaid,lblpendingamt;
        JTextField tfroomno,tfname,tfcheckin,tfamtpaid,tfpendingamt;
        JButton btncheck,btnupdate,back;
        Choice cid;

    public UpdateStatus() {
        
        
        
        
                getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(250, 200, 1100, 600);
                
                lblupdate = new JLabel("Update Status");
		lblupdate.setBounds(470, 30, 200, 30);
                lblupdate.setFont(new Font("Serif",Font.BOLD,25));
		add(lblupdate);
                
                 lblid=new JLabel("ID");
                 lblid.setBounds(25,65,110,30);
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
        cid.setBounds(190, 70, 200, 30);
        add(cid);
        
         lblroomno=new JLabel("Room Number");
                 lblroomno.setBounds(25,110,110,30);
                 lblroomno.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblroomno);
                 
                  tfroomno=new JTextField();
                  tfroomno.setBounds(190,115,200,30);
                  add(tfroomno);
                 
                  lblname=new JLabel("Name");
                 lblname.setBounds(25,155,110,30);
                 lblname.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblname);
                 
                  tfname=new JTextField();
                  tfname.setBounds(190,160,200,30);
                  add(tfname);
                 
                  lblcheckintime=new JLabel("Checkin Time");
                 lblcheckintime.setBounds(25,200,110,30);
                 lblcheckintime.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblcheckintime);
                 
                  tfcheckin=new JTextField();
                  tfcheckin.setBounds(190,205,200,30);
                  add(tfcheckin);
                 
                  lblamtpaid=new JLabel("Amount Paid");
                 lblamtpaid.setBounds(25,245,110,30);
                 lblamtpaid.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblamtpaid);
                 
                  tfamtpaid=new JTextField();
                  tfamtpaid.setBounds(190,250,200,30);
                  add(tfamtpaid);
                 
                  lblpendingamt=new JLabel("Pending Amount");
                 lblpendingamt.setBounds(25,290,125,30);
                 lblpendingamt.setFont(new Font("Serif",Font.PLAIN,17));
                 add(lblpendingamt);
                 
                  tfpendingamt=new JTextField();
                  tfpendingamt.setBounds(190,295,200,30);
                  add(tfpendingamt);
                  
                    btncheck=new JButton("Check");
                    btncheck.setBounds(50,400,100,30);
                    btncheck.setBackground(Color.BLACK);
                    btncheck.setForeground(Color.WHITE);
                    btncheck.addActionListener(this);
                    
                    
                  add(btncheck);
                    
                    btnupdate=new JButton("Update");
                    btnupdate.setBounds(170,400,100,30);
                    btnupdate.setBackground(Color.BLACK);
                    btnupdate.setForeground(Color.WHITE);
                    btnupdate.addActionListener(this);
                    add(btnupdate);
                    
                    back=new JButton("Back");
                    back.setBounds(280,400,100,30);
                    back.setBackground(Color.BLACK);
                    back.setForeground(Color.WHITE);
                    back.addActionListener(this);
                    add(back);
                    
                    ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/three.jpg"));
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
                  tfname.setText(rs.getString("name"));
                   tfcheckin.setText(rs.getString("checkintime"));
                   tfamtpaid.setText(rs.getString("deposit"));
             }
             ResultSet rs2=conn.s.executeQuery("select * from rooms where roomno='"+tfroomno.getText()+"'");
             while(rs2.next()){
             String total=rs2.getString("price");
             int pending=Integer.parseInt(total)-Integer.parseInt(tfamtpaid.getText());
             tfpendingamt.setText(" "+pending);
             
               }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()== btnupdate){
            String id=cid.getSelectedItem();
            String roomno=tfroomno.getText();
            String name=tfname.getText();
            String checkin=tfcheckin.getText();
            String paid=tfamtpaid.getText();
            String pending=tfpendingamt.getText();
            try{
            Conn conn=new Conn();
            String query="update customer set idno='"+id+"',roomno='"+roomno+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+paid+"' where idno='"+id+"'";
            conn.s.executeUpdate(query); 
            JOptionPane.showMessageDialog(null,"customer Updated successfully");
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()== back){
            setVisible(false);
            new Reception();
        }
        
    }
    public static void main(String[] args) {
        new UpdateStatus();
        
    }
    
}
