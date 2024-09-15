package ua.trraxxe.algoritms.sorting;

import java.util.Arrays;

/**
 * The {@code BubbleSorter} class provides an implementation of the bubble sort algorithm
 * for sorting an array of integers in non-decreasing order.
 * <p>
 * The bubble sort algorithm works by repeatedly stepping through the array,
 * comparing adjacent elements and swapping them if they are in the wrong order.
 * This process is repeated until the array is fully sorted.
 * <p>
 * The optimization used in this implementation involves stopping the algorithm early
 * if the array becomes sorted before all iterations are complete.
 *
 * <p>Time Complexity:</p>
 * <ul>
 *   <li>Best-case: O(n) - when the input array is already sorted.</li>
 *   <li>Worst-case: O(n²) - when the array is sorted in reverse order.</li>
 *   <li>Average-case: O(n²) - when the elements are randomly distributed.</li>
 * </ul>
 *
 * <p>Space Complexity:</p>
 * <ul>
 *   <li>O(n) - due to the copy of the input array created during the sorting process.</li>
 * </ul>
 *
 * <p>
 * This class implements the {@link Sorter} interface, providing a {@code sort} method
 * that performs the sorting operation.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 */
public class BubbleSorter implements Sorter {

    /**
     * Sorts an array of integers using the bubble sort algorithm.
     *
     * @param array the input array to be sorted; it is not modified.
     * @return a new array containing the sorted elements from the input array.
     * @throws NullPointerException if the input array is {@code null}.
     */
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        boolean isSorted = false;

        // Outer loop: controls the number of passes through the array.
        for (int i = 0; i < result.length && !isSorted; i++) {
            isSorted = true;

            // Inner loop: compares adjacent elements and swaps if needed.
            for (int j = 0; j < result.length - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    // Swap elements if they are in the wrong order.
                    int buffer = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = buffer;

                    // Mark as not sorted to continue the process.
                    isSorted = false;
                }
            }
        }

        return result;
    }
}
