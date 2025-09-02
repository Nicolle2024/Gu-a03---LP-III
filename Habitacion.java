// ==============================================
// Clase Habitacion (ANTES tenía demasiadas responsabilidades)
// Ahora: solo gestiona información propia de la habitación
// y delega la disponibilidad a GestorDisponibilidadHabitacion
// ==============================================
import java.util.*;

public class Habitacion {
    private int numero;
    private String tipo; // individual, doble, suite...
    private double precioBase;

    // Nuevo atributo: se agrega el gestor de disponibilidad (SRP aplicado)
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(int numero, String tipo, double precioBase) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion(this);
    }

    // Getter
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    // ========================
    // Métodos que se quedan en Habitacion (propios de la habitación)
    // ========================

    // Calcular precio con promoción o temporada
    // (Se mantiene aquí porque depende del precioBase de la habitación)
    public double calcularPrecio(String temporada, double descuento) {
        double precio = precioBase;
        if (temporada.equalsIgnoreCase("alta")) {
            precio *= 1.2; // Aumento en temporada alta
        }
        if (descuento > 0) {
            precio -= precio * descuento;
        }
        return precio;
    }

    // Uso del gestor para verificar disponibilidad (delegación)
    public boolean estaDisponible(Date inicio, Date fin) {
        return gestorDisponibilidad.verificarDisponibilidad(inicio, fin);
    }

    // Uso del gestor para marcar reservada/liberada (delegación)
    public void reservar(Date inicio, Date fin) {
        gestorDisponibilidad.marcarReservada(inicio, fin);
    }

    public void liberar(Date inicio, Date fin) {
        gestorDisponibilidad.marcarDisponible(inicio, fin);
    }
}
