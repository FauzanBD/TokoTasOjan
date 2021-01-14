package Main;
import Entity.TasEntity;
import Entity.DaftarPembeliEntity;
import Model.DaftarPembeliModel;
import Controller.AdminController;
import Controller.AllObjectModel;
import Controller.PembeliController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner; 
import View.Fauzan07210_GUI;

public class main {
    private static AdminController pegawaiModel = new AdminController(); 
    private static PembeliController pembeliModel = new PembeliController();
    private static Scanner input = new Scanner (System.in);

    public static void main(String[] args){ 
        main data = new main();
        data.view(); 
    }
    void view(){
    do {
            int pilih;
            System.out.println("Menu\n" +
                    "1. Console\n" +
                    "2. GUI\n" +
                    "Masukkan Pilihan Anda : ");
            pilih = input.nextInt();

            switch (pilih){
                case 1:
                    viewMenu();
                    break;
                case 2:
                    GUI();
                    break;
                default:
                    break;
            }
        }while (true);
    }
    
    void GUI(){
        Fauzan07210_GUI gui = new Fauzan07210_GUI();
    }
    
    void viewMenu(){
        int loop = 0;
        int pilih = 0;
        int pilLogin = 0;
        pegawaiModel.datapegawai();
        do{
           System.out.print("Selamat Datang Di TOKO TAS OJAN !!" +
                            "\n 1. Login" +
                            "\n 2. Daftar Pelanggan" +
                            "\n 3. Hapus Pelanggan"+
                            "\n 4. Lihat Pelanggan"+
                            "\n 5. Close"+
                            "\n Masukkan Pilihan Anda : ");
                        pilih = input.nextInt();
                        if(pilih == 1){
            System.out.print("1. Login Pegawai" + "\n2. Login pelanggan" + "\n Pilih : ");
                pilLogin = input.nextInt();
                if(pilLogin == 1){
                    loginPegawai();  
                }else{
                    loginPembeli();
                }
            }else if(pilih == 2){
                register();
            }else if(pilih == 3){
                viewHapusDataPembeli();
            }else if(pilih == 4){
                if (pegawaiModel.cekDaftarPembeliModel().size() == 0) {
                System.out.println("Data Masih Kosong !!!");
                } else{
                viewDataPembeli();
                }
            }else if(pilih == 5){
                view();
            }else{
                break;
            }
        }while (loop != 1);
    }
     
        void register(){
                System.out.print("Input ID = ");
                String id = input.next();
                System.out.print("Input nama = ");
                String nama = input.next();
                System.out.print("Input Alamat = ");
                String alamat = input.next();
                System.out.print("Input No Pelanggan = ");
                String noIdentitas =  input.next();
                System.out.print("Input No Telepon = ");
                String notelp =  input.next();
                pembeliModel.insert(id,nama,alamat,noIdentitas,notelp);
                System.out.println("Daftar Sukses !!");
        }
        
        static void registerPembeli() {
        System.out.println("Pilih Tas : ");
        for (int i = 0; i < TasEntity.tas.length; i++) {
            System.out.println((i) + " " + TasEntity.tas[i]);
        }
        int pilPrak = input.nextInt();
        pembeliModel.DaftarPembeli(pilPrak, pembeliModel.getData(), false);
        
    }
        
        void viewDataPembeli() {
        int i=0;
        for (DaftarPembeliEntity pembeli : pembeliModel.cekDaftarPembeliModel()) {
                System.out.println("Data Ke - : "+i);
                System.out.println("Id : " + pembeliModel.showDaftarPembeli(i).getPembeli().getId());
                System.out.println("Nama = "+pembeliModel.showDaftarPembeli(i).getPembeli().getnama());
                System.out.println("No Antrian = "+pembeliModel.showDaftarPembeli(i).getPembeli().getnoIdentitas());
                System.out.println("No telp = "+pembeliModel.showDaftarPembeli(i).getPembeli().getnotelp());
                System.out.println("Tas = "+TasEntity.tas[pembeliModel.showDaftarPembeli(i).getIndexTas()]);
                System.out.println("isVerified = ");
                if (pembeliModel.showDaftarPembeli(i).isIsVerified() == false) {
                    System.out.print("Belum Di Verifikasi pegawai\n");
                    System.out.print("===========================\n");
                } else {
                    System.out.print("Telah Di Verifikasi pegawai\n");
                    System.out.print("===========================\n");
                }         
            i++;
        }
    }
        
        void loginPembeli(){
        System.out.print("ID : ");
        String id = input.next();
        System.out.print("Nama : ");
        String nama = input.next();
        try {
        pembeliModel.login(id, nama);
        System.out.println("Selamat datang "+pembeliModel.getData().getnama());
        int cekpembeli = pembeliModel.cekDaftarPembeli(pembeliModel.getData().getId());
        if (cekpembeli == -1){
            System.out.println("Anda belum memilih tas");
                registerPembeli();
        }else if(cekpembeli == -2){
            System.out.println("Anda belum memilih tas");
                registerPembeli();
        }else{
        System.out.println("Nama = "+pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getnama());
        System.out.println("id = "+pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getId());
        System.out.println("No Pelanggan = "+pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getnoIdentitas());
        System.out.println("No telp = "+pembeliModel.showDaftarPembeli(cekpembeli).getPembeli().getnotelp());
        System.out.println("Tas = "+TasEntity.tas[pembeliModel.showDaftarPembeli(cekpembeli).getIndexTas()]);
        System.out.println("isVerified = ");
         if (pembeliModel.showDaftarPembeli(cekpembeli).isIsVerified() == false) {
                System.out.print("Belum Di Verifikasi pegawai\n");
            } else {
                System.out.print("Telah Di Verifikasi pegawai\n");
            }
        
        }} catch (Exception e) {
            System.out.println("id atau nama Anda Salah !!!");
        }
    }
        
        void loginPegawai(){
        System.out.print("id : ");
        String id = input.next();
        System.out.print("nama: ");
        String nama = input.next();
        try {
            pegawaiModel.login(id, nama);
            System.out.println("Selamat Datang " + pembeliModel.getData().getnama() + " Id "
                    + pembeliModel.getData().getId());
            if (pembeliModel.cekDaftarPembeliModel().size() == 0) {
                System.out.println("Data Masih Kosong !!!");
            } else{
                viewDataPembeli();
                updateIsVerified();
            }
        } catch (Exception e) {
            System.out.println("id atau nama Anda Salah !!!");
        }
    }
         
        void updateIsVerified() {
        System.out.println("id Pelanggan : ");
        String id = input.next();
        System.out.println("=======================");
        int index = AllObjectModel.daftarPembelimodel.cekData(id, null);
        pegawaiModel.updateIsVerified(index, pembeliModel.showDaftarPembeli(index).getIndexTas(),pembeliModel.showDaftarPembeli(index).getPembeli());
    }
        
        void viewHapusDataPembeli() {
        viewDataPembeli();
        System.out.print("Pilih Data Ke - : ");
        int index = input.nextInt();
        pembeliModel.deleteDataPembeli(index);
        System.out.println("Data Berhasil Dihapus");
    }   
}