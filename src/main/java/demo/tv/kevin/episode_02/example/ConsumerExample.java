package demo.tv.kevin.episode_02.example;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerExample {

    public static void main(String[] args) {
        final Consumer<String> printer1 = System.out::println;
        final Function<String,Void> printer2 = s -> {
            System.out.println(s);
            return null;
        };

        printer1.accept("hello");
        printer2.apply("hello");
    }
}
