package demo.tv.kevin.episode_08.example;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {

    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i -> System.out.print(i+" "));
        
        //계속 올라감
//        IntStream.iterate(1, i -> i+1).forEach(i-> System.out.print(i+" "));
//        Stream.iterate(BigInteger.ONE, i->i.add(BigInteger.ONE)).forEach(i-> System.out.print(i+" "));
    }
}
