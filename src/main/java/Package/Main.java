package Package;
import Exception.PosizioneException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] map = new String[3][3];
        TicTacToe game = new TicTacToe();
        char scelta;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = "|";
            }
        }
        do{
            System.out.print("Vuoi Giocare? (scrivi n per terminare il gioco): ");
            scelta = sc.next().charAt(0);
            if (scelta == 'n') { break; }
            game.stampaMap(map);
            while (!game.controllaVittoria(map)) {
                try {
                    game.selezionaPosizione(map);
                } catch (PosizioneException e) {
                    System.out.println(e.getMessage());
                }
                game.stampaMap(map);
            }
            game.resetMap(map);
        }while (scelta != 'n');
    }
}
