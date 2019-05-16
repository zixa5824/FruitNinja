package SliceableObjects;

import javafx.scene.image.Image;

public class FatalBomb extends Bomb {

    public Image[] getMyImage() {
        Image[] view= new Image[3];
        view[0] = new Image("file:fb.png");
        view[1] = new Image("file:fbCUT.png");
        return view;
    }

	@Override
	public int offscreen() {
		return 0;
	}


}
