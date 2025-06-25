package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jarav
 */
@Entity
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idUsuario;
    private String usuario;
    private String apellidos;
    private int idCarne;
    private String tipoDeMarca;
    private String tipoDeCarne;
    private int cantidadAdquirida;
    private int precio;
    private double porcentaje;

    private Date fecha;
    private int total;

    public Venta() {
    }

    public Venta(int id, int idUsuario, String usuario, String apellidos, int idCarne, String tipoDeMarca, String tipoDeCarne, int cantidadAdquirida, int precio, double porcentaje, Date fecha, int total) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.apellidos = apellidos;
        this.idCarne = idCarne;
        this.tipoDeMarca = tipoDeMarca;
        this.tipoDeCarne = tipoDeCarne;
        this.cantidadAdquirida = cantidadAdquirida;
        this.precio = precio;
        this.fecha = fecha;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdCarne() {
        return idCarne;
    }

    public void setIdCarne(int idCarne) {
        this.idCarne = idCarne;
    }

    public String getTipoDeMarca() {
        return tipoDeMarca;
    }

    public void setTipoDeMarca(String tipoDeMarca) {
        this.tipoDeMarca = tipoDeMarca;
    }

    public String getTipoDeCarne() {
        return tipoDeCarne;
    }

    public void setTipoDeCarne(String tipoDeCarne) {
        this.tipoDeCarne = tipoDeCarne;
    }

    public int getCantidadAdquirida() {
        return cantidadAdquirida;
    }

    public void setCantidadAdquirida(int cantidadAdquirida) {
        this.cantidadAdquirida = cantidadAdquirida;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
