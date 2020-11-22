package controleaereo.persistencia;

import controleaereo.entidades.Data;
import java.util.List;

/**
 *
 * @author garrien
 */
public interface DataDAO {
    public void inserir(Data data);
    
    public void editar(Data data);
    
    public boolean remover(int id);
    
    public Data getById(int id);
    
    public List<Data> listar();
}
