package controleaereo.entidades;

import java.io.Serializable;

/**
 *
 * @author garrien
 */
public class Base implements Serializable{
    private int id;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
}
