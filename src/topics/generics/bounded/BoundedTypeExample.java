package topics.generics.bounded;

import java.util.Arrays;
import java.util.List;

public class BoundedTypeExample {
    //Upper bounded - accepts Number and its subclasses
    public static <T extends Number> double calculateSum(List<T> numbers) {
        double sum = 0.0;
        for(T number : numbers){
            sum += number.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double calculateAverage(List<T> numbers){
        if(numbers.isEmpty())
            return 0.0;
        return calculateSum(numbers)/numbers.size();
    }

    public static <T extends Number> T findMax(List<T> numbers){
        if(numbers.isEmpty()){
            return null;
        }
        T max = numbers.get(0);
        for(T number : numbers){
            if(number.doubleValue() > max.doubleValue()){
                max = number;
            }
        }
        return max;
    }

    public static <T extends Number> T findMin(List<T> numbers){
        if(numbers.isEmpty()){
            return null;
        }
        T min = numbers.get(0);
        for(T number : numbers){
            if(number.doubleValue()<min.doubleValue()){
                min = number;
            }
        }
        return min;
    }

    public static <T extends Number & Comparable<T>> T findMaxWithComparable(List<T> numbers){
        if(numbers.isEmpty()){
            return null;
        }
        T max = numbers.get(0);
        for(T number : numbers){
            if(number.compareTo(max) > 0){
                max = number;
            }
        }
        return max;
    }
    static void main() {
        System.out.println("=== Integer List Tests ===");
        List<Integer> intList = Arrays.asList(10,20,30,40,50);
        System.out.println("List: "+ intList);
        System.out.println("Sum: "+ calculateSum(intList));
        System.out.println("Average: "+ calculateAverage(intList));
        System.out.println("Max: " + findMax(intList));
        System.out.println("Min: " + findMin(intList));
        System.out.println("Max (with Comparable): " + findMaxWithComparable(intList));

        System.out.println("\n=== Double List Tests ===");
        List<Double> doubleList = Arrays.asList(1.5, 2.7, 3.2, 4.9, 5.1);
        System.out.println("List: " + doubleList);
        System.out.println("Sum: " + calculateSum(doubleList));
        System.out.println("Average: " + calculateAverage(doubleList));
        System.out.println("Max: " + findMax(doubleList));
        System.out.println("Min: " + findMin(doubleList));

        System.out.println("\n=== Float List Tests ===");
        List<Float> floatList = Arrays.asList(10.5f, 20.3f, 15.7f, 8.2f);
        System.out.println("List: " + floatList);
        System.out.println("Sum: " + calculateSum(floatList));
        System.out.println("Average: " + calculateAverage(floatList));
        System.out.println("Max: " + findMax(floatList));
        System.out.println("Min: " + findMin(floatList));
    }


}
