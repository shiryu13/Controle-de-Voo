package controleaereo.persistencia.impl;

import controleaereo.entidades.Horario;
import controleaereo.persistencia.HorarioDAO;
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
public class HorarioDAOImpl implements HorarioDAO{
    private final String filename = "horario.dat";
    private List<Horario> horarios = new ArrayList<Horario>();
    
    private void salvarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(horarios);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(HorarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void loadArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            horarios = (List<Horario>) ois.readObject();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(HorarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HorarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void inserir(Horario horario) {
       loadArquivo();
        boolean existe = false;
        for(Horario h : horarios){
            if(h.getId() == horario.getId()){
                existe = true;
                break;
            }
        }
        if(!existe){
            horarios.add(horario);
            salvarArquivo();
            System.out.println("Horário cadastrado!");
        }else{
            System.out.println("Horário já cadastrado!");
        }
    }

    @Override
    public void editar(Horario horario) {
        loadArquivo();
        for(int i = 0; i < horarios.size(); i++){
            Horario h = horarios.get(i);
            if(h.getId() == horario.getId()){
                horarios.set(i, horario);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean remover(int id) {
        loadArquivo();
        
        for(int i = 0; i < horarios.size(); i++){
            Horario h = horarios.get(i);
            if(h.getId() == id){
                horarios.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public Horario getById(int id) {
        loadArquivo();
        for(Horario h : horarios){
            if(h.getId() == id){
                return h;
            }
        }
        
        return null;
    }

    @Override
    public List<Horario> listar() {
        loadArquivo();
        return horarios;
    }
    
}
