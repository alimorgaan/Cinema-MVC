import java.util.ArrayList;

public class CinemaModel {
    private ArrayList<Movie> cinemaMovies = new ArrayList<Movie>();

    public ArrayList<Movie> getCinemaMovies() {
        return cinemaMovies;
    }

    public Movie getMovie(int i) {
        return cinemaMovies.get(i);
    }

    public void removeMovie(int i) {
        cinemaMovies.remove(i);
    }
}
