package design.tictactoe;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getGameWinningStrategy(GameWinningStrategyType gameWinningStrategyType, int dimension){
        return new OrderOneGameWinningStrategy(dimension);
    }
}
