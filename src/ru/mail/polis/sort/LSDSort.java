package ru.mail.polis.sort;

import ru.mail.polis.structures.Numerical;

import java.util.Comparator;

public class LSDSort<T extends Object & Numerical<T>> extends AbstractSortOnComparisons<T> {

    public LSDSort() {
    }

    public LSDSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array) {
        int r = findMaxDigitValue(array), d = findMaxDigitsAmount(array);
        for (int k = d; k >= 1; k--) {
            int[] count = new int[r + 1];
            for (T object : array) count[getDigit(object, k)]++;
            for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
            T[] res = (T[]) new Object[array.length];
            for (int i = res.length - 1; i >= 0; i--) {
                res[--count[getDigit(array[i], k)]] = array[i];
            }
            System.arraycopy(res, 0, array, 0, array.length);
        }
    }

    private int getDigit(T object, int digit) {
        if (object.getDigitCount() > digit) return object.getDigit(digit - 1);
        return 0;
    }

    private int findMaxDigitsAmount(T[] array) {
        int max = 0;
        for (T x : array) {
            if (x.getDigitCount() > max) max = x.getDigitCount();
        }
        return max;
    }

    private int findMaxDigitValue(T[] array) {
        int max = 0;
        for (T anArray : array)
            if (anArray.getDigitMaxValue() > max)
                max = anArray.getDigitMaxValue();
        return max;
    }

}
