import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedStackOfStrings {

    private int N = 0;
    private String[] s;

    public FixedStackOfStrings(int capacity){
        s = new String[capacity];

    }
    public void push(String item){
        s[N++] = item;
    }
    public String pop() {
        return s[--N];
    }
    private boolean isEmpty(){
        return N==0;
    }
    public static void main(String[] args) {
        int capacity = StdIn.readInt();
        FixedStackOfStrings stack = new FixedStackOfStrings(capacity);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.print(stack.pop()+ " ");
            else stack.push(s);
        }
    }
}
