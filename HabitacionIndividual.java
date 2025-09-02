package Practica1;

//Subclase HabitacionIndividual
public class HabitacionIndividual extends Habitacion {
 public HabitacionIndividual(int numero, double precioBase) {
     super(numero, "Individual", precioBase);
 }

 // Sobrescribimos calcularPrecio respetando el contrato de la clase base
 @Override
 public double calcularPrecio(String temporada, double descuento) {
     // Reutilizamos la lógica base, pero añadimos un pequeño ajuste específico
     double precio = super.calcularPrecio(temporada, descuento);
     return precio; // No rompemos expectativas: sigue devolviendo un precio válido
 }
}

//Subclase HabitacionDoble
public class HabitacionDoble extends Habitacion {
 public HabitacionDoble(int numero, double precioBase) {
     super(numero, "Doble", precioBase);
 }

 @Override
 public double calcularPrecio(String temporada, double descuento) {
     double precio = super.calcularPrecio(temporada, descuento);
     // Habitacion doble cobra un 10% adicional por capacidad
     return precio * 1.1;
 }
}

//Subclase HabitacionSuite
public class HabitacionSuite extends Habitacion {
 public HabitacionSuite(int numero, double precioBase) {
     super(numero, "Suite", precioBase);
 }

 @Override
 public double calcularPrecio(String temporada, double descuento) {
     double precio = super.calcularPrecio(temporada, descuento);
     // Suites tienen un cargo adicional fijo
     return precio + 50;
 }
}
