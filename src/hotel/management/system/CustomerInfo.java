/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
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


public class CustomerInfo extends JFrame implements ActionListener{

        JLabel lblname,lblage,lblgender,lblrole,lblsalary,lblmobile,lblemail,lblaadhar;
        JButton back;
        
    public CustomerInfo() {

    
        setLayout(null);
        setBounds(300,300,900,510);
        getContentPane().setBackground(Color.WHITE);
        
        JTable table=new JTable();
        table.setBounds(0, 65, 900, 310);
        table.setFont(new Font("Serif",Font.PLAIN,15));
        add(table);
        try{
            Conn conn=new Conn();
            String query="select * from customer";
            ResultSet rs=conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        lblname=new JLabel("ID");
        lblname.setBounds(25,30,100,30);
         lblname.setFont(new Font("Serif",Font.BOLD,15));
        add(lblname);
        
        lblage=new JLabel("ID Number");
        lblage.setBounds(135,30,100,30);
         lblage.setFont(new Font("Serif",Font.BOLD,15));
        add(lblage);
        
        lblgender=new JLabel("Name");
        lblgender.setBounds(250,30,100,30);
         lblgender.setFont(new Font("Serif",Font.BOLD,15));
        add(lblgender);
        
        lblrole=new JLabel("Gender");
        lblrole.setBounds(360,30,100,30);
         lblrole.setFont(new Font("Serif",Font.BOLD,15));
        add(lblrole);
        
        lblsalary=new JLabel("Country");
        lblsalary.setBounds(470,30,100,30);
         lblsalary.setFont(new Font("Serif",Font.BOLD,15));
        add(lblsalary);
        
        lblmobile=new JLabel("Room no.");
        lblmobile.setBounds(580,30,100,30);
         lblmobile.setFont(new Font("Serif",Font.BOLD,15));
        add(lblmobile);
        
        lblemail=new JLabel("Checkin Time");
        lblemail.setBounds(679,30,100,30);
         lblemail.setFont(new Font("Serif",Font.BOLD,15));
        add(lblemail);
        
        lblaadhar=new JLabel("Deposit");
        lblaadhar.setBounds(810,30,100,30);
         lblaadhar.setFont(new Font("Serif",Font.BOLD,15));
        add(lblaadhar);
        
        
        
         back=new JButton("Back");
        back.setBounds(270,400,300,30);
       
        back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.addActionListener(this);
         add(back);
        
        
        setVisible(true);
    }

    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new Reception();
        }
    }
    
    
    public static void main(String[] args) {
        new CustomerInfo();
    }
    
}
 

