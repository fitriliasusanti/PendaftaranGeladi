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
    private Lokasi[] lokasi = new Lokasi[10];
    private int i = 0;
    
    public Pembimbing(String nama, String jenisKelamin,  String alamat, String telp, String nip, String kodeDosen) {
        super(nama,jenisKelamin,alamat,telp);
        this.nip = nip;
        this.kodeDosen = kodeDosen;
    }         

    public Lokasi getLokasi(int index) {
         if (index<10)
        {
            return lokasi[index];
        } 
        else 
        {
            return null;
        }
    }

    public void createLokasi(Lokasi l) {
        if (i<10)
        {
            lokasi[i] = l;
            i++;
        }
        else
        {
            System.out.println("Array Pesanan Penuh !!!");
        }
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
        return super.getNama();
    }
}
