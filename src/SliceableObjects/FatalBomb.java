package SliceableObjects;

import SliceableObjects.Bomb;
import javafx.scene.image.Image;

public class FatalBomb extends Bomb {

    public Image[] getImages() {
        Image[] view= new Image[3];
        view[0] = new Image("file:fb.png");
        view[1] = new Image("file:fbCUT.png");
        return view;
    }


}
