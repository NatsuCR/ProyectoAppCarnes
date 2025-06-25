package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jarav
 */
@Entity
public class Carne implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Marca;
    private String tipoDeCarne;
    private String descripcion;
    private int cantidad;
    private int precioGramos;
    
    public Carne() {
    }

    public Carne(int id, String Marca, String tipoDeCarne, String descripcion, int cantidad, int precioGramos) {
        this.id = id;
        this.Marca = Marca;
        this.tipoDeCarne = tipoDeCarne;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioGramos = precioGramos;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getTipoDeCarne() {
        return tipoDeCarne;
    }

    public void setTipoDeCarne(String TipoDeCarne) {
        this.tipoDeCarne = TipoDeCarne;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    public int getPrecioGramos() {
        return precioGramos;
    }

    public void setPrecioGramos(int precioGramos) {
        this.precioGramos = precioGramos;
    }
    
    
    

}
