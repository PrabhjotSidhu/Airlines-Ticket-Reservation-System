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
import java.awt.Color;
import java.sql.*;

public class ticket_enquiry extends JFrame implements ActionListener
{
    int counter=0;
    String idd,str2,str3,str4,str5,str6,str7,str8,str9;
    static JFrame f1;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,img;
    static JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    static JButton b1,b2;
    
    ticket_enquiry()
    {
        
        javax.swing.border.Border b=BorderFactory.createLineBorder(Color.black,3);
        
        f1=new JFrame();
        l10=new JLabel("TICKET  ENQUIRY");
        l1=new JLabel("Ticket Number");
        l2=new JLabel("Customer ID");
        l3=new JLabel("Customer Name");
        l4=new JLabel("Flight ID");
        l5=new JLabel("Flight Name");
        l6=new JLabel("Source");
        l7=new JLabel("Destination");
        l8=new JLabel("Seats");
        l9=new JLabel("Date of Flight");
        img=new JLabel(new ImageIcon("images/airplane7.jpg"));
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        t8=new JTextField();
        t9=new JTextField();
        
        b1=new JButton("SEARCH");
        b2=new JButton("BACK");
        
        f1.setLayout(null);
        l10.setBounds(200,70,600,100);
        
        l1.setBounds(100,250,200,100);
        l2.setBounds(100,300,200,100);
        l3.setBounds(100,350,200,100);
        l4.setBounds(100,400,200,100);
        l5.setBounds(100,450,200,100);
        l6.setBounds(100,500,200,100);
        l7.setBounds(100,550,200,100);
        l8.setBounds(100,600,200,100);
        l9.setBounds(100,650,200,100);
        
        img.setBorder(b);
        img.setBounds(570,370,280,280);
        
        t1.setBounds(350,280,150,30);
        t2.setBounds(350,330,150,30);
        t3.setBounds(350,380,150,30);
        t4.setBounds(350,430,150,30);
        t5.setBounds(350,480,150,30);
        t6.setBounds(350,530,150,30);
        t7.setBounds(350,580,150,30);
        t8.setBounds(350,630,150,30);
        t9.setBounds(350,680,150,30);
        
        b1.setBounds(620,280,150,30);
        b2.setBounds(230,800,100,30);
        
        Font fo1=new Font("Sans Serif",Font.BOLD,40);
        l10.setFont(fo1);
        l10.setForeground(Color.ORANGE);
        Font fo2=new Font("Dialog",Font.BOLD,20);
        l1.setFont(fo2);
        l2.setFont(fo2);
        l3.setFont(fo2);
        l4.setFont(fo2);
        l5.setFont(fo2);
        l6.setFont(fo2);
        l7.setFont(fo2);
        l8.setFont(fo2);
        l9.setFont(fo2);
        b1.setFont(fo2);
        b2.setFont(fo2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f1.add(l10);
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(l8);
        f1.add(l9);
        f1.add(img);
        
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(t4);
        f1.add(t5);
        f1.add(t6);
        f1.add(t7);
        f1.add(t8);
        f1.add(t9);
        
        f1.add(b1);
        f1.add(b2);
        
        f1.setSize(1000,1000);
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
            
            String s1;
            Connection c;
            Statement st;
            ResultSet rs;
            PreparedStatement ps;
            
            try
            {
                
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                c=DriverManager.getConnection("jdbc:derby://localhost:1527/airdatabase","root","admin");
                System.out.println("connected");
                
                st=c.createStatement();
                s1=t1.getText();
                ps=c.prepareStatement("select * from TICKETTABLE where ticket_number=?");
                ps.setString(1,s1);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    idd=rs.getString(1);
                    str2=rs.getString(2);
                    str3=rs.getString(3);
                    str4=rs.getString(4);
                    str5=rs.getString(5);
                    str6=rs.getString(6);
                    str7=rs.getString(7);
                    str8=String.valueOf(rs.getInt(8));
                    str9=rs.getString(9);
                    if(idd.equals(s1))
                    {
                        counter++;
                    }
                }
                if(counter>0)
                {
                    //t1.setText(rs.getString(1));
                    t2.setText(str2);
                    t3.setText(str3);
                    t4.setText(str4);
                    t5.setText(str5);
                    t6.setText(str6);
                    t7.setText(str7);
                    t8.setText(str8);
                    t9.setText(str9);
                
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"no such Ticket Number exists!");
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
