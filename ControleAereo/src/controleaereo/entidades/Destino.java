package controleaereo.entidades;

import java.io.Serializable;

/**
 *
 * @author garrien
 */
public class Destino extends Base implements Serializable{
    private String cidade;
    private String pais;
    private String latLong;// Nxx°yy'zz"-Lxx°yy'zz"
    /*private Origem origem;*/
    
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
    
    /*public Origem getOrigem(){
        return origem;
    }
    
    public void setOrigem(Origem origem){
        this.origem = origem;
    }

    public void setDestino(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public void setDestino(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
