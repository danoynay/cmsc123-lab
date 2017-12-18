import java.lang.IllegalArgumentException;

class Heap {
  int[] heap; 
  int maxSize; 
  int size; 
  
  Heap(int maxSize) {
    this.size = 0;
    heap = new int[maxSize];
    heap[0] = Integer.MIN_VALUE;
  }
  
    // int -> void
    // and inserts it to the bottom of the heap.
    public void add(int value) {
      size++;
      heap[size] = value;
      bubbleUp();
    }
    
    //  -> int
    // removes the smallest value in the heap then returns it.
    public int remove() {
      int poppedItem = heap[1];
      
        heap[1] = heap[size];
        heap[size] = 0;
        bubbleDown(1);
      return poppedItem;
    }

    // -> void
    // places the newly-inserted valuein its correct position.
    protected void bubbleUp() {
      int childIndex = size;
      
      while(heap[childIndex] < heap[parent(childIndex)]) {
        swap(childIndex, parent(childIndex));
        childIndex = parent(childIndex);
      }
    }
    
    // int -> void
    // places the value, which is the root, in its correct position.
    protected void bubbleDown(int index) {
      if(!isLeaf(index)) {
        if(heap[index] > heap[leftChild(index)] || heap[index] > heap[rightChild(index)]) {
          if(heap[leftChild(index)] < heap[rightChild(index)]) {
            swap(index, leftChild(index));
            bubbleDown(leftChild(index));
          }
          else {
            swap(index, rightChild(index));
            bubbleDown(rightChild(index));
          }
        }
      }
    }
    
    // int, int -> void
    // swaps the parent's position with its child's. 
    protected void swap(int childIndex, int parentIndex) {
      int tmp = heap[parentIndex];
      heap[parentIndex] = heap[childIndex];
      heap[childIndex] = tmp;
    }
    
    // -> void
    // prints the values of the Heap
    public void display() {
      for(int i = 1; i <= size; i++) {
        System.out.print(heap[i] + " ");
      }
      System.out.println();
    }
////////////////////////////TRAVERSALS//////////////////////////////////////
    // -> void
    // preorder traversal
    public void preorder() {
      int index = 1;
      preorder(index);
      System.out.println();
    }
      // that is, root -> leftChild -> rightChild.
      protected void preorder(int index) {
        if(index > size) {
          return;
        }
        System.out.print(heap[index] + " ");
        preorder(leftChild(index));
        preorder(rightChild(index));
    }
    
    // -> void
    // inorder traversal
    public void inorder() {
      int index = 1;
      inorder(index);
      System.out.println();
    }

      // that is, leftChild -> root -> rightChild.
      protected void inorder(int index) {
        if(index > size) {
          return;
        }
        inorder(leftChild(index));
        System.out.print(heap[index] + " ");
        inorder(rightChild(index));
    }
    
    // -> void
    //  postorder traversal
    public void postorder() {
      int index = 1;
      postorder(index);
      System.out.println();
    }

    // that is, leftChild ->rightChild -> root.
    protected void postorder(int index) {
      if(index > size) {
        return;
      }
      postorder(leftChild(index));
      postorder(rightChild(index));
      System.out.print(heap[index] + " ");
    }
    
    // int -> boolean
    // returns true if an index is a leaf, false otherwise.
    protected boolean isLeaf(int i) {
      return ((i >= (size / 2)) && (i <= size));
    }
    
    // fumction which returns the parent's postion
    protected int parent(int i) {
      return i / 2;
    }
    
    // fumction which returns the left child's postion
    protected int leftChild(int i) {
      return 2 * i;
    }
    
    // fumction which returns the right child's postion
    protected int rightChild(int i) {
      return 2 * i + 1;
    }
  }