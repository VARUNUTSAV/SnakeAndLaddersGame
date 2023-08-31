import java.util.Random;

public class Dice {
    Random rand = new Random();
    public int rollDice(){
        int result = rand.nextInt(6)+1;
        return result;
    }
}
