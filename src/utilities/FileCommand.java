package utilities;

import Game.GameController;
import utilities.Command;

public class FileCommand implements Command {
	private GameController c = GameController.getInstance();

	
	@Override
	public void execute() {
		c.save();
		}

	@Override
	public void unexecute() {
		c.load();
		}
}
