package model;

import java.util.Random;

public class Tabla {
    private char[][] T;
    private char uresCella;
    private static final Random rn = new Random();
    
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
    
    public void elhelyez(int n){
        for (int i = 0; i < n; i++) {
            int sor;
            int oszlop;
            do{
                sor = rn.nextInt(8);
                oszlop = rn.nextInt(8);
            } while (T[sor][oszlop] != uresCella);
            T[sor][oszlop] = 'K';
        }
    }
}
