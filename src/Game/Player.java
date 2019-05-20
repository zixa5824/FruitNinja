package Game;

public class Player {

    private String playerName, difficulty;
    private int playerScore;
    public Player(String playerName, int playerScore, String difficulty)
    {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.difficulty = difficulty;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Player() {
    }
}