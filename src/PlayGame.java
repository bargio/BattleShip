import java.awt.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Gio on 06/01/2017.
 */
public class PlayGame {
    private Player player1,player2;
    private boolean winnerPlayer1, winnerPlayer2;
    private GamePreparator pr;

    private final int SHOOTED = 1;
    private final int WHATER= 0;
    private final int TRY_AGAIN = 2;

    private boolean vsPC;
    private boolean rematch = true;
    private boolean rematchPc = true;

    public PlayGame() {
        this.pr = new GamePreparator();
        this.player1 = pr.getPlayer1();
        this.player2 = pr.getPlayer2();
        this.winnerPlayer1 = player1.isWinner();
        this.winnerPlayer2 = player2.isWinner();
        this.vsPC = false;
        pr.mapCreator();
        pr.shipsCreator();
        player1.setMovesPlayer();
        player2.setMovesPlayer();

    }
    public void startGame(){
        vsPc();
        while(!winnerPlayer1||!winnerPlayer2){
            rematch = true;
            move(player1);
            if(vsPC){
                rematchPc = true;
                movePc(player2);
            }else{
                rematch = true;
                move(player2);
            }
        }
    }

    private void movePc(Player pc) {
        while(rematchPc) {
            Random rd = new Random();
            String casella = String.valueOf((char) ('A' + rd.nextInt(pc.getBattleField().getHorizontal()))) + (rd.nextInt(pc.getBattleField().getVertical()) + 1);
            checkMove(pc, casella);
            System.out.println(casella);
        }
    }

    private void move(Player player) {
        while(rematch) {
            System.out.println("#####   TURNO DI " + player.getName() + "##### \n\n Inserire coordinata :\n\n");
            String point;
            point = new Scanner(System.in).nextLine();
            if (point.equalsIgnoreCase("Mappa")) {
                player.getBattleField().printMap();
            } else if (point.contains("navi")){
                System.out.println(player.getName() + " si arrende\n Ecco le mappe con le navi");
                player1.getBattleField().setPrintMap();
                player2.getBattleField().setPrintMap();
                player1.getBattleField().printMap();
                player2.getBattleField().printMap();
                System.exit(0);
            }
            point = point.toUpperCase();
            checkMove(player,point);
        }
    }

    private void checkMove(Player player, String point) {
            switch (player.getMovesPlayer().actionMove(point)) {
                case SHOOTED:
                    System.out.print("#### COLPITO #### \n");
                    player.getBattleField().printMap();
                    break;
                case WHATER:
                    System.out.print("#### ACQUA #### \n");
                    player.getBattleField().printMap();
                    rematch = false;
                    rematchPc = false;
                    break;
                case TRY_AGAIN:
                    System.out.println("#### RIPROVARE #####");
                    player.getBattleField().printMap();
                    break;

            }
            if(checkVictory(player)){
                winnerIs();
            }
        }

    private void winnerIs() {
        if(winnerPlayer1){
            System.out.print("************ HA VINTO IL GIOCATORE " + player1.getName() + " **********");
        }else{

            System.out.print("************ HA VINTO IL GIOCATORE " + player2.getName() + "**********");
        }
        System.exit(1);
    }

    private boolean checkVictory(Player player) {
        BattleField m = player.getBattleField();
        Slot[][] c = m.getSlot();
        for(int i = 0; i<m.getHorizontal();i++){
            for(int j = 0;j<m.getVertical();j++){
                if(c[i][j].getThereShip() && !c[i][j].getShooted()){
                    return false;
                }
            }
        }
        player.setWinner(true);
        return true;
    }


    private void vsPc() {
        System.out.println("Giocare contro il pc?? y/n");
        String s = new Scanner(System.in).nextLine();
        if(s.equalsIgnoreCase("y")){
            vsPC = true;
            player2.setName("PC");
        }
    }
}
