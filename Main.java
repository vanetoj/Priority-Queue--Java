package project2;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		Library library = new Library();
		library.add_book("Software Engineering");
		library.add_book("Chemistry");

		library.add_employee("Adam");
		library.add_employee("Sam");
		library.add_employee("Ann");

		library.circulate_book("Chemistry", createDate(2015, 3, 1));
		library.circulate_book("Software Engineering", createDate(2015, 4, 1));
		library.pass_on("Chemistry", createDate(2015, 3, 5));

		
		
		library.pass_on("Software Engineering", createDate(2015, 4, 5));
		library.pass_on("Software Engineering", createDate(2015, 4, 10));
		library.pass_on("Software Engineering", createDate(2015, 4, 15));
		
		library.print();
		
		System.out.println("DONE");
	}


	public static Date createDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(year, month, day);
		return c.getTime();
	}
	
}
