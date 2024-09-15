package ua.trraxxe.algoritms.sorting;

import org.openjdk.jmh.annotations.*;


@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@Warmup(iterations = 2)
@Measurement(iterations = 4)
@Fork(value = 1, warmups = 0)
public class SorterBenchmark {

    private static final int ARRAY_SIZE = 100_000;

    private static final Sorter BUBBLE_SORTER = new BubbleSorter();
    private static final Sorter SELECTION_SORTER = new SelectionSorter();
    private static final Sorter INSERTION_SORTER = new InsertionSorter();

    private int[] bestCase;
    private int[] averageCase;
    private int[] worstCase;

    @Setup
    public void setup() {
        bestCase = new int[ARRAY_SIZE];
        averageCase = new int[ARRAY_SIZE];
        worstCase = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            bestCase[i] = i;
            worstCase[i] = ARRAY_SIZE - i - 1;
            if (i < ARRAY_SIZE / 2) {
                averageCase[i] = (ARRAY_SIZE / 2) + i;
            } else {
                averageCase[i] = i;
            }
        }
    }

    @Benchmark
    public int[] bubble_sorter_best_case_benchmark() {
        return BUBBLE_SORTER.sort(bestCase);
    }

    @Benchmark
    public int[] bubble_sorter_average_case_benchmark() {
        return BUBBLE_SORTER.sort(averageCase);
    }

    @Benchmark
    public int[] bubble_sorter_worst_case_benchmark() {
        return BUBBLE_SORTER.sort(worstCase);
    }

    @Benchmark
    public int[] selection_sorter_best_case_benchmark() {
        return SELECTION_SORTER.sort(bestCase);
    }

    @Benchmark
    public int[] selection_sorter_average_case_benchmark() {
        return SELECTION_SORTER.sort(averageCase);
    }

    @Benchmark
    public int[] selection_sorter_worst_case_benchmark() {
        return SELECTION_SORTER.sort(worstCase);
    }

    @Benchmark
    public int[] insertion_sorter_best_case_benchmark() {
        return INSERTION_SORTER.sort(bestCase);
    }

    @Benchmark
    public int[] insertion_sorter_average_case_benchmark() {
        return INSERTION_SORTER.sort(averageCase);
    }

    @Benchmark
    public int[] insertion_sorter_worst_case_benchmark() {
        return INSERTION_SORTER.sort(worstCase);
    }
}
