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
    private int puntiX = 0;
    private int puntiO = 0;

    public TicTacToe() {}

    public void setPuntiX(int puntiX){
        this.puntiX = puntiX;
    }

    public int getPuntiX(){
        return puntiX;
    }

    public void setPuntiO(int puntiO){
        this.puntiO = puntiO;
    }

    public int getPuntiO(){
        return puntiO;
    }

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
                System.out.print(map[i][j] + "\t");
            }
        }
    }

    public void selezionaPosizione (String[][] map) throws PosizioneException{
        if (getTurno()%2 == 0) {
            do{
                System.out.println("\nScegli in che posizione mettere la X!");
                System.out.print("riga + colonna: ");
                posizioneRigaX = scanner.nextInt();
                posizioneColonnaX = scanner.nextInt();
                if (posizioneRigaX < 0 || posizioneRigaX >= 3 || posizioneColonnaX < 0 || posizioneColonnaX >= 3){
                    throw new PosizioneException("Posizione non valida");
                }
            }while (getPosizioneOccupata(map, posizioneRigaX, posizioneColonnaX));
            map[posizioneRigaX][posizioneColonnaX] = "X";
            updateTurno();
        }
        else{
            do{
                System.out.println("\nScegli in che posizione mettere il O!");
                System.out.print("riga + colonna: ");
                posizioneRigaO = scanner.nextInt();
                posizioneColonnaO = scanner.nextInt();
                if (posizioneRigaO < 0 || posizioneRigaO >= 3 || posizioneColonnaO < 0 || posizioneColonnaO >= 3){
                    throw new PosizioneException("Posizione non valida");
                }
            }while(getPosizioneOccupata(map, posizioneRigaO, posizioneColonnaO));
            map[posizioneRigaO][posizioneColonnaO] = "O";
            updateTurno();
        }
    }

    public boolean getPosizioneOccupata(String[][] map, int riga, int colonna){
        if (!map[riga][colonna].equals("|")){
            System.out.println("Posizione occupata!");
            return true;
        }
        return false;
    }

    public void vittoriaX(){
        System.out.println("Tris! Ha vinto la X!");
        setPuntiX(getPuntiX() + 1);
    }

    public void vittoriaO(){
        System.out.println("Tris! Ha vinto il O!");
        setPuntiO((getPuntiO()) + 1);
    }


    public boolean controllaRighe(String[][] map){
        if (map[0][0].equals(map[0][1]) && map[0][1].equals(map[0][2]) && !map[0][0].equals("|")){
            if (map[0][0].equals("X")){
                vittoriaX();
            }
            else if (map[0][0].equals("O")){
                vittoriaO();
            }
            return true;
        }
        else if (map[1][0].equals(map[1][1]) && map[1][1].equals(map[1][2]) && !map[1][0].equals("|")){
            if (map[1][0].equals("X")){
                vittoriaX();
            }
            else if (map[1][0].equals("O")){
                vittoriaO();
            }
            return true;
        }
        else if (map[2][0].equals(map[2][1]) && map[2][1].equals(map[2][2]) && !map[2][0].equals("|")){
            if (map[2][0].equals("X")){
                vittoriaX();
            }
            else if (map[2][0].equals("O")){
                vittoriaO();
            }
            return true;
        }
        return false;
    }

    public boolean controllaColonne(String[][] map){
        if (map[0][0].equals(map[1][0]) && map[1][0].equals(map[2][0]) && !map[0][0].equals("|")){
            if (map[0][0].equals("X")){
                vittoriaX();
            }
            else if (map[0][0].equals("O")){
                vittoriaO();
            }
            return true;
        }
        else if (map[0][1].equals(map[1][1]) && map[1][1].equals(map[2][1]) && !map[0][1].equals("|")){
            if (map[0][1].equals("X")){
                vittoriaX();
            }
            else if (map[0][1].equals("O")){
                vittoriaO();
            }
            return true;
        }
        else if (map[0][2].equals(map[1][2]) && map[1][2].equals(map[2][2]) && !map[0][2].equals("|")){
            if (map[0][2].equals("X")){
                vittoriaX();
            }
            else if (map[0][2].equals("O")){
                vittoriaO();
            }
            return true;
        }
        return false;
    }

    public boolean controllaVittoria(String[][] map){
        if (controllaRighe(map) || controllaColonne(map)) {
            System.out.println("Gioco Finito!");
            System.out.println("Classifiche: \nX = " + getPuntiX() + "\nO = " + getPuntiO());
            return true;
        }
        return false;
    }

    public void resetMap(String[][] map){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = "|";
            }
        }
    }
}
