package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.LSDSort;
import ru.mail.polis.sort.SortUtils;
import ru.mail.polis.structures.SimpleString;

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
public class SimpleStringSortBench {

    private LSDSort<SimpleString> lsdSort = new LSDSort<>();

    private SimpleString[][] data;
    private SimpleString[] curr;
    private int index;
    private final static int ARRAY_LENGTH = 100;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new SimpleString[10][ARRAY_LENGTH];
        for (int i = 0; i < 10; i++) {
            //define arrays here
//            data[i] = SortUtils.generateSimpleStringArray(ARRAY_LENGTH);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data.length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureLSDSort() {
        lsdSort.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SimpleStringSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}