/**
 * Created by Gio on 06/01/2017.
 */
public class Ship {
    private int dimension;
    private String[] pointsShip;
    private int counter;

    private final int ALLIGNER_NUMBERS = 1;

    public Ship(int dim){
        this.dimension = dim;
        this.pointsShip = new String[dim];
        this.counter = 0;
    }

    public void creatorShipName(int x,int y ){
        String slot = String.valueOf((char)('A'+x)+(y+ ALLIGNER_NUMBERS));
        pointsShip[counter] = slot;
        counter ++;
    }

    //getter
    public int getDimension(){
        return dimension;
    }
}
