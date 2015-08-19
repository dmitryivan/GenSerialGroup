import java.io.Serializable;

public class Student extends Human implements StudentInterface, Serializable, Comparable <StudentInterface> {
protected String contract;
public String sortCriteria = "age";


public String getSortCriteria() {
	return sortCriteria;
}

public void setSortCriteria(String sortCriteria) {
	this.sortCriteria = sortCriteria;
}

public Student(String name, String gender, int age, String contract) {
	super(name, gender, age);
	this.contract = contract;
}

public Student() {
	super();
	this.contract = "have";
}

public Student(String name) {
	super();
	this.name = name;
}

@Override
public String getContract() {
	return this.contract;
}

@Override
public void setContract(String contract) {
	this.contract = contract;
}

@Override
public String info(){
	return "Name: " + this.getName() + " Gender: " + this.getGender() +" Age: " + this.getAge() 
	+ " Contract: " + this.getContract() ;	
}

@Override
public String toString(){
return info();
}

@Override
public int compareTo(StudentInterface s){
	switch (sortCriteria) {
        case "age":
    	if (this.getAge()>s.getAge()) return 1;
  	    else if(this.getAge()<s.getAge()) return -1;
        break;
        case "gender":
        return this.getGender().compareTo( s.getGender() );
        case "name":
     	return this.getName().compareTo( s.getName() );
        case "contract":
     	return this.getContract().compareTo( s.getContract() );
    }
    return 0;
} 
}
