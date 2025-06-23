
package Encriptaciones;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author jarav
 */
public class Hashead {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    public static String encriptarContraseña(String contraseña){
    return encoder.encode(contraseña);
    }

    public static boolean checkPassword(String contraseñaIngresada, String contraseñaEncriptada) {
        return encoder.matches(contraseñaIngresada, contraseñaEncriptada);
    }
    
}
