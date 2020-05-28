/** %java FixedStack.java < tobefix.txt
 *
 Note: FixedStack.java uses unchecked or unsafe operations.
 Note: Recompile with -Xlint:unchecked for details.
 to be not that or be Vot ostatok is
 Vot ostatok to

 */


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class FixedStack<Item> implements Iterable<Item> {

    private int N = 0;
    private Item[] s;

    public FixedStack(int capacity){
        s = (Item[]) new Object[capacity];

    }
    public void push(Item item){
        s[N++] = item;
    }
    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        return item;
    }
    private boolean isEmpty(){
        return N==0;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>{
        private int i = N;

        public boolean hasNext() { return i>0; }

        public void remove() { throw new UnsupportedOperationException(); }


        public Item next() {
            return s[--i];
        }
    }

    public static void main(String[] args) {
        int capacity = StdIn.readInt();
        FixedStack<String> stack = new FixedStack<String>(capacity);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.print(stack.pop()+ " ");
            else stack.push(s);
        }
        for (String s : stack)
            StdOut.println("Vot ostatok " + s);
    }



}
