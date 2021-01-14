package Model; 
import Entity.DaftarPembeliEntity;
import Entity.TasEntity;
import Entity.AdminEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
public class DaftarPembeliModel implements ModeIinterfaces { 
    private ArrayList<DaftarPembeliEntity> daftarpembeliArrayList;
    public DaftarPembeliModel(){
    daftarpembeliArrayList = new ArrayList<DaftarPembeliEntity>();
        }
    public void insertDataPembeli(DaftarPembeliEntity daftarpembeli){
        daftarpembeliArrayList.add(daftarpembeli);
    }
    public ArrayList<DaftarPembeliEntity> getdaftarpembeliArrayList(){
        return daftarpembeliArrayList;
    }
    @Override 
    public int cekData(String id, String nama){
        int loop = 0;
        if(daftarpembeliArrayList.size() == 0){
            loop = -1;//data kosong
        }else{
            for(int i = 0; i <daftarpembeliArrayList.size(); i++){
            if(daftarpembeliArrayList.get(i).getPembeli().getId().equals(id)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
    public DaftarPembeliEntity showDaftarPembeli(int index){
        return daftarpembeliArrayList.get(index); //menampilkan data pelanggan
    }
    public void hapusPembeliModel(int index) {
        daftarpembeliArrayList.remove(daftarpembeliArrayList.get(index)); //mengapus data pelanggan
    }
    public void updateIsVerified(int index,DaftarPembeliEntity daftarpembeli){
    daftarpembeliArrayList.set(index, daftarpembeli); 
    }
    public ArrayList <DaftarPembeliEntity> alldatapembeli(){
        return  daftarpembeliArrayList;
    }
}
