package controleaereo;

import controleaereo.entidades.Aviao;
import controleaereo.entidades.Origem;
import controleaereo.telas.AviaoJPanel;
import controleaereo.telas.PrincipalJFrame;

/**
 *
 * @author garrien
 */
public class ControleAereo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        PrincipalJFrame tela = new PrincipalJFrame();
        tela.setVisible(true);
        
        //se o avião já está alocado em uma rota, ele não pode fazer um voo novo
        //se o avião não tiver rota e não estiver na mesma latlong da cidade, ele não pode fazer o voo
        /*if(a.setLatLong == o.setLatLong){/*significa que o avião está na mesma localização que 
            a cidade de origem, então caso o avião já não esteja escalado para
            outro voo, ele mode ser desiguinado para voar.*/
            //System.out.println("O voo pode ser realizado!");
        //}else{
            //System .out.println("O voo não pode ser realizado!");
        //}
                
    }
    
}
