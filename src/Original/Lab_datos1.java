package Original;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Lab_datos1 {

    public static void Ordenar(Scanner sc, String file_name, int cont) {
        Llenar_Clientes(sc, file_name, cont);
        cont = sc.nextInt();
        boolean hay = false;
        int tempo[] = new int[cont];
        System.out.println(cont);
        int cont2 = 0;
        while (hay == false) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file_name + ".txt"));
                String line = null;

                while ((line = br.readLine()) != null) {
                    String temp[] = line.split("\t");
                    // String temp[] ={1,2,3,4}
                    System.out.println(temp[0] + "," + temp[1] + "," + temp[2]);
                    int temporal = Integer.parseInt(temp[0]);
                    if (cont2 < cont) {
                        tempo[cont2] = temporal;
                        cont2++;
                    }
                }
                for (int i = 0; i < tempo.length - 1; i++) {
                    for (int j = 0; j < tempo.length - 1; j++) {
                        if (tempo[j] > tempo[j + 1]) {
                            int tmp = tempo[j + 1];
                            tempo[j + 1] = tempo[j];
                            tempo[j] = tmp;
                        }
                    }
                }
                for (int i = 0; i < tempo.length; i++) {
                    System.out.println("Aca se escribirá el vector en orden");
                    System.out.println(tempo[i]);

                }
                br.close();
                FileWriter ClientesOrg = new FileWriter("ClientesOrg.txt", false);
                PrintWriter register = new PrintWriter(ClientesOrg);
                BufferedReader BR = new BufferedReader(new FileReader(file_name + ".txt"));
                String lines = null;
                String registers= null;
                
                while ((lines = BR.readLine()) != null) {
                    for (int i = 0; i < tempo.length; i++) {
                        if (lines.contains(String.valueOf(tempo[i]))) {
                            register.write(lines); // PREGUNTAR A RACEDO
                        }
                    }
                }
                hay = true;
            } catch (IOException ex) {
                System.out.println("No se encontro archivo");
                hay = false;
                file_name = sc.nextLine(); // Archivo
            }
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

    public static void Llenar_Clientes(Scanner in, String file_name, int cont) {
        String id, name, dir, tel, email;
        List clientes = new Vector();

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
                    cont++;
                }

                System.out.println("Hay clientes? 1 = si, 2 = no");
                hay_clientes = Integer.parseInt(in.nextLine());

            }
            register.close();
            System.out.println(cont);

        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cont = 0;
        String file_name = in.nextLine();
        Ordenar(in, file_name, cont);
        in.close();
    }
}
