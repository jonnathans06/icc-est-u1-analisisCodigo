import random as rd
import time 
from metodos_ordenamiento import MetodosOrdenamiento

class Benchmarking:
    def __init__(self):
        self.mOrdenamiento = MetodosOrdenamiento()
        print("Bench inicializado")
        array = self.build_arreglo(50000)

        tarea = lambda: self.mOrdenamiento.sortByBubble(array)
        tiempoMillis = self.contar_con_current_time_millis(tarea)
        tiempoNano = self.contar_con_nano_time(tarea)
        print(f'Tiempo millis: {tiempoMillis}')
        print(f'Tiempo nano: {tiempoNano}')

    def build_arreglo(self, size):
        array = []
        for i in range(size):
            numero = rd.randint(0, 50000)
            array.append(numero)
        return array

    def contar_con_current_time_millis(self, tarea):
        inicio = time.time()
        tarea()
        final = time.time()
        return final - inicio

    def contar_con_nano_time(self, tarea):
        inicio = time.time_ns()
        tarea()
        final = time.time_ns()
        return final - inicio /1000000000.0