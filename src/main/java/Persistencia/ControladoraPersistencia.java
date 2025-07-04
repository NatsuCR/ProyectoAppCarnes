package Persistencia;

import Logica.Carne;
import Logica.Rol;
import Logica.Usuario;
import Logica.Venta;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jarav
 */
public class ControladoraPersistencia {



    RolJpaController controladorPersiRol = new RolJpaController();
    UsuarioJpaController controladorPersiUsuario = new UsuarioJpaController();
    CarneJpaController controladorPersiCarne = new CarneJpaController();
    VentaJpaController controladorPersiVenta = new VentaJpaController();

    public List<Usuario> traerUsuarios() {

        //Trae todas las listas de usarios existentes
        //En MySQL es SELECT * FROM usuario
        return controladorPersiUsuario.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
        //Trae todas las listas de roles existentes
        //En MySQL es SELECT * FROM rol
        return controladorPersiRol.findRolEntities();
    }

    public void crearUsuario(Usuario usu) {
        //Crear usuario
        controladorPersiUsuario.create(usu);
    }

    public void borrarUsuarios(int id_usuarios) {
        try {
            controladorPersiUsuario.destroy(id_usuarios);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarUsuario(Usuario usu) {
        try {
            controladorPersiUsuario.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuarioPorId(int id_usuario) {
        return controladorPersiUsuario.findUsuario(id_usuario);
    }

    public void crearCarne(Carne carnes) {
        controladorPersiCarne.create(carnes);
    }

    public List<Carne> traerCarne() {
        return controladorPersiCarne.findCarneEntities();
    }

    public void editarCarne(Carne carneEditar) {
        try {
            controladorPersiCarne.edit(carneEditar);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarCarne(int id_Carne) {

        try {
            controladorPersiCarne.destroy(id_Carne);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Carne traerCarnePorId(int id_Carne) {
        return controladorPersiCarne.findCarne(id_Carne);
    }

    
    
    
    public void borrarCarneCantidades(int idCarne, int cantidad) {
        Carne carne = controladorPersiCarne.findCarne(idCarne);
        if (carne != null) {
            int cantidadActual = carne.getCantidad(); // ← asumimos que tenés un campo "cantidad"
            int nuevaCantidad = cantidadActual - cantidad;

            if (nuevaCantidad < 0) {
                nuevaCantidad = 0; // Por seguridad, no permitir negativos
            }

            carne.setCantidad(nuevaCantidad);

            try {
                controladorPersiCarne.edit(carne); // guardamos la nueva cantidad en la BD
            } catch (Exception ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agregarVenta(Venta NuevaVenta) {
       controladorPersiVenta.create(NuevaVenta);
    }

    public List<Venta> traerVentas() {
        return controladorPersiVenta.findVentaEntities();
    }

}
