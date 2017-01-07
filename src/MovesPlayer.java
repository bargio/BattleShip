import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gio on 06/01/2017.
 */
public class MovesPlayer {
    private Map<String,Integer[]> movesPlayer;
    private BattleField battleField;
    private Integer points[];
    //constant
    private final int POINTS = 2;
    private final int ALLIGNER_NUMBERS = 1;
    private final int X = 0;
    private final int Y = 1;
    private final int SHOOTED = 1;
    private final int WHATER= 0;
    private final int TRY_AGAIN = 2;


    public MovesPlayer (BattleField bf){
        this.movesPlayer = new HashMap<>();
        this.battleField = bf;
        movesPlayerCreator();
    }

    public void movesPlayerCreator(){
        for(int i = 0; i<battleField.getHorizontal();i++){
            for(int j = 0; j<battleField.getVertical();j++){
                points = new Integer[POINTS];
                String slot = String.valueOf((char)('A'+i));
                slot = slot + (j + ALLIGNER_NUMBERS);
                points[X] = i;
                points[Y] = j;
                movesPlayer.put(slot,points);
            }
        }
    }

    public int actionMove (String point){
        if(movesPlayer.get(point)==null){
            return TRY_AGAIN;
        }
        getPoints(point);
        if(battleField.checkPoints(points[X],points[Y]) == WHATER){
            return WHATER;

        }else{
            return SHOOTED;
        }
    }


    private void getPoints(String point){
        points = movesPlayer.get(point);
        movesPlayer.remove(point);

    }
}
