package design.tictactoe;

import design.tictactoe.players.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players) {
        try{
            Game game=Game.getBuilder().setDimension(dimension)
                                .setPlayers(players)
                                .build();
            return game;
        }
        catch (Exception e){
            // usually returns error code
            return null;
        }
    }
    public void undo(Game game){
        game.undo();
    }
    public void displayBoard(Game game){
        game.displayBoard();
    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }
}
