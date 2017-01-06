import java.util.Scanner;

/**
 * Created by Gio on 06/01/2017.
 */
public class Player {
    private MovesPlayer movesPlayer;
    private BattleField battleField;
    private boolean winner;
    private String name;

    public Player(){
        this.winner = false;
        insName();
    }

    private void insName() {
        System.out.print("Inserisci nome \n");
        this.name = new Scanner(System.in).nextLine();
    }

    //getter
    public BattleField getBattleField(){
        return battleField;
    }
    public MovesPlayer getMovesPlayer(){
        return movesPlayer;
    }
    public String getName(){
        return name;
    }
    public boolean isWinner(){
        return winner;
    }

    //setter
    public void setName(String name){
        this.name = name;
    }
    public void setBattleField(BattleField bf){
        this.battleField = bf;
    }
    public void setMovesPlayer(){
        this.movesPlayer = new MovesPlayer(battleField);
    }
    public void setWinner(boolean winner){
        this.winner = winner;
    }
}
