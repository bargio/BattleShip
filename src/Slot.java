/**
 * Created by Gio on 06/01/2017.
 */
public class Slot {
    private boolean shooted;
    private boolean thereSShip;
    private boolean free;
    private int pointX;
    private int pointY;

    public Slot(int x,int y){
        this.pointX = x;
        this.pointY = y;
        this.free = true;
        this.shooted = false;
        this.thereSShip = false;
    }
//setter
    public void setShip(){
        this.thereSShip = true;
    }

    public void setShooted(){
        this.shooted = true;
    }
    //getter
    public boolean getShooted(){
        return shooted;
    }
    public boolean getThereShip(){
        return thereSShip;
    }
    public boolean getFree(){
        return free;
    }
}
