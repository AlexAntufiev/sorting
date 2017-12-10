package ru.mail.polis.sort;

import ru.mail.polis.structures.ArrayPriorityQueue;

import java.util.Comparator;

public class HeapSort<T extends Comparable> extends AbstractSortOnComparisons<T> {

    public HeapSort() {
    }

    public HeapSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array) {
        ArrayPriorityQueue<T> queue = new ArrayPriorityQueue<>();
        queue.addAll(array);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - 1 - i);
            queue.setSize(queue.size() - 1);
            queue.siftDown(0);
        }
    }
}