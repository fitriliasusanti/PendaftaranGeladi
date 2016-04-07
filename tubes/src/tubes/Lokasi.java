/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;

/**
 *
 * @author Fitrilia
 */
public class Lokasi {
    private Pembimbing pembimbing;
    private Kelompok[] kelompok = new Kelompok[10];        
    private String namaPerusahaan;
    private String kota;
    private int jmlKelompokLokasi = 0;           
    
    public Lokasi(String namaPerusahaan, String kota, Pembimbing pem) {
        this.namaPerusahaan = namaPerusahaan;
        this.kota = kota;  
        this.pembimbing = pem;             
    }

    public Lokasi(int nomerKel, String lokasi, String namaPerusahaan, String namaPembimbing) {        
        this.kota = lokasi;
        this.namaPerusahaan = namaPerusahaan;     
    }
        
    
    public int getJmlKelompok() {
        return jmlKelompokLokasi;
    }

    public void setJmlKelompok(int jmlKelompok) {
        this.jmlKelompokLokasi = jmlKelompok;
    }
    
    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }        
    
    public void setPembimbing(Pembimbing p) {
        this.pembimbing = p;        
    }

    public Pembimbing getPembimbing() {
        return pembimbing;
    }        

    public int getJmlKelompokLokasi() {
        return jmlKelompokLokasi;
    }

    public void setJmlKelompokLokasi(int jmlKelompokLokasi) {
        this.jmlKelompokLokasi = jmlKelompokLokasi;        
    }    
    
    public void createKelompok(Kelompok kel){
        this.kelompok[this.jmlKelompokLokasi] =  kel;
        this.jmlKelompokLokasi++;    
        kel.setNomerKelompok(jmlKelompokLokasi);
    } 
    
    public Kelompok getKelompok(int n) {
        return kelompok[n];
    }        
    
    public Kelompok getJmlKelompok(int index) {
        if (index<10)
        {
            return kelompok[index];
        } 
        else 
        {
            return null;
        }
    }

    public void addKelompok(Kelompok k) {
        if (jmlKelompokLokasi<10)
        {
            kelompok[jmlKelompokLokasi] = k;
            jmlKelompokLokasi++;
        }
        else
        {
            System.out.println("Kelompok penuh !!!");
        }
    }
    
     public boolean removeKelompok(int nomerKel) {
         for (int j = 0; j < jmlKelompokLokasi; j++) {
            if(kelompok[j].getNomerKelompok()== nomerKel){
                //cek dia index keberapa
                if(j == 0){
                    //index pertama alias delete first
                    kelompok[0] = null;
                    for (int k = 0; k < jmlKelompokLokasi-1; k++) {
                        kelompok[k] = kelompok[k+1];
                    }
                    kelompok[jmlKelompokLokasi] = null;
                    jmlKelompokLokasi--;
                    return true;
                }else if(j == jmlKelompokLokasi){
                    //index terakhir alias delete last
                    kelompok[j] = null;
                    jmlKelompokLokasi--;
                    return true;
                }else{
                    //index tengah alias delete after
                    kelompok[j] = null;
                    for (int k = j; k < jmlKelompokLokasi-1; k++) {
                        kelompok[k] = kelompok[k+1];
                    }
                    kelompok[jmlKelompokLokasi] = null;
                    jmlKelompokLokasi--;
                    return true;
                }
            }
        }
        return false;
     }             
     
     public String toString(){
        String x = "\nLokasi : "+this.getKota()+
                "\nNama Perusahaan : "+this.getNamaPerusahaan()+
                "\nPembimbing : "+this.getPembimbing();                
        return x;
    }
}

