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
import javax.swing.table.DefaultTableModel;

public class flight_list extends JFrame implements ActionListener
{
    
    static JFrame f1;
    static JLabel l1;
    static JButton b1,b2;
    static DefaultTableModel model;
    static JScrollPane sp2;
    
    flight_list()
    {
        
        f1=new JFrame();
        l1=new JLabel("VIEW  FLIGHT  LIST");
        b1=new JButton("SHOW FLIGHTS");
        b2=new JButton("BACK");
        
        model=new DefaultTableModel(new String[]{"FLIGHT ID","FLIGHT NAME","FLIGHT SOURCE","FLIGHT DESTINATION","DEPARTURE TIME","ARRIVAL TIME","FLIGHT CHARGES","DATE OF DEPARTURE"},0);
        JTable jt=new JTable();
        jt.getTableHeader().setFont(new Font("Serif",Font.BOLD,12));
        jt.setModel(model);
        
        sp2=new JScrollPane(jt);
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        f1.setLayout(null);
        l1.setBounds(200,70,600,100);
        b1.setBounds(150,250,250,30);
        b2.setBounds(600,250,100,30);
        sp2.setBounds(90,350,1100,300);
        
        Font fo1=new Font("Sans Serif",Font.BOLD,40);
        l1.setFont(fo1);
        l1.setForeground(Color.ORANGE);
        Font fo2=new Font("Dialog",Font.BOLD,20);
        //l2.setFont(fo2);
        b1.setFont(fo2);
        b2.setFont(fo2);
        Font fo3=new Font("Dialog",Font.BOLD,15);
        jt.setFont(fo3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f1.add(l1);
        f1.add(b1);
        f1.add(b2);
        f1.add(sp2);
        f1.setSize(1250,1250);
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
        try
        {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/airdatabase","root","admin");
            System.out.println("connected");
                
            st=c.createStatement();
            String s="Select * from FLIGHTTABLE";
            rs=st.executeQuery(s);
            while(rs.next())
            {
                String str1=rs.getString(1);
                String str2=rs.getString(2);
                String str3=rs.getString(3);
                String str4=rs.getString(4);
                String str5=rs.getString(5);
                String str6=rs.getString(6);
                String str7=rs.getString(7);
                String str8=rs.getString(8);
                model.addRow(new Object[]{str1,str2,str3,str4,str5,str6,str7,str8});
            }
        }
        catch(Exception ee)
        {
            System.out.println(ee.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
}
