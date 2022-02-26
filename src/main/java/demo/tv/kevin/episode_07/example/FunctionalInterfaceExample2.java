package demo.tv.kevin.episode_07.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static demo.tv.kevin.episode_07.example.FunctionalInterfaceExample.map;

public class FunctionalInterfaceExample2 {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1L, "A", new BigDecimal("10.00")),
                new Product(2L, "B", new BigDecimal("11.00")),
                new Product(3L, "C", new BigDecimal("55.00")),
                new Product(4L, "D", new BigDecimal("20.00")),
                new Product(5L, "E", new BigDecimal("34.00"))
        );
        List<BigDecimal> prices = map(products, p -> p.getPrice());
        System.out.println("prices = " + prices);

        System.out.println("total : " + total(products, p->p.getPrice() ));
    }


    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper ){
        BigDecimal total = BigDecimal.ZERO;
        for (T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
    }
}
