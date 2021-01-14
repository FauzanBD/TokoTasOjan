package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
public class Fauzan07210_GUI {
    JFrame TampilanAwal = new JFrame();//tampilan awal
    JLabel login,daftar,top; 
    JRadioButton radioPegawai,radiopembeli; //tombol pilihan
    JTextField textidlogin,textnamalogin,textalamat,textnopelanggan,textnotelp,textiddaftar,textnamadaftar;
    JLabel labelidlogin,labelnamalogin,labelalamat,labelnopelanggan,labelnotelp,labeliddaftar,labelnamadaftar;
    JButton check,reg; //tombol
    
    private boolean ceklogin = false;
    public Fauzan07210_GUI(){ 
        TampilanAwal.setSize(700, 830); //ukuran 
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.GREEN); //warna background
        
        top = new JLabel("====TOKO TAS OJAN====");
        top.setBounds(50, 10, 600, 50); 
        top.setFont(new Font("Times New Roman",Font.BOLD,40));
        TampilanAwal.add(top);
        
        login = new JLabel("LOGIN");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman",Font.BOLD,30));
        TampilanAwal.add(login);
        
        radioPegawai = new JRadioButton("Pegawai");
        radioPegawai.setBounds(30, 150, 100, 30);
        radioPegawai.setBackground(Color.RED);
        TampilanAwal.add(radioPegawai);
        
        radiopembeli = new JRadioButton("Pembeli");
        radiopembeli.setBounds(140, 150, 100, 30);
        radiopembeli.setBackground(Color.RED);
        TampilanAwal.add(radiopembeli);
        
        labelidlogin = new JLabel("Id");
        labelidlogin.setBounds(30, 180, 30, 30);
        TampilanAwal.add(labelidlogin);
        textidlogin = new JTextField();
        textidlogin.setBounds(30, 210, 200, 30);
        TampilanAwal.add(textidlogin);
        
        labelnamalogin = new JLabel("Nama");
        labelnamalogin.setBounds(30, 240, 100, 30);
        TampilanAwal.add(labelnamalogin);
        textnamalogin = new JTextField();
        textnamalogin.setBounds(30, 270, 200, 30);
        TampilanAwal.add(textnamalogin);
        
        check = new JButton("CHECK");
        check.setBounds(90, 320, 100, 40);
        check.setBackground(Color.RED);
        TampilanAwal.add(check);
        
        daftar = new JLabel("DAFTAR");
        daftar.setFont(new Font("Times New Roman",Font.BOLD,30));
        daftar.setBounds(440, 50, 150, 100);
        TampilanAwal.add(daftar);
        
        labeliddaftar = new JLabel("Id");
        labeliddaftar.setBounds(400, 150, 30, 30);
        TampilanAwal.add(labeliddaftar);
        textiddaftar = new JTextField();
        textiddaftar.setBounds(400, 180, 200, 30);
        TampilanAwal.add(textiddaftar);
        
        labelnamadaftar = new JLabel("Nama Pembeli");
        labelnamadaftar.setBounds(400, 210, 100, 30);
        TampilanAwal.add(labelnamadaftar);
        textnamadaftar = new JTextField();
        textnamadaftar.setBounds(400, 240, 200, 30);
        TampilanAwal.add(textnamadaftar);
        
        labelalamat = new JLabel("Alamat Pembeli");
        labelalamat.setBounds(400, 270, 100, 30);
        TampilanAwal.add(labelalamat);
        textalamat = new JTextField();
        textalamat.setBounds(400, 300, 200, 30);
        TampilanAwal.add(textalamat);
        
        labelnopelanggan = new JLabel("No Antrian");
        labelnopelanggan.setBounds(400, 330, 100, 30);
        TampilanAwal.add(labelnopelanggan);
        textnopelanggan = new JTextField();
        textnopelanggan.setBounds(400, 360, 200, 30);
        TampilanAwal.add(textnopelanggan);
        
        labelnotelp = new JLabel("No Telepon");
        labelnotelp.setBounds(400, 390, 200, 30);
        TampilanAwal.add(labelnotelp);
        textnotelp = new JTextField();
        textnotelp.setBounds(400, 420, 200, 30);
        TampilanAwal.add(textnotelp);
        
     
        
        reg = new JButton("DAFTAR");
        reg.setBounds(460, 480, 100, 40);
        reg.setBackground(Color.RED);
        TampilanAwal.add(reg);
        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal.setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);
        radioPegawai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //method pegawai
                if(radioPegawai.isSelected()){
                    radiopembeli.setSelected(false);
                    ceklogin=true;
                }
            }
        });
        
        radiopembeli.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk pembeli
                if(radiopembeli.isSelected()){
                    radioPegawai.setSelected(false);//untuk pegawai false
                    ceklogin=false;
                }
            }
        });
        
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //method
                if(ceklogin==true){
                    try{ 
                        Fauzan07210_Allobjctrl.admin.datapegawai(); // login untuk pegawai
                        Fauzan07210_Allobjctrl.admin.login(textidlogin.getText(), textnamalogin.getText());
                        String nama = Fauzan07210_Allobjctrl.admin.PegawaiEntity().getnama(); //memasukkan id,nama, jika benar 
                        JOptionPane.showMessageDialog(null, "Selamat datang "+nama,"information", JOptionPane.INFORMATION_MESSAGE);
                        Fauzan07210_PegawaiGUI pegawai = new Fauzan07210_PegawaiGUI();
                        TampilanAwal.dispose();
                    }catch(Exception exception){ //jika id/nama salah makan akan muncul pesan
                        JOptionPane.showMessageDialog(null, "id atau nama salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    }
                        kosong();//method kosong, jika datanya kosong
                }else{
                    try{ //login untuk pembeli
                       Fauzan07210_Allobjctrl.pembeli.login(textidlogin.getText(),textnamalogin.getText());
                       String nama = Fauzan07210_Allobjctrl.pembeli.getData().getnama(); //memasukkan id,nama, jika benar 
                       JOptionPane.showMessageDialog(null, "Selamat datang "+nama,"information", JOptionPane.INFORMATION_MESSAGE);
                       Fauzan07210_PembeliGUI  pel = new Fauzan07210_PembeliGUI();
                       TampilanAwal.dispose();
                    }catch(Exception eception){ //jika id/nama salah makan akan muncul pesan
                        JOptionPane.showMessageDialog(null, "id atau nama salah", "information", JOptionPane.INFORMATION_MESSAGE);
                       kosong(); //method kosong, jika datanya kosong
                    }
                }
            }
        });
        
        reg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    String id = textiddaftar.getText(); //regristasi
                    String nama = textnamadaftar.getText();
                    String alamat = textalamat.getText();
                    String nopelanggan = textnopelanggan.getText();
                    String notelp = textnotelp.getText();
                    Fauzan07210_Allobjctrl.pembeli.insert(id, nama, alamat, nopelanggan, notelp); //jika sukses
                    JOptionPane.showMessageDialog(null, "Registrasi sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
       void kosong(){
        textiddaftar.setText(null);//settext null semua
        textnamadaftar.setText(null);
        textalamat.setText(null);
        textnopelanggan.setText(null);
        textnotelp.setText(null);
        textidlogin.setText(null);
        textnamalogin.setText(null);
    }
}
