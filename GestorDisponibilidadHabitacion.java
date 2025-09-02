package Practica1;

//==============================================
//Nueva clase: GestorDisponibilidadHabitacion
//Aplicación de SRP: ahora se encarga SOLO de la disponibilidad
//==============================================
import java.util.*;

public class GestorDisponibilidadHabitacion {
 private Habitacion habitacion;
 private List<Reserva> reservas; // lista de reservas asociadas a esta habitación

 public GestorDisponibilidadHabitacion(Habitacion habitacion) {
     this.habitacion = habitacion;
     this.reservas = new ArrayList<>();
 }

 // 1. Verificar la disponibilidad en un rango de fechas
 public boolean verificarDisponibilidad(Date inicio, Date fin) {
     for (Reserva r : reservas) {
         if (r.seSuperpone(inicio, fin)) {
             return false;
         }
     }
     return true;
 }

 // 2. Marcar como reservada
 public void marcarReservada(Date inicio, Date fin) {
     if (verificarDisponibilidad(inicio, fin)) {
         reservas.add(new Reserva(habitacion, inicio, fin));
         System.out.println("Habitación " + habitacion.getNumero() + " reservada.");
     } else {
         System.out.println("Habitación no disponible en ese rango de fechas.");
     }
 }

 // 3. Liberar habitación
 public void marcarDisponible(Date inicio, Date fin) {
     reservas.removeIf(r -> r.getInicio().equals(inicio) && r.getFin().equals(fin));
     System.out.println("Habitación " + habitacion.getNumero() + " liberada.");
 }
}
