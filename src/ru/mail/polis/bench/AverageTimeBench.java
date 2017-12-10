package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.*;
import ru.mail.polis.structures.IntKeyObject;
import ru.mail.polis.structures.SimpleInteger;
import ru.mail.polis.structures.SimpleString;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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
public class AverageTimeBench {

    private QuickSort<Integer> quickSort = new QuickSort<>();
    private QuickSortWithInsertions<Integer> quickSortWithInsertions = new QuickSortWithInsertions<>();
    private MergeSort<Integer> mergeSort = new MergeSort<>();
    private HeapSort<Integer> heapSort = new HeapSort<>();
    private LSDSort<SimpleString> simpleStringLSDSort = new LSDSort<>();
    private LSDSort<SimpleInteger> simpleIntegerLSDSort = new LSDSort<>();
    private CountingSort<IntKeyObject> countingSort = new CountingSort<>();

    private Integer[][] dataInteger;
    private Integer[] currInteger;
    private int index;

    private SimpleInteger[][] dataSimpleInteger;
    private SimpleInteger[] currSimpleInteger;

    private SimpleString[][] dataSimpleString;
    private SimpleString[] currSimpleString;

    private IntKeyObject[][] dataIntKeyObject;
    private IntKeyObject[] currIntKeyObject;

    private static final int ARRAY_LENGTH = 1000;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        dataInteger = new Integer[10][ARRAY_LENGTH];
        dataSimpleInteger = new SimpleInteger[10][ARRAY_LENGTH];
        dataSimpleString = new SimpleString[10][ARRAY_LENGTH];
        dataIntKeyObject = new IntKeyObject[10][ARRAY_LENGTH];
        for (int i = 0; i < 10; i++) {
            //define arrays here
//            dataInteger[i] = SortUtils.generateUniqueIntegerArray(ARRAY_LENGTH);
//            dataSimpleInteger[i] = SortUtils.generateUniqueSimpleIntegerArray(ARRAY_LENGTH);
//            dataSimpleString[i] = SortUtils.generateUniqueSimpleStringArray(ARRAY_LENGTH);
//            dataIntKeyObject[i] = SortUtils.generateUniqueIntKeyStringValueArray(ARRAY_LENGTH);

//            dataInteger[i] = SortUtils.generateRandomIntegerArray(ARRAY_LENGTH);
//            dataSimpleInteger[i] = SortUtils.generateRandomSimpleIntegerArray(ARRAY_LENGTH);
//            dataSimpleString[i] = SortUtils.generateRandomSimpleStringArray(ARRAY_LENGTH);
//            dataIntKeyObject[i] = SortUtils.generateRandomIntKeyStringValueArray(ARRAY_LENGTH);

//            dataInteger[i] = SortUtils.generateLowRangeIntegerArray(ARRAY_LENGTH);
//            dataSimpleInteger[i] = SortUtils.generateLowRangeSimpleIntegerArray(ARRAY_LENGTH);
//            dataSimpleString[i] = SortUtils.generateLowRangeSimpleStringArray(ARRAY_LENGTH);
//            dataIntKeyObject[i] = SortUtils.generateLowRangeIntKeyStringValueArray(ARRAY_LENGTH);

//            dataInteger[i] = SortUtils.generateAscIntegerArray(ARRAY_LENGTH);
//            dataSimpleInteger[i] = SortUtils.generateAscSimpleIntegerArray(ARRAY_LENGTH);
//            dataSimpleString[i] = SortUtils.generateAscSimpleStringArray(ARRAY_LENGTH);
//            dataIntKeyObject[i] = SortUtils.generateAscIntKeyStringValueArray(ARRAY_LENGTH);

            dataInteger[i] = SortUtils.generateDescIntegerArray(ARRAY_LENGTH);
            dataSimpleInteger[i] = SortUtils.generateDescSimpleIntegerArray(ARRAY_LENGTH);
            dataSimpleString[i] = SortUtils.generateDescSimpleStringArray(ARRAY_LENGTH);
            dataIntKeyObject[i] = SortUtils.generateDescIntKeyStringValueArray(ARRAY_LENGTH);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        currInteger = Arrays.copyOf(dataInteger[index], dataInteger.length);
        currSimpleInteger = Arrays.copyOf(dataSimpleInteger[index], dataSimpleInteger.length);
        currSimpleString = Arrays.copyOf(dataSimpleString[index], dataSimpleString.length);
        currIntKeyObject = Arrays.copyOf(dataIntKeyObject[index], dataIntKeyObject.length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureQuickSort() {
        quickSort.sort(currInteger);
    }

    @Benchmark
    public void measureQuickSortWithInsertions() {
        quickSortWithInsertions.sort(currInteger);
    }

    @Benchmark
    public void measureMergeSort() {
        mergeSort.sort(currInteger);
    }

    @Benchmark
    public void measureHeapSort() {
        heapSort.sort(currInteger);
    }

    @Benchmark
    public void measureLsdSimpleIntegerSort() {
        simpleIntegerLSDSort.sort(currSimpleInteger);
    }

    @Benchmark
    public void measureLsdSimpleStringSort() {
        simpleStringLSDSort.sort(currSimpleString);
    }

    @Benchmark
    public void measureCountingSort() {
        countingSort.sort(currIntKeyObject);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AverageTimeBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
