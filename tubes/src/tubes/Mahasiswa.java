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
public class Mahasiswa extends Orang{
    private String nim;
    private String fakultas;
    private String jurusan;       
    private boolean status;    
    private ArrayList<Kelompok> kel = new ArrayList<Kelompok>();
    
    public Mahasiswa(String nama, String alamat, String telp, String nim, String fakultas, String jurusan) {
        super(nama,alamat,telp); 
        this.nim = nim;
        this.jurusan = jurusan;        
        this.fakultas = fakultas;
    }                      
    
    public Mahasiswa(String nama, String alamat, String telp) {
        super(nama, alamat, telp);
    }
        
    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    } 

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }            
    
//    public void getKelompokMhs() {
//        for (int i=0; i<kel.size(); i++) {
//            System.out.print("Kelompok: ");
//            System.out.println(kel.get(i).getNomerKelompok());
//            kel.get(i).getAnggota();
//            System.out.println("");
//        }
//    }
//    
//    public void addKelompokMhs(Kelompok k) {
//        kel.add(k);
//    }
//    
//    public void removeKelompokMhs(Kelompok k) {
//        kel.remove(k);
//    }
    
    public String toString(){
        String x = "\nNIM : "+this.getNim()+
                "\nNama Mahasiswa : "+this.getNama()+
                "\nFakultas : "+this.getFakultas()+                
                "\nJurusan : "+this.getJurusan()+
                "\nStatus : "+this.isStatus();                
        return x;
    }
}