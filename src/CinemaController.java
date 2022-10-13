import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CinemaController {
    CinemaView view = new CinemaView();
    CinemaModel model = new CinemaModel();

    CinemaController(){
        Movie m1 = new Movie("iron man1", "action", 200);
        Movie m2 = new Movie("iron man2", "action", 200);
        Movie m3 = new Movie("iron man3", "action", 200);

        model.setMovie(m1);
        model.setMovie(m2);
        model.setMovie(m3);

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
                view.showMovies(getMoviesName(model.getCinemaMovies()));
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

    private String[] getMoviesName(ArrayList<Movie> myMovies) {
        int size = myMovies.size();
        String[] names = new String[size];

        for (int i = 0; i < size; i++)
            names[i] = myMovies.get(i).getName()  + ' ' + '(' + myMovies.get(i).getCategory() + ')';

        return names;
    }
}
