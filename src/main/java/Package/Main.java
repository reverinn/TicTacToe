package Package;
import Exception.PosizioneException;

public class Main {
    public static void main(String[] args) {
        String[][] map = new String[3][3];
        TicTacToe game = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = "|";
            }
        }
        game.stampaMap(map);
        while (true) {
            try {
                game.selezionaPosizione(map);
            } catch (PosizioneException e) {
                System.out.println(e.getMessage());
            }
            game.stampaMap(map);
        }
    }
}
