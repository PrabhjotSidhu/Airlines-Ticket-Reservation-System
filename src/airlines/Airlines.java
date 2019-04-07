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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Airlines extends JFrame implements ActionListener
{
    
    static JFrame f1;
    static JLabel l1,l2,l3,l4;
    static JTextField t1;
    static JPasswordField t2;
    static JButton b1;
    
    
    public static void main(String[] args)
    {
        
        Airlines ob=new Airlines();
        f1=new JFrame();
        //f1.setResizable(false);
        l1=new JLabel("WELCOME TO JET AIRLINES");
        l2=new JLabel("LOG IN TO CONTINUE");
        l3=new JLabel("Log In ID");
        l4=new JLabel("Password");
        t1=new JTextField();
        t2=new JPasswordField();
        b1=new JButton("Log In");
        
        
        f1.setLayout(null);
        l1.setBounds(180,100,700,100);
        l2.setBounds(300,200,700,100);
        l3.setBounds(300,330,200,100);
        l4.setBounds(300,380,200,100);
        t1.setBounds(400,350,200,50);
        t2.setBounds(400,400,200,50);
        b1.setBounds(350,500,100,50);
        
        
        b1.addActionListener(ob);
        Font fo1=new Font("Courier New",Font.BOLD,50);
        l1.setFont(fo1);
        l1.setForeground(Color.BLUE);
        Font fo2=new Font("Monaco",Font.BOLD,30);
        
        l2.setFont(fo2);
        l2.setForeground(Color.cyan);
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(t1);
        f1.add(l4);
        f1.add(t2);
        f1.add(b1);
        f1.setSize(1000,1000);
        f1.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource()==b1)
        {
            String s1=t1.getText();
            String s2=t2.getText();
            if(s1.equals("admin")&&s2.equals("7777"))
            {
                Airlines2 ob2=new Airlines2();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"incorrect username/password...");
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
