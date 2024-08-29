
palabras = ["abc", "cba", "qwe", "ewq", "fgh"]
lista = {}
salida = [["abc","cba"],["qwe", "ewq"], ["fgh"]]
for palabra in palabras:
    lista_anagramas=[]
    for letra in palabra:
        if letra not in lista:
            lista[letra] = 1
        else:
            lista[letra] = lista[letra] + 1

print(lista)

def encontrar_anagramas(palabras):
    anagramas = {}
    
    for palabra in palabras:
        # Ordenar la palabra alfabéticamente
        palabra_ordenada = ''.join(sorted(palabra))
        
        # Si la palabra ordenada no está en el diccionario, agregarla
        if palabra_ordenada not in anagramas:
            anagramas[palabra_ordenada] = []
        
        # Agregar la palabra original a la lista correspondiente en el diccionario
        anagramas[palabra_ordenada].append(palabra)
    
    # Convertir los valores del diccionario en una lista de listas
    salida = list(anagramas.values())
    print(anagramas) 
    return salida

# Ejemplo de uso
palabras = ["abc", "cba", "qwe", "ewq", "fgh"]
salida = encontrar_anagramas(palabras)
print(salida)
