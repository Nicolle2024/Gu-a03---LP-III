package Practica1;

//==============================================
//Controlador: usa el GestorDisponibilidadHabitacion
//ya que Habitacion ahora delega esas funciones
//==============================================
import java.util.*;

public class ControladorReserva {
 private List<Habitacion> habitaciones;

 public ControladorReserva() {
     habitaciones = new ArrayList<>();
 }

 public void agregarHabitacion(Habitacion habitacion) {
     habitaciones.add(habitacion);
 }

 // Consultar disponibilidad
 public void consultarDisponibilidad(int numero, Date inicio, Date fin) {
     for (Habitacion h : habitaciones) {
         if (h.getNumero() == numero) {
             boolean disponible = h.estaDisponible(inicio, fin);
             System.out.println("Habitación " + numero + 
                                (disponible ? " está disponible." : " no está disponible."));
         }
     }
 }

 // Crear nueva reserva
 public void crearReserva(int numero, Date inicio, Date fin) {
     for (Habitacion h : habitaciones) {
         if (h.getNumero() == numero) {
             h.reservar(inicio, fin); // Delegación al Gestor
         }
     }
 }
}
