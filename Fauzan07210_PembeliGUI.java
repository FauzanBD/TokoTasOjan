package View;
import Entity.TasEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class Fauzan07210_PembeliGUI {
    JFrame Pembeli = new JFrame();
    JButton back,daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftartas;
    JComboBox piltas = new JComboBox(TasEntity.tas);
    int cek = Fauzan07210_Allobjctrl.pembeli.cekDaftarPembeli
        (Fauzan07210_Allobjctrl.pembeli.getData().getId());
    
    public Fauzan07210_PembeliGUI(){
        Pembeli.setSize(720, 600);
        Pembeli.setLayout(null);
        Pembeli.getContentPane().setBackground(Color.RED);
        
        datadiri = new JLabel("Data Pembeli");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datadiri.setBounds(90, 30, 200, 30);
        Pembeli.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Pembeli.add(area);
        
        daftartas = new JLabel("Daftar Tas");
        daftartas.setBounds(450, 30, 250, 30);
        daftartas.setFont(new Font("Times New Roman",Font.BOLD,30));
        Pembeli.add(daftartas);
        piltas.setBounds(450, 90, 230, 30);
        Pembeli.add(piltas);
        
        daftarbtn = new JButton("Daftar Tas");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        Pembeli.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GRAY);
        Pembeli.add(back);
        
        Pembeli.setVisible(true);
        Pembeli.setLocationRelativeTo(null);
        Pembeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(cek==-1){
            JOptionPane.showMessageDialog(null, "Anda Belum Memilih Tas", "Information", JOptionPane.INFORMATION_MESSAGE);        
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Memilih Tas", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapembeli());
        }
        daftarbtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            int indexcamera = piltas.getSelectedIndex();
            Fauzan07210_Allobjctrl.pembeli.DaftarPembeli
            (indexcamera,Fauzan07210_Allobjctrl.pembeli.getData(), false);
            area.setText(datapembeli());
        }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Pembeli.dispose();
                Fauzan07210_GUI men = new Fauzan07210_GUI(); //nama objek menu
            }
        });
    }
    
    String datapembeli(){
        int cek = Fauzan07210_Allobjctrl.pembeli.cekDaftarPembeli
        (Fauzan07210_Allobjctrl.pembeli.getData().getId());
        String cekverif; //untuk verivikasi data berdasarkan id
        if(Fauzan07210_Allobjctrl.pembeli.showDaftarPembeli(cek).isIsVerified()==false){
            cekverif = "belum dibeli";
        }else{
            cekverif = "sudah dibeli";
        }
         String text = "Id = "+Fauzan07210_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getId()+"\n"
                +"Nama = "+Fauzan07210_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getnama()+"\n"
                +"Alamat = "+Fauzan07210_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getalamat()+"\n"
                +"No Antrian = "+Fauzan07210_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getnoIdentitas()+"\n"
                +"No Telp = "+Fauzan07210_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getnotelp()+"\n"
                +"Pembayar = "+cekverif+"\n"
                +"Data Tas = "+TasEntity.tas[Fauzan07210_Allobjctrl.pembeli.showDaftarPembeli(cek).getIndexTas()];
        return text;
    }
    }