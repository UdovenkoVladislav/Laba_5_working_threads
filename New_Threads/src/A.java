//Взаимная блокировка (стр 309) (deadlock)
// Пример взаимной блокировки
class А {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " вошел в метод A.foo()");

        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println("Класс А прерван");
        }
        System.out.println(name + " пытается вызвать метод B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("B методе A.last()" );
    }
}

class B {
    synchronized void bar (А a) {
        String name = Thread. currentThread().getName();
        System.out.println(name + " вошел в метод B.bar()");

        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println("Класс В прерван");
        }

        System.out.println(name + " пытается вызвать метод A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("B методе A.last()");
    }
}

class Deadlock implements Runnable {
    А a = new А();
    B b = new B();

    Deadlock() {
        Thread.currentThread().setName ("Главный поток");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();
        a.foo(b); // получить блокировку для объекта а
        // в этом потоке исполнения
        System.out.println( "Назад в главный поток");
    }

    public void run() {
        b.bar(a); // получить блокировку для объекта b
        // в другом потоке исполнения
        System.out.println("Назад в другой поток");
    }

    public static void main(String args[]) {
        new Deadlock();
    }
}
