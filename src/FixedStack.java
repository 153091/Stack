import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedStack<Item> {

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

    public static void main(String[] args) {
        int capacity = StdIn.readInt();
        FixedStack<String> stack = new FixedStack<String>(capacity);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.print(stack.pop()+ " ");
            else stack.push(s);
        }
    }
}
