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
    private double precioGramos;

    public Carne() {
    }

    public Carne(int id, String Nombre, String tipoDeCarne, String descripcion, double precioGramos) {
        this.id = id;
        this.Marca = Nombre;
        this.tipoDeCarne = tipoDeCarne;
        this.descripcion = descripcion;
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

    public double getPrecioGramos() {
        return precioGramos;
    }

    public void setPrecioGramos(double precioGramos) {
        this.precioGramos = precioGramos;
    }
    
    
    

}
