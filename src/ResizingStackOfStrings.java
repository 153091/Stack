import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingStackOfStrings {

    private int N = 0;
    private String[] s;

    public ResizingStackOfStrings(){
        s = new String[1];
    }
    public void push(String item){
        if( N == s.length) resize(s.length*2);
        s[N++] = item;
    }
    public String pop() {
        String item = s[--N];
        if (N>0 && N == s.length/4) resize(s.length/2);
        s[N] = null;
        return item;
    }
    private boolean isEmpty(){
        return N==0;
    }

    private void resize(int capacity){
       String[] copy = new String[capacity];
       for (int i=0; i<N; i++)
           copy[i] = s[i];
       s=copy;
    }

    public static void main(String[] args) {
        ResizingStackOfStrings stack = new ResizingStackOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.print(stack.pop()+ " ");
            else stack.push(s);
        }
    }
}
