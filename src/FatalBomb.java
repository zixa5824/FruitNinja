import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FatalBomb extends Bomb {

    @Override
    public void move(double time) {
        // TODO Auto-generated method stub

    }

    public Image[] getImages() {
        Image[] view= new Image[3];
        view[0] = new Image("file:fb.png");
        view[1] = new Image("file:fbCUT.png");
        return view;
    }

    @Override
    public double getXVelocity() {
        return 0;
    }

    @Override
    public double getYVelocity() {
        return 0;
    }

    @Override
    public int getXLocation() {
        return 0;
    }

    @Override
    public int getYLocation() {
        return 0;
    }
}
