import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

        //👉 1. Stream.ofNullable --------------------------------------------------------------------------------------
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", null, "David", "Edward", null, "Frank");
        List<String> nonNullNames = names.stream().flatMap(Stream::ofNullable).toList();
        System.out.println(nonNullNames);

        //👉 2. Stream.iterate -----------------------------------------------------------------------------------------
        Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);


        //👉 3. Collectors.collectingAndThen ---------------------------------------------------------------------------
        List<Person> list = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 48),
                new Person("Charlie", 28)
        );
        Long collect = list.stream()
                .mapToDouble(Person::getAge).boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingDouble(Double::doubleValue),
                        Math::round)
                );

        System.out.println("collectors.collecting_and_then " + collect);

        //👉 4. Stream.takenWhile and Stream.dropWhile -----------------------------------------------------------------

        /** we can take element from list based on condition */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream().takeWhile(n -> n < 5).forEach(System.out::println);

        //we can drop element from list based on condition
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers2.stream().dropWhile(n -> n < 5).forEach(System.out::println);


    }
}