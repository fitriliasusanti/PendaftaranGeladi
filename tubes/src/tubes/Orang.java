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
public abstract class Orang {
    private String nama;    
    private String alamat;
    private String telp;        
    
    //constructor   
    public Orang(String nama, String alamat, String telp) {
        this.nama = nama;        
        this.alamat = alamat;
        this.telp = telp;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String toString(){
        String x ="\nNama : "+this.getNama()+                
                "\nAlamat : "+this.getAlamat()+
                "\nTelp : "+this.getTelp();        
        return x;
    }
}
