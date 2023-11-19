package design.tictactoe.moves;

import design.tictactoe.board.cells.Cell;

public class Move {
    private Cell cell;
    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Move(Cell cell) {
        this.cell = cell;
    }
}
