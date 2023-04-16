package 算法;

import java.util.Arrays;
import java.util.Collections;

public class ArraysTest {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Collections.reverseOrder());
        Arrays.asList(integers).stream().forEach(a-> System.out.println(a));
    }
}
