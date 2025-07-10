import json
import datetime as dt

def parse_fecha(texto_fecha):
    try:
        return dt.datetime.strptime(texto_fecha.strip(), "%Y-%m-%d").date()
    except Exception as err:
        raise ValueError(f"Formato de fecha invalido: {texto_fecha}")

def total_calc(monto_base, pagos, fecha_inicio, tasa_anual):
    dias_transcurridos = (dt.date.today() - fecha_inicio).days
    interes = dias_transcurridos * (tasa_anual / 365.0) * float(monto_base) if dias_transcurridos > 30 else 0
    return round(interes, 2), dias_transcurridos

def evaluar_estado(monto_pagado, monto_original, monto_total_con_interes):
    try:
        if monto_pagado >= monto_total_con_interes:
            return "SALDADO"
        elif monto_pagado >= float(monto_original) * 0.8:
            return "AL DIA"
        elif monto_pagado > 0:
            return "EN MORA"
        elif monto_pagado == 0:
            return "SIN PAGOS"
        else:
            return "DESCONOCIDO"
    except:
        return "ERROR"

def r1(c, s, b, f, t):
    try:
        fecha_valida = parse_fecha(f)
        interes_calc, dias = total_calc(b, s, fecha_valida, t)
        pagado = sum(float(x) for x in s if isinstance(x, (int, float)))
        estado = evaluar_estado(pagado, b, float(b) + interes_calc)

        return {
            "Cliente": c,
            "Estado": estado,
            "Pagado": round(pagado, 2),
            "Interes": interes_calc,
            "Deuda Total": round(float(b) + interes_calc, 2),
            "Dias": dias
        }

    except Exception as e:
        return {
            "Cliente": c,
            "Estado": "ERROR",
            "Motivo": str(e)
        }

def leer_archivo_json(ruta):
    with open(ruta, "r", encoding="utf-8") as archivo:
        return json.load(archivo)

def xdata(lista_clientes):
    resultado = []
    for item in lista_clientes:
        resultado.append(
            r1(
                item.get("nombre"),
                item.get("pagos", []),
                item.get("monto_total"),
                item.get("fecha_inicio"),
                item.get("tasa_interes")
            )
        )
    return resultado

def mostrar_tabla(filas):
    print(f"{'Cliente':<15} | {'Estado':<10} | {'Pagado':<8} | {'Interes':<9} | {'Deuda Total':<12} | {'Dias':<5}")
    print("-" * 70)
    for fila in filas:
        if fila["Estado"] != "ERROR":
            print(f"{fila['Cliente']:<15} | {fila['Estado']:<10} | {fila['Pagado']:<8.2f} | {fila['Interes']:<9.2f} | {fila['Deuda Total']:<12.2f} | {fila['Dias']:<5}")
        else:
            print(f"{fila['Cliente']:<15} | ERROR      | Motivo: {fila.get('Motivo', 'Desconocido')}")

if __name__ == "__main__":
    try:
        datos = leer_archivo_json("clientes.json")
        resultado = xdata(datos)
        mostrar_tabla(resultado)
    except Exception as e:
        print("ERROR FATAL:", str(e))
