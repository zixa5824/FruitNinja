import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fruit1 extends Fruit {



    @Override
    public void move(double time) {
        // TODO Auto-generated method stub

    }

    @Override
    public Image[] getImages() {
        Image[] view= new Image[3];
        view[0] = new Image("file:apple.png");
        view[1] = new Image("file:appleCUT.png");
        return view;
    }



}
