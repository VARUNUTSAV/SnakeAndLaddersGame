import Utils.CellType;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Board{
    ArrayList<Cell> board = new ArrayList<>();
    SecureRandom srand = new SecureRandom();
    ArrayList<Player> playerList = new ArrayList<>();
    Set<Integer> occupiedCells = new HashSet<>();

    public ArrayList<Cell> getBoard(){
        return board;
    }
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void initialize() {
        System.out.println("Initializing the game board");
//        int snakes = srand.nextInt(10)+1;
//        int ladders = srand.nextInt(10)+1;
        int snakes =5;
        int ladders = 5;
        for(int i = 0 ; i < 101 ; i++){
            Cell cell = new Cell(CellType.NORMAL);
            board.add(cell);
        }
        setLaddersRandomly(ladders);
        setSnakesRandomly(snakes);

        for(int i = 0 ; i < 101 ; i++){
            if(board.get(i) != null) continue;
            Cell newCell = new Cell(CellType.NORMAL);
            board.set(i, newCell);
        }

    }

    public void setSnakesRandomly(int num) {
        for(int i = 0; i < num; i ++){
            int start = 0, destination = 0;

            while(true) {
                start = srand.nextInt(98);
                if(!occupiedCells.contains(start)){
                    occupiedCells.add(start);
                    break;
                }
            }
            while(true) {
                //Setting the destination for a snake cell to lower than its position
                destination = (int)(start * srand.nextDouble());
                if(!occupiedCells.contains(destination)){
                    occupiedCells.add(destination);
                    break;
                }
            }
            System.out.println("Snake generated at position " + "[" + start+ "," + destination + "]");

            Cell cell = new Cell(CellType.SNAKE, destination);
            board.set(start, cell);

        }
    }

    public void setLaddersRandomly(int num) {
        for(int i = 0; i < num; i ++) {
            int start = 0, destination = 0;

            while (true) {
                start = srand.nextInt(80);
                if (!occupiedCells.contains(start)) {
                    occupiedCells.add(start);
                    break;
                }
            }
            while (true) {
                //Setting the destination for the ladder cell to greater than its position
                destination = (int)(start + (srand.nextDouble() * 10));
                if (!occupiedCells.contains(destination)) {
                    occupiedCells.add(destination);
                    break;
                }
            }
            System.out.println("Ladder generated at position " + "[" + start + "," + destination + "]");

            Cell cell = new Cell(CellType.LADDER, destination);

            board.set(start, cell);

        }

    }

    public Cell getCell(int pos){
        return board.get(pos);
    }
    public void addPlayers(Player player){
        this.playerList.add(player);
    }
    public void movePlayer(int roll, Player player) {
        int currPosition = player.getPosition();
        int checkPos = checkPosition(currPosition);

        if(checkPos == 1) gameOver(player);
        else if(checkPos == 2) System.out.println("Too high try different number next time");
        else{
            Cell cell = getCell(currPosition+roll);
            if(cell.getCellType() == (CellType.NORMAL)){
                player.setPosition(currPosition + roll);
                System.out.println("Player " + player.getName() + " has moved to position "+ player.getPosition());
            }else{
                player.setPosition(cell.getDestination());
                System.out.println("Player " + player.getName() + " has met a " + cell.getCellType() + " moves to position " + player.getPosition());
            }
        }
    }

    public int checkPosition(int position){
        if(position > 100) return 2;
        else if (position == 100) {
            return 1;
        }else{
            return 0;
        }
    }

    public void gameOver(Player player){

        System.out.print("Hurray!!! " + player.getName() + " has won the game !");
        System.exit(0);
    }
}
