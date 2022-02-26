package demo.tv.kevin.episode_02.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        Predicate<String> isAlphabetical1 = s -> s.matches("[a-zA-Z]+");
        Predicate<String> isAlphabetical2 = PredicateExample::alphabetTest;

        System.out.println(isAlphabetical1.test("가나다"));
        System.out.println(isAlphabetical1.test("abc"));

        Predicate<Integer> isPositive = i -> i > 0;

        System.out.println(isPositive.test(-1));
        System.out.println(isPositive.test(1));
        
        List<Integer> numbers = Arrays.asList(-5,-4,-3,-2,-1,1,2,3,4);
        long count = numbers.stream().filter(isPositive).count();
        System.out.println("count = " + count);

        List<Integer> positiveNums = filter(numbers, isPositive);
        List<Integer> lessThan3 = filter(numbers, i -> i < 3);
        System.out.println("positiveNums = " + positiveNums);
        System.out.println("lessThan3 = " + lessThan3);
    }

    private static boolean alphabetTest(String s) {
        return s.matches("[a-zA-Z]+");
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter){
        List<T> result = new ArrayList<>();
        for(T input : list){
            if(filter.test(input)){
                result.add(input);
            }
        }
        return result;
    }
}
