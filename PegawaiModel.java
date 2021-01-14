package Model;
import Entity.AdminEntity;
import java.util.ArrayList;
public class PegawaiModel implements ModeIinterfaces{ 
    private  ArrayList <AdminEntity> PegawaiEntityArrayList;   
    public PegawaiModel(){
    PegawaiEntityArrayList = new ArrayList<AdminEntity>();
    }
    public void insertPegawai(AdminEntity pegawai){
        PegawaiEntityArrayList.add(pegawai);
    }
     @Override   
    public int cekData(String id, String nama){
        int loop = 0;
        for(AdminEntity pegawaiEntity : PegawaiEntityArrayList){
            if(pegawaiEntity.getId().equals(id) && pegawaiEntity.getnama().equals(nama)){
            break;
            }else{
                loop++;
            }
        }
        return loop;
   }
    public AdminEntity showDataPegawai(int index){
        return PegawaiEntityArrayList.get(index);
    }
}
