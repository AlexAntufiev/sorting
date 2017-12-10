package ru.mail.polis.structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleInteger implements Numerical<SimpleInteger> {

    private static final int DIGIT_COUNT = 10;

    private final byte[] data;
    private final int length;

    public SimpleInteger(Integer data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
        byte[] temp = new byte[DIGIT_COUNT];
        int length = 0;
        for (int i = 0; i < DIGIT_COUNT; i++) {
            if (data == 0)
                break;
            temp[i] = (byte) (data % DIGIT_COUNT);
            data /= DIGIT_COUNT;
            length++;
        }
        this.length = length;
        this.data = temp;
    }

    @Override
    public int getDigit(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index " + index);
        } else if (index < getDigitCount()) {
            return 0;
        } else {
            return data[index];
        }
    }

    @Override
    public int getDigitMaxValue() {
        return DIGIT_COUNT;
    }

    @Override
    public int getDigitCount() {
        return length;
    }

    @Override
    public int compareTo(SimpleInteger anotherSimpleInteger) {
        if (data[9] > anotherSimpleInteger.data[9]) {
            return -1;
        }
        if (data[9] < anotherSimpleInteger.data[9]) {
            return 1;
        }

        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] < anotherSimpleInteger.data[i])
                return -1;
            if (data[i] > anotherSimpleInteger.data[i])
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        new SimpleInteger(Integer.MAX_VALUE);
    }
}