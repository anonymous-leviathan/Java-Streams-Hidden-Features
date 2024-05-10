import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers3.stream()
                .takeWhile(n -> n < 5)
                .dropWhile(n -> n < 3)
                .forEach(System.out::println);

        //👉 5. Collectors.teeing --------------------------------------------------------------------------------------
        /* this was introduced in JDK 12 this allows you to perform two collectors
         * in parallel and then apply a third collector to the result of those two collectors.
         * */

        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        String collect1 = numbers4.stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compareTo),
                        Collectors.minBy(Integer::compareTo),
                        (max, min) -> "Max: " + max.orElse(null) + ", Min: " + min.orElse(null)
                ));

        System.out.println("collect id "+collect1);

        //👉 6. Stream.concat -------------------------------------------------------------------------------------------
        List<Integer> numbers5 = Arrays.asList(1, 2, 3);
        List<Integer> numbers6 = Arrays.asList(4, 5, 6);
        Stream.concat(numbers5.stream(), numbers6.stream())
                .forEach(System.out::print);

        System.out.println();

        //👉 7. Collectors.partitioningBy --------------------------------------------------------------------------------
        List<Person> list2 = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 48),
                new Person("Charlie", 28),
                new Person("David", 21),
                new Person("Edward", 32),
                new Person("Frank", 25)
        );

        //partitioningBy is a special case of groupingBy where the resultant map has only two keys
        // true and false. The key true contains the list of elements that satisfy the predicate
        // and the key false contains the list of elements that don't satisfy the predicate.
        list2.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 30))
                .forEach((key, value) -> System.out.println(key + " -> " + value));

        //👉 8. IntStream for Ranges -----------------------------------------------------------------------------------
        List<Integer> collect2 = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        System.out.println(collect2);//[1, 2, 3, 4, 5, 6, 7, 8, 9]

        List<Integer> collect3 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        System.out.println(collect3);//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    }
}