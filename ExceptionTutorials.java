public class ExceptionTutorials {
    public static void main (String[] args) {

        // When we're writing our code, we can run into all kinds of errors

        // Logical Errors....things where our logic is flawed...
        //      This means our code may be valid JAVA, but its not doing
        //      what we actually want it to do

        // Example: we want to add 2 numbers, but we accidentally subtracted them
        //      a + b was written as a-b

        // Syntax Errors....where our code is not valid code
        //      Java can catch syntax errors...it just won't compile
        //      System.out.println("hey);
        //      Missing the closing quote

        // Another kind of error is a Runtime Error
        // Where the code is valid JAVA, but we can hit a snag when the 
        // program is running.

        // Example, division by zero.

        // What happens by default?
        System.out.println(7/3);

        System.out.println("Mickey");

        //System.out.println(7/0); // At this point in time....the program crashes and burns
                                 // And mouse is never printed.

        // We need a way to gracefylly handle the scenario
        // such that Mouse is always printed.
        System.out.println("Mouse");

        // try-catch blocks are built for this

        // Basically...
        // We try something...any operation that can result in a runtime exception/error
        // If we catch an exception, we handle it

        /*

        try {
            ....whatever it is that I am doing that is risky
        } catch (Exception ex) {
            // Ooops I ran into a problem, handle it here
        }

        // Any code below would still run, because I handled the error above
        */
        
        try {
            System.out.println("Daniel is here");
            System.out.println(8/0);
            System.out.println("Daniel is gone");
        } catch (Exception ex) {
            System.out.println("Oh no...trouble!");
        }

        System.out.println("Mouse");

    }
}
