import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStackOfStrings {
    private Node first = null;
    private class Node{
        String item;
        Node next;
    }
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;

    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    private boolean isEmpty()
    { return first==null; }

    public static void main(String[] args) {
	LinkedStackOfStrings stack = new LinkedStackOfStrings();
	while (!StdIn.isEmpty()) {
        String s = StdIn.readString();
	    if(s.equals("-")) StdOut.print(stack.pop()+ " ");
	    else stack.push(s);
    }
    }
}