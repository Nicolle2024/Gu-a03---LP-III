/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

package Practica1;
import java.util.Date;

public class CalculadoraPrecioHabitacion {
    public double calcularPrecio(Habitacion habitacion, Date fecha, String temporada, double descuentoPromocion) {
        double precio = habitacion.getPrecioBase();
        
        if ("alta".equalsIgnoreCase(temporada)) {
            precio *= 1.2;
        } else if ("baja".equalsIgnoreCase(temporada)) {
            precio *= 0.8;
        }
        
        if (descuentoPromocion > 0) {
            precio -= precio * descuentoPromocion;
        }
        
        if (habitacion instanceof HabitacionDoble) {
            precio *= 1.1;
        } else if (habitacion instanceof HabitacionSuite) {
            precio += 50;
        }
        
        return precio;
    }
}


