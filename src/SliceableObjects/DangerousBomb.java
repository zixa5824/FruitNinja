package SliceableObjects;

import SliceableObjects.Bomb;
import javafx.scene.image.Image;

public class DangerousBomb extends Bomb {


    @Override
    public Image[] getImages() {
        Image[] view= new Image[3];
        view[0] = new Image("file:db.png");
        // view[1] = new Image("file:dbCUT.png");
        //------

        return view;
    }

}
