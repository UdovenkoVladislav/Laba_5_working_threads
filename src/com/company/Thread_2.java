package com.company;
class Thread_2 extends Thread{
    public void run(){
        try {
            while(true){
                if (!isInterrupted()) {
                    Log.to_console("Поток 2");
                } else {
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Поток 2 прерван");
        }
    }
}
