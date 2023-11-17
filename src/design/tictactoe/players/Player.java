package design.tictactoe.players;

import design.tictactoe.symbols.Symbol;

public class Player {
    private char aChar;
    private String name;
    private PlayerType playerType;

    public Player(char aChar, String name, PlayerType playerType) {
        this.aChar = aChar;
        this.name = name;
        this.playerType = playerType;
    }
}
