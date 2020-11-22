package controleaereo.persistencia;

import controleaereo.entidades.Destino;
import java.util.List;

/**
 *
 * @author garrien
 */
public interface DestinoDAO {
    public void inserir(Destino destino);
    
    public void editar(Destino destino);
    
    public boolean remover(int id);
    
    public Destino getById(int id);
    
    public List<Destino> listar();
}
