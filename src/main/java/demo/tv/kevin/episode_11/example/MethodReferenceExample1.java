package demo.tv.kevin.episode_11.example;

import java.math.BigDecimal;
import java.util.Arrays;

import static java.util.stream.Collectors.*;

public class MethodReferenceExample1 {

    /**
     * Java 에서 Function 은 Method 다
     * Lambda Expression 을 통해 Function 은 First-Class 가 되었다.
     * Method 자체도 First-Class 가 되었다.
     */
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(System.out::println);

        Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                .stream()
                .sorted()   // Comparable 이라서 가능
                .collect(toList());

        Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                .stream()
                .sorted((bd1, bd2) -> BigDecimalUtil.compare(bd1, bd2))
                .sorted(BigDecimalUtil::compare)   // 직접 Comparator 전달
                .collect(toList());

        Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                .stream()
                .sorted((bd1, bd2) -> bd1.compareTo(bd2))
                .sorted(BigDecimal::compareTo)   // 직접 Comparator 전달
                .collect(toList());

        String targetString = "c";
        Arrays.asList("a", "b", "c", "d", "d")
                .stream()
                .anyMatch(x -> x.equals("c"));

        // 특정한 Object 의 Method Reference
        Arrays.asList("a", "b", "c", "d", "d")
                .stream()
                .anyMatch(targetString::equals);
    }
}

class BigDecimalUtil {
    public static int compare(BigDecimal bd1, BigDecimal bd2){
        return bd1.compareTo(bd2);
    }
}
