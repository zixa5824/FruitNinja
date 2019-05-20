import Game.GameController;

public class FileCommand implements Command{
	private GameController c = GameController.getInstance();

	
	@Override
	public void execute() {
		c.saveGame();
		}

	@Override
	public void unexecute() {
		c.loadGame();
		}
}
