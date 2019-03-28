package project2;

public class Employee extends ItemType {
	private String name;
	private int retainingTime;
	private int waitingTime;

	public Employee(String name1) {
		name = name1;
		retainingTime = 0;
		waitingTime = 0;
	}
	
	public Employee(String name1, int priority) {
		name = name1;
		waitingTime = priority;
		retainingTime = 0;
	}
	
	public int getPriority() {
		return waitingTime - retainingTime;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name1) {
		name = name1;
	}

	public int getRetainingTime() {
		return retainingTime;
	}

	public void setRetainingTime(int retainingTime1) {
		retainingTime = retainingTime1;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime1) {
		waitingTime = waitingTime1;
	}
	
	public String toString() {
		return name+"(" +getPriority() + ") ";
	}
	
}
