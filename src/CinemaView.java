import  javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionListener;
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
    JList<String> adminMoviesList = new JList<String>();
    JLabel adminMovieLabel = new JLabel();
    JTextArea adminTextArea = new JTextArea();
    JButton adminDeleteButton = new JButton();
    JButton adminAddButton = new JButton();
    JTextField movieNameInput = new JTextField(20);
    JTextField movieCatInput = new JTextField(20);
    JTextField movieSeatsInput = new JTextField(20);
    JButton adminToLogin = new JButton("Back to Login Page");
    //-------------------------------------------------------------



    //------------------Customer panel-------------------------------------
    JPanel customerPanel = new JPanel();
    JList<String> customerMovieList = new JList<String>();
    JLabel customerMovieLabel = new JLabel();
    JButton customerBuyTicket = new JButton("Buy Ticket");
    //--------------------------------------------------------------------

    //--------------Ticket panel-----------------------
    JPanel ticketPanel = new JPanel();
    JLabel thankMsg = new JLabel();
    JLabel ticketCode = new JLabel();
    JButton backButton = new JButton("Back");
    //---------------------------------------------------

    CinemaView(){
        //---------------JFrame config-------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500 ,500);
        this.setLayout(null);
        this.add(loginPanel);
        this.add(adminPanel);
        this.add(customerPanel);
        this.add(ticketPanel);
        this.setResizable(false);
        this.setVisible(true);
        //-----------------------------------------------

        //-----------------Login panel----------------------
        loginPanel.setBounds(0 , 0 , 500 , 500);
        loginPanel.setBackground(new Color(0x1234456));
        adminLoginButton.setBounds(150 ,185 , 200 , 40);
        customerLoginButton.setBounds(150 ,235 , 200 , 40);
        customerLoginButton.setFocusable(false);
        adminLoginButton.setFocusable(false);
        loginPanel.add(adminLoginButton);
        loginPanel.add(customerLoginButton);
        loginPanel.setLayout(null);
        //---------------------------------------------------

        //---------------Admin panel-----------------------
        adminPanel.setVisible(false);
        adminPanel.setBounds(0 , 0 , 500 , 500);
        adminPanel.setLayout(null);
        adminPanel.setBackground(new Color(0x1234456));
        adminMoviesList.setBounds(20 , 10 , 200 , 430);
        adminMoviesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        adminMoviesList.setLayoutOrientation(JList.VERTICAL_WRAP);
        adminMoviesList.setVisibleRowCount(-1);
        adminDeleteButton.setBounds(240 , 360 , 220 , 30);
        adminDeleteButton.setText("Delete Selected Movie");
        adminAddButton.setBounds(240 , 320 , 220 , 30);
        adminToLogin.setBounds(240 , 360 , 220 , 80);
        adminAddButton.setText("Add New Movie");
        movieNameInput.setBounds(240 , 230 , 220 , 20);
        movieCatInput.setBounds(240 , 260 , 220 , 20);
        movieSeatsInput.setBounds(240 , 290 , 220 , 20);
        movieNameInput.setText("new movie name");
        movieCatInput.setText("new movie category");
        movieSeatsInput.setText("new movie available seats");
        adminTextArea.setBackground(new Color(0xffffff));
        adminTextArea.setBounds(240 , 10 , 220 , 200);
        adminTextArea.setFont(adminTextArea.getFont().deriveFont(14f));
        adminTextArea.setFocusable(false);
        adminTextArea.setMargin(new Insets(10,10,10,10));
        adminPanel.add(adminToLogin);
        adminPanel.add(adminTextArea);
        adminPanel.add(movieNameInput);
        adminPanel.add(movieCatInput);
        adminPanel.add(movieSeatsInput);
        adminPanel.add(adminMoviesList);
        adminPanel.add(adminAddButton);
        adminPanel.add(adminDeleteButton);
        //--------------------------------------------------

        //--------------Customer panel-----------------------
        customerPanel.setVisible(false);
        customerPanel.setBounds(0 , 0 , 500 , 500);
        customerPanel.setLayout(null);
        customerPanel.setBackground(new Color(0x1234456));
        customerMovieLabel.setText("Select Your Movie");
        customerMovieLabel.setForeground(Color.white);
        customerMovieLabel.setBounds(100, 20, 200, 10);
        customerMovieList.setBounds(100,40, 300, 300);
        customerMovieList.setFixedCellHeight(20);
        customerMovieList.setFixedCellWidth(400);
        customerBuyTicket.setBounds(200, 380, 100, 30);
        customerBuyTicket.setFocusable(false);
        customerPanel.add(customerMovieLabel);
        customerPanel.add(customerMovieList);
        customerPanel.add(customerBuyTicket);
        //---------------------------------------------------

        //--------------Ticket panel-----------------------
        ticketPanel.setVisible(false);
        ticketPanel.setBounds(0, 0, 500, 500);
        ticketPanel.setLayout(null);
        ticketPanel.setBackground(new Color(0x1234456));
        thankMsg.setText("Enjoy Your Movie !");
        thankMsg.setForeground(Color.white);
        thankMsg.setFont(new Font("Verdana", Font.BOLD, 20));
        thankMsg.setBounds(140, 190, 300, 20);
        ticketCode.setText("Your Code is : XTC675");
        ticketCode.setForeground(Color.white);
        ticketCode.setFont(new Font("Verdana", Font.BOLD, 20));
        ticketCode.setBounds(120, 150, 300, 20);
        backButton.setBounds(190, 240, 100, 30);
        backButton.setFocusable(false);
        ticketPanel.add(thankMsg);
        ticketPanel.add(backButton);
        ticketPanel.add(ticketCode);
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
    public void setAdminMoviesListListener(ListSelectionListener l){
        adminMoviesList.addListSelectionListener(l);
    }

    public int getAdminMoviesListSelection(){
        return adminMoviesList.getSelectedIndex();
    }

    public void setAdminDeleteButton (ActionListener ac){
        adminDeleteButton.addActionListener(ac);
    }

    public void setAdminAddButton (ActionListener ac){
        adminAddButton.addActionListener(ac);
    }

    public String getNewMovieName (){
        return movieNameInput.getText();
    }

    public String getNewMovieCat (){
        return movieCatInput.getText();
    }

    public int getNewMovieSeats (){
        try {
            return Integer.parseInt(movieSeatsInput.getText());
        }catch (RuntimeException e){
            return 0;
        }

    }

    public void setMovieDetails(String name , String cat , int seats){
        adminTextArea.setText("Name : " + name + "\n" + "Category : " + cat + "\n" + "Available seats : " + seats + "\n");
    }

    public void setAdminToLogin(ActionListener ac){
        adminToLogin.addActionListener(ac);
    }
    //---------------------------------------------------


    //--------------Customer panel-----------------------
    public void showCustomerPanel() {
        customerPanel.setVisible(true);
    }

    public void hideCustomerPanel() {
        customerPanel.setVisible(false);
    }

    public void setCustomerBuyButton (ActionListener ac){
        customerBuyTicket.addActionListener(ac);
    }

    public void showMovies(String[] movies) {
        customerMovieList.setListData(movies);
    }

    //---------------------------------------------------

    //--------------Ticket panel-----------------------
    public void showTicketPanel() {
        ticketPanel.setVisible(true);
    }

    public void hideTicketPanel() {
        ticketPanel.setVisible(false);
    }

    public void back(ActionListener ac){backButton.addActionListener(ac);};

    public int getSelectedMovie() {return customerMovieList.getSelectedIndex();}
    //---------------------------------------------------





}
