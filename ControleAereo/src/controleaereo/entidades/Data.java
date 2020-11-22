package controleaereo.entidades;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author garrien
 */
public class Data extends Base implements Serializable{
    private Date data;
    /*private Horario horario;*/
    
    public Date getData(){
        return data;
    }
    
    public void setData(Date data){
        this.data = data;
    }
    
    /*public Horario getHorario(){
        return horario;
    }
    
    public void setHorario(Horario horario){
        this.horario = horario;
    }*/
}
