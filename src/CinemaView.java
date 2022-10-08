import  javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class CinemaView extends JFrame {

    //------------Components-------------------------------------

    //------------------Login panel-------------------------------------
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

    //------------------Customer panel-------------------------------------
    JPanel customerPanel = new JPanel();
    //--------------------------------------------------------------------

    CinemaView(){
        //---------------JFrame config-------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500 ,500);
        this.setLayout(null);
        this.add(loginPanel);
        this.add(adminPanel);
        this.add(customerPanel);
        this.setResizable(false);
        this.setVisible(true);
        //-----------------------------------------------

        //-----------------Login panel----------------------
        loginPanel.setBounds(0 , 0 , 500 , 500);
        loginPanel.setBackground(new Color(0x1234456));
        adminLoginButton.setBounds(150 ,200 , 200 , 40);
        customerLoginButton.setBounds(150 ,250 , 200 , 40);
        loginPanel.add(adminLoginButton);
        loginPanel.add(customerLoginButton);
        loginPanel.setLayout(null);
        //---------------------------------------------------

        //---------------Admin panel-----------------------
        adminPanel.setVisible(false);
        adminPanel.setBounds(0 , 0 , 500 , 500);
        adminPanel.setLayout(null);
        adminPanel.setBackground(new Color(0x1234456));
        adminMoviesList.setBounds(10 , 10 , 200 , 430);
        adminMoviesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        adminMoviesList.setLayoutOrientation(JList.VERTICAL_WRAP);
        adminMoviesList.setVisibleRowCount(-1);
        adminPanel.add(adminMoviesList);

        //--------------------------------------------------

        //--------------Customer panel-----------------------

        //---------------------------------------------------

    }


    //--------------Login panel-----------------------
    public void setAdminLoginButton (ActionListener ac){
        adminLoginButton.addActionListener(ac);
    }
    public void setCustomerLoginButton (ActionListener ac){
        customerLoginButton.addActionListener(ac);
    }

    public void showLoginPanel() {
        loginPanel.setVisible(true);
    }

    public void hideLoginPanel() {
        loginPanel.setVisible(false);
    }
    //---------------------------------------------------


    //--------------Admin panel-----------------------
    public void showAdminPanel() {
        adminPanel.setVisible(true);
    }

    public void hideAdminPanel() {
        adminPanel.setVisible(false);
    }

    public void setAdminMoviesListData(String[] s){
        adminMoviesList.setListData(s);
    }

    public void setAdminMoviesListListener(AncestorListener ac){
        adminMoviesList.addAncestorListener(ac);
    }

    public int getAdminMoviesListSelection(){
        return adminMoviesList.getSelectedIndex();
    }
    //---------------------------------------------------


    //--------------Customer panel-----------------------

    //---------------------------------------------------







}
