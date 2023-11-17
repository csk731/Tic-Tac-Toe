package design.tictactoe.players.botplayers;

import design.tictactoe.players.Player;
import design.tictactoe.players.PlayerType;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(char aChar, String name, BotDifficultyLevel botDifficultyLevel) {
        super(aChar,name,PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
