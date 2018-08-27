package Java;

public class JavaTest {

    public static void main(String[] args) {/*
        System.out.println(new Integer(123) == new Integer(123));
        System.out.println(Integer.valueOf(123) == Integer.valueOf(123));

        String sb = new String("sb");
        String sb1 = new String("sb1");
        System.out.println(sb == sb1);
        System.out.println(sb.intern() == sb.intern());*/
        short s1 = 1;
        s1 += 1; // 相当与 (short) )(s1 + 1)
        System.out.println(s1);
    }
}
