package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface  PersionFactory {
    Persion createPersion(String firstName, String lastName);
}

class Persion {
   private String firstName;
   private String lastName;

    @Override
    public String toString() {
        return "Persion{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Persion(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

@FunctionalInterface
interface StringToInt{
   int toInt(String str);
}


public class TestLambda {

    public static void xxx () {

    }
    public static void main(String[] args) {
       /* StringToInt stringToInt = Integer::valueOf;
        String str = "hello.xx";
        Function<String, Boolean> function = str::endsWith;
        Boolean b = function.apply("e");

        System.out.println(b);

        // 構造流
        Stream stream = Stream.of("a", "b", "c");
        String[] strArray = new String[]{"a", "b",  "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        //
        IntStream.of(new int[]{1,2,3}).forEach(System.out::println);


        IntStream.range(1, 3).forEach(System.out::println);

        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        // 流轉換為其它數據結構
        String[] strArray1 = (String[]) stream.toArray(String[]::new);
        List<String>  list1 = (List<String>) stream.collect(Collectors.toList());
        List<String> list2 = (List<String>) stream.collect(Collectors.toCollection(ArrayList::new));
*/

       // map是生成的是個1:1映射，每個輸入的元素都按照規則轉換為另外一個元素，還有一些場景，是一對多映射關係的，這時需要flatmap
        List<String> wordList = new ArrayList<>();
        wordList.add("tiantian");
        wordList.add("sb");

        // 一對1映射關係
        List<String> output = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
        for(String s : output) {
            // System.out.println(s);
        }
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().map(n -> n*n).collect(Collectors.toList());
        for (Integer x : squareNums) {
            // System.out.println(x);
        }
        // 1對多關係
/*

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 3)
        );

        Stream<Integer> outputStream = inputStream.flatMap(xx -> xx.stream());
        for (Object x : outputStream.toArray()) {
            System.out.println(x);
        }*/
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] outputName = Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);
        for (Integer i : outputName) {
            System.out.println(i);
        }
    }
}
