import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The system you work with on a daily basis runs multiple microservices.
You have been asked to prepare an aggregation that represents the
number of user visits to all microservices, for use by data analysts.
The architect you're working with has already designed the API, which
consists of a single class: VisitCounter. VisitCounter has a single method,
count.
It returns Map<Long, Long> - this map should contain the number of visits by
the user with a given ID.
This method accepts an array of Map<String, UserStats>. Every map
represents the total number of visits per user to a given microservice.
There are some problems, however:
The map key, which is a String, should be parseable to Long - but it may not be. You must skip any such faulty entries.(())
For some keys, UserStats may be null. You must skip any such faulty
entries.(())
UserStats has a single field, visitCount, of type Optional<Long>. A
getter for this field is also implemented. This field will never be null;
however, it might be empty. You must skip any such faulty entries.(())
Remember that you may receive some invalid input: null, empty maps, and
so on. Handle it all appropriately and return an empty map.
You may use Java 8 Streams API to implement your solution
 * 
 */

public class VisitCounter {
    public Map<Long, Long> count(Map<String, UserStats>[] maps) {
        return Stream.of(maps)
            .filter(map -> map != null) // filter out null maps
            .flatMap(map -> map.entrySet().stream()) // flatten the map
            .filter(entry -> entry.getKey() != null && isLong(entry.getKey())) // filter out invalid keys
            .filter(entry -> entry.getValue() != null) // filter out null values
            .filter(entry -> entry.getValue().getVisitCount().isPresent()) // filter out empty visitCount
            .collect(Collectors.groupingBy(entry -> Long.parseLong(entry.getKey()), // group by user ID
                                            Collectors.summingLong(entry -> entry.getValue().getVisitCount().get()))); // sum visitCount
    }

    private boolean isLong(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
