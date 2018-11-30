package com.company;
class Thread_1 extends Thread{
    public void run(){
        try {
            while(true){
                if (!isInterrupted()) {
                    Log.to_console("Поток 1");
                } else {
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Поток 1 прерван");
        }
    }
}