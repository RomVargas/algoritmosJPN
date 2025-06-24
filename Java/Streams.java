import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Comparator;

public class Streams {
    public static void main(String[] args) {
        // Ejemplos de creación de Streams
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = numeros.stream();
        
        Integer[] arrayNumeros = {1, 2, 3, 4, 5};
        Stream<Integer> stream2 = Arrays.stream(arrayNumeros);
        
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        IntStream stream4 = IntStream.range(1, 10);

        // EJEMPLOS PRÁCTICOS

        // Ejemplo 1: Operaciones básicas con Streams
        System.out.println("=== Ejemplo 1: Operaciones básicas ===");
        List<Integer> numeros1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numeros1.stream()
                .filter(n -> n % 2 == 0)        // Filtra números pares
                .map(n -> n * n)                // Eleva al cuadrado
                .forEach(n -> System.out.println("Número procesado: " + n));

        // Ejemplo 2: Reducción y colección de resultados
        System.out.println("\n=== Ejemplo 2: Reducción y colección ===");
        List<String> palabras = Arrays.asList("Java", "Stream", "API", "Ejemplo");
        String resultado = palabras.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Resultado: " + resultado);

        // Ejemplo 3: Operaciones avanzadas
        System.out.println("\n=== Ejemplo 3: Operaciones avanzadas ===");
        List<Integer> numeros2 = Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6);
        numeros2.stream()
                .sorted()
                .distinct()
                .limit(5)
                .peek(n -> System.out.println("Procesando: " + n))
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(avg -> System.out.println("Promedio: " + avg));

        /* 
        EJERCICIOS PARA PRACTICAR:

        1. Dado una lista de números, encuentra la suma de los cuadrados de los números pares
           que sean mayores que 5. */
           Integer[] numeros_pares_filtrados = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
           int suma = numeros.stream()
           .filter(n -> n % 2 == 0 && n > 5)
           .filter(n -> n > 5)
           .map(n -> n * n)
           .reduce(0, Integer::sum);
           System.out.println(suma);
            
           

/* 
        2. Crea un stream que procese una lista de palabras y devuelva una nueva lista
           conteniendo solo las palabras que empiezan con vocal y tienen más de 3 letras
           ordenadas alfabéticamente. */
        String[] palabras_filtradas = {"Hola", "Mundo", "Java", "Stream", "API", "Ejemplo", "Arbol", "Elefante", "Iguana", "Oso", "Uva"};
        String[] palabras_procesadas = Arrays.stream(palabras_filtradas)
                .filter(palabra -> {
                    String primeraLetra = palabra.substring(0, 1).toLowerCase();
                    return "aeiou".contains(primeraLetra) && palabra.length() >= 3;
                })
                .sorted()
                .toArray(String[]::new);
        System.out.println("Palabras que empiezan con vocal y tienen más de 3 letras: " + Arrays.toString(palabras_procesadas));
/*
        3. Implementa un stream que procese una lista de objetos Persona (con nombre y edad)
           y encuentre la persona más joven que sea mayor de edad.
        */

        Persona[] personas = {new Persona("Juan", 20), new Persona("Maria", 18), new Persona("Pedro", 22), new Persona("Ana", 19)};
        Persona persona_mas_joven = Arrays.stream(personas)
        .filter(p -> p.edad >= 18)
        .min(Comparator.comparing(p -> p.edad))
        .orElse(null);
        System.out.println("Persona más joven: " + persona_mas_joven.nombre);

        
      }
}


class Persona {
    String nombre;
    int edad;
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

/* 
MÉTODOS DE STREAMS:

Métodos Finales (Terminales):
- count() -> Cuenta elementos
- forEach(Consumer) -> Acción por elemento
- reduce() -> Reduce a un solo valor
- max/min(Comparator) -> Encuentra máximo/mínimo
- findFirst()/findAny() -> Encuentra elementos
- anyMatch/allMatch/noneMatch(Predicate) -> Verifica condiciones
- collect() -> Recolecta resultados
- toArray() -> Convierte a array
- sum() -> Suma elementos numéricos
- average() -> Calcula promedio

Métodos Intermedios:
- filter(Predicate) -> Filtra elementos
- map(Function) -> Transforma elementos
- flatMap(Function) -> Aplana streams anidados
- distinct() -> Elimina duplicados
- sorted() -> Ordena elementos
- peek(Consumer) -> Inspecciona elementos
- limit(n) -> Limita cantidad
- skip(n) -> Salta elementos
- takeWhile(Predicate) -> Toma elementos hasta condición
- dropWhile(Predicate) -> Ignora elementos hasta condición
*/
