package topics.collection.set.problems;

import java.util.HashSet;
import java.util.Set;

public class SetProblem2 {
    //Find First Non-Repeating Character
    public static char firstNonRepeating (String str){
        Set<Character> seen = new HashSet<>();
        Set<Character> repeated = new HashSet<>();

        for(char c : str.toCharArray()){
            if(seen.contains(c)){
                repeated.add(c);
            }else{
                seen.add(c);
            }
        }

        for(char c : str.toCharArray()){
            if(!repeated.contains(c)){
                return c;
            }
        }
        return '\0';
    }
    static void main() {
        System.out.println(firstNonRepeating("programming"));
    }
}



