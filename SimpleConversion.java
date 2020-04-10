public class SimpleConversion{
    public static void main (String[] args) {
        
        int x = 100;
        System.out.println(x);

        String y = "100";
        System.out.println(y);

        // This is adding the number 50 to x
        System.out.println(x + 50);

        // This is tacking on 50 at the end of the string that is y
        // Called 'appending'
        System.out.println(y + 50);

        // What if we wanted to convert the string
        // to an Integer?

        // There exists a helper class for this
        // Like the class Math
        // We found the documentation here
        //https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html#parseInt(java.lang.String)'
  
        System.out.println(Integer.parseInt(y));
        System.out.println(Integer.parseInt(y) + 50);

        // Your task now 
        // is to implement a simplified version of this Integer.parseInt
        // So it takes a String as parameter
        // and returns an int (the integer representation of that string)

        // Let's call our method simpleStringToInt
        // public static int simpleStringToInt (String inputString)


        // Characters vs Ints...
        // Can a character just be convert to an int and vice-versa?
        char a = 'A';
        System.out.println(a);

        System.out.println(5.5);
        // This is called casting...take 5.5 and 'cast it' to an int
        System.out.println((int)5.5);
        System.out.println(6);
        System.out.println((double)6);

        // Now why did we get a 65????
        // a is 'A'
        System.out.println((int)a);

        // This is because of ASCII
        // http://www.asciitable.com/
        // A maps to 65

        // So we have a ready way to convert from a character to an int

        // Isn't a string....just a set of characters?
        // In fact its an array of characters

        // When is a character a number?

        // A little testing
        System.out.println(getIntFromChar('0'));
        System.out.println(getIntFromChar('7'));
        System.out.println(getIntFromChar('A'));
        System.out.println(getIntFromChar('a'));
        System.out.println(getIntFromChar('?'));
        System.out.println(getIntFromChar('5'));

        //simpleStringToInt("Hello");
        simpleStringToInt("56MaxiBoomBoom");
        simpleStringToInt("9875");
        //simpleStringToInt("");
    }
    public static int simpleStringToInt(String y){

        // Loop over each character
        // Get the length of the string

        int stringLength = y.length();

        System.out.println(y + " is " + stringLength + " characters long.");

        // Let's loop over each character...in the String
        // which can be thought of as an array of characters

        if (stringLength > 0) {
            for (int i=0;i < stringLength;i++) {
                char currentCharacter = y.charAt(i);

                //System.out.println(currentCharacter);
                System.out.print(getIntFromChar(currentCharacter));
            }
        }

        return 0;
    }

    public static int getIntFromChar(char inputChar) {
        int convertedDigit = (int)inputChar;
        
        // If our converted number is not between 48 and 57 inclusive...
        // then its not a digit
        
        if (convertedDigit < 48 || convertedDigit > 57) {
            // Not a digit
            System.out.println("The world doesn't make sense anymore!");
            System.out.println("You're trying to play me " +inputChar +" is not a digit...I QUIT!");
            //System.exit(0);
            return -1 ;
        }else {
            return convertedDigit - 48;
        }

    }

}
