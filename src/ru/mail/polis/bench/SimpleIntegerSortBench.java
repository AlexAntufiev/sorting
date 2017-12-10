package ru.mail.polis.bench;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.*;
import ru.mail.polis.structures.SimpleInteger;

/**
 * Created by Nechaev Mikhail
 * Since 20/11/16.
 */

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
public class SimpleIntegerSortBench {

    private LSDSort<SimpleInteger> lsdSort = new LSDSort<>();

    private SimpleInteger[][] data;
    private SimpleInteger[] curr;
    private int index;
    private final static int ARRAY_LENGTH = 100;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new SimpleInteger[10][ARRAY_LENGTH];
        for (int i = 0; i < 10; i++) {
            //define arrays here
//            data[i] = SortUtils.generateSimpleIntegerArray(ARRAY_LENGTH);
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
                .include(SimpleIntegerSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}

