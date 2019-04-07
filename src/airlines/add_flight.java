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
import java.sql.*;
import java.text.SimpleDateFormat;

public class add_flight extends JFrame implements ActionListener
{
    String jj,s1,s2,s3,s4,s5,s6,s7;
    static JFrame f1;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    static JTextField t1,t2,t3,t4,t5;
    static JButton b1,b2;
    static JDateChooser dt;
    static JComboBox cb1,cb2;
    
    add_flight()
    {
        
        javax.swing.border.Border b=BorderFactory.createLineBorder(Color.black,3);
        
        f1=new JFrame();
        l1=new JLabel(" ADD  FLIGHT  DETAILS");
        l2=new JLabel("Flight ID");
        l3=new JLabel("Flight Name");
        l4=new JLabel("Flight Source");
        l5=new JLabel("Flight Destination");
        l6=new JLabel("Departure Time");
        l7=new JLabel("Arrival Time");
        l8=new JLabel("Flight Charges");
        l9=new JLabel("Date of Departure");
        l10=new JLabel(new ImageIcon("images/airplane7.jpg"));
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        //t6=new JTextField();
        
        String m[]={"Delhi","Amritsar","Mumbai","Hyderabad","Bangalore","Toronto","USA","London","Amsterdam","Switzerland","Abu Dhabi"};
        cb1=new JComboBox(m);
        cb2=new JComboBox(m);
        
        b1=new JButton("ADD FLIGHT");
        b2=new JButton("BACK");
        
        
        dt=new JDateChooser();
                //dt.setDateFormatString("dd-MM-yyyy");
        
        f1.setLayout(null);
        l1.setBounds(280,50,600,100);
        l2.setBounds(100,150,200,100);
        l3.setBounds(100,200,200,100);
        l4.setBounds(100,250,200,100);
        l5.setBounds(600,250,200,100);
        l6.setBounds(100,300,200,100);
        l7.setBounds(600,300,200,100);
        l8.setBounds(100,350,200,100);
        l9.setBounds(600,350,200,100);
        l10.setBorder(b);
        l10.setBounds(1100,170,280,170);
        
        t1.setBounds(350,185,150,30);
        t2.setBounds(350,235,150,30);
        t3.setBounds(350,335,150,30);
        t4.setBounds(850,335,150,30);
        t5.setBounds(350,385,150,30);
        dt.setBounds(850,385,150,30);
        
        b1.setBounds(150,500,220,50);
        b2.setBounds(400,500,220,50);
        //b3.setBounds(650,500,150,50);
        cb1.setBounds(350,285,150,30);
        cb2.setBounds(850,285,150,30);
        
        
        
        Font fo1=new Font("Sans Serif",Font.BOLD,40);
        l1.setFont(fo1);
        l1.setForeground(Color.ORANGE);
        Font fo2=new Font("Dialog",Font.BOLD,20);
        l2.setFont(fo2);
        l3.setFont(fo2);
        l4.setFont(fo2);
        l5.setFont(fo2);
        l6.setFont(fo2);
        l7.setFont(fo2);
        l8.setFont(fo2);
        l9.setFont(fo2);
        //l10.setFont(fo2);
        b1.setFont(fo2);
        b2.setFont(fo2);
        //b3.setFont(fo2);
        cb1.setFont(fo2);
        cb2.setFont(fo2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        //b3.addActionListener(this);
        
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(l8);
        f1.add(l9);
        f1.add(l10);
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(t4);
        f1.add(t5);
        f1.add(b1);
        f1.add(b2);
        //f1.add(b3);
        f1.add(cb1);
        f1.add(cb2);
        f1.add(dt);
        f1.setSize(1500,1000);
        f1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
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
                s3=String.valueOf(cb1.getSelectedItem());
                s4=String.valueOf(cb2.getSelectedItem());
                s5=t3.getText();
                s6=t4.getText();
                s7=t5.getText();
                String hj=String.valueOf(dt.getDate());
                //String s8=String.valueOf(dt.getDate());
                //System.out.println(dt.getDate());
                if((s1.equals("")==false)&&(s2.equals("")==false)&&(s3.equals("")==false)&&(s4.equals("")==false)&&(s5.equals("")==false)&&(s6.equals("")==false)&&(s7.equals("")==false)&&(hj.equals("")==false))
                {
                SimpleDateFormat d1=new SimpleDateFormat("dd-MM-yyyy");
                jj=d1.format(dt.getDate());
                
                ps=c.prepareStatement("insert into FLIGHTTABLE values(?,?,?,?,?,?,?,?)");
                ps.setString(1,s1);
                ps.setString(2,s2);
                ps.setString(3,s3);
                ps.setString(4,s4);
                ps.setString(5,s5);
                ps.setString(6,s6);
                ps.setString(7,s7);
                ps.setString(8,jj);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"flight details added successfully...");
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
