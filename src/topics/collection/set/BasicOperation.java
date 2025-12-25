package topics.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BasicOperation {
    static void main() {
        Set<String> set = new HashSet<>();

        //Adding elements
        set.add("Java");
        set.add("Python");
        set.add("JavaScript");

        //check size
        System.out.println("Size : "+set.size()); //3
        //checking element is exists
        System.out.println("Contains Java : "+set.contains("Java")); //true
        //removing element
        set.remove("Python");
        //check set is empty
        System.out.println("Is empty: "+set.isEmpty()); //false
        //clear all elements
        set.clear();
        System.out.println(set); //[]


        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6,7,8));

        //Union (all elements from both sets)
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union); //[1, 2, 3, 4, 5, 6, 7, 8]

        // Intersection (common elements)
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection); //[4, 5]

        //Difference (elements in set1 but not in set2)
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference); //[1, 2, 3]

        // Symmetric Difference (elements in either set but not in both)
        Set<Integer> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);
        Set<Integer> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        symmetricDiff.removeAll(temp);
        System.out.println(symmetricDiff); //[1, 2, 3, 6, 7, 8]
    }

}
