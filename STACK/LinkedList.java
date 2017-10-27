import java.util.NoSuchElementException;

public class LinkedList<E> implements Collection<E> {
  
  public class Node {
    E data;
    Node next;
    
    Node(E data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  Node head = null;
  int size = 0;
  
  LinkedList() {}
  
// E,int -> boolean
// received type E item, and int and add the item at the given index 
public boolean add(E item, int index) {
  
  Node nNode = new Node(item, head);
    
  if (this.size == 0 || index == 0) {
    this.head = nNode;
    this.size++;
  return true;
  }
   
  Node current = this.head;
  Node previous = null;
  
  for(int i = 0; i < index; i++) {
    previous = current;
    current = current.next;
    if(current == null) {
      break;
    } 
  }
    
    nNode.next = current;
    previous.next = nNode;
    size++;
    return true;
  }
  
// int -> boolean
// accepts index in integer and remove the item at the given index.
public boolean remove(int index) {
  
  if(this.size == 0)
    return false;
    
  Node current = this.head;
  Node previous = null;
  
  for(int i = 0; i < index; i++) {
    previous = current;
    current = current.next;
      if(current == null) {
        break;
      } 
  }
     previous.next = current.next;
     current.next = null;
     this.size--;
     return true;
  }
  
// -> int
// returns the size of the list.
public int size() {
  
  return this.size;
}
  

// -> Iterator<E>
// returns an instance of the LinkedListIterator.
public Iterator<E> iterator() {
  
  return new LinkedListIterator();
}
   
class LinkedListIterator implements Iterator<E> {
  Node current = head;
    
  public boolean hasNext() {
    return (current != null);
  }
  
  public E next() {
    if(!(hasNext()))
      throw new NoSuchElementException();
      
    E item = current.data;
    current = current.next;
    return item;
    }
  }
}