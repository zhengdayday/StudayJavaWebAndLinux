package Java;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.function.Function;

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
    public static void main(String[] args) {
        StringToInt stringToInt = Integer::valueOf;
        String str = "hello.xx";
        Function<String, Boolean> function = str::endsWith;
        Boolean b = function.apply("e");

        System.out.print(b);
    }
}
