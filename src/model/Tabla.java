package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
    
    public boolean uresOszlop(int oszlopSzama){
        int i = 0;
        while (i < 8 && T[i][oszlopSzama] != 'K'){
            i++;
        }
        return i == 8;
    }
    
    public boolean uresSor(int sorSzama){
        int i = 0;
        while (i < 8 && T[sorSzama][i] != 'K'){
            i++;
        }
        return i == 8;
    }
    
    public int uresSorokSzama() {
        int db = 0;
        
        for (int i = 0; i < this.T.length; i++) {
            if(uresSor(i)){
                db++;
            }
        }
        
        return db;
    }
    
    public int uresOszlopokSzama() {
        int db = 0;
        
        for (int i = 0; i < this.T[0].length; i++) {
            if(uresOszlop(i)){
                db++;
            }
        }
        return db;
    }
    
    public void fajlbaIr() throws IOException{
        String txt = this.megjelenit() + "\n";
        
        Path path = Path.of("tablak64.txt");
        byte[] bytes = txt.getBytes();
        
        Files.write(path, bytes, StandardOpenOption.APPEND);
    }
}
