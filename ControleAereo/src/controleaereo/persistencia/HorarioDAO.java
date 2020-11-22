package controleaereo.persistencia;

import controleaereo.entidades.Horario;
import java.util.List;

/**
 *
 * @author garrien
 */
public interface HorarioDAO {
    public void inserir(Horario horario);
    
    public void editar(Horario horario);
    
    public boolean remover(int id);
    
    public Horario getById(int id);
    
    public List<Horario> listar();
}
