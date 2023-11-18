package design.tictactoe.players.botplayers.botplayingstategies;

import design.tictactoe.players.botplayers.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
        return new RandomBotPlayingStrategy();
    }
}
