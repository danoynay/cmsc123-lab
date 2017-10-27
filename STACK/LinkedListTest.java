import junit.framework.TestCase;
import java.util.*;

public class LinkedListTest extends TestCase {
  
  public void testAdd() {
    LinkedList<String> link = new LinkedList<String>();
    assertEquals(true, link.add("apple", 0));
    assertEquals(true, link.add("mango", 1));
    assertEquals(true, link.add("grapes", 2));
    assertEquals(true, link.add("orange", 3));
    assertEquals(true, link.add("guava", 4));
  }
  
  public void testRemove() {
    
    LinkedList<String> link = new LinkedList<String>();
    
    link.add("apple", 0);
    link.add("mango", 1);
    link.add("grapes", 2);
    link.add("orange", 3);
    link.add("guava", 4);
    assertEquals(true, link.remove(3));
  }
  
  public void testHasNext() {
    
    LinkedList<String> link = new LinkedList<String>();
    
    link.add("apple", 0);
    link.add("mango", 1);
    link.add("grapes", 2);
    link.add("orange", 3);
    link.add("orange", 4);
    
    Iterator iter = link.iterator();
    
    assertEquals(true, iter.hasNext());
  }
  
  public void testNext() {
    
    LinkedList<String> link = new LinkedList<String>();
    
    Iterator iter = link.iterator();
    
    while(iter.hasNext())
      System.out.println(iter.next() + " ");
  }
}