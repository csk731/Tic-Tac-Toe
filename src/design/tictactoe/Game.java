package design.tictactoe;

import design.tictactoe.board.Board;
import design.tictactoe.board.cells.Cell;
import design.tictactoe.board.cells.CellStatus;
import design.tictactoe.exceptions.InvalidGameConstructionParameterException;
import design.tictactoe.moves.Move;
import design.tictactoe.players.Player;

import java.util.ArrayList;
import java.util.List;
public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;

    private Game(){

    }
    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

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
    public void makeNextMove() {
        Player toMovePlayer=players.get(nextPlayerIndex);
        Move move=toMovePlayer.decideMove(board);

        //Validate Move

        int row=move.getCell().getRow();
        int col=move.getCell().getColumn();

        System.out.println("Move happened at: "+ row +", "+ col);

        board.getBoard()[row][col].setCellStatus(CellStatus.FILLED);
        board.getBoard()[row][col].setPlayer(toMovePlayer);

        Move finalMove=new Move(board.getBoard()[row][col],toMovePlayer);

        this.moves.add(finalMove);

        nextPlayerIndex = (nextPlayerIndex+1) % players.size();

    }

    public void displayBoard() {
        int size=board.getBoard().length;
        for(int i=0;i<size;++i){
            for(int j=0;j<size;++j){
                Cell cell=board.getBoard()[i][j];
                if(j==0) System.out.print("|");
                if(cell.getCellStatus().equals(CellStatus.FILLED)) System.out.print(cell.getPlayer().getaChar());
                else System.out.print(" ");
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    static class GameBuilder{
        private int dimension;
        private List<Player> players;
        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private boolean valid() throws InvalidGameConstructionParameterException {
            if(this.dimension < 3){
                throw new InvalidGameConstructionParameterException("The dimension of the board must be at least 3");
            }
            if(this.players.size() != this.dimension-1) {
                throw new InvalidGameConstructionParameterException("The number of players must be one less than dimension");
            }

            // Validate no two people has same symbols
            // Validate one bot

            return true;
        }

        public Game build() throws Exception{
            try{
                valid();
            }
            catch (Exception e){
                throw new Exception(e.getMessage());
            }

            Game game=new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayers(players);
            game.setMoves(new ArrayList<Move>());
            game.setBoard(new Board(dimension));
            game.setNextPlayerIndex(0);

            return game;
        }
    }
}
