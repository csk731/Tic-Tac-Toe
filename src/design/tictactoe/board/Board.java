package design.tictactoe.board;

import design.tictactoe.board.cells.Cell;

public class Board {
    private Cell[][] board;

    public Board(int dimension) {
        this.board = new Cell[dimension][dimension];
        for(int i=0;i<dimension;++i){
            for(int j=0;j<dimension;++j){
                board[i][j]=new Cell(i,j);
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }
    public void setBoard(Cell[][] board) {
        this.board = board;
    }

}
