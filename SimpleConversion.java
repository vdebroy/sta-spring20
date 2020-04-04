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
    }
}
