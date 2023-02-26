package com.mycompany.tsstackds;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * @author nicka
 */
public class TSStackDS extends Thread {

    public static void main(String[] args) throws InterruptedException {
        //doing some tests in the main thread

        ThreadSafeStack<String> s = new ThreadSafeStack<>();

        s.push("uhhh");
        s.push("test");
        System.out.println(s.pop());//should return test, and remove it

        System.out.println(s.peek());//should be uhhh

        System.out.println(s.size());//should be 1

        //now ill do some multi threaded tests
        ThreadSafeStack s2 = new ThreadSafeStack();
        
        Random rand = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < 15; i++){
            arr.add(rand.nextInt(2));
        }
        
        TSStackTest<String> test = new TSStackTest<>();
        
       Thread t3 = new Thread(() -> {
           for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == 0){
                test.push("Inserted from thread 1");
            }
            if(arr.get(i) == 1){
                System.out.println("popped from thread 1: " + test.pop());
            }
        } 
       });
       
       Thread t4 = new Thread(() -> {
           for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == 0){
                test.push("Inserted from thread 2");
            }
            if(arr.get(i) == 1){
                System.out.println("popped from thread 2: " + test.pop());
            }
        } 
       });
       
       test.push("TEST");
       test.push("TEST");
       
       t3.start();
       t4.start();
       t3.join();
       t4.join();
       
        System.out.println(test.size());
        
        for(int i = 0; i < test.size(); i++){
            System.out.println(test.pop());
        }
        
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                System.out.println("Currently: " + s2.size());
                int num = arr.get(i);
                if (num == 0) {

                    System.out.println("Inserted from thread 1");
                    s2.push("Inserted from Thread 1!");
                }
                if (num == 1) {
                
                        System.out.println("From Thread 1 popped: " + s2.pop());
                    
                }

            }

        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                System.out.println("Currently: " + s2.size());
                int num = arr.get(i);

                if (num == 0) {
                    System.out.println("Inserted from thread 2");
                    s2.push("Inserted from Thread 2!");
                }
                if (num == 1) {
                   
                        System.out.println("From Thread 2 popped: " + s2.pop());
                   
                }

            }
        });

      

       

    }

}
