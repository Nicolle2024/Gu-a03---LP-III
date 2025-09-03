/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
package Practica1;

import java.util.*;
import java.text.SimpleDateFormat;

public class MainHotel {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        // 1. CONFIGURACIÓN INICIAL
        CanalNotificacion canalCorreo = new EnviadorCorreo();
        ControladorReserva controlador = new ControladorReserva(canalCorreo);
        
        // 2. AGREGAR HABITACIONES (SRP y LSP)
        Habitacion individual = new HabitacionIndividual(101, 50.0);
        Habitacion doble = new HabitacionDoble(102, 75.0);
        Habitacion suite = new HabitacionSuite(201, 150.0);
        Habitacion estandar = new HabitacionEstandar(301, 60.0);
        
        controlador.agregarHabitacion(individual);
        controlador.agregarHabitacion(doble);
        controlador.agregarHabitacion(suite);
        controlador.agregarHabitacion(estandar);
        
        // 3. AGREGAR PROMOCIONES (OCP)
        controlador.agregarPromocion(new PromocionTemporadaAlta());
        controlador.agregarPromocion(new PromocionClienteFrecuente());
        
        // 4. CREAR RESERVAS CON NOTIFICACIONES (DIP)
        Date inicio1 = sdf.parse("2024-12-20");
        Date fin1 = sdf.parse("2024-12-25");
        
        Date inicio2 = sdf.parse("2024-12-15");
        Date fin2 = sdf.parse("2024-12-22");
        
        System.out.println("=== CREANDO RESERVAS ===");
        controlador.crearReserva(101, inicio1, fin1, "Juan Pérez");
        controlador.crearReserva(201, inicio2, fin2, "María García");
        
        // 5. CONSULTAR DISPONIBILIDAD
        System.out.println("\n=== CONSULTANDO DISPONIBILIDAD ===");
        controlador.consultarDisponibilidad(101, inicio1, fin1);
        controlador.consultarDisponibilidad(102, inicio1, fin1);
        
        // 6. CALCULAR PRECIOS CON PROMOCIONES
        System.out.println("\n=== CALCULANDO PRECIOS ===");
        Reserva reservaEjemplo = new Reserva(suite, inicio2, fin2);
        double precioFinal = controlador.calcularPrecioFinal(suite, reservaEjemplo, "alta");
        System.out.println("Precio final suite con promociones: $" + precioFinal);
        
        // 7. PERSONAL ESPECIALIZADO (ISP)
        System.out.println("\n=== PERSONAL EN ACCIÓN ===");
        IPersonalRecepcion recepcionista = new Recepcionista();
        Cliente cliente = new Cliente("Carlos López", "carlos@email.com", "123456789");
        recepcionista.registrarCliente(cliente);
        
        // 8. SERVICIOS DE HABITACIÓN (ISP)
        System.out.println("\n=== SERVICIOS DE HABITACIÓN ===");
        ControladorServicios controladorServicios = new ControladorServicios();
        controladorServicios.gestionarServiciosHabitacion(suite);
        controladorServicios.gestionarServiciosHabitacion(individual);
        
        // 9. CANCELACIÓN CON NOTIFICACIÓN
        System.out.println("\n=== CANCELANDO RESERVA ===");
        controlador.cancelarReserva(101, inicio1, fin1, "Juan Pérez", "Cambio de planes");
        
        // 10. CAMBIAR CANAL DE NOTIFICACIONES (DIP en acción)
        System.out.println("\n=== CAMBIANDO A SMS ===");
        CanalNotificacion canalSMS = new EnviadorSMS();
        controlador.getNotificador().setCanalNotificacion(canalSMS);
        
        // Nueva reserva con SMS
        Date inicio3 = sdf.parse("2024-12-26");
        Date fin3 = sdf.parse("2024-12-28");
        controlador.crearReserva(102, inicio3, fin3, "Ana Rodríguez");
        
        System.out.println("\n=== SISTEMA HOTELERO OPERATIVO ===");
    }
}



