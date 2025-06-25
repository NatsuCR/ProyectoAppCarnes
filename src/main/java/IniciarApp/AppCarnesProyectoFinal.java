
package IniciarApp;

import Logica.Carne;
import Logica.Venta;
import Login.Login;

/**
 *
 * @author jarav
 */
public class AppCarnesProyectoFinal {

    public static void main(String[] args) {
        Carne carnes = new Carne();
        Venta ventas = new Venta();
        
        Login l = new Login(carnes, ventas);
        l.setVisible(false); //FALSE PARA NO DOBLE PANTALLA.
        l.setLocationRelativeTo(null);
        
    }
}
