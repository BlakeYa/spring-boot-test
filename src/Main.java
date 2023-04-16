import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2,-1,0,1,-3,3,-3};
        System.out.println(main.maxScore(nums));
    }


    public int maxScore(int[] nums) {
                int max = 0;
//                for (int i = 0; i < nums.length; i++) {
//                    for (int j = i+1; j < nums.length; j++) {
//                        int a = nums[i];
//                        int b = nums[j];
//                        int c = 0;
//                        if (a < b){
//                            c = a;
//                            nums[i] = nums[j];
//                            nums[j] = c;
//                        }
//                    }
//                }
        Integer[] numsWrapper = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsWrapper, Comparator.reverseOrder());
        nums = Arrays.stream(numsWrapper).mapToInt(Integer::intValue).toArray();

//                long[] sum = new long[nums.length];
//                for (int i = 0; i < sum.length; i++) {
//                    sum[i] = 0;
//                    for (int i1 = 0; i1 <= i; i1++) {
//                        sum[i] += nums[i1];
//                    }
//                    if (sum[i] > 0) {
//                        max++;
//                    }
//                }
//                return max;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > 0 ){
                max++;
            }
        }
        return max;

        }
}