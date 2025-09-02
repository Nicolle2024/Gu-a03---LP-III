package Practica1;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return false; // Nunca permite cancelar
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 1.0; // Penalización del 100%
    }
}
