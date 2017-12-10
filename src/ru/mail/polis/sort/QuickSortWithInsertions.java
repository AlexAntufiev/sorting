package ru.mail.polis.sort;

import java.util.Comparator;

public class QuickSortWithInsertions<T> extends AbstractSortOnComparisons<T> {

    public QuickSortWithInsertions() {
    }

    public QuickSortWithInsertions(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(T[] a, int left, int right) {
        if (left >= right) return;
        int idx = partition(a, left, right);
        if (right - left < 20) {
            new InsertionSort().sort(a, left, idx);
            new InsertionSort().sort(a, idx + 1, right);
        } else {
            sort(a, left, idx);
            sort(a, idx + 1, right);
        }
    }

    private int partition(T[] a, int left, int right) {
        T p = a[(int) ((Math.random() * (right - left) + 1) + left)];
        int i = left, j = right;
        while (i <= j) {
            while (lesser(a[i], p)) {
                i++;
            }
            while (greater(a[j], p)) {
                j--;
            }
            if (i <= j) {
                swap(a, i++, j--);
            }
        }
        return j;
    }
}
