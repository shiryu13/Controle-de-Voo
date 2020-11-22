package controleaereo.entidades;

import java.io.Serializable;

/**
 *
 * @author garrien
 */
public class Aviao extends Base implements Serializable{
    private String fabricante;
    private String modelo;
    private String latLong; //latitute e longitude
    /*private Origem origem;
    private Destino destino;*/
    
    
    public String getFabricante(){
        return fabricante;
    }
    
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
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
    
    public Destino getDestino(){
        return destino;
    }
    
    public void setDestino(Destino destino){
        this.destino = destino;
    }*/

    public void setAviao(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
