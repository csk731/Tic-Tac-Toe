package design.tictactoe.board.cells;

import design.tictactoe.players.Player;
import design.tictactoe.symbols.Symbol;

public class Cell {
    private Player player;
    private CellStatus cellStatus;
    private int row;
    private int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellStatus=CellStatus.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
