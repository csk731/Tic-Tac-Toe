package design.tictactoe.board;

import design.tictactoe.board.cells.Cell;

public class Board {
    private Cell[][] board;

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }
}
