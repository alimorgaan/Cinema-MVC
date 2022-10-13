import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CinemaController {
    CinemaView view = new CinemaView();
    CinemaModel model = new CinemaModel();

    CinemaController(){

        //--------------Login Buttons--------------------
        view.setAdminLoginButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showAdminPanel();
                view.hideLoginPanel();
            }
        });
        view.setCustomerLoginButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.hideLoginPanel();
                view.hideAdminPanel();
                view.showCustomerPanel();
            }
        });
        //-------------------------------------------------


        //----------------Admin Buttons-------------------

        view.setAdminAddButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie newMovie = new Movie(view.getNewMovieName(), view.getNewMovieCat(), view.getNewMovieSeats());
                model.setMovie(newMovie);
            }
        });

        //-------------------------------------------------


        //--------------Customer Buttons--------------------
        view.setCustomerBuyButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.hideLoginPanel();
                view.hideAdminPanel();
                view.hideCustomerPanel();
                view.showTicketPanel();
            }
        });

        //-------------------------------------------------

    }
}
