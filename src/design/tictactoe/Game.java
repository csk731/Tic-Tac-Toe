package design.tictactoe;

import design.tictactoe.board.Board;
import design.tictactoe.moves.Move;
import design.tictactoe.players.Player;
import java.util.List;
public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameStatus gameStatus;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void undo(){

    }
}
