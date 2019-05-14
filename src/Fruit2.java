import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fruit2 extends Fruit {

    @Override
    public void move(double time) {
        // TODO Auto-generated method stub

    }

    @Override
    public Image[] getImages() {
        Image[] view= new Image[2];
        view[0] = new Image("file:orange.png");
        view[1] = new Image("file:orangeCUT.png");

        return view;
    }

}
