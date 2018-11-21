package learningforinterview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class JavaEightSorting {

	public static void main(String[] args) {
		JavaEightSorting obj = new JavaEightSorting();
		obj.sortStrings();
		obj.sortStringsBasedOnLength();
		List<Employee> emps = obj.createEmployees();
		obj.sortEmployeeByHireDate(emps);
		obj.sortEmployeeMulti(emps);
	}

	private List<Employee> createEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee("Akash", "Tumkur", "03/05/2015"));
		emps.add(new Employee("Chetan", "Kuna", "01/05/2013"));
		emps.add(new Employee("Nithesh", "Raju", "02/08/2014"));
		emps.add(new Employee("Neghraj", "Nadagouda", "03/05/2015"));
		return emps;
	}

	private void sortStrings() {
		String[] names = { "One", "Two", "Three", "Four", "Five", "Six", "Seven" };
		System.out.println("-----------");
		System.out.println("--- sort strings ---");
		Stream.of(names).sorted((o1, o2) -> o1.compareToIgnoreCase(o2)).forEach(str -> System.out.println(str));
		// Stream.of(names).sorted(String::compareToIgnoreCase).forEach(System.out::println);
	}

	private void sortStringsBasedOnLength() {
		String[] names = { "One", "Two", "Three", "Four", "Five", "Six", "Seven" };
		System.out.println("-----------");
		System.out.println("--- sort strings based on length ---");
		Stream.of(names).sorted((o1, o2) -> Integer.compare(o1.length(), o2.length())).forEach(System.out::println);
	}

	private void sortEmployeeByHireDate(List<Employee> emps) {
		System.out.println("-----------");
		System.out.println("--- sort Employees by hired date ---");
		emps.stream().sorted((e1, e2) -> e1.getHireDate().compareTo(e2.getHireDate())).forEach(System.out::println);
	}

	private void sortEmployeeMulti(List<Employee> emps) {
		System.out.println("-----------");
		System.out.println("--- Multi sort Employees ---");
		Comparator<Employee> byFirstName = (e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName());
		Comparator<Employee> byLastName = (e1, e2) -> e1.getLastName().compareTo(e2.getLastName());
		emps.stream().sorted(byFirstName.thenComparing(byLastName)).forEach(System.out::println);
	}
}

class Employee {
	public Employee(String firstName, String lastName, String hireDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.hireDate = sdf.parse(hireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", hireDate=" + hireDate + "]";
	}

	private String firstName;
	private String lastName;
	private Date hireDate;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getHireDate() {
		return hireDate;
	}
}