package model;

public class Tabla {
    private char[][] T;
    private char uresCella;
    
    public Tabla(char uresCella){
        this.T = new char[8][8];
        this.uresCella = uresCella;
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                T[i][j] = uresCella;
            }
        }
    }
    
    public String megjelenit(){
        String s = "";
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                s += T[i][j];
            }
            s += "\n";
        }
        return s;
    }
}
