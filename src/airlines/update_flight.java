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
import javax.swing.table.DefaultTableModel;

public class update_flight extends JFrame implements ActionListener
{
    
    String jj,idd,str2,str3,str4,str5,str6,str7,str8;
    int counter=0;
    static JFrame f1;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    static JTextField t1,t2,t3,t4,t5,t6;
    static JButton b1,b2,b3,b4;
    static JDateChooser dt;
    static JComboBox cb1,cb2;
    static JScrollPane sp2;
    static DefaultTableModel model;
    
    update_flight()
    {
        
        f1=new JFrame();
        l1=new JLabel("UPDATE  FLIGHT  INFORMATION");
        l2=new JLabel("Flight ID");
        l3=new JLabel("Flight Name");
        l4=new JLabel("Flight Source");
        l5=new JLabel("Flight Destination");
        l6=new JLabel("Departure Time");
        l7=new JLabel("Arrival Time");
        l8=new JLabel("Flight Charges");
        l9=new JLabel("Date of Departure");
        //l10=new JLabel(new ImageIcon("images/airplane7.jpg"));
        
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
        
        String m[]={"Delhi","Amritsar","Mumbai","Hyderabad","Bangalore","Toronto","USA","London","Amsterdam","Switzerland","Abu Dhabi"};
        cb1=new JComboBox(m);
        cb2=new JComboBox(m);
        
        b1=new JButton("SEARCH BY ID");
        b2=new JButton("UPDATE");
        b3=new JButton("DELETE");
        b4=new JButton("BACK");
        
        
        dt=new JDateChooser();
        //dt.setDateFormatString("dd-MM-yyyy");
        sp2=new JScrollPane(jt);
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        f1.setLayout(null);
        l1.setBounds(280,50,650,100);
        l2.setBounds(100,150,200,100);
        l3.setBounds(100,200,200,100);
        l4.setBounds(100,250,200,100);
        l5.setBounds(600,250,200,100);
        l6.setBounds(100,300,200,100);
        l7.setBounds(600,300,200,100);
        l8.setBounds(100,350,200,100);
        l9.setBounds(600,350,200,100);
        //l10.setBorder(b);
        //l10.setBounds(1100,170,280,170);
        
        t1.setBounds(350,185,150,30);
        t2.setBounds(350,235,150,30);
        t3.setBounds(350,335,150,30);
        t4.setBounds(850,335,150,30);
        t5.setBounds(350,385,150,30);
        t6.setBounds(850,385,150,30);
        
        b1.setBounds(150,470,220,50);
        b2.setBounds(400,470,150,50);
        b3.setBounds(580,470,150,50);
        b4.setBounds(760,470,150,50);
        cb1.setBounds(350,285,150,30);
        cb2.setBounds(850,285,150,30);
        sp2.setBounds(100,600,1200,300);
        
        
        
        Font fo1=new Font("Sans Serif",Font.BOLD,40);
        l1.setFont(fo1);
        l1.setForeground(Color.ORANGE);
        Font fo2=new Font("Dialog",Font.BOLD,20);
        Font fo3=new Font("Dialog",Font.BOLD,12);
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
        b3.setFont(fo2);
        b4.setFont(fo2);
        cb1.setFont(fo2);
        cb2.setFont(fo2);
        jt.setFont(fo3);
        
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
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(l8);
        f1.add(l9);
        //f1.add(l10);
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(t4);
        f1.add(t5);
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(cb1);
        f1.add(cb2);
        f1.add(t6);
        f1.add(sp2);
        f1.setSize(1500,1000);
        f1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==b4)
        {
            f1.dispose();
        }
        
        if(e.getSource()==b1)
        {
            String s1=t1.getText();
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
                ps=c.prepareStatement("select * from FLIGHTTABLE where flight_id=?");
                ps.setString(1,s1);
                rs=ps.executeQuery();
                
                //SimpleDateFormat d1=new SimpleDateFormat("dd-MM-yyyy");
                //jj=d1.format(dt.getDate());
                
                while(rs.next())
                {
                    idd=rs.getString(1);
                    str2=rs.getString(2);
                    str3=rs.getString(3);
                    str4=rs.getString(4);
                    str5=rs.getString(5);
                    str6=rs.getString(6);
                    str7=rs.getString(7);
                    str8=rs.getString(8);
                    
                    if(idd.equals(s1))
                    {
                        counter++;
                    }
                }
                if(counter>0)
                {
                    t2.setText(str2);
                    cb1.setSelectedItem(str3);
                    cb2.setSelectedItem(str4);
                    t3.setText(str5);
                    t4.setText(str6);
                    t5.setText(str7);
                    t6.setText(str8);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"no such Flight ID exists !");
                }   
                counter=0;
                
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
        
        if(e.getSource()==b2)
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
                
        
                //SimpleDateFormat d1=new SimpleDateFormat("dd-MM-yyyy");
                //jj=d1.format(dt.getDate());
                //System.out.println(jj);
                String s1=t1.getText();
                String s2=t2.getText();
                String s3=String.valueOf(cb1.getSelectedItem());
                String s4=String.valueOf(cb2.getSelectedItem());
                String s5=t3.getText();
                String s6=t4.getText();
                String s7=t5.getText();
                String s8=t6.getText();
                
                ps=c.prepareStatement("update FLIGHTTABLE set flight_name=?,flight_source=?,flight_destination=?,departure_time=?,arrival_time=?,flight_charges=?,dateofdeparture=? where flight_id=?");
                ps.setString(1,s2);
                ps.setString(2,s3);
                ps.setString(3,s4);
                ps.setString(4,s5);
                ps.setString(5,s6);
                ps.setString(6,s7);
                ps.setString(7,s8);
                ps.setString(8,s1);
                
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"flight details updated successfully...");
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
        
        if(e.getSource()==b3)
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
                ps=c.prepareStatement("delete from FLIGHTTABLE where flight_id=?");
                ps.setString(1,s1);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"flight record deleted successfully...");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"no such flight Id exists !");
                }
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }        
    }
        
}
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    

