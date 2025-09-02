package Practica1;

import java.util.*;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        Date ahora = new Date();
        long horasRestantes = (reserva.getInicio().getTime() - ahora.getTime()) / (1000 * 60 * 60);
        return horasRestantes >= 24; // Se puede cancelar hasta 24h antes
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0.0; // No hay penalización
    }
}
