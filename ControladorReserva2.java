/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

package Practica1;

import java.util.*;

public class ControladorReserva {
    private List<Habitacion> habitaciones;
    private NotificadorReserva notificador;

    // Constructor con inyección de dependencia
    public ControladorReserva(CanalNotificacion canalNotificacion) {
        habitaciones = new ArrayList<>();
        this.notificador = new NotificadorReserva(canalNotificacion);
    }

    // Método existente modificado para incluir notificación
    public void crearReserva(int numero, Date inicio, Date fin, String nombreCliente) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numero) {
                if (h.estaDisponible(inicio, fin)) {
                    h.reservar(inicio, fin);
                    Reserva reserva = new Reserva(h, inicio, fin);
                    notificador.notificarCreacionReserva(reserva, nombreCliente);
                    System.out.println("Reserva creada exitosamente.");
                } else {
                    System.out.println("Habitacion no disponible en esas fechas.");
                }
                return;
            }
        }
        System.out.println("Habitacion no encontrada.");
    }

    // Método para cancelar reserva con notificación
    public void cancelarReserva(int numero, Date inicio, Date fin, String nombreCliente, String motivo) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numero) {
                h.liberar(inicio, fin);
                Reserva reserva = new Reserva(h, inicio, fin);
                notificador.notificarCancelacion(reserva, nombreCliente, motivo);
                System.out.println("Reserva cancelada exitosamente.");
                return;
            }
        }
        System.out.println("Habitacion no encontrada.");
    }

    // Resto de métodos existentes...
}


