package com.mycompany.tsstackds;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class will contain a thread safe stack implementation
 *
 * @author nicka
 * @param <T>
 */
public class ThreadSafeStack<T extends Comparable<T>> {

    /**
     * node class, will hold nodes pushed into the stack
     *
     * @param <T>
     */
    private static class Node<T> {

        T data;
        Node<T> next;

        public Node() {
            this.data = null;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;

    public ThreadSafeStack() {
        size = 0;
        head = null;
    }

    /**
     * Peek operation will look but not remove the top element in the stack
     * synchronized is used for thread safety
     *
     * @return
     */
    public synchronized T peek() {

        if (size == 0) {
            return (T) new NoSuchElementException();
        } else {
            return head.data;
        }
    }

    /**
     * pop operation will look at the top element and remove it from the stack
     * synchronized is used for thread safety
     *
     * @return
     */
    public synchronized T pop() {

        T returnMe;

        if (size == 0) {//if the size is 0, theres nothing to pop so throw an exception
            return (T) new NoSuchElementException();
        } else {
            returnMe = head.data;//otherwise set the data to be returned

            if (head.next == null) {//meaning if the head is the last element in the stack
                head = null;//set the head to null
            } else {
                head = head.next;//otherwise advance the head to the next element in the stack
            }
        }
        size--;//decrement the size of the stack
        return returnMe;//return the data 
    }

    /**
     * push method will add an element to the stack, in a LIFO manner, synchronized is used for thread safety
     * @param addMe 
     */
    public synchronized void push(T addMe) {

        if (size == 0) {//if the stack is empty, then head needs to be set
            Node<T> newNode = new Node<T>();//make a new node
            newNode.data = addMe;//set the data

            size++;//increment the size of the stack

            head = newNode;//set the head to the newNode
        } else {//if the stack is not full, then just make a new node and add it

            Node<T> newNode = new Node<T>();//create a new node
            newNode.data = addMe;//set the data

            size++;//increment the size of the stack

            newNode.next = head;//set the next pointer to whats currently at the head
            head = newNode;//then set the head to the newly added node, pushing the old head down

        }

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
        return size;
    }

}
