from itertools import combinations

# La lista principal de listas
lists = [[-1,0,1,2,-1,-4],[],[5,6,4,3,0],[2,2,5,-1,-1,0,-4]]

# La lista de resultados
results = []

# Recorre cada sublista en la lista principal
for lst in lists:
    # Obtiene todas las combinaciones de tres elementos de la sublista
    combs = combinations(lst, 3)
    # Verifica si la suma de cada combinación es igual a cero
    for comb in combs:
        if sum(comb) == 0:
            # Si es así, agrega la combinación a la lista de resultados
            results.append(comb)

# Imprime la lista de resultados
print(results)