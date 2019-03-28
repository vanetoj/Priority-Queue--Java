package project2;

import java.util.Date;

public class Book {
	private String name;
	private Date circulationStartDate;
	private Date circulationEndDate;
	private boolean archived;
	private PriorityQueue employeeQueue = new PriorityQueue();
	private Employee checkedOutBy;

	public Book(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCirculationStartDate() {
		return circulationStartDate;
	}

	public void setCirculationStartDate(Date circulationStartDate) {
		this.circulationStartDate = circulationStartDate;
	}

	public Date getCirculationEndDate() {
		return circulationEndDate;
	}

	public void setCirculationEndDate(Date circulationEndDate) {
		this.circulationEndDate = circulationEndDate;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public PriorityQueue getEmployeeQueue() {
		return employeeQueue;
	}

	public void setEmployeeQueue(PriorityQueue employeeQueue) {
		this.employeeQueue = employeeQueue;
	}

	public Employee getCheckedOutBy() {
		return checkedOutBy;
	}

	public void setCheckedOutBy(Employee checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", circulationStartDate=" + circulationStartDate + ", circulationEndDate="
				+ circulationEndDate + ", archived=" + archived + ", employeeQueue=" + employeeQueue + ", checkedOutBy="
				+ checkedOutBy + "]";
	}
}
