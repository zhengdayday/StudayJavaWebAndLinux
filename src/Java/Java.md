* 不会的java知识 
* 
* 包装类型
    * new Integer(123) 与 Interget(123)的区别在于
        * new Integer(123) 每次都是新建一个对象
        * Integer.valueOf(123)会使用缓存池中的对象，多次调用会取得同一个对象的引用
    * valueOf方法的实现比较简单，是先判断值是否存在缓存池中，如果在的话，就直接返回缓存池的内容
    * 在Java 8中 Integer缓存池的大小默认为-128~127
    * 并且编译器会在自动装箱过程调用valueOf()方法
    * 基本类型的缓冲池如下
       * boolean values true and false
       * all byte values
       * short values between -128 and 127
       * int values beetween -128 and 127
       * char in the range \u0000 to \u007F
* String
    * String被声明为final，因此它不可被继承
    * 内部使用char数组存储数据，该数组也是final
    * 不可变的好处        
        * 缓存hash值
        * String pool的需要
            * 一个String对象已经被创建过了，那么就会从String Pool中取得引用。只有String是不可变的，才可能使用String pool
        * String经常作为参数，String不可变性可以保证参数不可变  
        * String不可变性天生具备线程安全，可以在多个线程中安全地使用
            * String, StringBuffer and StringBuilder
            * 可变性
                * String 不可变
                * StringBuffer和StringBuilder可变
            * 线程安全
                * String不可变，因此是线程安全的
                * StringBuilder不是线程安全的
                * StringBuffer是线程安全的，内部使用synchronized进行同步 
        * String Pool 字符串常量池
            * 保存所有字符串字面量， 这些字面量在编译时期就确定。不仅如此，还可以使用String的intern()方法在运行过程中将字符串添加到String Pools 
            * inter()方法
                * 如果String Pool中已经存在一个字符串和该字符串值想等(equal)，那么就会返回String Poll中字符串的引用；否则，就会在String Poll中添加一个新的字符串，并返回这个字符串的引用。
                * 如果采用字面量String sb = "sb";会自动放入String Pool中
            * Java7之前，String poll被放在运行时常量池中，属于永久代。而在Java7,String Poll被移到堆中。这是因为永久代的空间有限，在大量使用字符串场景下会导致OOM
        * new String("sb") 会创建两个字符串对象(前提是String Poll中还没有"sb"字符串对象)     
            * "sb"属于字符串字面量，因此编译时期会在String  Poll中创建一个字符串对象，指向这个"abc"字符串字面量
            * 而使用new的方式会在堆中创建一个字符串对象。
* 运算
    * Java中的参数是以值传递的形式传入方法中，而不是引用传递
    * float 与 double
        * 1.1字面属于double类型，不能直接赋给float变量，因为这是向下转型，Java不能隐式的向下转型，因为这会使得精度降低。
        * 1.1f才是float类型
    * 隐式类型转换
        * 因为1是int类型，它比short类型精度要高，因此不能隐式int类型向下转型为short类型
                        
                              