package Package;
import Exception.PosizioneException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] map = new String[3][3]; //mappa su cui si giochera a tris
        TicTacToe game = new TicTacToe();
        char scelta;
        //inizializzo la mappa
        game.resetMap(map);
        do{
            System.out.print("Vuoi Giocare? (scrivi n per terminare il gioco): ");
            scelta = sc.next().charAt(0);
            if (scelta == 'n') { break; } //se l'utente sceglie di non giocare termina il tutto
            game.stampaMap(map);
            while (!game.controllaVittoria(map)) { //il ciclo vale finchè non avviene un tris
                try {
                    if (game.getTurno() > 9){
                        System.out.println("Pareggio!!");
                        game.stampaClassifica(); //Stampo la classifica e concludo il giorno
                        break;
                    }
                    else {
                        game.selezionaPosizione(map);
                    }
                } catch (PosizioneException e) { //eccezione per quando l'utente prova una posizione occupata o invalida
                    System.out.println(e.getMessage());
                }
                game.stampaMap(map);
            }
            game.resetMap(map); //resetto la mappa
            game.resetTurno(); //resetto il numero di turni
        }while (scelta != 'n');
    }
}
