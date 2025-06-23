
package Persistencia;

import Logica.Usuario;
import java.util.List;

/**
 *
 * @author jarav
 */
public class ControladoraPersistencia {
    
        
    RolJpaController controladorPersiRol = new RolJpaController();
    UsuarioJpaController controladorPersiUsuario = new UsuarioJpaController();
    
    
    
    public List<Usuario> traerUsuarios() {
        
        //Trae todas las listas de usarios existentes
        //En MySQL es SELECT * FROM usuario
        return controladorPersiUsuario.findUsuarioEntities();
    }
    
}
