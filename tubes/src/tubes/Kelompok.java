/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fitrilia
 */
public class Kelompok {
    private Mahasiswa[] anggota = new Mahasiswa[5];            
    private int nomerKelompok;
    private int jmlAnggota;                
    
    public Kelompok(int nomerKelompok, Mahasiswa mhs) {
        this.anggota[this.jmlAnggota] = mhs; 
        this.jmlAnggota ++;
        this.nomerKelompok = nomerKelompok;
    }      
    
    public Kelompok(Mahasiswa mhs) {
        this.anggota[this.jmlAnggota] = mhs; 
    }

    public int getNomerKelompok() {
        return nomerKelompok;
    }

    public void setNomerKelompok(int nomerKelompok) {
        this.nomerKelompok = nomerKelompok;
    }        
    
    public int getJmlAnggota() {
        return jmlAnggota;
    }

    public void setJmlAnggota(int jmlAnggota) {
        this.jmlAnggota = jmlAnggota;
    }                        
    
    public void addAnggota(Mahasiswa mhs) {        
        if (jmlAnggota<5)
        {                     
            anggota[jmlAnggota] = mhs;
            jmlAnggota++;                
        }
        else
        {
                System.out.println("Anggota Kelompok Sudah Penuh !!!");
        }
    }    
    
    public boolean removeAnggota(String nim) {
        for (int j = 0; j < jmlAnggota; j++) {
            if(anggota[j].getNim()== nim){
                //cek dia index keberapa
                if(j == 0){
                    //index pertama alias delete first
                    anggota[0] = null;
                    for (int k = 0; k < jmlAnggota-1; k++) {
                        anggota[k] = anggota[k+1];
                    }
                    anggota[jmlAnggota] = null;
                    jmlAnggota--;
                    return true;
                }else if(j == jmlAnggota){
                    //index terakhir alias delete last
                    anggota[j] = null;
                    jmlAnggota--;
                    return true;
                }else{
                    //index tengah alias delete after
                    anggota[j] = null;
                    for (int k = j; k < jmlAnggota-1; k++) {
                        anggota[k] = anggota[k+1];
                    }
                    anggota[jmlAnggota] = null;
                    jmlAnggota--;
                    return true;
                }
            }
        }
        return false;
    }
    
    public void getAnggota(){
        for(int i = 0; i < jmlAnggota; i++){
            System.out.println(anggota[i].getNama());
        }        
        
    }
    
    public Mahasiswa getAnggotabyIndex(int n) {
        if (n<5)
        {
            return anggota[n];
        } 
        else 
        {
            return null;
        }        
    }
    
    public Mahasiswa getAnggotabyId(String nim) {
        int i;
        for (i=0; i<jmlAnggota; i++) {
            if (anggota[i].getNim().equals(nim)) {
                //System.out.println(this.getAnggota(i).getNama());
                break;             
            }
        }         
        return anggota[i];      
    }                       
    
    public String toString() {
        String x = "\nNomer Kelompok: "+this.getNomerKelompok();                
        return x;
    }            
}
