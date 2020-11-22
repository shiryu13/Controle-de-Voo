/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleaereo.persistencia.impl;

import controleaereo.entidades.Data;
import controleaereo.persistencia.DataDAO;
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
public class DataDAOImpl implements DataDAO {
    private final String filename = "data.dat";
    private List<Data> datas = new ArrayList<Data>();
    
    private void salvarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(datas);
            oos.close();
            }catch (IOException ex) {
                java.util.logging.Logger.getLogger(DataDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        
    }
    
    private void loadArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            try {
                datas = (List<Data>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(DataDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            ois.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DataDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
    }
    public void inserir(Data data) {
        loadArquivo();
        boolean existe = false;
        for(Data d : datas){
            if(d.getId() == data.getId()){
                existe = true;
                break;
            }
        }
        if(!existe){
            datas.add(data);
            salvarArquivo();
            System.out.println("Data cadastrado!");
        }else{
            System.out.println("Data já cadastrado!");
        }
    }

    public void editar(Data data) {
        loadArquivo();
        for(int i = 0; i < datas.size(); i++){
            Data d = datas.get(i);
            if(d.getId() == data.getId()){
                datas.set(i, data);
                salvarArquivo();
                break;
            }
        }
    }

    public boolean remover(int id) {
       loadArquivo();
        
        for(int i = 0; i < datas.size(); i++){
            Data d = datas.get(i);
            if(d.getId() == id){
                datas.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    public Data getById(int id) {
        loadArquivo();
        for(Data d : datas){
            if(d.getId() == id){
                return d;
            }
        }
        
        return null;
    }

    public List<Data> listar() {
        loadArquivo();
        return datas;
    }
}
