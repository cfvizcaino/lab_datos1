class Factura implements Comparable{
  Producto producto;
  long numFactura,codProductor,cantidad;
  long cedulaF;
  Factura(long cedulaF,long numFactura,long codProductor,long cantidad){
    this.cedulaF = cedulaF;
    this.numFactura = numFactura;
    this.codProductor = codProductor;
    this.cantidad = cantidad;
  }
  public void asignarProducto(Producto producto){
    this.producto = producto;
  }
    @Override
    public int compareTo(Object o) {
      long compareage=((Factura)o).cedulaF;
      return (int) (this.cedulaF-compareage);
         // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
  // toString
  @Override
public String toString() {
  return "cedula: "+String.valueOf(this.cedulaF)+",num Factura: "+String.valueOf(this.numFactura)+", cod Producto: "+String.valueOf(this.codProductor)+",cantidad de producto: "+String.valueOf(this.cantidad)+"\n";
}
}