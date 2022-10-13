import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
                view.hideTicketPanel();
                view.hideCustomerPanel();
                view.setAdminMoviesListData(getMoviesName(model.getCinemaMovies()));
            }
        });
        view.setCustomerLoginButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.hideLoginPanel();
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
                view.setAdminMoviesListData(getMoviesName(model.getCinemaMovies()));
            }
        });

        view.setAdminDeleteButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeMovie(view.getAdminMoviesListSelection());
                view.setAdminMoviesListData(getMoviesName(model.getCinemaMovies()));
            }
        });

        view.setAdminMoviesListListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Movie selectedMovie ;
                if(view.getAdminMoviesListSelection() != -1) {
                    selectedMovie = model.getMovie(view.getAdminMoviesListSelection());
                    view.setMovieDetails(selectedMovie.getName(), selectedMovie.getCategory(), selectedMovie.getAvailableTickets());
                }
            }
        });

        view.setAdminToLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showLoginPanel();
                view.hideAdminPanel();
                view.hideCustomerPanel();
                view.hideTicketPanel();
            }
        });
        //-------------------------------------------------


        //--------------Customer Buttons--------------------
        view.setCustomerBuyButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getSelectedMovie() != -1) {
                    model.getMovie(view.getSelectedMovie()).ticketIsToken();
                    view.hideCustomerPanel();
                    view.showTicketPanel();
                }
            }
        });

        view.back(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.hideTicketPanel();
                view.showLoginPanel();
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
