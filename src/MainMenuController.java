import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    public ImageView backGroundImage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("Initializing!");
    }
}
