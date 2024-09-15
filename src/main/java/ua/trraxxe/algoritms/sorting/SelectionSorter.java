package ua.trraxxe.algoritms.sorting;

import java.util.Arrays;

/**
 * The {@code SelectionSorter} class provides an implementation of the selection sort algorithm
 * for sorting an array of integers in non-decreasing order.
 * <p>
 * The selection sort algorithm works by dividing the input array into two parts:
 * a sorted part and an unsorted part. Initially, the sorted part is empty, and
 * the unsorted part contains the entire array. The algorithm repeatedly selects
 * the smallest (or largest, depending on sorting order) element from the unsorted part,
 * and swaps it with the first unsorted element, moving the boundary between the sorted
 * and unsorted parts.
 * <p>
 * The algorithm runs in O(n²) time complexity, making it inefficient on large arrays.
 * However, it has the advantage of making fewer swaps than bubble sort, and it is
 * simple to implement.
 *
 * <p>Time Complexity:</p>
 * <ul>
 *   <li>Best-case: O(n²) - even if the array is already sorted, the algorithm still performs the same number of comparisons.</li>
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
public class SelectionSorter implements Sorter {

    /**
     * Sorts an array of integers using the selection sort algorithm.
     *
     * @param array the input array to be sorted; it is not modified.
     * @return a new array containing the sorted elements from the input array.
     * @throws NullPointerException if the input array is {@code null}.
     */
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        // Outer loop: iterate over each element, treating it as a potential minimum.
        for (int i = 0; i < result.length - 1; i++) {
            int indexOfSmallest = i;

            // Inner loop: find the smallest element in the unsorted portion.
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }

            // Swap the smallest element found with the current element.
            if (indexOfSmallest != i) {
                int buffer = result[indexOfSmallest];
                result[indexOfSmallest] = result[i];
                result[i] = buffer;
            }
        }

        return result;
    }
}

