import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CinemaController {
    CinemaView view = new CinemaView();
    CinemaModel model = new CinemaModel();

    CinemaController(){
        view.setAdminLoginButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showAdminPanel();
                view.hideLoginPanel();
            }
        });
    }
}
