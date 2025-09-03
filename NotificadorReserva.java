/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

public class NotificadorReserva {
    private CanalNotificacion canalNotificacion;

    public NotificadorReserva(CanalNotificacion canal) {
        this.canalNotificacion = canal;
    }

    public void notificarCreacionReserva(Reserva reserva, String cliente) {
        String mensaje = "Reserva confirmada - Habitacion: " + reserva.getHabitacion().getNumero() + 
                        ", Cliente: " + cliente;
        canalNotificacion.enviarNotificacion(mensaje);
    }
    // ... otros métodos de notificación ...
}


