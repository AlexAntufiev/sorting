package ru.mail.polis.sort;

import ru.mail.polis.structures.IntKeyObject;
import ru.mail.polis.structures.IntKeyStringValueObject;
import ru.mail.polis.structures.SimpleInteger;
import ru.mail.polis.structures.SimpleString;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class SortUtils {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static <T> void swap(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static int[] generateIntegerArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static Integer[] generateUniqueIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static IntKeyObject[] generateUniqueIntKeyStringValueArray(int n) {
        IntKeyObject[] a = new IntKeyObject[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new IntKeyStringValueObject(i + 1, i + 1 + "");
        }
        for (int i = a.length - 1; i >= 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static SimpleString[] generateUniqueSimpleStringArray(int n) {
        SimpleString[] list = new SimpleString[n];
        int length = 1 + (int) (Math.random() * n);
        for (int i = 0; i < n; i++) {
            String tempStr = "";
            for (int j = 1; j <= length; j++) {
                int chr = 'a' + (int) (Math.random() * ('z' - 'a'));
                tempStr = tempStr.concat("" + (char) chr);
            }
            list[i] = new SimpleString(tempStr);
        }
        return list;
    }

    public static SimpleInteger[] generateUniqueSimpleIntegerArray(int n) {
        SimpleInteger[] a = new SimpleInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = new SimpleInteger(i + 1);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static Integer[] generateRandomIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(n + 1);
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static IntKeyObject[] generateRandomIntKeyStringValueArray(int n) {
        IntKeyObject[] a = new IntKeyObject[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new IntKeyStringValueObject(r.nextInt(i + 1), i + 1 + "");
        }
        for (int i = a.length - 1; i >= 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static SimpleInteger[] generateRandomSimpleIntegerArray(int n) {
        SimpleInteger[] a = new SimpleInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = new SimpleInteger(r.nextInt(i + 1));
        }
        for (int i = a.length - 1; i >= 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static SimpleString[] generateRandomSimpleStringArray(int n) {
        SimpleString[] list = new SimpleString[n];
        int length = 1 + (int) (Math.random() * n);
        for (int i = 0; i < n; i++) {
            String tempStr = "";
            for (int j = 1; j <= length; j++) {
                int chr = 'a' + (int) (Math.random() * ('z' - 'a'));
                tempStr = tempStr.concat("" + (char) chr);
            }
            list[i] = new SimpleString(tempStr);
        }
        return list;
    }

    public static Integer[] generateLowRangeIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(11);
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static IntKeyObject[] generateLowRangeIntKeyStringValueArray(int n) {
        IntKeyObject[] list = new IntKeyObject[n];
        for (int i = 0; i < list.length; i++) {
            int key = r.nextInt(11);
            list[i] = new IntKeyStringValueObject(key, key + "");
        }
        for (int i = list.length - 1; i >= 0; i--) {
            int j = r.nextInt(i + 1);
            swap(list, i, j);
        }
        return list;
    }

    public static SimpleInteger[] generateLowRangeSimpleIntegerArray(int n) {
        SimpleInteger[] a = new SimpleInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = new SimpleInteger(r.nextInt(11));
        }
        for (int i = a.length - 1; i >= 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    public static SimpleString[] generateLowRangeSimpleStringArray(int n) {
        SimpleString[] list = new SimpleString[n];
        int length = 1 + (int) (Math.random() * 10);
        for (int i = 0; i < n; i++) {
            String tempStr = "";
            for (int j = 1; j <= length; j++) {
                int chr = 'a' + (int) (Math.random() * ('z' - 'a'));
                tempStr = tempStr.concat("" + (char) chr);
            }
            list[i] = new SimpleString(tempStr);
        }
        return list;
    }

    public static Integer[] generateAscIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        return a;
    }

    public static IntKeyObject[] generateAscIntKeyStringValueArray(int n) {
        IntKeyObject[] list = new IntKeyObject[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new IntKeyStringValueObject(i + 1, i + 1 + "");
        }
        return list;
    }

    public static SimpleInteger[] generateAscSimpleIntegerArray(int n) {
        SimpleInteger[] a = new SimpleInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = new SimpleInteger(i + 1);
        }
        return a;
    }

    public static SimpleString[] generateAscSimpleStringArray(int n) {
        SimpleString[] list = new SimpleString[n];
        for (int i = 0; i < n; i++) {
            String tempStr = "";
            for (int j = 1; j <= i + 1; j++) {
                int chr = 'a' + (int) (Math.random() * ('z' - 'a'));
                tempStr = tempStr.concat("" + (char) chr);
            }
            list[i] = new SimpleString(tempStr);
        }
        return list;
    }

    public static Integer[] generateDescIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i;
        }
        return a;
    }

    public static IntKeyObject[] generateDescIntKeyStringValueArray(int n) {
        IntKeyObject[] a = new IntKeyObject[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new IntKeyStringValueObject(a.length - i, a.length - i + "");
        }
        return a;
    }

    public static SimpleInteger[] generateDescSimpleIntegerArray(int n) {
        SimpleInteger[] a = new SimpleInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = new SimpleInteger(a.length - i);
        }
        return a;
    }

    public static SimpleString[] generateDescSimpleStringArray(int n) {
        SimpleString[] a = new SimpleString[n];
        for (int i = 0; i < n; i++) {
            String tempStr = "";
            for (int j = 1; j <= a.length - i; j++) {
                int chr = 'a' + (int) (Math.random() * ('z' - 'a'));
                tempStr = tempStr.concat("" + (char) chr);
            }
            a[i] = new SimpleString(tempStr);
        }
        return a;
    }

    public static boolean isArraySorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    public static <T extends Comparable<? super T>> boolean isArraySorted(T[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; i++) {
            isSorted = array[i].compareTo(array[i + 1]) <= 0;
        }
        return isSorted;
    }

    public static <T> boolean isArraySorted(T[] array, Comparator<T> comparator) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; i++) {
            isSorted = comparator.compare(array[i], array[i + 1]) <= 0;
        }
        return isSorted;
    }
}
