package com.mycompany.tsstackds;

/**
 *
 * @author nicka
 */
public class TSStackDS extends Thread {

    public static int amount = 0;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        TSStackDS thread = new TSStackDS();
        thread.start();
        System.out.println(amount);
        amount++;
        System.out.println(amount);
      

    }

    @Override
    public void run() {
      amount++;
    }
}
