package demo.tv.kevin.episode_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Prelude {

    public static void main(String[] args) {
        int abs1 = Math.abs(-1);
        int abs2 = Math.abs(1);

        System.out.println("(abs1==abs2) = " + (abs1==abs2));

        int abs = Math.abs(Integer.MIN_VALUE);
        System.out.println("abs = " + abs);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(
                map(numbers, i->i*2)
        );

        System.out.println(
                map(numbers, i->i)
        );

        System.out.println(
                map(numbers, Function.identity())
        );
    }

    private static <T, R> List<R> map(List<T> list, Function<T,R> mapper){
        if(mapper == null) mapper = t->(R)t;
        final List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}
