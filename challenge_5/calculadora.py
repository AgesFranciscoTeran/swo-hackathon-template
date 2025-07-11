#!/usr/bin/env python3
"""
Generador de Contraseñas Seguras - Challenge 1

Este programa genera contraseñas seguras cumpliendo:
- Al menos una letra mayúscula (A-Z)
- Al menos una letra minúscula (a-z)
- Al menos un dígito (0-9)
- Al menos un carácter especial (!@#$%^&*)
- Longitud mínima de 8 caracteres
"""

import sys
import random
import string

def generar_contraseña(longitud):
    mayusculas = string.ascii_uppercase
    minusculas = string.ascii_lowercase
    digitos = string.digits
    especiales = "!@#$%^&*"

    # Garantizar al menos un carácter de cada tipo
    contraseña = [
        random.choice(mayusculas),
        random.choice(minusculas),
        random.choice(digitos),
        random.choice(especiales)
    ]
    # Completar el resto de la contraseña
    todos = mayusculas + minusculas + digitos + especiales
    for _ in range(longitud - 4):
        contraseña.append(random.choice(todos))
    random.shuffle(contraseña)
    return ''.join(contraseña)

def main():
    try:
        if len(sys.argv) != 2:
            print("error: se debe enviar el campo longitud y este debe ser de tipo entero")
            sys.exit(1)
        try:
            longitud = int(sys.argv[1])
        except ValueError:
            print("error: se debe enviar el campo longitud y este debe ser de tipo entero")
            sys.exit(1)
        if longitud < 8:
            print("error: la longitud minima para generar la contrasena debe ser de 8")
            sys.exit(1)
        contraseña = generar_contraseña(longitud)
        print(f"la contrasena generada es: {contraseña}")
    except Exception as e:
        print(f"error: {e}")
        sys.exit(1)

if __name__ == "__main__":
    main()
