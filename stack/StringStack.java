package stack;

import java.util.LinkedList;

public class StringStack implements Stack  {

    LinkedList<String> stack;
    
    int max;


    @Override
    public int length() {
        return stack.size();
    }

    @Override
    public int capacity() {
        return max;
    }

    @Override
    public String pop() {    
        return stack.getLast();
    }
    
    @Override
    public boolean push(String val) {

        if (stack.size() < max) {
            stack.add(val);  
            return true;          
        }
        return false;
    }   
    
}

/**
 * Stack
 */
interface Stack {
    int length();
    int capacity();
    String pop();
    boolean push(String val);    
}
