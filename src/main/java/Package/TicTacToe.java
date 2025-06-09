package Package;

import java.util.Scanner;
import Exception.PosizioneException;

public class TicTacToe {
    Scanner scanner = new Scanner(System.in);
    private int turno = 1;
    private int posizioneRigaX = 0;
    private int posizioneColonnaX = 0;
    private int posizioneRigaO = 0;
    private int posizioneColonnaO = 0;

    public TicTacToe() {}

    public void updateTurno(){
        turno++;
    }

    public int getTurno(){
        return turno;
    }

    public void stampaMap(String[][] map){
        for(int i = 0; i < 3; i++){
            System.out.print("\n");
            for(int j = 0; j < 3; j++){
                System.out.print(map[i][j]);
            }
        }
    }

    public void selezionaPosizione (String[][] map) throws PosizioneException{
        if (getTurno()%2 == 0) {
            System.out.println("\nScegli in che posizione mettere la X!");
            System.out.print("riga + colonna: ");
            posizioneRigaX = scanner.nextInt();
            posizioneColonnaX = scanner.nextInt();
            if (posizioneRigaX < 0 || posizioneRigaX >= 3 || posizioneColonnaX >= 3 || posizioneColonnaX < 0){
                throw new PosizioneException("Posizione non valida");
            }
            else{
                map[posizioneRigaX][posizioneColonnaX] = "X";
                updateTurno();
            }
        }
        else{
            System.out.println("\nScegli in che posizione mettere il O!");
            System.out.print("riga + colonna: ");
            posizioneRigaO = scanner.nextInt();
            posizioneColonnaO = scanner.nextInt();
            if (posizioneRigaO < 0 || posizioneRigaO >= 3 || posizioneColonnaO < 0 || posizioneColonnaO >= 3){
                throw new PosizioneException("Posizione non valida");
            }
            else{
                map[posizioneRigaO][posizioneColonnaO] = "O";
                updateTurno();
            }
        }
    }

}
