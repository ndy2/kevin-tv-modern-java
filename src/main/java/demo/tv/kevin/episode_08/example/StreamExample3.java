package demo.tv.kevin.episode_08.example;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Stream 특징 - Lazy : 결과를 달라고 할때 까지 아무것도 안함
 *  - Stream Method 의 종류
 *  1. Intermediate Operation Method
 *      - Stream 을 계속 Return 하기 때문에 Method Chaining 적용 가능!
 *      - e.g.) filter, map
 *  2. Terminal Operation Method
 *      - Optional/ Collection/ String 등 다양한 return
 *      - e.g.) collect, forEach
 */
public class StreamExample3 {

    public static void main(String[] args) {
        System.out.println("Collectors.toList()" +
              Stream.of(1, 3, 3, 5, 5)
                    .filter(i -> i > 2)
                    .map(i -> i * 2)
                    .map(i -> "#" + i)
                    .collect(toList())
        );

        System.out.println("Collectors.toSet() " +
                  Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        );
        System.out.println("Collectors.joining() " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining())
        );
        System.out.println("Collectors.joining(\", \") " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", "))
        );
        System.out.println("Collectors.joining(\", \",\"<\",\">\") " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", ","<",">"))
        );
        System.out.println("distinct + Collectors.joining(\", \") " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(joining(", "))
        );

        System.out.println("disting + Collectors.toList()" +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(toList())
        );


    }
}
