public class JavaMinHeapExample {

 private int[] Heap;
 private int size;
 private int maxsize;

 private static final int FRONT = 1;

 public JavaMinHeapExample(int maxsize) {
  this.maxsize = maxsize;
  this.size = 0;
  Heap = new int[this.maxsize + 1];
  Heap[0] = Integer.MIN_VALUE;
 }

 // int -> int
 // accessing the value in the parent node
 private int parent(int pos) {
  return pos / 2;
 }

 // int -> int
 // getting the index of the left child
 private int leftChild(int pos) {
  return (2 * pos);
 }

 // int -> int
 // getting the index of the right child
 private int rightChild(int pos) {
  return (2 * pos) + 1;
 }

 // int -> boolean
 // return true if the given node is a leaf otherwise, false 
 private boolean isLeaf(int pos) {
  if (pos >= (size / 2) && pos <= size) {
   return true;
  }
  return false;
 }

 // int, int -> void
 // swap the nodes/children
 private void swap(int fpos, int spos) {
  int tmp;
  tmp = Heap[fpos];
  Heap[fpos] = Heap[spos];
  Heap[spos] = tmp;
 }

 // int -> void
 // Heapifying/or sorting the values in the heap.
 private void minHeapify(int pos) {
  if (!isLeaf(pos)) {
   if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
    if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
     swap(pos, leftChild(pos));
     minHeapify(leftChild(pos));
    } else {
     swap(pos, rightChild(pos));
     minHeapify(rightChild(pos));
    }
   }
  }
 }

 // int -> void
 // inserting/adding a value in the tree
 public void insert(int element) {
  Heap[++size] = element;
  int current = size;

  while (Heap[current] < Heap[parent(current)]) {
   swap(current, parent(current));
   current = parent(current);
  }
 }
 
 // -> printing the values in the tree
 public void print() {
  for (int i = 1; i <= size / 2; i++) {
   System.out.print(
     " PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
   System.out.println();
  }
 }

 // -> void
 // identifying the smallest value in the tree
 public void minHeap() {
  for (int pos = (size / 2); pos >= 1; pos--) {
   minHeapify(pos);
  }
 }

 // -> int
 // remove and return the smallest value
 public int remove() {
  int popped = Heap[FRONT];
  Heap[FRONT] = Heap[size--];
  minHeapify(FRONT);
  return popped;
 }

 public static void main(String... arg) {
  System.out.println("The Min Heap is ");
  JavaMinHeapExample minHeap = new JavaMinHeapExample(15);
  minHeap.insert(5);
  minHeap.insert(3);
  minHeap.insert(17);
  minHeap.insert(10);
  minHeap.insert(84);
  minHeap.insert(19);
  minHeap.insert(6);
  minHeap.insert(22);
  minHeap.insert(9);
  minHeap.minHeap();
  
  /*
   *          (3)
   *        /    \
   *     (5)      (6)
   *    /  \      /  \
   *  (9)  (84) (19) (17)
   *  / \
   *(22) (10)
  */
  
  //printing the values in heap tree
  minHeap.print();
  //printing the smallest number in the heap tree
  System.out.println("The Min val is " + minHeap.remove());
  
  //Printing the new tree with removed the smallest number
  minHeap.print();
 }
}
