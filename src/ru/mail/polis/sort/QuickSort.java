package ru.mail.polis.sort;

import java.util.Comparator;

public class QuickSort<T> extends AbstractSortOnComparisons<T> {

    public QuickSort() {
    }

    public QuickSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(T[] a, int left, int right) {
        if (left >= right) return;
        int lt = left, gt = right;
        T v = a[left];
        int i = left;
        while (i <= gt) {
            if (lesser(a[i], v)) swap(a, lt++, i++);
            else if (greater(a[i], v)) swap(a, i, gt--);
            else i++;
        }
        sort(a, left, lt - 1);
        sort(a, gt + 1, right);
    }
}
