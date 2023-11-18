package design.tictactoe.players.botplayers;

import design.tictactoe.board.Board;
import design.tictactoe.moves.Move;
import design.tictactoe.players.Player;
import design.tictactoe.players.PlayerType;
import design.tictactoe.players.botplayers.botplayingstategies.BotPlayingStrategy;
import design.tictactoe.players.botplayers.botplayingstategies.BotPlayingStrategyFactory;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(char aChar, String name, BotDifficultyLevel botDifficultyLevel) {
        super(aChar,name,PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getStrategyForDifficultyLevel(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this,board);
    }
}
