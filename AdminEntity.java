package Entity;
import java.util.Date;
public class AdminEntity extends Jualbelitas{ 
    public AdminEntity(String id,String nama,
    String alamat, String noIdentitas,String notelp){
        super(id,nama,alamat,noIdentitas,notelp); 
}
    
 @Override 
    public String getId() {
        return id;
    }
}

