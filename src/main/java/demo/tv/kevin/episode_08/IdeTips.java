package demo.tv.kevin.episode_08;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Settings>Editor>Code Style>Java>Imports>Packages to User Import with '*'
 */
public class IdeTips {

    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5)
                .collect(toList());

        Set<Integer> collect2 = Stream.of(1, 2, 3, 4, 5)
                .collect(toSet());

    }
}
