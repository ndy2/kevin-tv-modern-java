package demo.tv.kevin.episode_07.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1L, "A", new BigDecimal("10.00")),
                new Product(2L, "B", new BigDecimal("11.00")),
                new Product(3L, "C", new BigDecimal("55.00")),
                new Product(4L, "D", new BigDecimal("20.00")),
                new Product(5L, "E", new BigDecimal("34.00"))
        );

        List<Product> result = new ArrayList<>();
        BigDecimal criteria = new BigDecimal("20.00");
        for (Product product : products) {
            if(product.getPrice().compareTo(criteria)>=0){
                result.add(product);
            }
        }
        System.out.println(result);

        List<Product> result2 = filter(products, p -> p.getPrice().compareTo(new BigDecimal(20))>=0);
        System.out.println(result2);

        Predicate<Product> predicate = p ->
                p.getPrice().compareTo(new BigDecimal("50")) > 0;

        List<Product> expensiveProducts = filter(products, predicate);
        System.out.println("expensiveProducts = " + expensiveProducts);

        List<DiscountedProduct> discountedProducts = map(expensiveProducts, DiscountedProduct::new);
        System.out.println("discountedProducts = " + discountedProducts);
        
        List<DiscountedProduct> filteredDiscount = filter(discountedProducts, predicate);
        System.out.println("filteredDiscount = " + filteredDiscount);
    }


    public static <T> List<T> filter(List<T> list, Predicate<? super T> criteria){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if(criteria.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static <T, R> List<R> map(List<T> list, Function<T,R> mapper){
        List<R> mappedList = new ArrayList<>();
        for (T p : list) {
            mappedList.add(mapper.apply(p));
        }
        return mappedList;
    }

}


@ToString(callSuper = true)
class DiscountedProduct extends Product {
    public DiscountedProduct(Product product) {
        super(product.getId(), product.getName(),product.getPrice().multiply(new BigDecimal("0.5")));
    }
}

@Data
@AllArgsConstructor
class Product{
    private Long id;
    private String name;
    private BigDecimal price;
}

@Data
@AllArgsConstructor
class OrderedItem{
    private Long id;
    private Product product;
    private int quantity;
}

@Data
@AllArgsConstructor
class Order{
    private Long id;
    private String orderId;
    private List<OrderedItem> orderedItems;
}
