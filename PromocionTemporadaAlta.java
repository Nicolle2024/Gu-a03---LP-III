/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

package Practica1;

public class PromocionTemporadaAlta implements Promocion {
    @Override
    public double aplicarDescuento(double precioBase, Reserva reserva) {
        return precioBase * 0.9;
    }
}


