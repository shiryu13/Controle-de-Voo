package controleaereo.persistencia;

import controleaereo.entidades.Aviao;
import java.util.List;

/**
 *
 * @author garrien
 */
public interface AviaoDAO {
    public void inserir(Aviao aviao);
    
    public void editar(Aviao aviao);
    
    public boolean remover(int id);
    
    public Aviao getById(int id);
    
    public List<Aviao> listar();
}
