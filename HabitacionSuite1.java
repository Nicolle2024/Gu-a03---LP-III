/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

package Practica1;

import java.util.List;

public class HabitacionSuite extends Habitacion 
    implements ServicioLimpieza, ServicioComida, ServicioLavanderia {
    
    public HabitacionSuite(int numero, double precioBase) {
        super(numero, "Suite", precioBase);
    }

    @Override
    public double calcularPrecio(String temporada, double descuento) {
        double precio = super.calcularPrecio(temporada, descuento);
        return precio + 50;
    }

    // Implementación ServicioLimpieza
    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza premium solicitada para suite " + getNumero());
    }
    
    @Override
    public void marcarComoLimpiada() {
        System.out.println("Suite " + getNumero() + " marcada como limpiada");
    }
    
    // Implementación ServicioComida
    @Override
    public void solicitarComida(String pedido) {
        System.out.println("Servicio comida suite " + getNumero() + ": " + pedido);
    }
    
    @Override
    public void cancelarPedidoComida() {
        System.out.println("Pedido comida cancelado suite " + getNumero());
    }
    
    // Implementación ServicioLavanderia
    @Override
    public void solicitarLavanderia(List<String> prendas) {
        System.out.println("Lavandería suite " + getNumero() + ": " + prendas);
    }
    
    @Override
    public void consultarEstadoLavanderia() {
        System.out.println("Consultando estado lavandería suite " + getNumero());
    }
}
