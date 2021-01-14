package Controller;
import Entity.DaftarPembeliEntity;
import Entity.PembeliEntity;
import Model.PembeliModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class PembeliController implements ControllerInterface{
    int indexLogin = 0;
    
    public PembeliController() {
    }
    
    public PembeliEntity getData() {
        return AllObjectModel.pembeliModel.getpembeliEntityArrayList(indexLogin);
    }
    
    public void DaftarPembeli(int indexCamera,  PembeliEntity pembeli,
            boolean isVerified) {
        AllObjectModel.daftarPembelimodel.insertDataPembeli(new 
        DaftarPembeliEntity (indexCamera,pembeli, isVerified));
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin = AllObjectModel.pembeliModel.cekData(id, nama);
    }
    
    public void insert(String id,String nama,
    String alamat, String noIdentitas,String notelp) {
        PembeliEntity pelangganModel = new PembeliEntity();
        pelangganModel.setid(id);
        pelangganModel.setnama(nama);
        pelangganModel.setalamat(alamat);
        pelangganModel.setnoIdentitas(noIdentitas);
        pelangganModel.setnotelp(notelp);
        AllObjectModel.pembeliModel.insert(pelangganModel);
    }

    public int cekDaftarPembeli(String id) {
        int cek = AllObjectModel.daftarPembelimodel.cekData(id, null);
        return cek;
    }
    
    public DaftarPembeliEntity showDaftarPembeli(int index) {
        return AllObjectModel.daftarPembelimodel.showDaftarPembeli(index);
    }
    public void deleteDataPembeli(int index) {
        AllObjectModel.daftarPembelimodel.hapusPembeliModel(index);
    }
    public ArrayList<DaftarPembeliEntity> cekDaftarPembeliModel() {
        return AllObjectModel.daftarPembelimodel.getdaftarpembeliArrayList();
    }
    public DefaultTableModel daftarpel(){
        DefaultTableModel dtmdaftarpel = new DefaultTableModel();
        Object[] kolom ={"Id","Nama","Alamat","No Pelanggan","No Telp","Tas","Verified"};
        dtmdaftarpel.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftarPembelimodel.alldatapembeli().size();
        String verif = null;
        for(int i=0;i<size;i++){
            if(AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).isIsVerified()==false){
                verif = "NO";
            }else{
                verif = "YES";
            }
            Object [] data = new Object[7];
            data[0] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getId();
            data[1] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getnama();
            data[2] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getalamat();
            data[3] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getnoIdentitas();
            data[4] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getnotelp();
            data[5] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getIndexTas();
            data[6] = verif;
            dtmdaftarpel.addRow(data);
    }
        return dtmdaftarpel;
    }

}
