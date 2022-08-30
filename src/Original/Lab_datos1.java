package Original;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab_datos1 {

    public static void Ordenar(Scanner sc, String file_name) {
        int cedulaMayor;

        try {
            File originalFile = new File(file_name + ".txt");
            BufferedReader register_cedula = new BufferedReader(new FileReader(originalFile));

            File temp = new File("temp_file.txt");
            PrintWriter register_temp = new PrintWriter(new FileWriter(temp));

            String cedula;
            cedula = register_cedula.readLine();

            while (cedula != null) {
                cedula = register_cedula.readLine();
            }

            register_cedula.close();
            register_temp.close();

        } catch (IOException ex) {
            ex.getStackTrace();
            System.out.println("No se encontró el archivo");
        }

    }

    public static void Llenar_Productos(Scanner in, String file_name) {
        String codigo, descripcion, precio;
        try {
            FileWriter outFile = new FileWriter(file_name + ".txt", false);
            PrintWriter register = new PrintWriter(outFile);
            String hayProducto;
            System.out.println("Hay Producto, si o no");
            hayProducto = in.nextLine();
            while (hayProducto.equalsIgnoreCase("si")) {
                System.out.println("Digite el codigo del producto");
                codigo = in.nextLine();
                while (codigo.length() > 10) {
                    System.out.println("Codigo invalido");
                    System.out.println("Digite el codigo del producto");
                    codigo = in.nextLine();
                }
                System.out.println("Digite la descripción");
                descripcion = in.nextLine();
                while (descripcion.length() > 100) {
                    System.out.println("Descripción muy larga, recuerde que son menos de 100 caracteres");
                    System.out.println("Digite la descripción");
                    descripcion = in.nextLine();
                }
                System.out.println("Digite el precio");
                precio = in.nextLine();
                while (precio.length() > 10) {
                    System.out.println("Precio invalido");
                    System.out.println("Digite el precio");
                    precio = in.nextLine();
                }
                if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {
                    register.println(codigo + "\t" + descripcion + "\t" + precio);
                }
            }
            register.close();
        } catch (IOException ex) {
            ex.getStackTrace();
        }

    }

    public static void Llenar_Facturas(Scanner in, String file_name) {
        String cedulaF, numFactura, codProducto, cantidad;
        try {
            FileWriter outFile = new FileWriter(file_name + ".txt", false);
            PrintWriter register = new PrintWriter(outFile);
            String hayFactura;
            System.out.println("Hay factura, si o no");
            hayFactura = in.nextLine();
            while (hayFactura.equalsIgnoreCase("si")) {
                System.out.println("Digite la cedula indicada en la factura");
                cedulaF = in.nextLine();
                while (cedulaF.length() > 10) {
                    System.out.println("Cedula invalida");
                    System.out.println("Digite la cedula indicada en la factura");
                    cedulaF = in.nextLine();
                }
                System.out.println("Digite el numero de la factura");
                numFactura = in.nextLine();
                while (numFactura.length() > 10) {
                    System.out.println("Factura invalida");
                    System.out.println("Digite el numero de la factura");
                    numFactura = in.nextLine();
                }
                System.out.println("Digite el codigo del producto");
                codProducto = in.nextLine();
                while (codProducto.length() > 10) {
                    System.out.println("Codigo invalido");
                    System.out.println("Digite el codigo del producto");
                    codProducto = in.nextLine();
                }
                System.out.println("Digite la cantidad del producto");
                cantidad = in.nextLine();
                while (cantidad.length() > 5) {
                    System.out.println("Cantidad invalida");
                    System.out.println("Digite la cantidad del producto");
                    cantidad = in.nextLine();
                }

                if (!cedulaF.isEmpty() && !numFactura.isEmpty() && !codProducto.isEmpty() && !cantidad.isEmpty()) {
                    register.println(cedulaF + "\t" + numFactura + "\t" + codProducto
                            + "\t" + cantidad);
                }
            }
            register.close();
        } catch (IOException ex) {
            ex.getStackTrace();

        }
    }

    public static void Llenar_Clientes(Scanner in, String file_name) {
        String id, name, dir, tel, email;

        try {
            FileWriter outFile = new FileWriter(file_name + ".txt", false);
            PrintWriter register = new PrintWriter(outFile);

            int hay_clientes = 0;
            System.out.println("Hay clientes? 1 = si, 2 = no");
            hay_clientes = Integer.parseInt(in.nextLine());
            while (hay_clientes < 1 || hay_clientes > 2) {
                System.out.println("Por favor ingrese una opción válida");
                System.out.println("Hay clientes? true = si, false = no");
                hay_clientes = Integer.parseInt(in.nextLine());
            }
            while (hay_clientes == 1) {
                System.out.println("Cédula");
                id = in.nextLine();
                System.out.println("Nombre");
                name = in.nextLine();
                System.out.println("Dirección");
                dir = in.nextLine();
                System.out.println("Celular");
                tel = in.nextLine();
                System.out.println("Correo");
                email = in.nextLine();

                if (!id.isEmpty() && !name.isEmpty() && !dir.isEmpty() && !tel.isEmpty() && !email.isEmpty()) {
                    register.println(id + "\t" + name + "\t" + dir
                            + "\t" + tel + "\t" + email);
                }

                System.out.println("Hay clientes? 1 = si, 2 = no");
                hay_clientes = Integer.parseInt(in.nextLine());

            }

            register.close();

        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file_name = in.nextLine();
        Llenar_Clientes(in, file_name);
        in.close();
        Ordenar(in, file_name);
    }
}
