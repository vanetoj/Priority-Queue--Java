package project2;

public class PriorityQueue {

	private ItemType[] theData;
	private int front_index;
	private int back_index;
	private int num_items;

	public PriorityQueue() {
		theData = new ItemType[10];
		front_index = 0;
		back_index = 0;
		num_items = 0;
	}

	private PriorityQueue(int capacity) {
		theData = new ItemType[capacity];
		front_index = 0;
		back_index = 0;
		num_items = 0;
	}

	public boolean isEmpty() {
		return num_items == 0;
	}
	
	public boolean isFull() {
		return num_items == theData.length;
	}

	public void push(ItemType item) {
		if (isFull()) {
			enlarge();
		}

		if (isEmpty()) {
			theData[front_index] = item;
			num_items = 1;
			return;
		}

		int index = 0, i = 0, new_index = 0;

		for (i = 0; i < num_items; ++i) {
			index = (front_index + i) % theData.length;
			if (item.getPriority() > theData[index].getPriority()) {
				break;
			}
		}

		for (int j = 0; j < num_items - i; ++j) {
			index = (back_index - j) % theData.length;
			new_index = (index + 1) % theData.length;
			theData[new_index] = theData[index];
		}

		num_items++;
		theData[(front_index + i) % theData.length] = item;
		back_index = (back_index + 1) % theData.length;
	}

	public ItemType pop() {
		ItemType firstItem = theData[front_index];
		theData[front_index] = null;
		front_index = (front_index + 1) % theData.length;
		num_items = num_items - 1;
		return firstItem;
	}

	public void reorder() {
		copyQueue(theData.length);
	}

	public void enlarge() {
		copyQueue(theData.length * 2);
	}

	private void copyQueue(int capacity) {
		PriorityQueue newPriorityQueue = new PriorityQueue(capacity);
		while (!isEmpty()) {
			newPriorityQueue.push(pop());
		}
		num_items = newPriorityQueue.num_items;
		theData = newPriorityQueue.theData;
		front_index = 0;
		back_index = num_items - 1;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < theData.length; i++) {
			if (i == front_index)
				sb.append("*F*:");
			if (i == back_index)
				sb.append("*B*:");
				sb.append(theData[i]);
				sb.append(", ");
		}
		return sb.toString();
	}
}
