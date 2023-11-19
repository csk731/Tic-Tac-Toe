package design.tictactoe;

import design.tictactoe.board.Board;
import design.tictactoe.board.cells.Cell;

public interface GameWinningStrategy {
    public boolean checkWinner(Board board, Cell moveCell);

    void undoMove(int row, int col, char c);
}
