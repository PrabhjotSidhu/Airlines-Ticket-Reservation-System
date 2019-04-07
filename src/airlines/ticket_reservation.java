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

public class ticket_reservation extends JFrame implements ActionListener
{
    
    int counter=0,counter2=0;
    String idd,str2,str3,str4,str5,str6,str7;
    static JFrame f1;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,img;
    static JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    static JButton b1,b2,b3,b4,b5;
    //static JDateChooser dt;
    static JComboBox cb1,cb2;
    static JRadioButton r1,r2;
    static ButtonGroup bg;
    static JTextArea a1;
    static JScrollPane sp,sp2;
    static DefaultTableModel model;
    
    ticket_reservation()
    {
        
        javax.swing.border.Border b=BorderFactory.createLineBorder(Color.black,3);
        
        f1=new JFrame();
        l17=new JLabel("TICKET  RESERVATION");
        
        l1=new JLabel("Ticket Number");
        l2=new JLabel("Customer ID");
        l3=new JLabel("Customer Name");
        l4=new JLabel("Father Name");
        l5=new JLabel("Gender");
        l6=new JLabel("DOB");
        l7=new JLabel("Address");
        
        l8=new JLabel("Flight ID");
        l9=new JLabel("Flight Name");
        l10=new JLabel("Seats");
        l11=new JLabel("Departure Time");
        l12=new JLabel("Flight Charges");
        l13=new JLabel("Date");
        l14=new JLabel("Amount");
        l15=new JLabel("Source");
        l16=new JLabel("Destination");
        //l10=new JLabel(new ImageIcon("images/airplane7.jpg"));
        img=new JLabel(" ");
        
        model=new DefaultTableModel(new String[]{"FLIGHT ID","FLIGHT NAME","FLIGHT SOURCE","FLIGHT DESTINATION","DEPARTURE TIME","ARRIVAL TIME","FLIGHT CHARGES","DATE OF DEPARTURE"},0);
        JTable jt=new JTable();
        jt.getTableHeader().setFont(new Font("Serif",Font.BOLD,12));
        jt.setModel(model);
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        t8=new JTextField();
        t9=new JTextField();
        t10=new JTextField();
        t11=new JTextField();
        t12=new JTextField();
        
        String m[]={"Delhi","Amritsar","Mumbai","Hyderabad","Bangalore","Toronto","USA","London","Amsterdam","Switzerland","Abu Dhabi"};
        cb1=new JComboBox(m);
        cb2=new JComboBox(m);
        
        b1=new JButton("SHOW");
        b2=new JButton("SEARCH BY ID");
        b3=new JButton("SEARCH BY NAME");
        b4=new JButton("BOOK");
        b5=new JButton("BACK");
        
        a1=new JTextArea();
        r1=new JRadioButton("male");
        r2=new JRadioButton("female");
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        sp2=new JScrollPane(jt);
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp=new JScrollPane(a1);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        f1.setLayout(null);
        l17.setBounds(300,30,650,100);
        l15.setBounds(50,100,100,100);
        cb1.setBounds(250,130,130,30);
        l16.setBounds(50,170,150,100);
        cb2.setBounds(250,205,130,30);
        b1.setBounds(420,170,100,30);
        sp2.setBounds(580,150,1200,120);
        
        l1.setBounds(70,300,150,80);
          t1.setBounds(270,325,150,30);
        l2.setBounds(70,350,150,80);
          t2.setBounds(270,375,150,30);
        l3.setBounds(70,400,170,80);
          t3.setBounds(270,425,150,30);
        l4.setBounds(70,450,150,80);
          t4.setBounds(270,475,150,30);
          t5.setBounds(270,575,150,30);
        sp.setBounds(270,625,250,70);
        r1.setBounds(270,525,100,30);
        r2.setBounds(400,525,150,30);
        l5.setBounds(70,500,150,80);
        l6.setBounds(70,550,150,80);
        l7.setBounds(70,600,150,80);
        
        b2.setBounds(100,750,200,30);
        b3.setBounds(320,750,230,30);
        b4.setBounds(830,700,100,30);
        b5.setBounds(950,700,100,30);
        
        l8.setBounds(800,290,150,80);
        l9.setBounds(800,340,150,80);
        l10.setBounds(800,390,150,80);
        l11.setBounds(800,440,150,80);
        l12.setBounds(800,490,150,80);
        l13.setBounds(800,540,150,80);
        l14.setBounds(800,590,150,80);
        img.setBorder(b);
        img.setBounds(450,315,280,170);
        
        t6.setBounds(1000,315,150,30);
        t7.setBounds(1000,365,150,30);
        t8.setBounds(1000,415,150,30);
        t9.setBounds(1000,465,150,30);
        t10.setBounds(1000,515,150,30);
        t11.setBounds(1000,565,150,30);
        t12.setBounds(1000,615,150,30);
        
        Font fo1=new Font("Sans Serif",Font.BOLD,40);
        l17.setFont(fo1);
        l17.setForeground(Color.ORANGE);
        Font fo2=new Font("Dialog",Font.BOLD,20);
        Font fo3=new Font("Dialog",Font.BOLD,12);
        l15.setFont(fo2);
        l16.setFont(fo2);
        //l10.setFont(fo2);
        b1.setFont(fo2);
        cb1.setFont(fo2);
        cb2.setFont(fo2);
        jt.setFont(fo3);
        
        l1.setFont(fo2);
        l2.setFont(fo2);
        l3.setFont(fo2);
        l4.setFont(fo2);
        l5.setFont(fo2);
        l6.setFont(fo2);
        l7.setFont(fo2);
        l8.setFont(fo2);
        l9.setFont(fo2);
        l10.setFont(fo2);
        l11.setFont(fo2);
        l12.setFont(fo2);
        l13.setFont(fo2);
        l14.setFont(fo2);
        
        b2.setFont(fo2);
        b3.setFont(fo2);
        b4.setFont(fo2);
        b5.setFont(fo2);
        r1.setFont(fo2);
        r2.setFont(fo2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        f1.add(l17);
        f1.add(l15);
        f1.add(cb1);
        f1.add(l16);
        f1.add(cb2);
        f1.add(b1);
        f1.add(sp2);
        
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
        f1.add(l11);
        f1.add(l12);
        f1.add(l13);
        f1.add(l14);
        
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(t4);
        f1.add(t5);
        f1.add(t6);
        f1.add(t7);
        f1.add(t8);
        f1.add(t9);
        f1.add(t10);
        f1.add(t11);
        f1.add(t12);
        
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(b5);
        
        f1.add(sp);
        f1.add(r1);
        f1.add(r2);
        f1.add(img);
        
        f1.setSize(2400,2400);
        f1.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
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
                
            st=c.createStatement();
            String s1=String.valueOf(cb1.getSelectedItem());
            String s2=String.valueOf(cb2.getSelectedItem());
            ps=c.prepareStatement("Select * from FLIGHTTABLE where FLIGHT_SOURCE=? and FLIGHT_DESTINATION=?");
            ps.setString(1,s1);
            ps.setString(2,s2);
            rs=ps.executeQuery();
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
        }
        
        if(e.getSource()==b5)
        {
            f1.dispose();
        }
        
        if(e.getSource()==b2)
        {
            String s2;
            String s1=t2.getText();
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
                ps=c.prepareStatement("select * from AIRTABLE where Customer_Id=?");
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
                        
                                                                        
                        if(idd.equals(s1))
                        {
                            counter++;
                        }
                    }
                
                if(counter>0)
                {
                  //t1.setText(rs.getString(1));
                        //t2.setText(str2);
                        t3.setText(str2);
                        t4.setText(str3);
                        t5.setText(str4);
                        if(str5.equals("male"))
                        {
                            r1.setSelected(true);
                        }
                        else
                        {
                            r2.setSelected(true);
                        }
                        a1.setText(str6);
                        
                }
                 else
                {
                    JOptionPane.showMessageDialog(this,"no such Customer ID exists!");
                }
                counter=0;
                /*while(rs.next())
                {
                    t2.setText(rs.getString(1));
                    t3.setText(rs.getString(2));
                    t4.setText(rs.getString(3));
                    t5.setText(rs.getString(4));
                    s2=rs.getString(5);
                    if(s2.equals("male"))
                    {
                        r1.setSelected(true);
                    }
                    else
                    {
                        r2.setSelected(true);
                    }
                    a1.setText(rs.getString(6));
                    
                    ImageIcon ii=new ImageIcon(rs.getString(7));
                    img.setIcon(ii);
                }*/
            
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
        
        if(e.getSource()==b3)
        {
            String s2;
            String s1=t3.getText();
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
                ps=c.prepareStatement("select * from AIRTABLE where Customer_Name=?");
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
                        
                                                                        
                        if(str2.equals(s1))
                        {
                            counter2++;
                        }
                    }
                
                if(counter2>0)
                {
                  //t1.setText(rs.getString(1));
                        //t2.setText(str2);
                        t2.setText(idd);
                        t4.setText(str3);
                        t5.setText(str4);
                        if(str5.equals("male"))
                        {
                            r1.setSelected(true);
                        }
                        else
                        {
                            r2.setSelected(true);
                        }
                        a1.setText(str6);
                        
                }
                 else
                {
                    JOptionPane.showMessageDialog(this,"no such Customer Name exists!");
                }
                counter2=0;
            
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
        
        if(e.getSource()==b4)
        {
            
            String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
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
                s2=t6.getText();
                s3=t7.getText();
                s4=t8.getText();
                s5=t9.getText();
                s6=t10.getText();
                s7=t11.getText();
                s8=t12.getText();
                
                s9=t2.getText();
                s10=t3.getText();
                
                ps=c.prepareStatement("insert into TICKETTABLE values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,s1);
                ps.setString(2,s9);
                ps.setString(3,s10);
                ps.setString(4,s2);
                ps.setString(5,s3);
                
                ps.setString(6,String.valueOf(cb1.getSelectedItem()));
                ps.setString(7,String.valueOf(cb2.getSelectedItem()));
                ps.setString(8,s4);
                ps.setString(9,s7);
                ps.setString(10,s5);
                ps.setString(11,s6);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"ticket reservation successful...");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"invalid data");
                }
            
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
    }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
    

