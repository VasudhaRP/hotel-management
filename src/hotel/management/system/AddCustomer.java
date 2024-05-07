
package hotel.management.system;
//import statements
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox cbid;
    Choice croom;
     JTextField tfno,tfname,tfdeposit,tfcountry;
     JRadioButton rbmale,rbfemale;
     JLabel lbltime;
     JButton btnadd,btnback;

    public AddCustomer() {
        setLayout(null);
        setBounds(300,300,900,510);
        getContentPane().setBackground(Color.WHITE);
        
          JLabel lblheading=new JLabel("NEW CUSTOMER FORM");
        lblheading.setBounds(70,15,190,30);
        lblheading.setFont(new Font("Raleway",Font.BOLD,15));
        add(lblheading);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,55,70,30);
        lblid.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lblid);
        
        
        String str[]={"Aadhar Card" ,"Driving Licence","Passport", "Ration card "};
          cbid=new JComboBox(str);
        cbid.setBounds(130,60,150,20);
        add(cbid);
        
        JLabel lblno=new JLabel("Number");
        lblno.setBounds(30,95,70,30);
        lblno.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lblno);
        
         tfno=new JTextField();
        tfno.setBounds(130,100,150,20);
        add(tfno);
        
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,135,70,30);
        lblname.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lblname);
        
         tfname=new JTextField();
        tfname.setBounds(130,140,150,20);
        add(tfname);
        
         JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,175,70,30);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lblgender);
        
         rbmale=new JRadioButton("Male");
        rbmale.setBounds(130,180,65,15);
        rbmale.setFont(new Font("Arial",Font.PLAIN,15));
        rbmale.setForeground(Color.BLACK);
        add(rbmale);
        
         rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(195,180,80,15);
        rbfemale.setFont(new Font("Arial",Font.PLAIN,15));
        rbfemale.setForeground(Color.BLACK);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        
         JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,220,70,30);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lblcountry);
        
         tfcountry=new JTextField();
        tfcountry.setBounds(130,225,150,20);
        add(tfcountry);
        
        JLabel lblroomno=new JLabel("Room no");
        lblroomno.setBounds(30,255,70,30);
        lblroomno.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lblroomno);
        
        croom=new Choice();
        
        try{
            Conn conn=new Conn();
            String query="select * from rooms where available='Available'";
            ResultSet rs=conn.s.executeQuery(query);
            
            while(rs.next()){
                croom.add(rs.getString("roomno"));
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(130, 260, 150, 20);
        add(croom);
        
        
        
        Date date=new Date();
        
        JLabel lblcheckintime=new JLabel("Checkin Time");
        lblcheckintime.setBounds(30,295,155,30);
        lblcheckintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lblcheckintime);
        
         lbltime=new JLabel("" +date);
        lbltime.setBounds(130,295,170,30);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lbltime);
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(30,335,190,30);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,15));
        add(lbldeposit);
        
         tfdeposit=new JTextField();
        tfdeposit.setBounds(130,340,150,20);
        add(tfdeposit);
        
         btnadd=new JButton("Add");
        btnadd.setBounds(40,380,95,30);
        btnadd.setBackground(Color.BLACK);
        btnadd.setForeground(Color.WHITE);
        btnadd.addActionListener(this);
        add(btnadd);
        
         btnback=new JButton("Back");
        btnback.setBounds(155,380,95,30);
         btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.WHITE);
        btnback.addActionListener(this);
        add(btnback);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,420,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
            
         image.setBounds(330,10,500,420 );
         add(image);
        
        
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnadd){
        String id=(String) cbid.getSelectedItem();
        String idno= tfno.getText();
        String name= tfname.getText();
        String gender=null;
        
         if(rbmale.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
         
         String roomno=(String)croom.getSelectedItem();
         String country= tfcountry.getText();
         String Checkin= lbltime.getText();
         String deposit= tfdeposit.getText();
         
         try{
             Conn conn=new Conn();
             
             String query="insert into customer values('"+id+"','"+idno+"','"+name+"','"+gender+"','"+country+"','"+roomno+"','"+Checkin+"','"+deposit+"')";
             String query1="update rooms set available ='Booked' where roomno='"+roomno+"' ";
             conn.s.executeUpdate(query);
             conn.s.executeUpdate(query1);
             
             JOptionPane.showMessageDialog(null,"customer added successfully");
             setVisible(false);
             new Reception();
             
         }
         catch(Exception ae){
             ae.printStackTrace();
         }
        }else if(e.getSource()== btnback){
            setVisible(false);
            new Reception();
        }
        
        
    }
    
    public static void main(String[] args) {
        new AddCustomer();
    }
    
}
