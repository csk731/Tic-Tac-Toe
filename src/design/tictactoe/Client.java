package design.tictactoe;

import design.tictactoe.players.Player;
import design.tictactoe.players.PlayerType;
import design.tictactoe.players.botplayers.Bot;
import design.tictactoe.players.botplayers.BotDifficultyLevel;
import design.tictactoe.symbols.Symbol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Provide the dimension(N) of the board: ");
        int dimension=scanner.nextInt();

        System.out.println("Is there any bot? y/n");
        String isThereABot=scanner.nextLine();

        int noOfPlayers=dimension-1;

        List<Player> players=new ArrayList<>();
        HashSet<Character> playerSymbols=new HashSet<>();

        if(isThereABot.equals("y")){
            System.out.println("What is the name of the bot?");
            String botName=scanner.nextLine();

            System.out.println("What is the symbol of the bot?");
            char symbol=scanner.next().charAt(0);

            System.out.println("What is the difficulty level of the bot?\n" +
                    "Select the number from below ones:\n" +
                    "1. Easy\n" +
                    "2. Medium\n" +
                    ">=3. Hard");

            int difficultyLevel=scanner.nextInt();

            if(difficultyLevel==1){
                players.add(new Bot(symbol,botName,BotDifficultyLevel.EASY));
            }
            else if (difficultyLevel==2){
                players.add(new Bot(symbol,botName,BotDifficultyLevel.MEDIUM));
            }
            else{
                players.add(new Bot(symbol,botName,BotDifficultyLevel.HARD));
            }

            noOfPlayers=dimension-2;
        }
        for(int i=1;i<=noOfPlayers;++i){
            System.out.println("What is the name of the player-" + i + " ?");
            String nameOfThePlayer=scanner.nextLine();
            System.out.println("What is the symbol of this player-" + i + " ?");
            char symbol=scanner.next().charAt(0);

            // Unique symbol validation

            players.add(new Player(symbol,nameOfThePlayer, PlayerType.HUMAN));
        }
        
        Game game=gameController.createGame(dimension,players);

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is the current board");
            // Print the Board
            gameController.displayBoard(game);

            System.out.println("Do you want to undo? y/n");
            //Read the input
            String input=scanner.next();
            if(input.equals("y")){
                gameController.undo(game);
            }
            else{
                gameController.executeNextMove(game);
            }

        }
        System.out.println("The Game has ended. Result: ");
        if(game.getGameStatus().equals(GameStatus.DRAW)){
            System.out.println("Winner is: ");
        }
    }
}
