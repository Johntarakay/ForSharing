package classroom;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student("baba", "Film", 12);
		Student s2 = new Student();
		Student s3 = new Student("moshe", "Math", 11);
		Teacher t4 = new Teacher("sas", "Math", "dor@gmail");
		
		s2.setName("Dor");
		s2.name = "ddd";
		t4.setEmail("ss");
		System.out.println(t4.getEmail());
		
		System.out.println(Person.getCount());
		t4.setEmail("dor@b.com");
		System.out.println(t4.getEmail());
	}
	
	private void another() {
				
	}
}
