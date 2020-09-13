public class ArmstrongNumberProblem {
    public static void main(String[] args) {

        System.out.println(numDigits(5));
        System.out.println(numDigits(55));
        System.out.println(numDigits(555));
        System.out.println(numDigits(5001));
        //System.out.println(numDigits(05001));
        //System.out.println(numDigits(-5001));

        System.out.println("-----------");

        System.out.println(numDigitsSneaky(5));
        System.out.println(numDigitsSneaky(55));
        System.out.println(numDigitsSneaky(555));
        System.out.println(numDigitsSneaky(5001));
        // Problem
        //System.out.println(numDigitsSneaky(-5001));
    }

    public boolean isArmstrongNumber(int number) {
        boolean result = false;
  
        ///

        ///

        return result;

    }

    public static int numDigitsSneaky (int input) {
        return (input + "").length();

    }

    public static int numDigits (int input) {
        int digits = 1;
        if ((input % 10) == input) {
            return digits;
        } else {
            return 1 + numDigits(input/10);
        }
    }
}
