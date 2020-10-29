package Data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessaData {

    public String formatDateUser(String data){  
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");  
        Date d1 = null;  
        try {  
            d1 = f.parse(data);              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
          
        data = format.format(d1);  
          
        return data;         
          
    }
}