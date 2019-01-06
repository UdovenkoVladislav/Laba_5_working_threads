//Метод isAlive и join (стр 297)
//Применить метод join(), чтобы ожидать завершения потоков исполнения
class NewThread_join implements Runnable {
    String name; // имя потока исполнения
    Thread t;

    NewThread_join(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start(); // запустить поток исполнения
    }

//Точка входа в поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван.");
        }

        System.out.println(name + " завершен.");
    }
}

class DemoJoin {
    public static void main(String args[]) {
        NewThread_join ob1 = new NewThread_join("Один");
        NewThread_join ob2 = new NewThread_join("Двa");
        NewThread_join ob3 = new NewThread_join("Tpи" );

        System.out.println("Поток Один запущен: " + ob1.t.isAlive());

        System.out.println("Поток Два запущен: " + ob2.t.isAlive());

        System.out.println("Поток Три запущен: " + ob3.t.isAlive());

        // ожидать завершения потоков исполнения
        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        System.out.println("Поток Один запущен: " + ob1.t.isAlive());

        System.out.println("Поток Два запущен: " + ob2.t.isAlive());

        System.out.println("Поток Три запущен: " + ob3.t.isAlive());

        System.out.println("Главный поток завершен.");
    }
}

