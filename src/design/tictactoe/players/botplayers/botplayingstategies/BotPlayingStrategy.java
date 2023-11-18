package design.tictactoe.players.botplayers.botplayingstategies;

import design.tictactoe.board.Board;
import design.tictactoe.moves.Move;
import design.tictactoe.players.Player;

public interface BotPlayingStrategy {
    public Move decideMove(Player player, Board board);
}
