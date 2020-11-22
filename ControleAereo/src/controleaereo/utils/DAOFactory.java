package controleaereo.utils;

import controleaereo.persistencia.AviaoDAO;
import controleaereo.persistencia.DestinoDAO;
import controleaereo.persistencia.OrigemDAO;
import controleaereo.persistencia.impl.AviaoDAOImpl;
import controleaereo.persistencia.impl.DestinoDAOImpl;
import controleaereo.persistencia.impl.OrigemDAOImpl;

/**
 *
 * @author garrien
 */
public class DAOFactory {
    public static AviaoDAO createAviaoDAO(){
        return new AviaoDAOImpl();
    }
    
    public static OrigemDAO createOrigemDAO(){
        return new OrigemDAOImpl();
    }
    
    public static DestinoDAO createDestinoDAO(){
        return new DestinoDAOImpl();
    }
    
    
}
