package controleaereo.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
/**
 *
 * @author garrien
 */
public class CadRota  extends Base implements Serializable {
    private Aviao aviao;
    private Origem origem;
    private Destino destino;
    private Date data;
    private Time hora;
    private float duracao;
    
    public Aviao getAviao(){
        return aviao;
    }
    public void setAviao(Aviao aviao){
        this.aviao = aviao;
    }
    
    public Origem getOrigem(){
        return origem;
    }
    
    public void setOrigem (Origem origem){
        this.origem = origem;
    }
    
    public Destino getDestino(){
        return destino;
    }
    
    public void setDestino(Destino destino){
        this.destino = destino;
    }
    
    public Date getData(){
        return data;
    }
    
    public void setData(Date data){
           this.data = data;
    }
    
    public Time getHora(){
        return hora;
    }
    
    public void setHora(Time hora){
        this.hora = hora;
    }
    
    public float setDuracao(){
         return duracao;
    }
    
    public void getDuracao(float duracao){
        this.duracao = duracao;
    }

    
}
