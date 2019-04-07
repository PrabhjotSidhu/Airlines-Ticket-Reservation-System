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
import javax.swing.table.DefaultTableModel;

public class update_customer extends JFrame implements ActionListener,ItemListener
{
    
    String jj,h1,path,idd,str2,str3,str4,str5,str6,str7;
    int counter=0,counter2=0;
    static JFrame f1;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,img;
    static JTextField t1,t2,t3,t4;
    static JButton b1,b2,b3,b4,b5,b6;
    static JRadioButton r1,r2;
    static ButtonGroup bg;
    static JTextArea a1;
    //static JScrollPane sp;
    static JDateChooser dt;
    static JScrollPane sp,sp2;
     static DefaultTableModel model;
    
    update_customer()
    {
        
        javax.swing.border.Border b=BorderFactory.createLineBorder(Color.black,3);
        
        f1=new JFrame();
        l1=new JLabel("UPDATE CUSTOMER DETAILS");
        l2=new JLabel("Customer ID");
        l3=new JLabel("Customer Name");
        l4=new JLabel("Father Name");
        l5=new JLabel("DOB");
        //l6=new JLabel(new ImageIcon("images/airplane3.jpg"));
        l7=new JLabel("Gender");
        l8=new JLabel("Address");
        img=new JLabel(" ");
        
        model=new DefaultTableModel(new String[]{"CUSTOMER ID","CUSTOMER NAME","FATHER NAME","DOB","GENDER","ADDRESS"},0);
        JTable jt=new JTable();
        jt.getTableHeader().setFont(new Font("Serif",Font.BOLD,17));
        jt.setModel(model);
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        a1=new JTextArea();
        bg=new ButtonGroup();
        r1=new JRadioButton("male");
        r2=new JRadioButton("female");
        bg.add(r1);
        bg.add(r2);
        a1=new JTextArea();
        b1=new JButton("UPDATE");
        b2=new JButton("BACK");
        b3=new JButton("DELETE");
        b4=new JButton("SEARCH BY ID");
        b5=new JButton("SEARCH BY NAME");
        b6=new JButton("CHANGE IMAGE");
        //dt=new JDateChooser();
        //dt.setDateFormatString("yyyy-MM-dd");
        sp=new JScrollPane(a1);
        sp2=new JScrollPane(jt);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
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
        t4.setBounds(300,340,150,30);
        sp.setBounds(300,500,200,100);
        sp2.setBounds(700,500,1200,300);
        r1.setBounds(250,380,100,100);
        r2.setBounds(350,380,200,100);
        b1.setBounds(100,650,150,50);
        b2.setBounds(500,650,150,50);
        b3.setBounds(300,650,150,50);
        b4.setBounds(1000,180,250,50);
        b5.setBounds(1300,180,250,50);
        b6.setBounds(670,380,250,50);
        
        Font fo1=new Font("Sans Serif",Font.BOLD,40);
        l1.setFont(fo1);
        l1.setForeground(Color.ORANGE);
        Font fo2=new Font("Dialog",Font.BOLD,20);
        Font fo3=new Font("Dialog",Font.BOLD,15);
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
        b4.setFont(fo2);
        b5.setFont(fo2);
        b6.setFont(fo2);
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
            String s="Select * from AIRTABLE";
            rs=st.executeQuery(s);
            while(rs.next())
            {
                String str1=rs.getString(1);
                String str2=rs.getString(2);
                String str3=rs.getString(3);
                String str4=rs.getString(4);
                String str5=rs.getString(5);
                String str6=rs.getString(6);
                model.addRow(new Object[]{str1,str2,str3,str4,str5,str6});
            }
        }
        catch(Exception ee)
        {
            System.out.println(ee.getMessage());
        }
        
        r1.addItemListener(this);
        r2.addItemListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b3.addActionListener(this);
        b6.addActionListener(this);
        
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
        f1.add(t4);
        f1.add(sp);
        f1.add(sp2);
        //f1.add(dt);
        f1.add(r1);
        f1.add(r2);
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(b5);
        f1.add(b6);
        f1.setSize(2400,2400);
        f1.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource()==b2)
        {
            f1.dispose();
            
        }
        if(e.getSource()==b4)
        {
            String s2;
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
                    str7=rs.getString(7);
                    if(idd.equals(s1))
                    {
                        counter++;
                    }
                }
                    if(counter>0)
                    {
                        t2.setText(str2);
                        t3.setText(str3);
                        t4.setText(str4);
                        if(str5.equals("male"))
                    {
                        r1.setSelected(true);
                    }
                    else
                    {
                        r2.setSelected(true);
                    }
                    a1.setText(str6);
                    
                    ImageIcon ii=new ImageIcon(str7);
                    img.setIcon(ii);
                    }
                /*    //t1.setText(rs.getString(1));
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
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
                    else
                    {
                        JOptionPane.showMessageDialog(this,"no such Customer ID exists!");
                    }
            counter=0;
            }
            
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
        
        if(e.getSource()==b5)
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
                        str7=rs.getString(7);
                                                                        
                        if(str2.equals(s1))
                        {
                            counter2++;
                        }
                    }
                
                if(counter2>0)
                {
                  //t1.setText(rs.getString(1));
                        t1.setText(idd);
                        t3.setText(str3);
                        t4.setText(str4);
                        if(str5.equals("male"))
                        {
                            r1.setSelected(true);
                        }
                        else
                        {
                            r2.setSelected(true);
                        }
                        a1.setText(str6);
                        ImageIcon ii=new ImageIcon(str7);
                        img.setIcon(ii);
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
                
        
                //SimpleDateFormat d1=new SimpleDateFormat("dd-MM-yyyy");
                //jj=d1.format(dt.getDate());
                //System.out.println(jj);
                String s1=t1.getText();
                String s2=t2.getText();
                String s3=t3.getText();
                String s4=t4.getText();
                String s6=a1.getText();
                System.out.println(jj);
                ps=c.prepareStatement("update AIRTABLE set customer_name=?,father_name=?,dob=?,gender=?,address=?,image=? where customer_id=?");
                ps.setString(1,s2);
                ps.setString(2,s3);
                ps.setString(3,s4);
                ps.setString(4,h1);
                ps.setString(5,s6);
                ps.setString(6,path);
                ps.setString(7,s1);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"customer details updated successfully...");
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
        if(e.getSource()==b6)
        {
            JFileChooser jf=new JFileChooser();
            int returnValue = jf.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
          File selectedFile = jf.getSelectedFile();
          System.out.println(selectedFile.getName());
            
         path = selectedFile.getAbsolutePath();
         ImageIcon MyImage = new ImageIcon(path);
        Image img1 = MyImage.getImage();
          //l1.setIcon((Icon) selectedFile);
           ImageIcon image = new ImageIcon(img1);
           img.setIcon(image);
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
                ps=c.prepareStatement("delete from AIRTABLE where Customer_Id=?");
                ps.setString(1,s1);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"customer record deleted successfully...");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"no such customer Id exists !");
                }
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie)
    {
        if(ie.getSource()==r1)
        {
            h1="male";
        }
        if(ie.getSource()==r2)
        {
            h1="female";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
