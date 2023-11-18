package design.tictactoe.players.botplayers.botplayingstategies;

import design.tictactoe.board.Board;
import design.tictactoe.board.cells.Cell;
import design.tictactoe.board.cells.CellStatus;
import design.tictactoe.moves.Move;
import design.tictactoe.players.Player;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Player player, Board board) {
        int size=board.getBoard().length;
        for(int i=0;i<size;++i){
            for (int j=0;j<size;j++){
                if(board.getBoard()[i][j].getCellStatus().equals(CellStatus.EMPTY)){
                    return new Move(new Cell(i,j),player);
                }
            }
        }
        return null;
    }
}
