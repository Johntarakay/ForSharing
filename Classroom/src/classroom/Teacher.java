package classroom;

public class Teacher extends Person{
	private String subject;
	private String email;
	
	public Teacher(String name, String subject, String email) {
		super(name);
		this.subject = subject;
		this.email = email;
	}
	
	public void teach() {
		System.out.println(super.getName()+" is teaching "+this.subject);
	}

	@Override
	public void something() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		String str = "Teacher "+ super.getName()+
				" learning "+ this.subject;
		return str;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		if(email.contains("@") && email.contains(".com")) {
			this.email = email;
		}
	}
	
	
	
}
