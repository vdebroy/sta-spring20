public class IncrementExamples {
    public static void main (String[] args) {

        int i = 0;

        // Incrementing i
        System.out.println(i++);
        // The output of the above was zero... not 1 :(

        System.out.println(i);
        // The output of the above is 1...

        //i++ means 
        //     increment 'i' by 1...but you don't see the change
        //     till the next time 'i' is encountered/used.

        // At this point in time, 'i' is 1

        // Incrementing i
        System.out.println(++i);

        // The output of the above is 2...
        // Because the increment happens immediately.

        System.out.println(i);
        // The output of the above is 2...because the increment has already happened
        
        
        //System.out.println(++i++);
        // Doing the above results in a compilation error    
        
        //System.out.println((++i)++);
        //System.out.println(++5);
        // The above doesn't work
        // ....because increment operators are only designed to work with
        // variables, not direct numbers.

    }
}
