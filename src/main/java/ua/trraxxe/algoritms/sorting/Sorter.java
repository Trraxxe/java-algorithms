package ua.trraxxe.algoritms.sorting;

/**
 * The {@code Sorter} interface provides a contract for implementing
 * sorting algorithms. Classes implementing this interface should
 * provide a specific sorting strategy to order an array of integers
 * in ascending order.
 */
public interface Sorter {

    /**
     * Sorts the given array of integers in ascending order.
     *
     * <p>This method returns a new array with the elements of the provided
     * array sorted in ascending order. The original array is not modified.
     *
     * @param array the array of integers to be sorted
     * @return a new array containing the elements sorted in ascending order
     */
    int[] sort(final int[] array);
}