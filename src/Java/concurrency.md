## java并发
* 新建(New)
    * 创建后尚未启动
* 可运行(Runnable)
    * 可能正在运行，也可能等待CPU时间片
* 阻塞
    * 等待获取一个排它锁，如果其线程释放了锁就会结束此状态
* 无期限等待
    * 等待其他线程显示地唤醒，在一定时间之后会被系统自动唤醒
    * 进入方法
        * 没用设置Timeout参数的Object.wait()方法 Object.notify或者Object.notifyAll() 退出
        * 没用设置Timeout参数的Thread.join()方法 被调用线程执行完毕
        * LockSupport.park()方法
* 限期等待(Time Waiting)
    * 无需等待其他线程显式的唤醒，在一定时间之后会被系统自动唤醒。
    * 调用Thread.sleep()方法使线程进入限期等待
    * 调用Object.wait()方法进入限期等待或者无限期等待时
    * 阻塞和等待的区别在于，阻塞是被动的，它是在等待获取一个排它锁。而等待是主动的，通过调用Thread.sleep()和Object.wait()等方法进入。                   
* 使用线程的方法
    * 实现Runnable接口;
    * 实现Callable接口;
    * 实现Thread类。    