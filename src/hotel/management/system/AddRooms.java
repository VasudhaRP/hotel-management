
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class AddRooms extends JFrame implements ActionListener{
    
    JTextField tfroomno ,tfprice;
    JButton addBtn,cancelBtn;
    JComboBox cbavailable,cbclean,cbbed; 

    public AddRooms() {
        setLayout(null);
        setBounds(400,300,700,500);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel lblheading=new JLabel("Add Rooms");
        lblheading.setBounds(160,30,100,30);
        lblheading.setFont(new Font("Garamond Regular",Font.BOLD,15));
        add(lblheading);
        
        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setBounds(30,70,150,30);
        lblroomno.setFont(new Font("Garamond Regular",Font.PLAIN,15));
        add(lblroomno);
        
         tfroomno=new JTextField();
        tfroomno.setBounds(200,75,200,20);
        add(tfroomno);
        
        JLabel lblavailable=new JLabel("Available");
        lblavailable.setBounds(30,110,150,30);
        lblavailable.setFont(new Font("Garamond Regular",Font.PLAIN,15));
        add(lblavailable);
        
        String availableType[]={"Available","Booked"};
         cbavailable=new JComboBox(availableType);
         cbavailable.setBounds(200,115,200,20);
        add(cbavailable);
        
        JLabel lblclean=new JLabel("Cleaning Status");
        lblclean.setBounds(30,150,150,30);
        lblclean.setFont(new Font("Garamond Regular",Font.PLAIN,15));
        add(lblclean);
        
        String CleanType[]={"Cleaned","Dirty"};
         cbclean=new JComboBox(CleanType);
         cbclean.setBounds(200,155,200,20);
        add(cbclean);
        
        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(30,190,150,30);
        lblprice.setFont(new Font("Garamond Regular",Font.PLAIN,15));
        add(lblprice);
        
         tfprice=new JTextField();
        tfprice.setBounds(200,195,200,20);
        add(tfprice);
        
        JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(30,230,150,30);
        lblbed.setFont(new Font("Garamond Regular",Font.PLAIN,15));
        add(lblbed);
        
         String BedType[]={"Single Bed","Double Bed"};
         cbbed=new JComboBox(BedType);
         cbbed.setBounds(200,235,200,20);
        add(cbbed);
        
         addBtn=new JButton("Add Room");
        addBtn.setBounds(30,280,160,30);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.addActionListener(this);
        add(addBtn);
        
         cancelBtn=new JButton("Cancel");
        cancelBtn.setBounds(210,280,160,30);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.addActionListener(this);
        add(cancelBtn);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image i2=i1.getImage().getScaledInstance(240,300,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
            
         image.setBounds(420,30,240,300 );
         add(image);
        
         
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== addBtn){
            String roomno=tfroomno.getText();
            String price=tfprice.getText();
            String available=(String) cbavailable.getSelectedItem();
            String clean=(String) cbclean.getSelectedItem();
            String bedtype=(String) cbbed.getSelectedItem();
            
            try{
            Conn c=new Conn();
            String string="insert into rooms values('"+roomno+"','"+available+"','"+clean+"','"+price+"','"+bedtype+"')";
             c.s.executeUpdate(string);
             
              JOptionPane.showMessageDialog(null, "Room added successfully");
                
                setVisible(false);
           
              }
            catch(Exception e){
                e.printStackTrace();
            }
}
            else if(ae.getSource()== cancelBtn){
                    setVisible(false);
                    }
            
        
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }
    
}
