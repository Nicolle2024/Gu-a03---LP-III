/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

package Practica1;

public interface IPersonalRecepcion {
    void registrarCliente(Cliente cliente);
    void procesarCheckIn(Reserva reserva);
    void procesarCheckOut(Reserva reserva);
}
public class Recepcionista implements IPersonalRecepcion {
    @Override
    public void registrarCliente(Cliente cliente) {
        System.out.println("Registrando cliente: " + cliente.getNombre());
    }
    
    @Override
    public void procesarCheckIn(Reserva reserva) {
        System.out.println("Check-in habitación: " + reserva.getHabitacion().getNumero());
    }
    
    @Override
    public void procesarCheckOut(Reserva reserva) {
        System.out.println("Check-out habitación: " + reserva.getHabitacion().getNumero());
    }
}


