package Java;


import java.util.Locale;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    public static void main(String[] args) throws InterruptedException {
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

        // Exector 管理多个异步任务的执行，而无需程序员显试的管理线程的生命周期，这里的异步指的是多个任务的执行互不干扰
        // 主要有三种Executor:
        // CachedThreadPool: 一个任务创建一个线程
        // FixedThreadPool: 所有任务只能使用固定大小的线程
        // SingleThreadExecutor: 相当于大小为1的FixedThreadPool

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Thread((() -> System.out.println("dayday"))));
        }
        executorService.shutdown();

        // 守护线程是程序运行时在后台提供服务的线程，非守护线程结束时，程序也就终止，同时会杀死所有守护线程
        // main属于非守护线程
        // 使用setDaemon()方法将一个线程设置守护线程。
        Thread thread2 = new Thread(() -> System.out.println("守护线程"));
        thread.setDaemon(true);

        // Thread.sleep(millisec)方法会休眠当前正在执行的线程，millisec单位为毫秒
        // sleep()可能会抛出InterruptedException。因为异常不能跨线程传播回main()中，它异常也同样需要在本地处理

        Thread thread3 = new Thread(() -> {
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });

        // yield(） 对静态方法Thread.yield()的调用声明了当前线程已经完成了生命周期中最重要的部分，可以切换给其他线程来执行
        Thread thread4 = new Thread(() -> {
          Thread.yield();
        });

        // 中断
        // 一个线程执行完毕之后会自动结束，如果在运行过程中发生异常也会提前结束
        // InterruptedException
        // 通过调用一个线程interrupt()来中断该线程，如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出InterruptedException, 从而提前结束该线程。但是不能终端I/O阻塞和synchronized阻塞
        Thread thread5 = new Thread(() -> {
                while (!Thread.interrupted()) {

                }
                System.out.println("Thread end");
        });
        thread5.start();
        thread5.interrupt();
        System.out.println("Main run");

        // Ex
        // 中断操作 调用Excutor的shtdown()方法会等待线程都执行完毕之后再关闭，但是如果调用的是shutdownNow()方法，则相当每个线程的interrupt()方法
        // 以下使用Lambda创建线程，相当于创建了一个匿名内部线程。
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService1.shutdown();
        System.out.println("Main run 111");
/*

        Future<?> future = executorService1.submit(() ->{
           System.out.println("submit");
        });
        future.cancel(true);
*/

        // 互斥同步
        SynchroizedExample synchroizedExample = new SynchroizedExample();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(() -> synchroizedExample.func1());
        executorService2.execute(() -> synchroizedExample.func1());

        // ReentrantLock是java.util.concurrent包中的锁

        LockExample lockExample = new LockExample();
        ExecutorService executorService3 = Executors.newCachedThreadPool();
        executorService3.execute(() -> lockExample.func());
        executorService3.execute(() -> lockExample.func());

        // synchronized是JVM实现的，而ReentrantLock是JDK实现的
        // 性能synchronized进行了很多优化，列入自旋锁，synchronized与ReentrantLock大致相同
        // 等待可能中断，当持有锁的线程长期不释放锁的时候，正在等待的线程可以选择放弃等待，改为处理其他事情
        // ReentrantLock可中断，而synchronized不行
        // 公平锁是指多个线程再等待同一个锁时，必须按照申请锁的时间顺序来依次获得锁
        // synchronized中的锁是非公平的，ReentrantLock默认情况下也是非公平的，但是也可以是公平的。 // 绑定多个条件 // 一个ReentrantLock可以同时绑定多个Condition对象 // 线程之间的协作
        // 当多个线程可以一起工作去解决某个问题时，如果某些部分必须再其它部分之前完成，那么就需要对线程进行协调。
        // join() 在线程中调用一饿线程join()方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
        JoinExample joinExample = new JoinExample();
        joinExample.test();
        //wait() notify() notifyAll()
        //调用wait() 使得线程等待某个条件满足，线程在等待时会被挂起，当其他线程的运行使得这个条件满足时，其他线程会调用nofiy()或者notifyAll来唤醒挂起的线程。
        //他们属于object的一部分，而不是属于Thread
        //只能用在同步方法或者同步控制块中，否则会运行时抛出IllegalMonitorStateExeception
        //wait挂起期间，线程会释放锁，这是因为，如果没有释放锁，那么其他线程就无法进入对象的同步方法或者同步控制块中，那么久无法执行notify()或者nofityAll()来唤醒线程，造成死锁
         WaitNofiyExample waitNofiyExample = new WaitNofiyExample();
         ExecutorService executorService4 = Executors.newCachedThreadPool();
         executorService4.execute(() -> waitNofiyExample.after());
         executorService4.execute(() -> waitNofiyExample.before());
         // wait()是Object的方法，而sleep是静态方法
         // wait()会释放锁，而 sleep()不会释放锁
         // await()signal() signalAll()
        //  java.util.concurrent类库提供了Condition类来实现线程之间的协调，可以在Condition调用await()方法使得线程等待，其他线程调用signal或signalAll方法唤醒等待的线程
        AwaitSignalExample awaitSignalExample = new AwaitSignalExample();
        ExecutorService executorService5 = Executors.newCachedThreadPool();
        executorService5.execute(() -> awaitSignalExample.after() );
        executorService5.execute(() -> awaitSignalExample.before());

        // JUC-AQS
        // jav.util.concurrent(J.U.C)大大提高了并发的性能，AQS被认为是J.U.C的核心
        //CountdownLatch
        //用来控制一个线程等待多个线程
        // 维护一个计数器cnt,每次调用countDown()方法会让计数器的值减1，减到0的时候，那些因为调用await方法而在等待线程就会被唤醒
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService6 = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService6.execute(() -> {
                System.out.println("run..");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end`");
        executorService6.shutdown();

        //CyclicBarrier用来控制多个线程互相等待，只有当u东哥线程都达到时，这些线程才会继续执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService7 = Executors.newCachedThreadPool();
        for(int i = 0; i< totalThread; i++) {
            executorService7.execute(() -> {
                System.out.println("before...");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after...");
            });
        }
        executorService7.shutdown();

        //Semaphore类似于操作系统中的信号量，可以控制对互斥资源的访问线程数
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService8 = Executors.newCachedThreadPool();
        for (int i = 0; i< totalRequestCount; i++) {
            executorService8.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            });
        }
        executorService8.shutdown();
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        ExecutorService executorService9 = Executors.newCachedThreadPool();
        executorService9.execute(() -> {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce..");
        });
        executorService9.execute(() -> {
            try {
                String produce = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume..");
        });

    }

    static class AwaitSignalExample {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void before() {
            lock.lock();
            try {
                System.out.println("before");
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void after() {
            lock.lock();
            try {
                condition.await();
                System.out.println("after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
    static class WaitNofiyExample{
        public synchronized void before() {
            System.out.println("before");
            notifyAll();
        }
        public synchronized void after() {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after");
        }
    }
    static class JoinExample {
        private class A extends Thread {
            @Override
            public void run() {
                System.out.println("A"); }
        }

        private class B extends Thread{

            private A a;
            public B(A a) {
                this.a = a;
            }

            @Override
            public void run() {
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
            }
        }
        public void test(){
            A a = new A();
            B b = new B(a);
            b.start();
            a.start();
        }
    }
    static class LockExample {

        private Lock lock = new ReentrantLock();
        public void func() {
           lock.lock();
           try {
               for (int i = 0; i < 10; i++) {
                   System.out.print(i +  "*");
               }
               System.out.println();
           } finally {
               lock.unlock();
           }
        }
    }
    // 同步代码块
    // 他只作用一个对象， 如果调用两个对象上的同步代码块，就不会进行同步
    // 以下代码，使用ExecutorService执行了两个线程，由于调用的是同一个对象的同步代码块，因此这两个线程会进行同步，当一个线程进入同步语句块时，另一个线程就必须等待
    static class SynchroizedExample {
        public void  func1() {
            synchronized (this) {
                for (int i = 0; i < 10 ;i++) {
                    System.out.println(i+ " ");
                }
            }
        }
    }


}