package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {

    public static void main(String[] args) {
        final Thread_1 thread1 = new Thread_1();
        final Thread_2 thread2 = new Thread_2();
        thread1.start();
        thread2.start();
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Прерывание потоков...");
                thread1.interrupt();
                thread2.interrupt();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
