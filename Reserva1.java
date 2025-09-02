import java.util.*;

public class Reserva1 {
    private Habitacion habitacion;
    private Date inicio;
    private Date fin;
    private PoliticaCancelacion politicaCancelacion;

    public Reserva1(Habitacion habitacion, Date inicio, Date fin, PoliticaCancelacion politica) {
        this.habitacion = habitacion;
        this.inicio = inicio;
        this.fin = fin;
        this.politicaCancelacion = politica;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    // Método cancelar que aplica la política (OCP en acción)
    public void cancelar() {
        if (politicaCancelacion.puedeCancelar(this)) {
            double penalizacion = politicaCancelacion.calcularPenalizacion(this);
            if (penalizacion > 0) {
                System.out.println("Reserva cancelada con penalización del " + (penalizacion * 100) + "%.");
            } else {
                System.out.println("Reserva cancelada sin penalización.");
            }
        } else {
            System.out.println("No se puede cancelar esta reserva según la política.");
        }
    }

    // Método para verificar si hay solapamiento de fechas
    public boolean seSuperpone(Date nuevoInicio, Date nuevoFin) {
        return !(nuevoFin.before(inicio) || nuevoInicio.after(fin));
    }
}
