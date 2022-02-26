package demo.tv.kevin.episode_06.example;

public class CustomFunctionalInterfaceExample {


    public static void main(String[] args) {
        TriFunction<Integer,Integer,Integer,Integer> triFunction = (a,b,c) -> a+2*b+3*c;
        System.out.println(triFunction.apply(1, 2, 3));

        println(1,2,3, (a, b, c) -> String.valueOf(a+b+c));
        println("Area is ",12,20, (message, width, height) -> message + width * height);

    }

    private static  <T1, T2, T3> void println(T1 a, T2 b, T3 c, TriFunction<T1, T2, T3, String> function){
        System.out.println(function.apply(a,b,c));
    }
}

@FunctionalInterface
interface TriFunction<T1, T2, T3, R>{
    R apply(T1 a, T2 b, T3 c);
}