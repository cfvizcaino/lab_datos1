from encodings import utf_8
from re import S
from timeit import default_timer
from tkinter import W

"""
Se importan la libreria necesaria para que los caracteres especiales del archivo puedan ser leidos por el programa,
y además se importa de la libreira timeit la función para capturar el tiempo que inicia y finaliza nuestro código.

"""

with open("file_agro.txt", encoding="utf-8") as file:

    """
    Se abre el archivo y se declara un contador, una lista y pedimos al usuario ingresar palabra clave para filtrar los datos y
    se inicia el temporizador para tomar el tiempo que se demora buscando los campos con la palabra clave
    """
    numLine = 0
    codigo = []
    cod= input("Ingrese palabras clave a filtar: ")
    codU = cod.upper()
    start= default_timer()
    for line in file:

        """
        El contador empieza a registrar que número es la linea donde se encuentra nuestra palabra clave, se eliminan posibles espacios en el archivo,
        se separa por comas y se empiezan a guardar en la lista las lineas con los campos que tienen la palabra clave.
        """

        numLine +=1
        line = line.rstrip()
        sep = line.split(",")
        if codU in sep:
            codigo.append(str(numLine) + "-" + line)

    """
    Se finaliza en contador, se imprimen las lineas guardadas con los campos que contienen la palabra clave y se hace el calculo
    del tiempo que se tomó en buscar los datos.
    """
    for line in codigo:
        print(line + "\n")
    
    end = default_timer()

time = end - start

print("El tiempo que se demoró en buscar los datos y escribirlos fue de:" , time, "segundos")
