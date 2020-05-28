/** %java LinkedStack.java < tobe.txt

 to be not that or be Vot element is
 Vot element to

 */


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item> {
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

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext() { return current != null ;}
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
                    return item;
            }

    }

    public static void main(String[] args) {
	LinkedStack<String> stack = new LinkedStack<String>();
	while (!StdIn.isEmpty()) {
        String s = StdIn.readString();
	    if(s.equals("-")) StdOut.print(stack.pop()+ " ");
	    else stack.push(s);
    }
        for (String s : stack)
            StdOut.println("Vot element " +s);
    }
}