package com.mycompany.tsstackds;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * test class for the thread safe stack, uses a built in stack class
 *
 * @author nicka
 */
public class TSStackTest<T> {

    private Stack<T> s = new Stack<>();

    public synchronized void push(T addMe) {
        s.push(addMe);
    }

    public synchronized T pop() {
        if(s.isEmpty()){
            return (T) "NO";
        }
        return s.pop();
    }

    public synchronized T peek() {
        return s.peek();
    }

    public synchronized int size() {
        return s.size();
    }

    public synchronized boolean isEmpty() {
        return s.isEmpty();
    }

}
