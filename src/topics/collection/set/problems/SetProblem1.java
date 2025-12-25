package topics.collection.set.problems;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetProblem1 {
    //Remove Duplicates from Array
    public static int[] removeDuplicates(int[] arr){
        Set<Integer> set = new LinkedHashSet<>();

        for(int num: arr){
            set.add(num);
        }

        return  set.stream()
                .mapToInt(n -> n.intValue())
                .toArray();
    }
    static void main() {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        int[] unique = removeDuplicates(array);
        System.out.println(Arrays.toString(unique));
        //[1, 2, 3, 4, 5]
    }
}
