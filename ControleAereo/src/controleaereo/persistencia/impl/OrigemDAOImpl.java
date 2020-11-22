package controleaereo.persistencia.impl;

import controleaereo.entidades.Origem;
import controleaereo.persistencia.OrigemDAO;
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
public class OrigemDAOImpl implements OrigemDAO{
    private final String filename = "origem.dat";
    private List<Origem> origens = new ArrayList<Origem>();
    
    private void salvarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(origens);
            oos.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(OrigemDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    private void loadArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            origens = (List<Origem>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(OrigemDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrigemDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Origem origem) {
        loadArquivo();
        boolean existe = false;
        for(Origem o : origens){
            if(o.getId() == origem.getId()){
                existe = true;
                break;
            }
        }
        if(!existe){
            origens.add(origem);
            salvarArquivo();
            System.out.println("Origem cadastrado!");
        }else{
            System.out.println("Origem já cadastrado!");
        }
    }

    @Override
    public void editar(Origem origem) {
        loadArquivo();
        for(int i = 0; i < origens.size(); i++){
            Origem o = origens.get(i);
            if(o.getId() == origem.getId()){
                origens.set(i, origem);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean remover(int id) {
       loadArquivo();
        
        for(int i = 0; i < origens.size(); i++){
            Origem o = origens.get(i);
            if(o.getId() == id){
                origens.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public Origem getById(int id) {
        loadArquivo();
        for(Origem o : origens){
            if(o.getId() == id){
                return o;
            }
        }
        
        return null;
    }

    @Override
    public List<Origem> listar() {
        loadArquivo();
        return origens;
    }
}
