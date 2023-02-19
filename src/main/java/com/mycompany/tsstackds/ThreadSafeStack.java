package com.mycompany.tsstackds;

/**
 * This class will contain a thread safe stack implementation
 *
 * @author nicka
 * @param <T>
 */
public class ThreadSafeStack<T extends Comparable<T>> {

    public ThreadSafeStack() {

    }

    /**
     * Peek operation will look but not remove the top element in the stack
     * synchronized is used for thread safety
     *
     * @return
     */
    public synchronized T peek() {
        return null;
    }

    /**
     * pop operation will look at the top element and remove it from the stack
     * synchronized is used for thread safety
     *
     * @return
     */
    public synchronized T pop() {
        return null;
    }

    /**
     * push operation, will add addMe to the stack in a LIFO manner, synchronized
     * is used for thread safety
     *
     * @param addMe
     */
    public synchronized void push(T addMe) {

    }

    /**
     * isEmpty will return true if the stack is empty, synchronized is used for
     * thread safety
     *
     * @return
     */
    public synchronized boolean isEmpty() {
        return false;
    }

    /**
     * size will return the size of the stack, synchronized is used for thread
     * safety
     *
     * @return
     */
    public synchronized int size() {
        return -1;
    }

}
