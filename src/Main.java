import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1. Stream.ofNullable
        //2. Stream.iterate
        //3. Collectors.collectingAndThen
        //4. Stream.takenWhile and Stream.dropWhile
        //5. Collectors.teeing
        //6. Stream.concat
        //7. Collectors.partitioningBy
        //8. IntStream for Ranges

        //1. Stream.ofNullable -----------------------------------------------------------------------------------------
        // Initialize a list of names, including null values
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", null, "David", "Edward", null, "Frank");

        // Use Java 8 Stream API to process the list
        // The `flatMap` method is used with `Stream::ofNullable` to filter out null values
        // The `toList` method is used to collect the result into a new list
        List<String> nonNullNames = names.stream().flatMap(Stream::ofNullable).toList();
        System.out.println(nonNullNames);

        //2. Stream.iterate --------------------------------------------------------------------------------------------
        // Use the `Stream.iterate` method to generate an infinite stream of odd numbers starting from 1
        // The first argument to `Stream.iterate` is the initial element (1 in this case)
        // The second argument is a lambda function that takes the current number and returns the next number
        // (n -> n + 2 in this case, which generates the next odd number)
        // This will result in an infinite stream of odd numbers: 1, 3, 5, 7, 9, 11, 13, ...
        Stream.iterate(1, n -> n + 2)

        // The `limit` method is used to truncate the infinite stream after the first 10 elements
        // This results in a finite stream of the first 10 odd numbers: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19
        .limit(10)
        .forEach(System.out::println);

        //3. Collectors.collectingAndThen ------------------------------------------------------------------------------

    }
}