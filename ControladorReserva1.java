package Practica1;

import java.util.*;

public class ControladorReserva1 {
    private List<Habitacion> habitaciones;

    public ControladorReserva1() {
        habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    // Consultar precios de todas las habitaciones
    public void mostrarPrecios(String temporada, double descuento) {
        for (Habitacion h : habitaciones) {
            System.out.println("Habitación " + h.getNumero() + " (" + h.getTipo() + 
                               ") precio: " + h.calcularPrecio(temporada, descuento));
        }
    }
}
