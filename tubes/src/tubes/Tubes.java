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
public class Tubes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String username , password;
//        System.out.println("Username : ");
//        username = in.nextLine();
//        System.out.println("Password : ");
//        password = in.nextLine();
//        if(username.equals("admin") && password.equals("admin")){
//            System.out.println("SELAMAT DATANG");
//            System.out.println("1. Data Pembimbing");
//            System.out.println("2. Tambah Pembimbing");            
//            System.out.println("3. Delete Pembimbing (soon)");
//            System.out.println("4. Tambah Kelompok");
//            System.out.println("5. --------");
//        }

        Pembimbing p = new Pembimbing("Pak abc", "laki-laki", "Bandung", "23456", 1, "ABC");
        System.out.println("FUNGSIONALITAS DATA PEMBIMBING");
        System.out.println("NIP : "+p.getNip());
        System.out.println("Nama Dosen : "+p.getNama());        
        System.out.println("Kode Dosen : "+p.getKodeDosen());
        System.out.println("Alamat : "+p.getAlamat());        
        System.out.println("Jenis Kelamin : "+p.getJenisKelamin());
        System.out.println("---------------------------");
        
        System.out.println();
        System.out.println("FUNGSIONALITAS DATA MAHASISWA");
        Mahasiswa m1 = new Mahasiswa("Lia", "perempuan", "Mojokerto", "08561234567", "1301144340", "IF");
        Mahasiswa m2 = new Mahasiswa("Fitri", "perempuan", "Mojokerto", "08561234567", "1301144340", "IF");
        Mahasiswa m3 = new Mahasiswa("Susanti", "perempuan", "Mojokerto", "08561234567", "1301144340", "IF");
        Mahasiswa m4 = new Mahasiswa("Minah", "perempuan", "Mojokerto", "08561234567", "1301144340", "IF");
        Mahasiswa m5 = new Mahasiswa("Siti", "perempuan", "Mojokerto", "08561234567", "1301144340", "IF");
        Mahasiswa m6 = new Mahasiswa("Hahaha", "perempuan", "Mojokerto", "08561234567", "1301144340", "IF");
        Mahasiswa m7 = new Mahasiswa("Hihihi", "perempuan", "Mojokerto", "08561234567", "1301144340", "IF");
        Mahasiswa m8 = new Mahasiswa("Hehehe", "perempuan", "Mojokerto", "08561234567", "1301144340", "IF");
        
        System.out.println("Nama : "+m1.getNama());
        System.out.println("---------------------------");
               
        Kelompok kel1 = new Kelompok(m1);
        kel1.addAnggota(m2);
        kel1.addAnggota(m3);        
        kel1.addAnggota(m4);
        kel1.getAnggota();
        
        Kelompok kel2 = new Kelompok(m5);
        
        kel2.addAnggota(m6);
        kel2.addAnggota(m7);
        kel2.addAnggota(m8);
        kel2.getAnggota();
                
        Lokasi l = new Lokasi("Telkomsel", "Bandung");
        l.setPembimbing(p);
        l.createKelompok(kel1); 
        l.createKelompok(kel2);
                
        
        
        System.out.println("-----DATA-DATA KELOMPOK-----");
        System.out.println("Lokasi : "+l.getKota());
        System.out.println("Perusahaan : "+l.getNamaPerusahaan());
        for (int i=0; i<l.getJmlKelompok(); i++) {
            Kelompok k = l.getKelompok(i);
            System.out.println("Kelompok : "+(i+1));
            for (int j=0; j<k.getJmlMhs(); j++ ) {
                Mahasiswa m = k.getAnggotabyIndex(j);                
                System.out.println("Anggota Kelompok : "+m.getNama());
            }            
        }        
    }    
}
