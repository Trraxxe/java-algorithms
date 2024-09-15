package ua.trraxxe.algoritms.sorting;

import java.util.Arrays;

public class BubbleSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        boolean isSorted = false;

        for (int i = 0; i < result.length && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < result.length - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int buffer = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = buffer;
                    isSorted = false;
                }
            }
        }

        return result;
    }
}
