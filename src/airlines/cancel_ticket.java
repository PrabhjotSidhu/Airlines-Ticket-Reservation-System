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

public class cancel_ticket extends JFrame implements ActionListener
{
   
    static JFrame f1;
    static JLabel l1,l2,img;
    static JTextField t1;
    static JButton b1,b2;
    
    cancel_ticket()
    {
        
        javax.swing.border.Border b=BorderFactory.createLineBorder(Color.black,3);
        f1=new JFrame();
        l1=new JLabel("CANCEL  TICKET");
        l2=new JLabel("Ticket Number");
        img=new JLabel(new ImageIcon("images/airplane8.jpg"));
        
        t1=new JTextField();
        b1=new JButton("CANCEL");
        b2=new JButton("BACK");
        
        f1.setLayout(null);
        l1.setBounds(200,70,600,100);
        l2.setBounds(100,250,200,100);
        img.setBorder(b);
        img.setBounds(580,280,280,280);
        
        t1.setBounds(350,280,150,30);
        b1.setBounds(120,600,150,30);
        b2.setBounds(300,600,150,30);
        
        Font fo1=new Font("Sans Serif",Font.BOLD,40);
        l1.setFont(fo1);
        l1.setForeground(Color.ORANGE);
        Font fo2=new Font("Dialog",Font.BOLD,20);
        l2.setFont(fo2);
        b1.setFont(fo2);
        b2.setFont(fo2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f1.add(l1);
        f1.add(l2);
        f1.add(img);
        f1.add(t1);
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
            PreparedStatement ps;
            
            try
            {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                c=DriverManager.getConnection("jdbc:derby://localhost:1527/airdatabase","root","admin");
                System.out.println("connected");
                
                s1=t1.getText();
                ps=c.prepareStatement("delete from TICKETTABLE where Ticket_Number=?");
                ps.setString(1,s1);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"ticket cancellation successful...");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"no such ticket number exists!");
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
