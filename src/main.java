import Java.util.*;

class factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public int factorial(int FacValue) {
        if (FacValue == 1 || FacValue == 0) {
            return 1;
        }

        return FacValue * factorial(FacValue - 1);
    }

}