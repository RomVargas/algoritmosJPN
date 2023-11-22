import java.util.stream.IntStream;

public class Streams {
    //Como crear un stream
    
    Stream<Integer> myStream = anyCollection.Stream();
    Stream<Integer> myStream = Arrays.Stream(anyArray);
    Stream<Integer> myStream = Stream.of(1,2,3);
    intStream myStream =IntStream.range(1, 10);

    /* 
    Metodos finales - Cierran el Stream y ya no se puede trabajar con el
      count() -> regresa numero total de elementos del stream
      forEach(Consumer<? extends T> consumer)  -> realiza una accion para cada elemnto
      reduce(BinaryOperator<? super T> accomulator) -> Realiza la reduccion de todos los elementos del stream a un solo elemento
      max(Comparator<? super T> comparator) -> Regersa el mayor elemnto encontrado en base al comparador pasado por parametro
      min(Comparator<? super T> comparator) -> Regresa el menor elemento encontrado en base al comparador pasaado por parametro
      findFirst() -> Regresa el primer elemento del stream en Objeto de tipo Optional
      findAny() -> Regresa un elemto aleatorio del stream en un Objeto de tipo Optional
      anyMatch(Predicate<? super T> predicate) -> Regresa true si encuentra un elemento que coincida con el predicado
      allMatch(Predicate<? super T> predicate) -> Regresa true si todos los elemntos coinciden con el predicado
      noneMatch(Predicate<? super T> rpedicate) -> Regresa true si ninguno de los elemntos coincide con el predicado

    Metodos Intermedios -> Regresa un stream identico para continuar trabajando
      distinct() -> Regresa un stream sin elementos repetidos
      limit(long n) -> Regresa un nuevo stream con los prrimeros elemntos pasados por parametro
      skip(long n) -> Regresa un nuevo stream a partir del elemento pasado por parametro
      peek(Consumer<? extends T> consumer) -> Realiza una accion pára cada elemento del stream y regregresa un stream identico para continuar el pipeline.
      sorted(Comparator<? extends T> comparator) -> Ordena los elementos en base al comparador pasado por parametro, en caso de no pasar ningun comparadaor los elemntos se ordenen de forma natural
      map
      faltMap
      takeWhile(Predicate<? super T> predicate) -> Regresa un stream con todos los elemntos anteriores al elemnto que cumpla el predicado(se recomienda ordenar elñ stream antes de aplicar esta funcion)
      dropWhile(Predicate<? super T> predicate) ->
    */ 
}
