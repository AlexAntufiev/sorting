package ru.mail.polis.sort;

import java.util.Comparator;

public class InsertionSort<T> extends AbstractSortOnComparisons<T> {

    public InsertionSort() {
    }

    public InsertionSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(T[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = a[i];
            int j;
            for (j = i - 1; (j >= 0) && (lesser(temp, a[j])); j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }
}
