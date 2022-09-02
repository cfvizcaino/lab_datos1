/*Esto es para poder tener el celular y la cédula como tipo de dato númerico,
debido a que el tipo de dato entero se sale del rango.
 */
import java.util.*;
import java.util.ArrayList;

class Cliente implements Comparable {

    // como el cliente puede tener varias facturas se crea el arraylist facturas aquí
    ArrayList<Factura> facturas;
    long cedula, celular;
    String nombre, direccion, email;
    long totalAPagar;
    // constructor 

    Cliente(long cedula, long celular, String nombre, String direccion, String email) {
        facturas = new ArrayList<Factura>();
        this.totalAPagar = 0;
        this.cedula = cedula;
        this.celular = celular;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
    }

    @Override
    /*
  El comparator para el araylist es una interface la cual se utiliza para ordenar
  un arraylist según un objeto el cual el usuario crea
     */
    public int compareTo(Object o) {
        long compareage = ((Cliente) o).cedula;
        return (int) (this.cedula - compareage);
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public void calcularTotal() {
        int sumaFacturas = 0;
        for (Factura f : this.facturas) {
            // sumF = 0;
            sumaFacturas += f.producto.precio * f.cantidad;
        }
        this.totalAPagar = sumaFacturas;
    }

    @Override
    public String toString() {
        // se ejecuta primero el metodo calcular total para que el total A pagar funcione
        this.calcularTotal();
        return "cedula: " + String.valueOf(this.cedula) + ",celular: " + String.valueOf(this.celular) + ",nombre: " + this.nombre + ",dirección: " + this.direccion + ",email: " + this.email + ",total a Pagar: " + this.totalAPagar + "\n";
    }

}
