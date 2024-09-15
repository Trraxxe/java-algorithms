package ua.trraxxe.algoritms.sorting;

import java.util.Arrays;

public class InsertionSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 1; i < result.length; i++) {
            int buffer = result[i];
            int replacementIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (buffer < result[j]) {
                    result[j + 1] = result[j];
                    replacementIndex = j;
                } else {
                    break;
                }
            }
            if (replacementIndex != i) {
                result[replacementIndex] = buffer;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InsertionSorter insertionSorter = new InsertionSorter();
        int[] ints = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(insertionSorter.sort(ints)));
    }
}
