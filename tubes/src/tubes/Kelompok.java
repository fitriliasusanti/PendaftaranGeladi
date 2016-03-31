/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author Fitrilia
 */
public class Kelompok {
    private Mahasiswa[] anggota = new Mahasiswa[5];    
    private int jmlMhs = 0;    
    private int jmlKelompok = 0;
       
    public Kelompok(Mahasiswa mhs) {
        this.anggota[this.jmlMhs] = mhs; 
        this.jmlMhs ++;
    }

    public int getJmlKelompok() {
        return jmlKelompok;
    }

    public void setJmlKelompok(int jmlKelompok) {
        this.jmlKelompok = jmlKelompok;
    }
    
    public int getJmlMhs() {
        return jmlMhs;
    }

    public void setJmlMhs(int jmlMhs) {
        this.jmlMhs = jmlMhs;
    }
    
    public void addAnggota(Mahasiswa m) {
        if (!m.isCekKelompok()) {
            m.setCekKelompok(true);
            anggota[jmlMhs] = m;
            jmlMhs++;
        }            
    }
    
    public void getAnggota(){
        for(int i = 0; i < jmlMhs; i++){
            System.out.println(anggota[i].getNama());
        }        
        
    }
    
    public Mahasiswa getAnggotabyIndex(int n) {
        return anggota[n];
    }
    
    public Mahasiswa getAnggotabyId(String nim) {
        int i;
        for (i=0; i<jmlMhs; i++) {
            if (anggota[i].getNim() == nim) {
                //System.out.println(this.getAnggota(i).getNama());
                return anggota[i];
                               
            }
        }         
        return anggota[i];      
    }                
}
