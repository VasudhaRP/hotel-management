
package hotel.management.system;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import hotel.management.system.Login;


public class HotelManagementSystem  extends JFrame implements ActionListener{
        HotelManagementSystem(){
            setSize(1366,565);
            setLocation(100,100);
            setLayout(null);
            
            
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/main.jpg"));
            Image i2=i1.getImage().getScaledInstance(1366,565,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
            
            image.setBounds(0, 0,1366, 565);
            add(image);
            
            JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
            text.setBounds(20,430,1000,90);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("serif",Font.PLAIN,50));
            image.add(text);
            
            JButton next=new JButton("Next");
            next.setBounds(1150,450,150,50);
            next.setForeground(Color.RED);
            next.setFont(new Font("serif",Font.PLAIN,24));
            image.add(next);
            next.addActionListener(this);
            
            
              setVisible(true);
        }
        
        @Override
        public void actionPerformed(ActionEvent ae){
        setVisible(false);
            new Login();

    }
    

 
    public static void main(String[] args) {
       new HotelManagementSystem();
    }
    
}
