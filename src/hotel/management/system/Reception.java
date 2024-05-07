
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Reception extends JFrame implements ActionListener {
        JButton btnnewcustomer,btnrooms,btndepartment,btnallemployee,btnmanagerinfo,btncustomerinfo,btnsearchroom,  btnupdatestatus,btnroomstatus,btncheckout,btnlogout;
    public Reception() {
         setLayout(null);
        setBounds(300,300,900,510);
        getContentPane().setBackground(Color.WHITE);
       
        
        btnnewcustomer=new JButton("New Customer Form");
        btnnewcustomer.setBounds(15,10,170,30);
        btnnewcustomer.setBackground(Color.BLACK);
        btnnewcustomer.setForeground(Color.WHITE);
        btnnewcustomer.addActionListener(this);
        add(btnnewcustomer);
        
          btnrooms=new JButton("Rooms");
        btnrooms.setBounds(15,50,170,30);
        btnrooms.setBackground(Color.BLACK);
        btnrooms.setForeground(Color.WHITE);
        btnrooms.addActionListener(this);
        add(btnrooms);
        
         btndepartment=new JButton("Department");
        btndepartment.setBounds(15,90,170,30);
        btndepartment.setBackground(Color.BLACK);
        btndepartment.setForeground(Color.WHITE);
        btndepartment.addActionListener(this);
        add(btndepartment);
        
        btnallemployee=new JButton("All Employee");
        btnallemployee.setBounds(15,130,170,30);
        btnallemployee.setBackground(Color.BLACK);
        btnallemployee.setForeground(Color.WHITE);
        btnallemployee.addActionListener(this);
        add(btnallemployee);
        
         btncustomerinfo=new JButton("Customer Info");
        btncustomerinfo.setBounds(15,170,170,30);
        btncustomerinfo.setBackground(Color.BLACK);
        btncustomerinfo.setForeground(Color.WHITE);
        btncustomerinfo.addActionListener(this);
        add(btncustomerinfo);
        
        btnmanagerinfo=new JButton("Manager Info");
        btnmanagerinfo.setBounds(15,210,170,30);
        btnmanagerinfo.setBackground(Color.BLACK);
        btnmanagerinfo.setForeground(Color.WHITE);
        btnmanagerinfo.addActionListener(this);
        add(btnmanagerinfo);
        
        btncheckout=new JButton("Checkout");
        btncheckout.setBounds(15,250,170,30);
        btncheckout.setBackground(Color.BLACK);
        btncheckout.setForeground(Color.WHITE);
        btncheckout.addActionListener(this);
        add(btncheckout);
        
          btnupdatestatus=new JButton("Update status");
        btnupdatestatus.setBounds(15,290,170,30);
        btnupdatestatus.setBackground(Color.BLACK);
        btnupdatestatus.setForeground(Color.WHITE);
        btnupdatestatus.addActionListener(this);
        add(btnupdatestatus);
        
         btnroomstatus=new JButton("Update Room Status");
        btnroomstatus.setBounds(15,330,170,30);
        btnroomstatus.setBackground(Color.BLACK);
        btnroomstatus.setForeground(Color.WHITE);
        btnroomstatus.addActionListener(this);
        add(btnroomstatus);
        
         btnsearchroom=new JButton("Search Room");
        btnsearchroom.setBounds(15,370,170,30);
        btnsearchroom.setBackground(Color.BLACK);
        btnsearchroom.setForeground(Color.WHITE);
        btnsearchroom.addActionListener(this);
        add(btnsearchroom);
        
         btnlogout=new JButton("Logout");
        btnlogout.setBounds(15,410,170,30);
        btnlogout.setBackground(Color.BLACK);
        btnlogout.setForeground(Color.WHITE);
        btnlogout.addActionListener(this);
        add(btnlogout);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/reception1.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,420,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
            
         image.setBounds(210,10,600,420 );
         add(image);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== btnnewcustomer){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource()== btnrooms){
            setVisible(false);
           Room room= new Room();
           room.setVisible(true);
        }
            
        else if(ae.getSource()== btndepartment){
            setVisible(false);
          Department dept=new Department();
          dept.setVisible(true);
    }
        else if(ae.getSource()== btnallemployee){
            setVisible(false);
             new EmloyeeInfo();
    }
        else if(ae.getSource()== btnmanagerinfo){
            setVisible(false);
            new ManagerInfo();
            
    }
        else if(ae.getSource()== btncustomerinfo){
            setVisible(false);
            new CustomerInfo();
            
    }
        else if(ae.getSource()== btnsearchroom){
            setVisible(false);
            new SearchRoom();
            
    }
         else if(ae.getSource()== btnupdatestatus){
            setVisible(false);
            new UpdateStatus();
    }
         else if(ae.getSource()== btnroomstatus){
            setVisible(false);
            new UpdateRoomStatus();
    }
         else if(ae.getSource()== btncheckout){
            setVisible(false);
            new Checkout();
    }
        else if(ae.getSource()== btnlogout){
            setVisible(false);
            new Login();
    }
    }
    
    public static void main(String[] args) {
        new Reception();
    }
    
}
