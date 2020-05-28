import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class ResizingStack<Item> implements Iterable<Item> {

    private int N = 0;
    private Item[] s;

    public ResizingStack(){
        s = (Item[]) new Object[1];
    }
    public void push(Item item){
        if( N == s.length) resize(s.length*2);
        s[N++] = item;
    }
    public Item pop() {
        Item item = s[--N];
        if (N>0 && N == s.length/4) resize(s.length/2);
        s[N] = null;
        return item;
    }
    private boolean isEmpty(){
        return N==0;
    }

    private void resize(int capacity){
       Item[] copy = (Item[]) new Object[capacity];
       for (int i=0; i<N; i++)
           copy[i] = s[i];
       s=copy;
    }

    public Iterator<Item> iterator() {return new ArrayIterator();}

    private class ArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() { return i>0; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() { return s[--i]; }
    }
    public static void main(String[] args) {
        ResizingStack<String> stack = new ResizingStack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.print(stack.pop()+ " ");
            else stack.push(s);
        }
        for (String s : stack)
            System.out.println("Vot oni " +s);
    }
}
