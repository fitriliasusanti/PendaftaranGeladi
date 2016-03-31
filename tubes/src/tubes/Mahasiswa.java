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
public class Mahasiswa extends Orang{
    private String nim;
    private String jurusan;   
    private Lokasi lokasi;
    private boolean status;
    private boolean cekKelompok;
    
    public Mahasiswa(String nama, String jenisKelamin, String alamat, String telp, String nim, String jurusan) {
        super(nama,jenisKelamin,alamat,telp); 
        this.nim = nim;
        this.jurusan = jurusan;        
    }               

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }
    
    public Mahasiswa(String nama, String jenisKelamin, String alamat, String telp) {
        super(nama, jenisKelamin, alamat, telp);
    }

    public boolean isCekKelompok() {
        return cekKelompok;
    }

    public void setCekKelompok(boolean cekKelompok) {
        this.cekKelompok = cekKelompok;
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
        
}