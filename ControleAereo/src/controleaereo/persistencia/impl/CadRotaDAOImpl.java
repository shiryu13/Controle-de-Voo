package controleaereo.persistencia.impl;

import controleaereo.entidades.CadRota;
import controleaereo.entidades.Data;
import controleaereo.persistencia.CadRotaDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author garrien
 */
public class CadRotaDAOImpl implements CadRotaDAO{
    private final String filename = "cadRota.dat";
    private List<CadRota> cadRotas = new ArrayList<CadRota>();
    
    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(cadRotas);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(CadRotaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadArquivo(){
       try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            try {
                cadRotas = (List<CadRota>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(CadRotaDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            ois.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CadRotaDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
    }
    @Override
    public void inserir(CadRota cadRota) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        loadArquivo();
        boolean existe = false;
        for(CadRota r : cadRotas){
            if(r.getId() == cadRota.getId()){
                existe = true;
                break;
            }
        }
        if(!existe){
            cadRotas.add(cadRota);
            salvarArquivo();
            System.out.println("Rota cadastrado!");
        }else{
            System.out.println("Rota já cadastrado!");
        }
    }

    @Override
    public void editar(CadRota cadRota) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        loadArquivo();
        for(int i = 0; i < cadRotas.size(); i++){
            CadRota r = cadRotas.get(i);
            if(r.getId() == cadRota.getId()){
                cadRotas.set(i,cadRota);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean remover(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        loadArquivo();
        
        for(int i = 0; i < cadRotas.size(); i++){
            CadRota r = cadRotas.get(i);
            if(r.getId() == id){
                cadRotas.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
}

    public CadRota getById(int id) {
        loadArquivo();
        for (CadRota r : cadRotas){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }

    public List<CadRota> listar() {
        loadArquivo();
        return cadRotas;
    }

    
    
}
