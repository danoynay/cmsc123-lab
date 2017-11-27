import java.util.*;

class HashT {
  
  class HashNode {
    String key;
    int value;
    HashNode next;
  
    HashNode(String key, int value) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  HashNode[] HashT; 
  int size; 
  int MAXsize; 
  
HashT() {
  MAXsize = 100;
  HashT = new HashNode[MAXsize];
    for (int i = 0; i < MAXsize; i++)
      HashT[i] = null;
  }  

  public int getHash(String key) {
    int hashCode = key.hashCode();
    int hashValue = hashCode % MAXsize;
      return hashValue;
    }

  public void display() {
    for (int i = 0; i < MAXsize; i++) {
      System.out.println("\nHash Index "+ (i + 1) +" : ");
      HashNode Node_new = HashT[i];
      while (Node_new != null) {
        System.out.print(Node_new.value +" ");
        Node_new = Node_new.next;
      } 
    }
  }


//-----------------------------------------------------------------
  // String -> int
  // return the value of the key
  public int get(String key) {
    int hash = (getHash(key) % MAXsize);
      if(HashT[hash] == null) {
        return -1;
      }
    
    HashNode Node_new = HashT[hash];
      while(Node_new.next != null && Node_new.key != key) {
        Node_new = Node_new.next;
      }
       if(Node_new.key == null) {
        return -1;
      }
      return Node_new.value;
  }
//------------------------------------------------------------------
  // String -> boolean
  // returns true if the key exists in the hash table, false if not.
  public boolean contains(String key) {
    int hash = (getHash(key) % MAXsize);
    
    if(HashT[hash] == null) {
      return false;
    }
    HashNode Node_new = HashT[hash];
    while(Node_new.next != null && Node_new.key != key) {
      Node_new.next = Node_new;
    }
    if(Node_new.key == null) {
      return false;
    }
    return true;
  }
//-------------------------------------------------------------------
  // String -> int
  // returns the values with the removed value associated with the key.
  public int remove(String key) {
    int hash = (getHash(key) % MAXsize);
    
    if(HashT[hash] == null) {
      return -1;
    }
    
    HashNode previous = null;
    HashNode Node_new = HashT[hash];
      
    while(Node_new.next != null && Node_new.key != key) {
      previous = Node_new;
      Node_new.next = Node_new;
    }
    if(Node_new.key == null) {
      return -1;
    }
    
    if(previous == null)
      HashT[hash] = Node_new.next;
    else
      previous.next = Node_new.next;
    
    size--;
    return Node_new.value;
  }
//--------------------------------------------------------------
  // String, int -> 
  // insert a key value to a hash
  public void put(String key, int value) {
    int hash = (getHash(key) % MAXsize);
    
    if(HashT[hash] == null) {
      HashT[hash] = new HashNode(key, value);
    }
    else {
      HashNode Node_new = HashT[hash];
      while(Node_new.next != null && Node_new.key != key) {
        Node_new = Node_new.next;
      }
      if(Node_new.key == key) {
        Node_new.value = value;
      }
      else {
        Node_new.next = new HashNode(key, value);
      }
    }
    size++;
  }
//-----------------------------------------------------------  
  // -> List
  // returns a list of all values in the data structure
  public List values() {
    List ListofValues = new ArrayList();
    for (int i = 0; i < MAXsize; i++) {
      HashNode Node_new = HashT[i];
      while (Node_new != null) {
        ListofValues.add(Node_new.value);
        Node_new = Node_new.next;
      } 
    }
    return ListofValues;
  }
//-------------------------------------------------------------  
  // -> List
  // returns a list of all keys in the data structure
  public List keys() {
    List keyList = new ArrayList();
    for (int i = 0; i < MAXsize; i++) {
      HashNode Node_new = HashT[i];
      while (Node_new != null) {
        keyList.add(Node_new.key);
        Node_new = Node_new.next;
      } 
    }
    return keyList;
  }

//-------------------------------------------------------------
}