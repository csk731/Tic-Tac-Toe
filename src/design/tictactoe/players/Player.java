package design.tictactoe.players;

import design.tictactoe.board.Board;
import design.tictactoe.board.cells.Cell;
import design.tictactoe.moves.Move;

import java.util.Scanner;

public class Player {
    private char aChar;
    private String name;
    private PlayerType playerType;

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Player(char aChar, String name, PlayerType playerType) {
        this.aChar = aChar;
        this.name = name;
        this.playerType = playerType;
    }

    public Move decideMove(Board board) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("It's "+this.name+"'s turn.!");

        System.out.println("Enter the row number, starting from 0:");
        int row=scanner.nextInt();
        System.out.println("Enter the column number, starting from 0:");
        int column=scanner.nextInt();
        return new Move(new Cell(row,column));

    }
}
