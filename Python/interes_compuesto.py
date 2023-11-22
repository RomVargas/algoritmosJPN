def calcular_interes_compuesto(p, r, n, t, a):
    """
    Calcula el monto total utilizando la fórmula del interés compuesto
    con aportaciones anuales.
    
    p: Monto principal (capital inicial)
    r: Tasa de interés anual (en decimal)
    n: Número de veces que se compone el interés por año
    t: Número de años
    a: Aportación anual
    """
    monto_total = p
    for _ in range(t):
        monto_total += a  # Agregar la aportación anual
        monto_total *= (1 + r/n)**n
    return monto_total

# Entradas del usuario
principal = float(input("Ingresa el monto principal (capital inicial): "))
tasa_interes = float(input("Ingresa la tasa de interés anual (en decimal): "))
compuestos_por_anio = int(input("Ingresa el número de veces que se compone el interés por año: "))
anios = int(input("Ingresa el número de años: "))
aportacion_anual = principal  # Aportación anual igual al monto principal

# Calcula el monto total con interés compuesto y aportaciones anuales
monto_total = calcular_interes_compuesto(principal, tasa_interes, compuestos_por_anio, anios, aportacion_anual)

# Imprime el resultado
print(f"Después de {anios} años, con una tasa de interés del {tasa_interes*100}%, compuesta {compuestos_por_anio} veces al año, y una aportación anual de {aportacion_anual:.2f}, el monto total será: {monto_total:.2f}")