import java.util.Scanner;

/**
 * Created by Gio on 06/01/2017.
 */
public class GamePreparator {
    private Player player1,player2;
    private BattleField battleFieldPlayer1,battleFieldPlayer2;
    private Ship[] shipsPlayer1,shipsPlayer2;
    private final int DIM_DEFAULT = 9;
    private Scanner inputPlayers;
    private int x,y;

    public GamePreparator() {
        this.player1 = new Player();
        this.player2 = new Player();
        this.inputPlayers = new Scanner(System.in);
    }
    public void mapCreator(){
        try {
            inputDimensio();
        }catch (Exception e){
            printMessage("valore non accettato...\nRiprovare");
            mapCreator();
        }
        this.battleFieldPlayer1 = new BattleField(x+DIM_DEFAULT,y+DIM_DEFAULT);
        this.battleFieldPlayer2 = new BattleField(x+DIM_DEFAULT,y+DIM_DEFAULT);
        battleFieldPlayer1.slotCreator();
        battleFieldPlayer2.slotCreator();
        player1.setBattleField(battleFieldPlayer1);
        player2.setBattleField(battleFieldPlayer2);
        }

        public void shipsCreator(){
            printMessage("Numero massimo navi da inserire: " + battleFieldPlayer1.getMaxShip());
            shipsPlayer1 = new Ship[battleFieldPlayer1.getMaxShip()];
            shipsPlayer2 = new Ship[battleFieldPlayer1.getMaxShip()];
            for(int i = 0; i<shipsPlayer1.length;i++){
                printMessage("Dimensione " + (i+1) + "° nave");
                int dim = inputPlayers.nextInt();
                if(checkRightDimension(dim)){
                    shipsPlayer1[i] = new Ship(dim);
                    shipsPlayer2[i] = new Ship(dim);
                    player1.getBattleField().insShip(shipsPlayer1[i]);
                    player2.getBattleField().insShip(shipsPlayer2[i]);
                }
                else{
                    printMessage("DIMENSIONE NON CONSONA \n SCEGLIERE NUOVA DIMENSIONE");
                    i--;
                }
            }
        }

    private boolean checkRightDimension(int dim) {
            if(dim<player1.getBattleField().getHorizontal() || dim<player1.getBattleField().getVertical()){
                return true;
            }
            return false;
    }


    private void inputDimensio() throws Exception{
        printMessage("Scegli dimensione Mappa (dimensioni default = 10) inserire almeno 1 \n altezza:");
        x = inputPlayers.nextInt();
        printMessage("y: ");
        y = inputPlayers.nextInt();
    }

    private void printMessage(String text) {
        System.out.println(text);
    }


    //getter
    public Player getPlayer1 (){
        return player1;
    }
    public Player getPlayer2(){
        return  player2;
    }
}
