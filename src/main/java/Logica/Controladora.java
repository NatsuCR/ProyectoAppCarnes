package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;
import javax.swing.JOptionPane;
import Encriptaciones.Hashead;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jarav
 */
public class Controladora {

    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();
    Hashead encriptar = new Hashead();

    public Usuario validarUsuario(String cedula, String contraseñaIngresada) {
        List<Usuario> listaUsuarios = controlPersistencia.traerUsuarios();

        for (Usuario usu : listaUsuarios) {
            if (usu.getCedula().equals(cedula)) {
                // Comparar la contraseña visible con la encriptada
                if (Hashead.checkPassword(contraseñaIngresada, usu.getContraseña())) {
                    return usu;
                }
            }
        }
        return null;
    }

    public boolean existe(String cedula) {
        List<Usuario> listaUsuarios = controlPersistencia.traerUsuarios();
        for (Usuario u : listaUsuarios) {
            if (u.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    public void crearUsuario(String cedula, String contraseñaEncriptada, String nombre, String apellidos, String rolRecibido) {

        //Crear una nueva instancia para porder guardar el usuario
        Usuario usu = new Usuario();
        usu.setCedula(cedula);
        usu.setNombre(nombre);
        usu.setApellidos(apellidos);
        usu.setContraseña(contraseñaEncriptada);

        //Crear una nueva instancia para poder guardar el rol
        Rol rolEncontrado = new Rol();
        //rolEncontrado ser = a lo que traerRoles encuentre del rolRecibido por parametro
        rolEncontrado = this.traerRoles(rolRecibido);
        //Si rolEncontrado es diferente a nulo, entonces que lo envíe al atributo UnRol

        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }

        //Traer del metodo, para seguir con la secuencia de ids automaticamente con + 1
        /*
        int id = this.buscarUltimaIdUsuarios();
        // Se le pone +1 para seguir la secuencia
        usu.setId(id +1);
         */
        JOptionPane.showMessageDialog(null, "Usuario creado correctamente!");
        controlPersistencia.crearUsuario(usu);
    }

    public List<Rol> traerRoles() {
        return controlPersistencia.traerRoles();
    }

    private Rol traerRoles(String rolRecibido) {
        //Se crea una lista del metodo traerRoles
        List<Rol> listaRoles = controlPersistencia.traerRoles();

        //Recorremos la lista de roles
        for (Rol rol : listaRoles) {
            //Si de lo que marco el usuario es == a lo que halla en la bd entonces lo retorna
            if (rol.getNombreRol().equals(rolRecibido.trim())) {
                return rol;
            }
        }
        return null;
    }

    public List<Usuario> traerUsuario() {

        return controlPersistencia.traerUsuarios();

    }

    public Usuario traerUsuarioPorId(int id_usuario) {
        return controlPersistencia.traerUsuarioPorId(id_usuario);
    }

    public void borrarUsuarios(int id_usuarios) {
        controlPersistencia.borrarUsuarios(id_usuarios);
    }

    public void editarUsuario(Usuario user, String cedula, String nombre, String apellidos, String contraseña, String rolRecibido) {

        user.setCedula(cedula);
        user.setContraseña(contraseña);
        user.setApellidos(apellidos);
        user.setNombre(nombre);
        //Crear una nueva instancia para poder guardar el rol
        Rol rolEncontrado = new Rol();
        //rolEncontrado ser = a lo que traerRoles encuentre del rolRecibido por parametro
        rolEncontrado = this.traerRoles(rolRecibido);
        //Si rolEncontrado es diferente a nulo, entonces que lo envíe al atributo UnRol
        if (rolEncontrado != null) {
            user.setUnRol(rolEncontrado);
        }
        controlPersistencia.editarUsuario(user);
    }

    public void agregarCarne(String marca, String tipoCarne, String descripcion, int cantidad, int precio) {
        Carne carnes = new Carne();

        carnes.setMarca(marca);
        carnes.setTipoDeCarne(tipoCarne);
        carnes.setDescripcion(descripcion);
        carnes.setCantidad(cantidad);
        carnes.setPrecioGramos(precio);

        JOptionPane.showMessageDialog(null, "Guardado con exito!");
        controlPersistencia.crearCarne(carnes);
    }

    public List<Carne> traerCarne() {
        return controlPersistencia.traerCarne();
    }

    public void borrarCarne(int id_Carne) {
        controlPersistencia.borrarCarne(id_Carne);
    }

    public void editarCarne(Carne carneEditar, String marca, String tipoCarne, String descripcion, int cantidad, int precio) {
        carneEditar.setMarca(marca);
        carneEditar.setTipoDeCarne(tipoCarne);
        carneEditar.setDescripcion(descripcion);
        carneEditar.setCantidad(cantidad);
        carneEditar.setPrecioGramos(precio);
        controlPersistencia.editarCarne(carneEditar);
    }

    public Carne traerCarnePorId(int id_Carne) {
        return controlPersistencia.traerCarnePorId(id_Carne);
    }

    public int calcular(int cantidad, int precio, double porcentaje) {
        int subtotal = cantidad * precio;
        double porcentajeReal = porcentaje / 100;
        int total = (int) (subtotal + (subtotal * porcentajeReal));
        return total;
    }
    
    public int obtenerCantidadDisponible(int idCarne) {
    Carne carne = controlPersistencia.traerCarnePorId(idCarne); // o como lo tengas
    return carne != null ? carne.getCantidad() : 0;
}
    

    public void agregarVenta(Venta NuevaVenta, int idUsuario, String usuario, String apellidos, int idCarne, String marca, String tipoCarne, int cantidad, int precio, Date fecha, int total) {
        NuevaVenta.setIdUsuario(idUsuario);
        NuevaVenta.setUsuario(usuario);
        NuevaVenta.setApellidos(apellidos);
        NuevaVenta.setIdCarne(idCarne);
        NuevaVenta.setTipoDeMarca(marca);
        NuevaVenta.setTipoDeCarne(tipoCarne);
        NuevaVenta.setCantidadAdquirida(cantidad);
        NuevaVenta.setPrecio(precio);
        NuevaVenta.setFecha(fecha);
        NuevaVenta.setTotal(total);
        controlPersistencia.agregarVenta(NuevaVenta);
    }

    public void eliminarCantidadesenBD(int idCarne, int cantidad) {
        controlPersistencia.borrarCarneCantidades(idCarne, cantidad);
    }

    public List<Venta> traerVentas() {
        return controlPersistencia.traerVentas();
    }
    
    public List<Venta> traerVentasPorFecha(Date fecha) {
    List<Venta> todasLasVentas = controlPersistencia.traerVentas();
    List<Venta> ventasFiltradas = new ArrayList<>();

    // Comparar solo día/mes/año ignorando la hora
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    for (Venta venta : todasLasVentas) {
        if (sdf.format(venta.getFecha()).equals(sdf.format(fecha))) {
            ventasFiltradas.add(venta);
        }
    }

    return ventasFiltradas;
}
    
    
    
    
}
