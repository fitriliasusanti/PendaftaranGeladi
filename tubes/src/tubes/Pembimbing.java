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
public class Pembimbing extends Orang {
    private String nip;
    private String kodeDosen;     
    private int i = 0;       
    
    public Pembimbing(String nama, String alamat, String telp, String nip, String kodeDosen) {
        super(nama,alamat,telp);
        this.nip = nip;
        this.kodeDosen = kodeDosen;
    }            
    
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        this.kodeDosen = kodeDosen;
    }          
    
    public String toString(){
        String x = "\nNIP : "+this.getNip()+
                "\nKode Dosen : "+this.getKodeDosen()+
                "\nNama Dosen : "+this.getNama();                
        return x;
    }
}
