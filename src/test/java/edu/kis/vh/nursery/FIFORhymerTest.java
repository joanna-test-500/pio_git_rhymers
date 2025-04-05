package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class FIFORhymerTest {

    @Test
    public void testCountIn() {
        FIFORhymer rhymer = new FIFORhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        FIFORhymer rhymer = new FIFORhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        FIFORhymer rhymer = new FIFORhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        FIFORhymer rhymer = new FIFORhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOutFIFO() {
        FIFORhymer rhymer = new FIFORhymer();
        final int EMPTY_STACK_VALUE = -1;

        // Test empty rhymer
        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        // Test FIFO behavior
        int firstValue = 1;
        int secondValue = 2;
        int thirdValue = 3;

        rhymer.countIn(firstValue);
        rhymer.countIn(secondValue);
        rhymer.countIn(thirdValue);

        // Should return values in FIFO order
        result = rhymer.countOut();
        Assert.assertEquals(firstValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(secondValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(thirdValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    @Test
    public void testMultipleOperations() {
        FIFORhymer rhymer = new FIFORhymer();
        
        // Add some values
        rhymer.countIn(1);
        rhymer.countIn(2);
        rhymer.countIn(3);
        
        // Remove one value
        int result = rhymer.countOut();
        Assert.assertEquals(1, result);
        
        // Add more values
        rhymer.countIn(4);
        rhymer.countIn(5);
        
        // Remove remaining values in FIFO order
        result = rhymer.countOut();
        Assert.assertEquals(2, result);
        result = rhymer.countOut();
        Assert.assertEquals(3, result);
        result = rhymer.countOut();
        Assert.assertEquals(4, result);
        result = rhymer.countOut();
        Assert.assertEquals(5, result);
        result = rhymer.countOut();
        Assert.assertEquals(-1, result);
    }
} 