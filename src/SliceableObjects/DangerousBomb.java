package SliceableObjects;

import javafx.scene.image.Image;

public class DangerousBomb extends Bomb {


    @Override
    public Image[] getMyImage() {
        Image[] view= new Image[3];
        view[0] = new Image("file:db.png");
        // view[1] = new Image("file:dbCUT.png");
        //------

        return view;
    }

}
