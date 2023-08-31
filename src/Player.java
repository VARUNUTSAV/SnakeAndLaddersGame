public class Player {
    private int position;
    private String name;

    public Player(String name){
        this.name = name;
    }
    public Player(int position, String name){
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
