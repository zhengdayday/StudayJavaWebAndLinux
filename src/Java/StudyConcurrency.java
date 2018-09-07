package Java;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyRunnable implements Runnable {
    @Override
    public void run() {

    }
}



class MyThread  extends Thread {
    public void run() {
       System.out.println("xxx");
    }
}
public class StudyConcurrency {

    public static void lazySingel() {

    }
    public static void main(String[] args) {
        // 实现Runnable接口
        Thread thread = new Thread(() -> System.out.println("启动线程") );
        thread.start();
        // 实现Callable接口 Callable可以有返回值，通过FutureTase封装
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 123);
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 继承Thread类 实现run()方法
        MyThread myThread = new MyThread();
        // 当调用start()方法启动一个线程时，虚拟机会将该线程放入就绪队列中等待被调度，当一个线程被调度时，会执行该线程的run()方法
        myThread.start();

        // 实现接口比继承Thread更优
        // Java不支持多重继承
        // 类可能只要求可执行就行，继承整个Thread类开销过大
    }
}
