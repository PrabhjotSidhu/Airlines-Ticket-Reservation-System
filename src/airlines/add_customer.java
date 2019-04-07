/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines;

/**
 *
 * @author PRABHJOT SIDHU
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
//import javafx.scene.layout.Border;

public class add_customer extends JFrame implements ActionListener,ItemListener
{
    
    String h1,path,jj,s1,s2,s3,s6;
    static JFrame f1;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,img;
    static JTextField t1,t2,t3;
    static JButton b1,b2,b3;
    static JRadioButton r1,r2;
    static ButtonGroup bg;
    static JTextArea a1;
    static JDateChooser dt;
    static JScrollPane sp;
    
    add_customer()
    {
        
        
        javax.swing.border.Border b=BorderFactory.createLineBorder(Color.black,3);
        
        f1=new JFrame();
        l1=new JLabel("ADD CUSTOMER DETAILS");
        l2=new JLabel("Customer ID");
        l3=new JLabel("Customer Name");
        l4=new JLabel("Father Name");
        l5=new JLabel("DOB");
        l6=new JLabel(new ImageIcon("images/airplane3.jpg"));
        l7=new JLabel("Gender");
        l8=new JLabel("Address");
        img=new JLabel(" ");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        a1=new JTextArea();
        bg=new ButtonGroup();
        r1=new JRadioButton("male");
        r2=new JRadioButton("female");
        bg.add(r1);
        bg.add(r2);
        //a1=new JTextArea();
        b1=new JButton("SAVE");
        b2=new JButton("BACK");
        b3=new JButton("choose image");
        dt=new JDateChooser();
        //dt.setDateFormatString("dd-MM-yyyy");
        //Date d=new Date("01-01-2000");
        //dt.setDate(d);
        
        sp=new JScrollPane(a1);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        f1.setLayout(null);
        l1.setBounds(150,50,600,100);
        l2.setBounds(100,150,200,100);
        l3.setBounds(100,200,200,100);
        l4.setBounds(100,250,200,100);
        l5.setBounds(100,300,200,100);
        l7.setBounds(100,380,200,100);
        l8.setBounds(100,500,200,100);
        img.setBorder(b);
        img.setBounds(650,180,280,170);

        t1.setBounds(300,190,150,30);
        t2.setBounds(300,240,150,30);
        t3.setBounds(300,290,150,30);
        dt.setBounds(300,340,150,30);
        sp.setBounds(300,500,200,100);
        r1.setBounds(250,380,100,100);
        r2.setBounds(350,380,200,100);
        b1.setBounds(220,650,150,50);
        b2.setBounds(420,650,150,50);
        b3.setBounds(700,380,200,50);
        
        
        Font fo1=new Font("Sans Serif",Font.BOLD,40);
        l1.setFont(fo1);
        l1.setForeground(Color.ORANGE);
        Font fo2=new Font("Dialog",Font.BOLD,20);
        l2.setFont(fo2);
        l3.setFont(fo2);
        l4.setFont(fo2);
        l5.setFont(fo2);
        l7.setFont(fo2);
        l8.setFont(fo2);
        r1.setFont(fo2);
        r2.setFont(fo2);
        b1.setFont(fo2);
        b2.setFont(fo2);
        b3.setFont(fo2);
        
        r1.addItemListener(this);
        r2.addItemListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l7);
        f1.add(l8);
        f1.add(img);
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(dt);
        f1.add(sp);
        f1.add(r1);
        f1.add(r2);
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.setSize(1000,1000);
        f1.setVisible(true);
        
    }
     @Override
    public void itemStateChanged(ItemEvent ie) 
    {
        
        if(r1.isSelected()==true)
        {
            h1="male";
        }
        if(r2.isSelected()==true)
        {
            h1="female";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==b3)
        {
            JFileChooser jf=new JFileChooser();
            int returnValue = jf.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = jf.getSelectedFile();
          System.out.println(selectedFile.getName());
            
         path = selectedFile.getAbsolutePath();
         ImageIcon MyImage = new ImageIcon(path);
        Image img1 = MyImage.getImage();
          //l1.setIcon((Icon) selectedFile);
           ImageIcon image = new ImageIcon(img1);
           img.setIcon(image);
        }}
        
        if(e.getSource()==b2)
        {
            f1.dispose();
            
        }
        
        if(e.getSource()==b1)
        {
            
            Connection c;
            Statement st;
            ResultSet rs;
            PreparedStatement ps;
            
            try
            {
                
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                c=DriverManager.getConnection("jdbc:derby://localhost:1527/airdatabase","root","admin");
                System.out.println("connected");
                
                s1=t1.getText();
                s2=t2.getText();
                s3=t3.getText();
                s6=a1.getText();
                String hj=String.valueOf(dt.getDate());
                
            if((s1.equals("")!=true)&&(s2.equals("")!=true)&&(s3.equals("")!=true)&&(s6.equals("")!=true)&&(path.equals(null)!=true)&&(h1.equals(null)!=true)&&(hj.equals("")!=true))
            {
                
             SimpleDateFormat d1=new SimpleDateFormat("dd-MM-yyyy");
                jj=d1.format(dt.getDate());
                
                ps=c.prepareStatement("insert into AIRTABLE values(?,?,?,?,?,?,?)");
                ps.setString(1,s1);
                ps.setString(2,s2);
                ps.setString(3,s3);
                ps.setString(4,jj);
                ps.setString(5,h1);
                ps.setString(6,s6);
                ps.setString(7,path);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"customer details added successfully...");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"invalid data");
                }
                    
        }
                
            
                else
                {
                    JOptionPane.showMessageDialog(this,"All fields are mandatory !");
                }
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}


