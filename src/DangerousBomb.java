import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DangerousBomb extends Bomb {

    @Override
    public void move(double time) {
        // TODO Auto-generated method stub

    }

    @Override
    public Image[] getImages() {
        Image[] view= new Image[3];
        view[0] = new Image("file:db.png");
        // view[1] = new Image("file:dbCUT.png");
        //------

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
