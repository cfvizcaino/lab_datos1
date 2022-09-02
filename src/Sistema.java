
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.math.BigInteger;

class Sistema {

    Scanner scan;
    ArrayList<Cliente> clientes;
    ArrayList<Factura> facturas;
    ArrayList<Producto> productos;

    Sistema() {
        this.scan = new Scanner(System.in);
        this.clientes = new ArrayList<Cliente>();
        this.facturas = new ArrayList<Factura>();
        this.productos = new ArrayList<Producto>();

        System.out.print("Hola bienvenido al programa:\t");
        txtCliente();
        txtFactura();
        txtProducto();
        ejercicio();

    }

    void txtCliente() {
        //Declarando las variables
        boolean seguir = true;
        int opcion = 1;
        try {
            FileWriter miEscritor = new FileWriter("cliente.txt");
            System.out.println("\n Archivo funcionando y listo para escribir.");

            while (seguir) {
                System.out.print("Digite número de cédula:\t");
                long cedulaCliente = this.scan.nextLong();
                String cedulaClienteT = String.valueOf(cedulaCliente);

                while (cedulaClienteT.length() > 10) {
                    System.out.print("Digite número de cédula:\t");
                    cedulaCliente = this.scan.nextLong();
                    cedulaClienteT = String.valueOf(cedulaCliente);
                }

                this.scan.nextLine();
                System.out.print("Digite número de celular:\t");
                long celularCliente = this.scan.nextLong();
                String celularClienteT = String.valueOf(cedulaCliente);

                while (celularClienteT.length() > 10) {
                    System.out.print("Digite número de cédula:\t");
                    celularCliente = this.scan.nextLong();
                    celularClienteT = String.valueOf(cedulaCliente);
                }
                this.scan.nextLine();
                System.out.print("Digite nombre del cliente:\t");
                String nombreCliente = this.scan.nextLine();
                while (nombreCliente.length() > 20) {
                    System.out.print("Digite nombre del cliente:\t");
                    nombreCliente = this.scan.nextLine();
                }
                System.out.print("Digite direccion del cliente:\t");
                String direccionCliente = this.scan.nextLine();
                while (direccionCliente.length() > 20) {
                    System.out.print("Digite direccion del cliente:\t");
                    direccionCliente = this.scan.nextLine();
                }
                System.out.print("Digite correo del cliente:\t");
                String correoCliente = this.scan.nextLine();
                while (correoCliente.length() > 30) {
                    System.out.print("Digite correo del cliente:\t");
                    correoCliente = this.scan.nextLine();
                }
                // se añaden los datos al arraylist
                clientes.add(new Cliente(cedulaCliente, celularCliente, nombreCliente, direccionCliente, correoCliente));

                System.out.print("Digite el número 1, si desea continuar\t ó\t Digite el número 0 si desea parar:\t");
                opcion = this.scan.nextInt();
                // como el scanner estaba volandose una linea se le agregó un nextLine();
                this.scan.nextLine();
                if (opcion == 0) {
                    seguir = false;
                }
            }
            ordenarArrayCliente(clientes);
            recorrerArrayCliente(clientes, miEscritor);
            miEscritor.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    void ordenarArrayCliente(ArrayList<Cliente> clientes) {
        Collections.sort(clientes);
    }

    /* para poder utilizar el sort en el arraylist el cual unicamente no tiene unicamente
        valores enteros. Necesite usar el compare to de los arraylist, el cual se encuentra en cada clase correspondiente
     */
    // aca se recorre el array y se escribe el archivo con el .write
    void recorrerArrayCliente(ArrayList<Cliente> clientes, FileWriter miEscritor) {
        for (Cliente c : clientes) { // logica de esto
            try {
                miEscritor.write(c.toString());
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }

    void txtFactura() {
        //Declarando las variables
        boolean seguir = true;
        int opcion = 1;

        try {
            FileWriter miEscritor2 = new FileWriter("facturas.txt");
            System.out.println("\n Archivo funcionando y listo para escribir.");

            while (seguir) {
                System.out.print("Digite número de cédula a la persona asociada:\t");
                long cedulaF = this.scan.nextLong();
                String cedulaFT = String.valueOf(cedulaF);
                while (cedulaFT.length() > 10) {
                    System.out.print("Digite número de cédula:\t");
                    cedulaF = this.scan.nextLong();
                    cedulaFT = String.valueOf(cedulaFT);
                }
                this.scan.nextLine();
                System.out.print("Digite número de factura:\t");
                long numFactura = this.scan.nextLong();
                String numFacturaT = String.valueOf(numFactura);
                while (numFacturaT.length() > 10) {
                    System.out.print("Digite el numero de factura:\t");
                    numFactura = this.scan.nextLong();
                    numFacturaT = String.valueOf(numFactura);
                }
                this.scan.nextLine();
                System.out.print("Digite código del producto:\t");
                long codProductor = this.scan.nextLong();
                String codProductorT = String.valueOf(codProductor);
                while (codProductorT.length() > 10) {
                    System.out.print("Digite el codigo del producto:\t");
                    codProductor = this.scan.nextLong();
                    codProductorT = String.valueOf(codProductor);
                }
                this.scan.nextLine();
                System.out.print("Digite la cantidad del producto:\t");
                long cantidad = this.scan.nextLong();
                String cantidadT = String.valueOf(cantidad);
                while (numFacturaT.length() > 5) {
                    System.out.print("Digite la cantidad de producto:\t");
                    cantidad = this.scan.nextLong();
                    cantidadT = String.valueOf(cantidad);
                }
                this.scan.nextLine();
                Factura f = new Factura(cedulaF, numFactura, codProductor, cantidad);
                facturas.add(f);
                asignarFactura(f);
                System.out.print("Digite el número 1, si desea continuar\t ó\t Digite el número 0 si desea parar:\t");
                opcion = this.scan.nextInt();
                this.scan.nextLine();
                if (opcion == 0) {
                    seguir = false;
                }
            }
            ordenarArrayFactura(facturas);
            recorrerArrayFactura(facturas, miEscritor2);

            miEscritor2.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    void asignarFactura(Factura factura) {
        for (Cliente c : this.clientes) {
            if (c.cedula == factura.cedulaF) {
                c.agregarFactura(factura);
                break;
            }
        }
    }

    void ordenarArrayFactura(ArrayList<Factura> facturas) {
        Collections.sort(facturas);
    }

    void recorrerArrayFactura(ArrayList<Factura> facturas, FileWriter miEscritor2) {
        for (Factura f : facturas) { // logica de esto
            try {
                miEscritor2.write(f.toString());
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
// si el cliente tiene facturas que las escriba

    public void ejercicio() {
        for (Cliente c : this.clientes) {
            if (c.facturas.size() > 0) {
                System.out.println(c.toString());
            }
        }
    }

    void txtProducto() {
        //Declarando las variables
        boolean seguir = true;
        int opcion = 1;
        // ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            FileWriter miEscritor3 = new FileWriter("productos.txt");
            System.out.println("\n Archivo funcionando y listo para escribir.");

            while (seguir) {
                System.out.print("Digite número de código:\t");
                long codigo = this.scan.nextLong();
                String codigoT = String.valueOf(codigo);
                while (codigoT.length() > 10) {
                    System.out.print("Digite el numero de factura:\t");
                    codigo = this.scan.nextLong();
                    codigoT = String.valueOf(codigo);
                }
                this.scan.nextLine();
                System.out.print("Digite la descripción:\t");
                String descripcion = this.scan.nextLine();
                while (descripcion.length() > 100) {
                    System.out.print("Digite la descripción:\t");
                    descripcion = this.scan.nextLine();

                }
                // this.scan.nextLine();
                System.out.print("Digite el precio:\t");
                long precio = this.scan.nextLong();
                String precioT = String.valueOf(precio);
                while (precioT.length() > 10) {
                    System.out.print("Digite el precio:\t");
                    precio = this.scan.nextLong();
                    precioT = String.valueOf(codigo);
                }
                this.scan.nextLine();
                // System.out.print("Digite direccion del cliente:\t");
                // String direccionCliente = this.scan.nextLine();
                // System.out.print("Digite correo del cliente:\t");
                // String correoCliente = this.scan.nextLine();
                Producto p = new Producto(codigo, descripcion, precio);
                productos.add(p);
                asignarProducto(p);
                System.out.print("Digite el número 1, si desea continuar\t ó\t Digite el número 0 si desea parar:\t");
                opcion = this.scan.nextInt();
                this.scan.nextLine();
                if (opcion == 0) {
                    seguir = false;
                }
            }
            ordenarArrayProducto(productos);
            recorrerArrayProducto(productos, miEscritor3);
            miEscritor3.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
// acá le asignaré el prpducto a la factura

    void asignarProducto(Producto producto) {
        for (Factura f : this.facturas) {
            if (f.codProductor == producto.codigo) {
                f.asignarProducto(producto);
            }
        }
    }

    void ordenarArrayProducto(ArrayList<Producto> productos) {
        Collections.sort(productos);
    }

    void recorrerArrayProducto(ArrayList<Producto> productos, FileWriter miEscritor3) {
        for (Producto p : this.productos) { // logica de esto
            try {
                miEscritor3.write(p.toString());
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }

}
