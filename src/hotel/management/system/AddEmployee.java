
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class AddEmployee extends JFrame implements ActionListener {
        JTextField tfname,tfage,tfjob,tfsalary,tfphone,tfemail,tfaadhar;
        JRadioButton rbmale,rbfemale;
        JComboBox cbjob;
        JButton saveBtn;
        
    public AddEmployee() {
        setLayout(null);
        setBounds(400,300,700,500);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,20,70,30);
        lblname.setFont(new Font("CG OMEGA",Font.BOLD,15));
        add(lblname);
        
         tfname=new JTextField();
        tfname.setBounds(120,30,200,20);
        add(tfname);
        
        JLabel lblage=new JLabel("Age");
        lblage.setBounds(30,70,70,30);
        lblage.setFont(new Font("CG OMEGA",Font.BOLD,15));
        add(lblage);
        
         tfage=new JTextField();
        tfage.setBounds(120,75,200,20);
        add(tfage);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,110,70,30);
        lblgender.setFont(new Font("CG OMEGA",Font.BOLD,15));
        add(lblgender);
        
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(120,115,80,15);
        rbmale.setFont(new Font("Arial",Font.PLAIN,15));
//        rbmale.setBackground(Color.BLACK);
        rbmale.setForeground(Color.BLACK);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(220,115,80,15);
        rbfemale.setFont(new Font("Arial",Font.PLAIN,15));
//        rbfemale.setBackground(Color.BLACK);
        rbfemale.setForeground(Color.BLACK);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        JLabel lbljob=new JLabel("Job");
        lbljob.setBounds(30,150,70,30);
        lbljob.setFont(new Font("CG OMEGA",Font.BOLD,15));
        add(lbljob);
        
        
        String str[]={"Front Desk Clerk","House Keeper","Manager","Kitchen Staff","Room Service","Chefs","Waiter/waitress"};
         cbjob=new JComboBox(str);
        cbjob.setBounds(120,155,200,20);
        add(cbjob);
        
        
        JLabel lblsalary=new JLabel("Salary");
        lblsalary.setBounds(30,190,70,30);
        lblsalary.setFont(new Font("CG OMEGA",Font.BOLD,15));
        add(lblsalary);
        
         tfsalary=new JTextField();
        tfsalary.setBounds(120,195,200,20);
        add(tfsalary);
        
         
        
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,230,70,30);
        lblphone.setFont(new Font("CG OMEGA",Font.BOLD,15));
        add(lblphone);
        
        
        
         tfphone=new JTextField();
        tfphone.setBounds(120,235,200,20);
        add(tfphone);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(30,270,70,30);
        lblemail.setFont(new Font("CG OMEGA",Font.BOLD,15));
        add(lblemail);
        
         tfemail=new JTextField();
        tfemail.setBounds(120,275,200,20);
        add(tfemail);
        
        JLabel lblaadhar=new JLabel("Aadhar");
        lblaadhar.setBounds(30,310,70,30);
        lblaadhar.setFont(new Font("CG OMEGA",Font.BOLD,15));
        add(lblaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(120,315,200,20);
        add(tfaadhar);
        
         saveBtn=new JButton("Add emplyee");
        saveBtn.setBounds(55,360,150,30);
        saveBtn.addActionListener(this);
        add(saveBtn);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
            
         image.setBounds(340,5,300,400 );
         add(image);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=null;
            
            String salary=tfsalary.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String aadhar=tfaadhar.getText();
           
            if(rbmale.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
            
            String job=(String) cbjob.getSelectedItem();
            
            try{
                Conn conn=new Conn();
                String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
                
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee added successfully");
                
                setVisible(false);
                
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
            
        
    }
            
            
            
            
     public static void main(String[] args) {
         new AddEmployee();
        
    }
    
}
