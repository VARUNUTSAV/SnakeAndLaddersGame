import java.util.ArrayList;
import java.util.Scanner;

public class SnakeAndLaddersGame {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.

        Board gameBoard = new Board();
        System.out.println("Enter number of Players.....");
        Scanner scn = new Scanner(System.in);
        int numberOfPlayers = scn.nextInt();

        ArrayList<Player> playerArrayList = new ArrayList<>(numberOfPlayers);

        for(int i = 0 ; i < numberOfPlayers; i++){

            System.out.println("Enter name of Player " + (int)(i+1));
            String name = scn.next();
            Player newPlayer = new Player(name);
            playerArrayList.add(newPlayer);
        }

        gameBoard.initialize();

        Dice gameDice = new Dice();
        int turn = 0;
        String choice = "r";

        System.out.println("Be Ready Game is Starting .....................");
        System.out.println("How to Play - ");
        System.out.println("Press r to roll the dice");
        System.out.println("Press q to quit the game");

        // while loop to play the game until we get a winner
        while(!choice.equals("q")){
            if(turn >= numberOfPlayers) turn = 0;
            else{
                Player currentPlayer = playerArrayList.get(turn);
                System.out.println("It is " + currentPlayer.getName() +"'s turn");
                System.out.println("Press r to roll dice & q to quit");
                choice = scn.next();

                if(choice.equals("r")){
                    int diceOutcome = gameDice.rollDice();
                    gameBoard.movePlayer(diceOutcome, currentPlayer);
                    turn += 1;
                }else{
                    System.out.println("The game has been quit by " + currentPlayer.getName());
                    break;
                }
            }
        }
    }
}