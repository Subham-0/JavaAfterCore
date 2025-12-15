package topics.collection.list;

import java.util.*;

public class ListBasicProblem {
    public static void main(String[] args) {

        //Create a List and add elements
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);

        //Find size of a List
        System.out.println(list.size());

        //Check if List is empty
        if(list.isEmpty()) {
            System.out.println("Empty");
        }else {
            System.out.println("Not Empty");
        }

        //Access element by index
        System.out.println(list.get(1));

        //Remove element by value
        list.remove(Integer.valueOf(20));

        //Remove element by index
        list.remove(0);

        // for loop
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));

        // enhanced for
        for(Integer i : list)
            System.out.println(i);

        // iterator
        Iterator<Integer> it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        //Find duplicate elements in List
        List<Integer> list2 = Arrays.asList(1,2,3,2,4,1);

        Set<Integer> set = new HashSet<>(); //for unique value
        for(Integer i : list2){
            if(!set.add(i))
                System.out.println(i);
        }

        //remove duplicates from list
        List<Integer> list3 = Arrays.asList(1,2,3,2,4,1);

        List<Integer> unique = new ArrayList<>(new LinkedHashSet<>(list3));
        System.out.println(unique);

        //sort list in ascending order
        Collections.sort(list);

        //sort list in descending order
        Collections.sort(list,Collections.reverseOrder());

        //reverse a list
        Collections.reverse(list);

        //check element exists or not
        if(list.contains(20))
            System.out.println("Found");
        else
            System.out.println("Not Found");

        //convert list to array
        Integer[] arr = list.toArray(new Integer[0]);

        //convert array to list
        List<Integer> list4 = new ArrayList<>(Arrays.asList(1,2,3));

        //find max and min element
        int max = Collections.max(list4);
        int min = Collections.min(list4);

        //find second largest
        Collections.sort(list);
        int secondLargest = list.get(list.size()-2);

        list4.removeIf(n -> n % 2 == 0);


        System.out.println(list4);

    }
}
