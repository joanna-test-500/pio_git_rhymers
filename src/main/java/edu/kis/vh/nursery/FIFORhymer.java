package edu.kis.vh.nursery;

/**
 * FIFORhymer implements a First-In-First-Out (FIFO) counting out rhymer.
 * This class extends DefaultCountingOutRhymer and provides FIFO behavior
 * by using a temporary storage to maintain the order of elements.
 */
public class FIFORhymer extends DefaultCountingOutRhymer {

    /**
     * Temporary storage used to maintain FIFO order during countOut operation.
     */
    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Counts out elements in FIFO order (First-In-First-Out).
     * This method overrides the default counting out behavior to ensure
     * elements are removed in the same order they were added.
     *
     * @return The first element that was added to the rhymer
     */
    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
