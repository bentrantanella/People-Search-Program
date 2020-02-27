
public class People {
	
	String name;
	int age;
	
	public People(int a, String n) {
		name = n;
		age = a;
	}
	
	public People() {
		name = "";
		age = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
