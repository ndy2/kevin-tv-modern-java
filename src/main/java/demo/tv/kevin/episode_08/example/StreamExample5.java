package demo.tv.kevin.episode_08.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StreamExample5 {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1L, "A", new BigDecimal("10.00")),
                new Product(2L, "B", new BigDecimal("23.00")),
                new Product(3L, "C", new BigDecimal("31.45")),
                new Product(4L, "D", new BigDecimal("80.20")),
                new Product(5L, "E", new BigDecimal("7.50"))
        );

        System.out.println("Products.price >= 30 : "+
            products.stream()
                    .filter(p -> p.getPrice().compareTo(new BigDecimal("30"))>=0)
                    .collect(toList())
        );
        System.out.println("\n================================");
        System.out.println("Products.price >= 30 (with joining(\"\\n\")) : \n"+
                products.stream()
                        .filter(p -> p.getPrice().compareTo(new BigDecimal("30"))>=0)
                        .map(Product::toString)
                        .collect(joining("\n"))
        );

        System.out.println("\n================================");
        System.out.println("IntStream.sum: " +
              IntStream.of(1, 2, 3, 4, 5)
                      .sum()
        );
        System.out.println("\n================================");
        System.out.println("Total Price : " +
            products.stream()
                    .map(product -> product.getPrice())
                    .reduce(BigDecimal.ZERO, (p1, p2) -> p1.add(p2))
        );
        System.out.println("\n================================");
        System.out.println("Total Price filter by(>=30) : " +
                products.stream()
                        .filter(p -> p.getPrice().compareTo(new BigDecimal("30"))>=0)
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );

        System.out.println("\n================================");
        System.out.println("# filter by(>=30) : " +
                products.stream()
                        .filter(p -> p.getPrice().compareTo(new BigDecimal("30"))>=0)
                        .count()
        );
        OrderedItem oi1 = new OrderedItem(1L, products.get(0), 1 );
        OrderedItem oi2 = new OrderedItem(1L, products.get(2), 3 );
        OrderedItem oi3 = new OrderedItem(1L, products.get(4), 10 );

        Order order = new Order(1L,"first-order", Arrays.asList(oi1, oi2, oi3));

        System.out.println("\n================================");
        System.out.println("order.totalPrice() : " + order.totalPrice());

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

    public BigDecimal totalPrice() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}

@Data
@AllArgsConstructor
class Order{
    private Long id;
    private String orderId;
    private List<OrderedItem> orderedItems;

    public BigDecimal totalPrice(){
        return  orderedItems.stream()
                .map(oi -> oi.totalPrice())
                .reduce(BigDecimal.ZERO, (p1, p2) -> p1.add(p2));
    }
}

