package controleaereo.persistencia;

import controleaereo.entidades.Origem;
import java.util.List;

/**
 *
 * @author garrien
 */
public interface OrigemDAO {
    public void inserir(Origem origem);
    
    public void editar(Origem origem);
    
    public boolean remover(int id);
    
    public Origem getById(int id);
    
    public List<Origem> listar();
}
