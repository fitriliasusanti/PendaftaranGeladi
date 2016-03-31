/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fitrilia
 */
public class Aplikasi { 
    static int pilihan;
    static Scanner pil = new Scanner(System.in);    
    
    private List<Pembimbing> daftarPembimbing = new ArrayList<Pembimbing>();
    private List<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    private List<Lokasi> daftarLokasi = new ArrayList<Lokasi>();
    private List<Kelompok> daftarKelompok = new ArrayList<Kelompok>();
    // private List<Anggota> daftarAnggota = new ArrayList<Anggota>(); tambah anggota di kelompok ??
    
    // ----------- tambah ---------
    /*
        tambah lokasi
        tambah kelompok
        tambah anggota
    */
    public void addPembimbing(String nama, String jenisKelamin,
            String alamat, String telp, String nip, String kodeDosen) {                  
        Pembimbing pembimbing = new Pembimbing(nama, jenisKelamin, alamat, telp, nip, kodeDosen);        
        daftarPembimbing.add(pembimbing);        
    }
    
    public void addMahasiswa(String nama, String jenisKelamin, String alamat,
            String telp, String nim, String jurusan, Lokasi lok) {       
        Mahasiswa mhs = new Mahasiswa(nama, jenisKelamin, alamat, telp, nim, jurusan);        
        daftarMahasiswa.add(mhs);
        lok.getKota();
        lok.getNamaPerusahaan();
        Kelompok kel = new Kelompok(mhs);
        daftarKelompok.add(kel);
        lok.createKelompok(kel);
    }
    
/*
    public void addLokasi(String namaPerusahaan, String kota, Pembimbing nama) {
        Lokasi lokasi = new Lokasi(namaPerusahaan, kota);
        daftarLokasi.add(lokasi);
        nama.createLokasi(lokasi);
    }        
    
    public void addKelompok (Mahasiswa mhs, Lokasi lok) {
        Kelompok kel = new Kelompok(mhs);
        daftarKelompok.add(kel);
        lok.createKelompok(kel);
    }
*/
    
    //---------- get ----------
    public Mahasiswa getMahasiswa(String nim) {
        for (int i=0; i<daftarMahasiswa.size(); i++) {
            Mahasiswa mhs = daftarMahasiswa.get(i);
            if (nim.equals(mhs.getNim())) {
                return mhs;
            }
        }
        return null;
    }
    
    public Pembimbing getPembimbing(String nip) {
        for (int i=0; i<daftarPembimbing.size(); i++) {
            Pembimbing pem = daftarPembimbing.get(i);
            if(nip.equals(pem.getNip())) {
                return pem;
            }
        }
        return null;
    }
       
    
    // --------- hapus ---------
    /*
    *   hapus kelompok
        hapus anggota
    */
    public void deleteMahasiswa(String nim) {
        for (int i=0; i<daftarMahasiswa.size(); i++) {
            Mahasiswa mhs = daftarMahasiswa.get(i);
            if(nim.equals(mhs.getNim())) {
                daftarMahasiswa.remove(i);
            }
        }
    }
    
    public void deletePembimbing(String nip) {
        for (int i=0; i<daftarPembimbing.size(); i++) {
            Pembimbing pem = daftarPembimbing.get(i);
            if(nip.equals(pem.getNip())) {
                daftarPembimbing.remove(i);
            }
        }
    }                
    
    public void mainMenu() {                
        Scanner in = new Scanner(System.in);
        String username , password;
        System.out.print("Username : ");
            username = in.next();
        System.out.print("Password : ");
            password = in.next();
        
        if(username.equals("admin") && password.equals("admin")){
            System.out.println("=== Hai Admin ===");
            System.out.println("SELAMAT DATANG APLIKASI PENDAFTARAN GELADI");
            System.out.println("1. Data Pembimbing");
            System.out.println("2. Data Kelompok");            
                      
            System.out.print("Pilihan : ");            
                pilihan = pil.nextInt();
                if (pilihan == 1) {
                    pembimbing();                        
                }
                else if (pilihan == 2) {
                    System.out.println("hai belum");
                }
        } else if (username.equals("mahasiswa") && password.equals("mahasiswa")) {
            System.out.println("=== Hai Mahasiswa ===");
            System.out.println("SELAMAT DATANG APLIKASI PENDAFTARAN GELADI");
            System.out.println("1. Pendaftaran Geladi");
            System.out.println("2. View Data Kelompok");
            System.out.println("3. View Data Lokasi dan Perusahaan");
            System.out.println("4. Tambah Anggota Kelompok");
            
            System.out.print("Pilihan : ");
                pilihan = pil.nextInt();
                switch(pilihan) {
                    case 1 : pendaftaranGeladi();
                    break;
                    case 2 : viewKelompok();
                    break;
                    case 3 : viewLokasi();
                    break;
                    case 4 : tambahAnggota();
                    break;
                }
        }
    }
    /*_________________________ADMIN_________________________*/
    
    // ------------------- ADMIN PEMBIMBING---------------------------
    public void pembimbing() {        
        System.out.println();
        System.out.println("---MENU DATA PEMBIMBING---");
        System.out.println("1. View Data Pembimbing");
        System.out.println("2. Tambah Pembimbing");
        System.out.println("3. Hapus Pembimbing");        
        System.out.print("Pilihan : ");
        pilihan = pil.nextInt();        
        switch(pilihan) {
            case 1 : viewPembimbing();
            break;
            case 2 : tambahPembimbing();
            break;
            case 3 : hapusPembimbing();
            break;
            
        }
    }
                
    public void viewPembimbing() {
        for(int i=0; i<daftarPembimbing.size(); i++) {
            Pembimbing pem = daftarPembimbing.get(i);            
            System.out.println("NIP : "+pem.getNip());
            System.out.println("Kode Dosen : "+pem.getKodeDosen());
            System.out.println("Nama : "+pem.getNama());
            System.out.println("Jenis Kelasmin : "+pem.getJenisKelamin());
            System.out.println("Telp : "+pem.getTelp());            
            System.out.println("Alamat : "+pem.getAlamat());
        }
        pembimbing();
    }
    
    public void tambahPembimbing() {
        System.out.println("--- Tambah Pembimbing ---");
        Scanner in = new Scanner(System.in);
        String nip, nama, telp, jenisKelamin,alamat,kodeDosen;
        System.out.print("1. NIP : ");
            nip = in.next();
        System.out.print("2. Nama : ");
            nama = in.next();
        System.out.print("3. Telp : ");
            telp = in.next();
        System.out.print("4. Jenis Kelamin : ");
            jenisKelamin = in.next();
        System.out.print("5. Alamat : ");
            alamat  = in.next();
        System.out.print("6. Kode Dosen : ");
            kodeDosen = in.next();                   
        
        addPembimbing(nama,jenisKelamin,alamat,telp,nip,kodeDosen);
        pembimbing();        
    }
    
    public void hapusPembimbing() {
        System.out.println("--- Hapus Pembimbing ---");
        Scanner scanner = new Scanner(System.in);        
        String nip;
        System.out.println("Masukkan NIP : ");
            nip = scanner.next();
        for(int i=0; i<daftarPembimbing.size(); i++) {
            Pembimbing pem = daftarPembimbing.get(i);            
            if(nip.equals(pem.getNip())) {
                System.out.println("NIP : "+pem.getNip());
                System.out.println("Kode Dosen : "+pem.getKodeDosen());
                System.out.println("Nama : "+pem.getNama());
                System.out.println("Jenis Kelasmin : "+pem.getJenisKelamin());
                System.out.println("Telp : "+pem.getTelp());            
                System.out.println("Alamat : "+pem.getAlamat());
                
                System.out.println();
                System.out.println("Yakin di hapus ? Y/N" );
                String hapus;
                hapus = scanner.next();
                if(hapus.equals("Y")) {
                    deletePembimbing(nip);
                    System.out.println("BERHASIL DI HAPUS");
                    pembimbing();
               } else if(hapus.equals("N")){
                   viewPembimbing();
               }
            }            
        }        
    }
    
// ------------------- ADMIN KELOMPOK---------------------------
    public void kelompok() {  
        System.out.println();
        Mahasiswa mhs = null;
        System.out.println("---MENU DATA KELOMPOK---");
        System.out.println("1. View Data Kelompok");
        System.out.println("2. Tambah Kelompok");
        System.out.println("3. Hapus Kelompok");        
        System.out.println("4. Tambah Anggota");
        System.out.println("5. Hapus Anggota");
        System.out.print("Pilihan : ");
        pilihan = pil.nextInt();        
        switch(pilihan) {            
            case 1 : viewKelompok();
            break;
            /*
            case 2 : tambahKelompok();
            break;
            case 3 : hapusKelompok();
            break;
            case 4 : tambahAnggota();
            break;
            case 5 : hapusAnggota();
            break;
            */
            
        }
    }
    
    public void viewKelompok() {   
        System.out.println();
        for(int i=0; i<daftarKelompok.size(); i++) {
            Kelompok kel = daftarKelompok.get(i);            
            for (int j=0; j<kel.getJmlKelompok(); j++) {
                System.out.println("Kelompok : "+(j+1));
                for (int k=0; k<kel.getJmlMhs(); j++ ) {
                    Mahasiswa m = kel.getAnggotabyIndex(j);                
                    System.out.println("----- Anggota Kelompok -----");
                    System.out.println("Nama : "+m.getNama());
                    System.out.println("Jurusan : "+m.getJurusan());
                }  
            }
        kelompok();
        }
    }
    
    public void tambahKelompok() {
//        System.out.println(); 
//        System.out.println("--- Tambah Kelompok ---");
//        Scanner in = new Scanner(System.in);        
//        
//        String nama, jenisKelamin, alamat, telp, nim, jurusan, kota, namaPerusahaan;
//        System.out.println("Lokasi : ");
//            kota = in.next();
//        System.out.println("Nama Perusahaan : ");
//            namaPerusahaan = in.next();
//        System.out.print("1. NIM : ");
//            nim = in.next();
//        System.out.print("2. Nama : ");
//            nama = in.next();
//        System.out.print("3. Jurusan : ");
//            jurusan = in.next();
//        System.out.print("4. Jenis Kelamin : ");
//            jenisKelamin = in.next();
//        System.out.print("5. Alamat : ");
//            alamat  = in.next();
//        System.out.print("6. Telp : ");
//            telp = in.next();                   
//        
//        addKelompok();
//        pembimbing();        
    }
    
    /*_________________________MAHASISWA_________________________*/
    
    public void pendaftaranGeladi() {
        System.out.println();
                
        System.out.println("--- PENDAFTARAN GELADI ---");
        Scanner in = new Scanner(System.in);
        String nim, nama, jurusan, jk, alamat, telp, lokasi, perusahaan;
        
        System.out.println("NIM : ");
            nim = in.next();
        System.out.println("Nama : ");
            nama = in.next();
        System.out.println("Jurusan : ");
            jurusan = in.next();
        System.out.println("Jenis Kelamin : ");
            jk = in.next();
        System.out.println("Alamat : ");
            alamat = in.next();
        System.out.println("Telp : ");
            telp = in.next();
        System.out.println("Lokasi : ");
            lokasi = in.next();
        System.out.println("Perusahaan : ");
            perusahaan = in.next();        
            
        //addMahasiswa(nama, perusahaan, alamat, telp, nim, jurusan, lok);
    }
    
    public void viewLokasi() {}
    
    public void tambahAnggota() {}
}
