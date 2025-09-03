/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

public class ControladorReserva {
    private List<Habitacion> habitaciones;
    private NotificadorReserva notificador;
    private CalculadoraPrecioHabitacion calculadoraPrecio;
    private List<Promocion> promociones;
    
    public ControladorReserva(CanalNotificacion canalNotificacion) {
        // ... inicialización ...
        this.calculadoraPrecio = new CalculadoraPrecioHabitacion();
        this.promociones = new ArrayList<>();
    }
    
    public void agregarPromocion(Promocion promocion) {
        promociones.add(promocion);
    }
    
    public double calcularPrecioFinal(Habitacion habitacion, Reserva reserva, String temporada) {
        double precioBase = calculadoraPrecio.calcularPrecio(habitacion, reserva.getInicio(), temporada, 0);
        
        double precioFinal = precioBase;
        for (Promocion promocion : promociones) {
            precioFinal = promocion.aplicarDescuento(precioFinal, reserva);
        }
        
        return precioFinal;
    }
}


