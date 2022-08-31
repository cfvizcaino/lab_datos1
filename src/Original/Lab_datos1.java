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

public class Lab_datos1 {
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
        int cedulaMin = 999999999;
        String cedulaMin2 = null;
        int cont = 0;
        List<Integer> listaId = new ArrayList<>();

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
                int idT= Integer.parseInt(id);
                listaId.add(idT);
                cont++;
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
            
            File originalFile = new File(file_name + ".txt");
            BufferedReader register_cedula = new BufferedReader(new FileReader(originalFile));
            
            BufferedReader registerNew = new BufferedReader(new FileReader(originalFile));

            File temp = new File("temp_file.txt");
            PrintWriter register_temp = new PrintWriter(new FileWriter(temp));
            String cedular = null;
            cedular = register_cedula.readLine();
            System.out.println(cedular);
            Collections.sort(listaId);
            System.out.println(listaId);
            for (int i = 0; i< listaId.size(); i++) {
                int cedulaT = listaId.get(i);
                register_temp.println(cedulaT + "\t");
            }
            
            // para comparar necesitamo convertir cada objeto del array list a string ya que es lo unico que contiene el metod contains
            String register_t = register_temp.toString();
            for (int i = 0; i< listaId.size(); i++) {
                int cedulaT = listaId.get(i);
                String cedula_T= String.valueOf(cedulaT);
                if (register_t.contains(cedula_T)){
                    System.out.println("Si");
                }
                // pasar al siguiente registro y volver a convertir a string 
            }
            

            register_cedula.close();
            register_temp.close();

        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    public static void main(String[] args) {
        int cont = 0;
        String cedula = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Escriba el nombre del archivo");
        String file_name = in.nextLine();
        Llenar_Clientes(in, file_name);
        //Ordenar(in, file_name);
        in.close();
    }
}
