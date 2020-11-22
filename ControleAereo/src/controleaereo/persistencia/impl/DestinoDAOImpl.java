package controleaereo.persistencia.impl;

import controleaereo.entidades.Destino;
import controleaereo.persistencia.DestinoDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garrien
 */
public class DestinoDAOImpl  implements DestinoDAO{
    private final String filename = "destino.dat";
    private List<Destino> destinos = new ArrayList<Destino>();

    private void salvarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(destinos);
            oos.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DestinoDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
    }
    
    private void loadArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            destinos = (List<Destino>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DestinoDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DestinoDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
    }
    
    @Override
    public void inserir(Destino destino) {
        loadArquivo();
        boolean existe = false;
        for(Destino dest : destinos){
            if(dest.getId() == destino.getId()){
                existe = true;
                break;
            }
        }
        if(!existe){
            destinos.add(destino);
            salvarArquivo();
            System.out.println("Destino cadastrado!");
        }else{
            System.out.println("Destino já cadastrado!");
        }
    }

    @Override
    public void editar(Destino destino) {
        loadArquivo();
        for(int i = 0; i < destinos.size(); i++){
            Destino dest = destinos.get(i);
            if(dest.getId() == dest.getId()){
                destinos.set(i, destino);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean remover(int id) {
        loadArquivo();
        
        for(int i = 0; i < destinos.size(); i++){
            Destino dest = destinos.get(i);
            if(dest.getId() == id){
                destinos.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public Destino getById(int id) {
        loadArquivo();
        for(Destino dest : destinos){
            if(dest.getId() == id){
                return dest;
            }
        }
        
        return null;
    }

    @Override
    public List<Destino> listar() {
       loadArquivo();
        return destinos;
    }
    
    
}
