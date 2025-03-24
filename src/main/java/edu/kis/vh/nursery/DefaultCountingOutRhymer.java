package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int NUMBERS_COUNT = 12;
    private static final int EMPTY_INDEX = -1;

    private int[] numbers = new int[NUMBERS_COUNT];

    public int total = EMPTY_INDEX;

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
            return EMPTY_INDEX;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY_INDEX;
        return numbers[total--];
    }

}
