package ru.mail.polis.sort;

import ru.mail.polis.structures.IntKeyObject;

import java.util.Comparator;

public class CountingSort<T extends IntKeyObject> extends AbstractSortOnComparisons<T> {

    public CountingSort() {
    }

    public CountingSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] a) {
        int max = findMax(a);
        int[] count = new int[max + 1];
        for (T x : a) count[x.getKey()]++;

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        T[] res = (T[]) new IntKeyObject[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            res[--count[a[i].getKey()]] = a[i];
        }
        System.arraycopy(res, 0, a, 0, a.length);
    }

    private int findMax(T[] a) {
        int max = 0;
        for (T x : a) {
            max = Math.max(max, x.getKey());
        }
        return max;
    }


}
