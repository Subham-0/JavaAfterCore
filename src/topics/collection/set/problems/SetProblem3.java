package topics.collection.set.problems;

import java.util.HashSet;
import java.util.Set;

public class SetProblem3 {
    //Check if Two Arrays are Disjoint
    public static boolean areDisjoint(int[] arr1,int[] arr2){
        Set<Integer> set = new HashSet<>();
        for(int num : arr1){
            set.add(num);
        }
        for(int num : arr2){
            if(set.contains(num)){
                return false;
            }
        }
        return true;
    }
    static void main() {
        int[] a = {1,2,3};
        int[] b = {4,5,6};

        System.out.println(areDisjoint(a,b));
    }
}
