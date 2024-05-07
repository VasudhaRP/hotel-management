/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

/**
 *
 * @author vasud
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vasud
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;




public class Login extends JFrame implements ActionListener  {
    
    JTextField username;
    JPasswordField password;
    JButton login,cancel;

    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       setBounds(500,200,400,300);
       setVisible(true);
       
       JLabel user=new JLabel("Username");
       user.setBounds(20,40,100,30);
       add(user);
       
        username=new JTextField();
       username.setBounds(120,40,150,30);
       add(username);
       
       JLabel pass=new JLabel("Password");
      pass.setBounds(20,80,100,30);
       add(pass);
       
        password=new JPasswordField();
       password.setBounds(120,80,150,30);
       add(password);
       
       login=new JButton("Login");
       login.setBounds(20,130,100,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       add(login);
       
        cancel=new JButton("Cancel");
       cancel.setBounds(130,130,100,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       add(cancel);
       
//       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/user.jpg"));
//       Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//       ImageIcon i3=new ImageIcon(i2);
//       
//        JLabel image=new JLabel(i3);
//       image.setBounds(150,40,50,50);
//       add(image);
       
          
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String user=username.getText();
            String pass=password.getText();
            
            try{
                Conn c=new Conn();
                String query="Select * from login where username='"+user+"' and password='"+pass+"'";
                ResultSet rs=c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
            
            
        }else if(ae.getSource()== cancel){
            setVisible(false);
        }
        
    }
    
    
    
    
    
    public static void main(String[] args) {
        new Login();
        
    }

    
    
}

