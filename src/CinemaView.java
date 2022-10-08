import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CinemaView extends JFrame {

    //------------Components-------------------------------------

    //-------------Login panel-------------------------------------
    JPanel loginPanel = new JPanel();
    JButton adminLoginButton = new JButton("Admin");
    JButton customerLoginButton = new JButton("Customer");
    //-------------------------------------------------------------

    //-------------------Admin panel-------------------------------
    JPanel adminPanel = new JPanel();
    JList adminMoviesList = new JList();
    JLabel adminMovieLabel = new JLabel();
    JButton adminDeleteButton = new JButton();
    JButton adminAddButton = new JButton();
    //-------------------------------------------------------------


    JPanel customerPanel = new JPanel();


    CinemaView(){
        //---------------JFrame config-------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500 ,500);
        this.setLayout(null);
        this.add(loginPanel);
        this.add(adminPanel);
        this.add(customerPanel);
        this.setResizable(false);
        //-----------------------------------------------


        //-----------------Login panel----------------------
        loginPanel.setBounds(0 , 0 , 500 , 500);
        loginPanel.setBackground(new Color(0x1234456));
        adminLoginButton.setBounds(150 ,200 , 200 , 40);
        customerLoginButton.setBounds(150 ,250 , 200 , 40);
        loginPanel.add(adminLoginButton);
        loginPanel.add(customerLoginButton);
        loginPanel.setLayout(null);
        this.setVisible(true);
        //---------------------------------------------------

        //---------------Admin panel------------------------
        adminPanel.setBounds(0 , 0 , 500 , 500);
        adminPanel.setBackground(new Color(0x1234456));
        adminMoviesList.setBounds(10 , 10 , 200 , 400);
        //--------------------------------------------------
    }

    public void showAdminPanel(){
        loginPanel.setVisible(false);
        customerPanel.setVisible(false);
        adminPanel.setVisible(true);
    }

    public void setAdminLoginButton (ActionListener ac){
        adminLoginButton.addActionListener(ac);
    }
    public void setCustomerLoginButton (ActionListener ac){
        customerLoginButton.addActionListener(ac);
    }



}
