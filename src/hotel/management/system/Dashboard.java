
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
    
    

    public Dashboard() {
        setBounds(0,0,1700,1000);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(1700,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1700, 1000);
        add(image);
        
        
        JLabel text=new JLabel("WELCOME!!!");
        text.setBounds(600,80,500,300);
        text.setFont(new Font("Serif",Font.PLAIN,46));
        text.setForeground(Color.decode("#e1e2f5"));
        image.add(text);
        
        JMenuBar m1=new JMenuBar();
        m1.setBounds(0,0,1700,50);
        image.add(m1);
        
        JMenu hotel=new JMenu("Hotel Management");
        hotel.setForeground(Color.red);
        hotel.setFont(new Font("garamond",Font.PLAIN,15));
        m1.add(hotel);
        
         JMenu admin=new JMenu("Admin");
        admin.setForeground(Color.BLUE);
       admin.setFont(new Font("garamond",Font.PLAIN,17));
        m1.add(admin);
        
        JMenuItem reception=new JMenuItem("Reception");
        reception.setForeground(Color.red);
       reception.setFont(new Font("garamond",Font.PLAIN,17));
       reception.addActionListener(this);
       hotel.add(reception);
       
       JMenuItem employee=new JMenuItem("Add Employee");
        employee.setForeground(Color.BLUE);
       employee.setFont(new Font("garamond",Font.PLAIN,17));
       employee.addActionListener(this);
       admin.add(employee);
       
//       JMenuItem customer=new JMenuItem("Add Customer");
//        customer.setForeground(Color.BLUE);
//       customer.setFont(new Font("garamond",Font.PLAIN,17));
//      admin.add(customer);
       
       JMenuItem rooms=new JMenuItem("Add Rooms");
        rooms.setForeground(Color.BLUE);
       rooms.setFont(new Font("garamond",Font.PLAIN,17));
       rooms.addActionListener(this);
       admin.add(rooms);
        
        
        
        
        
        
      setVisible(true);  
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getActionCommand().equals("Add Employee")){
         new AddEmployee();}
         else if(ae.getActionCommand().equals("Add Rooms")){
             new AddRooms();
         }else if(ae.getActionCommand().equals("Reception")){
             new Reception();
         }
         
     }
   
    public static void main(String[] args) {
        new Dashboard();
    }
    
}
