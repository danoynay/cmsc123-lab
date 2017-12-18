import java.util.NoSuchElementException;

public class ArrayinQueue {
	int[] array;
	int head;
	int tail;
	int arraySize;
	int max;
	
	public static final int RES = 2;

	public ArrayinQueue(int max) {
		this.array = new int[max];
		this.head = 0;
		this.tail = 0;
		this.arraySize = 0;
		this.max = max;
	}

	// int -> void
	// add (an item of data awaiting processing) to a queue of such items.
	public void enqueue(int item) {
		if (arraySize == array.length) {
			int arr = head - tail;
			if (((arr) == -1) || (arr) == (arraySize - 1)) {
				int resize = (int) (array.length * RES);
				int[] NewArr = new int[resize];

				for (int i = head; i <= tail; i++) {
					NewArr[i - head] = array[i % array.length];
				}

				array = NewArr;
				head = item;
				tail = arraySize - 1;
				array[arraySize] = array[resize];
			}
		}
		if (arraySize == 0) {
			head = head + 1;
		}

		array[tail] = item;
		tail = (tail + 1) % this.max;
		arraySize++;
	}

	// -> int
	// remove (an item of data awaiting processing) from a queue of such items.
	public int dequeue() {
		if (!(isEmpty())) {
			int item = array[head - 1];
			array[head - 1] = head;
			head = (head + 1) % arraySize;
			return item;
		}
		throw new NoSuchElementException();
	}
	
	// -> int
	// return the size of the array
	public int size() {
		return arraySize;
	}
	
	// -> boolean
	// return true if the array is empty, false otherwise
	public boolean isEmpty() {
		return arraySize == 0;
	}
	
	// -> Object
	// check the number in teh given index
	public Object peek() {
		if (!(isEmpty())) {
			return array[head - 1];
		}
		//else
		return null;
	}

}