/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleaereo.persistencia;

import controleaereo.entidades.CadRota;
import java.util.List;

/**
 *
 * @author garrien
 */
public interface CadRotaDAO {
    public void inserir(CadRota cadRota);
    
    public void editar(CadRota cadRota);
    
    public boolean remover(int id);
    
    public CadRota getById(int id);
    
    public List<CadRota> listar();
}
