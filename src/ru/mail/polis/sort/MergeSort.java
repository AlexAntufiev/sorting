package ru.mail.polis.sort;

import java.util.Comparator;

public class MergeSort<T> extends AbstractSortOnComparisons<T> {

    public MergeSort() {
    }

    public MergeSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] a) {
        int n = a.length;
        T[] t = (T[]) new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int left = 0; left < n - len; left += len + len) {
                int mid = left + len - 1;
                int right = Math.min(left + len + len - 1, n - 1);
                merge(a, t, left, mid, right);
            }
        }
    }


    private void merge(T[] a, T[] t, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            t[i] = a[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) a[k] = t[j++];
            else if (j > right) a[k] = t[i++];
            else if (lesser(t[j], t[i])) a[k] = t[j++];
            else a[k] = t[i++];
        }

    }
}
