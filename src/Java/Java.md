* 不会的java知识 
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
                        
* 接口
    * 接口从java8开始，接口也可以拥有默认的方法实现。
    * 接口的成员（方法+字段）默认都是public的，并且不允许定义为private或者protected
    * 接口的字段默认都是static 和 final的
    * 从设计层面上看，抽象类提供了一种 IS-A 关系，那么就必须满足里式替换原则，即子类对象必须能够替换掉所有父类对象。而接口更像是一种 LIKE-A 关系，它只是提供一种方法实现契约，并不要求接口和实现接口的类具有 IS-A 关系。  
    * 从使用上来看，一个类可以实现多个接口，但是不能继承多个抽象类
    * 接口的字段只能是static 和 final类型的，而抽象类没有这种限制
    * 接口的成员只能是public的，而抽象类的成员可以有多种访问权限
    * 使用接口：
        * 需要让不相关的类都实现一个方法，例如不相关的类都可以实现 Compareable 接口中的 compareTo() 方法；
        * 需要使用多重继承。
    * 使用抽象类：
        * 需要在几个相关的类中共享代码。
        * 需要能控制继承来的成员的访问权限，而不是都为 public。
        * 需要继承非静态和非常量字段。
    * super 
        * 访问父类的构造函数: 可以使用super()函数访问父类的构造函数，从而委托父类完成一些初始化工作
        * 访问父类的成员: 如果子类重写了父类的某个方法的实现，可以通过使用super关键字来引用父类的方法实现
    * 重写
        * 子类方法访问权限必须大于等于父类方法
        * 子类方法的返回类型必须是父类方法返回类型或为其子类型
    * 重载
        * 存在于同一个类中，指一个方法与已经存在的方法名称上相同，但是参数类型、个数、顺序至少有一个不同。应该注意的是，返回值不同，其它都相同不算是重载        
* clone
    * 如果一个类没有实现 Cloneable 接口又调用了 clone() 方法，就会抛出 CloneNotSupportedException。  
    * 浅拷贝
        * 拷贝对象和原始对象的引用类型引用同一个对象
    * 深拷贝
        * 拷贝对象和原始对象的引用类型引用不同对象
    * 反射
        * Class 和 java.lang.reflet 一起对反射提供了支持， java.lang.reflect类库主要包含以下三个类:
            * File: 可以使用get()和set()方法读取Field对象关联的方法;
            * Method: 可以使用invoke()方法调用与Method对象关联的方法;     
            * Constructor: 可以用Constructor创建新的对象
        *  获取Class对象
            * 使用Class类的forName静态方法
            ```java
                Class.forName(""); 
            ```
            * 直接获取某一个对象的Class
            ```java
               Class<?> klass = int.class;
               Class<?> classInt = Integer.TYPE;
            ```
            * 调用某个对象的getClass(）
           ```java
              StringBuilder str = new StringBuilder("123");
              Class<?> ss = str.getClass();
           ``` 
        * 判断是否为某个类的实例
        ````java
            public native boolean isInstance(Object obj);
        ```` 
        * 创建实例
        ```java
           //使用Class对象的newInstance()方法来创建对应类的实例
           Class<?> c = String.class;
           Object str = c.newInstance();
           //使用Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance方法来创建实例
           Class<?> c = String.class;
           Constructor = constructor = c.getConstructor(String.class);
           System.out.println(obj);
        ```
        