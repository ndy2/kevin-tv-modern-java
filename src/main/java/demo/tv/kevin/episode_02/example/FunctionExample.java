package demo.tv.kevin.episode_02.example;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<String, String> identityFunc1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        Function<String, String> identityFunc2 = s -> s; //identity function
        Function<String, String> identityFunc3 = Function.identity();

        Function<String, Integer> toInt1 = s -> Integer.parseInt(s);
        Function<String, Integer> toInt2 = Integer::parseInt;

        String hello = identityFunc1.apply("hello");
        System.out.println("hello = " + hello);
    }
}
