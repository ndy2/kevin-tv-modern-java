package demo.tv.kevin.episode_08.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Java 의 auto boxing 과 unboxing 이 일어나는 방식을 알아야함
 *    - auto boxing : i = 1;
 *      =>  i = new Integer(1); (X)
 *      =>  i = Integer.valueOf(1); (O) => Integer Object 리턴함 - 일종의 Factory Method
 *          -> 뭐가 다른가?
 *          -> valueOf 메소드는 캐시를 한다.
 * 인티저 캐시!!! (-128 ~ 127)
 */
public class StreamExample4 {

    public static void main(String[] args) {

        Integer integer3 = 3;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5)
                        .filter(i -> i== integer3)
                        .findFirst()
        );

        Integer integer127 = 127;
        System.out.println(
                Stream.of(1, 2, 3, 4, 127)
                        .filter(i -> i== integer127)
                        .findFirst()
        );

        Integer integer128 = 128;
        System.out.println(
                Stream.of(1, 2, 3, 4, 128)
                        .filter(i -> i== integer128)
                        .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 128)
                        .filter(i -> i.equals(integer128))
                        .findFirst()
        );

        //오...

        //primitive 타입 비교 中
        System.out.println( "count : " +
                Stream.of(1, 2, 3, 4, 128)
                        .filter(i -> i > 3)
                        .count()
        );

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //forEach문 사용 가능 = iterable의 구현체 이거나 배열
        //External iterator 사용
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }

        //Internal iterator
        Stream.of(1, 2, 3, 4, 5)
                .forEach(i -> System.out.print(i+" "));

    }
}
