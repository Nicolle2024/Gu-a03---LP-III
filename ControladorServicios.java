/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

package Practica1;

import java.util.Arrays;

public class ControladorServicios {
    
    public void gestionarServiciosHabitacion(Habitacion habitacion) {
        System.out.println("\n=== Gestionando servicios para habitación " + habitacion.getNumero() + " ===");
        
        if (habitacion instanceof ServicioLimpieza) {
            ((ServicioLimpieza) habitacion).solicitarLimpieza();
        } else {
            System.out.println("Habitación " + habitacion.getNumero() + " no tiene servicio de limpieza");
        }
        
        if (habitacion instanceof ServicioComida) {
            ((ServicioComida) habitacion).solicitarComida("Menú premium");
        } else {
            System.out.println("Habitación " + habitacion.getNumero() + " no tiene servicio de comida");
        }
        
        if (habitacion instanceof ServicioLavanderia) {
            ((ServicioLavanderia) habitacion).solicitarLavanderia(Arrays.asList("camisa", "pantalón"));
        } else {
            System.out.println("Habitación " + habitacion.getNumero() + " no tiene servicio de lavandería");
        }
    }
    
    public boolean tieneServicioLimpieza(Habitacion habitacion) {
        return habitacion instanceof ServicioLimpieza;
    }
    
    public boolean tieneServicioComida(Habitacion habitacion) {
        return habitacion instanceof ServicioComida;
    }
    
    public boolean tieneServicioLavanderia(Habitacion habitacion) {
        return habitacion instanceof ServicioLavanderia;
    }
    
    public void mostrarServiciosDisponibles(Habitacion habitacion) {
        System.out.println("\nServicios disponibles habitación " + habitacion.getNumero() + ":");
        System.out.println("Limpieza: " + (tieneServicioLimpieza(habitacion) ? "SÍ" : "NO"));
        System.out.println("Comida: " + (tieneServicioComida(habitacion) ? "SÍ" : "NO"));
        System.out.println("Lavandería: " + (tieneServicioLavanderia(habitacion) ? "SÍ" : "NO"));
    }
}
