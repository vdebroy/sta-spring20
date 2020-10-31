import java.util.*; 
public class HashMapExample { 
    
    public Map<Integer, Integer> fm;
    
    public HelloWorld() {
        System.out.println("Constructor called!");
        fm = new HashMap<Integer, Integer>(); 
        fm.put(0, new Integer(1)); 
        fm.put(1, new Integer(1)); 
    }
    
    public void printFactorialMap() {
        // Traversing through the map 
        System.out.println("---- Our FACTORIAL MAP ----");
        for (Map.Entry<Integer, Integer> me : fm.entrySet()) { 
           System.out.print(me.getKey() + ":"); 
           System.out.println(me.getValue()); 
        }
        System.out.println("----------");
    }
    
    public int getFactorial(int n) {
        if (n < 0) 
            return -1;
        
        Integer value = fm.get(n);
        
        if (value != null) {
            return value;
        } else {
            value = n * getFactorial(n-1);
            fm.put(n,value);
            printFactorialMap();
        }
        
        return value;
    }
    
    public static void main(String args[]) 
    { 
        HelloWorld hw = new HelloWorld();
        hw.printFactorialMap();
        
        System.out.println(hw.getFactorial(-1));
        System.out.println(hw.getFactorial(0));
        System.out.println(hw.getFactorial(1));
        System.out.println(hw.getFactorial(3)); 
        System.out.println(hw.getFactorial(5)); 
    } 
}
