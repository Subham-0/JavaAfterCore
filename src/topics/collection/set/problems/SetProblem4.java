package topics.collection.set.problems;

import java.util.*;

public class SetProblem4 {

    //Find All Pairs with Given Sum
    public static List<int[]> findPairsWithSum(int[] arr, int target) {
        List<int[]> pairs = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Set<String> usedPairs = new HashSet<>();

        for(int num:arr){
            int complement = target - num;
            if(seen.contains(complement)){
                int a = Math.min(num,complement);
                int b = Math.max(num,complement);

                String key = a +":"+b;
                if(!usedPairs.contains(key)){
                    pairs.add(new int[]{a,b});
                    usedPairs.add(key);
                }
            }
            seen.add(num);
        }

        return pairs;

    }

    static void main() {
        int[] numbers = {1, 5, 7, -1, 5, 3};
        List<int[]> pairs = findPairsWithSum(numbers, 6);
        for(int[] pair :pairs){
            System.out.print(Arrays.toString(pair));
        }
    }

}
