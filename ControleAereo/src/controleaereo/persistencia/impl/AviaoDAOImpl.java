package controleaereo.persistencia.impl;

import controleaereo.entidades.Aviao;
import controleaereo.persistencia.AviaoDAO;
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
public class AviaoDAOImpl implements AviaoDAO {

    private final String filename = "aviao.dat";
    private List<Aviao> avioes = new ArrayList<Aviao>();
    
    private void salvarArquivo(){
        try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
                oos.writeObject(avioes);
                oos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AviaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AviaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    
    private void loadArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            avioes = (List<Aviao>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(AviaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AviaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Aviao aviao) {
        loadArquivo();
        boolean existe = false;
        for(Aviao a : avioes){
            if(a.getId() == aviao.getId()){
                existe = true;
                break;
            }
        }
        if(!existe){
            avioes.add(aviao);
            salvarArquivo();
            System.out.println("Avião cadastrado!");
        }else{
            System.out.println("Avião já cadastrado!");
        }
    }

    @Override
    public void editar(Aviao aviao) {
        loadArquivo();
        for(int i = 0; i < avioes.size(); i++){
            Aviao a = avioes.get(i);
            if(a.getId() == aviao.getId()){
                avioes.set(i, aviao);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean remover(int id) {
       loadArquivo();
        
        for(int i = 0; i < avioes.size(); i++){
            Aviao a = avioes.get(i);
            if(a.getId() == id){
                avioes.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public Aviao getById(int id) {
        loadArquivo();
        for(Aviao a : avioes){
            if(a.getId() == id){
                return a;
            }
        }
        
        return null;
    }

    @Override
    public List<Aviao> listar() {
        loadArquivo();
        return avioes;
    }
    
    
}
