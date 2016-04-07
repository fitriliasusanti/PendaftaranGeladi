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
    static Scanner scanner = new Scanner(System.in);
    static Scanner in = new Scanner(System.in);
    
    private List<Pembimbing> daftarPembimbing = new ArrayList<Pembimbing>();
    private List<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    private List<Lokasi> daftarLokasi = new ArrayList<Lokasi>();
    private List<Kelompok> daftarKelompok = new ArrayList<Kelompok>();    
    
    /* ---------------------------- fungsional add --------------------------- */
 
    public void addPembimbing(String nama, String alamat, String telp, String nip, String kodeDosen) {
        Pembimbing pembimbing = new Pembimbing(nama, alamat, telp, nip, kodeDosen);
        daftarPembimbing.add(pembimbing);
    }

    public void addMahasiswa(String nama, String alamat,
            String telp, String nim, String fakultas, String jurusan) {
        Mahasiswa mhs = new Mahasiswa(nama, alamat, telp, nim, fakultas, jurusan);
        daftarMahasiswa.add(mhs);
    }

    public void addKelompok(int nomerKel, String lokasi, String namaPerusahaan,
            String namaPembimbing) {
        Lokasi lok = new Lokasi(nomerKel, lokasi, namaPerusahaan, namaPembimbing);
        daftarLokasi.add(lok);
    }
      
    
    /*---------------------------- fungsional get --------------------------------*/
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
    
    public Lokasi getLokasi(String namaPerusahaan) {
        for (int i=0; i<daftarLokasi.size(); i++) {
            Lokasi lok = daftarLokasi.get(i);
            if (namaPerusahaan.equals(lok.getNamaPerusahaan())) {
                return lok;
            }
        }
        return null;
    }
    
    public Kelompok getKelompok(int nomer) {
        for (int i=0; i<daftarKelompok.size(); i++) {
            Kelompok kel = daftarKelompok.get(i);
            if (kel.getNomerKelompok() == nomer) {
                return kel;
            }
        }
        return null;
    }
       
    
    /*---------------------------- fungsional hapus --------------------------------*/
   
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
    
    public void deleteKelompok(int nomer) {
        for (int i=0; i<daftarKelompok.size(); i++) {
            Kelompok kel = daftarKelompok.get(i);
            if (kel.getNomerKelompok() == nomer) {
                daftarKelompok.remove(i);
            }
        }
    }  
    
    public void deleteLokasi(String kota) {
        for (int i=0; i<daftarLokasi.size(); i++) {
            Lokasi lok = daftarLokasi.get(i);
            if(lok.getKota()==kota) {
                daftarLokasi.remove(i);
            }
        }
    }
    
    /*---------------------------- menu-menu --------------------------------*/
    
    public void mainMenu() {                        
        String username , password;
        System.out.print("Username : ");
            username = in.next();
        System.out.print("Password : ");
            password = in.next();
        
        if(username.equals("admin") && password.equals("admin")){
            admin();
            
        } else if (username.equals("mahasiswa") && password.equals("mahasiswa")) {
            mahasiswa();
        }
    }
        
    public void admin() {
        System.out.println("=== Hai Admin ===");
        System.out.println("SELAMAT DATANG APLIKASI PENDAFTARAN GELADI");
        System.out.println("1. Data Pembimbing");
        System.out.println("2. Data Kelompok");      
        System.out.println("3. Logout");
                      
        System.out.print("Pilihan : ");            
            pilihan = pil.nextInt();
            if (pilihan == 1) {
                pembimbing();                        
            }
            else if (pilihan == 2) {
                kelompok();
            }
            else if (pilihan == 3) {
                System.out.println("LOGOUT"); //belum
            }
    }
    
    public void mahasiswa() {
        System.out.println("=== Hai Mahasiswa ===");
        System.out.println("SELAMAT DATANG APLIKASI PENDAFTARAN GELADI");
        System.out.println("1. Pendaftaran Geladi");                
        System.out.println("2. Tambah Anggota Kelompok");
        System.out.println("3. Logout");
            
        System.out.print("Pilihan : ");
            pilihan = pil.nextInt();
            switch(pilihan) {                
                case 1 : pendaftaranGeladi();
                break;                
                case 2 : tambahAnggotaKelompok();
                break;
         }
    }
    
    /*________________________________ADMIN_________________________________*/
    // ------------------- ADMIN DATA PEMBIMBING---------------------------
    public void pembimbing() {        
        System.out.println();
        System.out.println("---MENU DATA PEMBIMBING---");
        System.out.println("1. View Data Pembimbing");
        System.out.println("2. Tambah Pembimbing");
        System.out.println("3. Hapus Pembimbing");  
        System.out.println("4. Exit");
        System.out.print("Pilihan : ");
        pilihan = pil.nextInt();        
        switch(pilihan) {
            case 1 : viewPembimbing();
            break;
            case 2 : tambahPembimbing();
            break;
            case 3 : hapusPembimbing();
            break;
            case 4 : admin();
            break;
        }
    }
                
    public void viewPembimbing() {
        if (daftarPembimbing.isEmpty()) {
            System.out.println("BELUM ADA DATA PEMBIMBING");
        }
        else {            
                System.out.println("Data Pembimbing");
                for(int i=0; i<daftarPembimbing.size(); i++) {
                Pembimbing pem = daftarPembimbing.get(i);            
                System.out.println("NIP : "+pem.getNip());
                System.out.println("Kode Dosen : "+pem.getKodeDosen());
                System.out.println("Nama : "+pem.getNama());            
                System.out.println("Telp : "+pem.getTelp());            
                System.out.println("Alamat : "+pem.getAlamat());
            }
        }        
        pembimbing();
    }
    
    public void tambahPembimbing() {
        System.out.println("--- Tambah Pembimbing ---");
        Scanner in = new Scanner(System.in);
        Pembimbing pem=null;
        String nip, nama, telp,alamat,kodeDosen;
        System.out.print("NIP : ");
            nip = in.next();
        System.out.print("Nama : ");
            nama = in.next();
        System.out.print("Telp : ");
            telp = in.next();       
        System.out.print("Alamat : ");
            alamat  = in.next();
        System.out.print("Kode Dosen : ");
            kodeDosen = in.next();                   
        pem = new Pembimbing(nama, alamat, telp, nip, kodeDosen);
        daftarPembimbing.add(pem);
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
                System.out.println("Telp : "+pem.getTelp());            
                System.out.println("Alamat : "+pem.getAlamat());
                
                System.out.println();
                System.out.println("Yakin di hapus ? Y/N" );
                String hapus;
                hapus = scanner.next();
                if(hapus.equals("Y")) {
                    daftarPembimbing.remove(i);
                    System.out.println("BERHASIL DI HAPUS");
                    pembimbing();
               } else if(hapus.equals("N")){
                   viewPembimbing();
               }
            }            
        }        
    }
    
    /*____________________________BELUUUUUUMMMMMMMMMM_________________________*/
    
    // ------------------- ADMIN DATA KELOMPOK---------------------------
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
            case 2 : tambahKelompok();
            break;
            /*
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
        for (int i=0; i<daftarLokasi.size(); i++) {            
            Lokasi lok = daftarLokasi.get(i);
            for(int j=0; j<lok.getJmlKelompok(); j++) {
                System.out.println("Nama Pembimbing : "+lok.getPembimbing().getNama());
                System.out.println("Lokasi          : "+lok.getKota());
                System.out.println("Nomer Kelompok  : "+lok.getKelompok(j).getNomerKelompok());                
                Kelompok kel = daftarKelompok.get(j);
                for (int k=0; k<kel.getJmlAnggota(); k++) {
                    Mahasiswa mhs = kel.getAnggotabyIndex(k);                    
                    System.out.println("Nama    : "+ mhs.getNama());
                    System.out.println("Telp    : "+ mhs.getTelp());            
                    System.out.println("Alamat  : "+ mhs.getAlamat());                    
                }
            }
        }        
    }
    
    public void tambahKelompok() {        
        System.out.println("--- Tambah Kelompok ---");        
        
        int nomerKel;
        Pembimbing pem;
        String lokasi, namaPerusahaan, namaPembimbing, nama, alamat, telp, nim, fakultas, jurusan;        
        System.out.print("Lokasi          : ");
            lokasi = in.next();
        System.out.print("Nama Perusahaan : ");
            namaPerusahaan = in.next();
        System.out.print("Nama Pembimbing : ");
            namaPembimbing = in.next();  
            
            while (!daftarPembimbing.contains(namaPembimbing)) {
                System.out.print("Nama Pembimbing : ");
                namaPembimbing = in.next();
            }
                
        String pilihan = "Y";       
        int jmlAnggota =0;
        
        Kelompok kel=null;       
        while (pilihan.equals("Y") && jmlAnggota<5) {
            System.out.print("NIM        : ");
                nim = in.next();
            System.out.print("Nama       : ");
                nama = in.next();    
            System.out.print("Fakultas   : ");
                fakultas = in.next();
            System.out.print("Jurusan    : ");
                jurusan = in.next();
            System.out.print("Alamat     : ");
                alamat = in.next();
            System.out.print("Telp       : ");
                telp = in.next();
            jmlAnggota++;
            Mahasiswa mhs = new Mahasiswa(nama, alamat, telp, nim, fakultas, jurusan);
            daftarKelompok.add(kel);
            if (jmlAnggota == 1) {
                kel = new Kelompok(mhs);
            } else {                
                kel.addAnggota(mhs);
            }
            
            if (jmlAnggota < 5) {
                System.out.print("Tambah anggota ? (Y/N): ");
                pilihan = in.next();                
            }            
        }                        
        daftarKelompok.add(kel);
        kelompok();        
    }
    
    public void hapusKelompok() {
        System.out.println("--- Hapus Kelompok ---");        
        String lokasi, nomer;
        System.out.println("Masukkan Lokasi : ");
            lokasi = scanner.next();
        Lokasi lok=null;
        for(int i=0; i<daftarLokasi.size(); i++) {
            lok = daftarLokasi.get(i);
            if (lokasi.equals(lok.getKota())) {
                System.out.println("Lokasi : "+lok.getKota());
                System.out.println("Jumlah Kelompok : "+lok.getJmlKelompok());
                break;
            }
        }
        
        if(lokasi.equals(lok.getKota())) {        
            for (int j=0; j<lok.getJmlKelompok(); j++) {
                System.out.println("Nomer Kelompok : "+lok.getKelompok(j).getNomerKelompok());
            }
            System.out.println("Masukkan nomer kelompok : ");
                nomer = scanner.next();
            lok.removeKelompok(Integer.parseInt(nomer));
        }                                
    }
    
    public void tambahAnggota() {
        System.out.println("--- Tambah Anggota Kelompok  ---");                
        String nama, fakultas, alamat, telp,  nim,  jurusan, lokasi, nomer;                
        System.out.println("Masukkan lokasi : ");        
            lokasi = scanner.next();
        Lokasi lok=null;        
        for(int i=0; i<daftarLokasi.size(); i++) {
            lok = daftarLokasi.get(i);
            if(lokasi.equals(lok.getKota())) {
                System.out.println("Lokasi : "+lok.getKota());
            }
        }
        
        if (lokasi.equals(lok.getKota())) {
            for(int j=0; j<lok.getJmlKelompok(); j++) {
                if(lok.getKelompok(j).getJmlAnggota()<5) {
                    System.out.println("Nomer Kelompok : "+lok.getKelompok(j).getNomerKelompok());
                    System.out.println("Jumlah Anggota : "+lok.getKelompok(j).getJmlAnggota());
                }                
            }
            System.out.println("Masukkan nomer kelompok :  ");
                nomer = scanner.next();            
            
            String pilihan = "Y";       
            int j = 0;
            int jmlAnggota = lok.getKelompok(j).getJmlAnggota(); // harusnya sesuai jumlah index terakhir
            Kelompok kel=null;        
            while (pilihan.equals("Y") && jmlAnggota<5) {
                System.out.print("NIM        : ");
                    nim = in.next();
                System.out.print("Nama       : ");
                    nama = in.next();    
                System.out.print("Fakultas   : ");
                    fakultas = in.next();
                System.out.print("Jurusan    : ");
                    jurusan = in.next();
                System.out.print("Alamat     : ");
                    alamat = in.next();
                System.out.print("Telp       : ");
                    telp = in.next();
                jmlAnggota++;
                Mahasiswa mhs = new Mahasiswa(nama, alamat, telp, nim, fakultas, jurusan);                
                if (jmlAnggota < 5) {
                    System.out.print("Tambah anggota ? (Y/N): ");
                    pilihan = in.next();                
                }                                  
            }
            daftarKelompok.add(kel);
        }
        pembimbing();        
    }
    
    public void hapusAnggota() /* belum */ { 
        System.out.println("--- Hapus Anggota Kelompok  ---");                
        String nama, fakultas, alamat, telp,  nim,  jurusan, lokasi, nomer;                
        System.out.println("Masukkan lokasi : ");        
            lokasi = scanner.next();
        Lokasi lok=null;        
        for(int i=0; i<daftarLokasi.size(); i++) {
            lok = daftarLokasi.get(i);
            if(lokasi.equals(lok.getKota())) {
                System.out.println("Lokasi : "+lok.getKota());
                System.out.println("Jumlah Kelompok : "+lok.getJmlKelompok());
                System.out.println("--- Data - data kelompok ---");
                break;
            }
        }
        
        if (lokasi.equals(lok.getKota())) {
            for(int j=0; j<lok.getJmlKelompok(); j++) {                
                System.out.println("Nomer Kelompok : "+lok.getKelompok(j).getNomerKelompok());
                Kelompok kel = daftarKelompok.get(j);
                for (int k=0; k<kel.getJmlAnggota(); k++) {                                        
                    Mahasiswa mhs = kel.getAnggotabyIndex(k);                    
                    System.out.println("Nama    : "+ mhs.getNama());
                    System.out.println("Telp    : "+ mhs.getTelp());            
                    System.out.println("Alamat  : "+ mhs.getAlamat());                     
                }            
            }    
            System.out.println("Masukkan nomer kelompok :  ");
                nomer = scanner.next();      
            // looping anggota
            // hapus anggota
        }
    }        
    
    
    
    /*_________________________MAHASISWA_________________________*/

    public void pendaftaranGeladi() {
        System.out.println();
                
        System.out.println("--- PENDAFTARAN GELADI ---");
        Scanner in = new Scanner(System.in);
        String nim, nama, fakultas, jurusan, alamat, telp, lokasi, perusahaan;
        Kelompok kel=null;
        
        System.out.println("NIM : ");
            nim = in.next();
        System.out.println("Nama : ");
            nama = in.next();
        System.out.println("Fakultas : ");
            jurusan = in.next();
        System.out.println("Jurusan : ");
            fakultas = in.next();
        System.out.println("Alamat : ");
            alamat = in.next();
        System.out.println("Telp : ");
            telp = in.next();
        System.out.println("Lokasi : ");
            lokasi = in.next();
        System.out.println("Perusahaan : ");
            perusahaan = in.next();                
            
        daftarKelompok.add(kel);
    }
    
    public void tambahAnggotaKelompok() {/*--belum--*/
        System.out.println("--- Lihat Lokasi dan Perusahaan ---");                
        String nama, fakultas, alamat, telp,  nim,  jurusan, lokasi, nomer;                
        System.out.println("Masukkan lokasi : ");        
            lokasi = scanner.next();
        Lokasi lok=null;        
        for(int i=0; i<daftarLokasi.size(); i++) {
            lok = daftarLokasi.get(i);
            if(lokasi.equals(lok.getKota())) {
                System.out.println("Lokasi : "+lok.getKota());
                System.out.println("Nama Perusahaan : "+lok.getNamaPerusahaan());
            }
        }
        
        if (lokasi.equals(lok.getKota())) {
            for(int j=0; j<lok.getJmlKelompok(); j++) {
                if(lok.getKelompok(j).getJmlAnggota()<5) {
                    System.out.println("Nomer Kelompok : "+lok.getKelompok(j).getNomerKelompok());
                    System.out.println("Jumlah Anggota : "+lok.getKelompok(j).getJmlAnggota());
                }                
                else if (lok.getKelompok(j).getJmlAnggota()>=5) {
                    System.out.println("FULL");
                }
            }
            System.out.println("Masukkan nomer kelompok :  ");
                nomer = scanner.next();            
            
            String pilihan = "Y";       
            int j = 0;
            int jmlAnggota = lok.getKelompok(j).getJmlAnggota(); // harusnya sesuai jumlah index terakhir
            Kelompok kel=null;        
            while (pilihan.equals("Y") && jmlAnggota<5) {
                System.out.print("NIM        : ");
                    nim = in.next();
                System.out.print("Nama       : ");
                    nama = in.next();    
                System.out.print("Fakultas   : ");
                    fakultas = in.next();
                System.out.print("Jurusan    : ");
                    jurusan = in.next();
                System.out.print("Alamat     : ");
                    alamat = in.next();
                System.out.print("Telp       : ");
                    telp = in.next();
                jmlAnggota++;
                Mahasiswa mhs = new Mahasiswa(nama, alamat, telp, nim, fakultas, jurusan);                
                if (jmlAnggota < 5) {
                    System.out.print("Tambah anggota ? (Y/N): ");
                    pilihan = in.next();                
                }                                  
            }
            daftarKelompok.add(kel);
        }
        mahasiswa();        
    }           
}
