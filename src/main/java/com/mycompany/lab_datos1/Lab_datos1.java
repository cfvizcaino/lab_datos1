package com.mycompany.lab_datos1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab_datos1 {

    public static void Llenar(Scanner in, String file_name) {
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
        Llenar(in, file_name);
        in.close();
    }
}
