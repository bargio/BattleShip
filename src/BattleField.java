import java.util.Random;

/**
 * Created by Gio on 06/01/2017.
 */
public class BattleField {

    private int horizzontal;
    private int vertical;
    private Slot[][] map;
    private Random randomNumberCreator;


    private final int NORD = 0;
    private final int SUD = 1;
    private final int EAST = 2;
    private final int WEST = 3;
    private final int TOT_DIRECTION = 4;
    private int MAX_SHIP = 0;

    private int shipsInsert;
    private boolean printMapWithShip = false;

    public BattleField(int x,int y){
        this.horizzontal = x;
        this.vertical = y;
        this.map = new Slot[horizzontal][vertical];
        this.randomNumberCreator = new Random();
        this.shipsInsert = 0;
        this.MAX_SHIP = (horizzontal+vertical)/TOT_DIRECTION;


    }

    public void slotCreator(){
        for(int i=0;i<horizzontal;i++){
            for(int j=0;j<vertical;j++){
                map[i][j] = new Slot(i,j);
            }
        }
    }

    public void insShip(Ship ship){

        searchFreeSlot(ship);
    }

    private void searchFreeSlot (Ship ship){
        boolean freeSlot = true;
        boolean insShip = false;
        shipsInsert++;
        int dimShip = ship.getDimension();
        while(freeSlot && shipsInsert <= MAX_SHIP){
            int pointX = randomNumberCreator.nextInt(horizzontal);
            int pointY = randomNumberCreator.nextInt(vertical);
            int maxSearchDirection = 0;
            if(!map[pointX][pointY].getThereShip()){
                while(!insShip && maxSearchDirection < TOT_DIRECTION){
                    int direction= randomNumberCreator.nextInt(TOT_DIRECTION);
                    maxSearchDirection++;
                    if(checkSpaceOccupiedShip(dimShip,direction,pointX,pointY)){
                        insertShip(dimShip,direction,pointX,pointY,ship);
                        insShip = true;
                        freeSlot = false;
                    }
                }
            }
        }
        if(shipsInsert == MAX_SHIP){
            String message = "Massimo navi raggiunto";
            printMessage(message);
        }
    }

    private void insertShip(int dimShip, int direction, int pointX, int pointY, Ship ship) {
        int sign = 1;
        int axisX = 0;
        int axisY = 0;


        if (direction == NORD || direction == WEST) {
            sign = -1;
        }
        if (direction == EAST || direction == WEST) {
            axisX = 1;
        }
        if (direction == NORD || direction == SUD) {
            axisY = 1;
        }
        for (int i = dimShip; i > 0; i--) {
            int pointAxisX = (i * axisX * sign);
            int pointAxisY = (i * axisY * sign);
            pointAxisX = pointX + pointAxisX;
            pointAxisY = pointY + pointAxisY;
            map[pointAxisX][pointAxisY].setShip();
            ship.creatorShipName(pointAxisX,pointAxisY);





        }
    }


    private boolean checkSpaceOccupiedShip(int dimShip, int direction, int pointX, int pointY) {
        int sign = 1;
        int axisX = 0;
        int axisY = 0;
        int spacePointsOccupied = 0;

        if (direction == NORD || direction == WEST) {
            sign = -1;
        }
        if (direction == EAST || direction == WEST) {
            axisX = 1;
            spacePointsOccupied = pointX + dimShip;
        }
        if (direction == NORD || direction == SUD) {
            axisY = 1;
            spacePointsOccupied = pointY + dimShip;
        }
        if (spacePointsOccupied >= 0 && (spacePointsOccupied < horizzontal || spacePointsOccupied< vertical)) {
            for (int i = dimShip; i >= 0; i--) {
                for (int j = -1; j <= 1; j++) {
                    int pointAxisX = (i * axisX * sign) + (j);
                    int pointAxisY = (i * axisY * sign) + (j);
                    pointAxisX = pointX + pointAxisX;
                    pointAxisY = pointY + pointAxisY;
                    if (pointAxisX < 0 || pointAxisY< 0 || pointAxisX>= horizzontal|| pointAxisY>= vertical) {
                        return false;
                    }
                    if (!map[pointAxisX][pointAxisY].getFree()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }



private void setDirection(int direction){

}


    private void printMessage(String text) {
        System.out.println(text);
    }

    public int checkPoints(int x,int y){
        map[x][y].setShooted();
        if(map[x][y].getThereShip()){
            return 1;
        }else {
            return 0;
        }
    }

    public void printMap(){
            for(int j=1;j<=horizzontal;j++){
                System.out.print(" " + j + " ");
            }
            System.out.print("\n");
            for (int i = 0; i < horizzontal; i++) {
                for (int z = 0; z < vertical; z++) {
                    if(z>=10){
                        System.out.print(" ");
                    }
                    if(map[i][z].getThereShip()&& (printMapWithShip || map[i][z].getShooted())){
                        System.out.print(" 1 ");
                    }else if(map[i][z].getShooted()){
                        System.out.print(" 0 ");
                    }else{
                        System.out.print(" - ");
                    }
                    if (z == vertical-1) {
                        System.out.println((char)('A'+i));
                    }
                }
            }
        }
    //getter
    public int getHorizontal(){
        return horizzontal;
    }
    public int getVertical(){
        return vertical;
    }
    public Slot[][] getSlot(){
        return map;
    }
    //setter
    public void setPrintMap(){
        this.printMapWithShip = true;
    }

    public int getMaxShip() {
        return MAX_SHIP;
    }
}



