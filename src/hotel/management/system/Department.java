
package hotel.management.system;
import java.awt.BorderLayout;
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


public class Department extends JFrame implements ActionListener {
    JLabel lblname,lblbudget;
    JButton back;

    public Department() {
        setLayout(null);
        setBounds(300,300,900,510);
        getContentPane().setBackground(Color.WHITE);
        
        JTable table=new JTable();
        table.setBounds(0, 60, 900, 310);
        table.setFont(new Font("Serif",Font.PLAIN,15));
        add(table);
        try{
            Conn conn=new Conn();
            String query="select * from department";
            ResultSet rs=conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        lblname=new JLabel("Department Name");
        lblname.setBounds(100,30,270,30);
         lblname.setFont(new Font("Serif",Font.BOLD,15));
        add(lblname);
        
        lblbudget=new JLabel("Budget");
        lblbudget.setBounds(630,30,270,30);
         lblbudget.setFont(new Font("Serif",Font.BOLD,15));
        add(lblbudget);
        
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
        new Department();
    }

	
}
    

