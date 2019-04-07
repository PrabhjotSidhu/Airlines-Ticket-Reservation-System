package airlines;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PRABHJOT SIDHU
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Airlines2 extends JFrame implements ActionListener
{
    
    static JFrame f2,f3;
    static JLabel l1;
    static JMenuBar mb;
    static JMenu m1,m2,m3;
    static JMenuItem i1,i2,i3,i4,i5,i6;
    static JMenuItem i7,i8,i9;
    static JMenuItem i10,i11;
    
    Airlines2()
    {
        
        
        f2=new JFrame();
        //f2.setResizable(false);
        l1=new JLabel(new ImageIcon("images/airplane3.jpg"));
        f2.setLayout(null);
        l1.setBounds(0,0,1920,1200);
        
        Border b=BorderFactory.createLineBorder(Color.black);
        
        mb=new JMenuBar();
        f2.setJMenuBar(mb);
        m1=new JMenu("Airline_System");
        m2=new JMenu("Ticket");
        m3=new JMenu("List");
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        i1=new JMenuItem("Add_Customer");
        i2=new JMenuItem("View_Customer");
        i3=new JMenuItem("Update_Customer");
        i4=new JMenuItem("Flight_Information");
        i5=new JMenuItem("Add_Flight");
        i6=new JMenuItem("Update_Flight");
        
        i7=new JMenuItem("Ticket_Reservation");
        i8=new JMenuItem("Ticket_Enquiry");
        i9=new JMenuItem("Cancel_Seat");
        
        i10=new JMenuItem("Customer_List");
        i11=new JMenuItem("Flight_List");
        
        
        m1.add(i1);
        m1.add(i2);
        m1.add(i3);
        m1.add(i4);
        m1.add(i5);
        m1.add(i6);
        m2.add(i7);
        m2.add(i8);
        m2.add(i9);
        m3.add(i10);
        m3.add(i11);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);
        i7.addActionListener(this);
        i8.addActionListener(this);
        i9.addActionListener(this);
        i10.addActionListener(this);
        i11.addActionListener(this);
        l1.setBorder(b);
        f2.add(l1);
        f2.setSize(1950,1300);
        f2.setVisible(true);
    
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource()==i1)
        {
            add_customer ob=new add_customer();
        }
        if(e.getSource()==i2)
        {
            view_customer ob2=new view_customer();
        }
        if(e.getSource()==i3)
        {
            update_customer ob3=new update_customer();
        }
        if(e.getSource()==i4)
        {
            Flight_Information ob4=new Flight_Information();
        }
        if(e.getSource()==i5)
        {
            add_flight ob5=new add_flight();
        }
        if(e.getSource()==i6)
        {
            update_flight ob6=new update_flight();
        }
        if(e.getSource()==i7)
        {
            ticket_reservation ob7=new ticket_reservation();
        }
        if(e.getSource()==i8)
        {
            ticket_enquiry ob8=new ticket_enquiry();
        }
        if(e.getSource()==i9)
        {
            cancel_ticket ob9=new cancel_ticket();
        }
        if(e.getSource()==i10)
        {
            customer_list ob10=new customer_list();
        }
        if(e.getSource()==i11)
        {
            flight_list ob11=new flight_list();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
