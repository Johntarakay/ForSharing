package classroom;

public class Student extends Person{
	public String major;
	private int age;

	public Student() {
		super("new");
		this.major = "none";
		this.age = 0;
	}
	
	public Student(String name, String major, int age) {
		super(name);
		this.major = major;
		this.age = age;
	}
	
	public void another() {
		System.out.println("Another");
	}
	
	public void another(int num) {
		System.out.println("Another int "+num);
	}
	
	public void another(double num) {
		System.out.println("Another double "+num);
	}
	
	public void another(boolean bool) {
		System.out.println("Another boolean "+bool);
	}


	@Override
	public String toString() {
		String str = "Student "+ super.getName()+
				" learning "+ this.major;
		return str;
	}

	@Override
	public void something() {
		// TODO Auto-generated method stub
		
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if(age > 0 && age <= 18) {
			this.age = age;
		}
	}

}
