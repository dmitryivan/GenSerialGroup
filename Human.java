import java.io.Serializable;

public class Human  implements Serializable {
protected String name;
protected String gender;
protected int age;
public Human(String name, String gender, int age) {
	super();
	this.name = name;
	this.gender = gender;
	this.age = age;
}

public Human() {
	super();
	this.name = "Anonim";
	this.gender = "Undefined";
	this.age = 666;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

@Override
public String toString(){
return "Name: " + this.getName() + " Gender: " + this.getGender() +" Age: "+this.getAge();	
}

}
