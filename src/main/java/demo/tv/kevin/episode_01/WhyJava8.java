package demo.tv.kevin.episode_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WhyJava8 {

    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        final StringBuilder sb = new StringBuilder();
        /*for (Integer number : numbers) {
            sb.append(number).append(" : ");
        }*/

        /*int size = numbers.size();
        for (int i = 0; i < size; i++) {
            sb.append(numbers.get(i));
            if(i != size-1){
                sb.append(" : ");
            }
        }*/

        /*for (Integer number : numbers) {
            sb.append(number).append(" : ");
        }
        if(sb.length() > 0 ){
            sb.delete(sb.length()-3, sb.length());
        }*/

        /*String result = sb.toString();*/
        final String result = numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" : "));

        System.out.println(result);
    }
}
