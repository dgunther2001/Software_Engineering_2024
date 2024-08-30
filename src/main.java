import java.util.*;

class factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int facValue) {
        if (facValue == 1 || facValue == 0) {
            return 1;
        }

        return facValue * factorial(facValue - 1);
    }

}