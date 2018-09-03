package Java;


import javafx.util.Pair;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

class Example implements Cloneable{
    private int x;
    private int y;
    private int z;
    public Example(int x,int y,int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Example e = (Example) o;
        if ( x != e.x) return false;
        if ( y != e.y) return false;
        return z == e.z;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }
}

class CloneExample implements Cloneable{
    private int a;
    private int b;

    @Override
    protected  Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/**
 * 浅拷贝
 */
class  ShallowCloneExample implements Cloneable {
    private int[] arr;

    public ShallowCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }
}

/**
 * 深拷贝
 */
class DeepCloneExample implements Cloneable {
   private int[]  arr;
   public DeepCloneExample() {
       arr = new int[10];
       for (int i = 0; i < 10; i++) {
           arr[i] = i;
       }
   }

   public void set(int index, int value) {
       arr[index] = value;
   }

   public int get(int index) {
       return arr[index];
   }

   @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
       DeepCloneExample result = (DeepCloneExample) super.clone();
       result.arr = new int[arr.length];
       for (int i = 0; i <arr.length; i++) {
           result.arr[i] = arr[i];
       }
       return result;
   }
}


class methodClass {
    public final int sb = 3;
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }

}
// 定义泛型类
class Box<T> {
   private T t;
   public void set(T t ) {
       this.t = t;
   }
   public T get() {
       return t;
   }
}

// 泛型方法
class Util  {
   public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
       return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
   }

}
public class JavaTest {
    public static void main(String[] args){
        try {
            Class<?> cls = Class.forName("java.lang.String");
            Object array = Array.newInstance(cls, 25);
            //往数组里添加内容
            Array.set(array, 0, "hello0");
            Array.set(array, 1, "hello1");
            Array.set(array, 2, "hello2");
            Array.set(array, 3, "hello3");
            System.out.println(Array.get(array, 3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

