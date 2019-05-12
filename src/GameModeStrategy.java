import java.util.List;

public interface GameModeStrategy {

    public int getLives () ;

    public int timerType () ;

    public List<GameObject> NewBatch(int time);

}
