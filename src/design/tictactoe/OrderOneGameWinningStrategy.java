package design.tictactoe;

import design.tictactoe.board.Board;
import design.tictactoe.board.cells.Cell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy{
    private List<HashMap<Character, Integer>> rowSymbolCounts=new ArrayList<>();
    private List<HashMap<Character, Integer>> columnSymbolCounts=new ArrayList<>();
    private HashMap<Character, Integer> topLeftDiagonalSymbolCounts=new HashMap<>();
    private HashMap<Character, Integer> topRightDiagonalSymbolCounts=new HashMap<>();
    private int dimension;

    public OrderOneGameWinningStrategy(int dimension) {
        this.dimension=dimension;
        for(int i=0;i<dimension;i++){
            rowSymbolCounts.add(new HashMap<>());
            columnSymbolCounts.add(new HashMap<>());
        }
    }

    private static boolean isCellOnTopLeftDiagonal(int row, int col) {
        return row == col;
    }
    private boolean isCellOnTopRightDiagonal(int row, int col, int dimension){
        return row+col==dimension-1;
    }
    @Override
    public boolean checkWinner(Board board, Cell moveCell) {
        char playerSymbol=moveCell.getPlayer().getaChar();
        int row=moveCell.getRow();
        int col=moveCell.getColumn();

        HashMap<Character, Integer> rowMap = rowSymbolCounts.get(row);
        if(rowMap.containsKey(playerSymbol)) {
            rowMap.put(playerSymbol, rowMap.get(playerSymbol) + 1);
        }
        else{
            rowMap.put(playerSymbol,1);
        }

        HashMap<Character, Integer> colMap = columnSymbolCounts.get(col);
        if(colMap.containsKey(playerSymbol)) {
            colMap.put(playerSymbol, colMap.get(playerSymbol) + 1);
        }
        else{
            colMap.put(playerSymbol,1);
        }

        if(isCellOnTopLeftDiagonal(row, col)){
            if (topLeftDiagonalSymbolCounts.containsKey(playerSymbol)) {
                topLeftDiagonalSymbolCounts.put(playerSymbol, topLeftDiagonalSymbolCounts.get(playerSymbol) + 1);
            } else {
                topLeftDiagonalSymbolCounts.put(playerSymbol, 1);
            }
        }
        if(isCellOnTopRightDiagonal(row, col, dimension-1)) {
            if (topRightDiagonalSymbolCounts.containsKey(playerSymbol)) {
                topRightDiagonalSymbolCounts.put(playerSymbol, topRightDiagonalSymbolCounts.get(playerSymbol) + 1);
            } else {
                topRightDiagonalSymbolCounts.put(playerSymbol, 1);
            }
        }

        if((rowSymbolCounts.get(row).get(playerSymbol)==dimension || columnSymbolCounts.get(col).get(playerSymbol)==dimension)){
            return true;
        }
        if(isCellOnTopLeftDiagonal(row,col) && topLeftDiagonalSymbolCounts.get(playerSymbol)==dimension){
            return true;
        }
        if(isCellOnTopRightDiagonal(row,col,dimension-1) && topRightDiagonalSymbolCounts.get(playerSymbol)==dimension){
            return true;
        }
        return false;
    }

    public void undoMove(int row, int col, char symbol){
        HashMap<Character, Integer> rowMap = rowSymbolCounts.get(row);
        rowMap.put(symbol,rowMap.get(symbol)-1);
        if(rowMap.get(symbol)==0) rowMap.remove(symbol);

        HashMap<Character, Integer> colMap = columnSymbolCounts.get(col);
        colMap.put(symbol,colMap.get(symbol)-1);
        if(colMap.get(symbol)==0) colMap.remove(symbol);

        if(isCellOnTopLeftDiagonal(row,col)){
            topLeftDiagonalSymbolCounts.put(symbol,topLeftDiagonalSymbolCounts.get(symbol)-1);
            if(topLeftDiagonalSymbolCounts.get(symbol)==0) topLeftDiagonalSymbolCounts.remove(symbol);
        }
        if(isCellOnTopRightDiagonal(row,col,dimension-1)){
            topRightDiagonalSymbolCounts.put(symbol,topRightDiagonalSymbolCounts.get(symbol)-1);
            if(topRightDiagonalSymbolCounts.get(symbol)==0) topRightDiagonalSymbolCounts.remove(symbol);
        }
    }

}
