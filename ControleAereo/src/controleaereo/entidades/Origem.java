package controleaereo.entidades;

import java.io.Serializable;

/**
 *
 * @author garrien
 */
public class Origem extends Base implements Serializable{
    private String cidade;
    private String pais;
    private String latLong;
    /*private Destino destino;*/
    
    public String getCidade(){
        return cidade;
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public String getPais(){
        return pais;
    }
    
    public void setPais(String pais){
        this.pais = pais;
    }
    
    public String getLatLong(){
        return latLong;
    }
    
    public void setLatLong(String latLong){
        this.latLong = latLong;
    }
    
   /* public Destino getDestino(){
        return destino;
    }
    
    public void setDestino(Destino destino){
        this.destino = destino;
    }

    public void setOrigem(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public void setOrigem(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
