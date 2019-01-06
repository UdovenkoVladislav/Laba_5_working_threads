//Получение состояния потока исполнения (стр 313)
class ThreadState implements Runnable {
    String name; // имя потока исполнения
    Thread t;

    ThreadState(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t + " Состояние: " + t.getState());
        t.start(); // запустить поток исполнения
    }

    //Точка входа в поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i + " Состояние: " + t.getState());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван. Состояние: " + t.getState());
        }

        System.out.println(name + " завершен. Состояние: " + t.getState());
    }
}

class DemoJoinThreadState {
    public static void main(String args[]) {
        ThreadState ob1 = new ThreadState("Один");
        ThreadState ob2 = new ThreadState("Двa");
        ThreadState ob3 = new ThreadState("Tpи");

        System.out.println("Поток Один запущен: " + ob1.t.isAlive() + " Состояние: " + ob1.t.getState());

        System.out.println("Поток Два запущен: " + ob2.t.isAlive() + " Состояние: " + ob2.t.getState());

        System.out.println("Поток Три запущен: " + ob3.t.isAlive() + " Состояние: " + ob3.t.getState());

        // ожидать завершения потоков исполнения
        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            System.out.println("Состояние Один: " + ob1.t.getState());
            ob2.t.join();
            System.out.println("Состояние Два: " + ob2.t.getState());
            ob3.t.join();
            System.out.println("Состояние Три: " + ob1.t.getState());
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        System.out.println("Поток Один запущен: " + ob1.t.isAlive() + " Состояние: " + ob1.t.getState());

        System.out.println("Поток Два запущен: " + ob2.t.isAlive() + " Состояние: " + ob2.t.getState());

        System.out.println("Поток Три запущен: " + ob3.t.isAlive() + " Состояние: " + ob3.t.getState());

        System.out.println("Главный поток завершен.");
    }
}