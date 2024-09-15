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
            if (i % 2 == 0) {
                averageCase[i] = i;
            } else {
                averageCase[i] = ARRAY_SIZE - i - 1;
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
}
