import math

def sumar(a, b):
    """Suma dos números y retorna el resultado."""
    return a + b

def restar(a, b):
    """Resta el segundo número al primero y retorna el resultado."""
    return a - b

def multiplicar(a, b):
    """Multiplica dos números y retorna el resultado."""
    return a * b

def dividir(a, b):
    """Divide el primer número entre el segundo y retorna el resultado.
    Lanza ValueError si el divisor es cero."""
    if b == 0:
        raise ValueError("No se puede dividir por cero")
    return a / b

def potencia(base, exponente):
    """Calcula la potencia de una base elevada a un exponente y retorna el resultado."""
    return base ** exponente

def raiz_cuadrada(x):
    """Calcula la raíz cuadrada de un número.
    Lanza ValueError si el número es negativo."""
    if x < 0:
        raise ValueError("No se puede calcular la raíz cuadrada de un número negativo")
    return math.sqrt(x)

def modulo(a, b):
    """Calcula el módulo (residuo) de la división entre dos números.
    Lanza ValueError si el divisor es cero."""
    if b == 0:
        raise ValueError("No se puede hacer módulo por cero")
    return a % b

def promedio(lista):
    """Calcula el promedio de una lista de números.
    Lanza ValueError si la lista está vacía."""
    if not lista:
        raise ValueError("La lista no puede estar vacía")
    return sum(lista) / len(lista)
