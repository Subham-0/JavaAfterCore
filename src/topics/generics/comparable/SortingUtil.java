package topics.generics.comparable;

import java.util.List;

public class SortingUtil{
    //Generic method to find maximum using Comparable
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // Generic method to find minimum using Comparable
    public static <T extends Comparable<T>> T findMin(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        T min = list.get(0);
        for (T item : list) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    // Generic bubble sort
    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    // swap
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Generic method to check if list is sorted
    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
