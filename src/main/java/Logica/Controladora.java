
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author jarav
 */
public class Controladora {
    
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();
    
    
        public Usuario validarUsuario(String cedula, String contraseña) {
        List<Usuario> listaUsuarios = controlPersistencia.traerUsuarios();

        for (Usuario usu : listaUsuarios) {
            if (usu.getCedula().equals(cedula)) {
                if (usu.getContraseña().equals(contraseña)) {
                    return usu; // ✅ Usuario válido
                } else {
                    return null; // ❌ Usuario encontrado, pero contraseña incorrecta
                }
            }
        }

        return null; // ❌ Usuario no encontrado en la lista
    }
    
}
