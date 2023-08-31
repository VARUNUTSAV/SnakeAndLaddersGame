import Utils.CellType;

public class Cell{
    private int position;
    private int destination;
    CellType cellType;

    public Cell(CellType cellType, int destination){
        this.destination = destination;
        this.cellType = cellType;
    }
    public Cell(CellType cellType){
//        this.position = position;
//        this.destination = destination;
        this.cellType = cellType;
    }

    public int getPosition() {
        return position;
    }

    public int getDestination() {
        return destination;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}
