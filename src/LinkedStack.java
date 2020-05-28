import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStack<Item> {
    private Node first = null;
    private class Node{
        Item item;
        Node next;
    }
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;

    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    private boolean isEmpty()
    { return first==null; }

    public static void main(String[] args) {
	LinkedStack<String> stack = new LinkedStack<String>();
	while (!StdIn.isEmpty()) {
        String s = StdIn.readString();
	    if(s.equals("-")) StdOut.print(stack.pop()+ " ");
	    else stack.push(s);
    }
    }
}