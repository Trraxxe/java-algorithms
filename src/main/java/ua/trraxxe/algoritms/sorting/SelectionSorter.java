package ua.trraxxe.algoritms.sorting;

import java.util.Arrays;

public class SelectionSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < result.length - 1; i++) {
            int indexOfSmallest = i;
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }
            if (indexOfSmallest != i) {
                int buffer = result[indexOfSmallest];
                result[indexOfSmallest] = result[i];
                result[i] = buffer;
            }
        }

        return result;
    }
}
