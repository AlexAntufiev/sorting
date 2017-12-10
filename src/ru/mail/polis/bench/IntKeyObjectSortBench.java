package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.CountingSort;
import ru.mail.polis.sort.SortUtils;
import ru.mail.polis.structures.IntKeyObject;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nechaev Mikhail
 * Since 27/11/2017.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
public class IntKeyObjectSortBench {

    private CountingSort<IntKeyObject> countingSort = new CountingSort<>();

    private IntKeyObject[][] data;
    private IntKeyObject[] curr;
    private int index;
    private final static int ARRAY_LENGTH = 100;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new IntKeyObject[10][ARRAY_LENGTH];
        for (int i = 0; i < 10; i++) {
            //define arrays here
//            data[i] = SortUtils.generateIntKeyStringValueArray(ARRAY_LENGTH);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data.length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureCountingSort() {
        countingSort.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IntKeyObjectSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
