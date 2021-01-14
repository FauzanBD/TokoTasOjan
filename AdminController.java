package Controller;
import Entity.AdminEntity;
import Entity.DaftarPembeliEntity;
import Entity.PembeliEntity;
import java.util.Date;
import java.util.ArrayList;
public class AdminController implements ControllerInterface{
    int indexLogin = 0;
    public AdminController() {    
    }
    
    public void datapegawai(){
        String id[] = {"01","02","03"};
        String nama [] = {"fauzan","bri","dandy"};
        String alamat [] = {"surabaya","surabaya","sidoarjo"};
        String noIdentitas [] = {"01","02","03"};
        String notelp [] = {"01","02","03"};
              for(int i=0;i<id.length;i++){
                AllObjectModel.pegawaiModel.insertPegawai(new 
                AdminEntity(id[i],nama[i],alamat[i],
                noIdentitas[i],notelp[i]));
            }
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin =  AllObjectModel.pegawaiModel.cekData(id, nama);
    }
    
    public AdminEntity PegawaiEntity() {
        return AllObjectModel.pegawaiModel.showDataPegawai(indexLogin);
    }
    
    public void updateIsVerified(int index,int indexPembeli,PembeliEntity pembeli ) {
        AllObjectModel.daftarPembelimodel.updateIsVerified(index, new 
        DaftarPembeliEntity(indexPembeli, pembeli,true));
    }
    
    public ArrayList<DaftarPembeliEntity> cekDaftarPembeliModel() {
        return AllObjectModel.daftarPembelimodel.getdaftarpembeliArrayList();
    }
}
