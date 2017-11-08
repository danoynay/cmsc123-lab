import java.util.Iterator;
import java.util.NoSuchElementExeption;

//Returns an iterator to this stack that iterates through the items in LIFO order
public Iterator<Item> iterator() { return new ListIterator(); }

private class ListIterator implements Iterator<Item> {
	private Node current = first;
	public boolean hasNext() {
		return current != null;
	public void remove(){
		throw new UnsupportedOperationExeption();
		}
		public Item next(){
			if (!hasNext()) throw new NoSuchElementExeption();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args){
		Stack<String> sta = new Stack<String>();
		while (!StdIn.isEmpty()){
			String item = StdIn.readString();
			if (!item.equals("-")) stack.push(item);
			else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
		}
		StdOut.println("(" + stack.size() + "left on stack");
	}
}


public class Stack<Item> implements Iterable<Item> {
	private int n;		//size of the stack
	private Node first; //top of stack

	private class Node{
		private Item item;
		private Node next;
	}
}

// Item -> 
//ads the item to the stack
public void push(Item item){
	Node oldfirst = first;
	first = new Node();
	first.item = item;
	first.next = oldfirst;
	n++;
}

// -> Item
// Removes and returns the item most recently added to this stack.
public Item pop(){
	if (isEmpty()) throw new NoSuchEElementExceptio("Stack underflow");
	Item item = first.item;		//save item to return
	first = first.next;			//delete first node
	n--;
	return item;				//return the save item
}

// -> Item
// returns the item most recently addes to the stack
public Item peek(){
	if (isEmpty()) throw new NoSuchElementExeption("Stack underflow");
	return first.item;
}

public Stack(){
	first = null;
	n = 0;
}

// -> boolean
//return true if the stafck is empty
public boolean isEmpty(){
	return first == null;
}

// -> int
//returns the number of item in the stack
public int size(){
	return n;
}

public String toString(){
	StringBuilder s = new StringBuilder();
	for (Item item : this){
		s.append(item);
		s.append(' ');
	}
	return s.String();
}

