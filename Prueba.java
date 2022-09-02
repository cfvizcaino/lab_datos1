package com.mycompany.prueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Prueba {

    public static void Buscar(Scanner in, String file_name) {
        int cont = 0;
        System.out.print("Ingrese la palabra clave a filtrar: ");
        String word = in.nextLine();
        String wordU = word.toUpperCase();
        try {
            File original = new File(file_name + ".txt");
            BufferedReader leer = new BufferedReader(new FileReader(original));
            String palabra;
            long inicio = System.nanoTime();

            while ((palabra = leer.readLine()) != null) {
                cont++;
                if (palabra.contains(wordU)) {
                    System.out.println(cont + "-" + palabra);
                }
            }

            leer.close();
            long fin = System.nanoTime();
            long resultado = fin - inicio;
            System.out.println("El tiempo que tomó en buscar y escribir los archivos fue de: " + (resultado) + " nanosegundos");
        } catch (IOException ex) {
            ex.getStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file_name = "file_agro";
        Buscar(in, file_name);
        in.close();
    }
}
