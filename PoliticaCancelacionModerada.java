package Practica1;

import java.util.*;

public class PoliticaCancelacionModerada implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        Date ahora = new Date();
        long horasRestantes = (reserva.getInicio().getTime() - ahora.getTime()) / (1000 * 60 * 60);
        return horasRestantes >= 72; // Se puede cancelar hasta 72h antes
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0.5; // Penalización del 50%
    }
}
