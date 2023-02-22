package com.mycompany.tsstackds;

/**
 *
 * @author nicka
 */
public class TSStackDS extends Thread {

    public static int amount = 0;
    public static void main(String[] args) {
        //doing some tests in the main thread
        
        ThreadSafeStack s = new ThreadSafeStack();
        s.push("uhhh");
        s.push("test");
        System.out.println(s.pop());//should return test, and remove it
       
        System.out.println(s.peek());//should be uhhh
      
        System.out.println(s.size());//should be 1

    }

    @Override
    public void run() {
      amount++;
    }
}
