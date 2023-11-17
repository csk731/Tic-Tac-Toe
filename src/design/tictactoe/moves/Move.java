package design.tictactoe.moves;

import design.tictactoe.board.cells.Cell;
import design.tictactoe.players.Player;

public class Move {
    private Cell cell;
    private Player player;
    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }
}
