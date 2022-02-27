package demo.tv.kevin.episode_10.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class HighOrderFunctionExample {

    public static void main(String[] args) {
        Function<Function<Integer, String>, String> f = g-> g.apply(10);
        String result = f.apply(i -> "#" + i);
        System.out.println("result = " + result);

        Function<Integer, Function<Integer, Integer>> f2 = i -> (i2-> i+i2);
        System.out.println(
                f2.apply(100).apply(200).toString()
        );

        // 아래의 map 도 HOF 이다. - 함수를 넘김
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(
                map(list, i->"#" + i)
        );

        System.out.println(
            list.stream()
                .map(i -> "#" + i)
                .collect(toList())
        );

        //identity 메소드도 HOF 이다.
        Function<Object, Object> identity = Function.identity();

        //커링 (Currying)
        Function<Integer, Function<Integer, Function<Integer, Integer>>> f3
                = i -> j -> k -> i+j+k;

        Integer result2 = f3.apply(1).apply(2).apply(3);
        System.out.println("result = " + result2);
    }

    private static <T,R> List<R> map(List<T> list, Function<T, R> mapper){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

    //Function 을  First Class Citizen 로 만들고 싶어..
    //그래서 method reference 가 등장 하게 되었다..
}
