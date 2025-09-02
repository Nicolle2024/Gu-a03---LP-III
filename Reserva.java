package Practica1;

//==============================================
//Clase Reserva (simplificada)
//==============================================
import java.util.*;

public class Reserva {
 private Habitacion habitacion;
 private Date inicio;
 private Date fin;

 public Reserva(Habitacion habitacion, Date inicio, Date fin) {
     this.habitacion = habitacion;
     this.inicio = inicio;
     this.fin = fin;
 }

 public Date getInicio() {
     return inicio;
 }

 public Date getFin() {
     return fin;
 }

 // Método para verificar solapamiento de fechas
 public boolean seSuperpone(Date nuevoInicio, Date nuevoFin) {
     return !(nuevoFin.before(inicio) || nuevoInicio.after(fin));
 }
}
