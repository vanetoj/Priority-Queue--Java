package project2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Library {

	List<Book> booksToBeCirculated = new ArrayList<Book>();
	List<Book> archivedBooks = new ArrayList<Book>();
	List<Employee> employees = new ArrayList<Employee>();

	public void add_book(String bookName) {
		Book newBook = new Book(bookName);
		newBook.setArchived(false);
		for (Employee e : employees) {
			newBook.getEmployeeQueue().push(e);
		}
		booksToBeCirculated.add(newBook);
	}

	public void add_employee(String employeeName) {
		Employee newEmployee = new Employee(employeeName);
		for (Book b : booksToBeCirculated) {
			b.getEmployeeQueue().push(newEmployee);
		}
	}

	public void circulate_book(String bookName, Date circulationDate) {
		Book book = locateBook(bookName);
		book.setCirculationStartDate(circulationDate);
		Employee nextEmployee = (Employee) book.getEmployeeQueue().pop();
		book.setCheckedOutBy(nextEmployee);
	}

	public void pass_on(String bookName, Date passOnDate) {
		Book book = locateBook(bookName);
		Employee checkedOutBy = book.getCheckedOutBy();
		int daysCheckedOut = daysBetween(book.getCirculationStartDate(), passOnDate);
		checkedOutBy.setRetainingTime(checkedOutBy.getRetainingTime() + daysCheckedOut);
		Employee nextEmployee = (Employee) book.getEmployeeQueue().pop();
		if (nextEmployee == null) {
			book.setArchived(true);
			archivedBooks.add(book);
			booksToBeCirculated.remove(book);
		} else {
			nextEmployee.setWaitingTime(nextEmployee.getWaitingTime() + daysCheckedOut);
			book.setCheckedOutBy(nextEmployee);
			book.setCirculationStartDate(passOnDate);
		}
		for (Book b : booksToBeCirculated) {
			b.getEmployeeQueue().reorder();
		}
	}

	private Book locateBook(String bookName) {
		Book book = null;
		for (Book testBook : booksToBeCirculated) {
			if (testBook.getName().equals(bookName)) {
				book = testBook;
			}
		}
		if (book == null) {
			throw new RuntimeException("Book " + bookName + " not in Library");
		}
		return book;
	}

	private int daysBetween(Date one, Date two) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(one);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(two);
		int daysBetween = 0;
		while (c1.before(c2)) {
			c1.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween = daysBetween + 1;
		}
		return daysBetween;
	}
	
	public void print() {
		for (Book b : booksToBeCirculated) {
			System.out.println(b);
		}
	}
}
