package demo.tv.kevin.episode_11.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Method Reference 를 사용해서 Method 를
 * 일반 데이터처럼 사용할 수 있는지에 대해 확인
 */
public class MethodReferenceExample2 {
    /* First Class Function*/
    public static void main(String[] args) {
        methodRef1();
        methodRef2();
        methodRef3();
    }

    /*Function can be passed as a parameter to another function.*/
    private static void methodRef1(){
        /*
         * Using Lambda Expression
        * */
        String result = testFirstClassFunc1(1, i -> "#" + i);
        System.out.println(result);
        /*
        * Using Method Reference
         */
        String result2 = testFirstClassFunc1(1, MethodReferenceExample2::addHashTag);
        System.out.println(result2);
    }

    private static String addHashTag(int i){
        return "#" + i;
    }

    private static String testFirstClassFunc1(int n, Function<Integer, String> f){
        return "The result is " + f.apply(n);
    }

    /*Function can be returned as the result of another function.*/
    private static void methodRef2() {
        /*
         * Using Lambda Expression
         * */
        Function<Integer, String> addHashTagUsingLambda = getAddHashTagUsingLambda();
        System.out.println(addHashTagUsingLambda.apply(10));
        /*
         * Using Method Reference
         */

        Function<Integer, String> addHashTagUsingMethodRef = getAddHashTagUsingMethodRef();
        System.out.println(addHashTagUsingMethodRef.apply(10));
    }

    private static Function<Integer, String> getAddHashTagUsingLambda(){
        return i -> "#"+i;
    }

    private static Function<Integer, String> getAddHashTagUsingMethodRef(){
        return MethodReferenceExample2::addHashTag;
    }

    /*Function can be stored in the data structure.*/
    private static void methodRef3() {
        /*
         * Using Lambda Expression
         * */
        List<Function<Integer,String>> fsl
                = Arrays.asList(
                         i -> "#" + i,
                         i -> "##" + i,
                         i -> "###" + i
                 );
        for (Function<Integer, String> function : fsl) {
            System.out.println(function.apply(10));
        }

        /*
         * Using Method Reference
         */
        List<Function<Integer,String>> fsl2
                = Arrays.asList(
                MethodReferenceExample2::addHashTag,
                i -> "##" + i,
                i -> "###" + i
        );
        for (Function<Integer, String> function : fsl2) {
            System.out.println(function.apply(10));
        }

        Function<Integer,String> function = MethodReferenceExample2::addHashTag;
    }

}
