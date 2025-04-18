package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    //TODO: Te stałe powinny być publiczne, żeby klienci wiedzieli jaki jest romiar stosu.
    private static final int NUMBERS_COUNT = 12;
    private static final int EMPTY_INDEX = -1;
    private static final int EMPTY_RHYMER_VALUE = -1;

    private final int[] numbers = new int[NUMBERS_COUNT];

    private int total = EMPTY_INDEX;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY_INDEX;
    }

    public boolean isFull() {
        return total == NUMBERS_COUNT - 1;
    }

    protected int peekaboo() {
        if (callCheck())
            return EMPTY_RHYMER_VALUE;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY_RHYMER_VALUE;
        return numbers[total--];
    }

    public int getTotal() {
        return total;
    }

}
