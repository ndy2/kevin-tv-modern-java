package demo.tv.kevin.episode_11.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

public class MethodReferenceExample2Constructor {

    public static void main(String[] args) {
        Function<Integer, Section> sectionFactory2 = num -> new Section(num);
        Function<Integer, Section> sectionFactory3 = Section::new;

        Section section = new Section(1);
        Section section2 = sectionFactory2.apply(2);
        Section section3 = sectionFactory3.apply(3);

        System.out.println(section);
        System.out.println(section2);
        System.out.println(section3);

        ProductCreator<ProductA> productCreator = ProductA::new;

        System.out.println("\n==================");
        Product product = new ProductA(1L, "A", new BigDecimal("100"));
        Product product2 = productCreator.create(1L, "A", new BigDecimal("100"));
        ProductA product3 = createProduct(1L, "A", new BigDecimal("100"), ProductA::new);

        System.out.println(product);
        System.out.println(product2);
        System.out.println(product3);

    }

    private static  <T extends Product> T createProduct(Long id, String name, BigDecimal price, ProductCreator<T> creator){
        if(id == null || id <1L){
            throw new IllegalArgumentException("The id must be a positive Long.");
        }
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("The name is not given.");
        }
        if(price == null || BigDecimal.ZERO.compareTo(price)<=0){
            throw new IllegalArgumentException("The price must be greater than 0.");
        }

        return creator.create(id,name,price);
    }
}

@FunctionalInterface
interface ProductCreator<T extends Product> {
    T create(Long id, String name, BigDecimal price);
}

@Data
@AllArgsConstructor
class Section{
    private int number;
}

@Data
@AllArgsConstructor
abstract class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

class ProductA extends Product {

    public ProductA(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "ProductA{}" + super.toString();
    }
}

class ProductB extends Product {

    public ProductB(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "ProductB{}" + super.toString();
    }
}