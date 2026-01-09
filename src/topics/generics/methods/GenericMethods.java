package topics.generics.methods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class GenericMethods {
    public static <T> void printArray(T[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static <T> int findIndex(T[] array, T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    public static <T> void swap(T[] array, int index1, int index2) {

        if(index1 < 0 || index1 >= array.length || index2<0){
            System.out.println("Invalid indices!");
            return;
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static <T> void reverse(T[] array) {
        int left = 0;
        int right = array.length-1;
        while(left<right){
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    public static <T> List<T> arrayToList(T[] array){
        return Arrays.stream(array).collect(Collectors.toList());
    }
    static void main() {
        System.out.println("=== Integer Array Tests ===");
        Integer[] intArray = {1,2,3,4,5};
        System.out.println("Original: ");
        printArray(intArray);

        swap(intArray,0,4);
        System.out.print("After swap(0,4): ");
        printArray(intArray);

        reverse(intArray);
        System.out.print("After reverse(0,4): ");
        printArray(intArray);

        int index = findIndex(intArray, 3);
        System.out.println("Index of 3: " + index);

        List<Integer> intList = arrayToList(intArray);
        System.out.println("Converted to List: " + intList);

        System.out.println("\n=== String Array Tests ===");
        String[] stringArray = {"Apple", "Banana", "Cherry", "Date"};
        System.out.print("Original: ");
        printArray(stringArray);

        swap(stringArray, 1, 3);
        System.out.print("After swap(1,3): ");
        printArray(stringArray);

        reverse(stringArray);
        System.out.print("After reverse: ");
        printArray(stringArray);

        int strIndex = findIndex(stringArray, "Cherry");
        System.out.println("Index of 'Cherry': " + strIndex);

        System.out.println("\n=== Double Array Tests ===");
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.print("Original: ");
        printArray(doubleArray);

        List<Double> doubleList = arrayToList(doubleArray);
        System.out.println("Converted to List: " + doubleList);
    }



}
