import java.util.ArrayList;

class Producto implements Comparable{
  ArrayList<Factura>facturas;
  long codigo,precio;
  String descripcion;
  
  Producto(long codigo,String descripcion, long precio){
    facturas = new ArrayList<Factura>();
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.precio = precio;
  }
  @Override
    public int compareTo(Object o) {
      long compareage=((Producto)o).codigo;
      return (int) (this.codigo-compareage);
         // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  @Override
public String toString() {
  return "codigo del producto: "+String.valueOf(this.codigo)+",descripción del producto"+String.valueOf(this.descripcion)+", precio: "+String.valueOf(this.precio)+"\n";
  
}
}