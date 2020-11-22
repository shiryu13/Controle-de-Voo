package controleaereo.entidades;
import java.io.Serializable;
import java.sql.Time;
/**
 *
 * @author garrien
 */
public class Horario extends Base implements Serializable{
    private Time hora;
    private float duracao;
    /*private Data data;*/
    
    public Time getHora(){
        return hora;
    }
    
    public void setHora(Time hora){
        this.hora = hora;
    }
    
    public float getDuracao(){
        return duracao;
    }
    
    public void setDuracao(float duracao){
        this.duracao = duracao;
    }
    
    /*public Data setData(){
        return data;
    }
    
    public void getData(Data data){
        this.data = data;
    }*/
}
