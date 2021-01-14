package Model;
import Entity.TasEntity;
import Entity.PembeliEntity;
import Model.DaftarPembeliModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class PembeliModel implements ModeIinterfaces { 
    private ArrayList<PembeliEntity> pembeliEntityArrayList;
     
     public PembeliModel(){
        pembeliEntityArrayList = new ArrayList<PembeliEntity>();
    }
public void insert(PembeliEntity pembeliEntity){ //menambah data pelanggan
    pembeliEntityArrayList.add(pembeliEntity);  
}
public void hapusPembeliModel(int index) { //hapus data pelanggan 
        pembeliEntityArrayList.remove(pembeliEntityArrayList.get(index));
    }
 public int size() {
        return pembeliEntityArrayList.size();
    }
 @Override
    public int cekData(String id, String nama){
        int loop = 0;
        while (!pembeliEntityArrayList.get(loop).getId().equals(id) && 
                !pembeliEntityArrayList.get(loop).getnama().equals(nama)){
            loop++;
        }
        return loop;
    }
    public PembeliEntity getpembeliEntityArrayList(int index){ //
        return pembeliEntityArrayList.get(index);
    }
}
