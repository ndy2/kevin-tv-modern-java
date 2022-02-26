package demo.tv.kevin.episode_02.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Supplier - The Master of Lazy
 */
public class SupplierExample {

    public static void main(String[] args) {
        Supplier<String> helloSupplier = () -> "hello";
        System.out.println(helloSupplier.get()+" world");

//        printIfValidIndex(0, "hello");
//        printIfValidIndex(-2, " world");

        long start = System.currentTimeMillis();
//        printIfValidIndex(0, getVeryExpensiveValue());
//        printIfValidIndex(-1, getVeryExpensiveValue());
//        printIfValidIndex(-2, getVeryExpensiveValue());

        printIfValidIndexSupplier(0, ()->getVeryExpensiveValue());
        printIfValidIndexSupplier(-1, ()->getVeryExpensiveValue());
        printIfValidIndexSupplier(-2, ()->getVeryExpensiveValue());
        long end = System.currentTimeMillis();
        System.out.println("spend time : " + (end - start) + "ms");
    }

    static void printIfValidIndex(int number, String value){
        if (number >= 0){
            System.out.println("The value is " + value +".");
        } else{
            System.out.println("Invalid");
        }
    }

    static void printIfValidIndexSupplier(int number, Supplier<String> valueSupplier){
        if (number >= 0){
            System.out.println("The value is " + valueSupplier.get() +".");
        } else{
            System.out.println("Invalid");
        }
    }



    static String getVeryExpensiveValue(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Kevin";
    }
}
