package ua.trraxxe.algoritms.sorting;

import java.util.Arrays;

/**
 * The {@code InsertionSorter} class provides an implementation of the insertion sort algorithm
 * for sorting an array of integers in non-decreasing order.
 * <p>
 * The insertion sort algorithm builds the sorted array one element at a time.
 * It works by iterating over the array, and for each element, shifting larger elements
 * of the sorted portion to the right to make space for the new element to be inserted.
 * <p>
 * Insertion sort is efficient for small data sets and is often used as a building block
 * in more advanced sorting algorithms. It is also adaptive, meaning that it performs better
 * when the array is partially sorted.
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
 *   <li>In-place algorithm as it does not require additional memory for sorting beyond the input array (other than the result array).</li>
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
public class InsertionSorter implements Sorter {

    /**
     * Sorts an array of integers using the insertion sort algorithm.
     *
     * @param array the input array to be sorted; it is not modified.
     * @return a new array containing the sorted elements from the input array.
     * @throws NullPointerException if the input array is {@code null}.
     */
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        // Outer loop: iterate over each element starting from the second element.
        for (int i = 1; i < result.length; i++) {
            int buffer = result[i];
            int replacementIndex = i;

            // Inner loop: shift elements to the right to make room for the current element.
            for (int j = i - 1; j >= 0; j--) {
                if (buffer < result[j]) {
                    result[j + 1] = result[j];
                    replacementIndex = j;
                } else {
                    break;
                }
            }

            // Insert the element at the correct position.
            if (replacementIndex != i) {
                result[replacementIndex] = buffer;
            }
        }

        return result;
    }
}

